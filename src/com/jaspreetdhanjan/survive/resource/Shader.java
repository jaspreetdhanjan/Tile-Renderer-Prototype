package com.jaspreetdhanjan.survive.resource;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

import util.*;
import java.nio.FloatBuffer;
import com.jaspreetdhanjan.vecmath.*;

import util.MemoryTracker;

public class Shader extends Resource {
	private static final FloatBuffer tmpBuffer = MemoryTracker.createFloatBuffer(16);

	private final String vertexShaderSource, fragmentShaderSource;

	private int program;
	private int vertexShader, fragmentShader;
	private boolean bound;

	public Shader(String vertexShaderSource, String fragmentShaderSource) {
		super(ResourceType.Shader);
		this.vertexShaderSource = vertexShaderSource;
		this.fragmentShaderSource = fragmentShaderSource;
	}

	public boolean load() {
		program = glCreateProgram();

		vertexShader = loadShader(vertexShaderSource, GL_VERTEX_SHADER);
		fragmentShader = loadShader(fragmentShaderSource, GL_FRAGMENT_SHADER);

		glAttachShader(program, vertexShader);
		glAttachShader(program, fragmentShader);

		glLinkProgram(program);
		if (glGetProgrami(program, GL_LINK_STATUS) == GL_FALSE) {
			ExceptionLogger.log("Shader.loadShader()", new RuntimeException("OpenGL shader link failure! " + glGetProgramInfoLog(program)));
			return false;
		}

		glValidateProgram(program);

		return true;
	}

	private int loadShader(String shaderSource, int type) {
		int shaderID = glCreateShader(type);
		glShaderSource(shaderID, shaderSource);
		glCompileShader(shaderID);

		if (glGetShaderi(shaderID, GL_COMPILE_STATUS) == GL_FALSE) {
			ExceptionLogger.log("Shader.loadShader()", new RuntimeException("OpenGL shader compilation! " + glGetShaderInfoLog(shaderID, 500)));
		}
		return shaderID;
	}

	public void delete() {
		glDetachShader(program, vertexShader);
		glDetachShader(program, fragmentShader);

		glDeleteShader(vertexShader);
		glDeleteShader(fragmentShader);

		glDeleteProgram(program);
	}

	public void bind() {
		bound = true;
		glUseProgram(program);
	}

	public void unbind() {
		bound = false;
		glUseProgram(0);
	}

	public void setUniformf(String name, float... values) {
		int location = getUniformLocation(name);

		if (values.length == 1) {
			glUniform1f(location, values[0]);
		} else if (values.length == 2) {
			glUniform2f(location, values[0], values[1]);
		} else if (values.length == 3) {
			glUniform3f(location, values[0], values[1], values[2]);
		} else if (values.length == 4) {
			glUniform4f(location, values[0], values[1], values[2], values[3]);
		} else {
			ExceptionLogger.log("Shader.setUniformf()", new RuntimeException("Too many parameters!"));
		}
	}

	public void setUniformi(String name, int... values) {
		int location = getUniformLocation(name);

		if (values.length == 1) {
			glUniform1i(location, values[0]);
		} else if (values.length == 2) {
			glUniform2i(location, values[0], values[1]);
		} else if (values.length == 3) {
			glUniform3i(location, values[0], values[1], values[2]);
		} else if (values.length == 4) {
			glUniform4i(location, values[0], values[1], values[2], values[3]);
		} else {
			ExceptionLogger.log("Shader.setUniformi()", new RuntimeException("Too many parameters!"));
		}
	}

	public void setUniformVec3(String name, Vec3 value) {
		int location = getUniformLocation(name);
		glUniform3f(location, value.x, value.y, value.z);
	}

	public void setUniformMat4(String name, Mat4 matrix) {
		matrix.putInto(tmpBuffer);

		int location = getUniformLocation(name);
		glUniformMatrix4fv(location, false, tmpBuffer);
	}

	private int getUniformLocation(String uniformName) {
		int location = glGetUniformLocation(program, uniformName);
		if (location < 0) {
			ExceptionLogger.log("Shader.getUniformLocation()", new RuntimeException("Could not find uniform: " + uniformName));
		}

		return location;
	}

	public boolean isBound() {
		return bound;
	}

	public int getHandle() {
		return program;
	}
}
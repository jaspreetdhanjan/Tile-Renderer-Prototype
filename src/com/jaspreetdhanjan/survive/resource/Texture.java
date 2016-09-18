package com.jaspreetdhanjan.survive.resource;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;

import java.nio.ByteBuffer;

class TextureUniform {
	public int unit;
	public String name;

	public TextureUniform(int unit, String name) {
		this.unit = unit;
		this.name = name;
	}

	public int getActiveTexture() {
		return GL_TEXTURE0 + unit;
	}
}

public class Texture extends Resource {
	public static final int COMPONENTS_PER_PIXEL = 4;
	public static final TextureUniform UNIFORM0 = new TextureUniform(0, "textureSampler");

	private final int width, height;
	private final ByteBuffer data;

	private int textureID;
	private boolean bound;

	public Texture(int width, int height, ByteBuffer data) {
		super(ResourceType.Texture);
		this.width = width;
		this.height = height;
		this.data = data;
	}

	public boolean load() {
		textureID = glGenTextures();

		glBindTexture(GL_TEXTURE_2D, textureID);
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, data);

		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);

		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);

		glBindTexture(GL_TEXTURE_2D, 0);

		return true;
	}

	public void delete() {
		glDeleteTextures(textureID);
	}

	public void bind(TextureUniform tex, Shader shader) {
		bound = true;

		glActiveTexture(tex.getActiveTexture());
		glBindTexture(GL_TEXTURE_2D, textureID);

		shader.setUniformi(tex.name, tex.unit);
	}

	public void unbind() {
		bound = false;
		glBindTexture(GL_TEXTURE_2D, 0);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public ByteBuffer getData() {
		return data;
	}

	public boolean isBound() {
		return bound;
	}

	public int getHandle() {
		return textureID;
	}
}
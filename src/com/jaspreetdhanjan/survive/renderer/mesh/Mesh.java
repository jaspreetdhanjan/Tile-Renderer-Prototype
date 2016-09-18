package com.jaspreetdhanjan.survive.renderer.mesh;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

import java.nio.*;

import com.jaspreetdhanjan.survive.renderer.VertexData;
import com.jaspreetdhanjan.survive.resource.*;

import util.MemoryTracker;

public class Mesh {
	private static final int BYTES_PER_FLOAT = 4;

	private static final int POS_INDEX = 0;
	private static final int COL_INDEX = 1;
	private static final int TEX_INDEX = 2;

	private int vertexCount;

	private int vertexArray;
	private int vertexBuffer;
	private FloatBuffer vertexBufferData;

	private int indexBuffer;
	private IntBuffer indexBufferData;

	private Texture texture;

	public Mesh(VertexData[] vertices, int[] indices, Texture texture) {
		vertexBufferData = MemoryTracker.createFloatBuffer(vertices.length * VertexData.TOTAL_FLOATS);
		indexBufferData = MemoryTracker.createIntBuffer(indices.length);

		for (VertexData data : vertices) {
			data.putInto(vertexBufferData);
		}
		vertexBufferData.flip();
		indexBufferData.put(indices).flip();

		vertexCount = indices.length;
		this.texture = texture;
	}

	public void create() {
		vertexArray = glGenVertexArrays();
		vertexBuffer = glGenBuffers();

		indexBuffer = glGenBuffers();

		glBindVertexArray(vertexArray);
		{
			// Upload vertex buffer and set pointers
			glBindBuffer(GL_ARRAY_BUFFER, vertexBuffer);
			glBufferData(GL_ARRAY_BUFFER, vertexBufferData, GL_STATIC_DRAW);

			final int posSize = VertexData.FLOATS_PER_POS * BYTES_PER_FLOAT;
			final int colSize = VertexData.FLOATS_PER_COL * BYTES_PER_FLOAT;

			int stride = VertexData.TOTAL_FLOATS * BYTES_PER_FLOAT;
			int posOffs = 0;
			int colOffs = posSize;
			int texOffs = posSize + colSize;

			glVertexAttribPointer(POS_INDEX, VertexData.FLOATS_PER_POS, GL_FLOAT, false, stride, posOffs);
			glVertexAttribPointer(COL_INDEX, VertexData.FLOATS_PER_COL, GL_FLOAT, false, stride, colOffs);
			glVertexAttribPointer(TEX_INDEX, VertexData.FLOATS_PER_TEX, GL_FLOAT, false, stride, texOffs);

			glEnableVertexAttribArray(POS_INDEX);
			glEnableVertexAttribArray(COL_INDEX);
			glEnableVertexAttribArray(TEX_INDEX);
			
			// Upload index buffer
			glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, indexBuffer);
			glBufferData(GL_ELEMENT_ARRAY_BUFFER, indexBufferData, GL_STATIC_DRAW);

			glBindBuffer(GL_ARRAY_BUFFER, 0);
		}
		glBindVertexArray(0);
	}

	public void render(Shader shader) {
		texture.bind(Texture.UNIFORM0, shader);

		glBindVertexArray(vertexArray);
		drawElements(vertexCount);
		glBindVertexArray(0);

		texture.unbind();
	}

	protected void drawElements(int vertexCount) {
		glDrawElements(GL_TRIANGLES, vertexCount, GL_UNSIGNED_INT, 0);
	}

	public void delete() {
		vertexBufferData.clear();
		indexBufferData.clear();

		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glDeleteBuffers(vertexBuffer);
		glDeleteBuffers(indexBuffer);

		glBindVertexArray(0);
		glDeleteVertexArrays(vertexArray);
	}
}
package com.jaspreetdhanjan.survive.renderer.mesh;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL31.*;

import com.jaspreetdhanjan.survive.resource.*;
import com.jaspreetdhanjan.survive.renderer.VertexData;

public class InstancedMesh extends Mesh {
	private int instances;

	public InstancedMesh(VertexData[] vertices, int[] indices, Texture texture, int instances) {
		super(vertices, indices, texture);
		this.instances = instances;
	}

	public void drawElements(int vertexCount) {
		glDrawElementsInstanced(GL_TRIANGLES, vertexCount, GL_UNSIGNED_INT, 0, instances);
	}
}
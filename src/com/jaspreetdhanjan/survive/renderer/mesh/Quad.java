package com.jaspreetdhanjan.survive.renderer.mesh;

import com.jaspreetdhanjan.survive.resource.Texture;
import com.jaspreetdhanjan.survive.renderer.VertexData;

public class Quad extends Mesh {
	public static final int[] indexData = new int[] { 0, 1, 3, 3, 1, 2 };

	private static final float u0 = 0f;
	private static final float v0 = 1f;
	private static final float u1 = 1f;
	private static final float v1 = 0f;

	public Quad(VertexData d0, VertexData d1, VertexData d2, VertexData d3, Texture texture) {
		super(new VertexData[] { d0, d1, d2, d3 }, indexData, texture);
	}

	public Quad(float x0, float y0, float x1, float y1, float r, float g, float b, float a, Texture texture) {
		this(new VertexData(x0, y0, r, g, b, a, u0, v0), new VertexData(x1, y0, r, g, b, a, u1, v0), new VertexData(x1, y1, r, g, b, a, u1, v1), new VertexData(x0, y1, r, g, b, a, u0, v1), texture);
	}
}
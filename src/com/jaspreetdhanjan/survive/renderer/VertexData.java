package com.jaspreetdhanjan.survive.renderer;

import java.nio.FloatBuffer;

public class VertexData {
	public static final int FLOATS_PER_POS = 2;
	public static final int FLOATS_PER_COL = 4;
	public static final int FLOATS_PER_TEX = 2;

	public static final int TOTAL_FLOATS = FLOATS_PER_POS + FLOATS_PER_COL + FLOATS_PER_TEX;

	private float x, y;
	private float r, g, b, a;
	private float u, v;

	private float[] tmpData = new float[TOTAL_FLOATS];

	public VertexData(float x, float y, float r, float g, float b, float a, float u, float v) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
		this.u = u;
		this.v = v;

		setData();
	}

	private void setData() {
		int pp = 0;
		tmpData[pp++] = x;
		tmpData[pp++] = y;
		tmpData[pp++] = r;
		tmpData[pp++] = g;
		tmpData[pp++] = b;
		tmpData[pp++] = a;
		tmpData[pp++] = u;
		tmpData[pp++] = v;
	}

	public void putInto(FloatBuffer buffer) {
		buffer.put(tmpData);
	}
}
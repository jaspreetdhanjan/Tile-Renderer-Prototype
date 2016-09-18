package com.jaspreetdhanjan.survive.renderer;

import com.jaspreetdhanjan.survive.renderer.mesh.*;
import com.jaspreetdhanjan.survive.resource.Texture;

public class SpriteSheet {
	public static VertexData[] get(Texture spriteSheet, float x, float y, float width, float height, float r, float g, float b, float a, int xSprite, int ySprite, int spriteWidth, int spriteHeight) {
		float x0 = x;
		float y0 = y;
		float x1 = x0 + width;
		float y1 = y0 + height;

		float u0 = (xSprite * spriteWidth) / (float) spriteSheet.getWidth();
		float v0 = (ySprite * spriteHeight) / (float) spriteSheet.getHeight();
		float u1 = u0 + (spriteWidth / (float) spriteSheet.getWidth());
		float v1 = v0 + (spriteHeight / (float) spriteSheet.getHeight());

		VertexData p0 = new VertexData(x0, y0, r, g, b, a, u0, v1);
		VertexData p1 = new VertexData(x1, y0, r, g, b, a, u1, v1);
		VertexData p2 = new VertexData(x1, y1, r, g, b, a, u1, v0);
		VertexData p3 = new VertexData(x0, y1, r, g, b, a, u0, v0);

		return new VertexData[] { p0, p1, p2, p3 };
	}

	public static Mesh getMesh(Texture spriteSheet, float x, float y, float width, float height, float r, float g, float b, float a, int xSprite, int ySprite, int spriteWidth, int spriteHeight) {
		VertexData[] vertices = get(spriteSheet, x, y, width, height, r, g, b, a, xSprite, ySprite, spriteWidth, spriteHeight);
		return new Mesh(vertices, Quad.indexData, spriteSheet);
	}
}
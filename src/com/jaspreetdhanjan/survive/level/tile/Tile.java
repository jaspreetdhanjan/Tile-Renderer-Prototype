package com.jaspreetdhanjan.survive.level.tile;

import com.jaspreetdhanjan.survive.ResourceLoader;
import com.jaspreetdhanjan.survive.renderer.*;

public abstract class Tile {
	public static final int WIDTH = 64;
	public static final int HEIGHT = 64;

	public int x, y;

	public int xSpriteIndex = 0;
	public int ySpriteIndex = 0;
	public int spriteWidth = 16;
	public int spriteHeight = 16;

	public VertexData[] getVertices() {
		return SpriteSheet.get(ResourceLoader.spriteSheetTexture, x, y, WIDTH, HEIGHT, 1f, 1f, 1f, 1f, xSpriteIndex, ySpriteIndex, spriteWidth, spriteHeight);
	}
}
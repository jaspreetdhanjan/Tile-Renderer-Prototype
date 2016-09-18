package com.jaspreetdhanjan.survive.level;

import com.jaspreetdhanjan.survive.renderer.Scene;

import java.util.*;

import com.jaspreetdhanjan.survive.ResourceLoader;
import com.jaspreetdhanjan.survive.level.tile.*;
import com.jaspreetdhanjan.survive.renderer.mesh.*;
import com.jaspreetdhanjan.survive.resource.Shader;

public class Level implements Scene {
	private final int width, height;
	private final Tile[] tiles;

	private List<Mesh> meshes = new ArrayList<Mesh>();

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new Tile[width * height];
	}

	public void init() {
		Shader shader = getShader();
		shader.bind();
		shader.setUniformi("mapWidth", width);
		shader.setUniformi("mapHeight", height);
		shader.setUniformi("tileWidth", Tile.WIDTH);
		shader.setUniformi("tileHeight", Tile.HEIGHT);
		shader.unbind();

		meshes.add(new InstancedMesh(new GrassTile().getVertices(), Quad.indexData, ResourceLoader.spriteSheetTexture, tiles.length));
		meshes.forEach(mesh -> mesh.create());
	}

	public void delete() {
		meshes.forEach(mesh -> mesh.delete());
		meshes.clear();
	}

	public Shader getShader() {
		return ResourceLoader.terrainShader;
	}

	public List<Mesh> getMeshes() {
		return meshes;
	}
}
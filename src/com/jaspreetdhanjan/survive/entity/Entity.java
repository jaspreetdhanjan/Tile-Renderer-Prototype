package com.jaspreetdhanjan.survive.entity;

import com.jaspreetdhanjan.survive.renderer.mesh.Mesh;
import com.jaspreetdhanjan.vecmath.*;

public class Entity {
	private Mesh mesh;

	private Mat4 translation = new Mat4();

	public Entity(Mesh mesh, Vec2 pos) {
		this.mesh = mesh;
		translation.translate(pos.x, pos.y, 0);
	}

	public Mesh getMesh() {
		return mesh;
	}

	public Mat4 getTranslation() {
		return translation;
	}
}
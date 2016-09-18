package com.jaspreetdhanjan.survive.renderer;

import java.util.List;

import com.jaspreetdhanjan.survive.renderer.mesh.Mesh;
import com.jaspreetdhanjan.survive.resource.Shader;

public interface Scene {
	public Shader getShader();

	public List<Mesh> getMeshes();
}
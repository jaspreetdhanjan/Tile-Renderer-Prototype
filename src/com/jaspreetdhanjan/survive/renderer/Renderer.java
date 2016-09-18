package com.jaspreetdhanjan.survive.renderer;

import com.jaspreetdhanjan.survive.renderer.mesh.*;
import com.jaspreetdhanjan.survive.resource.*;
import com.jaspreetdhanjan.vecmath.Mat4;

public class Renderer {
	private TextRenderer textRenderer = new TextRenderer();
	private Shader shader;

	public void init() {
		textRenderer.init();
	}

	public void draw(Scene scene, Mat4 modelViewMatrix, Mat4 projectionMatrix) {
		setShader(scene.getShader());
		prepareDraw(projectionMatrix);

		for (Mesh mesh : scene.getMeshes()) {
			drawPerMesh(mesh, modelViewMatrix);
		}

		endDraw();
	}

	private void setShader(Shader shader) {
		if (this.shader == shader) return;
		this.shader = shader;
	}

	private void prepareDraw(Mat4 projectionMatrix) {
		shader.bind();
		shader.setUniformMat4("projectionMatrix", projectionMatrix);
	}

	private void drawPerMesh(Mesh mesh, Mat4 modelViewMatrix) {
		shader.setUniformMat4("modelViewMatrix", modelViewMatrix);
		mesh.render(shader);
	}

	private void endDraw() {
		shader.unbind();
	}
}
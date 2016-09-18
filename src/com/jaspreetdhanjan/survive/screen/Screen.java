package com.jaspreetdhanjan.survive.screen;

import com.jaspreetdhanjan.survive.Display;
import com.jaspreetdhanjan.survive.renderer.Renderer;
import com.jaspreetdhanjan.vecmath.Mat4;

public class Screen {
	protected Mat4 projectionMatrix = new Mat4();
	protected Mat4 viewMatrix = new Mat4();
	protected Mat4 modelMatrix = new Mat4();

	protected Renderer renderer;

	public final void init(Renderer renderer) {
		this.renderer = renderer;
		init();
	}

	protected void init() {
	}

	public void tick(double delta) {
	}

	public final void render() {
		projectionMatrix.createOrthographicMatrix(0, Display.getFramebufferWidth(), 0, Display.getFramebufferHeight(), -1f, 1f);
		renderScene();
	}

	protected void renderScene() {
	}

	public void onClose() {
	}
}
package com.jaspreetdhanjan.survive.screen;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.glfw.GLFW.*;

import com.jaspreetdhanjan.survive.*;
import com.jaspreetdhanjan.survive.level.Level;
import com.jaspreetdhanjan.vecmath.Mat4;

public class GameScreen extends Screen {
	private Level level = new Level(64, 64);
	private float moveSpeed = 8;
	private float xOffset, yOffset;

	protected void init() {
		level.init();
	}

	public void tick(double delta) {
		boolean u = Keyboard.isKeyDown(GLFW_KEY_UP) || Keyboard.isKeyDown(GLFW_KEY_W);
		boolean d = Keyboard.isKeyDown(GLFW_KEY_DOWN) || Keyboard.isKeyDown(GLFW_KEY_S);
		boolean l = Keyboard.isKeyDown(GLFW_KEY_LEFT) || Keyboard.isKeyDown(GLFW_KEY_A);
		boolean r = Keyboard.isKeyDown(GLFW_KEY_RIGHT) || Keyboard.isKeyDown(GLFW_KEY_D);
		moveTick(u, d, l, r);
	}

	private void moveTick(boolean up, boolean down, boolean left, boolean right) {
		if (up) yOffset -= moveSpeed;
		if (down) yOffset += moveSpeed;
		if (left) xOffset += moveSpeed;
		if (right) xOffset -= moveSpeed;
	}

	protected void renderScene() {
		glColorMask(true, true, true, true);

		viewMatrix.identity().translate(xOffset, yOffset, 0);
		Mat4 modelViewMatrix = viewMatrix.clone().mul(modelMatrix);

		renderer.draw(level, modelViewMatrix, projectionMatrix);
	}

	public void onClose() {
		level.delete();
	}
}
package com.jaspreetdhanjan.survive;

import static org.lwjgl.glfw.GLFW.*;

public class Keyboard {
	private static boolean[] keysPressed = new boolean[512];

	public static void keyInvoked(int keyCode, int action) {
		boolean keyStatus = action != GLFW_RELEASE;
		keysPressed[keyCode] = keyStatus;
	}

	public static boolean isKeyDown(int keyCode) {
		return keysPressed[keyCode];
	}
}
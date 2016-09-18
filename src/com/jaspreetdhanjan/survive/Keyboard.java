package com.jaspreetdhanjan.survive;

import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

public class Keyboard {
	private static boolean[] keys = new boolean[512];

	public static void keyInvoked(int keyCode, int action) {
		keys[keyCode] = action != GLFW_RELEASE;
	}

	public static boolean isKeyDown(int keyCode) {
		return keys[keyCode];
	}
}
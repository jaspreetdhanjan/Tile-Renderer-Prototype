package com.jaspreetdhanjan.survive;

import static org.lwjgl.glfw.GLFW.*;

public class Mouse {
	private static double xMouse, yMouse;
	private static double dxMouse, dyMouse;
	private static boolean focused, mouseInScreen;

	private static boolean[] buttons = new boolean[16];

	public static void onMouseClick(int mouseButton, int action) {
		buttons[mouseButton] = action != GLFW_RELEASE;
	}

	public static boolean getMouseStatus(int mouseButton) {
		return buttons[mouseButton];
	}

	public static void setMouseX(double xMouse) {
		Mouse.xMouse = xMouse;
	}

	public static double getMouseX() {
		return xMouse;
	}

	public static void setMouseY(double yMouse) {
		Mouse.yMouse = yMouse;
	}

	public static double getMouseY() {
		return yMouse;
	}

	public static void setMouseDX(double dxMouse) {
		Mouse.dxMouse = dxMouse;
	}

	public static double getMouseDX() {
		return dxMouse;
	}

	public static void setMouseDY(double dyMouse) {
		Mouse.dyMouse = dyMouse;
	}

	public static double getMouseDY() {
		return dyMouse;
	}

	public static void setFocus(boolean focused) {
		Mouse.focused = focused;
	}

	public static boolean getFocus() {
		return focused;
	}

	public static void setMouseInScreen(boolean mouseInScreen) {
		Mouse.mouseInScreen = mouseInScreen;
	}

	public static boolean isMouseInScreen() {
		return mouseInScreen;
	}
}
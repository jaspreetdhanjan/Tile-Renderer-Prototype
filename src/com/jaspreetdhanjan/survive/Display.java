package com.jaspreetdhanjan.survive;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

import org.lwjgl.glfw.*;

import util.*;

public class Display {
	private static final int OPENGL_VERSION_MAJOR = 3;
	private static final int OPENGL_VERSION_MINOR = 2;

	private static long window;
	private static boolean created;

	private static int x, y;
	private static int screenW, screenH;
	private static int framebufferW, framebufferH;
	private static String title;

	private static GLFWErrorCallback errorCallback;
	private static GLFWKeyCallback keyCallback;
	private static GLFWCursorPosCallback cursorPosCallback;
	private static GLFWCursorEnterCallback cursorEnterCallback;
	private static GLFWMouseButtonCallback mouseButtonCallback;
	private static GLFWWindowFocusCallback focusCallback;
	private static GLFWWindowSizeCallback resizeCallback;
	private static GLFWFramebufferSizeCallback frameBufferCallback;

	public static void setLocation(int x, int y) {
		Display.x = x;
		Display.y = y;
		if (created) glfwSetWindowPos(window, x, y);
	}

	public static void setDimension(int screenW, int screenH) {
		if (screenW < 512) screenW = 512;
		if (screenH < 512) screenH = 512;

		Display.screenW = screenW;
		Display.screenH = screenH;
		if (created) glfwSetWindowSize(window, screenW, screenH);
	}

	public static int getScreenWidth() {
		return screenW;
	}

	public static int getScreenHeight() {
		return screenH;
	}

	public static void setTitle(String title) {
		Display.title = title;
	}

	public static String getTitle() {
		return title;
	}

	public static void create() {
		if (created) return;

		glfwDefaultWindowHints();

		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, OPENGL_VERSION_MAJOR);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, OPENGL_VERSION_MINOR);
		glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
		glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);

		glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);

		window = glfwCreateWindow(screenW, screenH, title, NULL, NULL);
		if (window == NULL) {
			ExceptionLogger.log("Display.create()", new RuntimeException("Window creation failure"));
		}

		errorCallback = GLFWErrorCallback.createPrint(System.err).set();
		glfwSetErrorCallback(errorCallback);

		glfwSetKeyCallback(window, keyCallback = new GLFWKeyCallback() {
			public void invoke(long window, int key, int scancode, int action, int mods) {
				Keyboard.keyInvoked(key, action);
			}
		});

		glfwSetCursorPosCallback(window, cursorPosCallback = new GLFWCursorPosCallback() {
			public void invoke(long window, double xMouse, double yMouse) {
				double oldMouseX = xMouse;
				double oldMouseY = yMouse;
				Mouse.setMouseX(xMouse);
				Mouse.setMouseY(yMouse);

				if (Mouse.isMouseInScreen()) {
					float ar = Display.screenW / Display.screenH;
					Mouse.setMouseDX((xMouse - oldMouseX) / ar);
					Mouse.setMouseDY((yMouse - oldMouseY) / ar);
				}
			}
		});

		glfwSetCursorEnterCallback(window, cursorEnterCallback = new GLFWCursorEnterCallback() {
			public void invoke(long window, boolean entered) {
				Mouse.setMouseInScreen(entered);
			}

			public void callback(long window) {
			}

			public void close() {
			}
		});

		glfwSetMouseButtonCallback(window, mouseButtonCallback = new GLFWMouseButtonCallback() {
			public void invoke(long window, int button, int action, int mods) {
				Mouse.onMouseClick(button, action);
			}
		});

		glfwSetWindowFocusCallback(window, focusCallback = new GLFWWindowFocusCallback() {
			public void invoke(long window, boolean focused) {
				Mouse.setFocus(focused);
			}

			public void callback(long window) {
			}

			public void close() {
			}
		});

		glfwSetWindowSizeCallback(window, resizeCallback = new GLFWWindowSizeCallback() {
			public void invoke(long window, int w, int h) {
				setDimension(w, h);
			}
		});

		glfwSetFramebufferSizeCallback(window, frameBufferCallback = new GLFWFramebufferSizeCallback() {
			public void invoke(long window, int framebufferW, int framebufferH) {
				setFramebufferSize(framebufferW, framebufferH);
			}
		});

		glfwSetWindowPos(window, x, y);

		glfwMakeContextCurrent(window);
		glfwSwapInterval(1);
		glfwShowWindow(window);

		int[] tmpWidth = new int[1];
		int[] tmpHeight = new int[1];
		glfwGetFramebufferSize(window, tmpWidth, tmpHeight);
		setFramebufferSize(tmpWidth[0], tmpHeight[0]);

		created = true;
	}

	private static void setFramebufferSize(int framebufferW, int framebufferH) {
		Display.framebufferW = framebufferW;
		Display.framebufferH = framebufferH;
	}

	public static int getFramebufferWidth() {
		return framebufferW;
	}

	public static int getFramebufferHeight() {
		return framebufferH;
	}

	public static void destroy() {
		if (!created) return;
		created = false;

		keyCallback.free();
		cursorPosCallback.free();
		cursorEnterCallback.free();
		mouseButtonCallback.free();
		focusCallback.free();
		resizeCallback.free();
		frameBufferCallback.free();

		glfwDestroyWindow(window);
		glfwTerminate();
	}

	public static boolean shouldClose() {
		return glfwWindowShouldClose(window);
	}

	public static void update() {
		glfwSwapBuffers(window);
	}
}
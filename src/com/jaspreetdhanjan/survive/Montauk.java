package com.jaspreetdhanjan.survive;

import util.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GL;

import com.jaspreetdhanjan.survive.renderer.Renderer;
import com.jaspreetdhanjan.survive.screen.*;

public class Montauk implements Runnable {
	private static final String TITLE = "Level Renderer Test";

	private boolean stop = false;
	private long lastTime, timer;

	private Screen screen;
	private Renderer renderer = new Renderer();

	private void setScreen(Screen screen) {
		this.screen = screen;
		screen.init(renderer);
	}

	public void run() {
		init();

		double delta = 0;
		int frames = 0;
		int ticks = 0;
		timer = System.currentTimeMillis();

		final double ns = 1000000000.0 / 60.0;

		while (!stop) {
			long nowTime = System.nanoTime();
			delta += (nowTime - lastTime) / ns;
			lastTime = nowTime;

			boolean render = true;
			if (delta >= 1.0) {
				tick(delta);
				ticks++;
				delta--;
				render = true;
			}

			if (render) {
				render();
				frames++;
			}

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(ticks + " ticks, " + frames + " fps");
				ticks = 0;
				frames = 0;
			}
		}

		onDestroy();
	}

	private void init() {
		if (!glfwInit()) {
			ExceptionLogger.log("Montauk.init()", new RuntimeException("GLFW init problem!"));
			return;
		}

		GLFWVidMode mode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		int monitorWidth = mode.width();
		int monitorHeight = mode.height();
		int x = monitorWidth / 10;
		int y = monitorHeight / 10;
		int screenW = monitorWidth * 8 / 10;
		int screenH = monitorHeight * 8 / 10;

		Display.setLocation(x, y);
		Display.setDimension(screenW, screenH);
		Display.setTitle(TITLE);
		Display.create();

		GL.createCapabilities();

		System.out.println(System.getProperty("os.name") + " with " + glGetString(GL_RENDERER));
		System.out.println("Supported OpenGL version: " + glGetString(GL_VERSION));
		System.out.println("Supported GLSL version: " + glGetString(GL_SHADING_LANGUAGE_VERSION) + "\n");

		ResourceLoader.loadAll(true);
		renderer.init();

		glEnable(GL_DEPTH_TEST);
		glDepthFunc(GL_LEQUAL);
		glEnable(GL_CULL_FACE);
		glCullFace(GL_BACK);

		setScreen(new GameScreen());
	}

	private void tick(double delta) {
		if (Display.shouldClose()) {
			stop();
			return;
		}

		glfwPollEvents();
		screen.tick(delta);
	}

	private void render() {
		glViewport(0, 0, Display.getFramebufferWidth(), Display.getFramebufferHeight());

		float r = 0.0f;
		float g = 0.0f;
		float b = 0.0f;
		float a = 1.0f;

		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glClearColor(r, g, b, a);

		screen.render();

		int error = glGetError();
		if (error != GL_NO_ERROR) {
			ExceptionLogger.log("Montauk.render()", new RuntimeException("OpenGL error! Error code: " + error));
		}

		Display.update();
	}

	private void onDestroy() {
		screen.onClose();
		ResourceLoader.deleteAll();
		Display.destroy();
	}

	public void stop() {
		stop = true;
	}

	public static void main(String[] args) {
		// System.setProperty("java.awt.headless", "true");
		for (int i = 0; i < args.length; i++) {
			System.out.println("Arg: " + args[i]);
		}
		new Thread(new Montauk()).run();
	}
}
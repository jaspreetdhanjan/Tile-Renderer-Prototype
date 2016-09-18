package com.jaspreetdhanjan.survive;

import static org.lwjgl.stb.STBImage.*;

import java.io.*;
import java.nio.*;
import java.util.*;

import com.jaspreetdhanjan.survive.resource.*;

import util.ExceptionLogger;
import util.MemoryTracker;

public class ResourceLoader {
	private static final Set<Resource> resources = new HashSet<Resource>();

	public static Shader basicShader = loadShader("basicShader");
	public static Shader terrainShader = loadShader("terrainShader");
	public static Texture spriteSheetTexture = loadTexture("spritesheet");

	private static Texture loadTexture(String path) {
		IntBuffer w = MemoryTracker.createIntBuffer(1);
		IntBuffer h = MemoryTracker.createIntBuffer(1);
		IntBuffer comp = MemoryTracker.createIntBuffer(1);

		String filename = "res/textures/" + path + ".png";
		ByteBuffer loadedImage = stbi_load(filename, w, h, comp, Texture.COMPONENTS_PER_PIXEL);
		if (loadedImage == null) {
			ExceptionLogger.log("ResourceManager.loadTexture()", new RuntimeException("Failed to load texture! Reason: " + stbi_failure_reason()));
		}
		return new Texture(w.get(0), h.get(0), loadedImage);
	}

	private static Shader loadShader(String filename) {
		try {
			String[] sources = new String[2];
			String[] ext = { ".vs", ".fs" };

			for (int i = 0; i < sources.length; i++) {
				String src = "";
				String name = "/shaders/" + filename + ext[i];

				BufferedReader reader = new BufferedReader(new InputStreamReader(ResourceLoader.class.getResourceAsStream(name)));
				String line;
				while ((line = reader.readLine()) != null) {
					src += line + "\n";
				}
				reader.close();

				sources[i] = src;
			}
			return new Shader(sources[0], sources[1]);
		} catch (IOException e) {
			ExceptionLogger.log("ResourceManager.loadShader()", e);
		}

		return null;
	}

	public static void add(Resource resource) {
		resources.add(resource);
	}

	public static void loadAll(boolean verbose) {
		for (Resource resource : resources) {
			if (!resource.load()) {
				System.out.println("Failed to load " + resource);
				continue;
			}
		}
	}

	public static void deleteAll() {
		resources.forEach(resource -> resource.delete());
		resources.clear();
	}
}
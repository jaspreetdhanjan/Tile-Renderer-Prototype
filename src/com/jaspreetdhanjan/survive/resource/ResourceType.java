package com.jaspreetdhanjan.survive.resource;

public enum ResourceType {
	Shader("Shader"), Texture("Texture");

	private final String type;

	private ResourceType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
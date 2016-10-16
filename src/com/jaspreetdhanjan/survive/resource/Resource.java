package com.jaspreetdhanjan.survive.resource;

import com.jaspreetdhanjan.survive.ResourceLoader;

public abstract class Resource {
	private final ResourceType type;

	public Resource(ResourceType type) {
		this.type = type;
		ResourceLoader.add(this);
	}

	public abstract boolean load();

	public abstract void delete();

	public abstract boolean isBound();

	public abstract int getHandle();

	public final ResourceType getType() {
		return type;
	}
}
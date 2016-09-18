#version 330 core

layout(location = 0) in vec2 position;
layout(location = 1) in vec4 colour;
layout(location = 2) in vec2 texCoord;

out vec4 passColour;
out vec2 passTexCoord;

uniform mat4 modelViewMatrix;
uniform mat4 projectionMatrix;

void main() {
	gl_Position = projectionMatrix*modelViewMatrix*vec4(position, 0.0, 1.0);
	passColour = colour;
	passTexCoord = texCoord;
}
#version 330 core

in vec4 passColour;
in vec2 passTexCoord;

out vec4 fragColour;

uniform sampler2D textureSampler;

void main() {
	fragColour = passColour * texture(textureSampler, passTexCoord);
}

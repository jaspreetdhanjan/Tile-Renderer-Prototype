package com.jaspreetdhanjan.vecmath;

/**
 * A 2-element vector that is represented by 2 single-precision floating numbers.
 *
 * @author Jaspreet Dhanjan
 */

public class Vec2 {
	public float x;
	public float y;

	// Constructors and setters

	/**
	 * Constructs and initialises a Vec2 with value: 0, 0.
	 */
	public Vec2() {
		this(0, 0);
	}

	/**
	 * Constructs and initialises a Vec2 with value: a, a.
	 * 
	 * @param a
	 *            the x and y coordinate.
	 */
	public Vec2(float a) {
		this(a, a);
	}

	/**
	 * Constructs and initialises a Vec2 from the specified x, y coordinates.
	 * 
	 * @param x
	 *            the x coordinate.
	 * @param y
	 *            the y coordinate.
	 */
	public Vec2(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Constructs and initialises a Vec2 from the attributes of vector r.
	 * 
	 * @param r
	 *            the vector to copy.
	 */
	public Vec2(Vec2 r) {
		this.x = r.x;
		this.y = r.y;
	}

	/**
	 * Sets the x, y attributes to the value r.
	 * 
	 * @param r
	 *            the value to set.
	 * 
	 * @return the result.
	 */
	public Vec2 set(float r) {
		x = r;
		y = r;
		return this;
	}

	/**
	 * Sets the x, y attributes to the values in the parameters.
	 * 
	 * @param x
	 *            the x coordinate.
	 * @param y
	 *            the y coordinate.
	 * 
	 * @return the result.
	 */
	public Vec2 set(float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}

	/**
	 * Sets the x, y attributes to the values of vector r.
	 * 
	 * @param r
	 *            the vector to copy.
	 * 
	 * @return the result.
	 */
	public Vec2 set(Vec2 r) {
		this.x = r.x;
		this.y = r.y;
		return this;
	}

	// Addition methods

	/**
	 * Adds the the value r to the x, y coordinates.
	 * 
	 * @param r
	 *            value to add.
	 *
	 * @return the result.
	 */
	public Vec2 add(float r) {
		x += r;
		y += r;
		return this;
	}

	/**
	 * Adds the the value xx, yy to the x, y coordinates, respectively.
	 * 
	 * @param xx
	 *            value that is added to x.
	 * @param yy
	 *            value that is added to y.
	 *
	 * @return the result.
	 */
	public Vec2 add(float xx, float yy) {
		x += xx;
		y += yy;
		return this;
	}

	/**
	 * Adds the the value x, y attributes of vector r to the x, y coordinates of this, respectively.
	 * 
	 * @param r
	 *            the vector added.
	 *
	 * @return the result.
	 */
	public Vec2 add(Vec2 r) {
		x += r.x;
		y += r.y;
		return this;
	}

	// Subtraction methods

	/**
	 * Subtracts the the value r from the x, y coordinates.
	 * 
	 * @param r
	 *            value to subtract.
	 *
	 * @return the result.
	 */
	public Vec2 sub(float r) {
		x -= r;
		y -= r;
		return this;
	}

	/**
	 * Subtracts the the value xx, yy from the x, y coordinates, respectively.
	 * 
	 * @param xx
	 *            value that is subtracted to x.
	 * @param yy
	 *            value that is subtracted to y.
	 *
	 * @return the result.
	 */
	public Vec2 sub(float xx, float yy) {
		x -= xx;
		y -= yy;
		return this;
	}

	/**
	 * Subtracts the the value x, y attributes of vector r from the x, y coordinates of this, respectively.
	 * 
	 * @param r
	 *            the vector subtracted
	 *
	 * @return the result.
	 */
	public Vec2 sub(Vec2 r) {
		x -= r.x;
		y -= r.y;
		return this;
	}

	// Multiplication methods

	/**
	 * Multiplies the the value r to the x, y coordinates.
	 * 
	 * @param r
	 *            value to multiply
	 *
	 * @return the result.
	 */
	public Vec2 mul(float r) {
		x *= r;
		y *= r;
		return this;
	}

	/**
	 * Multiplies values xx, yy to the x, y coordinates, respectively.
	 * 
	 * @param xx
	 *            the value that is multiplied to x.
	 * @param yy
	 *            the value that is multiplied to y.
	 *
	 * @return the result.
	 */
	public Vec2 mul(float xx, float yy) {
		x *= xx;
		y *= yy;
		return this;
	}

	/**
	 * Multiplies the x, y values of r to the x, y coordinates, respectively.
	 * 
	 * @param r
	 *            value to multiply.
	 *
	 * @return the result.
	 */
	public Vec2 mul(Vec2 r) {
		x *= r.x;
		y *= r.y;
		return this;
	}

	// Division methods

	/**
	 * Divides the the value r from the x, y coordinates.
	 * 
	 * @param r
	 *            value to divide.
	 *
	 * @return the result.
	 */
	public Vec2 div(float r) {
		x /= r;
		y /= r;
		return this;
	}

	/**
	 * Divides values xx, yy from the x, y coordinates, respectively.
	 * 
	 * @param xx
	 *            the value that is divided to x.
	 * @param yy
	 *            the value that is divided to y.
	 *
	 * @return the result.
	 */
	public Vec2 div(float xx, float yy) {
		x /= xx;
		y /= yy;
		return this;
	}

	/**
	 * Divides the x, y values by the x, y coordinates of r, respectively.
	 * 
	 * @param r
	 *            value to divide.
	 *
	 * @return the result.
	 */
	public Vec2 div(Vec2 r) {
		x /= r.x;
		y /= r.y;
		return this;
	}

	// Other methods

	/**
	 * Normalises this vector to return the directional component.
	 * 
	 * @return if the magnitude of the vector is 0, an empty vector is returned. The actual result is returned otherwise.
	 */
	public Vec2 normalise() {
		float len = length();
		if (len > 0) return div(len);
		return set(0, 0);
	}

	/**
	 * Gets the dot product from this and vector r.
	 * 
	 * @param r
	 *            the other vector.
	 * 
	 * @return the result (V = V·R).
	 */
	public float dot(Vec2 r) {
		return x * r.x + y * r.y;
	}

	/**
	 * Gets the midpoint between this and vector r.
	 * 
	 * @param r
	 *            the other vector.
	 * 
	 * @return the result.
	 */
	public Vec2 mid(Vec2 r) {
		float xx = (x + r.x) / 2f;
		float yy = (y + r.y) / 2f;
		return set(xx, yy);
	}

	/**
	 * Gets the magnitude of this vector.
	 * 
	 * @return the result.
	 */
	public float length() {
		return (float) Math.sqrt(x * x + y * y);
	}

	/**
	 * Gets the distance from the vector to vector r using Pythagoras' Theorem.
	 * 
	 * @param r
	 *            the other vector.
	 * 
	 * @return the result.
	 */
	public float distanceTo(Vec2 r) {
		float xd = r.x - x;
		float yd = r.y - y;
		return (float) Math.sqrt(xd * xd + yd * yd);
	}

	/**
	 * Gets the squared distance from the vector to vector r.
	 * 
	 * @param r
	 *            the other vector.
	 * 
	 * @return the result.
	 */
	public float distanceToSqrt(Vec2 r) {
		float xd = r.x - x;
		float yd = r.y - y;
		return xd * xd + yd * yd;
	}

	/**
	 * Rotates this vector by a given value.
	 * 
	 * @param angle
	 *            the amount, in radians, to rotate.
	 * 
	 * @return the result.
	 */
	public Vec2 rot(float angle) {
		float cos = (float) Math.cos(angle);
		float sin = (float) Math.sin(angle);
		return new Vec2(cos * x, sin * y);
	}

	/**
	 * Gives the scalar value of the cross product of this vector and other vector s.
	 * 
	 * @param s
	 *            the other vector.
	 * 
	 * @return the result.
	 */
	public float cross(Vec2 s) {
		return x * s.y - y * s.x;
	}

	/**
	 * Linearly interpolates between this vector and other vector p.
	 * 
	 * @param p
	 *            direction of the interpolation.
	 * @param t
	 *            step size.
	 * 
	 * @return the result.
	 */
	public Vec2 lerpTo(Vec2 p, float t) {
		float xx = x + (p.x - x) * t;
		float yy = y + (p.y - y) * t;
		return set(xx, yy);
	}

	/**
	 * Adds the value of v to this vector with multiple s.
	 * 
	 * T = T + (V * S)
	 * 
	 * @param v
	 *            the direction of the adder.
	 * @param s
	 *            the multiple of the adder.
	 * 
	 * @return the result.
	 */
	public Vec2 mulAdd(Vec2 v, float s) {
		x += v.x * s;
		y += v.y * s;
		return this;
	}

	/**
	 * Gets the angle between this and vector v using the inverse-cosine method.
	 * 
	 * @param v
	 *            the other vector.
	 * 
	 * @return returns a floating point value of the angle in radians. If the vectors are parallel then the method will return 0.
	 */
	public float angle(Vec2 v) {
		float d = dot(v);
		float len = length() * v.length();
		if (len > 0) return (float) Math.acos(d / len);
		return 0;
	}

	/**
	 * Gets the absolute value of this vector.
	 * 
	 * @return the result.
	 */
	public Vec2 abs() {
		return set(Math.abs(x), Math.abs(y));
	}

	/**
	 * Gets the reciprocal value of this vector.
	 * 
	 * @return the result.
	 */
	public Vec2 reciprocal() {
		return set(1f / x, 1f / y);
	}

	// java.lang.Object overrides

	public Vec2 clone() {
		return new Vec2(x, y);
	}

	public String toString() {
		return "Vec2(" + x + ", " + y + ")";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(y);
		return result;
	}

	public boolean equals(Object o) {
		if (o instanceof Vec2) {
			Vec2 r = (Vec2) o;
			if (x == r.x && y == r.y) return true;
		}
		return false;
	}
}
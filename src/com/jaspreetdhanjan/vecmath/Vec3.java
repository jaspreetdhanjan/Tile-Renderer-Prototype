package com.jaspreetdhanjan.vecmath;

/**
 * A 3-element vector that is represented by 3 single-precision floating numbers.
 *
 * @author Jaspreet Dhanjan
 */

public class Vec3 {
	public static final Vec3 X = new Vec3(1f, 0f, 0f);
	public static final Vec3 Y = new Vec3(0f, 1f, 0f);
	public static final Vec3 Z = new Vec3(0f, 0f, 1f);

	public float x;
	public float y;
	public float z;

	// Constructors and setters

	/**
	 * Constructs and initialises a Vec3 with value: (0, 0, 0).
	 */
	public Vec3() {
		this(0, 0, 0);
	}

	/**
	 * Constructs and initialises a Vec3 with value: (a, a, a).
	 * 
	 * @param a
	 *            the x, y and z coordinate.
	 */
	public Vec3(float a) {
		this(a, a, a);
	}

	/**
	 * Constructs and initialises a Vec3 from the specified x, y, z coordinates.
	 * 
	 * @param x
	 *            the x coordinate.
	 * @param y
	 *            the y coordinate.
	 * @param z
	 *            the z coordinate.
	 */
	public Vec3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Constructs and initialises a Vec3 from x, y, z attributes of vector r.
	 * 
	 * @param r
	 *            the vector to copy.
	 */
	public Vec3(Vec3 r) {
		this.x = r.x;
		this.y = r.y;
		this.z = r.z;
	}

	/**
	 * Sets the x, y, z attributes to the value r.
	 * 
	 * @param r
	 *            the value to set.
	 * 
	 * @return the result.
	 */
	public Vec3 set(float r) {
		x = r;
		y = r;
		z = r;
		return this;
	}

	/**
	 * Sets the x, y, z attributes to the values in the parameters.
	 * 
	 * @param x
	 *            the x coordinate.
	 * @param y
	 *            the y coordinate.
	 * @param z
	 *            the z coordinate.
	 * 
	 * @return the result.
	 */
	public Vec3 set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}

	/**
	 * Sets the x, y, z attributes to the values of vector r.
	 * 
	 * @param r
	 *            the vector to copy.
	 * 
	 * @return the result.
	 */
	public Vec3 set(Vec3 r) {
		this.x = r.x;
		this.y = r.y;
		this.z = r.z;
		return this;
	}

	// Addition methods

	/**
	 * Adds the the value r to the x, y, z coordinates.
	 * 
	 * @param r
	 *            value to add.
	 *
	 * @return the result.
	 */
	public Vec3 add(float r) {
		x += r;
		y += r;
		z += r;
		return this;
	}

	/**
	 * Adds the the value xx, yy, zz to the x, y, z coordinates, respectively.
	 * 
	 * @param xx
	 *            value that is added to x.
	 * @param yy
	 *            value that is added to y.
	 * @param zz
	 *            value that is added to z.
	 *
	 * @return the result.
	 */
	public Vec3 add(float xx, float yy, float zz) {
		x += xx;
		y += yy;
		z += zz;
		return this;
	}

	/**
	 * Adds the the value x, y, z attributes of vector r to the x, y, z coordinates of this, respectively.
	 * 
	 * @param r
	 *            the vector added.
	 *
	 * @return the result.
	 */
	public Vec3 add(Vec3 r) {
		x += r.x;
		y += r.y;
		z += r.z;
		return this;
	}

	// Subtraction methods

	/**
	 * Subtracts the the value r from the x, y, z coordinates.
	 * 
	 * @param r
	 *            value to subtract.
	 *
	 * @return the result.
	 */
	public Vec3 sub(float r) {
		x -= r;
		y -= r;
		z -= r;
		return this;
	}

	/**
	 * Subtracts the the value xx, yy, zz from the x, y, z coordinates, respectively.
	 * 
	 * @param xx
	 *            value that is subtracted to x.
	 * @param yy
	 *            value that is subtracted to y.
	 * @param zz
	 *            value that is subtracted to z.
	 *
	 * @return the result.
	 */
	public Vec3 sub(float xx, float yy, float zz) {
		x -= xx;
		y -= yy;
		z -= zz;
		return this;
	}

	/**
	 * Subtracts the the value x, y, z attributes of vector r from the x, y, z coordinates of this, respectively.
	 * 
	 * @param r
	 *            the vector subtracted
	 *
	 * @return the result.
	 */
	public Vec3 sub(Vec3 r) {
		x -= r.x;
		y -= r.y;
		z -= r.z;
		return this;
	}

	// Multiplication methods

	/**
	 * Multiplies the the value r to the x, y, z coordinates.
	 * 
	 * @param r
	 *            value to multiply
	 *
	 * @return the result.
	 */
	public Vec3 mul(float r) {
		x *= r;
		y *= r;
		z *= r;
		return this;
	}

	/**
	 * Multiplies values xx, yy, zz to the x, y, z coordinates, respectively.
	 * 
	 * @param xx
	 *            the value that is multiplied to x.
	 * @param yy
	 *            the value that is multiplied to y.
	 * @param zz
	 *            the value that is multiplied to z.
	 *
	 * @return the result.
	 */
	public Vec3 mul(float xx, float yy, float zz) {
		x *= xx;
		y *= yy;
		z *= zz;
		return this;
	}

	/**
	 * Multiplies the x, y, z values of r to the x, y, z coordinates, respectively.
	 * 
	 * @param r
	 *            value to multiply.
	 *
	 * @return the result.
	 */
	public Vec3 mul(Vec3 r) {
		x *= r.x;
		y *= r.y;
		z *= r.z;
		return this;
	}

	// Division methods

	/**
	 * Divides the the value r from the x, y, z coordinates.
	 * 
	 * @param r
	 *            value to divide.
	 *
	 * @return the result.
	 */
	public Vec3 div(float r) {
		x /= r;
		y /= r;
		z /= r;
		return this;
	}

	/**
	 * Divides values xx, yy, zz from the x, y, z coordinates, respectively.
	 * 
	 * @param xx
	 *            the value that is divided to x.
	 * @param yy
	 *            the value that is divided to y.
	 * @param zz
	 *            the value that is divided to z.
	 *
	 * @return the result.
	 */
	public Vec3 div(float xx, float yy, float zz) {
		x /= xx;
		y /= yy;
		z /= zz;
		return this;
	}

	/**
	 * Divides the x, y, z values by the x, y, z coordinates of r, respectively.
	 * 
	 * @param r
	 *            value to divide.
	 *
	 * @return the result.
	 */
	public Vec3 div(Vec3 r) {
		x /= r.x;
		y /= r.y;
		z /= r.z;
		return this;
	}

	// Other methods

	/**
	 * Normalises this vector to return the directional component.
	 * 
	 * @return if the magnitude of the vector is 0, an empty vector is returned. The actual result is returned otherwise.
	 */
	public Vec3 normalise() {
		float len = length();
		if (len > 0) div(len);
		return set(0, 0, 0);
	}

	/**
	 * Gets the dot product from this and vector r.
	 * 
	 * @param r
	 *            the other vector.
	 * 
	 * @return the result (V = V·R).
	 */
	public float dot(Vec3 r) {
		return x * r.x + y * r.y + z * r.z;
	}

	/**
	 * Gets the midpoint between this and vector r.
	 * 
	 * @param r
	 *            the other vector.
	 * 
	 * @return the result.
	 */
	public Vec3 mid(Vec3 r) {
		float xx = (x + r.x) / 2f;
		float yy = (y + r.y) / 2f;
		float zz = (z + r.z) / 2f;
		return set(xx, yy, zz);
	}

	/**
	 * Gets the magnitude of this vector.
	 * 
	 * @return the result.
	 */
	public float length() {
		return (float) Math.sqrt(x * x + y * y + z * z);
	}

	/**
	 * Gets the distance from the vector to vector r using Pythagoras' Theorem.
	 * 
	 * @param r
	 *            the other vector.
	 * 
	 * @return the result.
	 */
	public float distanceTo(Vec3 r) {
		float xd = r.x - x;
		float yd = r.y - y;
		float zd = r.z - z;
		return (float) Math.sqrt(xd * xd + yd * yd + zd * zd);
	}

	/**
	 * Gets the squared distance from the vector to vector r.
	 * 
	 * @param r
	 *            the other vector.
	 * 
	 * @return the result.
	 */
	public float distanceToSqrt(Vec3 r) {
		float xd = r.x - x;
		float yd = r.y - y;
		float zd = r.z - z;
		return xd * xd + yd * yd + zd * zd;
	}

	/**
	 * Rotates this vector around the x-axis.
	 * 
	 * @param angle
	 *            the amount, in radians, to rotate.
	 * 
	 * @return the result.
	 */
	public Vec3 rotX(float angle) {
		float sin = (float) Math.sin(angle);
		float cos = (float) Math.cos(angle);
		return set(x, cos * y + sin * z, cos * z - sin * y);
	}

	/**
	 * Rotates this vector around the y-axis.
	 * 
	 * @param angle
	 *            the amount, in radians, to rotate.
	 * 
	 * @return the result.
	 */
	public Vec3 rotY(float angle) {
		float sin = (float) Math.sin(angle);
		float cos = (float) Math.cos(angle);
		return set(cos * x + sin * z, y, cos * z - sin * x);
	}

	/**
	 * Rotates this vector around the z-axis.
	 * 
	 * @param angle
	 *            the amount, in radians, to rotate.
	 * 
	 * @return the result.
	 */
	public Vec3 rotZ(float angle) {
		float sin = (float) Math.sin(angle);
		float cos = (float) Math.cos(angle);
		return set(cos * x - sin * y, sin * x + cos * y, z);
	}

	/**
	 * Creates the cross-product between this vector and other vector r.
	 * 
	 * @param r
	 *            the other vector.
	 * 
	 * @return the result.
	 */
	public Vec3 cross(Vec3 r) {
		float xx = y * r.z - z * r.y;
		float yy = z * r.x - x * r.z;
		float zz = x * r.y - y * r.x;
		return set(xx, yy, zz);
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
	public Vec3 lerpTo(Vec3 p, float t) {
		float xx = x + (p.x - x) * t;
		float yy = y + (p.y - y) * t;
		float zz = x + (p.z - z) * t;
		return set(xx, yy, zz);
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
	public Vec3 mulAdd(Vec3 v, float s) {
		x += v.x * s;
		y += v.y * s;
		z += v.z * s;
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
	public float angle(Vec3 v) {
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
	public Vec3 abs() {
		return set(Math.abs(x), Math.abs(y), Math.abs(z));
	}

	/**
	 * Gets the reciprocal value of this vector.
	 * 
	 * @return the result.
	 */
	public Vec3 reciprocal() {
		float xx = 1f / x;
		float yy = 1f / y;
		float zz = 1f / z;
		return set(xx, yy, zz);
	}

	/**
	 * Gets the x and y component of this vector as a Vec2.
	 * 
	 * @return the result.
	 */
	public Vec2 toVec2() {
		return new Vec2(x, y);
	}

	// java.lang.Object overrides

	public Vec3 clone() {
		return new Vec3(x, y, z);
	}

	public String toString() {
		return "Vec3(" + x + ", " + y + ", " + z + ")";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(y);
		result = prime * result + Float.floatToIntBits(z);
		return result;
	}

	public boolean equals(Object o) {
		if (o instanceof Vec3) {
			Vec3 r = (Vec3) o;
			if (r.x == x && r.y == y && r.z == z) return true;
		}
		return false;
	}
}
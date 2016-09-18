package com.jaspreetdhanjan.vecmath;

import java.nio.FloatBuffer;

/**
 * A row-major 4x4 matrix that is represented by 16 single-precision floating numbers.
 *
 * @author Jaspreet Dhanjan
 */

public class Mat4 {
	public float m00, m01, m02, m03;
	public float m10, m11, m12, m13;
	public float m20, m21, m22, m23;
	public float m30, m31, m32, m33;

	// Constructors and setters

	/**
	 * Constructs an identity matrix.
	 */
	public Mat4() {
		identity();
	}

	/**
	 * Constructs a matrix with given parameters.
	 */
	public Mat4(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33) {
		set(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33);
	}

	/**
	 * Constructs a matrix using the attributes of another matrix.
	 * 
	 * @param otherMatrix
	 *            the matrix to copy.
	 */
	public Mat4(Mat4 otherMatrix) {
		set(otherMatrix.m00, otherMatrix.m01, otherMatrix.m02, otherMatrix.m03, otherMatrix.m10, otherMatrix.m11, otherMatrix.m12, otherMatrix.m13, otherMatrix.m20, otherMatrix.m21, otherMatrix.m22, otherMatrix.m23, otherMatrix.m30, otherMatrix.m31, otherMatrix.m32, otherMatrix.m33);
	}

	/**
	 * Sets the matrix values to the respective arguments.
	 * 
	 * @return this matrix.
	 */
	public Mat4 set(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33) {
		this.m00 = m00;
		this.m01 = m01;
		this.m02 = m02;
		this.m03 = m03;
		this.m10 = m10;
		this.m11 = m11;
		this.m12 = m12;
		this.m13 = m13;
		this.m20 = m20;
		this.m21 = m21;
		this.m22 = m22;
		this.m23 = m23;
		this.m30 = m30;
		this.m31 = m31;
		this.m32 = m32;
		this.m33 = m33;
		return this;
	}

	/**
	 * Sets the matrix values to the same arguments as the other matrix.
	 * 
	 * @param otherMatrix
	 *            the matrix to copy.
	 * 
	 * @return this matrix.
	 */
	public Mat4 set(Mat4 otherMatrix) {
		return set(otherMatrix.m00, otherMatrix.m01, otherMatrix.m02, otherMatrix.m03, otherMatrix.m10, otherMatrix.m11, otherMatrix.m12, otherMatrix.m13, otherMatrix.m20, otherMatrix.m21, otherMatrix.m22, otherMatrix.m23, otherMatrix.m30, otherMatrix.m31, otherMatrix.m32, otherMatrix.m33);
	}

	/**
	 * Sets the matrix values to the values of the FloatBuffer.
	 * 
	 * @param b
	 *            the FloatBuffer to copy.
	 * 
	 * @return this matrix.
	 */
	public Mat4 set(FloatBuffer b) {
		int pp = 0;
		return set(b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++), b.get(pp++));
	}

	/**
	 * Sets the values of the matrix to zero.
	 * 
	 * @return this matrix.
	 */
	public Mat4 setZero() {
		return set(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	/**
	 * Sets the values of the matrix to an identity matrix.
	 * 
	 * @return this matrix.
	 */
	public Mat4 identity() {
		return set(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
	}

	/**
	 * Translates the matrix by the vector r.
	 * 
	 * @param r
	 *            the translation vector.
	 * 
	 * @return this matrix.
	 */
	public Mat4 translate(Vec3 r) {
		return translate(r.x, r.y, r.z);
	}

	/**
	 * Translates the matrix by the given x, y, z values.
	 * 
	 * @param x
	 *            the x translation coordinate.
	 * @param y
	 *            the y translation coordinate.
	 * @param z
	 *            the z translation coordinate.
	 * 
	 * @return this matrix.
	 */
	public Mat4 translate(float x, float y, float z) {
		m30 += m00 * x + m10 * y + m20 * z;
		m31 += m01 * x + m11 * y + m21 * z;
		m32 += m02 * x + m12 * y + m22 * z;
		m33 += m03 * x + m13 * y + m23 * z;
		return this;
	}

	/**
	 * Rotates the matrix by a given angle on the x-axis.
	 * 
	 * @param angle
	 *            the angle to rotate by.
	 * 
	 * @return this matrix.
	 */
	public Mat4 rotX(float angle) {
		return rotate(angle, Vec3.X);
	}

	/**
	 * Rotates the matrix by a given angle on the y-axis.
	 * 
	 * @param angle
	 *            the angle to rotate by.
	 * 
	 * @return this matrix.
	 */
	public Mat4 rotY(float angle) {
		return rotate(angle, Vec3.Y);
	}

	/**
	 * Rotates the matrix by a given angle on the z-axis.
	 * 
	 * @param angle
	 *            the angle to rotate by.
	 * 
	 * @return this matrix.
	 */
	public Mat4 rotZ(float angle) {
		return rotate(angle, Vec3.Z);
	}

	/**
	 * Rotates the matrix by a given angle on a given axis.
	 * 
	 * @param angle
	 *            the angle to rotate by.
	 * @param axis
	 *            the axis to rotate along.
	 * 
	 * @return this matrix.
	 */
	public Mat4 rotate(float angle, Vec3 axis) {
		float sin = (float) Math.sin(angle);
		float cos = (float) Math.cos(angle);
		float acos = 1f - cos;

		float xy = axis.x * axis.y;
		float yz = axis.y * axis.z;
		float xz = axis.x * axis.z;

		float xs = axis.x * sin;
		float ys = axis.y * sin;
		float zs = axis.z * sin;

		float f00 = axis.x * axis.x * acos + cos;
		float f01 = xy * acos + zs;
		float f02 = xz * acos - ys;

		float f10 = xy * acos - zs;
		float f11 = axis.y * axis.y * acos + cos;
		float f12 = yz * acos + xs;

		float f20 = xz * acos + ys;
		float f21 = yz * acos - xs;
		float f22 = axis.z * axis.z * acos + cos;

		float t00 = m00 * f00 + m10 * f01 + m20 * f02;
		float t01 = m01 * f00 + m11 * f01 + m21 * f02;
		float t02 = m02 * f00 + m12 * f01 + m22 * f02;
		float t03 = m03 * f00 + m13 * f01 + m23 * f02;
		float t10 = m00 * f10 + m10 * f11 + m20 * f12;
		float t11 = m01 * f10 + m11 * f11 + m21 * f12;
		float t12 = m02 * f10 + m12 * f11 + m22 * f12;
		float t13 = m03 * f10 + m13 * f11 + m23 * f12;

		m20 = m00 * f20 + m10 * f21 + m20 * f22;
		m21 = m01 * f20 + m11 * f21 + m21 * f22;
		m22 = m02 * f20 + m12 * f21 + m22 * f22;
		m23 = m03 * f20 + m13 * f21 + m23 * f22;

		m00 = t00;
		m01 = t01;
		m02 = t02;
		m03 = t03;
		m10 = t10;
		m11 = t11;
		m12 = t12;
		m13 = t13;
		return this;
	}

	/**
	 * Scales the matrix by the a vector r.
	 * 
	 * @param r
	 *            the vector to scale.
	 * 
	 * @return this matrix.
	 */
	public Mat4 scale(Vec3 r) {
		return scale(r.x, r.y, r.z);
	}

	/**
	 * Scales the matrix by the given x, y, z values.
	 * 
	 * @param x
	 *            the x translation coordinate.
	 * @param y
	 *            the y translation coordinate.
	 * @param z
	 *            the z translation coordinate.
	 * 
	 * @return this matrix.
	 */
	public Mat4 scale(float x, float y, float z) {
		m00 *= x;
		m01 *= x;
		m02 *= x;
		m03 *= x;
		m10 *= y;
		m11 *= y;
		m12 *= y;
		m13 *= y;
		m20 *= z;
		m21 *= z;
		m22 *= z;
		m23 *= z;
		return this;
	}

	/**
	 * Adds a scalar r to the matrix.
	 * 
	 * @param r
	 *            the value to add.
	 * 
	 * @return this matrix.
	 */
	public Mat4 add(float r) {
		m00 += r;
		m11 += r;
		m22 += r;
		m33 += r;
		return this;
	}

	/**
	 * Adds another matrix to this.
	 * 
	 * @param r
	 *            the value to add.
	 * 
	 * @return this matrix.
	 */
	public Mat4 add(Mat4 r) {
		m00 += r.m00;
		m01 += r.m01;
		m02 += r.m02;
		m03 += r.m03;
		m10 += r.m10;
		m11 += r.m11;
		m12 += r.m12;
		m13 += r.m13;
		m20 += r.m20;
		m21 += r.m21;
		m22 += r.m22;
		m23 += r.m23;
		m30 += r.m30;
		m31 += r.m31;
		m32 += r.m32;
		m33 += r.m33;
		return this;
	}

	/**
	 * Multiplies this matrix by a vector r.
	 * 
	 * @param r
	 *            the vector to multiply by.
	 * 
	 * @return this matrix.
	 */
	public Vec3 mul(Vec3 r) {
		float x = m00 * r.x + m01 * r.y + m02 * r.z + m03;
		float y = m10 * r.x + m11 * r.y + m12 * r.z + m13;
		float z = m20 * r.x + m21 * r.y + m22 * r.z + m23;
		// float w = m30 * r.x + m31 * r.y + m22 * r.z + m33;
		return new Vec3(x, y, z);
	}

	/**
	 * Multiplies this matrix by a scalar s.
	 * 
	 * @param r
	 *            the value to multiply by.
	 * 
	 * @return this matrix.
	 */
	public Mat4 mul(float s) {
		return set(m00 * s, m01 * s, m02 * s, m03 * s, m10 * s, m11 * s, m12 * s, m13 * s, m20 * s, m21 * s, m22 * s, m23 * s, m30 * s, m31 * s, m32 * s, m33 * s);
	}

	/**
	 * Multiplies this matrix by another matrix m.
	 * 
	 * @param m
	 *            the value to multiply by.
	 * 
	 * @return this matrix.
	 */
	public Mat4 mul(Mat4 m) {
		m00 = m00 * m.m00 + m01 * m.m10 + m02 * m.m20 + m03 * m.m30;
		m01 = m00 * m.m01 + m01 * m.m11 + m02 * m.m21 + m03 * m.m31;
		m02 = m00 * m.m02 + m01 * m.m12 + m02 * m.m22 + m03 * m.m32;
		m03 = m00 * m.m03 + m01 * m.m13 + m02 * m.m23 + m03 * m.m33;

		m10 = m10 * m.m00 + m11 * m.m10 + m12 * m.m20 + m13 * m.m30;
		m11 = m10 * m.m01 + m11 * m.m11 + m12 * m.m21 + m13 * m.m31;
		m12 = m10 * m.m02 + m11 * m.m12 + m12 * m.m22 + m13 * m.m32;
		m13 = m10 * m.m03 + m11 * m.m13 + m12 * m.m23 + m13 * m.m33;

		m20 = m20 * m.m00 + m21 * m.m10 + m22 * m.m20 + m23 * m.m30;
		m21 = m20 * m.m01 + m21 * m.m11 + m22 * m.m21 + m23 * m.m31;
		m22 = m20 * m.m02 + m21 * m.m12 + m22 * m.m22 + m23 * m.m32;
		m23 = m20 * m.m03 + m21 * m.m13 + m22 * m.m23 + m23 * m.m33;

		m30 = m30 * m.m00 + m31 * m.m10 + m32 * m.m20 + m33 * m.m30;
		m31 = m30 * m.m01 + m31 * m.m11 + m32 * m.m21 + m33 * m.m31;
		m32 = m30 * m.m02 + m31 * m.m12 + m32 * m.m22 + m33 * m.m32;
		m33 = m30 * m.m03 + m31 * m.m13 + m32 * m.m23 + m33 * m.m33;
		return this;
	}

	/**
	 * Linearly interpolates between this matrix and the given matrix m.
	 * 
	 * @param m
	 *            the other matrix.
	 * @param t
	 *            the step size.
	 * 
	 * @return this matrix.
	 */
	public Mat4 lerpTo(Mat4 m, float t) {
		m00 *= (1 - t) + m.m00 * t;
		m01 *= (1 - t) + m.m01 * t;
		m02 *= (1 - t) + m.m02 * t;
		m03 *= (1 - t) + m.m03 * t;
		m10 *= (1 - t) + m.m10 * t;
		m11 *= (1 - t) + m.m11 * t;
		m12 *= (1 - t) + m.m12 * t;
		m13 *= (1 - t) + m.m13 * t;
		m20 *= (1 - t) + m.m20 * t;
		m21 *= (1 - t) + m.m21 * t;
		m22 *= (1 - t) + m.m22 * t;
		m23 *= (1 - t) + m.m23 * t;
		m30 *= (1 - t) + m.m30 * t;
		m31 *= (1 - t) + m.m31 * t;
		m32 *= (1 - t) + m.m32 * t;
		m33 *= (1 - t) + m.m33 * t;
		return this;
	}

	/**
	 * Creates a perspective matrix.
	 * 
	 * @param fov
	 *            the field-of-view.
	 * @param aspect
	 *            the aspect ratio.
	 * @param near
	 *            the near clipping plane.
	 * @param far
	 *            the far clipping plane.
	 * 
	 * @return this matrix.
	 */
	public Mat4 createPerspectiveMatrix(float fov, float aspect, float near, float far) {
		identity();

		float yScale = (float) (1f / Math.tan(Math.toRadians(fov / 2f)));
		float xScale = yScale / aspect;
		float clipPlane = far - near;

		m00 = xScale;
		m11 = yScale;
		m22 = -((far + near) / clipPlane);
		m23 = -1f;
		m32 = -((2f * far * near) / clipPlane);
		m33 = 0f;
		return this;
	}

	/**
	 * Creates an orthographic matrix.
	 * 
	 * @param left
	 *            the left clipping plane.
	 * @param right
	 *            the right clipping plane.
	 * @param bottom
	 *            the bottom clipping plane.
	 * @param top
	 *            the top clipping plane.
	 * @param near
	 *            the near clipping plane.
	 * @param far
	 *            the far clipping plane.
	 * 
	 * @return this matrix.
	 */
	public Mat4 createOrthographicMatrix(float left, float right, float bottom, float top, float near, float far) {
		identity();

		float xOrth = 2f / (right - left);
		float yOrth = 2f / (top - bottom);
		float zOrth = -2f / (far - near);

		float tx = -(right + left) / (right - left);
		float ty = -(top + bottom) / (top - bottom);
		float tz = -(far + near) / (far - near);

		m00 = xOrth;
		m11 = yOrth;
		m22 = zOrth;
		m30 = tx;
		m31 = ty;
		m32 = tz;
		m33 = 1;
		return this;
	}

	/**
	 * Sets the matrix to a look at matrix with a direction and an up vector.
	 * 
	 * Multiply this with a translation matrix to get a camera model-view matrix.
	 * 
	 * @param eye
	 *            the position of the camera.
	 * @param center
	 *            the center position.
	 * @param up
	 *            the up director.
	 * 
	 * @return this matrix.
	 */
	public Mat4 lookAt(Vec3 eye, Vec3 center, Vec3 up) {
		identity();

		Vec3 forward = center.clone().sub(eye).normalise();
		Vec3 side = forward.clone().cross(up).normalise();
		up = side.clone().cross(forward);

		m00 = side.x;
		m01 = side.y;
		m02 = side.z;
		m10 = up.x;
		m11 = up.y;
		m12 = up.z;
		m20 = -forward.x;
		m21 = -forward.y;
		m22 = -forward.z;
		return this;
	}

	/**
	 * Multiplies the matrix by -1.
	 * 
	 * @return this matrix.
	 */
	public Mat4 negate() {
		return mul(-1f);
	}

	/**
	 * Gets the determinant of this matrix.
	 * 
	 * @return the value of the determinant.
	 */
	public float getDeterminant() {
		return m30 * m21 * m12 * m03 - m20 * m31 * m12 * m03 //
				- m30 * m11 * m22 * m03 + m10 * m31 * m22 * m03 //
				+ m20 * m11 * m32 * m03 - m10 * m21 * m32 * m03 //
				- m30 * m21 * m02 * m13 + m20 * m31 * m02 * m13 //
				+ m30 * m01 * m22 * m13 - m00 * m31 * m22 * m13 //
				- m20 * m01 * m32 * m13 + m00 * m21 * m32 * m13 //
				+ m30 * m11 * m02 * m23 - m10 * m31 * m02 * m23 //
				- m30 * m01 * m12 * m23 + m00 * m31 * m12 * m23 //
				+ m10 * m01 * m32 * m23 - m00 * m11 * m32 * m23 //
				- m20 * m11 * m02 * m33 + m10 * m21 * m02 * m33 //
				+ m20 * m01 * m12 * m33 - m00 * m21 * m12 * m33 //
				- m10 * m01 * m22 * m33 + m00 * m11 * m22 * m33;//
	}

	/**
	 * Inverses the matrix.
	 * 
	 * @throws a
	 *             RuntimeException if the matrix is singular (non-invertible).
	 * 
	 * @return this matrix.
	 */
	public Mat4 inverse() {
		if (!isInvertible()) {
			throw new RuntimeException("Non-Invertible matrix: " + this);
		}
		float invDeterminant = 1f / getDeterminant();

		float t00 = m12 * m23 * m31 - m13 * m22 * m31 + m13 * m21 * m32 - m11 * m23 * m32 - m12 * m21 * m33 + m11 * m22 * m33;
		float t01 = m03 * m22 * m31 - m02 * m23 * m31 - m03 * m21 * m32 + m01 * m23 * m32 + m02 * m21 * m33 - m01 * m22 * m33;
		float t02 = m02 * m13 * m31 - m03 * m12 * m31 + m03 * m11 * m32 - m01 * m13 * m32 - m02 * m11 * m33 + m01 * m12 * m33;
		float t03 = m03 * m12 * m21 - m02 * m13 * m21 - m03 * m11 * m22 + m01 * m13 * m22 + m02 * m11 * m23 - m01 * m12 * m23;
		float t10 = m13 * m22 * m30 - m12 * m23 * m30 - m13 * m20 * m32 + m10 * m23 * m32 + m12 * m20 * m33 - m10 * m22 * m33;
		float t11 = m02 * m23 * m30 - m03 * m22 * m30 + m03 * m20 * m32 - m00 * m23 * m32 - m02 * m20 * m33 + m00 * m22 * m33;
		float t12 = m03 * m12 * m30 - m02 * m13 * m30 - m03 * m10 * m32 + m00 * m13 * m32 + m02 * m10 * m33 - m00 * m12 * m33;
		float t13 = m02 * m13 * m20 - m03 * m12 * m20 + m03 * m10 * m22 - m00 * m13 * m22 - m02 * m10 * m23 + m00 * m12 * m23;
		float t20 = m11 * m23 * m30 - m13 * m21 * m30 + m13 * m20 * m31 - m10 * m23 * m31 - m11 * m20 * m33 + m10 * m21 * m33;
		float t21 = m03 * m21 * m30 - m01 * m23 * m30 - m03 * m20 * m31 + m00 * m23 * m31 + m01 * m20 * m33 - m00 * m21 * m33;
		float t22 = m01 * m13 * m30 - m03 * m11 * m30 + m03 * m10 * m31 - m00 * m13 * m31 - m01 * m10 * m33 + m00 * m11 * m33;
		float t23 = m03 * m11 * m20 - m01 * m13 * m20 - m03 * m10 * m21 + m00 * m13 * m21 + m01 * m10 * m23 - m00 * m11 * m23;
		float t30 = m12 * m21 * m30 - m11 * m22 * m30 - m12 * m20 * m31 + m10 * m22 * m31 + m11 * m20 * m32 - m10 * m21 * m32;
		float t31 = m01 * m22 * m30 - m02 * m21 * m30 + m02 * m20 * m31 - m00 * m22 * m31 - m01 * m20 * m32 + m00 * m21 * m32;
		float t32 = m02 * m11 * m30 - m01 * m12 * m30 - m02 * m10 * m31 + m00 * m12 * m31 + m01 * m10 * m32 - m00 * m11 * m32;
		float t33 = m01 * m12 * m20 - m02 * m11 * m20 + m02 * m10 * m21 - m00 * m12 * m21 - m01 * m10 * m22 + m00 * m11 * m22;
		return set(t00, t01, t02, t03, t10, t11, t12, t13, t20, t21, t22, t23, t30, t31, t32, t33).mul(invDeterminant);
	}

	private boolean isInvertible() {
		return getDeterminant() != 0f;
	}

	/**
	 * Transposes the matrix to a column-major matrix.
	 * 
	 * @return this matrix.
	 */
	public Mat4 transpose() {
		float t00 = m00, t01 = m01, t02 = m02, t03 = m03;
		float t10 = m10, t11 = m11, t12 = m12, t13 = m13;
		float t20 = m20, t21 = m21, t22 = m22, t23 = m23;
		float t30 = m30, t31 = m31, t32 = m32, t33 = m33;
		return set(t00, t10, t20, t30, t01, t11, t21, t31, t02, t12, t22, t32, t03, t13, t23, t33);
	}

	/**
	 * Gets the reciprocal of this matrix.
	 * 
	 * @return this matrix.
	 */
	public Mat4 reciprocal() {
		return set(1f / m00, 1f / m01, 1f / m02, 1f / m03, 1f / m10, 1f / m11, 1f / m12, 1f / m13, 1f / m20, 1f / m21, 1f / m22, 1f / m23, 1f / m30, 1f / m31, 1f / m32, 1f / m33);
	}

	/**
	 * Compresses the matrix information into the given FloatBuffer, ready for OpenGL usage.
	 * 
	 * @param tmpBuffer
	 *            the buffer where the matrix will be stored into.
	 * 
	 * @return a FloatBuffer copy of this row-major matrix.
	 */
	public void putInto(FloatBuffer tmpBuffer) {
		tmpBuffer.clear();
		tmpBuffer.put(m00).put(m01).put(m02).put(m03).put(m10).put(m11).put(m12).put(m13).put(m20).put(m21).put(m22).put(m23).put(m30).put(m31).put(m32).put(m33);
		tmpBuffer.flip();
	}

	// java.lang.Object overrides

	public Mat4 clone() {
		return new Mat4(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33);
	}

	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append(m00).append(" ").append(m01).append(" ").append(m02).append(" ").append(m03).append("\n");
		b.append(m10).append(" ").append(m11).append(" ").append(m12).append(" ").append(m13).append("\n");
		b.append(m20).append(" ").append(m21).append(" ").append(m22).append(" ").append(m23).append("\n");
		b.append(m30).append(" ").append(m21).append(" ").append(m32).append(" ").append(m33).append("\n");
		return b.toString();
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(m00);
		result = prime * result + Float.floatToIntBits(m01);
		result = prime * result + Float.floatToIntBits(m02);
		result = prime * result + Float.floatToIntBits(m03);
		result = prime * result + Float.floatToIntBits(m10);
		result = prime * result + Float.floatToIntBits(m11);
		result = prime * result + Float.floatToIntBits(m12);
		result = prime * result + Float.floatToIntBits(m13);
		result = prime * result + Float.floatToIntBits(m20);
		result = prime * result + Float.floatToIntBits(m21);
		result = prime * result + Float.floatToIntBits(m22);
		result = prime * result + Float.floatToIntBits(m23);
		result = prime * result + Float.floatToIntBits(m30);
		result = prime * result + Float.floatToIntBits(m31);
		result = prime * result + Float.floatToIntBits(m32);
		result = prime * result + Float.floatToIntBits(m33);
		return result;
	}

	public boolean equals(Object o) {
		if (o instanceof Mat4) {
			Mat4 r = (Mat4) o;
			if (m00 != r.m00 && m01 != r.m01 && m02 != r.m02 && m03 != r.m03) return false;
			if (m10 != r.m10 && m11 != r.m11 && m12 != r.m12 && m13 != r.m13) return false;
			if (m20 != r.m20 && m21 != r.m21 && m22 != r.m22 && m23 != r.m23) return false;
			if (m30 != r.m30 && m31 != r.m31 && m32 != r.m32 && m33 != r.m33) return false;
			return true;
		}
		return false;
	}
}
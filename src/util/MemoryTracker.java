package util;

import java.nio.*;

public class MemoryTracker {
	private static ByteBuffer byteBuffer = createByteBuffer(4);
	private static ShortBuffer shortBuffer = createShortBuffer(4);
	private static CharBuffer charBuffer = createCharBuffer(4);
	private static IntBuffer intBuffer = createIntBuffer(4);
	private static LongBuffer longBuffer = createLongBuffer(4);
	private static FloatBuffer floatBuffer = createFloatBuffer(4);
	private static DoubleBuffer doubleBuffer = createDoubleBuffer(4);

	public static ByteBuffer getb(byte a, byte b, byte c, byte d) {
		byteBuffer.clear();
		byteBuffer.put(a).put(b).put(c).put(d);
		byteBuffer.flip();
		return byteBuffer;
	}

	public static ShortBuffer gets(short a, short b, short c, short d) {
		shortBuffer.clear();
		shortBuffer.put(a).put(b).put(c).put(d);
		shortBuffer.flip();
		return shortBuffer;
	}

	public static CharBuffer getc(char a, char b, char c, char d) {
		charBuffer.clear();
		charBuffer.put(a).put(b).put(c).put(d);
		charBuffer.flip();
		return charBuffer;
	}

	public static IntBuffer geti(int a, int b, int c, int d) {
		intBuffer.clear();
		intBuffer.put(a).put(b).put(c).put(d);
		intBuffer.flip();
		return intBuffer;
	}

	public static LongBuffer getl(long a, long b, long c, long d) {
		longBuffer.clear();
		longBuffer.put(a).put(b).put(c).put(d);
		longBuffer.flip();
		return longBuffer;
	}

	public static FloatBuffer getf(float a, float b, float c, float d) {
		floatBuffer.clear();
		floatBuffer.put(a).put(b).put(c).put(d);
		floatBuffer.flip();
		return floatBuffer;
	}

	public static DoubleBuffer getd(double a, double b, double c, double d) {
		doubleBuffer.clear();
		doubleBuffer.put(a).put(b).put(c).put(d);
		doubleBuffer.flip();
		return doubleBuffer;
	}

	public static ByteBuffer createByteBuffer(int size) {
		return ByteBuffer.allocateDirect(size).order(ByteOrder.nativeOrder());
	}

	public static ShortBuffer createShortBuffer(int size) {
		return createByteBuffer(size << 1).asShortBuffer();
	}

	public static CharBuffer createCharBuffer(int size) {
		return createByteBuffer(size << 1).asCharBuffer();
	}

	public static IntBuffer createIntBuffer(int size) {
		return createByteBuffer(size << 2).asIntBuffer();
	}

	public static LongBuffer createLongBuffer(int size) {
		return createByteBuffer(size << 3).asLongBuffer();
	}

	public static FloatBuffer createFloatBuffer(int size) {
		return createByteBuffer(size << 2).asFloatBuffer();
	}

	public static DoubleBuffer createDoubleBuffer(int size) {
		return createByteBuffer(size << 3).asDoubleBuffer();
	}

	public static native long getBufferAddress(Buffer buffer);
}
package com.twolight.mp4parse.box;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * @author wangyuehui
 * @date 2018/3/2 上午9:25
 * @description TODO: briefly describe what this file does
 */
public abstract class Box {
    private int size;
    private String type;

    public Box(int size, String type) {
        this.size = size;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Box{" +
                "size=" + size +
                ", type='" + type + '\'' +
                '}';
    }

    protected final short readShort(InputStream inputStream) throws IOException {
        byte[] src = new byte[2];
        inputStream.read(src);

        return (short) ((short) ((src[0] & 0xF) << 8)
                | (short) ((src[1] & 0xF)));
    }

    protected final int readInt(InputStream inputStream) throws IOException {
        byte[] src = new byte[4];
        inputStream.read(src);

        return (((src[0] & 0xFF) << 24)
                | ((src[1] & 0xFF) << 16)
                | ((src[2] & 0xFF) << 8)
                | (src[3] & 0xFF));
    }

    protected String readString(InputStream inputStream, int i) throws IOException {
        byte[] bytes = new byte[i];
        inputStream.read(bytes);
        return new String(bytes);
    }

    protected final int bytesToInt(byte[] src, int offset) {
        return (((src[offset] & 0xFF) << 24)
                | ((src[offset + 1] & 0xFF) << 16)
                | ((src[offset + 2] & 0xFF) << 8)
                | (src[offset + 3] & 0xFF));
    }

    protected final long bytesToLong(byte[] src, int offset) {
        return ((src[offset] & 0xFF) << 56)
                | ((src[offset + 1] & 0xFF) << 48)
                | ((src[offset + 2] & 0xFF) << 40)
                | ((src[offset + 3] & 0xFF) << 32)
                | ((src[offset + 4] & 0xFF) << 24)
                | ((src[offset + 5] & 0xFF) << 16)
                | ((src[offset + 6] & 0xFF) << 8)
                | ((src[offset + 7] & 0xFF));
    }

    protected final String bytesToString(byte[] src, int from, int length) {
        return new String(Arrays.copyOfRange(src, from, from + length));
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

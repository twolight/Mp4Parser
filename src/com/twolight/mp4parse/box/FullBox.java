package com.twolight.mp4parse.box;

import com.twolight.mp4parse.UnsignedChar;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * @author wangyuehui
 * @date 2018/3/2 上午9:27
 * @description TODO: briefly describe what this file does
 */
public abstract class FullBox extends Box {
    private UnsignedChar version;
    private byte[] flags;

    public FullBox(int size, String type, InputStream inputStream) throws IOException {
        super(size, type);

        this.version = new UnsignedChar(inputStream);
        flags = new byte[3];
        inputStream.read(flags);
    }

    public UnsignedChar getVersion() {
        return version;
    }

    public void setVersion(UnsignedChar version) {
        this.version = version;
    }

    public byte[] getFlags() {
        return flags;
    }

    public void setFlags(byte[] flags) {
        this.flags = flags;
    }

    @Override
    public String toString() {
        return "FullBox{" +
                "version=" + version +
                ", flags=" + Arrays.toString(flags) +
                "} " + super.toString();
    }
}

package com.twolight.mp4parse.box;

import com.twolight.mp4parse.box.Box;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangyuehui
 * @date 2018/3/2 上午9:25
 * @description TODO: briefly describe what this file does
 */
public class Mdat extends Box {
    protected byte[] data;

    public Mdat(int size, String type, InputStream inputStream) throws IOException {
        super(size, type);
        data = new byte[size - 8];
        inputStream.read(data);
    }
}

package com.twolight.mp4parse.box;

import com.twolight.mp4parse.UnsignedInt;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangyuehui
 * @date 2018/3/2 下午5:24
 * @description TODO: briefly describe what this file does
 */
public class Btrt extends FullBox {
    private UnsignedInt bufferSizeDB;
    private UnsignedInt maxBitrate;
    private UnsignedInt avgBitrate;

    public Btrt(int size, String type, InputStream inputStream) throws IOException {
        super(size, type, inputStream);

        bufferSizeDB = new UnsignedInt(inputStream);
        maxBitrate = new UnsignedInt(inputStream);
        avgBitrate = new UnsignedInt(inputStream);
    }
}

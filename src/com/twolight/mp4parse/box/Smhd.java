package com.twolight.mp4parse.box;

import com.twolight.mp4parse.UnsignedShort;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangyuehui
 * @date 2018/3/2 下午3:12
 * @description TODO: briefly describe what this file does
 */
public class Smhd extends FullBox {
    private short balance;
    private UnsignedShort reserved;
    public Smhd(int size, String type, InputStream inputStream) throws IOException {
        super(size, type, inputStream);
        balance = readShort(inputStream);

        reserved = new UnsignedShort(inputStream);
    }
}

package com.twolight.mp4parse.box;

import com.twolight.mp4parse.UnsignedShort;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangyuehui
 * @date 2018/3/2 下午3:10
 * @description TODO: briefly describe what this file does
 */
public class Vmhd extends FullBox {
    private UnsignedShort graphicsmode;
    private UnsignedShort[] opcolor;

    public Vmhd(int size, String type, InputStream inputStream) throws IOException {
        super(size, type, inputStream);

        graphicsmode = new UnsignedShort(inputStream);
        opcolor = new UnsignedShort[]{
                new UnsignedShort(inputStream),
                new UnsignedShort(inputStream),
                new UnsignedShort(inputStream)
        };
    }
}

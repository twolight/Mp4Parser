package com.twolight.mp4parse.box;

import com.twolight.mp4parse.UnsignedInt;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangyuehui
 * @date 2018/3/2 下午3:15
 * @description TODO: briefly describe what this file does
 */
public class Dref extends FullBox {
    private UnsignedInt entry_count;

    public Dref(int size, String type, InputStream inputStream) throws IOException {
        super(size, type, inputStream);

        entry_count = new UnsignedInt(inputStream);
    }
}

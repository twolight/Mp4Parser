package com.twolight.mp4parse.box;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangyuehui
 * @date 2018/3/2 下午3:26
 * @description TODO: briefly describe what this file does
 */
public class Url extends FullBox {
    public Url(int size, String type, InputStream inputStream) throws IOException {
        super(size, type, inputStream);

        inputStream.skip(size - 12);
    }
}

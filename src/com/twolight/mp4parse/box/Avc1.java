package com.twolight.mp4parse.box;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangyuehui
 * @date 2018/3/2 下午5:40
 * @description TODO: briefly describe what this file does
 */
public class Avc1 extends FullBox {
    public Avc1(int size, String type, InputStream inputStream) throws IOException {
        super(size, type, inputStream);

        // TODO: 2018/3/2 暂时不解析Avc1
        inputStream.skip(size - 12);
    }
}

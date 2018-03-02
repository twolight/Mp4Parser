package com.twolight.mp4parse;

import com.twolight.mp4parse.box.FullBox;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangyuehui
 * @date 2018/3/2 下午5:48
 * @description TODO: briefly describe what this file does
 */
public class Mp4a extends FullBox {
    public Mp4a(int size, String type, InputStream inputStream) throws IOException {
        super(size, type, inputStream);
        // TODO: 2018/3/2 暂时不解析Mp4a
        inputStream.skip(size - 12);
    }
}

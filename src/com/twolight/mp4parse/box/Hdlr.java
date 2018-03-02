package com.twolight.mp4parse.box;

import com.twolight.mp4parse.box.FullBox;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangyuehui
 * @date 2018/3/2 下午3:05
 * @description TODO: briefly describe what this file does
 */
public class Hdlr extends FullBox {
//    unsigned int(32) pre_defined = 0;
//    unsigned int(32) handler_type;
//    const unsigned int(32)[3] reserved = 0;
//    string name;

    public Hdlr(int size, String type, InputStream inputStream) throws IOException {
        super(size,type,inputStream);

        inputStream.skip(size - 12);
    }
}

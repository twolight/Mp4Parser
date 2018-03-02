package com.twolight.mp4parse;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangyuehui
 * @date 2018/3/2 上午10:19
 * @description TODO: briefly describe what this file does
 */
public class UnsignedChar extends Unsigned {

    public UnsignedChar(InputStream inputStream) throws IOException {
        super(inputStream, 1);
    }
}

package com.twolight.mp4parse.box;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangyuehui
 * @date 2018/3/2 下午5:53
 * @description TODO: briefly describe what this file does
 */
public class Meta extends FullBox {
    public Meta(int size, String type, InputStream inputStream) throws IOException {
        super(size, type, inputStream);

        // TODO: 2018/3/2 忽略meta box
        inputStream.skip(size - 12);
    }
}

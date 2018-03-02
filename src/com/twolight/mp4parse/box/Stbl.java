package com.twolight.mp4parse.box;

import java.io.InputStream;

/**
 * @author wangyuehui
 * @date 2018/3/2 下午3:21
 * @description TODO: briefly describe what this file does
 */
public class Stbl extends Box {
    public Stbl(int size, String type, InputStream inputStream) {
        super(size, type);
    }
}

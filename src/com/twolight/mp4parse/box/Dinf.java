package com.twolight.mp4parse.box;

import com.twolight.mp4parse.box.Box;

import java.io.InputStream;

/**
 * @author wangyuehui
 * @date 2018/3/2 下午3:14
 * @description TODO: briefly describe what this file does
 */
public class Dinf extends Box {
    public Dinf(int size, String type, InputStream inputStream) {
        super(size, type);
    }
}

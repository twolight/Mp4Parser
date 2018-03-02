package com.twolight.mp4parse.box;

import java.io.InputStream;

/**
 * @author wangyuehui
 * @date 2018/3/2 下午2:56
 * @description TODO: briefly describe what this file does
 */
public class Mdia extends Box {
    public Mdia(int size, String type, InputStream inputStream) {
        super(size, type);
    }
}

package com.twolight.mp4parse.box;

import java.io.InputStream;

/**
 * @author wangyuehui
 * @date 2018/3/2 上午9:26
 * @description TODO: briefly describe what this file does
 */
public class Moov extends Box {

    public Moov(int size, String type, InputStream inputStream) {
        super(size, type);
    }

    @Override
    public String toString() {
        return "Moov{} " + super.toString();
    }
}

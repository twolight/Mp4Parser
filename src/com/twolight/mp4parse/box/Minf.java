package com.twolight.mp4parse.box;

import java.io.InputStream;

/**
 * @author wangyuehui
 * @date 2018/3/2 下午3:09
 * @description TODO: briefly describe what this file does
 */
public class Minf extends Box {
    public Minf(int size, String type, InputStream inputStream) {
        super(size,type);
    }
}

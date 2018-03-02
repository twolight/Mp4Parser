package com.twolight.mp4parse.box;

import java.io.InputStream;

/**
 * @author wangyuehui
 * @date 2018/3/2 下午5:50
 * @description TODO: briefly describe what this file does
 */
public class Udta extends Box {
    public Udta(int size, String type, InputStream inputStream) {
        super(size, type);
    }
}

package com.twolight.mp4parse.box;

/**
 * @author wangyuehui
 * @date 2018/3/2 上午9:25
 * @description TODO: briefly describe what this file does
 */
public class Free extends Box {

    public Free(int size, String type) {
        super(size, type);
    }

    @Override
    public String toString() {
        return "Free{} " + super.toString();
    }
}

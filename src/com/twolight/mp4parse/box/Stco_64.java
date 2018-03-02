package com.twolight.mp4parse.box;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyuehui
 * @date 2018/3/2 上午9:26
 * @description TODO: briefly describe what this file does
 */
public class Stco_64 extends FullBox {
    private int entry_count;
    private List<Integer> chunk_offset = new ArrayList<>();

    public Stco_64(int size, String type, InputStream inputStream) throws IOException {
        super(size, type, inputStream);
    }
}

package com.twolight.mp4parse.box;

import com.twolight.mp4parse.Unsigned;
import com.twolight.mp4parse.UnsignedInt;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyuehui
 * @date 2018/3/2 上午9:26
 * @description TODO: briefly describe what this file does
 */
public class Stco extends FullBox {
    private UnsignedInt entry_count;
    private List<Unsigned> chunk_offset = new ArrayList<>();

    public Stco(int size, String type, InputStream inputStream) throws IOException {
        super(size, type, inputStream);
        entry_count = new UnsignedInt(inputStream);
        for (long i = 1; i <= entry_count.getValue().longValueExact(); i++) {
            UnsignedInt unsignedInt = new UnsignedInt(inputStream);
            chunk_offset.add(unsignedInt);
        }
    }

}

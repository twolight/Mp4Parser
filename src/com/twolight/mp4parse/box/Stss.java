package com.twolight.mp4parse.box;

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
public class Stss extends FullBox {
    protected UnsignedInt entry_count;
    protected List<UnsignedInt> sample_number = new ArrayList<>();

    public Stss(int size, String type, InputStream inputStream) throws IOException {
        super(size, type, inputStream);

        entry_count = new UnsignedInt(inputStream);

        for (int i = 0; i < entry_count.getValue().longValueExact(); i++) {
            sample_number.add(new UnsignedInt(inputStream));
        }
    }

}

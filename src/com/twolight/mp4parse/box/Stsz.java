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
public class Stsz extends FullBox {
    protected UnsignedInt sample_size;
    protected UnsignedInt sample_count;
    protected List<UnsignedInt> entry_size = new ArrayList<>();

    public Stsz(int size, String type, InputStream inputStream) throws IOException {
        super(size, type, inputStream);

        sample_size = new UnsignedInt(inputStream);
        sample_count = new UnsignedInt(inputStream);

        if (sample_size.getValue().longValueExact() == 0) {
            for (int i = 1; i <= sample_count.getValue().longValueExact(); i++) {
                entry_size.add(new UnsignedInt(inputStream));
            }
        }
    }

}

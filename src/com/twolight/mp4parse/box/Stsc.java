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
public class Stsc extends FullBox {
    protected UnsignedInt entry_count;
    protected List<UnsignedInt> first_chunk = new ArrayList<>();
    protected List<UnsignedInt> samples_per_chunk = new ArrayList<>();
    protected List<UnsignedInt> sample_description_index = new ArrayList<>();

    public Stsc(int size, String type, InputStream inputStream) throws IOException {
        super(size, type, inputStream);

        entry_count = new UnsignedInt(inputStream);

        for (long i = 1; i <= entry_count.getValue().longValueExact(); i++) {
            first_chunk.add(new UnsignedInt(inputStream));
            samples_per_chunk.add(new UnsignedInt(inputStream));
            sample_description_index.add(new UnsignedInt(inputStream));
        }
    }
}

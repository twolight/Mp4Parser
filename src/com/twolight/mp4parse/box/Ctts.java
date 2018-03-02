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
public class Ctts extends FullBox {
    protected UnsignedInt entry_count;
    protected List<UnsignedInt> sample_count = new ArrayList<>();
    protected List<UnsignedInt> sample_offset = new ArrayList<>();

    public Ctts(int size, String type, InputStream inputStream) throws IOException {
        super(size, type, inputStream);

        entry_count = new UnsignedInt(inputStream);

        if(getVersion().getValue().intValue() == 0){

        }else if(getVersion().getValue().intValue() == 1){

        }

        for (int i = 0; i < entry_count.getValue().longValueExact(); i++) {
            sample_count.add(new UnsignedInt(inputStream));
            sample_offset.add(new UnsignedInt(inputStream));
        }
    }
}

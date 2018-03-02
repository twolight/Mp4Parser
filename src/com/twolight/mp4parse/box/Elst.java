package com.twolight.mp4parse.box;

import com.twolight.mp4parse.Unsigned;
import com.twolight.mp4parse.UnsignedInt;
import com.twolight.mp4parse.UnsignedLong;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyuehui
 * @date 2018/3/2 下午5:02
 * @description TODO: briefly describe what this file does
 */
public class Elst extends FullBox {
    private UnsignedInt entry_count;
    private List<Unsigned> segment_duration = new ArrayList<>();
    private List<Unsigned> media_time = new ArrayList<>();
    private List<Short> media_rate_integer = new ArrayList<>();
    private List<Short> media_rate_fraction = new ArrayList<>();

    public Elst(int size, String type, InputStream inputStream) throws IOException {
        super(size, type, inputStream);

        entry_count = new UnsignedInt(inputStream);

        for (int i = 0; i < entry_count.getValue().longValueExact(); i++) {
            if (getVersion().getValue().longValueExact() == 1) {
                segment_duration.add(new UnsignedLong(inputStream));
                media_time.add(new UnsignedLong(inputStream));
            } else { // version==0
                segment_duration.add(new UnsignedInt(inputStream));
                media_time.add(new UnsignedInt(inputStream));
            }

            media_rate_integer.add(readShort(inputStream));
            media_rate_fraction.add(readShort(inputStream));
        }
    }
}

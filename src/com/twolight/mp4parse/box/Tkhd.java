package com.twolight.mp4parse.box;

import com.twolight.mp4parse.Unsigned;
import com.twolight.mp4parse.UnsignedInt;
import com.twolight.mp4parse.UnsignedLong;
import com.twolight.mp4parse.UnsignedShort;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangyuehui
 * @date 2018/3/2 下午2:19
 * @description TODO: briefly describe what this file does
 */
public class Tkhd extends FullBox {

    private Unsigned creation_time;
    private Unsigned modification_time;
    private Unsigned track_ID;
    private Unsigned reserved;
    private Unsigned duration;

    private UnsignedInt[] pub_reserved;
    private short layer;
    private short alternate_group;
    private short volume;
    private UnsignedShort pub_reserved_2;
    private int[] matrix;
    private UnsignedInt width;
    private UnsignedInt height;


    public Tkhd(int size, String type, InputStream inputStream) throws IOException {
        super(size, type, inputStream);

        int version = getVersion().getValue().intValue();

        if (version == 1) {
            creation_time = new UnsignedLong(inputStream);
            modification_time = new UnsignedLong(inputStream);
            track_ID = new UnsignedInt(inputStream);
            reserved = new UnsignedInt(inputStream);
            duration = new UnsignedLong(inputStream);
        } else {
            creation_time = new UnsignedInt(inputStream);
            modification_time = new UnsignedInt(inputStream);
            track_ID = new UnsignedInt(inputStream);
            reserved = new UnsignedInt(inputStream);
            duration = new UnsignedInt(inputStream);
        }

        pub_reserved = new UnsignedInt[]{new UnsignedInt(inputStream), new UnsignedInt(inputStream)};

        layer = readShort(inputStream);
        alternate_group = readShort(inputStream);
        volume = readShort(inputStream);

        pub_reserved_2 = new UnsignedShort(inputStream);

        matrix = new int[]{
                readInt(inputStream),
                readInt(inputStream),
                readInt(inputStream),
                readInt(inputStream),
                readInt(inputStream),
                readInt(inputStream),
                readInt(inputStream),
                readInt(inputStream),
                readInt(inputStream)
        };

        width = new UnsignedInt(inputStream);
        height = new UnsignedInt(inputStream);
    }
}

package com.twolight.mp4parse.box;

import com.twolight.mp4parse.UnsignedChar;
import com.twolight.mp4parse.UnsignedInt;
import com.twolight.mp4parse.UnsignedLong;
import com.twolight.mp4parse.UnsignedShort;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangyuehui
 * @date 2018/3/2 上午9:25
 * @description TODO: briefly describe what this file does
 */
class Mvhd_64 extends FullBox {
    public UnsignedLong creation_time;
    public UnsignedLong modification_time;
    public UnsignedInt timescale;
    public UnsignedLong duration;
    public float rate;
    public float volume;
    public byte[] reserved;

    public byte[] matrix;
    public byte[] pre_defined;
    public UnsignedInt next_track_ID;

    public Mvhd_64(int size, String type, InputStream inputStream) throws IOException {
        super(size, type, inputStream);

        creation_time = new UnsignedLong(inputStream);
        modification_time = new UnsignedLong(inputStream);
        timescale = new UnsignedInt(inputStream);
        duration = new UnsignedLong(inputStream);


        UnsignedShort high = new UnsignedShort(inputStream);
        UnsignedShort low = new UnsignedShort(inputStream);
        rate = Float.valueOf(high.toString() + "." + low.toString());

        UnsignedChar volumeHigh = new UnsignedChar(inputStream);
        UnsignedChar volumeLow = new UnsignedChar(inputStream);
        volume = Float.valueOf(volumeHigh.toString() + "." + volumeLow.toString());

        reserved = new byte[10];
        inputStream.read(reserved);

        matrix = new byte[36];
        inputStream.read(matrix);

        pre_defined = new byte[24];
        inputStream.read(pre_defined);

        next_track_ID = new UnsignedInt(inputStream);
    }
}

package com.twolight.mp4parse.box;

import com.twolight.mp4parse.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * @author wangyuehui
 * @date 2018/3/2 上午9:25
 * @description TODO: briefly describe what this file does
 */
public class Mvhd extends FullBox {
    public Unsigned creation_time;
    public Unsigned modification_time;
    public Unsigned timescale;
    public Unsigned duration;
    public float rate;
    public float volume;
    public int reserved = 0;

    public int[] matrix;
    public int pre_defined = 0;
    public UnsignedInt next_track_ID;

    public Mvhd(int size, String type, InputStream inputStream) throws IOException {
        super(size, type, inputStream);

        if(getVersion().getValue().intValue() == 1){
            creation_time = new UnsignedLong(inputStream);
            modification_time = new UnsignedLong(inputStream);
            timescale = new UnsignedLong(inputStream);
            duration = new UnsignedLong(inputStream);
        }else{
            creation_time = new UnsignedInt(inputStream);
            modification_time = new UnsignedInt(inputStream);
            timescale = new UnsignedInt(inputStream);
            duration = new UnsignedInt(inputStream);
        }

        UnsignedShort high = new UnsignedShort(inputStream);
        UnsignedShort low = new UnsignedShort(inputStream);
        rate = Float.valueOf(high.toString() + "." + low.toString());

        UnsignedChar volumeHigh = new UnsignedChar(inputStream);
        UnsignedChar volumeLow = new UnsignedChar(inputStream);
        volume = Float.valueOf(volumeHigh.toString() + "." + volumeLow.toString());

        //reserved 保留位 不读取
        inputStream.skip(10);

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

        // pre_defined 预定义，不读取
        inputStream.skip(24);

        next_track_ID = new UnsignedInt(inputStream);
    }

    @Override
    public String toString() {
        return "Mvhd{" +
                "creation_time=" + creation_time +
                ", modification_time=" + modification_time +
                ", timescale=" + timescale +
                ", duration=" + duration +
                ", rate=" + rate +
                ", volume=" + volume +
                ", reserved=" + reserved +
                ", matrix=" + Arrays.toString(matrix) +
                ", pre_defined=" + pre_defined +
                ", next_track_ID=" + next_track_ID +
                "} " + super.toString();
    }
}

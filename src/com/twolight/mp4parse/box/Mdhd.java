package com.twolight.mp4parse.box;

import com.twolight.mp4parse.Unsigned;
import com.twolight.mp4parse.UnsignedInt;
import com.twolight.mp4parse.UnsignedLong;
import com.twolight.mp4parse.UnsignedShort;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangyuehui
 * @date 2018/3/2 下午2:56
 * @description TODO: briefly describe what this file does
 */
public class Mdhd extends FullBox {
    private Unsigned creation_time;
    private Unsigned modification_time;
    private Unsigned timescale;
    private Unsigned duration;

    private String language;
    private UnsignedShort pre_defined;


    public Mdhd(int size, String type, InputStream inputStream) throws IOException {
        super(size, type, inputStream);

        if(getVersion().getValue().intValue() == 1){
            creation_time = new UnsignedLong(inputStream);
            modification_time = new UnsignedLong(inputStream);
            timescale = new UnsignedInt(inputStream);
            duration = new UnsignedLong(inputStream);
        }else {
            creation_time = new UnsignedInt(inputStream);
            modification_time = new UnsignedInt(inputStream);
            timescale = new UnsignedInt(inputStream);
            duration = new UnsignedInt(inputStream);
        }
        // language
        language = readString(inputStream,2);

        pre_defined = new UnsignedShort(inputStream);
    }
}

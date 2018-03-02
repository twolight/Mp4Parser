package com.twolight.mp4parse.box;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyuehui
 * @date 2018/3/2 上午9:25
 * @description TODO: briefly describe what this file does
 */
public class Ftyp extends Box {
    protected String major_brand;
    protected String minor_version;
    protected List<String> compatible_brands;

    public Ftyp(int size, String type, InputStream inputStream) throws IOException {
        super(size, type);

        major_brand = readString(inputStream, 4);
        minor_version = readString(inputStream, 4);


        compatible_brands = new ArrayList<>();
        int i = size - 16;
        while (i > 0) {
            compatible_brands.add(readString(inputStream, 4));
            i = i - 4;
        }
    }

    @Override
    public String toString() {
        return "Ftyp{" +
                "major_brand='" + major_brand + '\'' +
                ", minor_version='" + minor_version + '\'' +
                ", compatible_brands=" + compatible_brands +
                "} " + super.toString();
    }
}

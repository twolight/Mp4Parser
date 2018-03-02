package com.twolight.mp4parse;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

/**
 * @author wangyuehui
 * @date 2018/3/2 上午11:19
 * @description TODO: briefly describe what this file does
 */
public class Unsigned {
    private BigInteger value;

    public Unsigned(InputStream inputStream,int length) throws IOException {
        byte[] bytes = new byte[length];
        inputStream.read(bytes);
        value = new BigInteger(bytes);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }
}

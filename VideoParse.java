package com.twolight.server.usecase;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangyuehui
 * @date 2018/2/28 上午10:33
 * @description TODO: briefly describe what this file does
 */
public class VideoParse {

    public static int bytesToInt(byte[] des, int offset) {
        int value;
        value = (int) (des[offset] & 0xff
                | ((des[offset + 1] & 0xff) << 8)
                | ((des[offset + 2] & 0xff) << 16)
                | (des[offset + 3] & 0xff) << 24);
        return value;
    }

    public static int bytesToInt2(byte[] src, int offset) {
        int value;
        value = (int) (((src[offset] & 0xFF) << 24)
                | ((src[offset + 1] & 0xFF) << 16)
                | ((src[offset + 2] & 0xFF) << 8)
                | (src[offset + 3] & 0xFF));
        return value;
    }

    public void parseVideo(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("file not exist");
        }

        FileInputStream inputStream = new FileInputStream(file);

        byte[] buffer_8 = new byte[8];
        byte[] buffer_1024 = new byte[1024];

        while (true) {
            int length = inputStream.read(buffer_8);

            if (length == -1) {
                break;
            }

            int size = bytesToInt2(buffer_8, 0);

            if (size == 0) {
                break;
            }

            if (size == 1) {

            }

            String type = new String(Arrays.copyOfRange(buffer_8, 4, 8));

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int need = size - 8;
            while (need > 0) {
                if (need < 1024) {
                    buffer_1024 = new byte[need];
                }

                length = inputStream.read(buffer_1024);
                if (length == -1) {
                    break;
                }

                byteArrayOutputStream.write(buffer_1024, 0, length);

                need = need - length;
            }

            byte[] body = byteArrayOutputStream.toByteArray();

            System.out.println(size);
            System.out.println(type);
            System.out.println("------------------");
        }

        inputStream.close();
    }

    public static void main(String[] args) throws IOException {
        VideoParse videoParse = new VideoParse();
        for (String arg : args) {
            System.out.println(arg);
        }

        videoParse.parseVideo(args[0]);
    }

    static class Box {
        private int size;
        private String type;
        private List<Box> body;
    }
}

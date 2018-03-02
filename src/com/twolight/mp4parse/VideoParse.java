package com.twolight.mp4parse;

import com.twolight.mp4parse.box.Box;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * @author wangyuehui
 * @date 2018/2/28 上午10:33
 * @description TODO: briefly describe what this file does
 */
public class VideoParse {

    public static int bytesToInt(byte[] des, int offset) {
        return (des[offset] & 0xff
                | ((des[offset + 1] & 0xff) << 8)
                | ((des[offset + 2] & 0xff) << 16)
                | (des[offset + 3] & 0xff) << 24);
    }

    public static int bytesToInt2(byte[] src, int offset) {
        return (((src[offset] & 0xFF) << 24)
                | ((src[offset + 1] & 0xFF) << 16)
                | ((src[offset + 2] & 0xFF) << 8)
                | (src[offset + 3] & 0xFF));
    }

    private byte[] buffer_8;
    private byte[] buffer_1024;

    private VideoParse() {
        buffer_8 = new byte[8];
        buffer_1024 = new byte[1024];
    }

    public void parseVideo(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("file not exist");
        }

        FileInputStream inputStream = new FileInputStream(file);

        parseMp4(inputStream);

//        while (true) {
//            int length = inputStream.read(buffer_8);
//
//            if (length == -1) {
//                break;
//            }
//
//            int size = bytesToInt2(buffer_8, 0);
//
//            if (size == 0) {
//                break;
//            }
//
//            if (size == 1) {
//
//            }
//
//            String type = new String(Arrays.copyOfRange(buffer_8, 4, 8));
//
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            int need = size - 8;
//
//            while (need > 0) {
//                if (need < 1024) {
//                    buffer_1024 = new byte[need];
//                }
//
//                length = inputStream.read(buffer_1024);
//                if (length == -1) {
//                    break;
//                }
//
//                byteArrayOutputStream.write(buffer_1024, 0, length);
//
//                need = need - length;
//            }
//
//            byte[] body = byteArrayOutputStream.toByteArray();
//
//            System.out.println(size);
//            System.out.println(type);
//            System.out.println("------------------");
//        }

        inputStream.close();
    }

    public void parseMp4(InputStream inputStream) throws IOException {
        int available = inputStream.available();

        while (available > 0) {
            Box box = parseBox(inputStream);
            available = available - box.getSize();
        }

    }

    public Box parseBox(InputStream inputStream) throws IOException {
        inputStream.read(buffer_8);

        int size = bytesToInt2(buffer_8, 0);

        if (size == 0) {

        }

        if (size == 1) {

        }

        String type = new String(Arrays.copyOfRange(buffer_8, 4, 8));

        Box box = Factor.create(type, size, inputStream);

        System.out.println(box.toString());

        return box;
    }

    public static void main(String[] args) throws IOException {
        VideoParse videoParse = new VideoParse();
        String path = VideoParse.class.getResource("/").getPath();
        System.out.println(path);
        videoParse.parseVideo(path + "1.mp4");
        videoParse.parseVideo(path + "2.mp4");
        videoParse.parseVideo(path + "3.mp4");
    }

}

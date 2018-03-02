package com.twolight.mp4parse;

import com.twolight.mp4parse.box.*;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangyuehui
 * @date 2018/3/2 上午9:28
 * @description TODO: briefly describe what this file does
 */
public class Factor {

    public static Box create(String type, int size, InputStream inputStream) throws IOException {

        Box box;
        switch (type) {
            case "ftyp":
                box = new Ftyp(size, type, inputStream);
                break;
            case "free":
                box = new Free(size, type);
                break;
            case "ctts":
                box = new Ctts(size, type, inputStream);
                break;
            case "mdat":
                box = new Mdat(size, type, inputStream);
                break;
            case "moov":
                box = new Moov(size, type, inputStream);
                break;
            case "mvhd":
                box = new Mvhd(size, type, inputStream);
                break;
            case "stco":
                box = new Stco(size, type, inputStream);
                break;
            case "stsc":
                box = new Stsc(size, type, inputStream);
                break;
            case "stss":
                box = new Stss(size, type, inputStream);
                break;
            case "stsz":
                box = new Stsz(size, type, inputStream);
                break;
            case "stts":
                box = new Stts(size, type, inputStream);
                break;
            case "trak":
                box = new Trak(size, type);
                break;
            case "tkhd":
                box = new Tkhd(size, type, inputStream);
                break;
            case "mdia":
                box = new Mdia(size, type, inputStream);
                break;
            case "mdhd":
                box = new Mdhd(size, type, inputStream);
                break;
            case "hdlr":
                box = new Hdlr(size, type, inputStream);
                break;
            case "minf":
                box = new Minf(size, type, inputStream);
                break;
            case "vmhd":
                box = new Vmhd(size, type, inputStream);
                break;
            case "smhd":
                box = new Smhd(size, type, inputStream);
                break;
            case "dinf":
                box = new Dinf(size, type, inputStream);
                break;
            case "dref":
                box = new Dref(size, type, inputStream);
                break;
            case "url ":
                box = new Url(size, type, inputStream);
                break;
            case "urn ":
                box = new Urn(size, type, inputStream);
                break;
            case "stbl":
                box = new Stbl(size, type, inputStream);
                break;
            case "edts":
                box = new Edts(size, type, inputStream);
                break;
            case "elst":
                box = new Elst(size, type, inputStream);
                break;

            case "stsd":
                box = new Stsd(size, type, inputStream);
                break;

            case "btrt":
                box = new Btrt(size, type, inputStream);
                break;

            case "avc1":
                box = new Avc1(size, type, inputStream);
                break;

            case "mp4a":
                box = new Mp4a(size, type, inputStream);
                break;

            case "udta":
                box = new Udta(size, type, inputStream);
                break;

            case "meta":
                box = new Meta(size, type, inputStream);
                break;

            default:
                throw new RuntimeException("unknown type:" + type);
        }

        return box;
    }
}

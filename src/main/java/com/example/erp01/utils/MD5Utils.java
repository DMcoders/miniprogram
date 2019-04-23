package com.example.erp01.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

/**
 * Created by hujian on 2019/4/21
 */
public class MD5Utils {

    private static Logger logger = LoggerFactory.getLogger(MD5Utils.class);

    public static String EncoderByMd5(String str){
        String newstr = null;
        try {
            MessageDigest md5=MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
         } catch (Exception e) {
            logger.error(e.getMessage(),e);
         }
        return newstr;
    }

    public static void main(String[] args) {
        String MD5_passWord = MD5Utils.EncoderByMd5("1");
        System.out.println(MD5_passWord);
    }
}


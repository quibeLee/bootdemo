package com.liheng.bootdemo.controller;

import org.springframework.stereotype.Controller;

import sun.misc.BASE64Encoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


@Controller
public class TokenProccessor {
    private TokenProccessor(){}
    private static final TokenProccessor instance = new TokenProccessor();

    public static TokenProccessor getInstance(){
        return instance;
    }

    public  String makeToken(){
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999) + "" );
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            byte[] md5 = messageDigest.digest(token.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return null;
    }
}

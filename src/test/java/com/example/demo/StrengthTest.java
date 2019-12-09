package com.example.demo;

import org.junit.Test;
import java.util.regex.Pattern;

public class StrengthTest {

    //非法字符；
    public final static String SEARCHKEYREGEX = "[~!/@#$%^&*()\\-_=+\\|[{}];:\'\",<.>/?]+";

    @Test
    public void testPassWord(){
        String password = "汇123";
        String chinese = "[\u4e00-\u9fa5]|\\s";
        String mix = "^(?![0-9]+$)(?![a-zA-Z]+$)[A-Za-z0-9\\W]{1,}$";

        if(Pattern.matches(chinese,password)||Pattern.matches(SEARCHKEYREGEX,password)){
            System.out.println("error");
            return;
        }
        else{
            System.out.println("correct");
        }
    }
}

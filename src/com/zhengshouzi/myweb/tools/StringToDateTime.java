package com.zhengshouzi.myweb.tools;

import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;

/**
 * Created by ǿ on 2015/9/15.
 */
public class StringToDateTime implements Converter<String, Timestamp> {
    @Override
    public Timestamp convert(String s) {


        System.out.println("convert timestamp");

        return Timestamp.valueOf(s);


    }
}

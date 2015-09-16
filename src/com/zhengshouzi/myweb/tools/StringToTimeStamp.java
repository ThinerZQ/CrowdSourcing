package com.zhengshouzi.myweb.tools;

import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by zhengshouzi on 2015/9/15.
 */
public class StringToTimeStamp implements Converter<String, Timestamp> {
    @Override
    public Timestamp convert(String source) {
        Timestamp timestamp = null;
        System.out.println("convert timestamp");


        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        try {
            timestamp = new Timestamp(format.parse(source).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timestamp;
    }
}

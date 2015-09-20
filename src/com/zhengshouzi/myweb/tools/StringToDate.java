package com.zhengshouzi.myweb.tools;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhengshouzi on 2015/9/15.
 */
public class StringToDate implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        Date date = null;
        System.out.println("convert Date");


        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        try {
            date = format.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}

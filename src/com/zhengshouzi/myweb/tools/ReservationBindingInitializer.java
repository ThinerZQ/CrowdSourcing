package com.zhengshouzi.myweb.tools;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;

/**
 * Created by zhengshouzi on 2015/9/12.
 */
public class ReservationBindingInitializer implements WebBindingInitializer {


    @Override
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);

        SimpleDateFormat datetimeFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        datetimeFormat.setLenient(false);

        webDataBinder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(
                dateFormat, true));
        webDataBinder.registerCustomEditor(java.sql.Timestamp.class,
                new CustomTimestampEditor(datetimeFormat, true));


    }
}

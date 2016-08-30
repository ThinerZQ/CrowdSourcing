package com.sysu.model.crowdsourcing.tools;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhengshouzi on 2015/8/24.
 */
public class RegisterTools {


    public static Date getLastActivateTime(Timestamp registerTime) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(registerTime);
        cl.add(Calendar.DATE, 2);

        return cl.getTime();
    }

}

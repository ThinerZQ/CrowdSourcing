package com.sysu.model.crowdsourcing.exceptions;

import java.io.Serializable;

/**
 * Created by zhengshouzi on 2015/8/24.
 */

public class ServiceException extends Exception implements Serializable {


    public ServiceException(String message) {
        super(message);
    }
}
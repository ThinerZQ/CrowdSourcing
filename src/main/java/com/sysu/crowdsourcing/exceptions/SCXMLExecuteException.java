package com.sysu.crowdsourcing.exceptions;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/19
 * Time: 10:40
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class SCXMLExecuteException extends Exception implements Serializable {

    public SCXMLExecuteException(String message) {
        super(message);
    }
}

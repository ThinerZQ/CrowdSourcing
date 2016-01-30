package com.sysu.workflow.service.formservice;

import com.sysu.workflow.entity.FormEntity;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/30
 * Time: 19:30
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
public interface FormDao {
     ArrayList<FormEntity> findForm(FormEntity formEntity);
}

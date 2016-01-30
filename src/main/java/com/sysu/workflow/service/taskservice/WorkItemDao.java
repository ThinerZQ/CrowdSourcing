package com.sysu.workflow.service.taskservice;


import com.sysu.workflow.entity.GroupWorkItemEntity;
import com.sysu.workflow.entity.UserWorkItemEntity;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Date: 2015/12/16
 * Time: 13:16
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
public interface WorkItemDao {


    long insertIntoWorkItem(UserWorkItemEntity workItemEntity);

    long insertIntoWorkItem(GroupWorkItemEntity workItemEntity);

    ArrayList<UserWorkItemEntity> findUserWorkItem(UserWorkItemEntity userWorkItemEntity);

    ArrayList<GroupWorkItemEntity> findGroupWorkItem(GroupWorkItemEntity groupWorkItemEntity);

    boolean updateUserWorkItem(UserWorkItemEntity userWorkItemEntity);

    boolean updateGroupWorkItem(GroupWorkItemEntity groupWorkItemEntity);
}

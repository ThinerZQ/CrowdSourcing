package com.sysu.workflow.service.taskservice;


import com.sysu.persistence.model.workflow.UserEntity;
import com.sysu.persistence.model.workflow.UserWorkItemEntity;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/20
 * Time: 15:06
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
public class UserTaskQuery {
    private UserWorkItemEntity userWorkItemEntity = null;
    private WorkItemDao workItemDao = null;

    public UserTaskQuery(UserWorkItemEntity workItemEntity) {
        this.userWorkItemEntity = workItemEntity;
    }

    public UserTaskQuery() {
        userWorkItemEntity = new UserWorkItemEntity();
    }

    public com.sysu.workflow.service.taskservice.UserTaskQuery taskName(String taskName) {
        userWorkItemEntity.setItemName(taskName);
        return this;
    }

    public com.sysu.workflow.service.taskservice.UserTaskQuery taskId(int taskId) {
        userWorkItemEntity.setItemId(taskId);
        return this;
    }

    public com.sysu.workflow.service.taskservice.UserTaskQuery taskFinish(String itemFinish) {
        userWorkItemEntity.setItemFinish(itemFinish);
        return this;
    }

    public com.sysu.workflow.service.taskservice.UserTaskQuery taskProcessInstanceId(String taskProcessInstanceId) {
        userWorkItemEntity.setItemProcessId(taskProcessInstanceId);
        return this;
    }

    public com.sysu.workflow.service.taskservice.UserTaskQuery taskStateId(String taskStateId) {
        userWorkItemEntity.setItemStateId(taskStateId);
        return this;
    }

    public com.sysu.workflow.service.taskservice.UserTaskQuery taskAssignee(UserEntity userEntity) {
        userWorkItemEntity.setItemAssigneeEntity(userEntity);
        return this;
    }

    public UserWorkItemEntity SingleResult() {
        if (workItemDao == null) {
            workItemDao = new WorkItemDao();
        }
        ArrayList<UserWorkItemEntity> arrayList = workItemDao.findUserWorkItem(userWorkItemEntity);
        int size = arrayList.size();
        return size >= 1 ? arrayList.get(0) : null;
    }

    public ArrayList<UserWorkItemEntity> list() {
        if (workItemDao == null) {
            workItemDao = new WorkItemDao();
        }

        return workItemDao.findUserWorkItem(userWorkItemEntity);
    }
}

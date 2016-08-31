package com.sysu.workflow.service.taskservice;

import com.sysu.model.WorkflowEntity;
import com.sysu.model.workflow.GroupEntity;
import com.sysu.model.workflow.GroupWorkItemEntity;
import com.sysu.model.workflow.UserEntity;
import com.sysu.model.workflow.UserWorkItemEntity;
import com.sysu.workflow.model.extend.GroupException;
import com.sysu.workflow.model.extend.UserException;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/18
 * Time: 20:53
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
public class TaskDispatcher {

    private static com.sysu.workflow.service.taskservice.TaskDispatcher taskDispatcher;
    private TaskService taskService = null;


    public static com.sysu.workflow.service.taskservice.TaskDispatcher newInstance() {
        return taskDispatcher == null ? new com.sysu.workflow.service.taskservice.TaskDispatcher() : taskDispatcher;
    }


    public long dispatchUserTask(UserWorkItemEntity userWorkItemEntity) throws UserException {

        return taskService.saveUserWorkItem(userWorkItemEntity);
    }

    public long dispatchGroupTask(GroupWorkItemEntity groupWorkItemEntity) throws GroupException {

        return taskService.saveGroupWorkItem(groupWorkItemEntity);

    }

    public long dispatchTask(WorkflowEntity workItemEntity, WorkflowEntity resourceEntity) {
        long id = -1;
        if (taskService == null) {
            taskService = new TaskService();
        }

        try {
            if (resourceEntity == null) {
                throw new GroupException("no resource: " + resourceEntity.getNotNullPropertyMap());
            }
            if (workItemEntity instanceof GroupWorkItemEntity && resourceEntity instanceof GroupEntity) {
                GroupWorkItemEntity groupWorkItemEntity = (GroupWorkItemEntity) workItemEntity;
                GroupEntity groupEntity = (GroupEntity) resourceEntity;
                groupWorkItemEntity.setItemCandidateGroupEntity(groupEntity);
                return dispatchGroupTask(groupWorkItemEntity);

            } else if (workItemEntity instanceof UserWorkItemEntity && resourceEntity instanceof UserEntity) {

                UserWorkItemEntity userWorkItemEntity = (UserWorkItemEntity) workItemEntity;
                UserEntity userEntity = (UserEntity) resourceEntity;
                userWorkItemEntity.setItemAssigneeEntity(userEntity);

                return dispatchUserTask(userWorkItemEntity);

            } else {
                System.out.println("the task dispatch type is not support");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

}
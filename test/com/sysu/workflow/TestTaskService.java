package com.sysu.workflow;

import com.sysu.workflow.entity.GroupEntity;
import com.sysu.workflow.entity.GroupWorkItemEntity;
import com.sysu.workflow.entity.UserEntity;
import com.sysu.workflow.entity.UserWorkItemEntity;
import com.sysu.workflow.service.identityservice.IdentityService;
import com.sysu.workflow.service.taskservice.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/20
 * Time: 16:58
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
@TransactionConfiguration
public class TestTaskService extends AbstractJUnit4SpringContextTests {

    @Resource(name = "taskService")
    TaskService taskService;

    @Resource(name = "identityService")
    IdentityService identityService;

    @Before
    public void before() {

    }

    @Test
    public void testFindTask() {
      /*  GroupEntity groupEntity = IdentityService.createGroupQuery().groupName("Judger").SingleResult();
        ArrayList<GroupWorkItemEntity> groupWorkItemEntityArrayList = TaskService.createGroupTaskQuery().taskCandidateGroup(groupEntity).list();



        System.out.println(groupWorkItemEntityArrayList.get(0).getItemFormEntity().getFormItemEntityLinkedHashSet().size());
    */
    }

    @Test
    public void findGroupTaskByUser() {

       /* UserEntity currentUserEntity  = IdentityService.createUserQuery().userRealName("judger1").SingleResult();

        ArrayList<UserWorkItemEntity> userWorkItemEntityList = TaskService.createUserTaskQuery().taskAssignee(currentUserEntity).list();

        Map<GroupEntity, ArrayList<GroupWorkItemEntity>> groupWorkItemArrayListMap = new LinkedHashMap<GroupEntity, ArrayList<GroupWorkItemEntity>>();
        //得到当前用户所在组的所有工作项
        for (GroupEntity groupEntity : currentUserEntity.getGroupEntitySet()) {
            ArrayList<GroupWorkItemEntity> groupWorkItemEntityArrayList = TaskService.createGroupTaskQuery().taskCandidateGroup(groupEntity).list();
            //当前组有任务，就加入到map里面
            if (groupWorkItemEntityArrayList.size() != 0) {
                groupWorkItemArrayListMap.put(groupEntity, groupWorkItemEntityArrayList);
            }
        }*/


    }

    @Test
    public void findUserTaskByUser() {

        UserEntity currentUserEntity = identityService.createUserQuery().userRealName("judger1").SingleResult();

        ArrayList<UserWorkItemEntity> userWorkItemEntityList = taskService.createUserTaskQuery().taskAssignee(currentUserEntity).list();

        Map<GroupEntity, ArrayList<GroupWorkItemEntity>> groupWorkItemArrayListMap = new LinkedHashMap<GroupEntity, ArrayList<GroupWorkItemEntity>>();
        //得到当前用户所在组的所有工作项
        long groupWorkItemId = 0;
        for (GroupEntity groupEntity : currentUserEntity.getGroupEntitySet()) {
            ArrayList<GroupWorkItemEntity> groupWorkItemEntityArrayList = taskService.createGroupTaskQuery().taskCandidateGroup(groupEntity).list();
            //当前组有任务，就加入到map里面
            if (groupWorkItemEntityArrayList.size() != 0) {
                groupWorkItemArrayListMap.put(groupEntity, groupWorkItemEntityArrayList);
            }
            groupWorkItemId = groupWorkItemEntityArrayList.get(0).getItemId();
        }


        if (groupWorkItemId != 0) {
            GroupWorkItemEntity groupWorkItemEntity = taskService.createGroupTaskQuery().taskId((int) groupWorkItemId).SingleResult();
            //更新group workitem
            int instance;
            instance = groupWorkItemEntity.getItemInstances();
            if (groupWorkItemEntity.getItemInstances() <= 0) {
                //返回，提示组任务被做完了。
                System.out.println("group work done ");
            } else {

                UserWorkItemEntity userWorkItemEntity = taskService.newWorkItem();
                //保存user workitem
                userWorkItemEntity.setItemName(groupWorkItemEntity.getItemName())
                        .setItemCreateTime(new Date().toLocaleString())
                        .setItemStateId(groupWorkItemEntity.getItemStateId())
                        .setItemProcessId(groupWorkItemEntity.getItemProcessId())
                        .setItemAssigneeEntity(currentUserEntity)
                        .setItemFormEntity(groupWorkItemEntity.getItemFormEntity())
                        .setItemGroupWorkItemEntity(groupWorkItemEntity);

                taskService.saveUserWorkItem(userWorkItemEntity);

                instance = groupWorkItemEntity.getItemInstances() - 1;
                groupWorkItemEntity.setItemInstances(instance);
                taskService.updateGroupWorkItem(groupWorkItemEntity);
            }
        }

    }

}

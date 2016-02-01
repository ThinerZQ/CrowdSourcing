package com.sysu.crowdsourcing;

import com.sysu.workflow.entity.GroupEntity;
import com.sysu.workflow.entity.UserEntity;
import com.sysu.workflow.service.indentityservice.IdentityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/18
 * Time: 16:47
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
@TransactionConfiguration
public class DataTest extends AbstractJUnit4SpringContextTests {
   /* @Resource(name = "identityService")
    IdentityService identityService;
*/

    @Test
    public void testAddUserAndGroup() {
        IdentityService identityService = new IdentityService();
        //添加管理员
        UserEntity userEntity = identityService.newUser("admin");
        userEntity.setUserPassword("123456")
                .setUserName("admin")
                .setUserAge("23")
                .setUserEmail("admin@qq.com")
                .setUserGender("man")
                .setUserStatus("1")
                .setUserRegisterDate(new Date());
        identityService.saveUser(userEntity);

        //添加发布者
        UserEntity userEntity1 = identityService.newUser("poster");
        userEntity.setUserPassword("123456")
                .setUserName("poster")
                .setUserAge("23")
                .setUserEmail("poster@qq.com")
                .setUserGender("man")
                .setUserStatus("1")
                .setUserRegisterDate(new Date());
        identityService.saveUser(userEntity);

        //添加用户对应的组
        GroupEntity judgerGroupEntity = identityService.newGroup("Judger");
        GroupEntity decomposerGroupEntity1 = identityService.newGroup("Decomposer");
        GroupEntity decomposeVoterGroupEntity2 = identityService.newGroup("DecomposeVoter");
        GroupEntity solverGroupEntity3 = identityService.newGroup("Solver");
        GroupEntity solveVoterGroupEntity4 = identityService.newGroup("SolveVoter");

        identityService.saveGroup(judgerGroupEntity);
        identityService.saveGroup(decomposerGroupEntity1);
        identityService.saveGroup(decomposeVoterGroupEntity2);
        identityService.saveGroup(solverGroupEntity3);
        identityService.saveGroup(solveVoterGroupEntity4);


        //添加判断人3个
        for (int i = 1; i <= 3; i++) {
            Set groupSet = new HashSet<GroupEntity>();
            groupSet.add(judgerGroupEntity);
            userEntity = identityService.newUser();
            userEntity.setUserRealName("judger" + i)
                    .setUserPassword("judger" + i)
                    .setUserName("judger" + i)
                    .setUserAge("23")
                    .setUserEmail("judger" + i + "@qq.com")
                    .setUserGender("man")
                    .setUserStatus("1")
                    .setUserRegisterDate(new Date())
                    .setGroupEntitySet(groupSet);
            identityService.saveUser(userEntity);
        }
        //添加分解者2个
        for (int i = 1; i <= 2; i++) {
            Set groupSet = new HashSet<GroupEntity>();
            groupSet.add(decomposerGroupEntity1);
            userEntity = identityService.newUser();
            userEntity.setUserRealName("decomposer" + i)
                    .setUserPassword("decomposer" + i)
                    .setUserName("decomposer" + i)
                    .setUserAge("23")
                    .setUserEmail("decomposer" + i + "@qq.com")
                    .setUserGender("man")
                    .setUserStatus("1")
                    .setUserRegisterDate(new Date())
                    .setGroupEntitySet(groupSet);
            identityService.saveUser(userEntity);
        }
        //添加分解投票者3个
        for (int i = 1; i <= 3; i++) {
            Set groupSet = new HashSet<GroupEntity>();
            groupSet.add(decomposeVoterGroupEntity2);
            userEntity = identityService.newUser();
            userEntity.setUserRealName("decomposeVoter" + i)
                    .setUserPassword("decomposeVoter" + i)
                    .setUserName("decomposeVoter" + i)
                    .setUserAge("23")
                    .setUserEmail("decomposeVoter" + i + "@qq.com")
                    .setUserGender("man")
                    .setUserStatus("1")
                    .setUserRegisterDate(new Date())
                    .setGroupEntitySet(groupSet);
            identityService.saveUser(userEntity);
        }
        //添加解决者2个
        for (int i = 1; i <= 2; i++) {
            Set groupSet = new HashSet<GroupEntity>();
            groupSet.add(solverGroupEntity3);
            userEntity = identityService.newUser();
            userEntity.setUserRealName("solver" + i)
                    .setUserPassword("solver" + i)
                    .setUserName("solver" + i)
                    .setUserAge("23")
                    .setUserEmail("solver" + i + "@qq.com")
                    .setUserGender("man")
                    .setUserStatus("1")
                    .setUserRegisterDate(new Date())
                    .setGroupEntitySet(groupSet);
            identityService.saveUser(userEntity);
        }
        //添加解决投票者3个
        for (int i = 1; i <= 3; i++) {
            Set groupSet = new HashSet<GroupEntity>();
            groupSet.add(solveVoterGroupEntity4);
            userEntity = identityService.newUser();
            userEntity.setUserRealName("solveVoter" + i)
                    .setUserPassword("solveVoter" + i)
                    .setUserName("solveVoter" + i)
                    .setUserAge("23")
                    .setUserEmail("solveVoter" + i + "@qq.com")
                    .setUserGender("man")
                    .setUserStatus("1")
                    .setUserRegisterDate(new Date())
                    .setGroupEntitySet(groupSet);
            identityService.saveUser(userEntity);
        }
    }

    @Test
    public void testAddGroup() {

    }
}

package com.zhengshouzi.myweb.daoimpl;

import com.zhengshouzi.myweb.dao.JudgeTaskDao;
import com.zhengshouzi.myweb.dao.TaskDao;
import com.zhengshouzi.myweb.entity.JudgetaskEntity;
import com.zhengshouzi.myweb.entity.TaskEntity;
import com.zhengshouzi.myweb.entity.UserEntity;
import com.zhengshouzi.myweb.tools.ConstantDefine;
import com.zhengshouzi.myweb.tools.DBHelper;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public class TaskDaoImpl implements TaskDao {


    @Resource(name = "judgeTaskDao")
    JudgeTaskDao judgeTaskDao;



    @Override
    public boolean addTask(TaskEntity taskEntity) {
        boolean b = false;
        Connection connection = DBHelper.getMySqlConnection();
        PreparedStatement ps = null;
        //添加根任务
        String sql = "INSERT INTO task (title,releaseTime,deadlineTime,completeTime) VALUES(?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, taskEntity.getTitle());
            ps.setTimestamp(2, taskEntity.getReleaseTime());
            ps.setTimestamp(2,taskEntity.getDeadlineTime());
            ps.setTimestamp(2,taskEntity.getCompleteTime());

            if (ps.executeUpdate() == 1)
                b = true;

            //为每个根任务，添加判断任务
            for(int i=0;i< ConstantDefine.JudgeNumber;i++){

            }
            //添加task 和 judgeTask 的依赖关系
            for (int i=0;i<ConstantDefine.JudgeNumber;i++){

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection, ps, null);
        }
        return b;
    }

    @Override
    public ArrayList<TaskEntity> findAllTask() {
        return null;
    }

    @Override
    public boolean deleteTask(TaskEntity taskEntity) {
        return false;
    }

    @Override
    public boolean updateUser(UserEntity userEntity) {
        return false;
    }

    @Override
    public TaskEntity findTaskById(String id) {

        Connection connection = DBHelper.getMySqlConnection();
        PreparedStatement ps = null;
        TaskEntity task =null;
        ResultSet rs = null;

        String sql = "select * from task where id=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));

            rs= ps.executeQuery();
            while (rs.next()){
                task =new TaskEntity();
                task.setId(rs.getInt("id"));

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection, ps, null);
        }
        return task;
    }

    //关闭连接
    public void close(Connection cn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (cn != null) {
                cn.close();
                ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.sysu.crowdsourcing.dao.impl.jdbc;


import com.sysu.crowdsourcing.dao.TaskDao;
import com.sysu.crowdsourcing.entity.TaskEntity;
import com.sysu.crowdsourcing.tools.ConstantDefine;
import com.sysu.crowdsourcing.tools.DBHelper;
import com.sysu.workflow.service.indentityservice.WorkItemEntity;
import org.hibernate.Criteria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public class TaskDaoImpl implements TaskDao {



    public boolean addTask(TaskEntity taskEntity) {
        boolean b = false;
        Connection connection = DBHelper.getMySqlConnection();
        PreparedStatement ps = null;
        //添加根任务
        String sql = "INSERT INTO task (title,releaseTime,deadlineTime,completeTime) VALUES(?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, taskEntity.getTaskName());
            //ps.setTimestamp(2, taskEntity.getReleaseTime());
//.setTimestamp(3, taskEntity.getDeadlineTime());
            // ps.setTimestamp(4, taskEntity.getCompleteTime());

            if (ps.executeUpdate() == 1)
                b = true;

            //为每个根任务，添加判断任务
            for (int i = 0; i < ConstantDefine.JudgeNumber; i++) {

            }
            //添加task 和 judgeTask 的依赖关系
            for (int i = 0; i < ConstantDefine.JudgeNumber; i++) {

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection, ps, null);
        }
        return b;
    }


    public boolean deleteTaskById(String task_id) {
        return false;
    }


    public boolean updateTask(TaskEntity taskEntity) {
        return false;
    }


    public ArrayList<TaskEntity> findAllTask() {
        return null;
    }


    public TaskEntity findTaskById(String id) {

        Connection connection = DBHelper.getMySqlConnection();
        PreparedStatement ps = null;
        TaskEntity task = null;
        ResultSet rs = null;

        String sql = "select * from task where id=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));

            rs = ps.executeQuery();
            while (rs.next()) {
                task = new TaskEntity();
                task.setTaskId(rs.getInt("id"));

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection, ps, null);
        }
        return task;
    }


    public List<TaskEntity> findTaskByCriteria(Criteria criteria) {
        return null;
    }

    public List<WorkItemEntity> findAllWorkitem() {
        return null;
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

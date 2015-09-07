package com.zhengshouzi.myweb.daoimpl;

import com.zhengshouzi.myweb.beans.JudgeTask;
import com.zhengshouzi.myweb.beans.Task;
import com.zhengshouzi.myweb.beans.User;
import com.zhengshouzi.myweb.dao.JudgeTaskDao;
import com.zhengshouzi.myweb.dao.TaskDao;
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
    public boolean addTask(Task task) {
        boolean b = false;
        Connection connection = DBHelper.getMySqlConnection();
        PreparedStatement ps = null;
        //添加根任务
        String sql = "INSERT INTO task (title,releaseTime,deadlineTime,completeTime) VALUES(?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, task.getTitle());
            ps.setTimestamp(2, task.getReleaseTime());
            ps.setTimestamp(2,task.getDeadlineTime());
            ps.setTimestamp(2,task.getCompleteTime());

            if (ps.executeUpdate() == 1)
                b = true;

            //为每个根任务，添加判断任务
            for(int i=0;i< ConstantDefine.JudgeNumber;i++){
                JudgeTask judgeTask = new JudgeTask();
                judgeTask.setReleaseTime(task.getReleaseTime());
                judgeTaskDao.addJudgeTask(judgeTask);
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
    public ArrayList<Task> findAllTask() {
        return null;
    }

    @Override
    public boolean deleteTask(Task task) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public Task findTaskById(String id) {

        Connection connection = DBHelper.getMySqlConnection();
        PreparedStatement ps = null;
        Task task =null;
        ResultSet rs = null;

        String sql = "select * from task where id=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));

            rs= ps.executeQuery();
            while (rs.next()){
                task =new Task();
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

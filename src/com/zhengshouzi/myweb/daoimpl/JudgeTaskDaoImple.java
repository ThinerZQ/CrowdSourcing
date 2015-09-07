package com.zhengshouzi.myweb.daoimpl;

import com.zhengshouzi.myweb.beans.JudgeTask;
import com.zhengshouzi.myweb.beans.Task;
import com.zhengshouzi.myweb.dao.JudgeTaskDao;
import com.zhengshouzi.myweb.dao.TaskDao;
import com.zhengshouzi.myweb.tools.DBHelper;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public class JudgeTaskDaoImple implements JudgeTaskDao {

    @Resource(name = "taskDao")
    TaskDao taskDao;

    @Override
    public boolean addJudgeTask(JudgeTask judgeTask) {
        boolean b = false;
        Connection connection = DBHelper.getMySqlConnection();
        PreparedStatement ps = null;
        //添加任务
        String sql = "INSERT INTO judgetask (simple,releaseTime,deadlineTime,completeTime) VALUES(?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,judgeTask.getSimple());
            ps.setTimestamp(2,judgeTask.getReleaseTime());
            ps.setTimestamp(2,judgeTask.getDeadlineTime());
            ps.setTimestamp(2,judgeTask.getCompleteTime());

            if (ps.executeUpdate() == 1)
                b = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection, ps, null);
        }
        return b;
    }

    @Override
    public ArrayList<JudgeTask> findAllJudgeTask() {

        ArrayList<JudgeTask> judgeTasks = new ArrayList<>();

        Connection connection = DBHelper.getMySqlConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //查找所有的judgeTask
        String sql = "SELECT * from judgetask ";
        try {
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();
            while(rs.next()){
                JudgeTask judgeTask = new JudgeTask();
                judgeTask.setId(rs.getInt("id"));
                judgeTask.setSimple(rs.getString("simple"));
                judgeTask.setReleaseTime(rs.getTimestamp("releaseTime"));
                judgeTask.setDeadlineTime(rs.getTimestamp("deadlineTime"));
                judgeTask.setCompleteTime(rs.getTimestamp("completeTime"));

                //Task task = taskDao.findTaskById();
                //judgeTask.setTask(task);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection, ps, null);
        }
        return judgeTasks;




    }

    @Override
    public boolean deleteJudgeTask(JudgeTask judgeTask) {
        return false;
    }

    @Override
    public boolean updateJudgeUser(JudgeTask judgeTask) {
        return false;
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

package com.zhengshouzi.myweb.dao.impl.jdbc;

import com.zhengshouzi.myweb.dao.JudgeTaskDao;
import com.zhengshouzi.myweb.dao.TaskDao;
import com.zhengshouzi.myweb.entity.TaskEntity;
import com.zhengshouzi.myweb.tools.ConstantDefine;
import com.zhengshouzi.myweb.tools.DBHelper;
import org.hibernate.Criteria;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
        //���Ӹ�����
        String sql = "INSERT INTO task (title,releaseTime,deadlineTime,completeTime) VALUES(?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, taskEntity.getTitle());
            //ps.setTimestamp(2, taskEntity.getReleaseTime());
//.setTimestamp(3, taskEntity.getDeadlineTime());
            // ps.setTimestamp(4, taskEntity.getCompleteTime());

            if (ps.executeUpdate() == 1)
                b = true;

            //Ϊÿ�������������ж�����
            for (int i = 0; i < ConstantDefine.JudgeNumber; i++) {

            }
            //����task �� judgeTask ��������ϵ
            for (int i = 0; i < ConstantDefine.JudgeNumber; i++) {

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection, ps, null);
        }
        return b;
    }

    @Override
    public boolean deleteTaskById(String task_id) {
        return false;
    }

    @Override
    public boolean updateTask(TaskEntity taskEntity) {
        return false;
    }

    @Override
    public ArrayList<TaskEntity> findAllTask() {
        return null;
    }

    @Override
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
                task.setId(rs.getInt("id"));

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection, ps, null);
        }
        return task;
    }

    @Override
    public List<TaskEntity> findTaskByCriteria(Criteria criteria) {
        return null;
    }

    //�ر�����
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
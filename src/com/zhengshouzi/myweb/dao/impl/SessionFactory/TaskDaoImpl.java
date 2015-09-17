package com.zhengshouzi.myweb.dao.impl.SessionFactory;

import com.zhengshouzi.myweb.dao.JudgeTaskDao;
import com.zhengshouzi.myweb.dao.TaskDao;
import com.zhengshouzi.myweb.entity.TaskEntity;
import com.zhengshouzi.myweb.entity.UserEntity;
import com.zhengshouzi.myweb.tools.DBHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
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

    @Resource(name = "sessionFactory")
    SessionFactory sessionFactory;


    @Transactional
    @Override
    public boolean addTask(TaskEntity taskEntity) {

        Session session = sessionFactory.getCurrentSession();

        Serializable id = (Serializable) session.save(taskEntity);

        if (id != 0 || id != null) {
            return true;
        }
        return false;
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

    //πÿ±’¡¨Ω”
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

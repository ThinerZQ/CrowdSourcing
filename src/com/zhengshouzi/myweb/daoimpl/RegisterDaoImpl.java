package com.zhengshouzi.myweb.daoimpl;

import com.zhengshouzi.myweb.dao.RegisterDao;
import com.zhengshouzi.myweb.forms.RegisterForm;
import com.zhengshouzi.myweb.tools.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by zhengshouzi on 2015/8/24.
 */
public class RegisterDaoImpl implements RegisterDao {

    /*
    @Resource(name = "dbHelper")
    DBHelper dbHelper;
    */
    @Override
    public boolean register(RegisterForm registerForm) {

        boolean b = false;
        Connection connection = DBHelper.getMySqlConnection();
        PreparedStatement ps = null;
        //开始注册
        String sql = "INSERT INTO user_register_table(email,password,activatecode,status,registerdate) VALUES(?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, registerForm.getEmail());
            ps.setString(2, registerForm.getPassword());
            ps.setString(3, registerForm.getActivatecode());
            ps.setString(4, registerForm.getStatus());
            ps.setTimestamp(5, registerForm.getRegisterTime());
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
    public RegisterForm findByEmail(String email) {

        Connection connection = DBHelper.getMySqlConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        RegisterForm registerForm = null;
        String sql = "select * from user_register_table where email= ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                registerForm = new RegisterForm();
                registerForm.setEmail(rs.getString("email"));
                registerForm.setPassword(rs.getString("password"));
                registerForm.setActivatecode(rs.getString("activatecode"));
                registerForm.setStatus(rs.getString("status"));
                registerForm.setRegisterTime(rs.getTimestamp("registerdate"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection, ps, rs);
        }
        return registerForm;
    }

    @Override
    public boolean updateRegisterStatus(String email, String status) {
        boolean b = false;
        Connection connection = DBHelper.getMySqlConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE user_register_table SET status=? where email=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, status);
            ps.setString(2, email);
            if (ps.executeUpdate() == 1) {
                b = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection, ps, null);
        }
        return b;
    }

    public boolean deleteRegisterByEmail(String Email) {
        boolean b = false;
        Connection connection = DBHelper.getMySqlConnection();
        PreparedStatement ps = null;
        String sql = "DELETE FROM user_register_table where email=?";
        try {
            ps = connection.prepareStatement(sql);

            ps.setString(1, Email);
            if (ps.executeUpdate() == 1) {
                b = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection, ps, null);
        }
        return b;
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

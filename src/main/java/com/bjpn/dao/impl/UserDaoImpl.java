package com.bjpn.dao.impl;

import com.bjpn.bean.User;
import com.bjpn.dao.UserDao;
import com.bjpn.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    @Override
    public User loginUser(String userCode, String userPwd) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql = "select * from yonghu where usercode = ? and userpwd = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, userCode);
            pstm.setString(2, userPwd);
            resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userid"));
                user.setUserCode(resultSet.getString("usercode"));
                user.setUserPwd(resultSet.getString("userpwd"));
                user.setUserName(resultSet.getString("username"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePsta(pstm);
            DBUtil.closeConn(conn);
        }
        return null;
    }
}

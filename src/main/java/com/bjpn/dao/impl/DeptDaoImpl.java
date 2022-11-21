package com.bjpn.dao.impl;

import com.bjpn.bean.Dept;
import com.bjpn.dao.DeptDao;
import com.bjpn.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {


    public List<Dept> selectAllDept(Connection conn) {
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql = "select * from dept";
            pstm = conn.prepareStatement(sql);
            resultSet = pstm.executeQuery();
            List<Dept> list = new ArrayList<Dept>();

            while(resultSet.next()) {
                Dept dept = new Dept();
                dept.setDeptLoc(resultSet.getString("dept_loc"));
                dept.setDeptName(resultSet.getString("dept_name"));
                dept.setDeptNo(resultSet.getInt("dept_no"));
                list.add(dept);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePsta(pstm);
        }
        return null;
    }

}

package com.bjpn.dao.impl;

import com.bjpn.bean.Emp;
import com.bjpn.dao.EmpDao;
import com.bjpn.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    //添加员工

    public Boolean addEmp(Connection conn, Emp emp) {
        PreparedStatement pstm = null;
        try {
            String sql = "insert into emp(emp_name, emp_job, emp_photo, emp_hiredate, emp_sal, dept_no) value (?,?,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, emp.getEmpName());
            pstm.setString(2, emp.getEmpJob());
            pstm.setString(3, emp.getEmpPhoto());
            pstm.setString(4, emp.getEmpHiredate());
            pstm.setDouble(5, emp.getEmpSal());
            pstm.setInt(6, emp.getDeptNo());
            int i = pstm.executeUpdate();
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.closePsta(pstm);
        }
        return false;
    }

    //查询所有员工

    public List<Emp> selectAllEmp() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql = "select * from emp";
            pstm = conn.prepareStatement(sql);
            resultSet = pstm.executeQuery();
            List<Emp> list = new ArrayList<Emp>();

            while(resultSet.next()) {
                Emp emp = new Emp();
                emp.setEmpNo(resultSet.getInt("emp_no"));
                emp.setEmpName(resultSet.getString("emp_name"));
                emp.setEmpJob(resultSet.getString("emp_job"));
                emp.setEmpPhoto(resultSet.getString("emp_photo"));
                emp.setEmpHiredate(resultSet.getString("emp_hiredate"));
                emp.setEmpSal(resultSet.getDouble("emp_sal"));
                emp.setDeptNo(resultSet.getInt("dept_no"));
                list.add(emp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePsta(pstm);
            DBUtil.closeConn(conn);
        }
        return null;
    }

    @Override
    public Emp selectEmpByEmpNo(int empNo) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql = "select emp_no,emp_name, emp_job, emp_photo, emp_hiredate, emp_sal, dept_no from emp where emp_no = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, empNo);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Emp emp = new Emp();
                emp.setEmpNo(resultSet.getInt("emp_no"));
                emp.setEmpName(resultSet.getString("emp_name"));
                emp.setEmpJob(resultSet.getString("emp_job"));
                emp.setEmpPhoto(resultSet.getString("emp_photo"));
                emp.setEmpHiredate(resultSet.getString("emp_hiredate"));
                emp.setEmpSal(resultSet.getDouble("emp_sal"));
                emp.setDeptNo(resultSet.getInt("dept_no"));
                return emp;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePsta(preparedStatement);
            DBUtil.closeConn(conn);
        }
        return null;
    }
//更新员工信息
    @Override
    public Boolean updateEmp(Connection conn, Emp emp) {
        PreparedStatement pstm = null;
        try {
            String sql = "update emp set emp_name = ?,emp_job=?,emp_hiredate=?,emp_sal=?,emp_photo=?,dept_no=? where emp_no=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, emp.getEmpName());
            pstm.setString(2, emp.getEmpJob());
            pstm.setString(3, emp.getEmpHiredate());
            pstm.setDouble(4, emp.getEmpSal());
            pstm.setString(5, emp.getEmpPhoto());
            pstm.setInt(6, emp.getDeptNo());
            pstm.setInt(7, emp.getEmpNo());
            int i = pstm.executeUpdate();
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.closePsta(pstm);
        }
        return false;
    }


}

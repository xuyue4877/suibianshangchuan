package com.bjpn.dao;

import com.bjpn.bean.Emp;
import com.bjpn.bean.User;

import java.sql.Connection;
import java.util.List;

public interface EmpDao {
    //添加员工
    Boolean addEmp(Connection conn, Emp emp);

    //查看所有员工
    List<Emp> selectAllEmp();

    Emp selectEmpByEmpNo(int empNo);

    Boolean updateEmp(Connection conn ,Emp emp);

}

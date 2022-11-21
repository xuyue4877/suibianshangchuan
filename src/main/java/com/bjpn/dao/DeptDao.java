package com.bjpn.dao;

import com.bjpn.bean.Dept;

import java.sql.Connection;
import java.util.List;

public interface DeptDao {
    List<Dept> selectAllDept(Connection conn);
}

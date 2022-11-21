package com.bjpn.service.impl;

import com.bjpn.bean.Dept;
import com.bjpn.dao.DeptDao;
import com.bjpn.dao.impl.DeptDaoImpl;
import com.bjpn.service.DeptService;
import com.bjpn.util.DBUtil;

import java.sql.Connection;
import java.util.List;

public class DeptServiceImpl implements DeptService {
    DeptDao deptDao = new DeptDaoImpl();

    @Override
    public List<Dept> findAllDeptService() {
        Connection conn = null;
        try{
            conn = DBUtil.getConn();
            List<Dept> deptList = deptDao.selectAllDept(conn);
            return deptList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn);
        }
        return null;
    }

}

package com.bjpn.service;

import com.bjpn.bean.Emp;
import com.bjpn.bean.User;

import java.util.List;

public interface EmpService {
    Boolean addEmpService(Emp emp);

    //查询所有员工
    List<Emp> selectAllEmp();

    //删除员工
    boolean delEmp(int num);

    //根据员工编号查询
    Emp selectEmpByEmpNo(int empNo);

    //修改员工信息
    Boolean updateEmp(Emp emp);

}

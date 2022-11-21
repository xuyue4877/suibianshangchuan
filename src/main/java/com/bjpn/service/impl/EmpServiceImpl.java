package com.bjpn.service.impl;

import com.bjpn.bean.Emp;
import com.bjpn.dao.EmpDao;
import com.bjpn.dao.impl.EmpDaoImpl;
import com.bjpn.mapper.EmpMapper;
import com.bjpn.service.EmpService;
import com.bjpn.util.DBUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmpServiceImpl implements EmpService {
    EmpDao empDao = new EmpDaoImpl();
    @Override
    public Boolean addEmpService(Emp emp) {
        //注册驱动
        Connection conn = null;
        try {
            //注册驱动
            conn = DBUtil.getConn();
            //开启事务
            conn.setAutoCommit(false);
            Boolean b = empDao.addEmp(conn, emp);
            if (b) {
                conn.commit();
                return true;
            } else {
                conn.rollback();
                return false;
            }
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn);
        }
        return false;

    }
    @Override
    public List<Emp> selectAllEmp() {
        List<Emp> emps = empDao.selectAllEmp();
        return emps;
    }

    @Override
    public boolean delEmp(int num) {
        SqlSession sqlSession = null;
        try {
            //读取核心配置文件
            InputStream in = Resources.getResourceAsStream("mybatis.xml");
            //拿到jdbc 和sql语句
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

             sqlSession = sqlSessionFactory.openSession();

            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

            boolean b = mapper.delEmpByEmpNo(num);
            if (b) {
                sqlSession.commit();
                return true;
            } else {
               sqlSession.rollback();
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
            sqlSession.close();
            }
        }
        return false;
    }

    @Override
    public Emp selectEmpByEmpNo(int empNo) {
        Emp emp = empDao.selectEmpByEmpNo(empNo);

        return emp;
    }

    @Override
    public Boolean updateEmp(Emp emp) {
        //注册驱动
        Connection conn = null;
        try {
            //注册驱动
            conn = DBUtil.getConn();
            //开启事务
            conn.setAutoCommit(false);
            Boolean b = empDao.updateEmp(conn, emp);
            if (b) {
                conn.commit();
                return true;
            } else {
                conn.rollback();
                return false;
            }
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn);
        }
        return false;
    }
}


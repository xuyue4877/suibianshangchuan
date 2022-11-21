package com.bjpn.servlet;

import com.bjpn.bean.Emp;
import com.bjpn.service.EmpService;
import com.bjpn.service.impl.EmpServiceImpl;
import com.bjpn.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.UUID;

@WebServlet("/updateEmp.action")
@MultipartConfig
public class UpdateEmpServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        Part part = request.getPart("empPhoto");//输入框的key
        String oldFileName = part.getSubmittedFileName();//源文件的名字
        String fileTypeName = oldFileName.substring(oldFileName.lastIndexOf("."));//截取文件后缀
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String filename = uuid + fileTypeName;//新名字
        String path = request.getServletContext().getRealPath("/fileupload");//获取动态路径
        part.write(path + "/" + filename);

        String empno = request.getParameter("empNo");
        String empName = request.getParameter("empName");
        String empJob = request.getParameter("empJob");
        String empHiredate = request.getParameter("empHiredate");
        String empsal = request.getParameter("empSal");
        String deptno = request.getParameter("deptNo");
        String empPhoto = filename;
        int empNo = Integer.parseInt(empno);
        double empSal = Double.parseDouble(empsal);
        int deptNo = Integer.parseInt(deptno);
        EmpService empService = new EmpServiceImpl();
        Emp emp = new Emp();
        emp.setEmpNo(empNo);
        emp.setEmpSal(empSal);
        emp.setEmpJob(empJob);
        emp.setEmpName(empName);
        emp.setEmpPhoto(empPhoto);
        emp.setEmpHiredate(empHiredate);
        emp.setDeptNo(deptNo);
        Boolean aBoolean = empService.updateEmp(emp);
        if (aBoolean) {
            response.getWriter().write("修改成功");
        } else {
            response.getWriter().write("修改失败");
        }

    }
}

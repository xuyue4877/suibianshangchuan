package com.bjpn.servlet;

import com.alibaba.fastjson.JSON;
import com.bjpn.bean.Emp;
import com.bjpn.bean.User;
import com.bjpn.service.EmpService;
import com.bjpn.service.UserService;
import com.bjpn.service.impl.EmpServiceImpl;
import com.bjpn.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/addEmp.action")
@MultipartConfig
public class AddEmpServlet extends HttpServlet {
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


        String empName = request.getParameter("empName");
        String empJob = request.getParameter("empJob");
        String empHiredate = request.getParameter("empHiredate");
        String empPhoto = filename;
        String empSal = request.getParameter("empSal");
        String deptNo = request.getParameter("deptNo");
        //连接数据库
        EmpService empService = new EmpServiceImpl();
        Emp emp = new Emp();
        emp.setEmpName(empName);
        emp.setEmpJob(empJob);
        emp.setEmpHiredate(empHiredate);
        emp.setEmpPhoto(empPhoto);
        emp.setEmpSal(Double.parseDouble(empSal));
        emp.setDeptNo(Integer.parseInt(deptNo));
        Boolean aBoolean = empService.addEmpService(emp);
        if (aBoolean) {
            response.getWriter().write("添加成功");
        } else {
            response.getWriter().write("添加失败");

        }
    }
}

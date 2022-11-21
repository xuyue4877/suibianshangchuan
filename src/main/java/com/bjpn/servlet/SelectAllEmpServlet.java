package com.bjpn.servlet;

import com.alibaba.fastjson.JSON;
import com.bjpn.bean.Emp;
import com.bjpn.service.EmpService;
import com.bjpn.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllEmp.action")
public class SelectAllEmpServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("utf-8");
        response.setContentType("text/html;charset=utf-8");

        EmpService empService = new EmpServiceImpl();
        List<Emp> emps = empService.selectAllEmp();

        request.setAttribute("emps", emps);
        request.getRequestDispatcher("pages/emp/emp.jsp").forward(request, response);


    }
}

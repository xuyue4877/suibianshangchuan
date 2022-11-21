package com.bjpn.servlet;

import com.bjpn.bean.Emp;
import com.bjpn.service.EmpService;
import com.bjpn.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/look.action")
public class LookEmp extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String empNo = request.getParameter("emp");
        int i = Integer.parseInt(empNo);
        System.out.println("i = " + i);
        EmpService empService = new EmpServiceImpl();
        Emp emp = empService.selectEmpByEmpNo(i);
        System.out.println("emp = " + emp);
        request.getSession().setAttribute("emp", emp);
        request.getRequestDispatcher("pages/emp/updateEmp.jsp").forward(request, response);
    }
}

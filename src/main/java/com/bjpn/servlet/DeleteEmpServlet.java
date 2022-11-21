package com.bjpn.servlet;

import com.bjpn.service.EmpService;
import com.bjpn.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteEmp.action")
public class DeleteEmpServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String emp = request.getParameter("emp");
        int i = Integer.parseInt(emp);
        System.out.println("i = " + i);
        System.out.println("emp = " + emp);
        EmpService empService = new EmpServiceImpl();
        boolean b = empService.delEmp(i);
        System.out.println(b);

        if (b) {
//            response.sendRedirect("selectAllEmp.action");
//            request.getRequestDispatcher("selectAllEmp.action").forward(request, response);
            response.getWriter().write("ok");
        }
    }
}

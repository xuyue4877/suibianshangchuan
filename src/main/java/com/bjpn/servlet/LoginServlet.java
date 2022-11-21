package com.bjpn.servlet;

import com.bjpn.bean.User;
import com.bjpn.service.UserService;
import com.bjpn.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login.action")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //接收参数
        String userCode = request.getParameter("userCode");
        String userPwd = request.getParameter("userPwd");
        //连接数据库  登录
        UserService userService = new UserServiceImpl();
        User user = userService.loginUserService(userCode,userPwd);
        if(user!=null){
            //什么时候用转发什么时候用重定向
            //当前业务结束了  用重定向  业务未结束用转发
            request.getSession().setAttribute("user", user);
            response.sendRedirect("pages/main/index.jsp");
        }else{
            request.setAttribute("loginError", "账号或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}

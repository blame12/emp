package com.qfedu.controller;

import com.qfedu.entity.EmpManager;
import com.qfedu.service.EmpManagerService;
import com.qfedu.service.EmpManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/empManagerLoginController")
public class EmpManagerLoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String inputVcode = req.getParameter("inputVcode");
        // 校验验证码
        String codes = (String) req.getSession().getAttribute("codes");
        if (!inputVcode.isEmpty() && inputVcode.equalsIgnoreCase(codes)) {
            // 业务逻辑实现登录
            EmpManagerService empManagerService = new EmpManagerServiceImpl();
            EmpManager empManager = empManagerService.login(username, password);
            if (empManager != null) {
                HttpSession session = req.getSession();
                session.setAttribute("empManager", empManager);
                resp.sendRedirect(req.getContextPath()+"/safe/empServlet?method=queryAll");
            }else {
                // >> 登录界面
                resp.sendRedirect(req.getContextPath()+"/index.html");
            }
        }else {
            // 验证码错误 >> 登录界面
            resp.sendRedirect(req.getContextPath()+"/index.html");
        }

    }
}

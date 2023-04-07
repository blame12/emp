package com.qfedu.controller;

import com.qfedu.entity.Emp;
import com.qfedu.service.EmpService;
import com.qfedu.service.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/safe/empServlet")
public class EmpServlet extends BaseServlet {
    EmpService empService = new EmpServiceImpl();
    public final static int pageSize = 3;

    public void queryAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");
//        System.out.println("query");
        List<Emp> emps;
        if (page == null) {
            req.setAttribute("page", 1);
            emps = empService.showAllEmp(0, pageSize);
        } else {
            req.setAttribute("page", page);
            emps = empService.showAllEmp((Integer.parseInt(page) - 1) * pageSize, pageSize);
        }
        long count = empService.selectCount();
//        System.out.println(count);
        int pageCount = (int)(count / pageSize + 1);
        req.setAttribute("pageCount", pageCount);
        req.setAttribute("emps", emps);
        req.getRequestDispatcher(req.getContextPath() + "/pages/showAllEmp.jsp").forward(req, resp);
    }

    public void queryOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Emp emps = empService.showEmp(id);
        req.setAttribute("emps", emps);
        req.getRequestDispatcher(req.getContextPath() + "/pages/showAllEmp.jsp").forward(req, resp);
    }

    public void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        EmpService empService = new EmpServiceImpl();
        try {
            if (empService.removeEmp(id) == 1) {
                resp.sendRedirect("/safe/empServlet?method=queryAll");
            }
        } catch (Exception e) {
            System.out.println("删除失败");
        }
    }

    public void modify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double salary = Double.parseDouble(req.getParameter("salary"));
        int age = Integer.parseInt(req.getParameter("age"));

        EmpService empService = new EmpServiceImpl();
        Emp emp = new Emp(id, name, salary, age);
        if (empService.modifyEmp(emp) == 1) {
            resp.sendRedirect("/safe/empServlet?method=queryAll");
        }
    }

    public void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        double salary = Double.parseDouble(req.getParameter("salary"));
        int age = Integer.parseInt(req.getParameter("age"));

        EmpService empService = new EmpServiceImpl();
        Emp emp = new Emp(name, salary, age);
        if (empService.insert(emp) == 1) {
            resp.sendRedirect("/safe/empServlet?method=queryAll");
        }
    }
}

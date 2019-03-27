package com.xm.controller;

import com.xm.dao.MenuDao;
import com.xm.entity.Menu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author : 张晋飞
 * date : 2019/3/27
 */
@WebServlet(name = "MenuSerlvet",urlPatterns = {"/MenuSerlvet"})
public class MenuSerlvet extends HttpServlet {

    MenuDao dao =  new MenuDao();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if("query".equals(action)){
            List<Menu> list = dao.qeruyAll();
            request.setAttribute("list",list);
            request.getRequestDispatcher("/admin-cate.jsp").forward(request,response);
        }

    }

}

package com.xm.controller;

import com.xm.dao.MenuDao;
import com.xm.dao.RoleDao;
import com.xm.dao.RoleMenuDao;
import com.xm.entity.Menu;
import com.xm.entity.Role;
import com.xm.entity.RoleMenu;

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
@WebServlet(name = "RoleSerlvet",urlPatterns = {"/RoleSerlvet"})
public class RoleSerlvet extends HttpServlet {

    RoleDao dao =  new RoleDao();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if("query".equals(action)){
            List<Role> list = dao.qeruyAll();
            request.setAttribute("list",list);
            request.getRequestDispatcher("/admin-role.jsp").forward(request,response);
        }
        if("add".equals(action)){
            String rolename = request.getParameter("rolename");
            int i = dao.add(new Role(rolename));
            response.getWriter().print(i);
        }
        if("addMenu".equals(action)){
            String rId = request.getParameter("rId");
            Role role = dao.queryOne(rId);
            MenuDao menuDao = new MenuDao();
            List<Menu> menus = menuDao.qeruyAll();
            request.setAttribute("menus",menus);
            request.setAttribute("role",role);
            request.getRequestDispatcher("/role-menu.jsp").forward(request,response);
        }
        if("addRolemenu".equals(action)){
            String rId = request.getParameter("rId");
            RoleMenuDao roleMenuDao = new RoleMenuDao();
            List<String> midList = roleMenuDao.qeruyByRoleId(rId);
            System.out.println("------------"+midList);
            String mids = request.getParameter("mids");
            String[] ids = mids.split(",");
            for (String mid:ids) {
                if(!midList.contains(mid)){
                    int i = roleMenuDao.addAll(new RoleMenu(Integer.parseInt(rId), Integer.parseInt(mid)));
                }
            }
        }

    }

}

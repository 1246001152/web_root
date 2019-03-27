package com.xm.controller;

import com.xm.dao.MenuDao;
import com.xm.dao.RoleDao;
import com.xm.dao.UserDao;
import com.xm.dao.UserRoleDao;
import com.xm.entity.Menu;
import com.xm.entity.Role;
import com.xm.entity.User;
import com.xm.entity.UserRole;

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
@WebServlet(name = "UserServlet",urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

    UserDao dao =  new UserDao();
    RoleDao roleDao =  new RoleDao();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if("query".equals(action)){
            List<User> list = dao.qeruyAll();
            request.setAttribute("list",list);
            request.getRequestDispatcher("/admin-list.jsp").forward(request,response);
        }
        if("torole".equals(action)){
            String uId = request.getParameter("uId");
            User user = dao.qeruyOne(uId);
            request.setAttribute("user",user);
            List<Role> rolelist = roleDao.qeruyAll();
            request.setAttribute("rolelist",rolelist);
            request.getRequestDispatcher("/admin-edit.jsp").forward(request,response);
        }
        if("add".equals(action)){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            int i = dao.add(new User(username,password));
            response.getWriter().print(i);
        }
        if("addRole".equals(action)){
            String uId = request.getParameter("uId");
            String rId = request.getParameter("rId");
            UserRoleDao userRoleDao = new UserRoleDao();
            int i = userRoleDao.addUserRole(new UserRole(Integer.parseInt(uId),Integer.parseInt(rId)));
            response.getWriter().print(i);
        }
        if("login".equals(action)){
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = dao.queryOneByUsername(username);
            MenuDao menuDao = new MenuDao();
            List<Menu> menus = menuDao.RoleMenu(user.getuId());
            request.getSession().setAttribute("menus",menus);
            if(user.getPassword().equals(password))
                response.getWriter().print(1);
            else
                response.getWriter().print(0);
        }

    }

}

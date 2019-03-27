package com.xm.dao;

import com.xm.entity.Menu;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author : 张晋飞
 * date : 2019/3/27
 */
public class MenuDao {

    private final String COLNAME = "M_ID MID  ,MENU_NAME  MENUNAME  ,P_ID  PID ,URL,IMG ";

    private QueryRunner qr =  new QueryRunner(DataSourceUtil.getDruidDataSource());

    public List<Menu> qeruyAll(){
        String sql="SELECT "+COLNAME+" FROM MENU";
        try {
            List<Menu> list = qr.query(sql, new BeanListHandler<>(Menu.class));
            return  list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }
    public int add(Menu menu){
        String sql="insert into menu (menu_name,p_id,url) values (?,?,?)";
        try {
            int i = qr.update(sql,
                    menu.getMenuName(),menu.getpId(),menu.getUrl());
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }

    public List<Menu> RoleMenu(int uId){
        String sql="select "+COLNAME+" from menu where m_id in ( " +
                        "select m_id from role_menu where r_id =( " +
                            " select r_id from role where r_id = (" +
                                 " select r_id from user_role where u_id =? )))";
        try {
            List<Menu> list = qr.query(sql, new BeanListHandler<>(Menu.class),uId);
            return  list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }
}

package com.xm.dao;

import com.xm.entity.RoleMenu;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : 张晋飞
 * date : 2019/3/27
 */
public class RoleMenuDao {

    private QueryRunner qr =  new QueryRunner(DataSourceUtil.getDruidDataSource());

    /**
     * 获得m_id 集合
     * @param rid
     * @return
     */
    public List<String> qeruyByRoleId(String rid){
        String sql="select * from role_menu  where r_id=?";
        List<String> list = new ArrayList<>();
        try {
            List<RoleMenu> roleMenuList = qr.query(sql, new BeanListHandler<>(RoleMenu.class),rid);
            for (RoleMenu rm:roleMenuList) {
                list.add(""+rm.getM_id());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  list;
    }
    public int  addAll(RoleMenu roleMenu){
        String sql="insert into role_menu (r_id,m_id) values (?,?)";
        try {
          int i = qr.update(sql,roleMenu.getR_id(),roleMenu.getM_id());
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }

}

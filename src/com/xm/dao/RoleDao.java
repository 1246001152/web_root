package com.xm.dao;

import com.xm.entity.Role;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author : 张晋飞
 * date : 2019/3/27
 */
public class RoleDao {

    private QueryRunner qr =  new QueryRunner(DataSourceUtil.getDruidDataSource());

    public List<Role> qeruyAll(){
        String sql="select * from Role";
        try {
            List<Role> list = qr.query(sql, new BeanListHandler<>(Role.class));
            return  list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }
    public int add(Role role){
        String sql="insert into Role (role_name) values (?)";
        try {
            int i = qr.update(sql, role.getRole_name());
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }

    public Role queryOne(String rId) {
        String sql="select * from Role where r_id = ?";
        try {
            Role list = qr.query(sql, new BeanHandler<>(Role.class),rId);
            return  list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

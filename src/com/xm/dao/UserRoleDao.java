package com.xm.dao;

import com.xm.entity.UserRole;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author : 张晋飞
 * date : 2019/3/27
 */
public class UserRoleDao {

    private QueryRunner qr =  new QueryRunner(DataSourceUtil.getDruidDataSource());

    public List<UserRole> qeruyAll(){
        String sql="select * from User_Role";
        try {
            List<UserRole> list = qr.query(sql, new BeanListHandler<>(UserRole.class));
            return  list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }
    public int addUserRole(UserRole userRole){
        String sql="insert into User_Role (u_id,r_id) values (?,?)";
        try {
           int i = qr.update(sql,userRole.getU_id(),userRole.getR_id());
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }

}

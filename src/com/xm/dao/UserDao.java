package com.xm.dao;

import com.xm.entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author : 张晋飞
 * date : 2019/3/27
 */
public class UserDao {

    private final String COLNAME=" U.U_ID  UID,  U.USERNAME  USERNAME ,U.PASSWORD PASSWORD, R.ROLE_NAME ROLENAME ";
    private QueryRunner qr =  new QueryRunner(DataSourceUtil.getDruidDataSource());

    public List<User> qeruyAll(){
        String sql="SELECT "+COLNAME+" FROM USER U left join USER_ROLE UR on U.U_ID = UR.U_ID left join ROLE R " +
                " on UR.R_ID = R.R_ID";
        try {
            List<User> list = qr.query(sql, new BeanListHandler<>(User.class));
            return  list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }
    public int add(User user){
        String sql="insert into user (username,password) values (?,?)";
        try {
            int i = qr.update(sql,user.getUsername(),user.getPassword());
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }

    public User qeruyOne(String uId) {
        String sql="SELECT u_id  uId ,username ,password FROM USER where u_id = ?";
        try {
            User list = qr.query(sql, new BeanHandler<>(User.class),uId);
            return  list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public User queryOneByUsername(String username) {
        String sql="SELECT u_id  uId ,username ,password FROM USER where username = ?";
        try {
            User list = qr.query(sql, new BeanHandler<>(User.class),username);
            return  list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

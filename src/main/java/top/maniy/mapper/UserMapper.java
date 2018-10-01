package top.maniy.mapper;

import org.apache.ibatis.annotations.Param;
import top.maniy.entity.User;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/9/29 9:07
 */
public interface UserMapper {
    //根据用户名和密码获得用户信息
    User findUserByUsernameAndPassword(@Param("username") String username,@Param("password") String password);




    List<User> findAllUser();




}

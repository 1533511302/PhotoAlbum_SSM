package top.maniy.service;

import top.maniy.entity.User;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service
 * @Description:
 * @date 2018/9/29 9:17
 */
public interface UserService {

    //根据用户名和密码获得用户信息
    User findUserByUsernameAndPassword(String username,String password);

    List<User> findAllUser();

}

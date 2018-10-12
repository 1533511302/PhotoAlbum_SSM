package top.maniy.service;

import org.apache.http.ParseException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import top.maniy.entity.User;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
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

    public XSSFWorkbook exportExcel()throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException ;

}

package top.maniy.service.impl;

import org.apache.http.ParseException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.maniy.entity.ExcelBean;
import top.maniy.entity.User;
import top.maniy.mapper.UserMapper;
import top.maniy.service.UserService;
import top.maniy.util.ExcelUtil;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuzonghua
 * @Package top.maniy.service.impl
 * @Description:
 * @date 2018/9/29 9:18
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper usermapper;

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        return usermapper.findUserByUsernameAndPassword(username,password);
    }

    @Override
    public List<User> findAllUser() {
        return usermapper.findAllUser();
    }

    @Override
    public XSSFWorkbook exportExcel() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException {
        //根据条件查询数据，把数据装载到一个list中
        List<User> list = usermapper.findAllUser();

        List<ExcelBean> excel=new ArrayList<>();
        Map<Integer,List<ExcelBean>> map=new LinkedHashMap<>();
        XSSFWorkbook xssfWorkbook=new XSSFWorkbook();
        //设置标题栏
        excel.add(new ExcelBean("人员编号","userId",0));
        excel.add(new ExcelBean("用户名","username",0));
        excel.add(new ExcelBean("密码", "password", 0));


        map.put(0, excel);
        String sheetName = "用户列表";
        //调用ExcelUtil的方法
        xssfWorkbook = ExcelUtil.createExcelFile(User.class, list, map, sheetName);
        return xssfWorkbook;

    }

}

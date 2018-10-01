package top.maniy.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author liuzonghua
 * @Package top.maniy.service
 * @Description:
 * @date 2018/9/29 23:13
 */
@RunWith(SpringJUnit4ClassRunner.class)

public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findUserByUsernameAndPassword() {
//        System.out.println(userService.findUserByUsernameAndPassword("root","123456"));
    }
}
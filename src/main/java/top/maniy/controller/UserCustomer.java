package top.maniy.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.maniy.entity.User;
import top.maniy.service.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/9/29 9:23
 */
@Controller
public class UserCustomer {


    @Autowired
    private UserService userService;


    @RequestMapping(value ="index")
    public String index() {


        return "loginPage";
    }


    @RequestMapping(value = "/user")
    @ResponseBody
    public List<User> getUser(){
        return userService.findAllUser();
    }

    @RequestMapping(value = "/toLogin")
    @ResponseBody
    public String login(HttpServletRequest request,@RequestParam("username") String username, @RequestParam("password") String password){
        //return userService.findUserByUsernameAndPassword("root","123456");
        System.out.println(username);
        System.out.println(password);
        User user =userService.findUserByUsernameAndPassword(username,password);
        System.out.println(user);
        if(user!=null){
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
            return "1";
        }else {
            return "0";
        }

    }
}

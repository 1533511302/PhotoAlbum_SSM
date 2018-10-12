package top.maniy.controller;

import org.apache.http.ParseException;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.maniy.entity.User;
import top.maniy.service.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.IntrospectionException;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
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


    @RequestMapping(value ="toLogin",method = RequestMethod.GET)
    public String index() {


        return "loginPage";
    }


    @RequestMapping(value = "/getExcel")
    @ResponseBody
    public String getExcel(HttpServletResponse response)  throws IOException{
        List<User> userList =userService.findAllUser();


//创建HSSFWorkbook对象
        HSSFWorkbook wb = new HSSFWorkbook();

//创建HSSFSheet对象
        HSSFSheet sheet = wb.createSheet("成绩表");

//创建HSSFRow对象
        HSSFRow row = sheet.createRow(0);
//创建HSSFCell对象
        HSSFCell cell=row.createCell(0);
////设置单元格的值
//        cell.setCellValue("学员考试成绩一览表");
////合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
//        sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
////在sheet里创建第二行
//        HSSFRow row2=sheet.createRow(1);
//
//
////创建单元格并设置单元格内容
//        row2.createCell(0).setCellValue("姓名");
//        row2.createCell(1).setCellValue("班级");
//        row2.createCell(2).setCellValue("笔试成绩");
//        row2.createCell(3).setCellValue("机试成绩");
////在sheet里创建第三行
//        HSSFRow row3=sheet.createRow(2);
//        row3.createCell(0).setCellValue("李明");
//        row3.createCell(1).setCellValue("As178");
//        row3.createCell(2).setCellValue(87);
//        row3.createCell(3).setCellValue(78);

        cell.setCellValue("用户信息表");
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,2));
        int i=1;
        for (User user:userList){

            //在sheet里创建第i行
            HSSFRow irow=sheet.createRow(i);


            //创建单元格并设置单元格内容
            irow.createCell(0).setCellValue(user.getUserId());
            irow.createCell(1).setCellValue(user.getUsername());
            irow.createCell(2).setCellValue(user.getPassword());

            i++;
        }
//输出Excel文件
        OutputStream output=response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=details.xls");
        response.setContentType("application/msexcel");

        //FileOutputStream output=new FileOutputStream("d:\\workbook.xls");

        wb.write(output);

        output.close();
        return null;
    }

    @RequestMapping(value = "/getExcelByClass")
    @ResponseBody
    public String   export(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IntrospectionException, IllegalAccessException, ParseException, InvocationTargetException, UnsupportedEncodingException, InvocationTargetException, IntrospectionException {
        boolean flag=true;

        //response.setHeader("Pragma", "no-cache");
        //response.setHeader("Cache-Control", "no-cache");
        //response.setDateHeader("Expires", 0);//压缩包


            XSSFWorkbook workbook = userService.exportExcel();
            OutputStream output;
            response.reset(); //清除buffer缓存
            response.setHeader("Content-Disposition", "attachment;filename=" + new String("用户列表".getBytes("UTF-8"),"ISO-8859-1")+".xls");
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            try {
                output = response.getOutputStream();
                BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
                bufferedOutPut.flush();
                workbook.write(bufferedOutPut);
                bufferedOutPut.close();
            } catch (IOException e) {
                flag=false;
                e.printStackTrace();
            }

        if(flag)
            return "success";
        else
            return "error";
    }



    @RequestMapping(value = "/user" )
    @ResponseBody
    public List<User> getUser(){
        return userService.findAllUser();
    }

    @RequestMapping(value = "/toLogin",method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest request,@RequestParam("username") String username, @RequestParam("password") String password){

        System.out.println(username);
        System.out.println(password);
        User user =userService.findUserByUsernameAndPassword(username,password);

        if(user!=null){
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
            return "1";
        }else {
            return "0";
        }

    }
}

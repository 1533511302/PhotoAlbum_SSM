package top.maniy.controller;

import com.sun.xml.internal.ws.wsdl.writer.document.Part;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import top.maniy.entity.Album;
import top.maniy.entity.Photo;
import top.maniy.service.PhotoService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/10/1 11:26
 */
@Controller
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @RequestMapping(value = "/tophoto")
    public String getPhoto(@RequestParam("albumId") int albumId, ModelMap modelMap){
        List<Photo> photoList=photoService.getPhotosByAlbumId(albumId);
        System.out.println(photoList);
        modelMap.put("albumId",albumId);
        modelMap.put("photoList",photoList);
        return "photo";
    }
    @RequestMapping(value = "upload")
    public String uploadPhoto(HttpServletRequest request,MultipartFile pictureFile,
                              String photoName,int albumId,String introduce) throws IOException {

        String name =UUID.randomUUID().toString().replaceAll("-", "");


        String fileName=pictureFile.getOriginalFilename();// 文件原名称

        //获取上传文件的目录
        String path =request.getSession().getServletContext().getRealPath("/");

        String newPath=path.substring(0,path.indexOf("PhotoAlbum_SSM_war_exploded"))+"img\\";

        //获取图片后缀
        String ext= FilenameUtils.getExtension(fileName);

        //获取文件的后缀
        //String ext2=name.substring(name.lastIndexOf("."), name.length()-1);

        //新图片
        File newfile =new File(newPath+ name+"."+ext);
        //把内存图片写入磁盘中

        pictureFile.transferTo(newfile);
        //把图片信息保存都数据库
        Photo photo =new Photo();
        photo.setPhotoUrl( name+"."+ext);
        photo.setPhotoName(photoName);
        photo.setAlbumId(albumId);
        photo.setIntroduce(introduce);

        int result=photoService.savePhoto(photo);

        return "redirect:tophoto?albumId="+albumId;
    }

    //下载图片
    @RequestMapping(value = "/downloadPhoto")
    @ResponseBody
    private String downloadPhoto(HttpServletRequest request, HttpServletResponse resp,String photoUrl)throws IOException{

        System.out.println("图片下载");

        //获取上传文件的目录
        String path =request.getSession().getServletContext().getRealPath("/");

        String newPath=path.substring(0,path.indexOf("PhotoAlbum_SSM_war_exploded"))+"img\\";
        System.out.println(newPath);
//        String path = getServletContext().getRealPath("/") + "upload/images";
        String filename = photoUrl;
        System.out.println(filename);

        // System.out.println("路径：" + path + "\t\n文件名：" + filename);
        File file = new File(newPath,filename);
        //如果文件夹存在
        if (file.exists()) {
            //由于下载的时候与浏览器的编码不符，浏览器不能识别中文编码，这里要进行转换

            resp.setContentType("application/x-msdownload");
            resp.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");
            InputStream inputStream = new FileInputStream(file);
            ServletOutputStream outputStream = resp.getOutputStream();
            byte b[] = new byte[1024];
            int n;
            while ((n = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, n);
            }
            outputStream.close();
            inputStream.close();


        }
            return null;
    }
    @RequestMapping(value = "/deletePhoto")
    public String deletePhotoById(HttpServletRequest req, HttpServletResponse resp,String photoUrl,Integer albumId) throws IOException{

        HttpSession session =req.getSession();



        //获取图片位置的绝对路径
        //获取上传文件的目录
        String path =req.getSession().getServletContext().getRealPath("/");

        String newPath=path.substring(0,path.indexOf("PhotoAlbum_SSM_war_exploded"))+"img\\";
        //获取图片名

        File file=new File(newPath,photoUrl);
        if(file.exists()){
            //System.out.println(fileName);
            file.delete();
        }
         photoService.deletePhotoByPhotoUrl(photoUrl);
        return  "redirect:tophoto?albumId="+albumId;


    }


}

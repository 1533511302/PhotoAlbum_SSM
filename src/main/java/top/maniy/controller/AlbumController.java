package top.maniy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.maniy.entity.Album;
import top.maniy.entity.AlbumVO;
import top.maniy.entity.Photo;
import top.maniy.entity.User;
import top.maniy.service.AlbumService;
import top.maniy.service.PhotoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/9/30 9:08
 */
@Controller
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private PhotoService photoService;

   @RequestMapping(value = "/albumPage")
    public ModelAndView getAlbumByUserId(HttpServletRequest request,ModelMap modelMap){
       User user= (User) request.getSession().getAttribute("user");

       List<AlbumVO> albumVOList =albumService.getAlbumsByUserId(user.getUserId());
       System.out.println(albumVOList);
       Map<String,Object> data =new HashMap<String, Object>();
       data.put("albumVOList",albumVOList);
       modelMap.put("albumList",albumVOList);
       return new ModelAndView("album",data);
   }
   @RequestMapping(value = "/saveAlbum")
    public String saveAlbum(Album album,ModelMap modelMap,HttpServletRequest request){
       User user= (User) request.getSession().getAttribute("user");
       album.setUserId(user.getUserId());
       albumService.saveAlbum(album);

       return "redirect:albumPage";
   }

    @RequestMapping(value = "/deleteAlbum")
    public String deletePhotoById(HttpServletRequest req, HttpServletResponse resp,Integer albumId) throws IOException {
        int result =albumService.deleteAlbumByAlbumId(albumId);
        if(result>0){
            List<Photo> photoList =photoService.getPhotosByAlbumId(albumId);
            for(Photo photo : photoList){
                String photoUrl =photo.getPhotoUrl();
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
            }

        }
        return  "redirect:albumPage";


    }

}

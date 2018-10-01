package top.maniy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.maniy.entity.AlbumVO;
import top.maniy.service.AlbumService;

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
public class AlbumCustomer {

    @Autowired
    private AlbumService albumService;

   @RequestMapping(value = "/albumPage")
    public ModelAndView getAlbumByUserId(ModelMap modelMap){
       List<AlbumVO> albumVOList =albumService.getAlbumsByUserId(1);
       System.out.println(albumVOList);
       Map<String,Object> data =new HashMap<String, Object>();
       data.put("albumVOList",albumVOList);
       modelMap.put("albumList",albumVOList);
       return new ModelAndView("album",data);
   }
}

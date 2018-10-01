package top.maniy.service;

import org.apache.ibatis.annotations.Param;
import top.maniy.entity.Photo;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service
 * @Description:
 * @date 2018/10/1 17:29
 */
public interface PhotoService {

    //根据相册id获取相册的图片
    List<Photo> getPhotosByAlbumId(@Param("albumId") Integer albumId);

    //保存图片
    int savePhoto(Photo photo);
}

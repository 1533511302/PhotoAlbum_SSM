package top.maniy.mapper;

import org.apache.ibatis.annotations.Param;
import top.maniy.entity.Photo;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/9/29 9:05
 */
public interface PhotoMapper {
    //根据相册id获取 相册下的图片
    List<Photo> getPhotosByAlbumId(Integer AlbumId);
    //保存图片
    //boolean savePhoto(Photo photo);
    //根据图片id删除图片
    //boolean deletePhotoByPhotoId(Integer photoId);
    //
    //Photo getPhotoUpToDate();
    //根据相册id获取图片数量
    int getCountByAlbumId(Integer AlbumId);
    //
    //List<String> getPhotoByAlbumId(Integer albumId);

    //根据相册id获取相册下排序前num的图片
    List<Photo> getPhotosByAlbumIdNum(@Param("albumId") Integer albumId,@Param("num") Integer num);
}

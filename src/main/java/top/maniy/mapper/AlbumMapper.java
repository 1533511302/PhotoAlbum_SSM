package top.maniy.mapper;

import org.apache.ibatis.annotations.Param;
import top.maniy.entity.Album;
import top.maniy.entity.User;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/9/29 9:07
 */
public interface AlbumMapper {
    //根据用户名和密码获得用户信息
    List<Album> getAlbumsByUserId(Integer userId);
    //添加相册
    int saveAlbum(Album album);
    //根据相册id删除id
    int deleteAlbumByAlbumId(Integer albumId);




}

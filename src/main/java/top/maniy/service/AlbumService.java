package top.maniy.service;

import top.maniy.entity.Album;
import top.maniy.entity.AlbumVO;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service
 * @Description:
 * @date 2018/9/29 22:39
 */
public interface AlbumService {
    //根据用户名和密码获得用户信息
    List<AlbumVO> getAlbumsByUserId(Integer userId);
    //添加相册
    int saveAlbum(Album album);
    //根据相册id删除id
    int deleteAlbumByAlbumId(Integer albumId);
}

package top.maniy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.maniy.entity.Album;
import top.maniy.entity.AlbumVO;
import top.maniy.entity.Photo;
import top.maniy.mapper.AlbumMapper;
import top.maniy.mapper.PhotoMapper;
import top.maniy.service.AlbumService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service.impl
 * @Description:
 * @date 2018/9/29 22:45
 */
@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    @Autowired
    private PhotoMapper photoMapper;

    @Override
    public List<AlbumVO> getAlbumsByUserId(Integer userId) {

        List<Album> albumList =albumMapper.getAlbumsByUserId(userId);
        System.out.println(albumList);
        List<AlbumVO> albumVOList =new ArrayList<>();
        for(Album album : albumList){
            AlbumVO albumVO =new AlbumVO();
            albumVO.setAlbumId(album.getAlbumId());
            albumVO.setAlbumName(album.getAlbumName());
            albumVO.setIntroduce(album.getIntroduce());
            albumVO.setUserId(album.getUserId());
            List<Photo>  photoList =photoMapper.getPhotosByAlbumIdNum(album.getAlbumId(),9);
            albumVO.setPhotos(photoList);
            albumVO.setCount(photoMapper.getCountByAlbumId(album.getAlbumId()));
            albumVOList.add(albumVO);
        }


        return albumVOList;
    }

    @Override
    public int saveAlbum(Album album) {
        return albumMapper.saveAlbum(album);
    }

    @Override
    public int deleteAlbumByAlbumId(Integer albumId) {
        return albumMapper.deleteAlbumByAlbumId(albumId);
    }
}

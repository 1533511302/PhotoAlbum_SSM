package top.maniy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.maniy.entity.Photo;
import top.maniy.mapper.PhotoMapper;
import top.maniy.service.PhotoService;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service.impl
 * @Description:
 * @date 2018/10/1 17:30
 */
@Service
public class PhotoServiceImpl implements PhotoService{

    @Autowired
    private PhotoMapper photoMapper;

    @Override
    public List<Photo> getPhotosByAlbumId(Integer albumId) {
        return photoMapper.getPhotosByAlbumId(albumId);
    }

    @Override
    public int savePhoto(Photo photo) {
        return photoMapper.savePhoto(photo);
    }
}

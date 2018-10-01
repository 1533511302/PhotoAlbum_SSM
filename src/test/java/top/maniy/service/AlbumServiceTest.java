package top.maniy.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.maniy.entity.Album;
import top.maniy.mapper.AlbumMapper;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author liuzonghua
 * @Package top.maniy.service
 * @Description:
 * @date 2018/9/29 23:08
 */
public class AlbumServiceTest {

    @Autowired
    private AlbumMapper albumMapper;

    @Test
    public void getAlbumsByUserId() {
        List<Album> albumList= albumMapper.getAlbumsByUserId(1);
        System.out.println(albumList);
    }

    @Test
    public void saveAlbum() {
    }

    @Test
    public void deleteAlbumByAlbumId() {
    }
}
package top.maniy.entity;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.entity
 * @Description:
 * @date 2018/9/9 10:57
 */
public class AlbumVO {
    private Integer albumId;
    private String albumName;
    private Integer userId;
    private String introduce;
    private Integer count;
    private List<Photo> photos;

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "AlbumVO{" +
                "albumId=" + albumId +
                ", albumName='" + albumName + '\'' +
                ", userId=" + userId +
                ", introduce='" + introduce + '\'' +
                ", count=" + count +
                ", photos=" + photos +
                '}';
    }
}

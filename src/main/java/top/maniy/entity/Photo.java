package top.maniy.entity;

/**
 * @author liuzonghua
 * @Package top.maniy.entity
 * @Description:
 * @date 2018/9/6 22:31
 */
public class Photo {
    private Integer photoId;
    private String photoName;
    private Integer albumId;
    private String photoUrl;
    private String introduce;

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "photoId=" + photoId +
                ", photoName='" + photoName + '\'' +
                ", albumId=" + albumId +
                ", photoUrl='" + photoUrl + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}

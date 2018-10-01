package top.maniy.entity;

/**
 * @author liuzonghua
 * @Package top.maniy.entity
 * @Description:
 * @date 2018/9/6 22:28
 */
public class Album {
    private Integer albumId;
    private String albumName;
    private Integer userId;
    private String introduce;



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


    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", albumName='" + albumName + '\'' +
                ", userId=" + userId +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}

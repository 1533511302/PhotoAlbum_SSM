<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018/9/8
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + "/";
%>
<html>
<head>
    <title>相册</title>
    <link href="album/css/main.css" rel="stylesheet" type="text/css"/>
    <link href="album/css/sim-prev-anim.css" rel="stylesheet" type="text/css" />
    <script src="img/vendor/jquery/jquery-3.2.1.min.js"></script>
    <script>

        function clickAlbum(albumId) {

            location.href="tophoto?albumId="+albumId;
        };


    </script>
</head>
<body>
<div class="albums">
    <div align="center">
        <form action="saveAlbum" enctype="multipart/form-data" method="post">
            <p>添加相册</p>
            相册名称：<input type="text" name="albumName"/>
            相册描述：<input type="text" name="introduce"/>
            <p><input type="submit" value="提交"></p>
        </form>

    </div>

    <div class="albums-inner">

        <c:forEach var="album" items="${albumList}" varStatus="index">
            <div class="albums-tab" >
                <c:if test="${album.count==0}">
                    <div class="albums-tab-thumb" onclick="clickAlbum(${album.albumId})">
                        <img src="<%=basePath%>img/kong.jpg" class="all studio"/>

                    </div>
                </c:if>
                <c:if test="${album.count<4 && album.count>0}">
                    <div class="albums-tab-thumb sim-anim-7" onclick="clickAlbum(${album.albumId})">

                        <c:forEach var="photo" items="${album.photos}">
                        <img src="<%=basePath%>img/${photo.photoUrl}" class="all studio" style="width: 290px;height: 200px;"/>

                        </c:forEach>
                    </div>
                </c:if>

                <c:if test="${album.count>3 &&album.count<6}">
                    <div class="albums-tab-thumb sim-anim-2" onclick="clickAlbum(${album.albumId})">

                        <c:forEach var="photo" items="${album.photos}">
                            <img src="<%=basePath%>img/${photo.photoUrl}" class="all studio"/>

                        </c:forEach>
                    </div>
                </c:if>
                <c:if test="${album.count>6}">
                    <div class="albums-tab-thumb sim-anim-9" onclick="clickAlbum(${album.albumId})">

                        <c:forEach var="photo" items="${album.photos}">
                            <img src="<%=basePath%>img/${photo.photoUrl}" class="all studio"/>

                        </c:forEach>
                    </div>
                </c:if>
                <div class="albums-tab-text">${album.albumName}<span>(${album.introduce})</span></div>
            </div>
        </c:forEach>
<%%>

    </div>

</div>

</body>
</html>

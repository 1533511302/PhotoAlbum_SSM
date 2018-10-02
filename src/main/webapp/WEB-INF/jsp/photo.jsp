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

        function clickPhoto(PhotoId,photoUrl) {
            $(".albums-inner").hide();
            $(".albums-tab-boost").show(500,function () {
                $(".albums-tab-boost img").attr("src","<%=basePath%>img/"+photoUrl);
            });

        };
        function clickBoost() {
            $(".albums-tab-boost").hide();
            $(".albums-inner").show();

        }


    </script>
</head>
<body>
<div class="albums">
<div align="center">
<form action="upload" enctype="multipart/form-data" method="post">
    <p>上传图片：<input type="file" name="pictureFile"></p>
    图片名字：<input type="text" name="photoName"/>
    图片描述：<input type="text" name="introduce"/>
    <input type="hidden" name="albumId" value="${albumId}">
    <p><input type="submit" value="提交"></p>
</form>

</div>

    <div class="albums-inner">

           <c:forEach var="photo" items="${photoList}" varStatus="index">



               <div class="albums-tab" >
                    <div class="albums-tab-thumb" onclick="clickPhoto(${photo.photoId},'${photo.photoUrl}')">


                            <img src="<%=basePath%>img/${photo.photoUrl}" class="all studio"/>

                    </div>


                        <div class="albums-tab-text">${photo.photoName}<span>(${photo.introduce})</span></div>

                </div>
           </c:forEach>


    </div>
    <div align="center" class="albums-tab-boost" style="display: none" onclick="clickBoost()" >
        <img align=""/>
    </div>
</div>

</body>
</html>

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




        function clickPhoto(photoUrl,obj) {

            <%--$(".albums-tab-boost").show(500,function () {--%>
                <%--$(".albums-tab-boost img").attr("src","<%=basePath%>img/"+photoUrl);--%>
            <%--});--%>
            $("#bigimg").attr("src","<%=basePath%>/img/"+photoUrl);

            $("#outerdiv").fadeIn("fast");//淡出显示div
            $("#outerdiv").css("display","block");

            var windowW = $(window).width();//获取当前窗口可视区域宽度
            var windowH = $(window).height();//获取当前窗口视区域高度
            if(windowH>1000){
                windowH=1000;
            }

            //alert(windowW);
            //alert(windowH);


            //ar DocWinowW=$(document).width();//获取浏览器当前文档对象宽度

            //var AllWinowW=$(document.body).outerWidth(true);//获取浏览器当前文档body的总宽度

           // var AllWinowH=$(document.body).outerHeight(true);


            var img = new Image();
            img.src =$(obj).attr("src") ;
            var realWidth=img.width*2;
            var realHeight=img.height*2;

            console.log(realWidth);
            console.log(realHeight);

                    var imgWidth, imgHeight;
                    var scale = 0.8;//缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放
                    if(realHeight>windowH*scale) {//判断图片高度
                        imgHeight = windowH*scale;//如大于窗口高度，图片高度进行缩放
                        console.log(imgHeight);
                        imgWidth = imgHeight/realHeight*realWidth;//等比例缩放宽度
                        console.log(i)
                        if(imgWidth>windowW*scale) {//如宽度扔大于窗口宽度
                            imgWidth = windowW*scale;//再对宽度进行缩放
                        }
                    } else if(realWidth>windowW*scale) {//如图片高度合适，判断图片宽度
                        imgWidth = windowW*scale;//如大于窗口宽度，图片宽度进行缩放
                        imgHeight = imgWidth/realWidth*realHeight;//等比例缩放高度
                    } else {//如果图片真实高度和宽度都符合要求，高宽不变
                        imgWidth = realWidth;
                        imgHeight = realHeight;
                    }


                    $("#bigimg").css("width",imgWidth);//以最终的宽度对图片缩放
                    $("#bigimg").css("height",imgHeight);
                    var w = (windowW-imgWidth)/2;//计算图片与窗口左边距
                    var h = (windowH-imgHeight)/2;//计算图片与窗口上边距

                    console.log(windowH);
                    console.log(imgHeight)
                    console.log(h);


                     $("#innerdiv").css({"top":h, "left":w});//设置#innerdiv的top和left属性

                };





        function clickBoost() {
                    // $(".albums-tab-boost").hide();
                    // $(".albums-inner").fadeIn("fast");
                    $("#outerdiv").fadeOut("fast");//隐藏


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
                    <div class="albums-tab-thumb"<%-- onclick="clickPhoto(${photo.photoId},'${photo.photoUrl}')--%>">


                            <img  src="<%=basePath%>/img/${photo.photoUrl}" class="all studio" style="width: 290px;height: 200px;"  onclick="clickPhoto('${photo.photoUrl}',this)" />

                    </div>


                        <div class="albums-tab-text">${photo.photoName}<span>(${photo.introduce})</span></div>
               <div class="albums-tab-text"><a  href="downloadPhoto?photoUrl=${photo.photoUrl}" >下载</a>   <a style="background:palevioletred;"  href="deletePhoto?photoUrl=${photo.photoUrl}&albumId=${photo.albumId}">删除</a></div>

                </div>
           </c:forEach>


    </div>
    <%--<div align="center" class="albums-tab-boost" style="display: none" onclick="clickBoost()" >--%>
        <%--<img align=""/>--%>
    <%--</div>--%>



</div>
<div id="outerdiv" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:2;width:100%;height:100%;display:none;" onclick="clickBoost()" align="center">
    <div id="innerdiv" style="position:absolute;">
        <img id="bigimg" style="border:5px solid #fff;" src="" />
    </div>
</div>
</body>
</html>

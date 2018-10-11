<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018/9/18
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<%--%>
    <%--String path = request.getContextPath();--%>
    <%--String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()--%>
            <%--+ path + "/";--%>
<%--%>--%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>PhotoAlbum登录</title>
    <meta name="keywords" content="HTML5,美观,简洁大气,响应式,第三方登录,网页模板" />
    <meta name="description" content="HTML5美观简洁大气响应式带第三方登录网页模板下载。鼠标经过登录按钮带紫色渐变炫酷动画效果。带有简单的表单验证功能。" />

    <link rel="stylesheet" type="text/css" href="img/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="img/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="img/fonts/iconic/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" type="text/css" href="img/css/util.css">
    <link rel="stylesheet" type="text/css" href="img/css/main.css">
    <link rel="stylesheet" type="text/css" href="img/main.css">

</head>
<script src="img/vendor/jquery/jquery-3.2.1.min.js"></script>
<script>


    //json两种形式
    //当是对象的时候最外层是{}
    //当是数组集合的时候最外层是[]
    function login() {

        var $username= $('#username').val();
        var $password= $('#password').val();
        console.log($username);
        console.log($password);
        $.ajax({
            type: 'post',
            url: "${pageContext.request.contextPath}/toLogin",
            data: {username:$username,password:$password},
            dataType: "text",
            success: function (data) {
                var mydata =data;
                console.log(mydata)
                if (mydata == "1") {
                    console.log("成功");
                    window.location.href="albumPage";
                }
                else {
                    console.log("失败");
                }
            }
        });

    }
</script>
<body>

<div class="limiter">
    <div class="container-login100" style="background-image: url('img/images/bg-01.jpg');">
        <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">

                <span class="login100-form-title p-b-49">登录</span>

                <div class="wrap-input100 validate-input m-b-23" data-validate="请输入用户名">
                    <span class="label-input100">用户名</span>
                    <input class="input100" type="text" id="username" name="username" placeholder="请输入用户名" autocomplete="off">
                    <span class="focus-input100" data-symbol="&#xf206;"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="请输入密码">
                    <span class="label-input100">密码</span>
                    <input class="input100" type="password" id="password" name="password" placeholder="请输入密码">
                    <span class="focus-input100" data-symbol="&#xf190;"></span>
                </div>

                <div class="text-right p-t-8 p-b-31">
                    <a href="javascript:">忘记密码？</a>
                </div>

                <div class="container-login100-form-btn">
                    <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                        <button class="login100-form-btn" id="submit" onclick="login()">登 录</button>
                    </div>
                </div>

                <div class="txt1 text-center p-t-54 p-b-20">
                    <span>第三方登录</span>
                </div>

                <div class="flex-c-m">
                    <a href="#" class="login100-social-item bg1">
                        <i class="fa fa-wechat"></i>
                    </a>

                    <a href="#" class="login100-social-item bg2">
                        <i class="fa fa-qq"></i>
                    </a>

                    <a href="#" class="login100-social-item bg3">
                        <i class="fa fa-weibo"></i>
                    </a>
                </div>

                <div class="flex-col-c p-t-25">
                    <a href="javascript:" class="txt2">立即注册</a>
                </div>

        </div>
    </div>
</div>

<script src="img/vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="img/js/main.js"></script>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市订单管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css" />
	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		$(function(){
        /*获取时间*/
	        time();
	        function time(){
	            var a = new Array("日", "一", "二", "三", "四", "五", "六");
	            var week = new Date().getDay();
	            var time = new Date();
	            time = time.getFullYear() + " 年 " + (time.getMonth() + 1) + " 月 " + time.getDate() + " 日 " + time.getHours() + ":" + (time.getMinutes().toString().length < 2 ? '0' + time.getMinutes() : time.getMinutes())+ ":" + (time.getSeconds().toString().length < 2 ? '0' + time.getSeconds() : time.getSeconds()) + " 星期" + a[week];
	            $("#time").text(time);
	        }
	        setInterval(time,1000);      

			$("#back").click(function(){
				window.history.back();	
			});
		});
	</script>
</head>
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>超市订单管理系统</h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span style="color: #fff21b">${user.userName}</span> , 欢迎你！</p>
            <a href="<%=basePath%>jsp/logout.s">退出</a>
        </div>
    </header>
<!--时间-->
`

    <section class="publicTime">
        <span id="time"></span>
        <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
    </section>
 <!--主体内容-->
 <section class="publicMian ">
     <div class="left">
         <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
         <nav>
             <ul class="list">
                 <li ><a href="<%=basePath%>jsp/billlist.s">订单管理</a></li>
              <li><a href="<%=basePath%>jsp/providerlist.s">供应商管理</a></li>
              <li><a href="<%=basePath%>jsp/userlist.s">用户管理</a></li>
              <li><a href="<%=basePath%>jsp/updatePwd.s">密码修改</a></li>
              <li><a href="<%=basePath%>jsp/logout.s">退出系统</a></li>
             </ul>
         </nav>
     </div>
     <input type="hidden" id="path" name="path" value=""/>
     <input type="hidden" id="referer" name="referer" value=""/>
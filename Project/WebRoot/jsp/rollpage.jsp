<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".page-btn").click(function(){
			var pageNo=document.getElementById("inputPage").value;		
			if(pageNo!=""){
				location.href="userlist.s?page_No="+pageNo;
			}
			else{
				alert("请输入页码");
			}	
		});
	});

</script>
</head>

	<body>
 		<div class="page-bar">
			<ul class="page-num-ul clearfix">
				<li>共${pu.maxCount }条记录&nbsp;&nbsp;${pu.pageNo}/${pu.maxPage}页</li>
				
					<a href="userlist.s?page_No=1">首页</a>
					<a href="userlist.s?page_No=${pu.ago }">上一页</a>
				
					<a href="userlist.s?page_No=${pu.after}">下一页</a>
					<a href="userlist.s?page_No=${pu.maxPage}">最后一页</a>
				&nbsp;&nbsp;
			</ul>
		 <span class="page-go-form"><label>跳转至</label>
	     <input type="text" name="inputPage" id="inputPage" class="page-key" />页
	     <button type="button" class="page-btn" >GO</button>
		</span>
		</div> 
	</body>
</html>
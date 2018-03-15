<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
<script type="text/javascript">
	$(function(){
		$("#userCode").blur(function(){
			var userCode=$("#userCode").val();
			$.getJSON("checkUserCode.s?userCode="+userCode,function(result){
				$("#userCodeMsg").html(result.msg);
			});
		});
	});	
</script>

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户添加页面</span>
        </div>s
        <div class="providerAdd">
            <fm:form id="userForm" name="userForm" method="post" action="useraddinfo.s" modelAttribute="user" enctype="multipart/form-data">
				<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="userCode">用户账号：</label>
                    <input type="text" name="userCode" id="userCode" value=""> 
					<!-- 放置提示信息 -->
					<font color="red" id="userCodeMsg"><fm:errors path="userCode"></fm:errors></font>
                </div>
                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" value=""> 
					<font color="red"><fm:errors path="userName"></fm:errors></font>
                </div>
                <div>
                    <label for="userPassword">用户密码：</label>
                    <input type="password" name="userPassword" id="userPassword" value=""> 
					<font color="red"><fm:errors path="userPassword"></fm:errors></font>
                </div>
                <div>
                    <label for="ruserPassword">确认密码：</label>
                    <input type="password" name="ruserPassword" id="ruserPassword" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label >用户性别：</label>
					<select name="sex" id="sex">
					    <option value="男" selected="selected">男</option>
					    <option value="女">女</option>
					 </select>
                </div>
                <div>
                    <label for="birthday">出生日期：</label>
                    <input type="text" Class="Wdate" id="birthday" name="birthday" 
					readonly="readonly" onclick="WdatePicker();">
					<font color="red"></font>
                </div>
                <div>
                    <label for="phone">用户电话：</label>
                    <input type="text" name="phone" id="phone" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="address">用户地址：</label>
                   <input name="address" id="address"  value="">
                </div>
                <div>
                    <label >用户角色：</label>
                    <!-- 列出所有的角色分类 -->
					<select name="userRole" id="userRole">
					 <option value="0">--请选择--</option>
						  <option value="1">经理</option>
						  <option value="2">财务</option>
							<option value="3">员工</option>
					</select>
	        		<font color="red"></font>
                </div>
                <div>
                	<label for="file">证件照：</label>
                	<input name="pic" type="file" value="请选择文件" id="pic">
                </div>
                <div>
                	<label for="file">身份证照：</label>
                	<input name="pic" type="file" value="请选择文件">
                </div>
                <div class="providerAddBtn">
                    <input type="submit" name="add" id="add" value="保存" >
					<input type="button" id="back" name="back" value="返回" >
                </div>
            </fm:form>
        </div>
	</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>


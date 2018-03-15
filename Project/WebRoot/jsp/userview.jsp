<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>

 <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户信息查看页面</span>
            <span><a href="../download.s?fileName=${user.idPic }" style="color:black">下载工作照</a></span>
        </div>   
        <div class="providerView">
            <p><strong>用户编号：</strong><span>${user.userId }</span></p>
            <p><strong>用户名称：</strong><span>${user.userName }</span></p>
            <p><strong>用户性别：</strong>
            	<span>
            		${user.sex }
				</span>
			</p>
		    <p><strong>出生日期：</strong><span><fmt:formatDate pattern="yyyy-MM-dd" value="${user.birthday }"/></span></p>
            <p><strong>用户电话：</strong><span>${user.phone}</span></p>
            <p><strong>用户地址：</strong><span>${user.address}</span></p>
            <p><strong>用户角色：</strong><span>${user.roleName }</span></p>
			<div class="providerAddBtn">
            	<input type="button" id="back" name="back" value="返回" >
            </div>
        </div>
    </div>
</section>
<%@include file="/jsp/common/foot.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
<script type="text/javascript">
	$(function(){
		var id = "";
		$(".deleteUser").click(function(){
			id = $(this).attr("data-id");
			$("#removeUse").show();
		});
		$("#yes").click(function(){
			location.href = "userDelete/" + id;
		});
		
		$("#no").click(function(){
			$("#removeUse").hide();
		});
		
	
	});
	
		function userViewByAjax(userId){
			$.getJSON("userViewByAjax.s?userId="+userId,function(result){
				$("#userInfo").html("<p>姓名:"+result.userName+"</p><p>性别:"+result.sex+"</p><p>生日:"+result.birthday+"</p>");
			});
		}
</script>

        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">
           		<form method="post" action="usersearch.s">
					<input name="method" value="query" class="input-text" type="hidden">
					 <span>用户名：</span>
					 <input name="queryname" class="input-text"	type="text" value="">
					 
					 <span>用户角色：</span>
					 <select name="queryUserRole">
						  	<option value="0">--请选择--</option>
						 	<option value="1">经理</option>
						  	<option value="2">财务</option>
							<option value="3">员工</option>
							<option value="4">系统管理员</option>
	        		</select>
					 
					 <input type="hidden" name="pageIndex" value="1"/>
					 <input	value="查 询" type="submit" id="searchbutton">
					 <a href="useradd.s" >添加用户</a>
				</form>
            </div>
            <div id="userInfo" style="color: maroon;"></div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户编码</th>
                    <th width="10%">用户名称</th>
                    <th width="10%">性别</th>
                    <th width="10%">年龄</th>
                    <th width="15%">电话</th>
                    <th width="10%">用户角色</th>
                    <th width="15%">操作</th>
                    <th wid="30%">其它查看方式</th>
                </tr>
                
					<c:forEach items="${pu.list}" var="uli" varStatus="id">
	                     <tr>
	                     <td>
						<span>${id.count}</span>
						</td>
						<td>
						<span>${uli.userName }</span>
						</td>
						<td>
							<span>
								${uli.sex }	
							</span>
						</td>
						<td>
						<span>${uli.age }</span>
						</td>
						<td>
						<span>${uli.phone}</span>
						</td>
						<td>
							<span>${uli.roleName }</span>
						</td>
						<td>
							<span><a class="viewUser" href="userCheck/${uli.userId }"><img src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>			
							<c:if test="${user.userRole==4 }">
								<span><a class="modifyUser" href="userGetId.s?userId=${uli.userId }" ><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>
								<span><a class="deleteUser"  data-id="${uli.userId }" href="javascript:;" ><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>
							</c:if>
						</td>
						<td style="position:relative; top:-6.5px;">
							<a href="javascript:userViewByAjax(${uli.userId });">Ajax</a>
							<a href="view/${uli.userId }.json">JSON</a>
							<a href="view/${uli.userId }.xml">XML</a>
						</td>           
	                    </tr>
                    </c:forEach>      
                    
                    <c:forEach items="${stLi}" var="sli" varStatus="id">
	                     <tr>
	                     <td>
						<span>搜索数据</span>
						</td> 
						<td>
						<span>${sli.userName }</span>
						</td>
						<td>
							<span>
								${sli.sex }	
							</span>
						</td>
						<td>
						<span>${sli.age }</span>
						</td>
						<td>
						<span>${sli.phone}</span>
						</td>
						<td>
							<span>${sli.roleName }</span>
						</td>
						<td>
							<span><a class="viewUser" href="userCheck/${sli.userId }"><img src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>				
							<c:if test="${user.userRole==4 }">
								<span><a class="modifyUser" href="userGetId.s?userId=${sli.userId }" ><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>
								<span><a class="deleteUser"  data-id="${sli.userId }" href="javascript:;" ><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>
							</c:if>
						</td>  
						<td style="position:relative; top:-6.5px;">
							<a href="javascript:userViewByAjax(${sli.userId });">Ajax</a>
							<a href="">JSON</a>
							<a href="">XML</a>
						</td>                     
	                    </tr>
                    </c:forEach>      
				</table>
				 
			<input type="hidden" id="totalPageCount" value=""/>
		  	<c:import url="rollpage.jsp">
	          	<c:param name="totalCount" value=""/>
	          	<c:param name="currentPageNo" value=""/>
	          	<c:param name="totalPageCount" value=""/>
          	</c:import>
        </div>
    </section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="/jsp/common/foot.jsp" %>


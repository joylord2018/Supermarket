<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>

    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
        <form id="userForm" name="userForm" method="post" action="userUpdate.s?userId=${user.userId }">
			<input type="hidden" name="method" value="modifyexe">
			
			 <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" value="${user.userName }"> 
					<font color="red"></font>
             </div>
			 <div>
                    <label >用户性别：</label>
                    <select name="sex" id="gender">
                    	<c:choose>
                    		<c:when test="${user.sex =='男'}">
                    			<option value="男" selected="selected">男</option>
					    		<option value="女">女</option>
                    		</c:when>
                    		
                    		<c:otherwise>
                    			<option value="男">男</option>
					    		<option value="女" selected="selected">女</option>
                    		</c:otherwise>
                    	</c:choose>
					 </select>
             </div>
			 <div>
                    <label for="data">出生日期：</label>
                    <input type="text" Class="Wdate" id="birthday" name="birthday" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${user.birthday }"/>"
					readonly="readonly" onclick="WdatePicker();">
                    <font color="red"></font>
              </div>
			
		       <div>
                    <label for="userphone">用户电话：</label>
                    <input type="text" name="phone" id="phone" value="${user.phone }"> 
                    <font color="red"></font>
               </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="address" id="address" value="${user.address }">
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
			 <div class="providerAddBtn">
                    <input type="submit" name="save" id="save" value="保存" />
                    <input type="button" id="back" name="back" value="返回"/>
                </div>
            </form>
        </div>
    </div>
</section>
<%@include file="/jsp/common/foot.jsp" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
<script type="text/javascript">
	$(function(){
		var id = "";
		$(".deleteBill").click(function(){
			id = $(this).attr("data-id");
			$("#removeBi").show();
		});
		$("#yes").click(function(){
			location.href = "billDelete/" + id;
		});
		
		$("#no").click(function(){
			$("#removeBi").hide();
		});
		
		$(".page-btn").click(function(){
			var pageNo=document.getElementById("inputPage").value;		
			if(pageNo!=""){
				location.href="billlist.s?page_No="+pageNo;
			}
			else{
				alert("请输入页码");
			}	
		});
	});
</script>

<div class="right">
       <div class="location">
           <strong>你现在所在的位置是:</strong>
           <span>订单管理页面</span>
       </div>
       <div class="search">
       <form method="post" action="billsearch.s">
			<input name="method" value="query" class="input-text" type="hidden">
			<span>商品名称：</span>
			<input name="queryProductName" type="text" value="">
			 
			<span>供应商：</span>
			<select name="queryProviderId">				
				   <option value="">--请选择--</option>
				   <c:forEach items="${NameList }" var="li">
				   		<option value="${li.proName}">${li.proName }</option>	
				   </c:forEach>	
       		</select>
			 
			<span>是否付款：</span>
			<select name="queryIsPayment">
				<option value="0">--请选择--</option>
				<option value="1" >已付款</option>
				<option value="2">未付款</option>
       		</select>
			
			 <input	value="查 询" type="submit" id="searchbutton">
			 <a href="billadd.s">添加订单</a>
		</form>
       </div>
       <!--账单表格 样式和供应商公用-->
      <table class="providerTable" cellpadding="0" cellspacing="0">
          <tr class="firstTr">
              <th width="10%">订单编码</th>
              <th width="20%">商品名称</th>
              <th width="10%">供应商</th>
              <th width="10%">订单金额</th>
              <th width="10%">是否付款</th>
              <th width="10%">创建时间</th>
              <th width="30%">操作</th>
          </tr>
          
          <c:forEach items="${pubi.list }" var="li" >
          		<tr>
					<td>
					<span>${li.billCode }</span>
					</td>
					<td>
					<span>${li.productName }</span>
					</td>
					<td>
					<span>${li.proName }</span>
					</td>
					<td>
					<span>${li.totalPrice }</span>
					</td>
					<td>
					<c:choose>
						<c:when test="${li.isPayment==1 }">
							<span>		
								已付款
							</span>
						</c:when>
						<c:otherwise>
							<span>		
								未付款
							</span>
						</c:otherwise>
					</c:choose>

					</td>
					<td>
					<span>
						${li.createtionDate }
					</span>
					</td>
					<td>
					<span><a class="viewBill" href="billCheck/${li.bid }"><img src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>
					<c:if test="${user.userRole==4 }">
						<span><a class="modifyBill" href="billGetId.s?bid=${li.bid }	"><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>
						<span><a class="deleteBill" data-id="${li.bid }" href="javascript:;"><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>
					</c:if>
					</td>
				</tr> 
          </c:forEach>
          
           <c:forEach items="${biLi }" var="ls" >
          		<tr>
					<td>
					<span>搜索数据</span>
					</td>
					<td>
					<span>${ls.productName }</span>
					</td>
					<td>
					<span>${ls.proName }</span>
					</td>
					<td>
					<span>${ls.totalPrice }</span>
					</td>
					<td>
					<c:choose>
						<c:when test="${ls.isPayment==1 }">
							<span>		
								已付款
							</span>
						</c:when>
						<c:otherwise>
							<span>		
								未付款
							</span>
						</c:otherwise>
					</c:choose>

					</td>
					<td>
					<span>
						${ls.createtionDate }
					</span>
					</td>
					<td>
					<span><a class="viewBill" href="billCheck/${ls.bid }"><img src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>
					<c:if test="${user.userRole==4 }">
						<span><a class="modifyBill" href="billGetId.s?bid=${ls.bid }	"><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>
						<span><a class="deleteBill" data-id="${ls.bid }" href="javascript:;"><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>
					</c:if>	
					</td>
				</tr> 
          </c:forEach>
      </table>
      <div class="page-bar">
			<ul class="page-num-ul clearfix">
				<li>共${pubi.maxCount }条记录&nbsp;&nbsp;${pubi.pageNo}/${pubi.maxPage}页</li>
				
					<a href="billlist.s?page_No=1">首页</a>
					<a href="billlist.s?page_No=${pubi.ago }">上一页</a>
				
					<a href="billlist.s?page_No=${pubi.after}">下一页</a>
					<a href="billlist.s?page_No=${pubi.maxPage}">最后一页</a>
				&nbsp;&nbsp;
			</ul>
		 <span class="page-go-form"><label>跳转至</label>
	     <input type="text" name="inputPage" id="inputPage" class="page-key" />页
	     <button type="button" class="page-btn" >GO</button>
		</span>
		</div> 
  </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="/jsp/common/foot.jsp" %>

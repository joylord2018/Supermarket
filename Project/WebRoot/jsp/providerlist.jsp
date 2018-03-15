<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
<script type="text/javascript">
	$(function(){
		var id = "";
		$(".deleteProvider").click(function(){
			id = $(this).attr("data-id");
			$("#removeProv").show();
		});
		$("#yes").click(function(){
			location.href = "providerDelete/" + id;
		});
		
		$("#no").click(function(){
			$("#removeProv").hide();
		});
		
		$(".page-btn").click(function(){
			var pageNo=document.getElementById("inputPage").value;		
			if(pageNo!=""){
				location.href="providerlist.s?page_No="+pageNo;
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
            <span>供应商管理页面</span>
        </div>
        <div class="search">
        	<form method="post" action="providersearch.s">
				<input name="method" value="query" type="hidden">
				<span>供应商编码：</span>
				<input name="queryProCode" type="text" value="">
				
				<span>供应商名称：</span>
				<input name="queryProName" type="text" value="">
				
				<input value="查 询" type="submit" id="searchbutton">
				<a href="provideradd.s">添加供应商</a>
			</form>
        </div>
        <!--供应商操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">供应商编码</th>
                <th width="20%">供应商名称</th>
                <th width="10%">联系人</th>
                <th width="10%">联系电话</th>
                <th width="10%">传真</th>
                <th width="10%">创建时间</th>
                <th width="30%">操作</th>
            </tr>
  
				 <c:forEach items="${pup.list }" var="pli" >
	          		<tr>
						<td>
						<span>${pli.procode }</span>
						</td>
						<td>
						<span>${pli.proname }</span>
						</td>
						<td>
						<span>${pli.procontact }</span>
						</td>
						<td>
						<span>${pli.prophone }</span>
						</td>
						<td>
						<span>${pli.profax }</span>
						</td>
						<td>
						<span>
							${pli.createtionDate }
						</span>
						</td>
						<td>
							<span><a class="viewProvider" href="providerCheck/${pli.pid }" ><img src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>
							<c:if test="${user.userRole==4 }">
								<span><a class="modifyProvider" href="providerGetId.s?pid=${pli.pid }" ><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>
								<span><a class="deleteProvider" data-id="${pli.pid }" href="javascript:;"><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>
							</c:if>
						</td>        
					</tr>
				</c:forEach>
				
				<c:forEach items="${stProv }" var="ps" >
	          		<tr>
						<td>
						<span>搜索数据<br/>
						${ps.procode }</span>
						</td>
						<td>
						<span>${ps.proname }</span>
						</td>
						<td>
						<span>${ps.procontact}</span>
						</td>
						<td>
						<span>${ps.prophone }</span>
						</td>
						<td>
						<span>${ps.profax }</span>
						</td>
						<td>
						<span>
							${ps.createtionDate }
						</span>
						</td>
						<td>
							<span><a class="viewProvider" href="providerCheck/${ps.pid }" ><img src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>
							<c:if test="${user.userRole==4 }">
								<span><a class="modifyProvider" href="providerGetId.s?pid=${ps.pid }" ><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>
								<span><a class="deleteProvider" data-id="${ps.pid }" href="javascript:;"><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>
							</c:if>
						</td>      
					</tr> 
         	 </c:forEach>
        </table>
		<div class="page-bar">
			<ul class="page-num-ul clearfix">
				<li>共${pup.maxCount }条记录&nbsp;&nbsp;${pup.pageNo}/${pup.maxPage}页</li>
				
					<a href="providerlist.s?page_No=1">首页</a>
					<a href="providerlist.s?page_No=${pup.ago }">上一页</a>
				
					<a href="providerlist.s?page_No=${pup.after}">下一页</a>
					<a href="providerlist.s?page_No=${pup.maxPage}">最后一页</a>
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
<div class="remove" id="removeProv">
   <div class="removerChid">
       <h2>提示</h2>
       <div class="removeMain" >
           <p>你确定要删除该供应商吗？</p>
           <a href="#" id="yes">确定</a>
           <a href="#" id="no">取消</a>
       </div>
   </div>
</div>

<%@include file="/jsp/common/foot.jsp" %>


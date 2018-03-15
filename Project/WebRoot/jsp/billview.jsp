<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>

<div class="right">
     <div class="location">
         <strong>你现在所在的位置是:</strong>
         <span>订单管理页面 >> 信息查看</span>
     </div>
     <div class="providerView">
         <p><strong>订单编号：</strong><span>${bill.billCode }</span></p>
         <p><strong>商品名称：</strong><span>${bill.productName }</span></p>
         <p><strong>商品单位：</strong><span>${bill.productUnit }</span></p>
         <p><strong>商品数量：</strong><span>${bill.productCount }</span></p>
         <p><strong>总金额：</strong><span>${bill.totalPrice }</span></p>
         <p><strong>供应商：</strong><span>${bill.proName }</span></p>
         <p><strong>是否付款：</strong>
         	<c:choose>
					<c:when test="${bill.isPayment==1 }">
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
		</p>
		<div class="providerAddBtn">
         	<input type="button" id="back" name="back" value="返回" >
        </div>
     </div>
 </div>
</section>
<%@include file="/jsp/common/foot.jsp" %>

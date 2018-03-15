<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面 >> 供应商添加页面</span>
        </div>
        <div class="providerAdd">
           <form id="providerForm" name="providerForm" method="post" action="provideraddinfo.s">
			<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="procode">供应商编码：</label>
                    <input type="text" name="procode" id="procode" value=""> 
					<!-- 放置提示信息 -->
					<font color="red">${msg }</font>
					<font color="black">${procode }</font>
                </div>
                <div>
                    <label for="proname">供应商名称：</label>
                   <input type="text" name="proname" id="proname" value=""> 
					<font color="red">${proname }</font>
                </div>
                <div>
                    <label for="procontact">联系人：</label>
                    <input type="text" name="procontact" id="procontact" value=""> 
					<font color="red"></font>

                </div>
                <div>
                    <label for="prophone">联系电话：</label>
                    <input type="text" name="prophone" id="prophone" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="proaddress">联系地址：</label>
                    <input type="text" name="proaddress" id="proaddress" value=""> 
                </div>
                <div>
                    <label for="profax">传真：</label>
                    <input type="text" name="profax" id="profax" value=""> 
                </div>
                <div>
                    <label for="prodesc">描述：</label>
                    <input type="text" name="prodesc" id="prodesc" value=""> 
                </div>
                <div class="providerAddBtn">
                    <input type="submit" name="add" id="add" value="保存">
					<input type="button" id="back" name="back" value="返回" >
                </div>
           	</form>
     </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>


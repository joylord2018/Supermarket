<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>

  <div class="right">
      <div class="location">
          <strong>你现在所在的位置是:</strong>
          <span>供应商管理页面 >> 供应商修改页</span>
      </div>
      <div class="providerAdd">
          <form id="providerForm" name="providerForm" method="post" action="providerUpdate.s?pid=${prov.pid }">
              <!--div的class 为error是验证错误，ok是验证成功-->
              <div class="">
                  <label for="proCode">供应商编码：</label>
                  <input type="text" name="procode" id="proCode" value="${prov.procode }" readonly="readonly"> 
              </div>
              <div>
                  <label for="proName">供应商名称：</label>
                 <input type="text" name="proname" id="proName" value="${prov.proname}"> 
			<font color="red"></font>
              </div>
              
              <div>
                  <label for="proContact">联系人：</label>
                  <input type="text" name="procontact" id="proContact" value="${prov.procontact }"> 
			<font color="red"></font>
              </div>
              
              <div>
                  <label for="proPhone">联系电话：</label>
                  <input type="text" name="prophone" id="proPhone" value="${prov.prophone }"> 
			<font color="red"></font>
              </div>
              
              <div>
                  <label for="proAddress">联系地址：</label>
                  <input type="text" name="proaddress" id="proAddress" value="${prov.proaddress }"> 
              </div>
              
              <div>
                  <label for="proFax">传真：</label>
                  <input type="text" name="profax" id="proFax" value="${prov.profax }">
              </div>
              
              <div>
                  <label for="proDesc">描述：</label>
                  <input type="text" name="proDesc" id="proDesc" value="${prov.prodesc }"> 
              </div>
              <div class="providerAddBtn">
                  <input type="submit" name="save" id="save" value="保存">
				  <input type="button" id="back" name="back" value="返回" >
              </div>
          </form>
      </div>
  </div>
</section>
<%@include file="/jsp/common/foot.jsp" %>

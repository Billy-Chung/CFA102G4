<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.adoptPet.model.*"%>

<%
	// EmpVO empVO = (EmpVO) request.getAttribute("empVO");
%>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message.value}</li>
			</c:forEach>
		</ul>
	</c:if>
	
		<input type="hidden" name="adopt_meb_no" value="1">
		<div>${errorMsgs.ename}</div>


		<input type="hidden" name="gen_meb_no" value="">
		<div>${errorMsgs.ename}</div>


		<div class="form-floating mb-3">
			<input type="text" class="form-control" name="adopt_pet_breeds"
				placeholder="name@example.com"> <label for="floatingInput">領養寵物品種</label>
			<div>${errorMsgs.ename}</div>
		</div>

		<div class="form-check">
			<input class="form-check-input" type="radio" name="adopt_pet_gender"
				value="公"> <label class="form-check-label"
				for="flexRadioDefault1"> 公 </label>
		</div>
		<div class="form-check">
			<input class="form-check-input" type="radio" name="adopt_pet_gender"
				value="母"> <label class="form-check-label"
				for="flexRadioDefault2">母 </label>
		</div>
		<div class="form-floating mb-3">
			<input type="text" class="form-control" name="adopt_pet_come_form"
				placeholder="name@example.com"> <label for="floatingInput">來源</label>
			<div>${errorMsgs.ename}</div>
		</div>

		<div class="form-floating mb-3">
			<input type="Date" class="form-control" name="adopt_pet_join_date"
				placeholder="name@example.com"> <label for="floatingInput">入所日期</label>
			<div>${errorMsgs.ename}</div>
		</div>


		<div class="form-floating mb-3">
			<input type="text" class="form-control" name="adopt_pet_chip"
				placeholder="name@example.com" value="${errorMsgs.ename}"> <label
				for="floatingInput">晶片號碼</label>
			<div>${errorMsgs.ename}</div>
		</div>

		<div class="form-floating mb-3">
			<input type="text" class="form-control" name="adopt_pet_join_reason"
				placeholder="name@example.com" value="${errorMsgs.ename}"> <label
				for="floatingInput">進所原因</label>
			<div>${errorMsgs.ename}</div>
		</div>


		<div class="form-floating mb-3">
			<input type="text" class="form-control" name="capture_address"
				placeholder="name@example.com" value="${errorMsgs.ename}"> <label
				for="floatingInput">捕獲地址</label>
		</div>

		<div class="form-check">
			<input class="form-check-input" type="radio"
				name="adopt_pet_sterilization" value="是"> <label
				class="form-check-label" for="flexRadioDefault1"> 以絕育 </label>
		</div>
		<div class="form-check">
			<input class="form-check-input" type="radio"
				name="adopt_pet_sterilization" value="否"> <label
				class="form-check-label" for="flexRadioDefault2">未絕育 </label>
		</div>

		<div class="form-floating mb-3">
			<input type="text" class="form-control" name="contain_number"
				placeholder="name@example.com" value="${errorMsgs.ename}"> <label
				for="floatingInput">收容編號</label>
		</div>

		<div class="form-floating mb-3">
			<input type="text" class="form-control" name="adopt_pet_color"
				placeholder="name@example.com" value="${errorMsgs.ename}"> <label
				for="floatingInput">毛色</label>
		</div>

		<input type="hidden" name="adopt_pet_state" value="0">
		<div>${errorMsgs.ename}</div>
		
		<input type="hidden" name="action" value="addPet">

		<div class="modal-footer">
			<button type="button" class="btn btn-outline-danger"
				data-bs-dismiss="modal">關閉</button>
			<button type="submit" class="btn btn-outline-success">新增</button>
		</div>	


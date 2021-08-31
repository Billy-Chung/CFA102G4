<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.adoptPet.model.*"%>

<%
	AdoptPetVO adoptPet2 = (AdoptPetVO) request.getAttribute("adoptPetVO2");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message.value}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="addPet.do">

		<div class="form-floating mb-3">
			<input type="text" class="form-control" name="gen_meb_no"
				placeholder="新增領養者"
				value="<%=(adoptPet2.getGen_meb_no() == 0) ? "" : adoptPet2.getGen_meb_no()%>">
			<label for="floatingInput">新增領養會員</label>
		</div>

		<div class="form-floating mb-3">
			<input type="text" class="form-control" name="adopt_pet_breeds"
				placeholder="name@example.com"
				value="<%=(adoptPet2 == null) ? "" : adoptPet2.getAdopt_pet_breeds()%>">
			<label for="floatingInput">領養寵物品種</label>
		</div>

		<div class="form-floating mb-3">
			<input type="text" class="form-control" name="adopt_pet_gender"
				placeholder="name@example.com"
				value="<%=(adoptPet2 == null) ? "" : adoptPet2.getAdopt_pet_gender()%>">
			<label for="floatingInput">領養寵物性別</label>
		</div>


		<div class="form-floating mb-3">
			<input type="text" class="form-control" name="adopt_pet_come_form"
				placeholder="name@example.com"
				value="<%=(adoptPet2 == null) ? "" : adoptPet2.getAdopt_pet_come_form()%>">
			<label for="floatingInput">來源</label>

		</div>

		<div class="form-floating mb-3">
			<input type="Date" class="form-control" name="adopt_pet_join_date"
				placeholder="name@example.com"
				value="<%=(adoptPet2 == null) ? "" : adoptPet2.getAdopt_pet_join_date()%>">
			<label for="floatingInput">入所日期</label>
		</div>


		<div class="form-floating mb-3">
			<input type="text" class="form-control" name="adopt_pet_chip"
				placeholder="name@example.com"
				value="<%=(adoptPet2 == null) ? "" : adoptPet2.getAdopt_pet_chip()%>">
			<label for="floatingInput">晶片號碼</label>
		</div>

		<div class="form-floating mb-3">
			<input type="text" class="form-control" name="adopt_pet_join_reason"
				placeholder="name@example.com"
				value="<%=(adoptPet2 == null) ? "" : adoptPet2.getAdopt_pet_join_reason()%>">
			<label for="floatingInput">進所原因</label>
			<div>${errorMsgs.ename}</div>
		</div>


		<div class="form-floating mb-3">
			<input type="text" class="form-control" name="capture_address"
				placeholder="name@example.com"
				value="<%=(adoptPet2 == null) ? "" : adoptPet2.getCapture_address()%>">
			<label for="floatingInput">捕獲地址</label>
		</div>

		<div class="form-floating mb-3">
			<input type="text" class="form-control" name="capture_address"
				placeholder="name@example.com"
				value="<%=(adoptPet2 == null) ? "" : adoptPet2.getAdopt_pet_sterilization()%>">
			<label for="floatingInput">是否絕育</label>
		</div>

		<div class="form-floating mb-3">
			<input type="text" class="form-control" name="contain_number"
				placeholder="name@example.com"
				value="<%=(adoptPet2 == null) ? "" : adoptPet2.getContain_number()%>">
			<label for="floatingInput">收容編號</label>
		</div>

		<div class="form-floating mb-3">
			<input type="text" class="form-control" name="adopt_pet_color"
				placeholder="name@example.com"
				value="<%=(adoptPet2 == null) ? "" : adoptPet2.getAdopt_pet_color()%>">
			<label for="floatingInput">毛色</label>
		</div>


		<div class="form-floating mb-3">
			<input type="text" class="form-control" name="adopt_pet_state"
				placeholder="name@example.com"
				value="<%=(adoptPet2 == null) ? "" : adoptPet2.getAdopt_pet_state()%>">
			<label for="floatingInput">領養狀態</label>
		</div>


		<input type="hidden" name="action" value="update"> <input
			type="hidden" name="adopt_pet_no"
			value="<%=adoptPet2.getAdopt_pet_no()%>">

		<div class="modal-footer">
			<button type="button" class="btn btn-outline-danger"
				data-bs-dismiss="modal">關閉</button>

			<button type="submit" class="btn btn-outline-success">修改</button>
		</div>

	</FORM>
</body>
</html>
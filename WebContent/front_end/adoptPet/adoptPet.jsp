<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.adoptPet.model.*"%>
<%@ page import="com.adoptPetPhoto.model.*"%>

<%
	AdoptPetDAO dao = new AdoptPetDAO();
	List<AdoptPetVO> list = dao.getAllAdoptPet();
	pageContext.setAttribute("list", list);
%>

<!DOCTYPE html>
<html lang="zh-Hans">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>上傳寵物資訊</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<link href="fontawesome-free-5.15.4-web/css/all.css" rel="stylesheet">
<link href="petView.css" rel="stylesheet">
<script defer src="fontawesome-free-5.15.4-web/js/all.js"></script>
</head>

<body>
	<nav id="navbar-example2" class="navbar navbar-light px-3 onTop ">
		<a class="navbar-brand" href="#"> <i class="fas fa-dog fa-3x"></i>
			<i class="title">寵一而忠</i>
		</a>
		<ul class="nav nav-pills">
			<li class="nav-item"><a class="nav-link"
				href="#scrollspyHeading1"> <i class="fas fa-bell fa-2x"></i>
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="#scrollspyHeading2"> <i class="fas fa-envelope fa-2x"></i>
			</a></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
				role="button" aria-expanded="false"> <i
					class="fas fa-address-card fa-2x"></i> <i class="titleName">機構會員名稱</i>
			</a>
				<ul class="dropdown-menu ">
					<li><a class="dropdown-item" href="#scrollspyHeading3">忘記密碼</a></li>
					<li>
						<hr class="dropdown-divider">
					</li>
					<li><a class="dropdown-item" href="#scrollspyHeading5">登出</a></li>
				</ul></li>
		</ul>
	</nav>



	<div class="main">
		<div class="left">
			<div class="Ingrediends">
				<h3>
					<i class="fas fa-tools fa-2x"></i> 功能列表 <span class="arrow"></span>
				</h3>
			</div>
			<div class="onTopmenu">
				<a href="petView.html">寵物資料管理</a>
			</div>
			<div class="oneTopmenu">
				<a
					href="<%=request.getContextPath()%>/front_end/adoptMember/petMember.html">機構資訊管理</a>
			</div>
			<div class="oneTopmenu">
				<a>領養管理</a>
			</div>
		</div>
		<div class="right">

			<button type="button" class="btn btn-outline-info newInfo"
				data-bs-toggle="modal" data-bs-target="#newpet">新增寵物資料</button>

			<!-- Modal -->
			<div class="modal fade" id="newpet" data-bs-backdrop="static"
				data-bs-keyboard="false" tabindex="-1"
				aria-labelledby="staticBackdropLabel" aria-hidden="true">
				<div class="modal-dialog modal-xl">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="staticBackdropLabel">新增寵物資料</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<FORM METHOD="post" ACTION="addPet.do" name="newPet">
								<%@ include file="addPet.jsp"%>
							</FORM>
						</div>
					</div>
				</div>
			</div>

			<!-- 當前寵物清單搜尋列 -->
			<div class="navbar navbar-light bg-light putRight">
				<div class="container-fluid">
					<div class="blockLeft">
						<i class="titleName">當前領養寵物列表</i>
					</div>
					<div class="blockRight">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</div>
				</div>
			</div>

			<%@ include file="page1.file"%>
			<c:forEach var="AdoptPetVO" items="${list}" begin="<%=pageIndex%>"
				end="<%=pageIndex+rowsPerPage-1%>">

				<div class="card pdct_card" style="width: 18rem;">
					<img src="images/dog1.jpg" class="card-img-top" alt="狗">
					<div class="card-body">
						<h5 class="card-title">${AdoptPetVO.adopt_pet_breeds}</h5>
						<p class="card-text">${AdoptPetVO.adopt_pet_gender}</p>


						<FORM METHOD="post" ACTION="addPet.do">
							<input type="hidden" name="adoptPetNo"
								value="${AdoptPetVO.adopt_pet_no}"> <input type="hidden"
								name="action" value="getOne_For_Update">
							<button type="submit" class="btn btn-outline-info">修改詳細資訊</button>
						</FORM>

						<FORM METHOD="post" ACTION="addPet.do">
						<input type="hidden" name="adopt_pet_no"value="${AdoptPetVO.adopt_pet_no}"> 
						<input type="hidden" name="gen_meb_no"value="${AdoptPetVO.gen_meb_no}"> 
						<input type="hidden" name="adopt_pet_breeds"value="${AdoptPetVO.adopt_pet_breeds}"> 
						<input type="hidden" name="adopt_pet_gender"value="${AdoptPetVO.adopt_pet_gender}"> 
						<input type="hidden" name="adopt_pet_come_form"value="${AdoptPetVO.adopt_pet_come_form}"> 
						<input type="hidden" name="adopt_pet_join_date"value="${AdoptPetVO.adopt_pet_join_date}"> 
						<input type="hidden" name="adopt_pet_chip"value="${AdoptPetVO.adopt_pet_chip}"> 
						<input type="hidden" name="adopt_pet_join_reason"value="${AdoptPetVO.adopt_pet_join_reason}"> 
						<input type="hidden" name="capture_address"value="${AdoptPetVO.capture_address}"> 
						<input type="hidden" name="capture_address"value="${AdoptPetVO.capture_address}"> 
						<input type="hidden" name="contain_number"value="${AdoptPetVO.contain_number}"> 
						<input type="hidden" name="adopt_pet_color"value="${AdoptPetVO.adopt_pet_color}"> 
							<input type="hidden" name="adopt_pet_state"value="${AdoptPetVO.adopt_pet_state}">
							 <input type="hidden"name="action" value="delete">
							 <c:if test="${AdoptPetVO.adopt_pet_state == 0}">
							<button type="submit" class="btn btn-outline-danger">修改為已領養</button>
							 </c:if>
							 <c:if test="${AdoptPetVO.adopt_pet_state == 1}">
							<button type="submit" class="btn btn-outline-success">修改為未領養</button>
							 </c:if>
						</FORM>

					</div>
				</div>
			</c:forEach>
		</div>

	</div>


	<%@ include file="page2.file"%>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
		crossorigin="anonymous">
		
	</script>
</body>
</html>
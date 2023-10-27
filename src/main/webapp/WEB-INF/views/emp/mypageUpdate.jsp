<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- jsp에서 properties 메세지를 사용할 수 있도록 하는 API -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en" class="light-style layout-menu-fixed" dir="ltr"
	data-theme="theme-default" data-assets-path="/assets/"
	data-template="vertical-menu-template-free">
<head>
<c:import url="/WEB-INF/views/layout/headCSS.jsp"></c:import>
</head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<!-- Layout wrapper -->
	<div class="layout-wrapper layout-content-navbar">
		<div class="layout-container">
			<c:import url="/WEB-INF/views/layout/sidebar.jsp"></c:import>
			<!-- Layout container -->
			<div class="layout-page">
				<c:import url="/WEB-INF/views/layout/topbar.jsp"></c:import>
				<!-- Content wrapper -->
			<form action="mypageUpdate" method="post" enctype="multipart/form-data">
			<sec:authentication property="Principal" var="vo"/>
				<div class="content-wrapper">
					<!-- Content -->
					<!-- 내용부분-->
					<div class="container-xxl flex-grow-1 container-p-y">
					<div class="card shadow mb-4">
			
						<div style="width:900px; float: left; margin-bottom: 30px; margin-left: 250px;">
								<div style="width: 300px; float: left;">
									<img alt="" src="/resources/images/${vo.originalFileName}" style="width: 200px; height: 200px; margin: 30px;">
								</div>
							<div style="width: 550px; margin-top: 20px; float: left;">
								<input type="hidden" name="username" value="${vo.username}">
								<input type="hidden" name="fileName" value="${vo.fileName}">
								<table class="table">
									
									<tr>
										<td>사번</td>
										<td>${vo.username}</td>
									</tr>
									<tr>
										<td>이름</td>
										<td>${vo.name}</td>
									</tr>
									<tr>
										<td>부서</td>
										<td>${vo.deptName}</td>
									</tr>
									<tr>
										<td>직급</td>
										<td>${vo.positionName}</td>
									</tr>

								</table>							
							</div>
							<br>
							<div>
								<table class="table">
									<tr>
										<td>입사일</td>
										<td>${vo.hireDate}</td>
									</tr>
									<tr>
										<td>이메일</td>
										<td><input type="email" id="email" name="email" value="${vo.email}"></td>
									</tr>
									<tr>
										<td>연락처</td>
										<td><input type="text" id="phone" name="phone" value="${vo.phone}"></td>
									</tr>
									<tr>
										<td>생년월일</td>
										<td>${vo.birth}</td>
									</tr>

								</table>
							</div>
						</div>
					</div>
					<button class="btn btn-danger" id="btn_update">수정완료</button>
					<!-- / Content -->
					</div>
				</div>
				</form>
				<!-- Content wrapper -->
			</div>
			<!-- / Layout page -->
		</div>

		<!-- Overlay -->
		<div class="layout-overlay layout-menu-toggle"></div>
	</div>
	<!-- / Layout wrapper -->
	<c:import url="/WEB-INF/views/layout/footjs.jsp"></c:import>

<script type="text/javascript">

/* let index = {
		init: function(){
			$("#btn_update").on("click",()=>{
				this.update();
			});
		},
		
		update: function(){
			let data = {
					email: $("#email").val(),
					phone: $("#phone").val()
			};
			
			$.ajax({
				//회원정보 수정 요청
				type: "PUT",
				url: "/emp/mypage/mypageUpdate",
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				dataType:"json"
				//응답 정상일 때 
			}).done(function(resp){
				alert("회원정보 수정이 완료되었습니다.");
				location.href="/"
			}).fail(function(error){
				alert(JSON.stringify(error));
			});
		}

} */

</script>

</body>
</html>
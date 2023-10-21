<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- jsp에서 properties 메세지를 사용할 수 있도록 하는 API -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
			<div class="layout-page" style="align-items:center;">
				<c:import url="/WEB-INF/views/layout/topbar.jsp"></c:import>
				<form>
				<!-- Content wrapper -->
					<br><h3 style="/* margin-right: 1200px; */">${emp.name}의 마이페이지</h3>
				<div class="card shadow mb-4" style="width: 1400px;">										
							<div style="width:900px; float: left; margin-bottom: 30px; margin-left: 250px;">
								<div style="width: 300px; float: left;">
									<img alt="" src="/resources/images/${emp.originalFileName}" style="width: 200px; height: 200px; margin: 30px;">
								</div>
							<div style="width: 550px; margin-top: 20px; float: left;">
								<table class="table">
									<tr>
										<td>사번</td>
										<td>${emp.empNo}</td>
									</tr>
									<tr>
										<td>이름</td>
										<td>${emp.name}</td>
									</tr>
									<tr>
										<td>부서</td>
										<td>${vo.deptNo}</td>
									</tr>
									<tr>
										<td>직급</td>
										<td>${emp.positionNo}</td>
									</tr>

								</table>							
							</div>
							<br>
							<div>
								<table class="table">
									<tr>
										<td>입사일</td>
										<td>${emp.hireDate}</td>
									</tr>
									<tr>
										<td>이메일</td>
										<td>${emp.email}</td>
									</tr>
									<tr>
										<td>연락처</td>
										<td>${emp.phone}</td>
									</tr>
									<tr>
										<td>생년월일</td>
										<td>${emp.birth}</td>
									</tr>

								</table>
							</div>
						</div>
				</div>
				
				<!-- Content wrapper -->
							<a href="/emp/empUpdate?empNo=${vo.empNo}" class="btn btn-danger">수정</a>
					</form>
			</div>
			<!-- / Layout page -->
		</div>
		<!-- Overlay -->
		<div class="layout-overlay layout-menu-toggle"></div>
	</div>
	<!-- / Layout wrapper -->
	<c:import url="/WEB-INF/views/layout/footjs.jsp"></c:import>

</body>
</html>
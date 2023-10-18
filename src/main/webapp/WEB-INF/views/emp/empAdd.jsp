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
				<!-- Content wrapper -->
					<br><h3 style="margin-right: 1200px;">신규 사원 등록</h3>
				<div class="card shadow mb-4" style="width: 1400px;">										
							<div style="width: 300px; float: left; margin-top: 20px; margin-bottom: 20px;">
								<img alt="" src="/resources/images/default.jpeg" style="width: 200px; height: 200px; margin-left: 80px;">
							</div>
							<div style="width:900px; height:200px; float: left; margin-top: 30px; ">
								<table style="border-color: black;">
									
									<tr>
										<td>이름</td>
										<td><input type="text" value=""></td>
									</tr>
									<tr>
										<td>이메일</td>
										<td><input type="text" value=""></td>
									</tr>
									<tr>
										<td>연락처</td>
										<td><input type="text" value=""></td>
									</tr>
									<tr>
										<td>입사일</td>
										<td><input type="date" value=""></td>
									</tr>
									<tr>
										<td>생년월일</td>
										<td><input type="date" value=""></td>
									</tr>
									<tr>
										<td>주소</td>
										<td><input type="text" value=""></td>
									</tr>
								</table>
							
							
							</div>
						</div>
				<!-- Content wrapper -->
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
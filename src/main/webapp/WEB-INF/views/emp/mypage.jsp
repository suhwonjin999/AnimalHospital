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
			<div class="layout-page">
				<c:import url="/WEB-INF/views/layout/topbar.jsp"></c:import>
				<!-- Content wrapper -->
				<div class="content-wrapper">				
					<!-- Content -->
					<!-- 내용부분-->
					<div class="container-xxl flex-grow-1 container-p-y">
						<div style="width: 1295px; height: 900px;">
							<h3>마이페이지</h3> <br><br>
							<div style="width: 300px; float: left;">
								<img alt="" src="/resources/images/default.jpeg" style="width: 200px; height: 200px; margin-left: 50px;">
							</div>
							<div style="width:900px; height:200px; float: left; margin-top: 10px;">
								<table style="border-color: black;">
									<tr>
										<td>사번</td>
										<td><input type="text" value=""></td>
									</tr>
									<tr>
										<td>이름</td>
										<td><input type="text" value=""></td>
									</tr>
									<tr>
										<td>부서</td>
										<td><input type="text" value=""></td>
									</tr>
									<tr>
										<td>직급</td>
										<td><input type="text" value=""></td>
									</tr>
								</table>
							
							</div>
							<div style="width:800px; margin-left: 50px;">
								<table style="border-color: black;">
									<tr>
										<td>입사일</td>
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
										<td>생년월일</td>
										<td><input type="text" value=""></td>
									</tr>
									<tr>
										<td>주소</td>
										<td><input type="text" value=""></td>
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!-- / Content -->
					<c:import url="/WEB-INF/views/layout/footer.jsp"></c:import>
					<div class="content-backdrop fade"></div>
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
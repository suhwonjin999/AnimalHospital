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
				<form>
					<br><h3>사원 목록</h3>
				<div class="card shadow mb-4" style="width: 1400px; margin: auto;">				
					<!-- Content -->
					
					<table class="table" style="text-align: center; width:auto; margin: 20px; ">
						<thead style="height: 70px;">
							<tr>
								<th>사원번호</th>
								<th>이름</th>
								<th>부서</th>
								<th>직급</th>
								<th>이메일</th>
								<th>연락처</th>
								<th>입사일</th>
								<th>상태</th>
							</tr>
						</thead>
						<tbody style="height: 35px;">
					<c:forEach items="${list}" var="vo">
							<tr>
								<%-- <td><a href="./empDetail?empNo=${vo.empNo}" style="color: #697a8d;">${vo.empNo}</a></td>
								<td><a href="./empDetail?empNo=${vo.empNo}" style="color: #697a8d;">${vo.name}</a></td> --%>
								<td><a href="./empDetail?username=${vo.username}" style="color: #697a8d;">${vo.username}</a></td>
								<td><a href="./empDetail?username=${vo.username}" style="color: #697a8d;">${vo.name}</a></td>
								<td>${vo.deptName}</td>
								<td>${vo.positionName}</td>
								<td>${vo.email}</td>
								<td>${vo.phone}</td>
								<td>${vo.hireDate}</td>
								<td>${vo.state}</td>
							</tr>
					</c:forEach>
						</tbody>
					
					</table>
					<br>
				</div>
					<a href="/emp/empAdd" class="btn btn-secondary">신규직원 등록</a>
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

</body>
</html>
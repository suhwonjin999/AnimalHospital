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
<title>공지사항</title>

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
					<br><h3 style="margin-right: 1300px;">공지사항</h3>
					<select>
					<option value="1">제목+내용</option>
					<option value="2">제목</option>
					<option value="3">내용</option>
					</select>
				<div class="card shadow mb-4" style="width: 1400px;">				
					<!-- Content -->
					
					<table class="table tb" style="text-align: center; ">
						<thead style="height: 70px;">
							<tr>
								<th>공지번호</th>
								<th>작성자</th>
								<th>제목</th>
								<th>조회수</th>
							</tr>
						</thead>
<%-- 					<c:forEach items="${list}" var="vo">
						<tbody style="height: 35px;">
							<tr>
								<td><a href="./empDetail?empNo=${vo.empNo}">${vo.empNo}</a></td>
								<td><a href="./empDetail?empNo=${vo.empNo}">${vo.name}</a></td>
								<td>${vo.deptName}</td>
								<td>${vo.positionName}</td>
								<td>${vo.email}</td>
								<td>${vo.phone}</td>
								<td>${vo.hireDate}</td>
								<td>${vo.state}</td>
							</tr>
						</tbody>
					</c:forEach> --%>
					
					</table>
					<br>					
				</div>
				
				<div>
				<a href="/board/boardAdd" class="btn btn-secondary" style="width: 120px; height: 50px; color: white;"><button>작성</button></a>
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
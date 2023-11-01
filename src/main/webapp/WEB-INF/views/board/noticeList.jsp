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
<meta charset="UTF-8">
<title>공지사항</title>
</head>

<body>
	<!-- Layout wrapper -->
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
					
					<form>
					<h3>공지사항</h3>
						<select>
						<option value="1">제목+내용</option>
						<option value="2">제목</option>
						<option value="3">내용</option>
						</select>
					<div class="card shadow mb-4">
								
							<!-- Content -->
							
							<table class="table" style="text-align: center; width:auto; margin: 20px; ">
								<thead style="height: 70px;">
									<tr>
										<th>공지번호</th>
										<th>작성자</th>
										<th>제목</th>
										<th>조회수</th>
									</tr>
								</thead>
								<tbody style="height: 35px;">
							<c:forEach items="${list}" var="vo">
									<tr>
										<td><a href="./noticeDetail?noticeNo=${vo.noticeNo}" style="color: #697a8d;">${vo.noticeNo}</a></td>
										<td>${vo.empName}</td>
										<td><a href="./noticeDetail?title=${vo.title}">${vo.title}</a></td>
										<td>${vo.hit}</td>
									</tr>
							</c:forEach>
								</tbody>
							</table>
							<br>
						</div>
						<a href="/board/noticeAdd" class="btn btn-secondary">작성</a>
						</form>
					</div>
					<!-- / Content -->
<%-- 					<c:import url="/WEB-INF/views/layout/footer.jsp"></c:import> --%>
					<div class="content-backdrop fade"></div>
				</div>
				<!-- Content wrapper -->
			</div>
			<!-- / Layout page -->
		</div>
	</div>
		<!-- Overlay -->
		<div class="layout-overlay layout-menu-toggle"></div>
	<!-- / Layout wrapper -->
	<c:import url="/WEB-INF/views/layout/footjs.jsp"></c:import>


</body>
</html>
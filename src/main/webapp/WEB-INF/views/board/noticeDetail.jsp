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
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<c:import url="/WEB-INF/views/layout/headCSS.jsp"></c:import>
<meta charset="UTF-8">
<title>공지사항 상세페이지</title>
<style>
/* 테이블 셀 안의 테두리 색상을 흰색으로 설정 */
.table th, .table td {
    border: 1px solid white;
}

div {
    text-align: left;
}
</style>
<script>
/*  	$(document).ready(function(){
		$("#deleteBtn").click(function(){
			if(confirm("삭제하시겠습니까?")){
				document.frm.action="${path}/board/noticeDelete"
				document.frm.submit();
			}
		})
	}) */ 
</script>
</head>

<body>
	<sec:authentication property="Principal" var="user"/>
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
					
					<form name="boardInfo" id="boardInfo">
					<!-- <form action="noticeDetail" name="frm" id="frm" method="get"> -->
					<!-- Content wrapper -->
					<h3><%-- ${user.empName}&nbsp; --%>${vo.noticeNo}번 공지사항</h3>
					<div class="card shadow mb-4" style="align-items: center;">
								
							<!-- Content -->
							
							<table class="table" style="text-align: center; width:auto; margin: 20px auto; ">
									<tr>
										<th>제목 :</th>
										<td><div>${vo.title}</div></td>
									</tr>
									<tr>
										<th>작성자 :</th>
										<td>${user.empName}</td>
									</tr>
									<tr>
										<th>작성일자 :</th>
										<td>${vo.createDate}</td>
									</tr>								
									<tr>
										<th>수정일자 :</th>
										<td>${vo.modifyDate}</td>
									</tr>
									<tr>
										<th>내용 :</th>
									</tr>
								</table>
								<table>
									<tr>
										<td><div>${vo.contents}</div></td>
									</tr>
									
<%-- 							<c:forEach items="${list}" var="vo">
									<tr>
										<td><a href="./boardDetail?noticeNo=${vo.noticeNo}" style="color: #697a8d;">${vo.noticeNo}</a></td>
										<td>${user.username}</td>
										<td><a href="./boardDetail?title=${vo.title}" style="color: #697a8d;">${vo.title}</a></td>
										<td>${vo.hit}</td>
									</tr>
							</c:forEach> --%>
							</table>
							<br>
						  </div>
						<!-- Content wrapper -->
						<a href="/board/noticelist?username=${user.username}" class="btn btn-secondary">목록</a>
						<a href="/board/noticeUpdate?noticeNo=${vo.noticeNo}" class="btn btn-secondary">수정</a>
						<!-- <button type="button" class="btn btn-secondary" id="deleteBtn">삭제</button> -->
						<a href="/board/noticeDelete?noticeNo=${vo.noticeNo}" class="btn btn-secondary">삭제</a>
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

<!-- <script src="/resources/js/board/noticeUpdate.js"></script> -->
</body>
</html>
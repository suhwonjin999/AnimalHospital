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
<title>고객정보 목록</title>
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
					
						<table class="table">
						  <thead>
						    <tr>
						      <th>고객번호</th>
						      <th>이름</th>
						      <th>보호자 이름</th>
						    </tr>
						  </thead>
						  <tbody>
						    <c:forEach items="${list}" var="vo">
						    	<tr>
						    		<td>${vo.customerNo}</td>
						    		<td><a href="./detail?customerNo=${vo.customerNo}">${vo.animalName}</a></td>
						    		<td>${vo.name}</td>
						    	</tr>
						    </c:forEach>
						  </tbody>
						</table>
						
						<!-- 페이징 -->
						<nav aria-label="Page navigation example">
						  	<ul class="pagination justify-content-center">
							  <%-- <c:if test="${pager.pre}"> --%>
							    <li class="page-item ${pager.pre?'':'disabled'}">
							      <a class="page-link" href="./list?page=${pager.startNum - 1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
							        <span aria-hidden="true">&laquo;</span>
							      </a>
							    </li>
							   	<%-- </c:if> --%>
							    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
							    <li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
							    </c:forEach>
							    <c:if test="${pager.next}">
							    <li class="page-item">
							      <a class="page-link" href="./list?page=${pager.lastNum + 1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
							        <span aria-hidden="true">&raquo;</span>
							      </a>
							    </li>
							    </c:if>
							</ul>
						</nav>
						
						<!-- 검색 -->
						<div class="input-group mb-3">
							<form action="./list" method="get" id="frm">
								<input type="hidden" value="${pager.page}" id="page" name="page">
							  <select name="kind" id="k" class="form-select" data-kind="${pager.kind}" aria-label="Default select example">
								  <option class="kind" value="animalName">이름</option>
								  <option class="kind" value="name">보호자이름</option>
							  </select>
							  <input type="text" name="search" value="${pager.search}" class="form-control" aria-label="Amount (to the nearest dollar)">
							  <div class="col-auto">
					    		<button type="submit" class="btn btn-primary">검색</button>
					 		  </div>
				 		  </form>
						</div>
					
					<a class="btn btn-primary" style="float:right" href="./add">등록</a>
					
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
	
	<script src="/js/customer/list.js"></script>

</body>
</html>
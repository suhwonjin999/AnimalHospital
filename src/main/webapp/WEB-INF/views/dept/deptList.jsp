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
  <style>
  	ul {
  		list-style: none;
  	}
	.tree {
	    list-style: none;
	    padding-left: 1em;
	}
    .tree *:before{
   	  list-style: none;
      width:17px;
      height:17px;
      display:inline-block;
    }	
	input[type="checkbox"] {
		list-style: none;
	    display: none;
	}
	
	label::before {
		list-style: none;
	    content: "+";
	    margin-right: 5px;
	}
	
	input[type="checkbox"]:checked + label::before {
		list-style: none;
	    content: "-"; 
	}

	input[type="checkbox"] + label + ul {
		list-style: none;
	    display: none;
	}
  </style>
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
					<div class="container-xxl flex-grow-1 container-p-y">
							<br><h3>조직도 / 사원 목록</h3>
					<form>
					<div class="card shadow mb-4" style="width: 20%; float: left; height: 600px;">	
					 	<c:forEach items="${list}" var="vo">
						 	<ul class="tree">
						 		<li>
						 			<c:if test="${vo.depth == 0}">
							 			<input type="checkbox" id="dept${vo.deptNo}">
							 			<label for="dept${vo.deptNo}">${vo.deptName}</label>				 			
						 			</c:if>
						 			<ul>
						 				<li>
						 					<c:if test="${vo.depth == 1 && vo.parentNo == 0 && vo.deptNo != 300}">
									 			<label for="dept${vo.deptNo}">${vo.deptName}</label>				 			
								 			</c:if>
						 				</li>
						 				<li>
						 					<c:if test="${vo.deptNo == 300}">
						 						<input type="checkbox" id="dept${vo.deptNo}">
									 			<label for="dept${vo.deptNo}">${vo.deptName}</label>				 			
								 			</c:if>
						 					
								 			<ul>
								 				<li>
								 					<c:if test="${vo.depth == 2 && vo.parentNo == 300}">
											 			<label for="dept${vo.deptNo}">${vo.deptName}</label>				 			
										 			</c:if>
								 				</li>
								 			</ul>
						 				
						 				</li>
						 			</ul>
						 		</li>
						 	</ul>	
					 	</c:forEach>
					</div>

					<div class="card shadow mb-4" style="width:78%; float: right;">			
							<!-- Content -->
							
							<table class="table" style="text-align: center; width:auto; margin: 20px; ">
								<thead style="height: 70px;">
									<tr>
										<th>사원번호</th>
										<th>이름</th>
										<th>부서</th>
										<th>직급</th>
										<th>입사일</th>
										<th>상태</th>
									</tr>
								</thead>
								<tbody style="height: 35px;">
							<c:forEach items="${emp}" var="vo">
									<tr>
										<td><a href="/emp/empDetail?empNo=${vo.empNo}" style="color: #697a8d;">${vo.empNo}</a></td>
										<td><a href="/emp/empDetail?empNo=${vo.empNo}" style="color: #697a8d;">${vo.name}</a></td>
										<td>${vo.deptName}</td>
										<td>${vo.positionName}</td>
										<td>${vo.hireDate}</td>
										<td>${vo.state}</td>
									</tr>
							</c:forEach>
								</tbody>
							
							</table>
						</div>
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

		<!-- Overlay -->
		<div class="layout-overlay layout-menu-toggle"></div>
	</div>
	<!-- / Layout wrapper -->
	<c:import url="/WEB-INF/views/layout/footjs.jsp"></c:import>

</body>
</html>
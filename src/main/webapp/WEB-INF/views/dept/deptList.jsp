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

<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
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
					<h3>조직도 / 사원 목록</h3>
					<form>
					<div class="card shadow mb-4" style="width: 20%; float: left; height: 650px;">	
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
					<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addModal" data-bs-whatever="@getbootstrap">추가</button>
					</div>

					<div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h1 class="modal-title fs-5" id="exampleModalLabel">부서 등록</h1>
					        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					      </div>
					      <div class="modal-body">
					      	<form action="deptAdd" method="post">
					      	<input type="hidden" id="deptNo" name="deptNo">
					      	<input type="hidden" id="depth" name="depth">
					          <div class="mb-3">
					            <label for="deptName" class="col-form-label">부서명:</label>
					            <input type="text" class="form-control" id="deptName" name="deptName">
					          </div>
					          <div class="mb-3">
					            <label for="parentNo" class="col-form-label">상위부서:</label>
					            <select class="form-control" id="parentNo" name='parentNo'>
					            	<option value="200">인사행정부</option>
					            	<option value="300">진료부</option>
					            	<option value="NULL">없음</option>
					            </select>
					          </div>
					          
							      <div class="modal-footer">
			                       <button type="button" id="closeBtn"class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
			                       <button type="button" id="addBtn" class="btn btn-primary">Add</button>
							      </div>
							   </form>   
					      </div>
					    </div>
					  </div>
					</div>

					<div class="card shadow mb-4" style="width:78%; float: right; height: 650px;">			
							<!-- Content -->
							
							<table class="table" style="text-align: center; width:auto; margin: 20px;">
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
										<td><a href="/emp/empDetail?username=${vo.username}" style="color: #697a8d;">${vo.username}</a></td>
										<td><a href="/emp/empDetail?username=${vo.username}" style="color: #697a8d;">${vo.empName}</a></td>
										<td>${vo.deptName}</td>
										<td>${vo.positionName}</td>
										<td>${vo.hireDate}</td>
										<td>${vo.state}</td>
									</tr>
							</c:forEach>
								</tbody>
							
							</table>
						<div class="d-flex justify-content-between mb-3">
						<div>
							<!-- 검색 -->
							<div class="input-group mb-3">
								<form action="./deptList" method="get" class="d-flex align-items-center" id="frm">
									<div class="input-group" style="width: 120px;">
										<input type="hidden" value="${pager.page}" id="page" name="page">
										<select name="kind" id="k" class="form-select"
											data-kind="${pager.kind}" aria-label="Default select example" style="width: 50px;">
											<option class="kind" value="empName">이름</option>
											<option class="kind" value="username">사원번호</option>
										</select>
									</div> 
									<input type="text" name="search" value="${pager.search}"
										class="form-control" aria-label="Amount (to the nearest dollar)" style="width: 150px;">
										<button type="submit" class="btn btn-primary" style="width:100px;">검색</button>
								</form>
							</div>
						</div>
    					<div>
    						<!-- 페이징 -->
							<nav aria-label="Page navigation example">
								<ul class="pagination justify-content-center">
									<c:if test="${pager.pre}">
									<li class="page-item ${pager.pre?'':'disabled'}"><a
										class="page-link"
										href="./deptList?page=${pager.startNum - 1}&kind=${pager.kind}&search=${pager.search}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
									</c:if>
									<c:forEach begin="${pager.startNum}" end="${pager.lastNum}"
										var="i">
										<li class="page-item"><a class="page-link"
											href="./deptList?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
									</c:forEach>
									<c:if test="${pager.next}">
										<li class="page-item"><a class="page-link"
											href="./deptList?page=${pager.lastNum + 1}&kind=${pager.kind}&search=${pager.search}"
											aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										</a></li>
									</c:if>
								</ul>
							</nav>
    					</div>
    					<div> 						
    					</div>
					</div>
							
						</div>
						
						</form>
					</div>

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

	<script type="text/javascript">
	
	$('#addBtn').on("click", function(){
	    let deptName = $("#deptName").val();
	    let parentNo = $("#parentNo").val();

	    let data = {
	        deptName: deptName,
	        parentNo: parentNo
	    };
	    
	    $.ajax({
			url:"/dept/deptList/deptAdd",
			data:data,
			method:"POST",	
			contentType: "application/json",
			success : function(data){
				console.log(data);
				alert("등록이 완료되었습니다!")																		
			},
			error : function() {
				alert("실패..")
			}
		})

	    $("#addModal").modal("hide");
	    $("#deptName").val("");
	    $("#parentNo").val("");

	    location.href = "/dept/deptList";
	});
	
	</script>

</body>
</html>
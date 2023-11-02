<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- jsp에서 properties 메세지를 사용할 수 있도록 하는 API -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/layout/headCSS.jsp"></c:import>
</head>
<body id="page-top">
	    <!-- Page Wrapper -->
	    <div id="wrapper">
	    	<!-- sidebar -->
	    	<%-- <c:import url="/WEB-INF/views/layout/sidebar.jsp"></c:import> --%>
	    	
	    	<div id="content-wrapper" class="d-flex flex-column">
	    		<div id="content">
	    		
	    		<%-- <c:import url="/WEB-INF/views/layout/topbar.jsp"></c:import> --%>
	    		
		    		<div class="container-fluid">
		    				<!-- Content -->

						    <div class="container-xxl">
						      <div class="authentication-wrapper authentication-basic container-p-y">
						        <div class="authentication-inner">
						          <!-- Register -->
						          <div class="card">
						            <div class="card-body">
						              <!-- Logo -->
						              <div class="app-brand justify-content-center">
						                <a href="#" class="app-brand-link gap-2">
						                  <img alt="" src="/resources/images/jisun3.png" style="width: 40px;" height="40px;">
						                  <span class="app-brand-text demo text-body fw-bolder">Animal Hospital</span>
						                </a>
						              </div>
						              <!-- /Logo -->
						              <h4 class="mb-2">Welcome to Animal Hospital! 👋</h4>
						              <p class="mb-4">Please sign-in to your account and start the adventure</p>
										<div>
										
											<form:form modelAttribute="empVO" action="/emp/login" method="POST">
											  <div class="form-group">
											  	<form:label path="username">사원번호</form:label>
												<form:input  id="username" path="username" cssClass="form-control"/>					
											 
											  </div>
											  <div class="form-group">
											  	<form:label path="password">비밀번호</form:label>
											    <form:password id="password" path="password" cssClass="form-control"/>
											  
											  </div>
											  <button type="submit" class="btn btn-primary" style="margin-top: 30px;">로그인</button>

							        		</form:form>	
							        		
										</div>

									 <p class="text-center">
						                <a style="color: blue;" data-bs-toggle="modal" data-bs-target="#findUsername">
						                  <span>사원번호 /</span>
						                </a>
						                <a style="color: blue;" data-bs-toggle="modal" data-bs-target="#exampleModal">
						                  <span>비밀번호 찾기</span>
						                </a>
						              </p>
										
						              
						             <!-- 사원번호 찾기 modal -->
						              <div class="modal fade" id="findUsername" tabindex="-1" aria-labelledby="findUsernameLabel" aria-hidden="true">
										  <div class="modal-dialog">
										    <div class="modal-content">
										      <div class="modal-header">
										        <h1 class="modal-title fs-5" id="findUsernameLabel">사원번호 찾기</h1>
										        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
										      </div>
										      <div class="modal-body" style="margin: auto;">
					
										        <table>

													<tr>
														<td>이름</td>
													 	<td>
													 		<input type="text" class="form-control" name="empName" placeholder="이름을 입력해주세요.">
													 	</td>
												 	</tr>

												 	<tr>
														<td>이메일</td>
													 	<td>
													 		<input type="email" class="form-control" name="email" placeholder="이메일을 입력해주세요.">
													 		<!-- <input type="button" class="form-control" id="sendMail" value="인증번호전송">  -->
													 	</td>
												 	</tr>

											 	</table>
										          <br><br>
										          
												 <div class="modal-footer">
												   <button class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
												   <button class="btn btn-primary" id="addBtn">추가</button>
												 </div>
					
										      </div>
										    </div>
										  </div>
										</div>
										
										
						              <!-- 비밀번호 찾기 modal -->
						              <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
										  <div class="modal-dialog">
										    <div class="modal-content">
										      <div class="modal-header">
										        <h1 class="modal-title fs-5" id="exampleModalLabel">비밀번호 찾기</h1>
										        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
										      </div>
										      <div class="modal-body" style="margin: auto;">
					
										        <table>
													<tr>
														<td>사원번호</td>
													 	<td><input type="text" class="form-control" name="username" placeholder="사원번호를 입력해주세요."></td>
												 	</tr>

													<tr>
														<td>이름</td>
													 	<td>
													 		<input type="text" class="form-control" name="empName" placeholder="이름을 입력해주세요.">
													 	</td>
												 	</tr>

												 	<tr>
														<td>이메일</td>
													 	<td>
													 		<input type="email" class="form-control" name="email" placeholder="이메일을 입력해주세요.">
													 		<!-- <input type="button" class="form-control" id="sendMail" value="인증번호전송">  -->
													 	</td>
												 	</tr>

												 	<tr>
														<td>인증번호</td>
													 	<td><input type="text" class="form-control" name="randnum" placeholder="인증번호를 입력해주세요."></td>
												 	</tr>
											 	</table>
										          <br><br>
										          
												 <div class="modal-footer">
												   <button class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
												   <button class="btn btn-primary" id="addBtn">추가</button>
												 </div>
					
										      </div>
										    </div>
										  </div>
										</div>
						              
						            </div>
						          </div>
						          <!-- /Register -->
						        </div>
						      </div>
						    </div>
						
						    <!-- / Content -->
		    		</div>   		
	    		
	    		</div>	    		
	    		<%-- <c:import url="/WEB-INF/views/layout/footer.jsp"></c:import> --%>
	    	</div>
	    </div>  
	<c:import url="/WEB-INF/views/layout/footjs.jsp"></c:import>
</body>
</html>
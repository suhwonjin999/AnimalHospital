<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
						                <a href="/" class="app-brand-link gap-2">
						                  <img alt="" src="/resources/images/jisun3.png" style="width: 40px;" height="40px;">
						                  <span class="app-brand-text demo text-body fw-bolder">Animal Hospital</span>
						                </a>
						              </div>
						              <!-- /Logo -->
						              <h4 class="mb-2">비밀번호를 변경해주세요.🔐</h4>
						              <p class="mb-4">Please sign-in to your account and start the adventure</p>
										<div>
											<form:form modelAttribute="empVO" method="post">
											  <div class="form-group">
											  	<form:label path="password">임시 비밀번호</form:label>
												<form:input  id="password" path="password" cssClass="form-control"/>					
											  	<form:errors path="password"></form:errors>
											  </div>
											  <div class="form-group">
											  	<form:label path="password">변경 할 비밀번호</form:label>
											    <form:password id="password" path="password" cssClass="form-control"/>
											    <form:errors path="password"></form:errors>
											  </div>
											  <div class="form-group">
											  	<form:label path="password">비밀번호 확인</form:label>
											    <form:password id="password" path="password" cssClass="form-control"/>
											    <form:errors path="password"></form:errors>
											  </div>
											  			  			  				  				          													  	  				  			  				  				          		
											  <button type="submit" class="btn btn-primary" style="margin-top: 30px;">완료</button>
							        		</form:form>	
										</div>
						              <!-- <form id="formAuthentication" modelAttribute="com.vet.main.emp.EmpVO" class="mb-3" action="/" method="POST">
						                <div class="mb-3">
						                  <label for="email" class="form-label">Email or Username</label>
						                  <input
						                    type="text"
						                    class="form-control"
						                    id="email"
						                    name="email-username"
						                    placeholder="Enter your email or username"
						                    autofocus
						                  />
						                </div>
						                <div class="mb-3 form-password-toggle">
						                  <div class="d-flex justify-content-between">
						                    <label class="form-label" for="password">Password</label>
						                    <a href="auth-forgot-password-basic.html">
						                      <small>Forgot Password?</small>
						                    </a>
						                  </div>
						                  <div class="input-group input-group-merge">
						                    <input
						                      type="password"
						                      id="password"
						                      class="form-control"
						                      name="password"
						                      placeholder="&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;"
						                      aria-describedby="password"
						                    />
						                    <span class="input-group-text cursor-pointer"><i class="bx bx-hide"></i></span>
						                  </div>
						                </div>
						                <div class="mb-3">
						                  <div class="form-check">
						                    <input class="form-check-input" type="checkbox" id="remember-me" />
						                    <label class="form-check-label" for="remember-me"> Remember Me </label>
						                  </div>
						                </div>
						                <div class="mb-3">
						                  <button class="btn btn-primary d-grid w-100" type="submit">Sign in</button>
						                  <a></a>
						                </div>
						              </form> -->
						
						              <p class="text-center">
						                <span>New on our platform?</span>
						                <a href="auth-register-basic.html">
						                  <span>Create an account</span>
						                </a>
						              </p>
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
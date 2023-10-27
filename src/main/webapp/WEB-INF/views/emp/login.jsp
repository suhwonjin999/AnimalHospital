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
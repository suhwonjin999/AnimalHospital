<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- jsp에서 properties 메세지를 사용할 수 있도록 하는 API -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
	    	<div id="content-wrapper" class="d-flex flex-column">
	    		<div id="content">	    		
		    		<div class="container-fluid" style="margin-top: 50px;">
						<sec:authentication property="Principal" var="user"/>
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
						              <h4 class="mb-2">비밀번호 찾기.🔐</h4>
						              <p class="mb-4">Please change your password!</p>
										<div>
											<form action="pwUpdate" method="post">

											 	<table>
													<tr>
														<td>사원번호</td>
													 	<td><input type="username" name="username" placeholder="사원번호를 입력해주세요."></td>
												 	</tr>

													<tr>
														<td>이름을 입력해주세요</td>
													 	<td>
													 		<input type="text" name="empName" placeholder="이름을 입력해주세요.">
													 	</td>
												 	</tr>

												 	<tr>
														<td>이메일을 입력해주세요</td>
													 	<td>
													 		<input type="email" name="email" required="/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)?$/i" placeholder="이메일을 입력해주세요.">
													 		<input type="button" id="sendMail" value="인증번호전송"> 
													 	</td>
												 	</tr>

												 	<tr>
														<td>인증번호를 입력해주세요.</td>
													 	<td><input type="text" name="randnum" placeholder="인증번호를 입력해주세요."></td>
												 	</tr>
											 	</table>

											  <br><br>			  			  				  				          													  	  				  			  				  				          		
											  <button type="submit" class="btn btn-primary" style="margin-top: 30px;">확인</button>
							        		</form>
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

	    	</div>
	    </div>  
	<c:import url="/WEB-INF/views/layout/footjs.jsp"></c:import>
<!-- 	<script type="text/javascript">
		window.onload=function(){
			
		let emailconfirm=document.getElementById('email');
		
		emailconfirm.addEventListener('keyup',function(){
			let xhr,url='emp/emailconfirm',data='email='+emailconfirm.value;
			xhr=doajax(url,data);
			xhr.onload = function(){
				let color,text;
					if(xhr.response=='true'){
						color='red',text='존재하지 않는 이메일';
					}else{
						color='blue',text='존재하는 이메일';
					}
					document.geetElementById("emailCheck").innerHTML=text;
					emailconfirm.style.backgroundColor=color;
			}
		})
	}
	
	</script> -->
</body>
</html>
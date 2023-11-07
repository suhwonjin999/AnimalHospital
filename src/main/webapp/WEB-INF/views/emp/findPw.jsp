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
						              <h4 class="mb-2">아이디 찾기.🔐</h4>

										<div>
											<form method="post" class="form-signin" action="findUsername" name="findform">

											 	<table>
													<tr>
														<td>이름을 입력해주세요</td>
													 	<td>
													 		<input type="text" class="form-control" id="empName" name="empName" placeholder="이름을 입력해주세요.">
													 	</td>
												 	</tr>

												 	<tr>
														<td>이메일을 입력해주세요</td>
													 	<td>
													 		<input type="email" class="form-control" id="email" name="email" placeholder="이메일을 입력해주세요.">
													 	</td>
												 	</tr>
											 	</table>

											  <br><br>			  			  				  				          													  	  				  			  				  				          		
											  <input class="btn btn-lg btn-secondary btn-block text-uppercase" type="submit" value="check">
							        		
								                            <!-- 이름과 비밀번호가 일치하지 않을 때 -->
					                            <c:if test="${check == 1}">
													<!-- <script>
														opener.document.findform.empName.value = "";
														opener.document.findform.email.value = "";
													</script>  -->                           
					                                <label>일치하는 정보가 존재하지 않습니다.</label>
					                            </c:if>
					                            
					                            <c:if test="${check == 0}">
					                                <label>찾으시는 아이디는 '${username}' 입니다.</label>
					                            </c:if>				        		
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
    <script type="text/javascript">
        $('#searchBtn').on("click", function () {
            let empName = $("#empName").val();
            let email = $("#email").val();

            if (empName === "") {
                alert("이름은 필수입력사항입니다.");
                $("#empName").focus();
                return;
            }
            if (email === "") {
                alert("이메일은 필수입력사항입니다.");
                $("#email").focus();
                return;
            }
            
    </script>
</body>
</html>
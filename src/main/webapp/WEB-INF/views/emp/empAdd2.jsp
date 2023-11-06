<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- jsp에서 properties 메세지를 사용할 수 있도록 하는 API -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en" class="light-style layout-menu-fixed" dir="ltr"
	data-theme="theme-default" data-assets-path="/assets/"
	data-template="vertical-menu-template-free">
<head>
<c:import url="/WEB-INF/views/layout/headCSS.jsp"></c:import>

<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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

							<br><h3>사원 등록</h3>
					<div class="card shadow mb-4">									
							<div style="width: 300px; float: left; margin-top: 20px; margin-bottom: 20px;">
								<!-- <img alt="" src="/resources/images/default.jpeg" style="width: 200px; height: 200px; margin-left: 80px;"> -->
							</div>
							<div style="width:900px; float: left; margin-bottom: 30px; ">
								<%-- <form action="empAdd2" method="post" enctype="multipart/form-data"> --%>
								<form:form modelAttribute="empVO" method="post" enctype="multipart/form-data">
								<input type="hidden" class="form-control" name="username" id="username">
								<input type="hidden" class="form-control" name="password" id="password">
									<!-- <table style="border-color: black;"> -->
									  <div class="form-group">
									  	<form:label path="empName">이름</form:label>
										<form:input id="empName" path="empName" cssClass="form-control"/>					
									  	<form:errors path="empName"></form:errors>
									  </div>
									  <div class="form-group">
									  	<form:label path="email">이메일</form:label>
										<form:input id="email" path="email" cssClass="form-control"/>					
									  	<form:errors path="email"></form:errors>
									  </div>	
									  <div class="form-group">
									  	<form:label path="phone">연락처</form:label>
										<form:input id="phone" path="phone" cssClass="form-control"/>					
									  	<form:errors path="phone"></form:errors>
									  </div>	
									  <div class="form-group">
									  	<form:label path="birth">생년월일</form:label>
										<form:input id="birth" path="birth" cssClass="form-control"/>					
									  	<form:errors path="birth"></form:errors>
									  </div>										  									  									  										
										<!-- <tr>
											<td>이름</td>
											<td><input type="text" class="form-control" name="empName" id="empName"></td>
										</tr>
										<tr>
											<td>이메일</td>
											<td><input type="email" class="form-control mail" name="email" id="email"></td>
										</tr>
										<tr>
											<td>연락처</td>
											<td><input type="text" class="form-control" name="phone" id="phone"></td>
										</tr>
										<tr>
											<td>생년월일</td>
											<td><input type="date" class="form-control" name="birth" id="birth"></td>
										</tr> -->
										
									<!-- </table> -->
									<br>
									<button type="submit" class="btn btn-secondary sendMail">작성완료</button>
								<%-- </form> --%>
								</form:form>
								
							</div>
						</div>
				<!-- Content wrapper -->
			</div>
			<!-- / Layout page -->
		</div>
	</div>
</div>
		<!-- Overlay -->
		<div class="layout-overlay layout-menu-toggle"></div>
	</div>
	<!-- / Layout wrapper -->
	<c:import url="/WEB-INF/views/layout/footjs.jsp"></c:import>

<!-- 	<script type="text/javascript">
	
	$(".sendMail").click(function(){ // 메일 입력 유효성 검사
		let mail = $(".mail").val(); // 이메일 입력값
		
		if(mail == ""){
			alret("메일주소가 입력되지 않았습니다.");
		}else{
			mail;
			
			$.ajax({
				type : 'post'',
				url : '/CheckMail',
				data : {
					mail:mail
				},
				dataType : 'json',
			});
			alret("메일이 전송되었습니다.")
		}
		
	})
	
	</script>
 -->
</body>
</html>
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
	<!-- include summernote -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	  integrity="sha256-7ZWbZUAi97rkirk4DcEp4GWDPkWpRMcNaEyXGsNXjLg=" crossorigin="anonymous">	  
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/summernote@0.8.20/dist/summernote-lite.min.css"
	integrity="sha256-IKhQVXDfwbVELwiR0ke6dX+pJt0RSmWky3WB2pNx9Hg=" crossorigin="anonymous">
	
	<!-- include codemirror (codemirror.css, codemirror.js, xml.js, formatting.js) -->
	<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/codemirror/3.20.0/codemirror.css">
	<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/codemirror/3.20.0/theme/monokai.css">
	<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/codemirror/3.20.0/codemirror.js"></script>
	<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/codemirror/3.20.0/mode/xml/xml.js"></script>
	<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/codemirror/2.36.0/formatting.js"></script>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<!-- include summernote css/js-->
	<link href="summernote.css">
	<script src="summernote.js"></script>
	
<c:import url="/WEB-INF/views/layout/headCSS.jsp"></c:import>
<meta charset="UTF-8">
<title>익명게시판글 등록</title>

<script>
/*   	$(document).ready(function(){
		alert("공지사항 등록");
	}) */  
 
  	$(document).ready(function(){
		$("#addBtn").click(function(){
			const title = $("#title").val();
			const contents = $("#contents").val();
			if(title==""){
				alert("제목을 입력하세요");
				document.addForm.title.focus();
				return;
			}
			if(contents==""){
				alert("내용을 입력하세요");
				document.addForm.contents.focus();
				return;
			}
			if(confirm("등록하시겠습니까?")){
				document.addForm.action="${path}/board/boardAdd"
				document.addForm.submit();
			}
		})
	})  
 	
/*	$(document).ready(function(){
		$("#cancleBtn").click(function(){
	 		alert("작성 취소");
			if(confirm("작성 취소하시겠습니까?")){
 				document.addForm.action="${path}/board/noticeAdd"
			//	 document.addForm.method="post"
				document.addForm.submit();
 			}
		})
	})  */
</script>

</head>
<body>
	<sec:authentication property="Principal" var="user"/>
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

							<br><h3>익명게시판</h3>
					<div class="card shadow mb-4">									
						<div style="width: 300px; float: left; margin-top: 20px; margin-bottom: 20px;">
								<!-- <img alt="" src="/resources/images/default.jpeg" style="width: 200px; height: 200px; margin-left: 80px;"> -->
						</div>
							
						<div style="width:900px; float: left; margin-bottom: 30px; ">
						<!-- form enctype="multipart/form-data" post 방식 지원안해? -->
						<form action="noticeAdd" name="addForm" id="addForm" method="post">
								<input type="hidden" class="form-control" name="username" id="username" value="${user.username}">
								<!-- <input type="hidden" class="form-control" name="password" id="password"> -->

								<div class="mb-3" style=" padding: 5px; top : 0; height: auto; min-height: 100%; overflow: auto;" >
										<label for="title" class="form-label">제목</label>
										<input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요">
								</div>
									
								<div class="mb-3" style=" padding: 5px; top : 0; height: auto; min-height: 100%; overflow: auto;" >	
										<label for="empName" class="form-label">작성자</label>
										<input type="text" class="form-control" id="empName" name="empName" value="${user.empName}" readonly/>
								</div>
								

								<div class="mb-3" style=" padding: 5px; top : 0; height: auto; min-height: 100%; overflow: auto;" >
								  <label for="contents" class="form-label">내용</label>
								  <textarea class="form-control" id="contents" name="contents" rows="3" placeholder="내용을 입력하세요"></textarea>
								</div>

								<br>
								<div class="mb-3" >	
							  	<br>
							  	<button type="button" class="btn btn-secondary" id="addBtn">등록</button>
							  	 <button type="button" id="cancleBtn" class="btn btn-secondary">작성취소</button>
							  	<!-- <input type="button" id="cancleBtn" class="btn btn-secondary" value="작성취소" onsubmit="return false"/> -->
								</div>
							</form>
						</div> 
					</div>

					<div>
						<a href="/board/noticelist" class="btn btn-secondary" >뒤로가기</a>
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
	
	<!-- summernote -->
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"
	integrity="sha256-u7e5khyithlIdTpu22PHhENmPcRdFiHRjhAuHcs05RI=" crossorigin="anonymous"></script>
	
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.20/dist/summernote-lite.min.js"
	integrity="sha256-5slxYrL5Ct3mhMAp/dgnb5JSnTYMtkr4dHby34N10qw=" crossorigin="anonymous"></script>
	
	<!-- language pack -->
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.20/dist/lang/summernote-ko-KR.min.js"
	integrity="sha256-y2bkXLA0VKwUx5hwbBKnaboRThcu7YOFyuYarJbCnoQ=" crossorigin="anonymous"></script>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	
	<script>
	$('#contents').summernote({
	  tabsize: 2,
	  height: 1000,
	  codemirror: { // codemirror options
		    theme: 'monokai'
		  },
	  lang: 'ko-KR', // default: 'en-US'

	});
	
	$("#contents").summernote('code'); 
	</script>

	<script src="/resources/js/board/boardAdd.js"></script>
</body>
</html>
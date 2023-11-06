<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- JSP에서 properties 메세지를 사용할 수 있도록 하는 API -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en" class="light-style layout-menu-fixed" dir="ltr"
    data-theme="theme-default" data-assets-path="/assets/"
    data-template="vertical-menu-template-free">
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <c:import url="/WEB-INF/views/layout/headCSS.jsp"></c:import>
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
                    <!-- 내용부분 -->
                    <div class="container-xxl flex-grow-1 container-p-y">

                        <form method="post" class="form-signin" action="findUsername" name="findform">

                            <input type="text" class="form-control" id="empName" name="empName" placeholder="이름을 입력해주세요.">
                            <input type="email" class="form-control" id="email" name="email" placeholder="이메일을 입력해주세요.">
 
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
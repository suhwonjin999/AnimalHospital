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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link href='/fullcalendar/main.css' rel='stylesheet'/>
<script src='/fullcalendar/main.js'></script>
<script src="/js/reservation/treatment/schedule.js"></script>
<!-- <script>
document.addEventListener('DOMContentLoaded', function() {
   var calendarEl = document.getElementById('calendar');
   var calendar = new FullCalendar.Calendar(calendarEl, {
     initialView: 'dayGridMonth'
   });
   calendar.render();
 });
</script> -->
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
               <!-- Content -->               
               
               <!-- 내용부분-->               
               <div class="container-xxl flex-grow-1 container-p-y">
               <div id="calendar"></div>
                
               <!-- Modal -->
               <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                 <div class="modal-dialog">
                   <div class="modal-content">
                     <div class="modal-header">
                       <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                       <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                     </div>
                     <div class="modal-body">  
                     	
                     	<input type="text" id="customerNo">
                     	<input type="text" id="empNo">
                     	//<button type="button" id="nameSearch" class="btn btn-primary">검색</button>
                     	<input type="datetime-local" id="treatmentDatet">
                      
                     </div>
                     <div class="modal-footer">
                       <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                       <button type="button" id="addBtn" class="btn btn-primary">Add</button>
                     </div>
                   </div>
                 </div>
               </div>
               
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
  
</body>
</html>
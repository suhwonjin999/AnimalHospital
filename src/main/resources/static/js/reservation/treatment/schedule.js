

$(function(){
		var request = $.ajax({				
		url:"/treatment/schedule",
	    method:"POST",			
		dataType:"json"
		});
		
		$("#dept").on("change",function(){
			var deptNo=this.value;
			console.log(deptNo)			
		    var param = {"deptNo":deptNo}
		    console.log(param)		
		});
		var deptNo = $("#dept").val();
		console.log(deptNo)
		
		/*if(deptNo==400||500||600){
				var req = $.ajax({
				   url:"/treatment/scheduledept",
				   data:JSON.stringify(param),
				   method:"POST",
				   async:true,												
				   contentType: "application/json"				 																									
			   			   
			    })
		  	}*/
		
		console.log(request)	
	request.done(function(data){
	
		
		console.log(data);
	
		var calendarEl = document.getElementById('calendar');
		
		$('#closeBtn').on("click",function(){
							$("#customerNo").val("");
							$("#animalName").val("");
							$("#username").val("");
							$("#name").val("");    
							$("#treatmentDate").val("");
		});
		
		
		var calendar= new FullCalendar.Calendar(calendarEl, {
			height:'600px',
			expandRows:true,
			customButtons:{
				myCustomButton:{
					text:"예약 등록하기",
					click : function(){
						$('#addModal').modal("show");
						
						var animalName=$("#animalName").val();
						console.log(animalName);
												
					
						//등록버튼클릭시
						$('#addBtn').on("click", function(){

							var customerNo = $("#customerNo").val();
							var username = $("#username").val();
							var treatmentDate = $("#treatmentDate").val();
							
							console.log(treatmentDate);
			
							var param = {"customerNo":customerNo, "username":username, "treatmentDate":treatmentDate};
							
							
							$.ajax({
								url:"/treatment/scheduleAdd",
								data:JSON.stringify(param),
								method:"POST",												
								contentType: "application/json",
								success : function(data){
									console.log(data);
									alert("예약이 완료되었습니다!")																		
								}
							})

							$("#addModal").modal("hide");
							$("#customerNo").val("");
							$("#animalName").val("");
							$("#username").val("");
							$("#name").val("");    
							$("#treatmentDate").val("");

							location.href="/treatment/schedule";		
						});
						
					
						
					}
				}
			},
			headerToolbar: {
				left: 'prev,next,today,myCustomButton',
				center: 'title',
				right: 'dayGridMonth'
			},
			initialView:'dayGridMonth',
			events: data,
			navLinks: true,
			navLinkDayClick:function(date,jsEvent){
				console.log('day',date.format());
				console.log('coords',jsEvent.pageX,jsEvent.pageY);
			},
			editable: true,
			selectable: true,
			locale: 'ko',

			//이벤트 클릭했을시
			eventClick:function(info){		
				 console.log(info);
				 var animalName=info.event.title;
				 var treatmentNo=info.event.id;
				 console.log(treatmentNo);
				 var param={"treatmentNo":treatmentNo}				

			
				$.ajax({
					url:"/treatment/scheduleDetail",
					data: JSON.stringify(param),
					method:"POST",
					contentType: "application/json",
					success : function(detail){
						
						console.log("detail 전송성공");
						console.log(detail);
						console.log(detail.animalName);
						
						$("#detailModal").modal("show");
						$("#treatmentNo").val(detail.treatmentNo);
						$("#getanimalName").val(detail.animalName);
						$("#getcustomerName").val(detail.name);
						$("#getempname").val(detail.empName);
						$("#getcustomerNo").val(detail.customerNo);
						$("#getdate").val(detail.treatmentDate);					
											            													
					}
				 })
				 
				 	 //삭제버튼클릭시
				 $("#deleteBtn").on("click",function(){
							console.log(param);
							$.ajax({
								url:"/treatment/scheduleDelete",
								data:JSON.stringify(param),
								method:"POST",
								contentType: "application/json",
								success : function(data){
									console.log("delete");
									
									$("#detailModal").modal("hide");
									
									location.href="/treatment/schedule";
								}								 
							})
				 })	
				 
				 //수정버튼클릭시
				 $("#modifyBtn").on("click", function(){				
							$("#detailModal").modal("hide");
							$("#updateModal").modal("show");
							var animal = $("#getanimalName").val()			
					 		alert(animal)
				})
				 
				 
				 
				 //수정등록버튼클릭시
				 $("#updateBtn").on("click",function(){
					 		var treatmentNo = $("#treatmentNo").val();				 
							var customerNo = $("#getcustomerNo").val();
																		
							var username= $("#updateusername").val();
							
							var treatmentDate = $("#modifyDate").val();
							
							var param = {"treatmentNo":treatmentNo, "customerNo":customerNo, "username":username, "treatmentDate":treatmentDate}
							
							console.log(param);
							$.ajax({
										url:"/treatment/scheduleUpdate",
										data:JSON.stringify(param),
										method:"POST",
										contentType: "application/json",
										success : function(data){
											console.log("update성공")					
											location.href="/treatment/schedule";
										}							 
						 	})
						 	
				
				 })
				 
						
			
			},

		eventAdd:function(obj){
			console.log(obj)
		},
		

		});
		calendar.render();
		});
	
	request.fail(function(jqXHR, textStatus){
		alert("Request failed: " + textStatus);

	});
});
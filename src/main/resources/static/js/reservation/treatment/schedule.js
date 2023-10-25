
$(function(){
	var request = $.ajax({
		url:"/treatment/schedule",
		method:"POST",
		async:false,		
		dataType:"json"
	});

	request.done(function(data){    


		var calendarEl = document.getElementById('calendar');

		var calendar= new FullCalendar.Calendar(calendarEl, {
			height:'600px',
			expandRows:true,
			customButtons:{
				myCustomButton:{
					text:"예약 등록하기",
					click : function(){
						$('#exampleModal').modal("show");
						$('#addBtn').on("click", function(){

							var customerNo = $("#customerNo").val();
							var empNo = $("#empNo").val();
							var treatmentDatet = $("#treatmentDatet").val();

							var param = {"customerNo":customerNo, "empNo":empNo, "treatmentDatet":treatmentDatet};

							/*$.ajax({
								url:"/treatment/scheduleAdd",
								data:JSON.stringify(param),
								method:"POST",								
								contentType: "application/json",
								success : function(data){
									console.log(data);
								}
							})*/

							$("#exampleModal").modal("hide");
							$("#customerNo").val("");
							$("#empNo").val("");     
							$("#treatmentDatet").val(""); 
							// var customerNo = $("#customerNo").val();
							

							// var eventData = {
							// 	title : $("#customerNo"),
								
							// 	start : $("#treatmentDatet")												                             
							// };
						 
						// calendar.addEvent(eventData);
					                   
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
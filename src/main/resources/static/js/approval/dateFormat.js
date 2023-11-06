let username = document.getElementById("username").value;				// 사번

let search = document.getElementById("search");		// 전자결재 양식 내용

let searchfrm = document.getElementById("searchfrm");				// 작성폼
let searchBtn = document.getElementById("searchBtn");				// 작성폼 제출 버튼


function convertDate(inputDate) {
    const dateParts = inputDate.split('/');
    const year = dateParts[0];
    const month = dateParts[1];
    const day = dateParts[2];
    return year + "년 " + month + "월 " + day + "일";
}


$(document).onload(function () {
	var startDateStr = $('#dayoffStartDate').val();
	var endDateStr = $('#dayoffEndDate').val();
	
	var startDate = new Date(startDateStr);
	var endDate = new Date(endDateStr);
	
	var timeDiff = Math.abs(endDate.getTime() - startDate.getTime());
	var dayDifference = Math.ceil(timeDiff / (1000 * 3600 * 24));
	$('#result').html('(총 ' + dayDifference + '일)');
});
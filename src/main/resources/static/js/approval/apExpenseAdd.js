let username = document.getElementById("username").value;				// 사번

let apTitle = document.getElementById("apTitle");			// 전자결재 양식 제목
let apContents = document.getElementById("apContents");		// 전자결재 양식 내용

let addFrm = document.getElementById("addFrm");				// 작성폼
let addBtn = document.getElementById("addBtn");				// 작성폼 제출 버튼
let cancleBtn = document.getElementById("cancleBtn");		// 작성 취소 버튼


const addList = document.getElementById("addList");
const expensePlusBtn = document.getElementById("expensePlusBtn");
const expenseMinusBtn = document.getElementById("expenseMinusBtn");
// const df = document.getElementsByClassName("df"); 
const deletes = document.getElementsByClassName("deletes");



// 금액 콤마찍는 함수
 function inputNumberFormat(obj) {
     obj.value = comma(uncomma(obj.value));
 }

 function comma(str) {
     str = String(str);
     return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
 }

 function uncomma(str) {
     str = String(str);
     return str.replace(/[^\d]+/g, '');
 }
 
 
 

let max = 10;
let count = 0;

if(deletes != null) {
    count = deletes.length;
}
let idx = 1;


// expenseList에 항목 입력 폼 추가하기
$("#expensePlusBtn").click(function(){

    if(count>=max){
        alert("지출 항목은 최대 10개까지 추가할 수 있습니다.");
        return;
    }
    count++;    


	let f = '<div class="expense row g-3 mb-2" id="expense'+idx+'">'
    f = f + '<input type="text" class="form-control me-2" id="expenseName'+idx+'" name="expenseName" placeholder="항목" style="width:350px;">';
	f = f + '<input type="text" class="form-control me-2" id="expenseAmount'+idx+'" name="expenseAmount" placeholder="수량" style="width:100px;" oninput="this.value = this.value.replace(/[^0-9.]/g, \'\');">';
	f = f + '<input type="text" class="form-control me-2" id="expensePrice'+idx+'" name="expensePrice" placeholder="금액" style="width:150px;" onkeyup="inputNumberFormat(this)" oninput="this.value = this.value.replace(/[^0-9.]/g, \'\');">';
    f = f + '<input type="text" class="form-control me-2" id="expenseBigo'+idx+'" name="expenseBigo" placeholder="비고" style="width:200px;">';
  	f = f + '<button type="button" id="expenseMinusBtn" name="expenseMinusBtn" class="btn btn-primary df" style="width:50px; height:38.94px;"> X </button>';
	f = f + '</div>';
   
    
    idx++;

    $("#addList").append(f);

})


// expenseList에 항목 입력 폼 추가한거 지우기
$("#addList").on("click", ".df", function(){
    $(this).parent().remove();
    count--;
})




// 글 ADD
/*addBtn.addEventListener("click", function(){

    if(apTitle.value == ""){
        alert("제목을 입력해주세요.");
        apTitle.focus();
        return;
    }
    if(apContents.value == ""){
        alert("내용을 입력해주세요.");
        apContents.focus();
        return;
    }
    

    // 폼에 입력한 데이터를 서버로 전송
    addFrm.submit();
    
});*/


// 취소 버튼
cancleBtn.addEventListener("click", function(){
	/*location.href = "/approval/draftList/" + username;*/
	location.href = "/approval/formatList";
})

addBtn.addEventListener("click", function(){
	
	var apTitle = document.getElementById('apTitle');
	var expenses = [];
	var expenseElements = document.getElementsByClassName('expense');
	
	// 제목 필드 유효성 검사
	if (apTitle.value == "") {
	    alert("제목을 입력해주세요.");
	    apTitle.focus();
	    return;
	}
	
	for (var i = 0; i < expenseElements.length; i++) {
	    var expenseElement = expenseElements[i];
	    var expenseName = expenseElement.querySelector('input[name="expenseName"]').value;
	    var expenseAmount = expenseElement.querySelector('input[name="expenseAmount"]').value;
	    var expensePrice = expenseElement.querySelector('input[name="expensePrice"]').value;
	
	    // 항목 이름, 수량, 금액 필드 유효성 검사
	    if (expenseName == "") {
	        alert("항목 이름을 입력해주세요.");
	        expenseElement.querySelector('input[name="expenseName"]').focus();
	        return;
	    }
	
	    if (expenseAmount == "") {
	        alert("수량을 입력해주세요.");
	        expenseElement.querySelector('input[name="expenseAmount"]').focus();
	        return;
	    }
	
	    if (expensePrice == "") {
	        alert("금액을 입력해주세요.");
	        expenseElement.querySelector('input[name="expensePrice"]').focus();
	        return;
	    }
	
	    var expenseData = {
	        expenseName: expenseName,
	        expenseAmount: parseFloat(expenseAmount),
	        expensePrice: parseFloat(expensePrice),
	        expenseBigo: expenseElement.querySelector('input[name="expenseBigo"]').value || "" // 빈 문자열 처리
	    };
	    expenses.push(expenseData);
	}
	
	var jsonData = JSON.stringify(expenses, null, 2);
	/*console.log(jsonData);
	
	// JSON 데이터를 폼 필드에 설정
	// 이미 존재하는 username 필드의 값을 업데이트
	var usernameInput = document.querySelector('input[name="username"]');
	usernameInput.value = username; // EL 표현식 대신 JavaScript를 사용하여 값을 업데이트
	
	var addFrm = document.getElementById('addFrm');
	addFrm.appendChild(usernameInput);
	
	// 폼을 자동으로 제출
	addFrm.submit();*/
	
	$.ajax({
        url: "/approval/add/expenseAdd", // 서버 엔드포인트 URL로 대체
        type: 'POST',
        contentType: 'application/json',
        data: jsonData,
        success: function (response) {
	        if (response.startsWith('redirect:')) {
	            var redirectUrl = '../draftList/' + username; // 'redirect:' 이후의 문자열을 추출
	            window.location.href = redirectUrl; // 클라이언트에서 리디렉션
	        } else {
	            // 서버 응답을 처리
	            console.log(response);
	        }
        },
        error: function (xhr, status, error) {
            // 오류 처리
            console.log(error);
        }
	})
});



/*addBtn.addEventListener("click", function(){
	let expenseName = $("#expenseName").val();
	let expenseAmount = $("#expenseAmount").val();
	let expensePrice = $("#expensePrice").val();
	let expenseBigo = $("#expenseBigo").val();
	
	if(expenseBigo.value == "") {
		this.value = "";
	}
	
	

	
	let expenseVO = {
			"expenseName":expenseName,
			"expenseAmount":expenseAmount,
			"expensePrice":expensePrice,
			"expenseBigo":expenseBigo
			};
	
	

    if(apTitle.value == ""){
        alert("제목을 입력해주세요.");
        apTitle.focus();
        return;
    }
    
    if(expenseName.value == ""){
        alert("항목 이름을 입력해주세요.");
        apContents.focus();
        return;
    }
    
    if(expenseAmount.value == ""){
        alert("수량을 입력해주세요.");
        apContents.focus();
        return;
    }
    
    if(expensePrice.value == ""){
        alert("금액을 입력해주세요.");
        apContents.focus();
        return;
    }
    
	$.ajax({
		url:"/approval/add/expenseAdd",
		data:JSON.stringify(param),
		method:"POST",												
		contentType: "application/json",
		success : function(data){
			console.log(data);															
		}
	})

    // 폼에 입력한 데이터를 서버로 전송
    addFrm.submit();	
});*/


/*const saves = () => {
	
	let expenseName = $("#expenseName").val();
	let expenseAmount = $("#expenseAmount").val();
	let expensePrice = $("#expensePrice").val();
	let expenseBigo = $("#expenseBigo").val();
	
    // 아래의 6개의 배열들역할 -> 각 칸들의 값들의 index 값을 넣어서, 해당 칸들의 개수가 일치해야 하는 조건을 추가할 수 있고
    // 칸들의 개수는 일치하지만, 각 칸들의 위치가 다를 수 있으므로, 배열의 인덱스번호를 추가함
    let arrayExNo = [];
    let arrayApNo = [];
    let arrayName = [];
    let arrayAmount = [];
    let arrayPrice = [];
    let arrayBigo = [];
    
    
    $("input[name='expenseName']").each(function(i) { // i로 인덱스번호 체크
        if (this.value != "") arrayName.push(i);
    })
    $("input[name='expenseAmount']").each(function(i) {
        if (this.value != "") arrayAmount.push(i);
    })
    $("input[name='expensePrice']").each(function(i) {
        if (this.value != "") arrayPrice.push(i);
    })
    $("input[name='expenseBigo']").each(function(i) {
        if (this.value != "") arrayBigo.push(i);
    })

    // equals1, equals2 -> 배열은 == 비교가 불가능함(주소이기때문에) -> JSON.stringify를 통해서 비교 -> 3개의 배열을 비교
    const equals1 = (arrayAccount, arrayUseHistory) => JSON.stringify(arrayAccount) == JSON.stringify(arrayUseHistory)
    const equals2 = (arrayUseHistory, arrayPrice) => JSON.stringify(arrayUseHistory) == JSON.stringify(arrayPrice);
    const equals3 = (arrayUseHistory, arrayPrice) => JSON.stringify(arrayUseHistory) == JSON.stringify(arrayPrice);
    const equals4 = (arrayUseHistory, arrayPrice) => JSON.stringify(arrayUseHistory) == JSON.stringify(arrayPrice);
    const result = equals1(arrayAccount, arrayUseHistory) && equals2(arrayUseHistory, arrayPrice);

    if (arrayAccount.length <= 0 || arrayUseHistory.length <= 0 || arrayPrice.length <= 0) {
        alert("각 목록마다 한칸이상씩 입력");
        return false;
    } else {
        if (result == false) {
            alert("각 줄의 목록을 다 입력");
            return false;
        }
    }

    $("#appForm").attr("action", "${path}/approve/saveExpenditure.do");
    $("#appForm").submit();
}



    $("#addBtn").click(function() {
        let expense = [];
        
        // 모든 .expense div에서 데이터 수집
        $(".expense").each(function() {
			
            let expenseArr = {
                expenseName: $(this).find("input[name='expenseName']").val(),
                expensePrice: $(this).find("input[name='expensePrice']").val(),
                expenseBigo: $(this).find("input[name='expenseBigo']").val(),
                expenseAmount: $(this).find("input[name='expenseAmount']").val()
            };
            
            expense.push(expenseArr);
        });

        // JSON 배열로 데이터 묶기
        let jsonData = JSON.stringify(expense);

        // 서버로 데이터 전송
        $.ajax({
            url: "/approval/add/expenseAdd", // 서버 스크립트 URL
            data: jsonData,
			method:"POST",												
			contentType: "application/json",
            success: function(response) {
                // 성공 시 처리
                console.log("데이터 전송 성공!");
                addFrm.submit();	
            },
            error: function() {
                // 오류 시 처리
                console.log("데이터 전송 오류!");
            }
        });
    });*/
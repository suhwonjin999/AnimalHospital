let username = document.getElementById("username").value;				// 사번

let apTitle = document.getElementById("apTitle");			// 전자결재 양식 제목
let apContents = document.getElementById("apContents");		// 전자결재 양식 내용

let listBtn = document.getElementById("listBtn");				
let updateBtn = document.getElementById("updateBtn");		
let deleteBtn = document.getElementById("deleteBtn");		





// 수정버튼
updateBtn.addEventListener("click", function(){
	location.href = "/approval/update?apNo="+apNo;
})

// 삭제버튼
deleteBtn.addEventListener("click", function(){

    let result = confirm("정말로 삭제하시겠습니까?");

    if(result) {
	    frm.method = "post";
	    frm.action = "delete";		
	    frm.submit();
	}
})


// 목록버튼
listBtn.addEventListener("click", function(){
	location.href = "/approval/draftList/"+username;
})
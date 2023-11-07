const username = document.getElementById("username");

const title = document.getElementById("title");
const contents = document.getElementById("contents");
const empName = document.getElementById("empName")

const addForm = document.getElementById("addForm");
const addBtn = document.getElementById("addBtn");
const cancleBtn = document.getElementById("cancleBtn");
const deleteBtn = document.getElementById("deleteBtn");

deleteBtn.addEventListener("click", function(){

    if(confirm("삭제하시겠습니까?")){
        // deleteBtn.submit();
        location.href="/board/noticelist";
    }

})

// cancleBtn.addEventListener("click",function(){
//     if(confirm("작성 취소하시겠습니까?")){
//         fetch("cancleBtn",{
//             method:"POST",
//             headers:{
//                 "Content-Type": "application/json",
//             },
//             async:false,
//             body: JSON.stringify()
//         })
//         .then((res)=>{
//             return res.json();
//         })
//         .then((data)=>{
//             if(data){
//                 location.href="/board/noticeDetail?username=" + username.value;
//             }
//         })
//         .catch(()=>{
//             console.log("에러발생")
//         })
//     }
// })


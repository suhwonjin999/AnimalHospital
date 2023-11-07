const username = document.getElementById("username");

const title = document.getElementById("title");
const contents = document.getElementById("contents");
const empName = document.getElementById("empName")

const addForm = document.getElementById("addForm");
const addBtn = document.getElementById("addBtn");
const cancleBtn = document.getElementById("cancleBtn");


// addBtn.addEventListener("click", function(){

//     if(title.value == ""){
//         alert("제목을 입력해주세요.");
//         document.addForm.title.focus();
//         return;
//     }

//     if(contents.value == ""){
//         alert("제목을 입력해주세요.");
//         document.addForm.contents.focus();
//         return;
//     }

//     addForm.onsubmit();
// })

// addBtn.addEventListener("click",function(){
//     const obj = {username: username.value,
//                  title: title.value,
//                  empName: empName.value,
//                  contents: contents.value
//     };

//     if(title==""){
//         alert("제목을 입력하세요");
//         document.title.focus();
//         return;
//     }

//     if(contents==""){
//         alert("제목을 입력하세요");
//         document.contents.focus();
//         return;
//     }

//     if(confirm("등록하시겠습니까?")){
//         fetch("noticeAdd",{
//             method:"POST",
//             headers:{
//                 "Content-Type": "application/json; charset=UTF-8",
//             },
//             async:false,
//             body: JSON.stringify(obj)
//         })
//         .then((res)=>{
//             return res.json();
//         })
//         .then((data)=>{
//             if(data){
//                 addForm.onsubmit();
//                 location.href="/board/noticelist";
//             }
//         })
//         .catch(()=>{
//             console.log("에러발생")
//         })
//     }
//     else{
//         alert("필수 항목을 입력해주세요");
//     }
// })


cancleBtn.addEventListener("click",function(){
    if(confirm("작성 취소하시겠습니까?")){
        fetch("cancleBtn",{
            method:"POST",
            headers:{
                "Content-Type": "application/json",
            },
            async:false,
            body: JSON.stringify()
        })
        .then((res)=>{
            return res.json();
        })
        .then((data)=>{
            if(data){
                location.href="/board/noticelist?username=" + username.value;
            }
        })
        .catch(()=>{
            console.log("에러발생")
        })
    }
})



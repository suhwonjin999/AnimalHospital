$('.delets').click(function(){
    let num = $(this).attr("data-delete-num");
    let check = confirm("삭제시 복구 불가");
   
     if(check){
     $.ajax({
          type:'GET',
           url:'./fileDelete?fileNo='+num,
           success:function(r){
                if(r.trim()=='1'){
                   $(this).remove();
                        count--;
                    }
           }
     })
     }
})


let max = 1;
let count = 0;
const delets = document.getElementsByClassName("delets");

if(delets != null) {
    count = delets.length;
    
}

let idx = 0;

$("#fileList").on("click", ".df", function(){
    // let deleteId=$(this).attr("data-id")
    // $("#"+deleteId).remove();
    $(this).parent().remove();
    count--;
})

//jquery로 변경
$("#fileAdd").click(function(){
    if(count>=max){
        alert("1개까지입니다");
        return;
    }
    count++;

    let r = '<div class="input-group mb-3" id="files'+idx+'">'
    r = r+'<input type="file" class="form-control" id="files" name="files">'
    r = r+ '<span class="df" data-id="files'+idx+'">X</span>'
    r= r+"</div>";
    idx++;

    $("#fileList").append(r);

});

/*let r = '<div class="input-group" id="file'+idx+'">'
r = r+'<input type="file" aria-lable="upload" name="files" id="file" class="form-control">';
r = r+'<button class="df btn btn-danger" data-id="file'+idx+'">삭제</button>'
r = r+'</div>'

$("#fileAdd").click(function(){

    if(count>=1){
        alert("1개까지입니다");
        return;
    }
    count++;
    $('#fileList').append(r); 
    idx++;

  })*/
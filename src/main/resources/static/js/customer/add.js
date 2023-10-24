const addressSearch = document.getElementById("addressSearch");

//주소찾기버튼 클릭했을때
addressSearch.addEventListener("click", function () {
    new daum.Postcode({
      oncomplete: function (data) {
        var addr = "";
        var extraAddr = "";
  
        if (data.userSelectedType === "R") {
          addr = data.roadAddress;
        } else {
          addr = data.jibunAddress;
        }
        if (data.userSelectedType === "R") {
            if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
                extraAddr += data.bname;
            }
            if (data.buildingName !== "" && data.apartment === "Y") {
                extraAddr +=
                    extraAddr !== "" ? ", " + data.buildingName : data.buildingName;
            }
            if (extraAddr !== "") {
                extraAddr = " (" + extraAddr + ")";
            }
          document.getElementById("address").value = extraAddr;
        } else {
          document.getElementById("address").value = "";
        }
        document.getElementById("postcode").value = data.zonecode;
        document.getElementById("address").value = addr;
        document.getElementById("detailAddress").value = "";
        document.getElementById("detailAddress").focus();
      },
    }).open();
  });

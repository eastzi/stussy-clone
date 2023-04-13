const fileAddButton = document.querySelector(".add-button");
const fileInput = document.querySelector(".file-input");
const submitButton = document.querySelector(".submit-button");

let productImageFiles = new Array();

fileAddButton.onclick = () => {
    fileInput.click();
}

fileInput.onchange = () => {
    const formData = new FormData(document.querySelector("form"));
    let changeFlge = false;

    formData.forEach((value) => {
        if(value.size != 0) {
            productImageFiles.push(value);
            changeFlge = true;
        }
    });
    
    if(changeFlge){
        getImagePreview();
        fileInput.value = null;
    }
}

function getImagePreview() {
    const productImages = document.querySelector(".product-images");

    productImages.innerHTML = "";

    productImageFiles.forEach((file, i) => {

        //비동기적으로 파일 내용을 읽어들이는데 사용되는 파일API(FileReader 객체)
        const reader = new FileReader();

        //읽기 동작이 성공적으로 완료되었을때 발생하는 이벤트
        reader.onload = (e) => {
            productImages.innerHTML += `
                <div class="img-box">
                    <i class="fa-solid fa-xmark"></i>
                    <img class="product-img" src="${e.target.result}">
                </div>
            `;

            const deleteButton = document.querySelectorAll(".fa-xmark");
            deleteButton.forEach((xbutton, index) => {
                xbutton.onclick = () => {
                    if(confirm("상품 이미지를 삭제할까요?")) {
                        productImageFiles.splice(index, 1);
                        console.log(productImages);
                        getImagePreview();
                    }
                };
            })
        }

        //바이너리 파일을 Base64 Encode 문자열로 반환하는 메서드(readAsDataURL)
        //취득된 문자열로 이미지를 브러우저로 출력시키면 동적인 이미지 확인 가능
        //setTimeout메서드 - 일정시간 후 실행 함수(실행코드, 지연시간(ms단위))
        setTimeout(() => {reader.readAsDataURL(file)}, i * 100)
    });
}

submitButton.onclick = () => {
    const productInputs = document.querySelectorAll(".product-input");

    let formData = new FormData();

    formData.append("category", productInputs[0].value);
    formData.append("name", productInputs[1].value);
    formData.append("price", productInputs[2].value);
    formData.append("color", productInputs[3].value);
    formData.append("size", productInputs[4].value);
    formData.append("infoSimple", productInputs[5].value);
    formData.append("infoDetail", productInputs[6].value);
    formData.append("infoOption", productInputs[7].value);
    formData.append("infoManagement", productInputs[8].value);
    formData.append("infoShipping", productInputs[9].value);

    productImageFiles.forEach((file) => {
        formData.append("files", file);
    });

    request(formData);
}

function request(formData) {
    $.ajax({
        async: false,
        type: "post",
        url: "/api/admin/product",
        enctype: "multipart/form-data",
        contentType: false,
        processData: false,
        data: formData,
        dataType: "json",
        success: (response) => {
            alert("상품 등록 완료");
            location.replace("/admin/products");
        },
        error: (error) => {
            alert("상품 등록 실패");
            console.log(error);
        }
    });
}
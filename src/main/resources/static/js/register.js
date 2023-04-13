const registerBuuton = document.querySelector(".login-button");
const registerInputs = document.querySelectorAll(".login-input");

for(let i = 0; i < registerInputs.length; i++) {
    registerInputs[i].onkeyup = () => {
        if(window.Event.keycode == 13) {
            if(i != 3) {
                registerInputs[i + 1].focus();
            }else {
                registerBuuton.click();
            }
        }
    }
}

registerBuuton.onclick = () => {

    let registerInfo = { //object, JSON.stringify(객체)를 통해 object->JSON문자열로 변환
        lastName: registerInputs[0].value,
        firstName: registerInputs[1].value,
        email: registerInputs[2].value,
        password: registerInputs[3].value
    }

    $.ajax({
        async: false,
        type: "post",
        url: "/api/account/register",
        contentType: "application/json",
        data: JSON.stringify(registerInfo), // <-> JSON.parse(JOSN) JSON문자열을 object로 변환
        dataType: "json",                  // JSON은 문자열이 접근할 수 없기때문에 object로 변환
        success: (response) => {
            console.log(response);
            location.replace("/account/login"); 
        },
        error: (error) => {
            console.log(error);
            validationError(error.responseJSON.data);
        }
    });
}

function validationError(error) {
    const accountErrors = document.querySelector(".account-errors");
    const accountErrorList = document.querySelector("ul");
    
    const errorValues = Object.values(error);

    accountErrorList.innerHTML = "";

    errorValues.forEach((value) => {
        accountErrorList.innerHTML += `
            <li>${value}</li>
        `;
    });

    accountErrors.classList.remove("errors-invisible");
}
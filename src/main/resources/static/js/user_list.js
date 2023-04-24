const searchInput = document.querySelector(".user-search .user-input");
const searchButton = document.querySelector(".search-button");

let page = 1;
let searchText = "";

window.onload = () => {
    getList();
}

function getList() {
    $.ajax({
        async: false,
        type: "get",
        url: "/api/account/userList",
        data: {
            "pageNumber": page,
            "searchText": searchText
        },
        dataType: "json",
        success: (response) => {
            console.log(response);

            if(response.data.length != 0) {
                loadPageNumberButtons(response.data[0].userTotalCount)
                addUserList(response.data);
            }else {
                alert("등록된 회원이 없습니다.");
                location.reload();
            }
        },
        error: (error) => {
            console.log(error);
        }
    });
}

searchInput.onkeyup = () => {
    if(window.Event.keycode == 13) {
        searchButton.click();
    }
}

searchButton.onclick = () => {
    page = 1;
    searchText = searchInput.value;
    getList();
}

function loadPageNumberButtons(userTotalCount) {
    const pageButtons = document.querySelector(".page-buttons");

    pageButtons.innerHTML = "";

    let maxPage = (userTotalCount % 10 == 0) ? userTotalCount / 10 : Math.floor(userTotalCount / 10) + 1;
    let minPage = 1;

    let startIndex = page % 5 == 0 ? page - 4 : page - (page % 5) + 1;
    let endIndex = startIndex + 4 <= maxPage ? startIndex + 4 : maxPage; 

    if(page != 1) {
        pageButtons.innerHTML = `<a href="javascript:void(0)"><li>&#60;</li></a>`;
    }

    for(let i = startIndex; i <= endIndex; i++) {
        if(i == page) {
            pageButtons.innerHTML += `<a href="javascript:void(0)" class="a-selected"><li>${i}</li></a>`;
        }else {
            pageButtons.innerHTML += `<a href="javascript:void(0)"><li>${i}</li></a>`;
        }
    }

    if(page != maxPage) {
        pageButtons.innerHTML += `<a href="javascript:void(0)"><li>&#62;</li></a>`;
    }

    const pageNumbers = pageButtons.querySelectorAll("li");

    for(let i = 0; i < pageNumbers.length; i++) {
        pageNumbers[i].onclick = () => {
            let pageNumberText = pageNumbers[i].textContent;

            if(pageNumberText == "<") {
                --page;
            }else if(pageNumberText == ">") {
                ++page;
            }else {
                page = pageNumberText;
            }

            getList();
        }
    }
}

function addUserList(userList) {
    const listBody = document.querySelector(".list-body");

    listBody.innerHTML =  "";

    userList.forEach((user) => {

        listBody.innerHTML += `
            <tr>
                <th>${user.id}</th>
                <th>${user.name}</th>
                <th>${user.userEmail}</th>
                <th>${user.createDate}</th>
            </tr>
        `
    });
}
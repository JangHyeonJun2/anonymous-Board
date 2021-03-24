$(document).ready(function () {
    temp = location.href.split("?");
    let id = temp[1];
    // HTML 문서를 로드할 때마다 실행합니다.
    showDetailBoard(id);
});

function showDetailBoard(id) {
    $('#area-wrap-detail').empty();
    $.ajax({
        type: "GET",
        url: `/api/detail/board/${id}`,
        success: function (response) {
            let title = response.title;
            let content = response.contents;

            addHTML(id,title, content);
        }
    });

    function addHTML(id,title, content) {

        let tempHTML = `<div class="mb-3">
                            <label for="inputTitle" class="form-label">제목</label>
                            <input type="text" class="form-control" id="${id}-inputTitle" value="${title}" >
                        </div>
                        <div class="mb-3">
                            <label for="inputText" class="form-label">내용</label>
                            <textarea class="form-control" id="${id}-inputText" rows="5">${content}</textarea>
                        </div>
                        <div class="middle-wrap-button">
                            <button class="btn btn-primary btn-primary-sub" onclick="writePut('${id}')">수정하기</button>
                            <button class="btn btn-primary btn-primary-sub" onclick="writeDelete('${id}')">삭제하기</button>
                        </div>`;


        $('#area-wrap-detail').append(tempHTML);
    }
}

function writePut(id) {
    let title = $(`#${id}-inputTitle`).val();
    let contents = $(`#${id}-inputText`).val();

    //제목과 내용이 없으면 경고창 띄우기
    if (isValidContents(title) && isValidContents(contents)) {
        //전달할 data JSON으로 만듭니다.
        let data = {'title' : title , 'contents' : contents};

        $.ajax({
            type: "PUT",
            url: `/api/detail/board/${id}`,
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (response) {
                alert('메시지가 성공적으로 수정되었습니다.');
                location.href = "index.html";
            }
        });
    } else {
        return;
    }
}

function writeDelete() {
    
}

function isValidContents(str) {
    if (str == '') {
        alert('내용을 입력해주세요');
        return false;
    }else
        return true;
}
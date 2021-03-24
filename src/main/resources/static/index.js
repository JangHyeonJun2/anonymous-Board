$(document).ready(function () {
    // HTML 문서를 로드할 때마다 실행합니다.
    showBoards();
});

function showBoards() {
    //기존 내용을 지운다.
    $('#card-box').empty();
    //게시판 목록을 불러와서 HTML을 붙인다.
    $.ajax({
        type: "GET",
        url: "api/board",
        success: function (response) {

            for (let i = 0; i < response.length; i++) {
                let board = response[i];
                let id = board.id;
                let user = board.uuid;
                let title = board.title;
                let content = board.contents;
                let modifiedAt = board.modifiedAt;

                addHTML(id,user,title,content,modifiedAt);
            }
        }
    });

    function addHTML(id,user,title,content,modifiedAt) {
        let link = "detail.html";
        let tempHtml = `<div class="card card-line" onclick=location.href="detail.html?"+${id}>
                                <div class="card-header">
                                    <div id="${id}-username" class="username">
                                        ${user}
                                    </div>
                                    <div class="date">
                                        ${modifiedAt}
                                    </div>
                                </div>
                                <div class="card-body">
                                    <h5 class="card-title">
                                        <div class="card-title">${title}</div>
                                    </h5>
                                    <p class="card-text">${content}</p>
                                </div>
                            </div>`;

        // 2. #cards-box 에 HTML을 붙인다.
        $('#card-box').append(tempHtml);
    }

}



function isValidContents(str) {
    if (str == '') {
        alert('내용을 입력해주세요');
        return false;
    }else
        return true;
}

function writePost() {
    //제목과 내용 가져오기
    let title = $('#inputTitle').val();
    let contents = $('#inputText').val();

    //제목과 내용이 없으면 경고창 띄우기
    if (isValidContents(title) && isValidContents(contents)) {
        //전달할 data JSON으로 만듭니다.
        let data = {'title' : title , 'contents' : contents};

        $.ajax({
            type: "POST",
            url: "/api/board",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (response) {
                alert('메시지가 성공적으로 작성되었습니다.');
                window.location.reload();
            }
        });
    } else {
        return;
    }


}
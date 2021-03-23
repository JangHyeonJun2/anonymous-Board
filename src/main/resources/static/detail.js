$(document).ready(function () {
    // HTML 문서를 로드할 때마다 실행합니다.
    showDetailBoard();
});

function showDetailBoard() {
    $.ajax({
        type: "GET",
        url: "/api/detail/board",
        success: function (response) {
            let title = response.title;
            let content = response.contents;

            addHTML(title, content);
        }
    });

    function addHTML(title, content) {
        let tempHTML = `<div class="mb-3">
                            <label for="inputTitle" class="form-label">제목</label>
                            <input type="text" class="form-control" id="inputTitle">${title}
                        </div>
                        <div class="mb-3">
                            <label for="inputText" class="form-label">내용</label>
                            <textarea class="form-control" id="inputText" rows="5">${content}</textarea>
                        </div>
                        <div class="middle-wrap-button">
                            <button class="btn btn-primary btn-primary-sub" onclick="writePut()">수정하기</button>
                            <button class="btn btn-primary btn-primary-sub" onclick="writeDelete()">삭제하기</button>
                        </div>`;

    }
}

function writePut() {

}

function writeDelete() {
    
}
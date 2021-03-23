function isValidContents(str) {
    if (str == '') {
        alert('내용을 입력해주세요');
        return false;
    }
    return true;
}

function writePost() {
    //제목과 내용 가져오기
    let title = $('#inputTitle').val();
    let contents = $('#inputText').val();

    //제목과 내용이 없으면 경고창 띄우기
    if (isValidContents(title) || isValidContents(contents)) {
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
        return
    }


}
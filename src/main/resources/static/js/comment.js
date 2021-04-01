


function addComment(id) {

    let commentTitle = $('#commentTitle-name').val();
    let commentText = $('#message-text').val();

    if (isValidContents(commentText) && isValidContents(commentTitle)) {
        let data = {"title" : commentTitle, "contents" : commentText};

        $.ajax({
            type: "POST",
            url: `/api/comment/${id}`,
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (response) {
                alert("댓글이 작성되었습니다.");
                //여기서 리다이렉스 하고 싶은데 에러남...
                location.reload();
            }
        })
    }else {
        alert("내용을 입력해주세요");
        return;
    }
}

function isValidContents(str) {
    if (str == '') {
        alert('내용을 입력해주세요');
        return false;
    }else
        return true;
}

$(document).ready(function () {
    $("#InputUserName").on("input", function(){
        var username = $('.id_input').val();
        var data = {"username" : username};

        $.ajax({
            type: "post",
            url: "/login/duplicateCheck",
            data: JSON.stringify(data),
            contentType: "application/json",
            success : function(result){
                if(result != 'fail'){
                    $('.id_input_re_1').css("display","inline-block");
                    $('.id_input_re_2').css("display", "none");
                } else {
                    $('.id_input_re_2').css("display","inline-block");
                    $('.id_input_re_1').css("display", "none");
                }
            }// success 종료
        })
    });// function 종료
});
var username = false;
var email = false;
var password = false;
var passwordconfirm = false;
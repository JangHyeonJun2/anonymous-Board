var username = false;
var email = false;
var password = false;
var passwordconfirm = false;


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
    //회원가입 버튼(회원가입 기능 작동)
    $(".join_button").click(function(){

        /*입력값 변수*/
        var username = $('#InputUserName').val();
        var email = $('#InputEmail').val()
        var password = $('#InputPassword').val()
        var confirmPassword = $('#OneMoreInputPassword').val()


        /* 아이디 유효성검사 */
        if(id == ""){
            $('.un_ck').css('display','block');
            idCheck = false;
        }else{
            $('.un_ck').css('display', 'none');
            idCheck = true;
        }

        //$("#join_form").attr("action", "/member/join");
        //$("#join_form").submit();
    });
});

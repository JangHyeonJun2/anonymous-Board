

var username_ck = false;
var email_ck = false;
var password_ck = false;
var passwordconfirm_ck = false;


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
        var email = $('#InputEmail').val();
        var password = $('#InputPassword').val();
        var confirmPassword = $('#OneMoreInputPassword').val();


        /* 아이디 유효성검사 */
        if(id == ""){
            $('.un_ck').css('display','block');
            username_ck = false;
        }else{
            $('.un_ck').css('display', 'none');
            username_ck = true;
        }

        /* 비밀번호 유효성 검사 */
        if(pw == ""){
            $('.final_pw_ck').css('display','block');
            password_ck = false;
        }else{
            $('.final_pw_ck').css('display', 'none');
            password_ck = true;
        }


        //$("#join_form").attr("action", "/member/join");
        //$("#join_form").submit();
    });
});

/* 비밀번호 확인 일치 유효성 검사 */

$('#OneMoreInputPassword').on("input", function(){
    var pw = $('#InputPassword').val();
    var pwck = $('#OneMoreInputPassword').val();
    $('#OneMoreInputPassword').css('display', 'none');


    if(pw == pwck){
        $('.pwck_input_re_1').css('display','block');
        $('.pwck_input_re_2').css('display','none');
        pwckcorCheck = true;
    }else {
        $('.pwck_input_re_1').css('display', 'none');
        $('.pwck_input_re_2').css('display', 'block');
        pwckcorCheck = false;
    }
});


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
 
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 
<script>
	
	$.datepicker.setDefaults({
		dateFormat : 'yy-mm-dd',
		prevText : '이전 달',
		nextText : '다음 달',
		monthNames : ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		monthNamesShort : ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		dayNames : ['일','월','화','수','목','금','토'],
		dayNamesShort : ['일','월','화','수','목','금','토'],
		dayNamesMin : ['일','월','화','수','목','금','토'],
		showMonthAfterYear : false,
		changeMonth : true,
		changeYear : true,
		yearSuffix : '년',
		yearRange : '1950:2021',
		minDate : "-70Y"
	});

	$( function() {
    	$( "#datepicker" ).datepicker();
  	});
  	
	let nextStep = false;
	function joinCheck(){
		if ( nextStep ){
			alert('처리중입니다.');
		}
		
		let isGenderCheck = false;
		
		if( $('#man').prop('checked') || $('#woman').prop('checked') ){
			isGenderCheck = true;
		} 
		
		if( $('#memberName').val().trim().length <= 1 ) {
			alert('이름을 두 글자 이상 입력해주세요.');
			return;
		} else if( $('#memberPhoneNumber').val().trim().length != 11) {
			alert('휴대전화 번호 양식을 지켜주세요.(- 제외)');
			return;
		} else if( $('#memberId').val().trim().length < 5) {
			alert('아이디를 6글자 이상으로 지정해주세요.');
			return;
		} else if( $('#memberPw').val().trim().length < 8) {
			alert('비밀번호를 8글자 이상으로 지정해주세요.');
			return;
		} else if ( isGenderCheck == false ){
			alert('성별을 체크해주세요.');
		}
		
		
		if(nextStep){
			$('#join_policy_checkBox').submit();	
		}
	}
	
</script>

<main class="join_page">
	<div class="title_image" style="height:455px;">
		<div class="page_title">
			<h1>회원가입</h1>
		</div>
	</div>
	
	<div class="join_container">
		<div class="policy_title">
			<div>회원가입</div>
		</div>
		
		<form class="join_form" method="POST" action="javascript:joinCheck();">
			<table class="join_table">
				<tbody>
					<tr>
						<th><span>성명</span></th>
						<td><input type="text" name="memberName" id="memberName"></td>
						<td></td>
					</tr>
					<tr>
						<th><span>휴대폰<div class="mobile_display_block"></div>번호</span></th>
						<td><input type="tel" name="memberPhoneNumber" id="memberPhoneNumber"></td>
						<td><input type="checkbox" name="SMS_agree" id="SMS_agree" <c:if test="${SMS_agree eq 'on'}">checked</c:if> > <label for="SMS_agree">SMS 알림 문자 수신동의</label></td>
					</tr>
					<tr>
						<th><span>아이디</span></th>
						<td><input type="text" name="memberId" id="memberId"></td>
						<td><button type="button">중복 체크</button></td>
					</tr>
					<tr>
						<th><span>비밀번호</span></th>
						<td><input type="text" name="memberPw" id="memberPw"></td>
						<td><span>영문소문자 및 숫자<div class="mobile_display_block"></div>(6~13 자리)</span></td>
					</tr>
					<tr>
						<th><span>비밀번호<div class="mobile_display_block"></div>확인</span></th>
						<td><input type="text" name="memberPwConfirm" id="memberPwConfirm"></td>
						<td></td>
					</tr>
					<tr>
						<th><span>이메일</span></th>
						<td><input type="email" name="memberEmail" id="memberEmail"></td>
						<td><input type="checkbox" name="email_agree" id="email_agree" <c:if test="${email_agree eq 'on'}">checked</c:if> > <label for="email_agree">메일 수신동의</label></td>
					</tr>
					<tr>
						<th><span>생년월일</span></th>
						<td><input type="text" readonly id="datepicker" name="memberBirth"></td>
						<td></td>
					</tr>
					<tr>
						<th><span>주소</span></th>
						<td class="join_address_td">
							<div class="join_address">
								<input type="text" readonly id="postcode" name="memberPostCode" placeholder="우편번호">
								<input type="text" readonly id="address" name="memberAddress" placeholder="주소">
							</div>
							<div class="join_address_button">
								<input type="button" onclick="sample2_execDaumPostcode()" value="우편번호 찾기">
							</div>
						</td>
						<td></td>
					</tr>
					<tr>
						<th><span>성별</span></th>
						<td class="memberGender">
							<span>
								<input type="radio" id="man" name="gender" value="man"><label for="man">남</label>
							</span>
							
							<span>
								<input type="radio" id="woman" name="gender" value="woman"><label for="woman">여</label>
							</span>
						</td>
						<td></td>
					</tr>
				</tbody>
			</table>
			
			<div class="buttonBox">
				<div class="btn_join"><button>회원가입</button></div>
				<div class="btn_return"><button type="button" onclick="movePage('/member/join_policy.do')">취소</button></div>
			</div>
		</form>
	</div>
</main>

<script>
	$('#memberPhoneNumber').on("change paste", function() {
		let phoneNumber = $('#memberPhoneNumber');
		phoneNumber.val( phoneNumber.val().replaceAll("-",""));
		setTimeout(function(){
			if( phoneNumber.val().length > 11 ){
				phoneNumber.val( phoneNumber.val().substring(0,11) );
				alert('휴대전화 번호 양식을 지켜주세요(- 제외)');
				phoneNumber.focus();
			}
		},250);
	})
</script>

<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
	<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
</div>
							
<script>
	var windowWidth = $(window).width();
	
	$(window).resize(function(){
		windowWidth = $(window).width();
	});

    // 우편번호 찾기 화면을 넣을 element
    var element_layer = document.getElementById('layer');

    function closeDaumPostcode() {
        // iframe을 넣은 element를 안보이게 한다.
        element_layer.style.display = 'none';
    }

    function sample2_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("address").value = addr;

                // iframe을 넣은 element를 안보이게 한다.
                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                element_layer.style.display = 'none';
            },
            width : '100%',
            height : '100%',
            maxSuggestItems : 5
        }).embed(element_layer);

        // iframe을 넣은 element를 보이게 한다.
        element_layer.style.display = 'block';

        // iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
        initLayerPosition();
    }

    // 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
    // resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
    // 직접 element_layer의 top,left값을 수정해 주시면 됩니다.
    function initLayerPosition(){
    	if ( windowWidth > 550 ){
	        var width = 500; //우편번호서비스가 들어갈 element의 width
	        var height = 400; //우편번호서비스가 들어갈 element의 height
	        var borderWidth = 5; //샘플에서 사용하는 border의 두께
    	}
    	
    	else if ( windowWidth < 550 && windowWidth > 420 ){
    		var width = 400; 
	        var height = 300; 
	        var borderWidth = 3; 
    	}
    	
    	else if ( windowWidth < 420 && windowWidth > 320 ){
    		var width = 320;
	        var height = 350; 
	        var borderWidth = 1; 
    	}
    	
    	else if ( windowWidth <= 320){
    		var width = 300;
	        var height = 350; 
	        var borderWidth = 1; 
    	}
    	
        // 위에서 선언한 값들을 실제 element에 넣는다.
        element_layer.style.width = width + 'px';
        element_layer.style.height = height + 'px';
        element_layer.style.border = borderWidth + 'px solid';
        // 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
        element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width)/2 - borderWidth) + 'px';
        element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 'px';
    }
</script>
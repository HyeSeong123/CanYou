<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<main class="flex flex-jc-c flex-ai-c width-100p" style="margin-top:30px;">
	<div class="main_container">
		<c:if test="${memberName ne null and error eq null}">
			<div class="t_center">
				<div class="h3_big"><h3>아이디 정보</h3></div>
			</div>
			<div class="bd_afafaf width-100p height70 paddingW20 flex flex-ai-c flex-jc-c result_box">
				<span>회원님의 아이디는<strong>${memberId}</strong> 입니다.</span>
			</div>
			
			<div class="flex fBox_2 flex-ai-c flex-jc-c mt50 height-100p">
				<div class="btn_login-box t_center">
					<a class="btn_login color_white paddingH20 inline-block" href="/member/memberFindId.do">로그인</a>
				</div>
				
				<div class="btn_join-box">
					<button type="submit" value="Submit">패스워드 찾기</button>
				</div>
			</div>
		</c:if>
		
		<c:if test="${error eq true}">
			<div class="t_center">
				<h1 class="color-red"><i class="fas fa-exclamation-circle"></i></h1>
				<p>
					<h3>잘못된 접근입니다.</h3>
				</p>
				<p>
					<h3>누적될 시 접근불가 조치될 수 있습니다.</h3>
				</p>
			</div>
		</c:if>
	</div>
</main>

<script>
let width = $(window).width();
if ( width < 480 ) {
	$('.result_box').removeClass('paddingW20');
	$('.result_box').removeClass('paddingH20');
}
else if ( width > 480 ) {
	$('.result_box').addClass('paddingW20');
	$('.result_box').addClass('paddingH20');
}

$( window ).resize(function() {
	width = $(window).width();
	if ( width < 480 ) {
		$('.result_box').removeClass('paddingW20');
		$('.result_box').removeClass('paddingH20');
	}
	else if ( width > 480 ) {
		$('.result_box').addClass('paddingW20');
		$('.result_box').addClass('paddingH20');
	}
});

</script>
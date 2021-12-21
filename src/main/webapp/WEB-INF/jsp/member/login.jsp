<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<script>
	function changeActive(){
		$('#member_pw').toggleClass('active');
		if( $('#member_pw').hasClass('active') ){
			$('#member_pw').attr('type' , 'text');
			
		} else {
			$('#member_pw').attr('type', 'password');
		}
	}
</script>

<main class="" style="height:calc(100vh - 150px);">
	<div class="login_image">
		<div class="page_title">
			<h1>로그인</h1>
		</div>
	</div>
	<div class="login_container">
		<div class="login_box">
			<form action="/member/doLogin.do" method="POST">
				<input type="hidden" name="afterLoginURI" value="${afterLoginURI}" />
				
				<div class="box_input">
					<div class="box_input_input">
						<div class="id_input">
							<span>아이디</span>
							<input required type="text" name="loginId" placeholder="아이디">
						</div>
						
						<div class="pw_input">
							<span>패스워드</span>
							<input required type="password" name="loginPw" placeholder="패스워드">
							<span class="open_password"><i class="far fa-eye"></i></span>
						</div>
					</div>
					
					<div class="login_btn">
						<button type="submit" value="Submit">로그인</button>
					</div>
				</div>
				
				<section class="buttonBox">
				
					<div class="">
						<input type="checkbox" name="remember" id="remember">
						<label for="remember">아이디 저장</label>
					</div>
					
					<div class="">
						<button onclick="fn_pageMove('/member/join.do'); return false;">회원가입</button>
					</div>
					
					<div class="">
						<button onclick="movePage('/member/memberFindId.do'); return false;">ID/PW 찾기</button>
					</div>
				</section>
			</form>
		</div>
		
	</div>
</main>
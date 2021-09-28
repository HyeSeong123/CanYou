<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<main class="flex flex-jc-c flex-ai-c width-100p" style="margin-top:30px;">
	<div class="main_container">
		<div class="login_box">
			<form action="/login.do" method="POST">
				<input type="hidden" name="afterLoginURI" value="${param.afterLoginURI}" />
				<div class="login_input_box"> 
					<label>
						<input name="userid" id="member_id" type="text" required />
						<div class="label-text">아이디</div>
					</label>
					<label>
						<input name="userpw" id="member_pw" type="password" required />
						<div class="label-text">패스워드</div>
					</label>
				</div>
				
				<section class="login_btn_box flex height-100p flex-jc-ar">
					<div class="btn_login-box">
						<button type="submit" value="Submit">로그인</button>
					</div>
					
					<div class="login_btn_join-box">
						<button onclick="movePage('/member/join.do'); return false;">회원가입</button>
					</div>
					
					<div class="btn_find-box">
						<button onclick="movePage('/memberfind.do'); return false;">ID/PW 찾기</button>
					</div>
				</section>
			</form>
			
		</div>
	</div>
</main>
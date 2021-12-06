<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<main class="flex flex-jc-c flex-ai-c width-100p" style="margin-top:30px;">
	<div class="main_container">
		<div class="t_center">
			<div class="h3_big"><h3>아이디 찾기</h3></div>
		</div>
		<div class="login_box">
			<form action="/member/doFindId.do" method="POST">
				<div class="login_input_box"> 
					<label>
						<input name="member_name" id="member_name" type="text" required />
						<div class="label-text">이름</div>
					</label>
					<label>
						<input name="member_email" id="member_email" type="email" required />
						<div class="label-text">이메일</div>
					</label>
				</div>
				
				<c:if test="${param.err == true}">
					<section class="login_alert">아이디와 비밀번호가 일치하지 않습니다</section>
				</c:if>
				
				<section class="login_btn_box flex height-100p flex-jc-ar">
					<div class="btn_login-box">
						<button onclick="movePage('/member/login.do')">돌아가기</button>
					</div>
					
					<div class="login_btn_join-box">
						<button onclick="movePage('/member/memberFindPw.do'); return false;">패스워드 찾기</button>
					</div>
					
					<div class="btn_find-box">
						<button type="submit">확인</button>
					</div>
				</section>
			</form>
		</div>
		
	</div>
</main>
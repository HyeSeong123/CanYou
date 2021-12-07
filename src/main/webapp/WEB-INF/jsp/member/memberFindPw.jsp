<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<main class="flex flex-jc-c flex-ai-c width-100p" style="margin-top:30px;">
	<div class="main_container">
		<div class="login_box">
			<form action="/member/doLogin.do" method="POST">
				<input type="hidden" name="afterLoginURI" value="${param.afterLoginURI}" />
				<div class=""> 
					<label>
						<input name="member_id" id="member_id" type="text" required />
						<div class="label-text">아이디</div>
					</label>
					<label>
						<input name="member_pw" id="member_pw" type="password" required />
						<div class="">이메일</div>
					</label>
				</div>
				
				<c:if test="${param.err == true}">
					<section class="">아이디와 이메일이 일치하지 않습니다</section>
				</c:if>
				
				<section class="">
					<div class="">
						<button onclick="movePage('/member/login.do')">돌아가기</button>
					</div>
					
					<div class="">
						<button onclick="movePage('/member/memberFindId.do'); return false;">아이디 찾기</button>
					</div>
					
					<div class="">
						<button onclick="/member/doFindPw.do">확인</button>
					</div>
				</section>
			</form>
		</div>
		
	</div>
</main>
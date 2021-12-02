<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<main class="flex flex-jc-c flex-ai-c width-100p" style="margin-top:30px;ss">
<div class="main_container">
	
	<div class="join_box">
		<form action="/member/doJoin.do" method="POST">
			<label>
				<input name="member_name" id="member_name" type="text" required />
				<div class="label-text">이름</div>
			</label>
			<label>
				<input name="member_id" id="member_id" type="text" required />
				<div class="label-text">아이디</div>
			</label>
			<label>
				<input name="member_pw" id="member_pw" type="password" required />
				<div class="label-text">패스워드</div>
			</label>
			<label>
				<input name="confirm_pw" id="confirm_pw" type="password" required />
				<div class="label-text">패스워드 확인</div>
			</label>
			<label>
				<input name="member_nickname" id="member_nickname" type="text" required />
				<div class="label-text">닉네임</div>
			</label>
			<label>
				<input name="member_email" id="member_email" type="text" required />
				<div class="label-text">이메일</div>
			</label>
			<label>
				<input name="member_phNum" id="member_phNum" type="text" required />
				<div class="label-text">휴대전화 번호</div>
			</label>
			
			<div class="flex fBox_2 flex-ai-c flex-jc-c height-100p">
				
				<div class="btn_return_box">
					<a class="btn_return color_white" href="${afterLoginURI}">돌아가기</a>
				</div>
				
				<div class="btn_join-box">
					<button type="submit" value="Submit">회원 가입</button>
				</div>
			</div>			
		</form>
	</div>
</div>
</main>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<main class="flex flex-jc-c flex-ai-c width-100p" style="margin-top:30px;">

	<div class="main_container">
		<div class="login_box">
			<form action="doLogin.do" method="POST">
				<div class="login_input_box"> 
					<label>
						<input name="member_id" id="member_id" type="text" required />
						<div class="label-text">아이디</div>
					</label>
					<label>
						<input name="member_pw" id="member_pw" type="password" required />
						<div class="label-text">패스워드</div>
					</label>
				</div>
				
				<section class="login_btn_box flex height-100p flex-jc-ar">
					<div class="btn_login-box">
						<button type="submit" value="Submit">로그인</button>
					</div>
					
					<div class="btn_join-box">
						<button onclick="movePage('join.do'); return false;">회원가입</button>
					</div>
				</section>
			</form>
			
		</div>
	</div>

</main>
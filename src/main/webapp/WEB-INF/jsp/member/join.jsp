<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<main class="flex flex-jc-c flex-ai-c width-100p" style="margin-top:30px;">
<div class="main_container">
	<div class="join_box">
		<form action="POST">
			<label>
				<input name="member_name" id="member_name" type="text" required />
				<div class="label-text">NAME</div>
			</label>
			<label>
				<input name="member_id" id="member_id" type="text" required />
				<div class="label-text">ID</div>
			</label>
			<label>
				<input name="member_pw" id="member_pw" type="password" required />
				<div class="label-text">PASSWORD</div>
			</label>
			<label>
				<input name="confirm_pw" id="confirm_pw" type="password" required />
				<div class="label-text">CONFIRM PASSWORD</div>
			</label>
			<label>
				<input name="confirm_pw" id="member_email" type="text" required />
				<div class="label-text">EMAIL</div>
			</label>
			<label>
				<input name="confirm_pw" id="member_phNum" type="text" required />
				<div class="label-text">PHONE NUMBER</div>
			</label>
			<div class="btn_join-box">
				<button type="submit" value="Submit">Submit</button>
			</div>
		</form>
	</div>
</div>
</main>
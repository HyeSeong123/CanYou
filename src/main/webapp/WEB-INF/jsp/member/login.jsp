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

<main class="" style="margin-top:30px;">
	<div class="">
		<div class="">
			<form action="/member/doLogin.do" method="POST">
				<input type="hidden" name="afterLoginURI" value="${afterLoginURI}" />
				<div class=""> 
					<label>
						<input name="member_id" id="member_id" type="text" required />
						<div class="">아이디</div>
					</label>
					<label style="position : relative;">
						<input name="member_pw" id="member_pw" type="password" required />
						<div class="">패스워드 <a class="" href="javascript:changeActive();"> <i class="far fa-eye"></i></button></a></div>
					</label>
				</div>
				
				<c:if test="${param.err == true}">
					<section class="">아이디와 비밀번호가 일치하지 않습니다</section>
				</c:if>
				
				<section class="">
					<div class="">
						<button type="submit" value="Submit">로그인</button>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<header>
	<div class="container">
		<div class="header flex height-100p">
			<div class="header_logo height-100p">
				<a class="flex flex-ai-c width-100p height-100p" href="/index.do">
					<span class="head_main">캔 류</span>
					<span class="head_sub">
						<span id="txt_can">Can</span>
						<span id="txt_you">You</span>
						<span id="txt_etc">keep the plan?</span>
					</span>
				</a>
			</div>
			
			<div class="head_empty"></div>
			
			<div class="menuItem">
				<ul>
					<c:forEach items="${boards}" var="board">
						<li>
							<a href="#">${board.boardName}</a>
						</li>
					</c:forEach>

					<li class="flex flex-column header_btn-member">
						<div class="login_btn_cover"><a class="login_btn" href="/member/login.do">로그인</a></div>
						<div class="join_btn_cover"><a class="join_btn" href="/member/join.do">회원가입</a></div>
					</li>
				</ul>
			</div>
		</div>
	</div>
</header>
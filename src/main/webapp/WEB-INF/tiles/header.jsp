<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<form name="uriForm" method="POST">
	<input type="hidden" name="requestURI" value="${requestURI}">
</form>

<header>
	<div class="container">
		<div class="header flex height-100p">
			<div class="header_logo height-100p">
				<a class="flex flex-ai-c width-100p height-100p" href="/index.do">
					<span class="head_main">캔 류</span>
					<span class="head_sub">
						<span id="txt_can">Can</span>
						<span id="txt_you">You</span>
						<span id="txt_etc">keep your plan</span>
						<span id="txt_que">?</span>
						<span id="txt_exclam">!</span>
					</span>
				</a>
			</div>
			
			<div class="head_empty"></div>
			
			<div class="menuItem menuItem-PC">
				<ul class="depth_1">
					<c:forEach items="${boards}" var="board" varStatus="status">
						<li class="menu${status.count}">
							<a href="#">${board.boardName}</a>
						</li>
						<li class="menu_line menu_line${status.count}"></li>
					</c:forEach>
					<c:if test="${loginedMember == null}">
						<li class="flex flex-column header_btn-member">
							<div class="login_btn_cover"><a class="login_btn" href="javascript:fn_pageMove('/member/login.do')">로그인</a></div>
							<div class="join_btn_cover"><a class="join_btn" href="javascript:fn_pageMove('/member/join.do')">회원가입</a></div>
						</li>
					</c:if>
					
					<c:if test="${loginedMember != null}">
						<li class="flex flex-column header_btn-member">
							<div class="login_btn_cover"><a class="login_btn" href="javascript:fn_pageMove('/member/logout.do')">로그아웃</a></div>
							<div class="login_btn_cover"><a class="join_btn" href="javascript:fn_pageMove('/member/myInforBeforePage.do')">내정보</a></div>
						</li>
					</c:if>
				</ul>
				
				<div class="depth_2 flex flex-jc-ar flex-ai-c">
					<c:forEach items="${boards}" var="board" varStatus="status">
						<ul class="flex flex-column height-100p flex-jc-start menu2_${status.count}">
							<c:forEach items="${boards2}" var="board2">
								<c:if test="${board.boardCode == board2.parentCode}">
									<li>
										<a href="#">${board2.boardName}</a>
									</li>
								</c:if>
							</c:forEach>
						</ul>
					</c:forEach>
					
					<ul class="flex flex-column height-100p flex-jc-start">
						<c:if test="${loginedMember == null}">
							<li class="flex flex-column">
								<a class="login_btn" href="javascript:fn_pageMove('/member/login.do')">로그인</a>
							</li>
							<li>
								<a class="join_btn" href="javascript:fn_pageMove('/member/join.do')">회원가입</a>
							</li>
						</c:if>
							
						<c:if test="${loginedMember != null}">
							<li>
								<a class="login_btn" href="javascript:fn_pageMove('/member/logout.do')">로그아웃</a>
							</li>
							<li>
								<a class="join_btn" href="javascript:fn_pageMove('/member/myInforBeforePage.do')">내정보</a>
							</li>
						</c:if>
					</ul>
				</div>
			</div>
			
			<div class="btn_hamburger flex height-100p width-100p flex-jc-end flex-ai-c">
				<div class="flex height-100p width-100p flex-column flex-jc-c flex-ai-end">
					<span></span>
					<span></span>
				</div>
			</div>
		</div>
	</div>
	
	<div class="menuItem menuItem-mobile">
		<ul>
			<c:forEach items="${boards}" var="board">
				<li>
					<a href="#">${board.boardName}</a>
				</li>
			</c:forEach>
		</ul>
		<section class="menuItem-mobile_btn flex flex-jc-c">
			<c:if test="${loginedMember == null}">
					<div>
						<a class="login_btn" href="javascript:fn_pageMove('/member/login.do')">로그인</a>
					</div>
					<div>
						<a class="join_btn" href="javascript:fn_pageMove('/member/join.do')">회원가입</a>
					</div>
				</c:if>
				
				<c:if test="${loginedMember != null}">
					<div>
						<a class="login_btn" href="javascript:fn_pageMove('/member/logout.do')">로그아웃</a>
					</div>
					<div>
						<a class="join_btn" href="javascript:fn_pageMove('/member/myInforBeforePage.do')">내정보</a>
					</div>
				</c:if>
		</section>
	</div>
</header>
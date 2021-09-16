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
					<span class="head_sub">Can You keep the plan?</span>
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
					
					<li>
						<a href="#">로그인</a>
					</li>
				</ul>
				
			</div>
		</div>
	</div>
</header>
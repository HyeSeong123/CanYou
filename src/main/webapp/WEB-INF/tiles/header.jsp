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
	<section class="header_container height-100p">
		<section class="header_min_container height-100p">
		
			<div class="header height-100p flex">
				<div class="header_logo_title height-100p flex flex-ai-c">
					<a class="logo" href="/index.do"> <h2>Eyelac Brow</h2> </a>
				</div>
				
				<div class="header_menu height-100p flex flex-ai-c header_pc">
					<ul class="flex">
						<c:forEach items="${boards}" var="board">
							<li>
								<a href="#">${board.boardName}</a>
							</li>
						</c:forEach>
					</ul>
				</div>
				
				<div class="header_sns height-100p flex flex-ai-c header_pc">
					<ul class="flex">
						<li>
							<a href="#"><i class="far fa-comment"></i></a>
						</li>
						
						<li>
							<a href="#"><i class="fab fa-instagram"></i></a>
						</li>
						
					</ul>
				</div>
				
				<div class="header_mobile flex-grow-1"></div>
				
				<div class="header_hamburger header_mobile height-100p">
					<div></div>
					<div></div>
					<div></div>
				</div>
			</div>
			
			<div class="header_mobile">
			</div>
		</section>
	</section>
</header>
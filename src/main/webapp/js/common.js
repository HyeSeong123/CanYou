function movePage(page){
	location.href=page;
}
function fn_pageMove(moveUrl){
	var frm = document.uriForm;
	frm.method = "POST";
	frm.action = moveUrl;
	frm.submit();
}

function fadeInMobileHead(){
	let header_menu = $('.header_mobile_menu');
	let body = $('body');
	header_menu.addClass('active');
	
	if( header_menu.hasClass('active') ){
		body.css('overflow', 'hidden');
		body.css('touch-action', 'none');
		
		header_menu.fadeIn();
		header_menu.css('display', 'flex');
	}
}

function fadeOutMobileHead(){
	let header_menu = $('.header_mobile_menu');
	let body = $('body');
	header_menu.removeClass('active');
	body.css('overflow', 'auto');
	body.css('touch-action', 'auto');
	
	header_menu.fadeOut();
}

function openSubmenu(){
	let parent = $(event.target).closest('li').children('ul');
	
	if( ! parent.hasClass('active') ){
		parent.stop();
		parent.slideDown();
		parent.addClass('active');
	} else if ( parent.hasClass('active') ){
		parent.stop();
		parent.slideUp();
		parent.removeClass('active');
	}
}

$('.header_hamburger').click(function (){
	fadeInMobileHead();
});

$(window).resize(function(){
	fadeOutMobileHead();
});

$('.mobile_menu_exit span').click(function(){
	fadeOutMobileHead();
});


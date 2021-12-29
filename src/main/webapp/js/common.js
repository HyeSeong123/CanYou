function movePage(page){
	if(page == $(location).attr('pathname') ){
		page = "/index.do";
	}
	
	location.href= page;
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
	
	$(event.target).closest('li').addClass('openSubMenu');
	
	if( ! parent.hasClass('active') ){
		parent.stop();
		parent.slideDown();
		parent.addClass('active');
	} else if ( parent.hasClass('active') ){
		parent.stop();
		parent.slideUp();
		parent.removeClass('active');
		$(event.target).closest('li').removeClass('openSubMenu');
	}
}

let main_section1 = '';
let main_section2 = '';
let main_section3 = '';
let main_section4 = '';

let curUrl = $(location).attr('pathname');

if ( curUrl.includes('index.do') ){
	main_section1 = $('#main_section1');
	main_section2 = $('#main_section2');
	main_section3 = $('#main_section3');
	main_section4 = $('#main_section4');
}

function smooth_scroll(section){
	
	let ele = "#" + section;
	
	if ( ! curUrl.includes('index.do') ){
		movePage('/index.do' + ele);
	}
	
	let li = $('.mobile_menu_middle ul li');
	let children = $('.mobile_menu_middle ul li ul');
	
	li.removeClass('openSubMenu');
	children.removeClass('active');
	children.stop();
	children.slideUp();
	
	$('.header_mobile_menu').removeClass('active');
	$('.header_mobile_menu').fadeOut();
	
	$('body').css('overflow', 'auto');
	$('body').css('touch-action', 'auto');
	
	
	
	let scrollPosition = $(ele).offset().top;
	
	window.scroll({top: scrollPosition, behavior: 'smooth'});
}

$('html').click(function(e){
	let li = $('.mobile_menu_middle ul li');
	let children = $('.mobile_menu_middle ul li ul');
	
	if( ! $(e.target).closest('li').hasClass('openSubMenu') ){
		li.removeClass('openSubMenu');
		children.removeClass('active');
		children.stop();
		children.slideUp();
	}
	
})

$('.header_menu ul li').hover(function(){
	let sldUl = $(this).children('ul');
	$(this).children('ul').stop();
	$(this).children('ul').slideDown();
}, function(){
		let sldUl = $(this).children('ul');
		$(this).children('ul').stop();
		$(this).children('ul').slideUp();
	}
);

$('.header_hamburger').click(function (){
	document.querySelector('.header_mobile_menu').style.height = window.innerHeight + "px";
	fadeInMobileHead();
});

$(window).resize(function(){
	fadeOutMobileHead();
});

$('.mobile_menu_exit span').click(function(){
	fadeOutMobileHead();
});


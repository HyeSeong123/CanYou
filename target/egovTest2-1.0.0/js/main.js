const logo1 = $('#txt_you');
const logo2 = $('#txt_can');
const logo3 = $('#txt_etc');
const logo4 = $('#txt_que');
const logo4_1 = $('#txt_exclam');

const menuPC = $('.menuItem-PC');
const head_sub = $('.head_sub');
const btnHamburger = $('.btn_hamburger div');

function logo_movePosition(){
	gsap.to(logo1,{
		x: -120,
		y: -3,
		scale : 1.5,
		duration : 0.5
		
	});
	gsap.to(logo2,{
		x: -32,
		y: -3,
		scale : 1.5,
		duration : 0.6
	});
	gsap.to(logo3,{
		x: -60,
		duration : 0.7
	});
	logo4_1.fadeIn(400);
	logo4_1.css('display', 'inline-block');
	gsap.to(logo4_1,{
		x: -75,
		duration : 0.8
	});
}
function logo_zeroPosition(){
	gsap.to(logo1,{
		x: 0,
		y: 0,
		scale : 1,
		duration : 0.7
	});
	
	gsap.to(logo2,{
		x: 0,
		y: 0,
		scale : 1,
		duration : 0.6
	});
	
	gsap.to(logo3,{
		x: 0,
		duration : 0.6
	});
	logo4_1.fadeOut(400);
	gsap.to(logo4_1,{
		x: 0,
		duration : 0.8
	});
}

$('.header_logo').mouseenter(function(){
	logo_movePosition();
});

$('.header_logo').mouseleave(function(){
	logo_zeroPosition();
});
$(window).bind(function(){
	logo_zeroPosition();
});
$(window).blur(function(){
	logo_zeroPosition();
});

function logo_init(){
	var windowWidth = $(window).width();
	
	if(windowWidth < 1180){
		menuPC.css('display', 'none');
	}
	
	if(windowWidth < 850){
		head_sub.css('display', 'none');
	}
}

function widthResize(){
	var windowWidth = $(window).width();
	
	if(windowWidth < 1180){
		gsap.to('.menuItem-PC',{
			y : -100,
			duration : 0.3
		});
		$('.menuItem-PC').fadeOut(300);
	} else if(windowWidth > 1180){
		$('.menuItem-PC').fadeIn(300);
		gsap.to('.menuItem-PC',{
			y : 0,
			duration : 0.3
		});
	}
	
	if(windowWidth < 850){
		gsap.to('.head_sub',{
			y : -100,
			duration : 0.3
		});
		$('.head_sub').fadeOut(500);
	} else if(windowWidth > 800){
		$('.head_sub').fadeIn(300);
		gsap.to('.head_sub',{
			y : 0,
			duration : 0.3
		});
	}
}
$(window).resize(function(){
	widthResize();
});
logo_init();

btnHamburger.click(function(){
	btnHamburger.toggleClass("active");
	$('.menuItem-mobile').toggleClass("active");
});
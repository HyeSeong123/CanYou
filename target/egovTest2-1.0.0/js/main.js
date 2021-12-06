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
		duration : 0.6
	});
	if (logo4_1.is(":animated")){
		logo4_1.fadeIn(400);
	}
	logo4_1.css('display', 'inline-block');
	gsap.to(logo4_1,{
		x: -75,
		duration : 0.7,
		opacity : 1
	});
}
function logo_zeroPosition(){
	gsap.to(logo1,{
		x: 0,
		y: 0,
		scale : 1,
		duration : 0.5
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
	if (logo4_1.is(":animated")){
		logo4_1.fadeOut(400);
	}
	gsap.to(logo4_1,{
		x: 0,
		duration : 0.7,
		opacity : 0
	});
}

$('.header_logo').hover(function(){
	logo_movePosition();
}, function(){
		logo_zeroPosition();
	}
);

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

function menuBar(num1, num2){
	
	if(num1 == 1){
		if(num2 == 1){
			menu_line1.css('height', '55%');
		} else if (num2 == 2){
			menu_line1.css('height', '55%');
			menu_line2.css('height', '55%');
		} else if (num2 == 3){
			menu_line2.css('height', '55%');
			menu_line3.css('height', '55%');
		} else if (num2 == 3){
			menu_line3.css('height', '55%');
			menu_line4.css('height', '55%');
		} else if (num2 == 4){
			menu_line3.css('height', '55%');
			menu_line4.css('height', '55%');
		}
	}
	
	else if (num1 == 2){
		if(num2 == 1){
			menu_line1.css('height', '30%');
		} else if (num2 == 2){
			menu_line1.css('height', '30%');
			menu_line2.css('height', '30%');
		} else if (num2 == 3){
			menu_line2.css('height', '30%');
			menu_line3.css('height', '30%');
		} else if (num2 == 3){
			menu_line3.css('height', '30%');
			menu_line4.css('height', '30%');
		} else if (num2 == 4){
			menu_line3.css('height', '30%');
			menu_line4.css('height', '30%');
		}
	}
}

$(window).resize(function(){
	widthResize();
});
logo_init();

$('.menuItem').hover(function() {
	slideUpDown(1);
},function(){
		slideUpDown(2);
	}
);
$('.depth_2 ul').hover(function(){
	var menuClass = $(this).attr('class');
	var menuNum = menuClass.replace('menu2_','');
	menuNum = menuNum.replace('100p', '');
	menuNum = menuNum.replace(/[^0-9]/g, '');
	menuBar(1,menuNum);
},
	function(){
		var menuClass = $(this).attr('class');
		var menuNum = menuClass.replace('menu2_','');
		menuNum = menuNum.replace('100p', '');
		menuNum = menuNum.replace(/[^0-9]/g, '');
		menuBar(2,menuNum);
	}
);

function slideUpDown(num){
	const depth1 = $('.menuItem');
	const depth2 = $('.depth_2');
	const member_btn = $('.header_btn-member');
	
	if ( num == 1 ) {
		if( ! depth2.is(':animated') ){
			depth2.slideDown(300);
			depth2.css('display', 'flex');
			depth2.find('a').css('opacity', '1');
			member_btn.css('opacity', '0');
			member_btn.css('pointer-events', 'none');
		}
	}
	else if ( num == 2 ){
		if( ! depth2.is(':animated') ){
			depth2.slideUp(300);
			depth2.find('a').css('opacity', '0');
			$('.header_btn-member').css('opacity', '1');
		}
	}
}

const menu1 = $('.menu1');
const menu2 = $('.menu2');
const menu3 = $('.menu3');
const menu4 = $('.menu4');
const menu_line1 = $('.menu_line1');
const menu_line2 = $('.menu_line2');
const menu_line3 = $('.menu_line3');
const menu_line4 = $('.menu_line4');

$('.depth_1 li').hover(function(){
	var menuClass = $(this).attr('class');
	var menuNum = menuClass.replace('menu','');
	menuBar(1,menuNum);
},
	function(){
		var menuClass = $(this).attr('class');
		var menuNum = menuClass.replace('menu','');
		menuBar(2,menuNum);
	}
)

btnHamburger.click(function(){
	btnHamburger.toggleClass("active");
	$('.menuItem-mobile').toggleClass("active");
});
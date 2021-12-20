var windowWidth = $(window).width();

$(window).resize(function(){
	windowWidth = $(window).width();
});

let scr = 0;
$(window).scroll(function(){
	scr = $(window).scrollTop();
	
	let scrollPosition1 = $('#main_section1').offset().top - 60;
	let scrollPosition2 = $('#main_section2').offset().top - 150;
	let scrollPosition3 = $('#main_section3').offset().top - 250;
	let scrollPosition4 = $('#main_section4').offset().top - 400;
	
	let section1 = $('.right_ball > a:nth-child(1) > div ');
	let section2 = $('.right_ball > a:nth-child(2) > div ');
	let section3 = $('.right_ball > a:nth-child(3) > div ');
	let section4 = $('.right_ball > a:nth-child(4) > div ');
	
	if ( scr >= 0 && scr < scrollPosition2){
		section1.addClass('active');
		section2.removeClass('active');
		section3.removeClass('active');
		section4.removeClass('active');
	}
	if ( scr >= scrollPosition2 && scr < scrollPosition3){
		section1.removeClass('active');
		section2.addClass('active');
		section3.removeClass('active');
		section4.removeClass('active');
	}
	if ( scr >= scrollPosition3 && scr < scrollPosition4){
		section1.removeClass('active');
		section2.removeClass('active');
		section3.addClass('active');
		section4.removeClass('active');
	}
	if ( scr >= scrollPosition4){
		section1.removeClass('active');
		section2.removeClass('active');
		section3.removeClass('active');
		section4.addClass('active');
	}
})

function move_section2(){
	let main = $('.main_wrapper');
	let main2_img = $('.main_wrapper2_left_imgBox'); 
	let main2_logo = $('.main_wrapper2_logoBox');
	let main2_manual = $('.main_wrapper2_manual');
	
	let t1 = gsap.timeline({
		scrollTrigger : {
			trigger : main,
			start : "bottom 60%",
			toggleActions : 'restart none none reverse',
			end : "+=500",
		}
	});
	
	t1.to(main2_img, { opacity : 1, y : -100, x:50, duration : 0.9 });
	t1.to(main2_logo, { opacity : 1, y : -200, duration : 0.7 }, -0.1);
	t1.to(main2_manual, { opacity : 1, y : -150, duration : 0.8 }, -0.1);
}

function move_section3(){
	let main = $('#main_section2');
	let main3_logo = $('.section3_logo');
	
	let t1 = gsap.timeline({
		scrollTrigger : {
			trigger : main,
			start : "90% center",
			toggleActions : 'restart none none reverse',
			end : "+=500",
		}
	});
	
	t1.to(main3_logo, { opacity :1, y : -70, duration : 1});
}

function smooth_scroll(section){
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
	
	let ele = "#" + section.id;
	
	let scrollPosition = $(ele).offset().top;
	
	window.scroll({top: scrollPosition, behavior: 'smooth'});
}

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

if ( windowWidth > 1000 ){
	setTimeout(function(){
		move_section2();
		move_section3();
	},800)
}



var t1 = gsap.timeline({
	repeat : -1,
	repeatDelay : 0.7
});

t1.to(".main_wrapper_arrow", {
	opacity : 1,
	y : 100,
	duration : 1.3
});

var windowWidth = $(window).width();


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


$('.header_menu ul li').hover(function(){
	let sldUl = $(this).children('ul');
	
	if(!sldUl.is(":animated")) {
		$(this).children('ul').slideDown();
	}
}, function(){
		let sldUl = $(this).children('ul');
		if(!sldUl.is(":animated")) {
			$(this).children('ul').slideUp();
		}
	}
);



function smooth_scroll(section){
	let ele = "#" + section.id;
	
	let scrollPosition = $(ele).offset().top;
	
	window.scroll({top: scrollPosition, behavior: 'smooth'});
	
}
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
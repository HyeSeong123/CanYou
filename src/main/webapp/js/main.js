gsap.registerPlugin(ScrollTrigger);

var windowWidth = $(window).width();

if ( windowWidth > 1000 ){
	gsap.to('.main_wrapper2_left_imgBox', {
		scrollTrigger:{
			trigger : '.main_wrapper',
			toggleActions : 'restart none none reverse',
			start : "bottom 60%",
			markers : true
		},
		y : -100,
		x : 50,
		opacity : 1,
		duration : 1
	});
	
	gsap.to('.main_wrapper2_logoBox', {
		scrollTrigger:{
			trigger : '.main_wrapper',
			toggleActions : 'restart none none reverse',
			start : "bottom 60%",
			markers : true
		},
		y : -200,
		opacity : 1,
		duration : 0.7
	});
	
	gsap.to('.main_wrapper2_manual', {
		scrollTrigger:{
			trigger : '.main_wrapper',
			toggleActions : 'restart none none reverse',
			start : "bottom 60%",
			markers : true
		},
		y : -150,
		opacity : 1,
		duration : 0.8
	});
}
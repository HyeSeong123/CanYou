
$('.header_logo').mouseenter(function(){
	$('.header_logo').addClass("active");
	gsap.to('#txt_you',{
		x: -120,
		y: -3,
		scale : 1.5,
		duration : 0.5
		
	});
	gsap.to('#txt_can',{
		x: -32,
		y: -3,
		scale : 1.5,
		duration : 0.6
	});
	gsap.to('#txt_etc',{
		x: -60,
		duration : 0.7
	});
});

$('.header_logo').mouseleave(function(){
	gsap.to('#txt_you',{
		x: 0,
		y: 0,
		scale : 1,
		duration : 0.7
	});
	
	gsap.to('#txt_can',{
		x: 0,
		y: 0,
		scale : 1,
		duration : 0.6
	});
	
	gsap.to('#txt_etc',{
		x: 0,
		duration : 0.6
	});
});

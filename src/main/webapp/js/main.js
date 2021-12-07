let parentMenu = $('.header_bottom_box > ul > li');

parentMenu.hover(function(){

	let childMenu = $(this).children('ul');
		childMenu.stop().slideDown();
	
});

parentMenu.mouseleave(function(){
	let childMenu = $(this).children('ul');
		childMenu.stop().slideUp();
	
})
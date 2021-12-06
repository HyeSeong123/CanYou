function movePage(page){
	location.href=page;
}
function fn_pageMove(moveUrl){
	var frm = document.uriForm;
	frm.method = "POST";
	frm.action = moveUrl;
	frm.submit();
}
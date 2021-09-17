<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>캔류</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
	
	<link rel="stylesheet" href="/css/default.css">
	<link rel="stylesheet" href="/css/style.css">
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.7.1/gsap.min.js"></script>
	
</head>
<body>
	<tiles:insertAttribute name="header" ></tiles:insertAttribute>
	
	<section>
		<tiles:insertAttribute name="main"></tiles:insertAttribute>
	</section>
	
	<tiles:insertAttribute name="footer" ></tiles:insertAttribute>
	<script src="/js/main.js"></script>
</body>
</html>
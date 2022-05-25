<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jspweb/css/productcart.css" rel="stylesheet">
</head>
<body>
<%@include file="../header.jsp" %>

	<div class="container">
		<div class="processbox">
				<span>01 옵션선택</span> <span> > </span>
				<span>02 장바구니</span> <span> > </span>
				<span>03 주문결제</span> <span> > </span>
				<span id="process_active">04 주문완료</span> <span> > </span>
			</div>
			<h3>주문이 완료되었습니다</h3>
			<div class="col-sm-4 offset-4" style="align-content: center;"><br>
				<a href="/jspweb/main.jsp"><button class="form-control py-2" > 계속 쇼핑하기 </button></a>
			</div>
			
	</div>
<script type="text/javascript" src="/jspweb/js/productcart.js"></script>
<%@include file="../footer.jsp" %>	
</body>
</html>  
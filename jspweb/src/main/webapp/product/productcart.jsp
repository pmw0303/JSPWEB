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

	
		
		<div class="container"> <!-- container(b) : 컨테이너  -->
			<div class="processbox">
				<span>01 옵션선택</span> <span> > </span>
				<span id="process_active">02 장바구니</span> <span> > </span>
				<span>03 주문결제</span> <span> > </span>
				<span>04 주문완료</span> <span> > </span>
			</div>
			
			<table class="table my-5" id="carttable"> <!-- table(b) : 테이블 // my(b) : 위아래 마진(바깥여백) -->
				<!-- js에서 데이터가 들어가는 위치 -->
			</table>
			
			<div class="col-sm-2">
				<button class="form-control" onclick="cancel(-1)"> 전체 삭제 </button>
			</div>
			<div class="paybox">
				<span> 총 상품금액</span> <span id="sumprice"> 20,000원</span>
				<span> + </span>
				<span> 배송비 </span> <span id="deliverypay"> 3,000원 </span>
				<span> = </span>
				<span> 총 주문금액 </span> <span id="totalpay"> 23,000원 </span>
				
				<div class="pointbox">
					<span> 적립 예정 포인트 </span> <span id="point"> 2,000 </span>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-3 offset-3">
					<a href="/jspweb/main.jsp"><button class="form-control py-2" > 계속 쇼핑하기 </button></a>
				</div>
				<div class="col-sm-3">
				<a href="/jspweb/product/orderpay.jsp">
					<button class="form-control py-2" style="background-color: blue; color: white;"> 구매하기 </button>
				</a>
				</div>
			</div>
			
		</div>
	<script type="text/javascript" src="/jspweb/js/productcart.js"></script>

<%@include file="../footer.jsp" %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>zzz</title>
	<!-- 사용자 정의 css -->
	<link href="/jspweb/css/main.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">


</head>
<body>
	<!-- 헤더페이지 -->
	<%
		String loginid = (String)session.getAttribute("login");
		// 세션 호출 - 기본타입=Object
	%>

	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<a href="/jspweb/main.jsp" class="logo_img"> <img style="width: 200px;" alt="" src="/jspweb/img/nike.png"> </a>
			</div>
			<div class="col-md-4">
				
			</div>
			<div class="col-md-4 d-flex justify-content-end	">
				<ul class="nav">
				
					<!-- 로그인 안된 상태 -->
				<% if(loginid == null){ %>
					<li><a href="/jspweb/member/login.jsp" class="header_topmenu"> 로그인 ㅣ</a></li>
					<li><a href="/jspweb/member/signup.jsp" class="header_topmenu"> 회원가입 ㅣ</a></li>
				<%}%>
					<!-- 로그인 된 상태 -->
				<% if(loginid != null){ %>
					<li><span><%=loginid %> 님</span></li>
					<li><a href="/jspweb/member/logout.jsp" class="header_topmenu"> 로그아웃 ㅣ</a></li>
					<li><a href="/jspweb/member/info.jsp" class="header_topmenu"> 회원정보 ㅣ</a></li>
				
					<!-- 로그인 id 가 관리자 -->
					<% if(loginid.equals("admin")){ %>
						<li><a href="/jspweb/admin/dashboard.jsp" class="header_topmenu">관리자모드</a></li>
					<%}%>
				<%}%>	
					<li><a href="/jspweb/board/boardlist.jsp?key=&keyword=" class="header_topmenu">자유게시판</a></li>
				</ul>
			</div> <!-- 상단 메뉴 끝 -->
			
			<div class="navbar navbar-expand-md navbar-light"> <!-- 메인 메뉴 -->
				<ul class="navbar-nav col-md-12 justify-content-between">
					<li class="nav-item"><a href="#">BIG SIZE</a></li>
					<li class="nav-item"><a href="#" style="color: #00D8FF;">MUSCLE-FIT</a></li>
					<li class="nav-item"><a href="#" style="color: #0100FF;">1+1 EVENT</a></li>
					<li class="nav-item dropdown">
						<a href="#" data-bs-toggle="dropdown">OUTER</a>
						<!-- dropdown -->
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">PADDING</a>
							<a class="dropdown-item" href="#">COAT</a>
							<a class="dropdown-item" href="#">JACKET</a>
							<a class="dropdown-item" href="#">CARDIGAN</a>
						</div>
					</li>
					<li class="nav-item dropdown">
						<a href="#" data-bs-toggle="dropdown">TOP</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">MENU 1</a>
							<a class="dropdown-item" href="#">MENU 2</a>
							<a class="dropdown-item" href="#">MENU 3</a>
							<a class="dropdown-item" href="#">MENU 4</a>
						</div>
					</li>
					<li class="nav-item dropdown" >
						<a href="#" data-bs-toggle="dropdown">PANTS</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">MENU 1</a>
							<a class="dropdown-item" href="#">MENU 2</a>
							<a class="dropdown-item" href="#">MENU 3</a>
							<a class="dropdown-item" href="#">MENU 4</a>
						</div>
					</li>
					<li class="nav-item dropdown" >
						<a href="#" data-bs-toggle="dropdown">SHOES</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">MENU 1</a>
							<a class="dropdown-item" href="#">MENU 2</a>
							<a class="dropdown-item" href="#">MENU 3</a>
							<a class="dropdown-item" href="#">MENU 4</a>
						</div>
					</li>
					<li class="nav-item dropdown">
						<a href="#" data-bs-toggle="dropdown">ACC</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">MENU 1</a>
							<a class="dropdown-item" href="#">MENU 2</a>
							<a class="dropdown-item" href="#">MENU 3</a>
							<a class="dropdown-item" href="#">MENU 4</a>
						</div>
					</li>
					<li class="nav-item"><a class="blinking" href="/jspweb/game.jsp">GAMES</a></li>
					<li class="nav-item"><a href="/jspweb/teamchatting.jsp">LIVE CHAT</a></li>
					<li class="nav-item"><a class="blinking" href="#" style="color: #FFBB00;">LIKE MODEL</a></li>
					<li class="nav-item"><a class="blinking" href="#" style="color: #FF0000;">50% D/C</a></li>
					<li class="nav-item"> <input type="text" class="header_input" size="13"> </li>
					<li class="nav-item"> <a href="#"> <i class="fas fa-search"></i> </a> </li>	
					<li class="nav-item"> <a href="/jspweb/product/productcart.jsp"><i class="fa fa-shopping-basket" aria-hidden="true"></i><span class="shoppingbox">3</span></a></li>
				</ul>
			</div>
			
		</div>
		
		
		<!-- 공통 -->
		
		
		
		
			
			
			
			
		
	</div>
	
	
	<!-- 사용자 정의 js -->
	<script src="/jspweb/js/main.js" type="text/javascript"></script>
	<!-- 부트스트랩 cdn -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- jquery 최신 cdn -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>
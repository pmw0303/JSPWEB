<%@page import="dao.MemberDao"%>
<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%@include file="../header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-3"> <!-- 사이드바 -->
				<%@include file="infosidebar.jsp"%>
			</div>
			<div class="col-md-9"> <!-- 본문 -->
				<h3>회원정보</h3>
				
				<%
					// 1. 세션호출 [회원id 저장] -> 로그인 서블릿 참조
					String mid = (String)session.getAttribute("login");		
					// 2. DB 메소드 호출
					Member member = MemberDao.getmemberDao().getmember(mid);	
				%>
				회원번호 : <%=member.getMno() %><br>
				아이디 : <%=member.getMid() %><br>
				이름 : <%=member.getMname() %><br>
				연락처 : <%=member.getMphone() %><br>
				이메일 : <%=member.getMemail() %><br>
				배송주소 : <%=member.getMaddress() %><br>
				포인트 : <%=member.getMpoint() %><br>
				가입날짜 : <%=member.getMdate() %>
				
				 
			</div>
		</div>
	</div>
	<%@include file="../footer.jsp" %>
</body>
</html>
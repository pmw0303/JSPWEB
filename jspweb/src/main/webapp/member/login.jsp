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
		<div class="page-header">
	        <div class="col-md-6 offset-3">
	       		 <h3>로그인</h3>
	        </div>
    	</div>
    	 <div class="col-md-6 offset-3">
    	 	<form class="form-login" action="../login" method="post">
    	 		<div class="form-group">
    	 			<label>아이디</label> 
    	 			<input class="form-control" type="text" name="mid">
    	 		</div>
    	 		<div class="form-group">
    	 			<label>비밀번호</label> 
    	 			<input class="form-control" type="password" name="mpassword">
    	 		</div>
    	 		<div class="form-group text-center"><br>
					<button class="btn btn-success" type="submit">로그인</button>
					<button class="btn btn-warning" onclick="location.href='../main.jsp'" type="button">홈으로</button>
				</div>
				<!-- 로그인 실패시 -->
				<%
					String result = request.getParameter("result");
					if(result != null && result.equals("2")){
				%>	
						<span> 회원 정보가 없습니다</span>	
				<%
					}
				%>
    	 	</form>
    	 </div>
	</div>
	
	<%@include file="../footer.jsp" %>
	
</body>
</html>
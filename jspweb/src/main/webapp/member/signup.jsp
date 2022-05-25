<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

<%@include file = "../header.jsp" %>
<div class="container">
	<div class="page-header">
        <div class="col-md-6 offset-3">
        <h3>회원가입</h3>
        </div>
    </div>
    <div class="col-md-6 offset-3">
	<form class="form-signup" id="signupform" action="../signup" method="post">
	
		<div class="form-group">
		<label>아이디</label> 
		<input class="form-control" type="text" id="mid" name="mid" placeholder="user id">
		</div>
		<span id="idcheck"></span> 
		<br>
		<div class="form-group">
		<label>비밀번호</label>  
		<input class="form-control" type="password" id="mpassword" name="mpassword" placeholder="user password"> 
		</div>
		<div class="form-group">
		<label>비밀번호 확인</label> 
		<input class="form-control" type="password" id="mpasswordcheck" placeholder="password check">
		</div>
		<span id="passwordcheck"></span>
		<br>
		<div class="form-group">
		<label>이름</label> 
		<input class="form-control" type="text" id="mname" name="mname" placeholder="user name">
		</div>
		<span id="namecheck"></span>
		<br>
		 <div class="form-group">
		<label>연락처</label> 
		<input class="form-control" type="text" id="mphone" name="mphone" placeholder="user phone">
		</div>
		<span id="phonecheck"></span>
		<br>
		<div class="form-group">
		<label>이메일</label><br> 
			
			<input type="text" id="memail" name="memail" placeholder="user email">
			@
			<input type="text" id="memailaddress" name="memailaddress" >
			
			<select id="emailselect">
				<option value=""> 직접입력 </option>
				<option value="naver.com"> naver.com </option>
				<option value="nate.com"> nate.com </option>
				<option value="daum.com"> daum.com </option>
			</select>
			
		</div>
		<span id="emailcheck"></span>
		<br>
		
		<div class="form-group">
			<label>주소</label> 
			<input class="form-control" type="text" id="sample4_postcode" name="address1" placeholder="우편번호">
			<input class="form-control" type="text" id="sample4_roadAddress" name="address2" placeholder="도로명주소">
			<input class="form-control" type="text" id="sample4_jibunAddress" name="address3" placeholder="지번주소">
			<span id="guide" style="color:#999;display:none"></span>
			<input class="form-control" type="text" id="sample4_detailAddress" name="address4" placeholder="상세주소">
			<br><input class="form-control" type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
		</div>
		<span id="addresscheck"></span>
		<br>
		<div class="form-group text-center">
			<button class="btn btn-success" onclick="signup()" type="button">가입하기</button>
			<button class="btn btn-warning" onclick="location.href='../main.jsp'" type="button">뒤로가기</button>
		</div>
	</form>
	</div>
</div>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../js/signup.js" type="text/javascript"></script>
<%@include file = "../footer.jsp" %>




</body>
</html>
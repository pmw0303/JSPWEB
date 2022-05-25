<%@page import="dao.BoardDao"%>
<%@page import="dto.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	
	<%@include file ="../header.jsp" %>

	<div class="container">
		<h3> 내 문의 </h3>
		
		<%
			String mid = (String)session.getAttribute("login");
			int mno = MemberDao.getmemberDao().getmno(mid);
		%>
		
		<div>
			<table class="table"> <!-- 테이블 -->
				<tr>
					<th> 번호 </th> <th> 제목 </th> <th> 작성자 </th> 
					<th> 조회수  </th> <th> 작성일 </th> 
				</tr>
				<!-- for 문 -->
				<%
				// 1. 모든 게시물  호출 
				String key = "";
				String keyword = "";
				ArrayList<Board> boardlist = 
					BoardDao.getBoardDao().getboardlist();
				for( Board board : boardlist ){
					if(board.getMid().equals(mid)) {
			%>
					<tr>
						<td> <%=board.getBno() %> </td>
						<td>
							<a href="boardview.jsp?bno=<%=board.getBno()%>">
									<%=board.getBtitle() %>
								</a> 
						</td>
						
						<td> <%=board.getMid()%> </td>
						<td> <%=board.getBview() %> </td>
						<td> <%=board.getBdate() %> </td>
					</tr>
				<%
					}}
				%>
			</table>
		</div>
	</div>
	<%@include file ="../footer.jsp" %>

</body>
</html>
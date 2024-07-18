<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<h3>게시글 상세(board.jsp)</h3>
<%
	BoardVO board = (BoardVO) request.getAttribute("board");
%>
<table class="table">
	<tr>
		<th>글번호</th>
		<td>
			<%=board.getBoardNo() %>
		</td>
		<th>조회수</th>
		<td><%=board.getViewCnt() %></td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="3"><%=board.getTitle()%></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><%=board.getContent() %></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td colspan="3"><%=board.getWriteDate()%></td>	</tr>
	<tr>
		<td colspan="2" align="center"><input class="btn btn-primary"
			type="submit"> <input class="btn btn-secondary" type="reset">
		</td>
	</tr>
</table>
<%@ include file="../includes/footer.jsp"%>

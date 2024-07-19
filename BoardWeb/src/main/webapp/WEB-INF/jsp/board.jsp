<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<h3>게시글 상세(board.jsp)</h3>
<%
BoardVO board = (BoardVO) request.getAttribute("board");
%>
<form action="removeBoard.do">
<input type="hidden" name="bno" value="<%=board.getBoardNo()%>">
<table class="table">
	<tr>
		<th>글번호</th>
		<td><%=board.getBoardNo()%></td>
		<th>조회수</th>
		<td><%=board.getViewCnt()%></td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="3"><%=board.getTitle()%></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><%=board.getContent()%></td>
	</tr>
		<tr>
		<th>작성자</th>
		<td colspan="3"><%=board.getWriter()%></td>
	</tr>
	<tr>
		<th>작성일시</th>
		<td colspan="3"><%=board.getWriteDate()%></td>
	</tr>
	<tr>
		<td colspan="4" align="center">
		<input class="btn btn-danger" type="submit" value="삭제화면"> 
		<button class="btn btn-warning" type="button">수정화면</button>
		</td>
	</tr>
</table>
</form>

<script>
	document.querySelector('form>table button.btn.btn-warning')
		.addEventListener('click', function(e){
			location.href = 'modifyBoard.do?bno=<%=board.getBoardNo()%>'; 			
		});
</script>
<%@ include file="../includes/footer.jsp"%>

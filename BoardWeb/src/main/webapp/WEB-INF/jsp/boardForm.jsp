<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<h3>등록화면(boardForm.jsp)</h3>
<form action="addBoard.do" method="post" enctype="multipart/form-data">
<table class="table">
	<tr>
		<th>제목</th>
		<td><input class="form-control" type="text" name="title"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea class="form-control" name="content"></textarea></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input class="form-control" readonly type="text" name="writer" value="${logid }"></td>
	</tr>
	<tr>
		<th>이미지</th>
		<td><input class="form-control" type="file" name="img"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		 	<input class="btn btn-primary" type="submit">
		 	<input class="btn btn-secondary" type="reset">
	    </td>
	</tr>
</table>
</form>
<%@ include file="../includes/footer.jsp"%>
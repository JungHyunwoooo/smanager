<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<style>
div.reply ul {
	list-style-type: none;
}

div.reply span {
	display: inline-block;
}
</style>



<h3>게시글 상세(board.jsp)</h3>
<form action="removeBoard.do">
	<input type="hidden" name="bno" value="${board.boardNo }"> <input
		type="hidden" name="page" value="${page }">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${board.boardNo }</td>
			<th>조회수</th>
			<td>${board.viewCnt }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${board.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${board.content }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3">${board.writer }</td>
		</tr>
		<tr>
			<th>이미지 파일</th>
			<td colspan="3"><c:choose>
					<c:when test="${empty board.image}">
			 				이미지 없음.
			 			</c:when>
					<c:otherwise>
						<img width="250px" src="images/${board.image}">
					</c:otherwise>
				</c:choose></td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td colspan="3">${board.writeDate }</td>
		</tr>
		<tr>
			<td colspan="4" align="center"><c:choose>
					<c:when test="${logid == board.writer}">
						<input class="btn btn-danger" type="submit" value="삭제화면">
						<button class="btn btn-warning" type="button">수정화면</button>
					</c:when>
					<c:otherwise>
						<input class="btn btn-danger" disabled type="submit" value="삭제화면">
						<button class="btn btn-warning" disabled type="button">수정화면</button>
					</c:otherwise>
				</c:choose></td>
		</tr>
	</table>
</form>

<!-- 댓글관련 -->
<div class="container reply">
	<!-- 등록.html -->
	<div class="header">
		<input class="col-sm-8" id="content">
		<button class="col-sm-3" id="addReply">댓글등록</button>
	</div>
	<!-- 목록.html -->
	<div class="content">
		<ul id="replyList">
			<li style="display: none;">
			<span class="col-sm-2">글번호</span> 
			<span class="col-sm-5">댓글내용</span> 
			<span class="col-sm-2">작성자</span> 
			<span class="col-sm-2"><button>삭제</button></span>
			</li>
		</ul>
	</div>
	<!-- 댓글페이징.html -->
	<div class="footer">
		<nav aria-label="...">
			<ul class="pagination" align="center">
			</ul>
		</nav>
	</div>
</div>
<script>
	const bno = "${board.boardNo }";
	const replyer = "${logid}";
	document.querySelector('form>table button.btn.btn-warning')
			.addEventListener('click', function(e) {
				location.href = 'modifyBoard.do?bno=${board.boardNo }';
			});
</script>

<!--  -<script src="js/boardService.js"></script> 
<script src = "js/boardJquery.js"></script> -->

<script src="js/jBoardService.js"></script>
<script src="js/jBoard.js"></script>
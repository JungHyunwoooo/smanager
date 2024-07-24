<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 여기 html/index.jsp -->
<h3>연습합시다...</h3>

<div id="show"></div>
<div>
 <table class="table">
   <tr>
     <th>이름</th><td><input type="text" class="form-control" id="fname"></td>
   </tr>
   <tr>
     <th>주소</th><td><input type="text" class="form-control" id="faddress"></td>
   </tr>
   <tr>
     <th>키</th><td><input type="number" class="form-control" id="height"></td>
   </tr>
   <tr>
     <td colspan="2" align="center">
       <button id="addBtn" class="btn btn-primary">등록</button>
       <button id="modifyBtn" class="btn btn-warning">수정</button>
     </td>
   </tr>
 </table>
</div>
<table class="table">
	<thead>
		<tr>
			<th>친구이름</th>
			<th>주소</th>
			<th>키</th>
			<th>삭제</th>
			<th><input type="checkbox"></th>
		</tr>
	</thead>
	<tbody id="list"></tbody>
</table>

<script src="js/array1.js"></script>
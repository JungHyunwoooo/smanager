<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 여기 html/index.jsp -->
<h3>연습합시다...</h3>

<div id="student">

	<table class="table">
		<tr>
			<th>학생번호</th>
			<td><input type="text" class="form-control" id="sno"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" class="form-control" id="sname"></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" class="form-control" id="phone"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button id="addBtn" class="btn btn-primary">등록</button>
			</td>
		</tr>
	</table>
	<hr />
	
	<table class="table">
		<tr>
		<thead>
			<tr>
				<th>학생번호</th>
				<th>학생이름</th>
				<th>연락처</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody id="stdList">
		</tbody>
	</table>

</div>

<div id="show">
	<select class="form-control" id="searchGender">
		<option value="All">선택하세요</option>
		<option value="Female">여성</option>
		<option value="Male">남성</option>
	</select>

	<table class="table">
		<thead>
			<tr>
				<th>사원번호</th>
				<th>첫이름</th>
				<th>성씨</th>
				<th>급여</th>
			</tr>
		</thead>
		<tbody id="empList">
			<!-- 사원번호 fname, lname, salary -->
		</tbody>
	</table>
</div>
<div>
	<table class="table">
		<tr>
			<th>이름</th>
			<td><input type="text" class="form-control" id="fname"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" class="form-control" id="faddress"></td>
		</tr>
		<tr>
			<th>키</th>
			<td><input type="number" class="form-control" id="height"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button id="addBtn" class="btn btn-primary">등록</button>
				<button id="modifyBtn" class="btn btn-warning">수정</button>
				<button id="delBtn" class="btn btn-danger">선택삭제</button>
			</td>
		</tr>
	</table>
</div>

<table class="table table-hover">
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

<script src="js/json4.js"></script>
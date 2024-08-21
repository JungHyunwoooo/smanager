<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exe1.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
$(document).ready(function() {
	// 이벤트 등록.
	$('#addBtn').on('click', function() {
		//요소추가.
		let btn = $('<button>삭제</button>').on('click', function() {
			console.log(this);
			$(this).parent().hide(10000);
		}); // 여기까지가 btn 영역.
		let newElem = $('<li />').html($('#userVal').val() + " ")
		                                            .append(btn);
		$('#list').append( newElem );
		//$('#show #list').append( $('<li />').html($('#userVal').val()));
	})
	
	
	// 홀수.
	$('#oddBtn').on('click', function() {
		$('#list li:eq(1)').css('background', 'red');
	});
	// 짝수.
	$('#evenBtn').on('click', function() {
		$('#list li:not(:has(span))').css('background', 'blue');
	});
  });
</script>
</head>
<body>
  입력:<input id="userVal"> <!-- val() -->
  <button id="addBtn">추가</button>
  <button id="oddBtn">3번째이후</button>
  <button id="evenBtn">span</button>
  
  
  <div id="show">
    <ul id="list">
      <li>사과1 <span>span</span><button>삭제</button></li>
      <li>사과2 <button>삭제</button></li>
      <li>사과3 <button>삭제</button></li>
      <li>사과4 <button>삭제</button></li>
      <li>사과5 <button>삭제</button></li>
      <li>사과6 <button>삭제</button></li>
    </ul>
  </div>
  
</body>
</html>
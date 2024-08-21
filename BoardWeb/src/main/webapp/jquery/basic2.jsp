<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>basic2.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
 $(document).ready(function(){
  $('button').on('click', function(){
	  //https://www.tcpschool.com/examples/images/img_monalisa.png
	  $('img').attr('src', 'https://www.tcpschool.com/examples/images/img_monalisa.png');
  });
 });
 
</script>

</head>
<body>
 <h1>속성 선택자</h1>
 <img src="https://www.tcpschool.com/examples/images/img_flower.png" alt="flower"><br>
 <button>속성을 바꾸죠!!</button>
</body>
</html>
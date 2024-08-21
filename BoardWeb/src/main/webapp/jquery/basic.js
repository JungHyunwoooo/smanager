/**
 * basic.js
 */
//document.addEventListener('DOMContentLoaded', function(){
$(document).ready(function(){
	// jquery 객체 vs. 자바스크립트 dom 객체는 다르다
	let obj = $('.show'); //이렇게 보는 방식이 jquery 객체
		obj[0].innerHTML = 'Hello';
		//obj.eq(0).html('Hello');
		obj.eq(1).html('World');
		$(obj[2]).html('Hello');
		$(obj[3]).html('World');
		//obj = document.getElementById('show');
		console.log(obj);
		
		// jquery 객체 생성.
		//사용법 : $(만들고싶은 tag)
		$('#show').append($('<button />').html('삭제')); // show id의 자식요소로 append <button>삭제</button> -> 이거를 만든 거
		$('#show').append($('<button>삭제</button>') ); // show id의 자식요소로 append <button>삭제</button> -> 이거를 만든 거
})

	
//})


		
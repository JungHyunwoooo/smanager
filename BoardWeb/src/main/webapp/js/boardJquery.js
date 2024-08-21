/**
 * boardJquery.js
 * jquery 용 Ajax 사용.
 */
$('#addReply').on('click', function(){
console.log('test');
$.ajax({
	url: 'addList.do', // 서버 url 호출.
	data: { replyer: replyer, content: content, bno: bno },// 서버에 전달한 parameter. {변수이름 : 변수값}
	dataType: 'json', // 서버로부터 전달받은 content의 타입. json은 배열이라 생각
	success: function(result) { //어떤 기능을 하기 위해 function
		let temp = makeRow()
	},
	error: function(err) {
		console.error(err);
	}
	
})
console.log('jquery start');

let page = 1;
$.ajax({
	url: 'replyList.do', // 서버 url 호출.
	data: { bno: bno, page: page },// 서버에 전달한 parameter.
	dataType: 'json', // 서버로부터 전달받은 content의 타입.
	success: function(result) {
		console.log(result);
		$.each(result, function(i, elem) {
			console.log("요기=>", i, elem)
			let elem = result.retVal;

			let temp = $('#replyList li:eq(0)').clone();
			temp.attr('data-rvo', elem.replyNo);
			temp.css('display', 'block'); // 속성(attribute) 변경.
			temp.find('span:eq(0)').html(elem.replyNo);
			temp.find('span').eq(1).html(elem.replyContent);
			temp.find('span').eq(2).html(elem.replyer);
			// 버튼생성을 새로 ..
			let btn = $('<button>삭제1</button>').on('click', deleteRow)
			temp.find('span').eq(3).html(btn);

			$('#replyList').prepend(temp);

			$('#content').val(''); //입력 .. 초기화
		})
	},
	error: function(err) {
		console.error(err);
	}
})// end of ajax

function deleteRow() {
	// 삭제하기 위한 ajax.
	let li = $(this).parent().parent();
	let rvo = li.data('rvo');
	$.ajax({
		url: 'removeReply.do',
		data: { rvo: rvo },
		dataType: 'json',
		success: function(result) {
			console.log(result)
			if (result.retCode == 'Success') {
				li.remove();
			} else {
				alert('처리중 예외 발생.')
			}
		},
		error: function(err) {
			console.log(err)

		}
	});
} // end of deleteRow

function makeRow(elem = {}) {
	let temp = $('#replyList li:eq(0)').clone();
	temp.attr('data-rvo', elem.replyNo);
	temp.css('display', 'block'); // 속성(attribute) 변경.
	temp.find('span:eq(0)').html(elem.replyNo);
	temp.find('span').eq(1).html(elem.replyContent);
	temp.find('span').eq(2).html(elem.replyer);
	// 버튼생성을 새로 ..
	let btn = $('<button>삭제1</button>').on('click', deleteRow)
	temp.find('span').eq(3).html(btn);
	
	return temp;
} // end of makeRow



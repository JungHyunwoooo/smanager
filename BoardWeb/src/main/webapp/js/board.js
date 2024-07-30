/**
 * board.js
 */
console.log('board.js' + bno);
let page = 1; // 아래쪽에서 댓글의 페이지를 지정.

// 댓글등록 버튼에 클릭 이벤트를 등록.
document.querySelector("#addReply").addEventListener('click', function(e) {

	let content = document.querySelector('#content').value;
	if (!replyer || !content) {
		alert('필수입력항목을 확인하세요!!')
		return;
	}
	let parm = { bno, content, replyer };

	svc.addReply(parm, function() {
		//등록완료 => 화면에 등록된 글 추가하는.
		let result = JSON.parse(this.responseText);
		console.log(result);
		if (result.retCode == 'Success') {
			alert("성공");
			showPage();
			//replyList.appendChild(makeRow(result.retVal));
		}
	});

});

// 댓글목록 출력.
function showPage() {
	svc.replyList({ bno, page }, function(e) {
		// 기존 목록을 지우기.
		replyList.querySelectorAll('li').forEach((li, idx) => {
			if (idx != 0) {
				li.remove();
			}
		})
		//페이지 로드하면서 목록을 출력
		let result = JSON.parse(this.response);
		result.forEach(reply => {
			replyList.appendChild(makeRow(reply));
		});
		//실제 데이터 ... 출력 , 페이징 만들어주는 부분
		svc.pagingCount(bno, createPageList);
	});
}

showPage();

//reply => row 생성.
function makeRow(reply = {}) {
	let cloned = document.querySelector('div.reply>div.content li').cloneNode(true);
	cloned.setAttribute('data-rno', reply.replyNo);
	cloned.style.display = 'block'; // <li style="display: block;"></li> 에 스타일을 주겠다는 의미
	cloned.querySelector('span:nth-of-type(1)').innerText = reply.replyNo;
	cloned.querySelector('span:nth-of-type(2)').innerText = reply.replyContent;
	cloned.querySelector('span:nth-of-type(3)').innerText = reply.replyer;
	cloned.querySelector('button').addEventListener('click', deleteReplyFnc);
	return cloned;
}

// 댓글 삭제 이벤트 핸들러.
function deleteReplyFnc(e) {
	let rno = e.target.parentElement.parentElement.dataset.rno;
	svc.removeReply(rno, function(e) {
		let result = JSON.parse(this.response);
		if (result.retCode == 'Success') {
			alert('삭제 성공!!!');
			//document.querySelector('li[data-rno="' + rno + '"]').remove();
			showPage();	
		} else {
			alert('삭제 실패!!!');
		}
	})
}



// 페이지 a 태그 생성해주는 부분.
function createPageList(event) {
	console.log(this.responseText); //
	let result = JSON.parse(this.responseText);
	let totalCnt = result.totalCount;
	let startPage, endPage; // 현재 페이지를 기준으로 계산한 첫페이지 번호 ~ 마지막 페이지 번호.
	let next, prev; // 이전, 이후를 체크하는 변수.
	let realEnd = Math.ceil(totalCnt / 5); // 20page가 마지막

	endPage = Math.ceil(page / 10) * 10;
	startPage = endPage - 9;
	endPage = endPage > realEnd ? realEnd : endPage;

	prev = startPage > 1; // 이전 10개의 페이지의 존재를 구분.
	next = endPage < realEnd ? true : false;

	//기존 html 지우기
	document.querySelector('ul.pagination').innerHTML = '';

	// 이전 10페이 존재 여부.
	let li = document.createElement('li');
	li.className = 'page-item';
	// 이전 페이지 있는지 존재 여부.
	if (prev) {
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page', startPage - 1);
		aTag.className = 'page-link';
		aTag.href = '#';
		aTag.innerHTML = 'Previous';
		li.appendChild(aTag);
	} else {
		li.classList.add('disabled');
		let span = document.createElement('span');
		span.className = 'page-link';
		span.innerHTML = 'Previous';
		li.appendChild(span);
	}
	document.querySelector('ul.pagination').appendChild(li);

	// 10개 출력. <li class="page-item"><a class="page-link" href="#">1</a></li>
	for (let p = startPage; p <= endPage; p++) {
		let li = document.createElement('li');
		li.className = 'page-item'; // class='page-item active'
		if (page == p) {
			li.classList.add('active');
			let span = document.createElement('span');
			span.className = 'page-link';
			span.innerHTML = p;
			li.appendChild(span);

		} else {
			let aTag = document.createElement('a');
			aTag.setAttribute('data-page', p);
			aTag.className = 'page-link';
			aTag.href = '#';
			aTag.innerHTML = p;
			li.appendChild(aTag);
		}

		document.querySelector('ul.pagination').appendChild(li);
	} // end of for.

	// 이후 10페이지가 있는지 여부.
	li = document.createElement('li');
	li.className = 'page-item';
	// 이전 페이지 있는지 존재 여부.
	if (next) {
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page', endPage + 1);
		aTag.className = 'page-link';
		aTag.href = '#';
		aTag.innerHTML = 'Next';
		li.appendChild(aTag);
	} else {
		li.classList.add('disabled'); // li태그의 스타일을 비활성화된 것처럼 보여주기 위해.
		let span = document.createElement('span');
		span.className = 'page-link';
		span.innerHTML = 'Next';
		li.appendChild(span);
	}
	document.querySelector('ul.pagination').appendChild(li);

	// a태그의 이벤트 등록.
	pageMove();
}// end of createPageList.


// paging영역의 a 태그를 클릭하면... 2 3 4 페이지 넘어가는 . . .
function pageMove() {
	document.querySelectorAll('div.reply ul.pagination a')//
		.forEach(item => {
			// a태그에 클릭이벤트 등록.
			item.addEventListener('click', function(e) {
				page = item.dataset.page; // Previous, Next 값을 가지고 있어 이동이 불가.
				// service에서 목록을 출력하는 메소드 호출.
				svc.replyList({ bno, page }, function() {
					//기존 목록을 삭제.
					showPage();
				}); // end of svc.replyList.
			}) // end of click event.
		});

} // end of pageMove
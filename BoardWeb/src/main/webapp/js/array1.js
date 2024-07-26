/**
 *  array1.js
 */

// 선택삭제 이벤트 등록
document.getElementById('delBtn').addEventListener('click', delBtn);
//delBtn 이벤트핸들러.
function delBtn(e) {
	document.querySelectorAll('div.container-fluid>table>tbody input[type="checkbox"]:checked')
		.forEach(function(item) {
			item.parentElement.parentElement.remove();
		})
}

// thead쪽에 있는 체크박스 이벤트 등록.
document.querySelector('div.container-fluid>table>thead input[type="checkbox"]') // > 자식의 영역지정, '공백'은 테이블의 하위를 의미 => 최상단 체크박스
	.addEventListener('change', changeFnc);

function changeFnc(e) { // 이벤트 핸들러.
	console.log(e.target.checked);
	console.log(document.querySelectorAll('div.container-fluid>table>tbody input[type="checkbox"]:checked').length);
	// 찾으려고 하는 대상 체크박스를 화면에서 가져와야 함.
	document.querySelectorAll('div.container-fluid>table>tbody input[type="checkbox"]') //테이블을 기준으로 티바디에 있는 인풋태그를 가져온다는 의미
		.forEach(function(item) {
			item.checked = e.target.checked;
		})
} // end of changeFnc(e).

// 수정버튼
document.getElementById('modifyBtn').addEventListener('click', modifyBtnFnc);

//modifyBtnFnc 이벤트핸들러.
function modifyBtnFnc(e) {

	// 화면상에 있는 tr을 대상으로 변경을 해야함
	document.querySelectorAll('#list tr').forEach(function(tr) {
		// tr의 첫 번째 자식요소의 innerHTML : 이름. 비교 fname의 value가 같을 때
		// faddress, height의 value를 tr의 두 번째, 세 번째 자식요소의 innerHTML에 대입.
		if (tr.children[0].innerHTML == document.querySelector('#fname').value) {
			tr.children[1].innerHTML = document.querySelector('#faddress').value;
			tr.children[2].innerHTML = document.querySelector('#height').value;
		}
	});
}; // end of modifyBtnFnc

// '등록' 버튼에 클릭 이벤트를 추가하는 법
document.getElementById('addBtn').addEventListener('click', addBtnFnc);

// addBtnFnc 이벤트핸들러.
function addBtnFnc(e) {
	let name = document.getElementById('fname').value;
	let address = document.getElementById('faddress').value;
	let height = document.getElementById('height').value;

	if (!name || !address || !height) {
		alert('값을 입력하세요.');
		return;
	}

	let friend = { name, address, height }

	console.log(name);

	// tr만드는 부분.
	let tr = makeTr(friend);
	list.appendChild(tr);

	alert('OK');

	fname.value = '';
	faddress.value = '';
	document.getElementById('height').value = '';
};


const friends = [
	{ name: "홍길동", address: "대구 100번지", height: 170 },
	{ name: "이몽룡", address: "대구 200번지", height: 175 },
	{ name: "변사또", address: "대구 300번지", height: 180 },
]

makeList();
function makeList() {
	//<tr><td>값1</td><td>값2</td><td>값3</td><td><button>삭제</button></td></tr>
	friends.forEach(function(friend) {
		let tr = makeTr(friend);
		document.getElementById('list').appendChild(tr);
	});

}

function detailCallback(e) {
	e.stopPropagation();
	console.log(e.target.parentElement);
	let tr = e.target.parentElement; // 이벤트를 대상으로 tr영역을 찾아야 한다!
	// this : 1)함수영역에서 window. 2)이벤트 대상. 3)객체에서는 객체를 가르킴.
	tr = this;
	document.getElementById('fname').value = tr.children[0].innerHTML; //수정을 목적으로 대부분 사용
	document.getElementById('faddress').value = tr.children[1].innerHTML;
	document.getElementById('height').value = tr.children[2].innerHTML;

} // end of detailCallback.



//friend => tr 생성해주는 함수 만들기.
function makeTr(friend = { name: 'Hong', address: '대구', height: 170 }) {

	// tr만드는 부분.
	let tr = document.createElement('tr');
	tr.addEventListener('click', detailCallback, false); //true를 넣으면 하위에서 상위로 *<버블링?? 캡쳐링??>
	//tr.addEventListener('mouseover', detailCallback); //마우스를 갖다댈 때마다 바뀌는 것


	for (let prop in friend) {
		let td = document.createElement('td');
		td.innerHTML = friend[prop];
		tr.appendChild(td);
	}
	// 삭제버튼
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.setAttribute('class', 'btn btn-danger'); // <button class="btn btn-danger">삭제</button>
	btn.addEventListener('click', function(e) { //addEventListner = onClick과 비슷함, e는 전달되는 이벤트
		console.log(e);
		e.stopPropagation(); // 버튼의 click 이벤트가 button에서 상위로 >td > tr > table ... 영향을 주는 것을 차단하겠다는 것 <하위에서->상위로>
		e.target.parentElement.parentElement.remove();
	}, true);
	btn.innerHTML = '삭제';
	td.appendChild(btn);
	tr.appendChild(td);

	// 체크박스 완성된 html은 --> <td><input type="checkbox"></td>의 상위요소 tr에 붙인다.
	td = document.createElement('td');
	let inp = document.createElement('input');
	inp.setAttribute('type', 'checkbox');
	inp.addEventListener('click', function(e) { e.stopPropagation(); })

	//체크박스에 이벤트등록.
	inp.addEventListener('change', function(e) {
		// thead의 체크박스 변경하기.
		let allCnt = document.querySelectorAll('div.container-fluid>table>tbody input[type="checkbox"]:checked');
		let chkCnt = document.querySelectorAll('div.container-fluid>table>tbody input[type="checkbox"]');
		let theadCheck = document.querySelector('div.container-fluid>table>thead input[type="checkbox"]');
		if (allCnt.length == chkCnt.length) {
			theadCheck.checked = true;
		} else {
			theadCheck.checked = false;
		}
	});

	td.appendChild(inp);
	tr.appendChild(td);

	return tr;
}
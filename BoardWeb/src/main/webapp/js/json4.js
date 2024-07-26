/**
 * json4.js
 */
document.querySelector('#show').remove();
document.querySelector('div.container-fluid>div:nth-of-type(2)').remove();
document.querySelector('div.container-fluid>table').remove();
//등록이벤트 만들기
document.querySelector("#addBtn").addEventListener('click', addRowFnc);

function addRowFnc(e) {
	let sno = document.querySelector('#sno').value;
	let sname = document.querySelector('#sname').value;
	let phone = document.querySelector('#phone').value;
	
	let addHtp = new XMLHttpRequest();
	addHtp.open('get', 'addStudent.do?sno='+sno+'&sname='+sname+'&phone='+phone);
	addHtp.send();
	addHtp.onload = function(e) {
		console.log(addHtp.response);
		let result = JSON.parse(addHtp.response);
		if(result.retCode == 'Success') {
			let tr = makeRow(result.retVal);
			document.getElementById('stdList').appendChild(tr);
		}
	}
}



// Asynchronous Javascript And Xml (AJAX)
let student;
let xhtp = new XMLHttpRequest();
xhtp.open('get', 'studentJson.do'); // 서버상의 특정 페이지를 요청하는 메소드
xhtp.send();
xhtp.onload = function(e) {
	console.log(xhtp.response);
	let json = xhtp.response;
	students = JSON.parse(json);
	initList();
}
// 화면에 목록출력.
function initList() {
	let target = document.getElementById('stdList');
	target.innerHTML = ''; //원래 화면을 비워주겠습니다~~
	students.forEach(emp => {
		target.appendChild(makeRow(emp));
	});
}// end of initList


// 사원정보 => row 생성.
function makeRow(emp = {}) {
	let fields = ['stdNo', 'stdName', 'stdPhone'];
	let tr = document.createElement('tr');
	tr.setAttribute('data-sno', emp.stdNo);
	fields.forEach(field => {
		let td = document.createElement('td');
		td.innerHTML = emp[field];
		tr.appendChild(td);
	})

	// 삭제 및 삭제버튼
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.addEventListener('click', deleteRowFnc);
	btn.setAttribute('class', 'btn btn-danger');
	btn.innerHTML = '삭제';
	td.appendChild(btn);
	tr.appendChild(td);

	return tr;
}// end of makeRow(emp = {})

//삭제이벤트 핸들러.
function deleteRowFnc(e) {
	console.log(e.target.parentElement.parentElement.firstChild.innerText);
	let tr = e.target.parentElement.parentElement;
	let sno = e.target.parentElement.parentElement.firstChild.innerText;
	sno = e.target.parentElement.parentElement.dataset.sno;     //getattribute("data-sno")
	const delHtp = new XMLHttpRequest();
	delHtp.open('get', 'removeStudent.do?sno=' + sno);
	delHtp.send();
	delHtp.onload = function(e) {
		let result = JSON.parse(delHtp.responseText); // 성공적이면 {"retCode": "Success"}가 있을 거임 
		if (result.retCode == 'Success') {
			alert("성공!");
			tr.remove();
		} else if (result.retCode == 'Fail') {
			alert("관리자에게 문의하세요!");
		}
	}
} // end of deleteRowFnc(e)
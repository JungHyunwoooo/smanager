/**
 * json3.js
 */

document.querySelector('div.container-fluid>div:nth-of-type(2)').remove();
document.querySelector('div.container-fluid>table').remove();

// Asynchronous Javascript And Xml (AJAX)
let employees;
let xhtp = new XMLHttpRequest();
xhtp.open('get', 'data/MOCK_DATA.json'); // 서버상의 특정 페이지를 요청하는 메소드
xhtp.send();
xhtp.onload = function(e) {
	console.log(xhtp.response);
	let json = xhtp.response;
	employees = JSON.parse(json);
	console.log(employees);
	initList();
}


document.querySelector('#searchGender').addEventListener('change', function(e) {
	initList();
})

function initList() {
	let target = document.getElementById('empList');
	target.innerHTML = ''; //원래 화면을 비워주겠습니다~~
	let selValue = document.querySelector('#searchGender').value;
	employees.forEach(emp => {
		if (selValue == 'All' || emp.gender == selValue ) {
			target.appendChild(makeRow(emp));
	}
 });
}


// 사원정보 => row 생성.
function makeRow(emp = {}) {
	let fields = ['id', 'first_name', 'last_name', 'salary'];
	let tr = document.createElement('tr');
	fields.forEach(field => {
	 let td = document.createElement('td');
	 td.innerHTML = emp[field];
	 tr.appendChild(td);
	})
	return tr;
}



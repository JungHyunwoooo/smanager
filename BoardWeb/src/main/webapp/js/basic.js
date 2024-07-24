/**
 * basic.js
 */
console.log("basic.js")

let name = "정현우";
let address = "대구 100번지";
let age = 32;

//const myInfo = { name, address, age } // 속성과 밸류값이 같으면 하나로 표현할 수 있다.
const myInfoAry = [name, address, age];

// createElement('span') => <span></span>
// innerText/innerHTML = 값.
// 부모.appendChild(자식) => <부모><자식/></부모>	


  // for .. in ..
/*
  for(let prop in myInfo){
	let span = document.createElement('span');
  	span.innerHTML = myInfo[prop] + ' ';
    document.getElementById('show').appendChild(span);
  
  	console.log(span);
  	  
  } //end of for

}// end of function
*/
makeDom();	
function makeDom() {
  //for(let prop of myInfoAry){ //배열이면 prop of
  myInfoAry.forEach(function(prop) {
	let span = document.createElement('span');
  	span.innerHTML = prop + ' ';
    document.getElementById('show').appendChild(span);
  
  	console.log(span);
  	  
  }) //end of for

}// end of function


console.log(`이름은 ${name}이고 주소는 ${address} 입니다. ${age > 20 ? '성년' : '미성년'} 입니다.`);
name = 20;
console.log(typeof address);

const obj = {name: "정현우",
			 age : 32,
			 myInfo : function(){
				 return this.name + ', ' + this.age;
			  }
			 }

console.log(`이름은 ${obj.name}, 나이는 ${obj['age']}`);
console.log(obj.myInfo());

for (let prop in obj){
	console.log(`속성은 ${prop}이고, 값은 ${obj[prop]}`);
}

//배열
const ary = [1, 2, 3];
ary.push(4); // 제일 뒤에 추가
ary.unshift(5); // 제일 앞에 추가

for (let num of ary){
	console.log(`값은 ${num}입니다.`);
}

//많이 사용하는 반복문
ary.forEach(function(item, idx, ary) {
	if (idx == 0 || idx == ary.length -1){
		console.log(idx); // 값
	}
/*
	console.log('hhhh' + item); // 값
	console.log('hhhh' + idx); // 인덱스값
	console.log('hhhh' + ary); // 배열전체
*/
});



friends.forEach(function(friend) {
	// friend 정보를 한 건씩 반복해서 보여준다.
	for (let prop in friend) {
		console.log(prop + ', ' + friend[prop]);
	}
	console.log('-----------------------');
});
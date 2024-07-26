/**
 * json1.js
 */
document.querySelector('div.container-fluid>div:nth-of-type(2)').remove();
document.querySelector('div.container-fluid>table').remove();

// json 문자열
// 자바스크립트 객체 {속성: 값, 속성:값,...} new Object();
let obj = {name: '정현우', age: 20, pets: [
  { name: '야옹이', age: 3 },
  { name: '멍멍이', age: 2 }
 ]
}; //-> {"name":"정현우", "age":20}
let json = JSON.stringify(obj);
console.log(json);

obj = JSON.parse(json);
console.log(obj);

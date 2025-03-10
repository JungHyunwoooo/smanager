<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	margin: 0;
	min-width: 250px;
}

/* Include the padding and border in an element's total width and height */
* {
	box-sizing: border-box;
}

/* Remove margins and padding from the list */
ul {
	margin: 0;
	padding: 0;
}

/* Style the list items */
ul li {
	cursor: pointer;
	position: relative;
	padding: 12px 8px 12px 40px;
	list-style-type: none;
	background: #eee;
	font-size: 18px;
	transition: 0.2s;
	/* make the list items unselectable */
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

/* Set all odd list items to a different color (zebra-stripes) */
ul li:nth-child(odd) {
	background: #f9f9f9;
}

/* Darker background-color on hover */
ul li:hover {
	background: #ddd;
}

/* When clicked on, add a background color and strike out text */
ul li.checked {
	background: #888;
	color: #fff;
	text-decoration: line-through;
}

/* Add a "checked" mark when clicked on */
ul li.checked::before {
	content: '';
	position: absolute;
	border-color: #fff;
	border-style: solid;
	border-width: 0 2px 2px 0;
	top: 10px;
	left: 16px;
	transform: rotate(45deg);
	height: 15px;
	width: 7px;
}

/* Style the close button */
.close {
	position: absolute;
	right: 0;
	top: 0;
	padding: 12px 16px 12px 16px;
}

.close:hover {
	background-color: #f44336;
	color: white;
}

/* Style the header */
.header {
	background-color: #f44336;
	padding: 30px 40px;
	color: white;
	text-align: center;
}

/* Clear floats after the header */
.header:after {
	content: "";
	display: table;
	clear: both;
}

/* Style the input */
input {
	margin: 0;
	border: none;
	border-radius: 0;
	width: 75%;
	padding: 10px;
	float: left;
	font-size: 16px;
}

/* Style the "Add" button */
.addBtn {
	padding: 10px;
	width: 25%;
	background: #d9d9d9;
	color: #555;
	float: left;
	text-align: center;
	font-size: 16px;
	cursor: pointer;
	transition: 0.3s;
	border-radius: 0;
}

.addBtn:hover {
	background-color: #bbb;
}
</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

</head>
<body>

	<div id="myDIV" class="header">
		<h2 style="margin: 5px">My To Do List</h2>
		<input type="text" id="myInput" placeholder="Title..."> <span
			onclick="newElement()" class="addBtn">Add</span>
	</div>

	<ul id="myUL">
		<li>Hit the gym</li>
		<li class="checked">Pay bills</li>
		<li>Meet George</li>
		<li>Buy eggs</li>
		<li>Read a book</li>
		<li>Organize office</li>
	</ul>

	<script>
		// Create a "close" button and append it to each list item
		var myNodelist = document.getElementsByTagName("LI");
		var i;
		for (i = 0; i < myNodelist.length; i++) {
			var span = document.createElement("SPAN");
			var txt = document.createTextNode("\u00D7");
			span.className = "close";
			span.appendChild(txt);
			myNodelist[i].appendChild(span); // <li> ....X </li>
		}

		// Click on a close button to hide the current list item
		/*var close = document.getElementsByClassName("close");
		var i;
		for (i = 0; i < close.length; i++) {
			close[i].onclick = function() {
				var div = this.parentElement;
				div.style.display = "none";
			}
		}*/
		
		//Jquery
		$('li').append($('<span/>').text('\u00D7')
                                   .addClass('close')
                                   //.on('click', e => {
              	                   //$(e.target).parent().css('display', 'none');
                                   // })
                                    );

		// Add a "checked" symbol when clicking on a list item
		/*var list = document.querySelector('ul');
		list.addEventListener('click', function(ev) {
			console.log(ev.target);
			if (ev.target.tagName === 'LI') {
				ev.target.classList.toggle('checked'); // toggle : 없으면 추가, 있으면 빼는 기능을 함.
			}
		}, false); */
		
		//Jquery
		$('ul').on('click', 'li', function() {
			$(this).toggleClass('checked');
		})
		$('ul').on('click', 'span.close', function(e) {
			e.stopPropagation(); // -> 이벤트가 상위에 영향을 미치는 것을 차단하는 기능
		  $(this).parent().hide(500);//css('display', 'none');
		})
		//document.querySelectorAll('li').forEach(list => {
		//  list.addEventListener('click', function(ev) {
		//    ev.target.classList.toggle('checked');
			//});
		//})

		// Create a new list item when clicking on the "Add" button
		function newElement() {
			var inputValue = $('#myInput').val();
			
			if (inputValue === '') {
				alert("뭐시든 쓰랑께!");
				return;
			}
			let span = $('<span />').text('\u00D7').addClass('close');
			/*var li = document.createElement("li");
			var t = document.createTextNode(inputValue);
			li.appendChild(t);
				document.getElementById("myUL").appendChild(li);*/
				$('#myUL').append($('<li />').text(inputValue) //
						                     .append(span) //li 태그생성.
						         );
			//document.getElementById("myInput").value = "";
			$('#myInput').val("");

			/*var span = document.createElement("SPAN");
			var txt = document.createTextNode("\u00D7");
			span.className = "close";
			span.appendChild(txt);
			li.appendChild(span);*/

	
			/*for (i = 0; i < close.length; i++) {
				close[i].onclick = function() {
					var div = this.parentElement;
					div.style.display = "none";
				}
			}*/
			
			
		}
	</script>

</body>
</html>


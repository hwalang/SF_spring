<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Main</title>
</head>
<body>
	<h1>Student Main</h1>
	<button id="btnStudentDetail" >Student 상세</button>
	<button id="btnStudentList" >Student 목록</button>
	<button id="btnStudentInsert" >Student 등록</button>
	<button id="btnStudentUpdate" >Student 수정</button>
	<button id="btnStudentDelete" >Student 삭제</button>
	
	<button id="btnStudentInsertJSON" >JSON 등록</button>
	
	<!-- 특정 studentId의 사원정보를 또다른 JSP에 보이도록 페이지 요청 -->
	<button id="btnStudentDetailJsp" >Student 상세 jsp</button>
	<button id="btnStudentListJsp" >Student 목록 Jsp</button>
</body>

<script>
window.onload = function() {
	
	// GET 방식
	document.querySelector("#btnStudentDetail").onclick = async function() {
		// 비동기 요청
		try {
			let response = await fetch('/mybatis/studentDetail/1');
			let data = await response.json();
			console.log(data);
		} catch (error) {
			console.error(error);
		}
	}
	
	document.querySelector("#btnStudentList").onclick = async function() {
		try {
			let response = await fetch('/mybatis/studentList');
			let data = await response.json();
			console.log(data);
		} catch (error) {
			console.error(error);
		}
	}
	
	document.querySelector("#btnStudentDelete").onclick = async function() {
		
		try {
			let response = await fetch('/mybatis/studentDelete/1');
			let data = await response.json();
			console.log(data);
		} catch (error) {
			console.error(error);
		}
	}
	
	// POST 방식
	document.querySelector("#btnStudentInsert").onclick = async function() {
		
		// post로 전송할 데이터( json 형식 데이터 ) 준비
		// post 전송: www-url encoded
		let urlParams = new URLSearchParams({
			  "studentNm": "kdh",
			  "email": "kdh@n.com",
			  "phone": "010-1234-5678"
		});
		
		let fetchOptions = {
			method: 'POST',
			body: urlParams
		}
		
		try {
			let response = await fetch('/mybatis/studentInsert', fetchOptions);
			let data = await response.json();
			console.log(data);
		} catch (error) {
			console.error(error);
		}
	}
	
	
	let studentUpdateData = {
			"studentId": 2,
			"studentNm": "kdh",
			 "email": "kdh@n.com",
			 "phone": "010-1234-567811"
	}
	document.querySelector("#btnStudentUpdate").onclick = async function() {
		
		let fetchOptions = {
			method: 'POST',
			body: new URLSearchParams(studentUpdateData)
		}
		
		try {
			let response = await fetch('/mybatis/studentUpdate', fetchOptions);
			let data = await response.json();
			console.log(data);
		} catch (error) {
			console.error(error);
		}
	}
	
	// js object -> json object: JSON.stringify()
	let studentInsertData = {
			"studentNm": "kdh2",
			 "email": "kdh2@n.com",
			 "phone": "010-1234-5678"
	}
	document.querySelector("#btnStudentInsertJSON").onclick = async function() {
		
		let fetchOptions = {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(studentInsertData)
		}
		
		try {
			let response = await fetch('/mybatis/studentInsertJSON', fetchOptions);
			let data = await response.json();
			console.log(data);
		} catch (error) {
			console.error(error);
		}
	}
	
	// 페이지 요청( 동기 )
	document.querySelector("#btnStudentDetailJsp").onclick = function() {
		window.location.href="/mybatis/studentDetailJsp/2";
	}
	document.querySelector("#btnStudentListJsp").onclick = function() {
		window.location.href="/mybatis/studentListJsp";
	}
	
	
}
</script>

</html>
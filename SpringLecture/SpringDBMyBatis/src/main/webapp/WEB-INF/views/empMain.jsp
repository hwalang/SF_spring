<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Emp Main</title>
</head>
<body>
	<h1>Emp Main</h1>
	<button id="btnEmpDetail" >Emp 상세</button>
	<button id="btnEmpList" >Emp 목록</button>
	<button id="btnEmpInsert" >Emp 등록</button>
	<button id="btnEmpUpdate" >Emp 수정</button>
	<button id="btnEmpDelete" >Emp 삭제</button>
	
	<button id="btnEmpInsertJSON" >JSON 등록</button>
	
	<!-- 특정 employeeId의 사원정보를 또다른 JSP에 보이도록 페이지 요청 -->
	<button id="btnEmpDetailJsp" >Emp 상세 jsp</button>
	<button id="btnEmpListJsp" >Emp 목록 Jsp</button>
	
	<h1>MyBatis 추가 연습</h1>
	<button id="btnEmpListLike" >Emp 목록 Like 검색</button>
	<button id="btnEmpListResultMap" >Emp 목록 ResultMap</button>
	
	
</body>

<script>
window.onload = function() {
	
	// GET 방식
	document.querySelector("#btnEmpDetail").onclick = async function() {
		// 비동기 요청
		try {
			let response = await fetch('/mybatis/empDetail/2');
			let data = await response.json();
			console.log(data);
		} catch (error) {
			console.error(error);
		}
	}
	
	document.querySelector("#btnEmpList").onclick = async function() {
		try {
			let response = await fetch('/mybatis/empList');
			let data = await response.json();
			console.log(data);
		} catch (error) {
			console.error(error);
		}
	}
	
	document.querySelector("#btnEmpDelete").onclick = async function() {
		
		try {
			let response = await fetch('/mybatis/empDelete/4');
			let data = await response.json();
			console.log(data);
		} catch (error) {
			console.error(error);
		}
	}
	
	// POST 방식
	document.querySelector("#btnEmpInsert").onclick = async function() {
		
		// post로 전송할 데이터( json 형식 데이터 ) 준비
		// post 전송: www-url encoded
		let urlParams = new URLSearchParams({
			employeeId: 4,
			firstName: '길동',
			lastName: '사',
			email: 'sa@gil.com',
			hireDate: '2023-04-04'
		});
		
		let fetchOptions = {
			method: 'POST',
			body: urlParams
		}
		
		try {
			let response = await fetch('/mybatis/empInsert', fetchOptions);
			let data = await response.json();
			console.log(data);
		} catch (error) {
			console.error(error);
		}
	}
	
	
	let empUpdateData = {
			employeeId: 4,
			firstName: '길동2',
			lastName: '사2',
			email: 'sa2@gil.com',
			hireDate: '2023-04-06'
	}
	document.querySelector("#btnEmpUpdate").onclick = async function() {
		
		let fetchOptions = {
			method: 'POST',
			body: new URLSearchParams(empUpdateData)
		}
		
		try {
			let response = await fetch('/mybatis/empUpdate', fetchOptions);
			let data = await response.json();
			console.log(data);
		} catch (error) {
			console.error(error);
		}
	}
	
	// js object -> json object: JSON.stringify()
	let empInsertData = {
			employeeId: 4,
			firstName: '길동',
			lastName: '사',
			email: 'sa@gil.com',
			hireDate: '2023-04-04'
	}
	document.querySelector("#btnEmpInsertJSON").onclick = async function() {
		
		let fetchOptions = {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(empInsertData)
		}
		
		try {
			let response = await fetch('/mybatis/empInsertJSON', fetchOptions);
			let data = await response.json();
			console.log(data);
		} catch (error) {
			console.error(error);
		}
	}
	
	// 페이지 요청( 동기 )
	document.querySelector("#btnEmpDetailJsp").onclick = function() {
		window.location.href="/mybatis/empDetailJsp/2";
	}
	document.querySelector("#btnEmpListJsp").onclick = function() {
		window.location.href="/mybatis/empListJsp";
	}
	
	
	document.querySelector("#btnEmpListLike").onclick = async function() {
		try {
			let searchWord = '동';
			let url = '/mybatis/empListLike';
			let urlParams = `?searchWord=\${searchWord}`;	// \를 줘야 JSP에서 EL문법이 아니라 JSP 문법임을 알 수 있다.
			
			let response = await fetch(url + urlParams);
			let data = await response.json();
			console.log(data);
		} catch (error) {
			console.error(error);
		}
	}
	
	document.querySelector("#btnEmpListResultMap").onclick = async function() {
		try {
			let searchWord = '동';
			let url = '/mybatis/empListResultMap';
			let urlParams = `?searchWord=\${searchWord}`;	// \를 줘야 JSP에서 EL문법이 아니라 JSP 문법임을 알 수 있다.
			
			let response = await fetch(url + urlParams);
			let data = await response.json();
			console.log(data);
		} catch (error) {
			console.error(error);
		}
	}
	
}
</script>

</html>
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
</body>

<script>
window.onload = function() {
	
	// GET 방식
	document.querySelector("#btnEmpDetail").onclick = async function() {
		// 비동기 요청
		try {
			let response = await fetch('/mydb/empDetail/2');
			let data = await response.json();
			console.log(data);
		} catch (error) {
			console.error(error);
		}
	}
	
	document.querySelector("#btnEmpList").onclick = async function() {
		try {
			let response = await fetch('/mydb/empList');
			let data = await response.json();
			console.log(data);
		} catch (error) {
			console.error(error);
		}
	}
	
	document.querySelector("#btnEmpDelete").onclick = async function() {
		
		try {
			let response = await fetch('/mydb/empDelete/4');
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
			let response = await fetch('/mydb/empInsert', fetchOptions);
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
			let response = await fetch('/mydb/empUpdate', fetchOptions);
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
			let response = await fetch('/mydb/empInsertJSON', fetchOptions);
			let data = await response.json();
			console.log(data);
		} catch (error) {
			console.error(error);
		}
	}
	
	// 페이지 요청( 동기 )
	document.querySelector("#btnEmpDetailJsp").onclick = function() {
		window.location.href="/mydb/empDetailJsp/2";
	}
	document.querySelector("#btnEmpListJsp").onclick = function() {
		window.location.href="/mydb/empListJsp";
	}
	
	
}
</script>

</html>
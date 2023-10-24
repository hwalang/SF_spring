<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
</head>
<body>
	<h1>My Page</h1>
	<button id="btnUserDetail">사용자 정보</button>
	
	<button id="btnUserRegisttJSON">사용자 정보</button>
	
</body>

<script>
window.onload = function() {
	document.querySelector("#btnUserDetail").onclick = async function() {
		
		let urlParams = new URLSearchParams({
			  userEmail: 'kdh@n.com'
		});
		
		let fetchOptions = {
			method: 'POST',
			body: urlParams
		}
		
		try {
			let response = await fetch('/enjoytrip/user/detail', fetchOptions);
			let data = await response.json();
			console.log(data);
		} catch (error) {
			console.error(error);
		}
	}
	
	
	let userDataJSON = {
		userId: 3,
		userEmail: 'kdh3@n.com',
		userPwd: '123',
		userNm: 'kss'
	}
	document.querySelector("#btnUserRegistJSON").onclick = async function() {
		
		// json: POST, headers, JSON.stringify()
		let fetchOptions = {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			}},
			body: JSON.stringify(userDataJSON)
		}
		
		try {
			let response = await fetch('/enjoytrip/user/registJSON', fetchOptions);
			let data = await response.json();
			console.log(data);
		} catch (error) {
			console.error(error);
		}
	}
}
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<h1>Login Page</h1>
	<button id="btnUserLogin">Login</button>
	
</body>

<script>
window.onload = function() {
	document.querySelector("#btnUserLogin").onclick = async function() {
		
		let urlParams = new URLSearchParams({
			  userEmail: 'kdh@n.com',
			  userPwd: '1234'
		});
		
		let fetchOptions = {
			method: 'POST',
			body: urlParams
		}
		
		try {
			let response = await fetch('/enjoytrip/user/login', fetchOptions);
			let data = await response.json();
			console.log(data);
		} catch (error) {
			console.error(error);
		}
	}
	
}
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
UserDto userDto = (UserDto) session.getAttribute("userDto");
%>
<!DOCTYPE html>
<html lang="en">

<head>

<%@ include file="include/header.jsp"%>

</head>

<%@ include file="include/navbar.jsp"%>

<div class="hero hero-inner">
	<div class="container">
		<div class="row align-items-center">
			<div class="col-lg-6 mx-auto text-center">
				<div class="intro-wrap">
					<h1 class="mb-0">My Info</h1>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="untree_co-section">
	<div class="container justify-content-center">
		<div class="container row-6 user">
			<div class="text-left">
				<h1 class="h2 text-gray-900 mb-4">My Info</h1>
			</div>
			<div class="row form-group">
				<div class="col-sm-3">
					<h4>이름 :</h4>
				</div>
				<div class="col-sm">
					<input type="text" class="form-control form-control-user"
						id="inputName" value="<%= userDto.getUserName()%>" />
				</div>
			</div>
			<div class="row form-group">
				<div class="col-sm-3">
					<h4>아이디 (E-mail) :</h4>
				</div>
				<!-- <input type="email" class="form-control form-control-user col-sm"
					id="userEmail" placeholder="abcde123@gmail.com" /> -->
				<div class="col-sm">
					<h4><%=userDto.getUserId()%></h4>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-sm-3">
					<h4>비밀번호 :</h4>
				</div>

				<div class="col-sm row">
					<div class="col-sm">
						<input type="password" class="form-control form-control-user"
							id="inputPassword" placeholder="Password" />
					</div>
					<div class="col-sm">
						<input type="password" class="form-control form-control-user"
							id="repeatPassword" placeholder="Repeat Password" />
					</div>
				</div>
			</div>

			<div class="row">
				<button class="col btn btn-primary btn-user btn-block m-5"
					id="btnEdit" type="button">수정하기</button>
				<button class="col btn btn-secondary btn-user btn-block m-5"
					id="btnDel" type="button">탈퇴하기</button>
					
			</div>
		</div>
	</div>
</div>

<%@ include file="include/footer.jsp"%>

<div id="overlayer"></div>
<div class="loader">
	<div class="spinner-border" role="status">
		<span class="sr-only">Loading...</span>
	</div>
</div>

<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.animateNumber.min.js"></script>
<script src="js/jquery.waypoints.min.js"></script>
<script src="js/jquery.fancybox.min.js"></script>
<script src="js/aos.js"></script>
<script src="js/moment.min.js"></script>
<script src="js/daterangepicker.js"></script>

<script src="js/typed.js"></script>
<script src="js/custom.js"></script>

<script>
	window.onload = function(){
	    document.querySelector("#btnEdit").onclick = edit;
	    document.querySelector("#btnDel").onclick = del;
	}
	
	async function edit(){
		let userName = document.querySelector("#inputName").value;
		let userPassword = document.querySelector("#inputPassword").value;
		let userRepeatPassword = document.querySelector("#repeatPassword").value;

        let urlParams = new URLSearchParams({
            path: 'editInfo',
            userName: userName,
            userPassword: userPassword
        });

        let fetchOptions = {
            method: "POST",
            body: urlParams
        }
        
		if (userPassword.equals(userRepeatPassword))){
			console.log("PW == Repeat PW!!")
	        let response = await fetch("/user/userEdit", fetchOptions);
	        let data = await response.json();
	        console.log("edit: "+data);	        

	        if (data.result == "success"){
	        	window.location.href="userinfo.jsp";
	        } else if (data.result == "fail"){
	        	alert("입력을 확인해주세요.");
	        }
		}
		
	}
	
	async function del(){
		
	}
	


</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="include/header.jsp" %>
</head>

<%@ include file="include/navbar.jsp" %>

<div class="hero hero-inner">
	<div class="container">
		<div class="row align-items-center">
			<div class="col-lg-6 mx-auto text-center">
				<div class="intro-wrap">
					<h1 class="mb-0">Login</h1>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="untree_co-section">
	<div class="container justify-content-center">
		<div class="row">
			<div class="col">
				<div class="p-5">
					<div class="text-center">
						<h1 class="h2 text-gray-900 mb-4">Welcome Back!</h1>
					</div>
					<form name="login-form" class="login-form">
						<div class="form-group">
							<input type="email" class="form-control form-control-user"
								id="userId" aria-describedby="emailHelp"
								placeholder="Enter Email Address..." value="ssafy@email.com" />
						</div>
						<div class="form-group">
							<input type="password" class="form-control form-control-user"
								id="userPassword" placeholder="Password" value="1234" />
						</div>
						<!-- <div class="form-group">
								<div class="custom-control custom-checkbox small">
									<input type="checkbox" class="custom-control-input"
										id="customCheck" /> <label class="custom-control-label"
										for="customCheck">Remember Me</label>
								</div>
							</div> -->
						<button class="login-btn btn btn-primary btn-user btn-block"
							id="btnLogin" type="button">로그인</button>
						<!-- <a href="index.html" class="btn btn-primary btn-user btn-block"> Login </a> -->
						<!-- <hr />
              <a href="index.html" class="btn btn-google btn-user btn-block">
                <i class="fab fa-google fa-fw"></i> Login with Google
              </a>
              <a href="index.html" class="btn btn-facebook btn-user btn-block">
                <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook
              </a> -->
					</form>

					<!--
            <div class="text-center">
              <a class="small" href="forgot-password.html">Forgot Password?</a>
            </div>
            <div class="text-center">
              <a class="small" href="register.html">Create an Account!</a>
            </div>
            -->
				</div>
			</div>

			<div class="col">
				<div class="p-5">
					<div class="text-center">
						<h1 class="h2 text-gray-900 mb-4">Create an Account!</h1>
					</div>
					<form class="user">
						<div class="form-group">
							<div class="mb-sm-0">
								<input type="text" class="form-control form-control-user"
									id="registName" placeholder="Name" />
							</div>
						</div>
						<div class="form-group">
							<input type="email" class="form-control form-control-user"
								id="registId" placeholder="Email Address for Id" />
						</div>
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="password" class="form-control form-control-user"
									id="registPassword" placeholder="Password" />
							</div>
							<div class="col-sm-6">
								<input type="password" class="form-control form-control-user"
									id="registRepeatPassword" placeholder="Repeat Password" />
							</div>
						</div>
						<button class="login-btn btn btn-primary btn-user btn-block"
							id="btnRegist" type="button">회원가입</button>
						<!-- 소셜 로그인 -->
						<!-- <hr />
                <a href="index.html" class="btn btn-google btn-user btn-block">
                  <i class="fab fa-google fa-fw"></i> Register with Google
                </a>
                <a href="index.html" class="btn btn-facebook btn-user btn-block">
                  <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                </a> -->
					</form>
					<!-- <div class="text-center">
                <a class="small" href="forgot-password.html">Forgot Password?</a>
              </div> -->
					<!-- <div class="text-center">
              <a class="small" href="login.html">Already have an account? Login!</a>
            </div> -->
				</div>
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

<script src="js/login.js"></script>
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

<script type="text/javascript">
	window.onload = function(){
        document.querySelector("#btnLogin").onclick = login;
        document.querySelector("#btnRegist").onclick = regist;
    }

    async function login(){
        // 사용자가 입력한 파라미터 준비
        // 백엔드 url 요청 - fetch post
        // 결과 : json
        // 성공 / 실패

        let userId = document.querySelector("#userId").value;
        let userPassword = document.querySelector("#userPassword").value;

        let urlParams = new URLSearchParams({
            job: 'login',
            userId: userId,
            userPassword: userPassword
        });

        let fetchOptions = {
            method: "POST",
            body: urlParams
        }
        let response = await fetch("/loginout", fetchOptions);
        let data = await response.json();
        console.log(data);
        
        if (data.result == "success"){
        	window.location.href="/main";
        } else if (data.result == "fail"){
        	alert("아이디 또는 비밀번호가 틀렸습니다.");
        }
    }
    
    async function regist(){
        // 사용자가 입력한 파라미터 준비
        // 백엔드 url 요청 - fetch post
        // 결과 : json
        // 성공 / 실패
        
        let registName = document.querySelector("#registName").value;
        let registId = document.querySelector("#registId").value;
        let registPassword = document.querySelector("#registPassword").value;
        let registRepeatPassword = document.querySelector("#registRepeatPassword").value;
        
        let urlParams = new URLSearchParams({
            job: 'isIdUnique',
            userId: registId
        });
        console.log("userId == "+ registId );

        let fetchOptions = {
            method: "POST",
            body: urlParams
        }
        
        let response = await fetch("/user/isIdUnique", fetchOptions);
        let data = await response.json();
        
        if (data.result == "fail"){
        	alert("중복된 아이디입니다.");
        } else if (registPassword != registRepeatPassword){
        	/* console.log("pw: "+registPassword+" / re-pw: "+registRepeatPassword); */
        	alert("비밀번호를 확인해주세요.");
    	} else {
        	let urlParams = new URLSearchParams({
                job: 'register',
                userName: registName,
                userId: registId,
                userPassword: registPassword,
                repeatPassword: registRepeatPassword
            });
        	
            let fetchOptions = {
                method: "POST",
                body: urlParams
            }
            let response = await fetch("/user/register", fetchOptions);
            let data = await response.json();
            console.log("register: " + data);
            
            if (data.result == "success"){
            	window.location.href="/main";
            } else if (data.result == "fail"){
            	alert("회원가입 실패했습니다.");
            }
        }
        
    }
	</script>

</body>
</html>

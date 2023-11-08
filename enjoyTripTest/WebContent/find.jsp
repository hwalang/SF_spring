<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dto.*, map.*, java.util.List"%>

<%
UserDto userDto = (UserDto) session.getAttribute("userDto");
List<SidoDto> sidoList = (List<SidoDto>) request.getAttribute("sidoList");
List<GugunDto> gugunList = (List<GugunDto>) request.getAttribute("gugunList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Solartec - Renewable Energy Website Template</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="keywords" />
<meta content="" name="description" />

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon" />

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;500&family=Roboto:wght@500;700;900&display=swap"
	rel="stylesheet" />

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet" />

<!-- Libraries Stylesheet -->
<link href="lib/animate/animate.min.css" rel="stylesheet" />
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet" />
<link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet" />

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet" />
</head>

<body>
	<!-- 지도 -->

	<!-- Spinner Start -->
	<div id="spinner"
		class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
		<div class="spinner-border text-primary"
			style="width: 3rem; height: 3rem" role="status">
			<span class="sr-only">Loading...</span>
		</div>
	</div>
	<!-- Spinner End -->

	<%
	if (userDto != null) {
		// 로그인 성공
	%>
	<!-- Navbar Start -->
	<nav
		class="navbar navbar-expand-lg bg-white navbar-light sticky-top p-0">
		<a href="index.jsp"
			class="navbar-brand d-flex align-items-center border-end px-4 px-lg-6">
			<h2 class="m-0 text-primary">K SpotS!</h2>
		</a>
		<button type="button" class="navbar-toggler me-4"
			data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
			<span class="navbar-toggler-icon"></span>
		</button>
		<!-- navbar button -->
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<div class="navbar-nav ms-auto p-4 p-lg-0">
				<a href="index.jsp" class="nav-item nav-link">Home</a> <a
					href="board.jsp" class="nav-item nav-link">게시판</a> <a
					href="find.jsp" class="nav-item nav-link active">여행지 찾기</a>

				<!-- 개인화 페이지 -->
				<a href="favorites.jsp" id="navFavorite" class="nav-item nav-link">즐겨찾기</a>
				<a href="mypage.jsp" id="navMyPage" class="nav-item nav-link">마이페이지</a>

				<!-- 로그인 버튼을 누르면 Modal 창이 뜨고 | 로그인/회원가입 버튼  -->

				<a href="#">
					<form action="/loginout" method="post">
						<input type="hidden" name="job" value="logout" />
						<button id="navLogout" type="submit"
							class="btn btn-primary nav-item rounded-0 py-4 px-lg-5 d-none d-lg-block">logout</button>
					</form>
				</a>
			</div>
		</div>
	</nav>
	<!-- Navbar End -->
	<%
	} else { // 로그인하지 않은 상태
	%>
	<!-- Navbar Start -->
	<nav
		class="navbar navbar-expand-lg bg-white navbar-light sticky-top p-0">
		<a href="index.jsp"
			class="navbar-brand d-flex align-items-center border-end px-4 px-lg-6">
			<h2 class="m-0 text-primary">K SpotS!</h2>
		</a>
		<button type="button" class="navbar-toggler me-4"
			data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
			<span class="navbar-toggler-icon"></span>
		</button>
		<!-- navbar button -->
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<div class="navbar-nav ms-auto p-4 p-lg-0">
				<a href="index.jsp" class="nav-item nav-link">Home</a> <a
					href="board.jsp" class="nav-item nav-link">게시판</a> <a
					href="find.jsp" class="nav-item nav-link active">여행지 찾기</a>

				<!-- 로그인 버튼을 누르면 Modal 창이 뜨고 | 로그인/회원가입 버튼  -->
				<a href="#" id="navLogin"
					class="btn btn-primary nav-item rounded-0 py-4 px-lg-5 d-none d-lg-block">login</a>
			</div>
		</div>
	</nav>
	<!-- Navbar End -->
	<%
	}
	%>


	<!-- 로그인 화면 -->
	<div id="modalByJs" class="modal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">로그인</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<!-- form -->
					<form action="/loginout" method="post">
						<div class="mb-3">
							<input type="hidden" value="login" name="job"><br> <input
								type="hidden" value="find" name="path"><br> <label
								for="exampleInputEmail1" class="form-label">Email
								address</label> <input type="email" name="userEmail"
								class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" />
						</div>
						<div class="mb-3">
							<label for="exampleInputPassword1" class="form-label">Password</label>
							<input type="password" name="userPassword" class="form-control"
								id="exampleInputPassword1" />
						</div>
						<div class="modal-footer">
							<button type="button" id="btnRegister" class="btn btn-secondary"
								data-bs-dismiss="modal">회원가입</button>
							<button type="submit" id="btnLogin" class="btn btn-primary">로그인</button>
						</div>
						<!-- 수정사항end -->
					</form>
				</div>
			</div>
		</div>
	</div>


	<!-- 회원가입 modal -->
	<div id="modalByRegister" class="modal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">회원가입</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<!-- form -->
					<form action="/users" method="get">
						<input type="hidden" value="A" name="job"><br>
						<div class="mb-3">
							<label for="exampleInputName" class="form-label">이름</label> <input
								type="text" name="userName" class="form-control"
								id="registerInputName" aria-describedby="nameHelp" />
						</div>
						<div class="mb-3">
							<label for="registerInputEmail" class="form-label">이메일</label> <input
								type="email" class="form-control" name="userEmail"
								id="registerInputEmail" aria-describedby="emailHelp" />
						</div>
						<!-- 전화번호 추가 -->
						<div class="mb-3">
							<label for="registerInputPhone" class="form-label">전화번호</label> <input
								type="tel" class="form-control" name="userPhone"
								id="registerInputPhone" aria-describedby="phoneHelp" />
						</div>
						<div class="mb-3">
							<label for="registerInputPassword1" class="form-label">Password</label>
							<input type="password" name="userPassword" class="form-control"
								id="registerInputPassword1" />
						</div>
						<div class="modal-footer">
							<button type="submit" id="registerCheck" class="btn btn-primary">회원가입</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- modal 끝 -->

	<!-- Page Header Start -->
	<div class="container-fluid page-header py-5 mb-5">
		<div class="container py-5">
			<h1 class="display-3 text-white mb-3 animated slideInDown">국내
				여행지 찾기</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a class="text-white" href="#">Home</a>
					</li>
					<li class="breadcrumb-item"><a class="text-white" href="#">Pages</a>
					</li>
					<li class="breadcrumb-item text-white active" aria-current="page">여행지 찾기</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->

	<!-- map Start -->
	<div class="container-fluid bg-light overflow-hidden px-lg-0"
		style="margin: 6rem 0">
		<div class="container">
			<div class="row g-0 mx-lg-0">
				<div class="contact-text py-5 wow fadeIn" data-wow-delay="0.5s">
					<div class="p-lg-5 ps-lg-0 text-end">
						<h6 class="text-primary">국내 여행지</h6>
						<h1 class="mb-4">Search</h1>

						<!-- 여기서 카테고리 설정 -->
						<div class="container pt-3 ">
							<h2 class="text-end">관광지 검색</h2>
							<div class="row justify-content-end">
								<div class="col-md-2">
									<select id="area1List" name="area1List" class="form-select">
										<option value="">시도</option>
										<%
										for (SidoDto dto : sidoList) {
										%>
										<option value="<%=dto.getSidoCode()%>"><%=dto.getSidoName()%></option>

										<%
										}
										%>
									</select>
								</div>
								<div class="col-md-2">
									<select id="area2List" name="area2List" class="form-select">
										<option value="">구군</option>
									</select>
								</div>
								<div class="col-md-2">
									<div class="d-grid gap-2">
										<button id="btnSearch" type="button" class="btn btn-primary">검색</button>
									</div>
								</div>
							</div>
						</div>
						<!-- kakao map -->
						<div id="map" style="width: 100%; height: 600px"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Contact End -->

	<!-- Footer Start -->
	<div
		class="container-fluid bg-dark text-body footer mt-5 pt-5 wow fadeIn"
		data-wow-delay="0.1s">
		<div class="container py-5">
			<div class="row g-5">
				<!-- <div class="col-lg-3 col-md-6"> -->
				<h5 class="text-white mb-4">한국 대표 관광지 사진</h5>
				<div class="row g-2">
					<div class="col-2">
						<img class="img-fluid rounded"
							src="https://www.visitbusan.net/uploadImgs/files/cntnts/20191229153531987_oen"
							alt="" />
					</div>
					<div class="col-2">
						<img class="img-fluid rounded"
							src="https://www.visitbusan.net/uploadImgs/files/cntnts/20220808115019607_wufrotr"
							alt="" />
					</div>
					<div class="col-2">
						<img class="img-fluid rounded"
							src="https://www.visitbusan.net/uploadImgs/files/cntnts/20200717114921495_oen"
							alt="" />
					</div>
					<div class="col-2">
						<img class="img-fluid rounded"
							src="https://www.visitbusan.net/uploadImgs/files/cntnts/20191229142305192_oen"
							alt="" />
					</div>
					<div class="col-2">
						<img class="img-fluid rounded"
							src="https://www.visitbusan.net/uploadImgs/files/cntnts/20191229160530047_oen"
							alt="" />
					</div>
					<div class="col-2">
						<img class="img-fluid rounded"
							src="https://www.visitbusan.net/uploadImgs/files/cntnts/20191231193128851_wufrotr"
							alt="" />
					</div>
				</div>
				<!-- </div> -->
			</div>
		</div>
		<div class="container">
			<div class="copyright">
				<div class="row">
					<div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
						&copy; <a href="#">한국 관광지 추천 페이지</a>
					</div>
					<div class="col-md-6 text-center text-md-end">
						<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
						Designed By <a href="https://htmlcodex.com">부울경 3반 11조 김동현,
							우미경</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer End -->

	<!-- Back to Top -->
	<a href="#"
		class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"><i
		class="bi bi-arrow-up"></i></a>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="lib/wow/wow.min.js"></script>
	<script src="lib/easing/easing.min.js"></script>
	<script src="lib/waypoints/waypoints.min.js"></script>
	<script src="lib/counterup/counterup.min.js"></script>
	<script src="lib/owlcarousel/owl.carousel.min.js"></script>
	<script src="lib/isotope/isotope.pkgd.min.js"></script>
	<!-- <script src="lib/lightbox/js/lightbox.min.js"></script> -->

	<!-- kakao map -->
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=031d62f93a0d302ac9151ec448c8abfc"></script>
	<!--  <script src="js/kakao.js"></script>  -->

	<!-- Template Javascript -->
	<script src="js/main.js"></script>
	<script>
    window.onload = function() {
    	// 처음부터 모든 관광지 정보를 가져와서 핀을 찍는다.
    	startMap();
    	   document.querySelector("#area1List").onchange = function() {
    		   changeGugun();
    	   }
    	   
    	   // 검색 버튼을 누르면 select value에 맞춰서 위도 경도를 통해 지도 중심 위치를 옮긴다.
    	   // select value가 없는 경우에는 비활동
    	   document.querySelector("#btnSearch").onclick = function() {
    		   setMarkerPostion();
    	   }
    	}
    
    	async function setMarkerPostion() {
    		
    		// 선택한 시도/구군 정보를 받는다.
    		let selectSidoCode = document.querySelector("#area1List").value;
    		let selectGugunCode = document.querySelector("#area2List").value;
    		
    		setMarkers(selectSidoCode, selectGugunCode);
    	}

    	async function changeGugun(){
			
    		// 선택한 시도 정보를 받는다.
    	    let selectSidoCode = document.querySelector("#area1List").value;
    	    console.log(selectSidoCode);

    	    let response = await fetch(`/mapCategory?action=gugun&select=` + selectSidoCode);
    	    const gugunList = await response.json();
    	    console.log(gugunList);
    	    
    	    // sidoName에 속한 구군 정보를 보여준다.
    	    let area2List = document.querySelector("#area2List");
    	    
    	    // 초기화 후에 세팅
    	    area2List.innerHTML ='';
    	    gugunList.forEach( (gugun) => {
        	    let option = document.createElement('option');
    	    	option.value = gugun.gugunCode;
    	    	option.text = gugun.gugunName;
    	    	area2List.appendChild(option);
    	    });
    	    
    	}
   
    
    // select - option - value를 이용해서 위도,경도 데이터를 가져온다.
    async function setMarkers(selectSidoCode, selectGugunCode) {
    	let response = await fetch("/mapCategory?action=kakaoPin&sido=" + selectSidoCode + "&gugun=" + selectGugunCode);
    	const trips = await response.json();
   		console.log(trips);
   		
   		
   		let positions = [];
   		trips.forEach( (trip) => {
   			positions.push({
   				contentId: trip.content_id,
   				title: trip.title,
   				addr1: trip.addr1,
   				addr2: trip.addr2,
   				imgURL: trip.first_image,
   				latlng: new kakao.maps.LatLng(trip.latitude, trip.longitude)
   			});
   		});
    	
    	let mapContainer = document.getElementById('map'), // 지도를 표시할 div  
        mapOption = { 
            center: new kakao.maps.LatLng(positions[0].latlng.getLat(), positions[0].latlng.getLng()), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };

    	let map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
    	
    	for (let i = 0; i < positions.length; i ++) {
    	    // 마커를 생성합니다
    	    let marker = new kakao.maps.Marker({
    	        map: map, // 마커를 표시할 지도
    	        position: positions[i].latlng, // 마커의 위치
    	        clickable: true
    	    });

    	 	// custom infoWindow
        	let iwContent = 
        	'<div class="container bg-white" style="border: 1.5px solid black;">' +
        	'  <form action="/mapCategory" method="get">' +
        	'   <input type="hidden" name="content_id" value="' + positions[i].contentId + '" />' +
        	'	<input type="hidden" name="action" value="tripDetail" />' +
        	'	<div class="row" style="height:35px;">' +
        	'		<div>' +
        	'			<div class="col-8">' + positions[i].title + '</div>' +
        	'		</div>' +
        	'	</div>' +
        	'	<div class="row">' +
        	'		<div class="col">' +
        	'			<img src=' + positions[i].imgURL + ' class="img-fluid" alt="관광지이미지" />' +
        	'		</div>' +
        	'		<div class="col-7">' +
        	'			<div class="col d-flex align-items-stretch" id="trip_addr">' + positions[i].addr1 + ' ' + positions[i].addr2 + '</div>' +
        	'			<div class="w-100"></div>' +
        	'         <div class="col d-flex align-items-stretch">' +
        	'			<button type="submit" class="btn btn-primary">' +
        	'				상세페이지' +
        	'			</button>' +
        	'          </div>' +
        	'		</div>' +
        	'	</div>' +
        	'  </form>' +
        	'</div>';
        	
        	// 마커에 표시할 인포윈도우를 생성합니다 
    	    let infowindow = new kakao.maps.InfoWindow({
    	        content: iwContent, // 인포윈도우에 표시할 내용
    	        removable: true
    	    });

    	    // for문에서 클릭 리스너를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
    	    kakao.maps.event.addListener(marker, 'click', function() {
    	          // 마커 위에 인포윈도우를 표시합니다
    	          infowindow.open(map, marker);
    	    });
    	}
    }
    
 	function startMap() {
 		let mapContainer = document.getElementById('map'), // 지도를 표시할 div 
 	    mapOption = { 
 	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
 	        level: 3 // 지도의 확대 레벨
 	    };

 		// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
 		let map = new kakao.maps.Map(mapContainer, mapOption); 
 	}
 	
 	
    </script>
</body>
</html>

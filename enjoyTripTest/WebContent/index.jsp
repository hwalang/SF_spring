<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dto.UserDto, java.util.List" %>
    
<%
UserDto userDto = (UserDto) session.getAttribute("userDto");

%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>한국 관광 페이지</title>
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
      rel="stylesheet"
    />

    <!-- Icon Font Stylesheet -->
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
      rel="stylesheet"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
      rel="stylesheet"
    />

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet" />
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet" />
    <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet" />
  </head>
  <body>
  
  
    <!-- Spinner Start -->
    <div
      id="spinner"
      class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center"
    >
      <div class="spinner-border text-primary" style="width: 3rem; height: 3rem" role="status">
        <span class="sr-only">Loading...</span>
      </div>
    </div>
    <!-- Spinner End -->


<%
if (userDto != null) {
	// 로그인 성공
%>
	<!-- Navbar Start -->
    <nav class="navbar navbar-expand-lg bg-white navbar-light sticky-top p-0">
      <a href="index.jsp" class="navbar-brand d-flex align-items-center border-end px-4 px-lg-6">
        <h2 class="m-0 text-primary">K SpotS!</h2>
      </a>
      <button
        type="button"
        class="navbar-toggler me-4"
        data-bs-toggle="collapse"
        data-bs-target="#navbarCollapse"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <!-- navbar button -->
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <div class="navbar-nav ms-auto p-4 p-lg-0">
          <a href="index.jsp" class="nav-item nav-link active">Home</a>
          <a href="board.jsp" class="nav-item nav-link">게시판</a>
          <a href="/map" class="nav-item nav-link">여행지 찾기</a>

          <!-- 개인화 페이지 -->
          <a href="favorites.jsp" id="navFavorite" class="nav-item nav-link"
            >즐겨찾기</a
          >
          <a href="/mypage.jsp" id="navMyPage" class="nav-item nav-link"
            >마이페이지</a
          >

          <!-- 로그인 버튼을 누르면 Modal 창이 뜨고 | 로그인/회원가입 버튼  -->
          
          <a href="#">
          	<a href="#" id="navLogin" class="btn btn-primary nav-item rounded-0 py-4 px-lg-5 d-none d-lg-block visually-hidden">login</a>
          	<form action="/loginout" method="post">
          		<input type="hidden" name="job" value="logout"/>
          		<button id="navLogout" type="submit" class="btn btn-primary nav-item rounded-0 py-4 px-lg-5 d-none d-lg-block" >logout</button>
          	</form>
          </a>
        </div>
      </div>
    </nav>
    <!-- Navbar End -->
<%
} else {	// 로그인하지 않은 상태
%>
	<!-- Navbar Start -->
    <nav class="navbar navbar-expand-lg bg-white navbar-light sticky-top p-0">
      <a href="index.jsp" class="navbar-brand d-flex align-items-center border-end px-4 px-lg-6">
        <h2 class="m-0 text-primary">K SpotS!</h2>
      </a>
      <button
        type="button"
        class="navbar-toggler me-4"
        data-bs-toggle="collapse"
        data-bs-target="#navbarCollapse"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <!-- navbar button -->
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <div class="navbar-nav ms-auto p-4 p-lg-0">
          <a href="index.jsp" class="nav-item nav-link active">Home</a>
          <a href="board.jsp" class="nav-item nav-link">게시판</a>
          <a href="/map" class="nav-item nav-link">여행지 찾기</a>

          <!-- 로그인 버튼을 누르면 Modal 창이 뜨고 | 로그인/회원가입 버튼  -->
          <a
            href="#"
            id="navLogin"
            class="btn btn-primary nav-item rounded-0 py-4 px-lg-5 d-none d-lg-block"
            >login</a
          >
        </div>
      </div>
    </nav>
    <!-- Navbar End -->
<%
}
%>
    
    
<% // 로그인 성공하면 ajax 또는 JSP를 이용해서 html을 재구성  %>
    <!-- 로그인 화면 -->
    <div id="modalByJs" class="modal" tabindex="-1">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">로그인</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <!-- form -->
            <form action="/loginout" method="post">
              <div class="mb-3">
              	<input type="hidden" value="login" name="job"><br>
              	<input type="hidden" value="index" name="path"><br>
                <label for="exampleInputEmail1" class="form-label">Email address</label>
                <input type="email" name="userEmail" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" />
              </div>
              <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Password</label>
                <input type="password" name="userPassword" class="form-control" id="exampleInputPassword1" />
              </div>
              <div class="modal-footer">
                <button type="button" id="btnRegister" class="btn btn-secondary" data-bs-dismiss="modal">회원가입</button>
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
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <!-- form -->
            <form action="/users" method="get">
            <input type="hidden" value="A" name="job"><br>
              <div class="mb-3">
                <label for="registerInputName" class="form-label">이름</label>
                <input type="text" name="userName" class="form-control" id="registerInputName" aria-describedby="nameHelp" />
              </div>
              <div class="mb-3">
                <label for="registerInputEmail" class="form-label">이메일</label>
                <input type="email" class="form-control" name="userEmail" id="registerInputEmail" aria-describedby="emailHelp" />
              </div>
              <!-- 전화번호 추가 -->
              <div class="mb-3">
                <label for="registerInputPhone" class="form-label">전화번호</label>
                <input type="tel" class="form-control" name="userPhone" id="registerInputPhone" aria-describedby="phoneHelp" />
              </div>
              <div class="mb-3">
                <label for="registerInputPassword1" class="form-label">Password</label>
                <input type="password" name="userPassword" class="form-control" id="registerInputPassword1" />
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

    <!-- 앞에 큰 사진 화면 Start -->
    <div class="container-fluid p-0 pb-5 wow fadeIn" data-wow-delay="0.1s">
      <div class="owl-carousel header-carousel position-relative">
        <div
          class="owl-carousel-item position-relative"
          data-dot="<img src='img/gyeongbokgung-1.jpg'>"
        >
          <img class="img-fluid" src="img/gyeongbokgung-1.jpg" alt="" />
          <a
            href="https://kr.freepik.com/free-photo/gyeongbokgung-palace-in-autumn-south-korea_21520841.htm#query=%ED%95%9C%EA%B5%AD%20%EC%97%AC%ED%96%89&position=37&from_view=keyword&track=ais"
            style="display: none"
            >작가 tawatchai07</a
          >
          <div class="owl-carousel-inner">
            <div class="container">
              <div class="row justify-content-start">
                <div class="col-10 col-lg-8">
                  <h1 class="display-2 text-white animated slideInDown">한국의 명소</h1>
                  <p class="fs-5 fw-medium text-white mb-4 pb-3">
                    한국의 아름다운 명소를 함께 찾아보고 서로 공유해요!
                  </p>
                  <a
                    href="/map"
                    class="btn btn-primary rounded-pill py-3 px-5 animated slideInLeft"
                    >관광지 검색하기</a
                  >
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="owl-carousel-item position-relative" data-dot="<img src='img/namsan-1.jpg'>">
          <img class="img-fluid" src="img/namsan-1.jpg" alt="" />
          <a
            href="https://kr.freepik.com/free-photo/seoul-tower-with-gyeongbokgung-roof-and-red-autumn-maple-leaves-at-namsan-mountain-in-south-korea_11599580.htm#query=%ED%95%9C%EA%B5%AD%20%EC%97%AC%ED%96%89&position=41&from_view=keyword&track=ais"
            style="display: none"
            >작가 tawatchai07</a
          >
          <div class="owl-carousel-inner">
            <div class="container">
              <div class="row justify-content-start">
                <div class="col-10 col-lg-8">
                  <h1 class="display-2 text-white animated slideInDown">한국의 맛</h1>
                  <p class="fs-5 fw-medium text-white mb-4 pb-3">
                    한국의 아름다운 명소를 함께 찾아보고 서로 공유해요!
                  </p>
                  <a
                    href="board.jsp"
                    class="btn btn-primary rounded-pill py-3 px-5 animated slideInLeft"
                    >게시판으로 이동</a
                  >
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- 앞에 큰 사진 화면 End -->

<!-- 

 -->


    <!-- 수치표현 Start -->
    <div class="container-xxl py-5">
      <div class="container">
        <div class="row g-5">
          <div class="col-md-6 col-lg-4 wow fadeIn" data-wow-delay="0.1s">
            <div class="d-flex align-items-center mb-4">
              <div class="btn-lg-square bg-primary rounded-circle me-3">
                <i class="fa fa-users text-white"></i>
              </div>
              <h1 class="mb-0" data-toggle="counter-up">3453</h1>
            </div>
            <h5 class="mb-3">이용하는 고객 수</h5>
            <span
              >점점 증가하는 이용자 수<br />
              많은 사람들과 장소를 공유해요!</span
            >
          </div>
          <div class="col-md-6 col-lg-4 wow fadeIn" data-wow-delay="0.3s">
            <div class="d-flex align-items-center mb-4">
              <div class="btn-lg-square bg-primary rounded-circle me-3">
                <i class="fa fa-check text-white"></i>
              </div>
              <h1 class="mb-0" data-toggle="counter-up">4234</h1>
            </div>
            <h5 class="mb-3">등록된 장소 수</h5>
            <span
              >한국의 몰랐던 장소를 찾아서<br />
              여행해보세요!</span
            >
          </div>
          <div class="col-md-6 col-lg-4 wow fadeIn" data-wow-delay="0.5s">
            <div class="d-flex align-items-center mb-4">
              <div class="btn-lg-square bg-primary rounded-circle me-3">
                <i class="fa fa-award text-white"></i>
              </div>
              <h1 class="mb-0" data-toggle="counter-up">3123</h1>
            </div>
            <h5 class="mb-3">등록된 후기 수</h5>
            <span
              >게시글에 등록된 수많은 장소의 후기를 보고<br />
              즐거운 여행하세요!</span
            >
          </div>
        </div>
      </div>
    </div>
    <!-- 수치표현 Start -->


<!--  지도 삭제  -->


<%
if (userDto != null) {
	// 로그인 성공
%>
    <!-- 즐겨찾기 Start -->
    <div class="container-xxl py-5">
      <div class="container">
        <div
          class="text-center mx-auto mb-5 wow fadeInUp"
          data-wow-delay="0.1s"
          style="max-width: 600px"
        >
          <h6 class="text-primary">Fav Spots</h6>
          <h1 class="mb-4">Your Pick!</h1>
        </div>
        <div class="row g-4">
          <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="team-item rounded overflow-hidden">
              <div class="d-flex">
                <img
                  class="img-fluid w-75"
                  src="https://www.visitbusan.net/uploadImgs/files/cntnts/20191229153531987_oen"
                  alt=""
                />
                <div class="team-social w-25">
                  <a class="btn btn-lg-square btn-outline-primary rounded-circle mt-3" href=""
                    ><i class="bi bi-bookmark-heart-fill"></i
                  ></a>
                </div>
              </div>
              <div class="p-4">
                <h5>해운대</h5>
                <span>주소</span>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
            <div class="team-item rounded overflow-hidden">
              <div class="d-flex">
                <img
                  class="img-fluid w-75"
                  src="https://www.visitbusan.net/uploadImgs/files/cntnts/20220808115019607_wufrotr"
                  alt=""
                />
                <div class="team-social w-25">
                  <a class="btn btn-lg-square btn-outline-primary rounded-circle mt-3" href=""
                    ><i class="bi bi-bookmark-heart-fill"></i
                  ></a>
                </div>
              </div>
              <div class="p-4">
                <h5>롯데월드 어드벤처</h5>
                <span>주소</span>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
            <div class="team-item rounded overflow-hidden">
              <div class="d-flex">
                <img
                  class="img-fluid w-75"
                  src="https://www.visitbusan.net/uploadImgs/files/cntnts/20200717114921495_oen"
                  alt=""
                />
                <div class="team-social w-25">
                  <a class="btn btn-lg-square btn-outline-primary rounded-circle mt-3" href=""
                    ><i class="bi bi-bookmark-heart-fill"></i
                  ></a>
                </div>
              </div>
              <div class="p-4">
                <h5>송도</h5>
                <span>주소</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- 즐겨찾기 End -->
<%
}
%>

    <!-- 게시판 Start -->
    <div class="container-xxl py-5">
      <div class="container">
        <div
          class="text-center mx-auto mb-5 wow fadeInUp"
          data-wow-delay="0.1s"
          style="max-width: 600px"
        >
          <h6 class="text-primary">이용자 소리함</h6>
          <h1 class="mb-4">What Our Clients Say!</h1>
        </div>

        <div class="owl-carousel testimonial-carousel wow fadeInUp" data-wow-delay="0.1s">
          <div class="testimonial-item text-center">
            <div class="testimonial-img position-relative">
              <img class="img-fluid rounded-circle mx-auto mb-5" src="img/testimonial-1.jpg" />
              <div class="btn-square bg-primary rounded-circle">
                <i class="fa fa-quote-left text-white"></i>
              </div>
            </div>
            <div class="testimonial-text text-center rounded p-5">
              <p>
                탁 트인 바다를 보니 평소의 피로가 날아가는 기분이었습니다! 다들 꼭 해운대 방문
                추천합니다!!
              </p>
              <hr />
              <h5 class="mb-1">홍길동</h5>
              <span class="fst-italic">24세</span>
              <br />
              <button type="button" class="btn mt-0 fs-6 fw-light" style="float: right">
                공유<i class="bi bi-arrow-bar-up"></i>
              </button>
            </div>
          </div>
          <div class="testimonial-item text-center">
            <div class="testimonial-img position-relative">
              <img class="img-fluid rounded-circle mx-auto mb-5" src="img/testimonial-2.jpg" />
              <div class="btn-square bg-primary rounded-circle">
                <i class="fa fa-quote-left text-white"></i>
              </div>
            </div>
            <div class="testimonial-text text-center rounded p-5">
              <p>
                평소 심란할 때 자주 찾는 곳입니다. 많은 사람들이 오지 않아 조용하기 때문에 마음이
                편안하고, 새소리와 절 소리가 마음을 편안하게 해줍니다. 다음에는 템플스테이까지 하고
                싶습니다.
              </p>
              <hr />
              <h5 class="mb-1">이길동</h5>
              <span class="fst-italic">32세</span>
              <br />
              <button type="button" class="btn mt-0 fs-6 fw-light" style="float: right">
                공유<i class="bi bi-arrow-bar-up"></i>
              </button>
            </div>
          </div>
          <div class="testimonial-item text-center">
            <div class="testimonial-img position-relative">
              <img class="img-fluid rounded-circle mx-auto mb-5" src="img/testimonial-3.jpg" />
              <div class="btn-square bg-primary rounded-circle">
                <i class="fa fa-quote-left text-white"></i>
              </div>
            </div>
            <div class="testimonial-text text-center rounded p-5">
              <p>
                부산을 오랜만에 방문한 친구를 데리고 간 곳입니다! 친구도 너무 재밌었다고
                좋아했습니다. 다들 부산에 놀러오는 친구를 데리고 가시는 거 아주 추천합니다!
              </p>
              <hr />
              <h5 class="mb-1">삼길동</h5>
              <span class="fst-italic fst-bold">26세</span>
              <br />
              <button type="button" class="btn mt-0 fs-6 fw-light" style="float: right">
                공유<i class="bi bi-arrow-bar-up"></i>
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- 게시판 End -->

    <!-- About Start -->
    <!-- <div class="container-fluid bg-light overflow-hidden my-5 px-lg-0">
      <div class="container about px-lg-0">
        <div class="row g-0 mx-lg-0">
          <div class="col-lg-6 ps-lg-0 wow fadeIn" data-wow-delay="0.1s" style="min-height: 400px">
            <div class="position-relative h-100">
              <img
                class="position-absolute img-fluid w-100 h-100"
                src="img/about.jpg"
                style="object-fit: cover"
                alt=""
              />
            </div>
          </div>
          <div class="col-lg-6 about-text py-5 wow fadeIn" data-wow-delay="0.5s">
            <div class="p-lg-5 pe-lg-0">
              <h6 class="text-primary">About Us</h6>
              <h1 class="mb-4">25+ Years Experience In Solar & Renewable Energy Industry</h1>
              <p>
                Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit. Aliqu diam amet diam et
                eos. Clita erat ipsum et lorem et sit, sed stet lorem sit clita duo justo erat amet
              </p>
              <p><i class="fa fa-check-circle text-primary me-3"></i>Diam dolor diam ipsum</p>
              <p><i class="fa fa-check-circle text-primary me-3"></i>Aliqu diam amet diam et eos</p>
              <p>
                <i class="fa fa-check-circle text-primary me-3"></i>Tempor erat elitr rebum at clita
              </p>
              <a href="" class="btn btn-primary rounded-pill py-3 px-5 mt-3">Explore More</a>
            </div>
          </div>
        </div>
      </div>
    </div> -->
    <!-- About End -->

    <!-- Service Start -->
    <!-- <div class="container-xxl py-5">
      <div class="container">
        <div
          class="text-center mx-auto mb-5 wow fadeInUp"
          data-wow-delay="0.1s"
          style="max-width: 600px"
        >
          <h6 class="text-primary">Our Services</h6>
          <h1 class="mb-4">We Are Pioneers In The World Of Renewable Energy</h1>
        </div>
        <div class="row g-4">
          <div class="col-md-6 col-lg-4 wow fadeInUp" data-wow-delay="0.1s">
            <div class="service-item rounded overflow-hidden">
              <img class="img-fluid" src="img/img-600x400-1.jpg" alt="" />
              <div class="position-relative p-4 pt-0">
                <div class="service-icon">
                  <i class="fa fa-solar-panel fa-3x"></i>
                </div>
                <h4 class="mb-3">Solar Panels</h4>
                <p>Stet stet justo dolor sed duo. Ut clita sea sit ipsum diam lorem diam.</p>
                <a class="small fw-medium" href=""
                  >Read More<i class="fa fa-arrow-right ms-2"></i
                ></a>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-4 wow fadeInUp" data-wow-delay="0.3s">
            <div class="service-item rounded overflow-hidden">
              <img class="img-fluid" src="img/img-600x400-2.jpg" alt="" />
              <div class="position-relative p-4 pt-0">
                <div class="service-icon">
                  <i class="fa fa-wind fa-3x"></i>
                </div>
                <h4 class="mb-3">Wind Turbines</h4>
                <p>Stet stet justo dolor sed duo. Ut clita sea sit ipsum diam lorem diam.</p>
                <a class="small fw-medium" href=""
                  >Read More<i class="fa fa-arrow-right ms-2"></i
                ></a>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-4 wow fadeInUp" data-wow-delay="0.5s">
            <div class="service-item rounded overflow-hidden">
              <img class="img-fluid" src="img/img-600x400-3.jpg" alt="" />
              <div class="position-relative p-4 pt-0">
                <div class="service-icon">
                  <i class="fa fa-lightbulb fa-3x"></i>
                </div>
                <h4 class="mb-3">Hydropower Plants</h4>
                <p>Stet stet justo dolor sed duo. Ut clita sea sit ipsum diam lorem diam.</p>
                <a class="small fw-medium" href=""
                  >Read More<i class="fa fa-arrow-right ms-2"></i
                ></a>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-4 wow fadeInUp" data-wow-delay="0.1s">
            <div class="service-item rounded overflow-hidden">
              <img class="img-fluid" src="img/img-600x400-4.jpg" alt="" />
              <div class="position-relative p-4 pt-0">
                <div class="service-icon">
                  <i class="fa fa-solar-panel fa-3x"></i>
                </div>
                <h4 class="mb-3">Solar Panels</h4>
                <p>Stet stet justo dolor sed duo. Ut clita sea sit ipsum diam lorem diam.</p>
                <a class="small fw-medium" href=""
                  >Read More<i class="fa fa-arrow-right ms-2"></i
                ></a>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-4 wow fadeInUp" data-wow-delay="0.3s">
            <div class="service-item rounded overflow-hidden">
              <img class="img-fluid" src="img/img-600x400-5.jpg" alt="" />
              <div class="position-relative p-4 pt-0">
                <div class="service-icon">
                  <i class="fa fa-wind fa-3x"></i>
                </div>
                <h4 class="mb-3">Wind Turbines</h4>
                <p>Stet stet justo dolor sed duo. Ut clita sea sit ipsum diam lorem diam.</p>
                <a class="small fw-medium" href=""
                  >Read More<i class="fa fa-arrow-right ms-2"></i
                ></a>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-4 wow fadeInUp" data-wow-delay="0.5s">
            <div class="service-item rounded overflow-hidden">
              <img class="img-fluid" src="img/img-600x400-6.jpg" alt="" />
              <div class="position-relative p-4 pt-0">
                <div class="service-icon">
                  <i class="fa fa-lightbulb fa-3x"></i>
                </div>
                <h4 class="mb-3">Hydropower Plants</h4>
                <p>Stet stet justo dolor sed duo. Ut clita sea sit ipsum diam lorem diam.</p>
                <a class="small fw-medium" href=""
                  >Read More<i class="fa fa-arrow-right ms-2"></i
                ></a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div> -->
    <!-- Service End -->

    <!-- Feature Start -->
    <!-- <div class="container-fluid bg-light overflow-hidden my-5 px-lg-0">
      <div class="container feature px-lg-0">
        <div class="row g-0 mx-lg-0">
          <div class="col-lg-6 feature-text py-5 wow fadeIn" data-wow-delay="0.1s">
            <div class="p-lg-5 ps-lg-0">
              <h6 class="text-primary">Why Choose Us!</h6>
              <h1 class="mb-4">Complete Commercial & Residential Solar Systems</h1>
              <p class="mb-4 pb-2">
                Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit. Aliqu diam amet diam et
                eos. Clita erat ipsum et lorem et sit, sed stet lorem sit clita duo justo erat amet
              </p>
              <div class="row g-4">
                <div class="col-6">
                  <div class="d-flex align-items-center">
                    <div class="btn-lg-square bg-primary rounded-circle">
                      <i class="fa fa-check text-white"></i>
                    </div>
                    <div class="ms-4">
                      <p class="mb-0">Quality</p>
                      <h5 class="mb-0">Services</h5>
                    </div>
                  </div>
                </div>
                <div class="col-6">
                  <div class="d-flex align-items-center">
                    <div class="btn-lg-square bg-primary rounded-circle">
                      <i class="fa fa-user-check text-white"></i>
                    </div>
                    <div class="ms-4">
                      <p class="mb-0">Expert</p>
                      <h5 class="mb-0">Workers</h5>
                    </div>
                  </div>
                </div>
                <div class="col-6">
                  <div class="d-flex align-items-center">
                    <div class="btn-lg-square bg-primary rounded-circle">
                      <i class="fa fa-drafting-compass text-white"></i>
                    </div>
                    <div class="ms-4">
                      <p class="mb-0">Free</p>
                      <h5 class="mb-0">Consultation</h5>
                    </div>
                  </div>
                </div>
                <div class="col-6">
                  <div class="d-flex align-items-center">
                    <div class="btn-lg-square bg-primary rounded-circle">
                      <i class="fa fa-headphones text-white"></i>
                    </div>
                    <div class="ms-4">
                      <p class="mb-0">Customer</p>
                      <h5 class="mb-0">Support</h5>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-6 pe-lg-0 wow fadeIn" data-wow-delay="0.5s" style="min-height: 400px">
            <div class="position-relative h-100">
              <img
                class="position-absolute img-fluid w-100 h-100"
                src="img/feature.jpg"
                style="object-fit: cover"
                alt=""
              />
            </div>
          </div>
        </div>
      </div>
    </div> -->
    <!-- Feature End -->

    <!-- Footer Start -->
    <div
      class="container-fluid bg-dark text-body footer mt-5 pt-5 wow fadeIn"
      data-wow-delay="0.1s"
    >
      <div class="container py-5">
        <div class="row g-5">
          <!-- <div class="col-lg-3 col-md-6"> -->
          <h5 class="text-white mb-4">한국 대표 관광지 사진</h5>
          <div class="row g-2">
            <div class="col-2">
              <img
                class="img-fluid rounded"
                src="https://www.visitbusan.net/uploadImgs/files/cntnts/20191229153531987_oen"
                alt=""
              />
            </div>
            <div class="col-2">
              <img
                class="img-fluid rounded"
                src="https://www.visitbusan.net/uploadImgs/files/cntnts/20220808115019607_wufrotr"
                alt=""
              />
            </div>
            <div class="col-2">
              <img
                class="img-fluid rounded"
                src="https://www.visitbusan.net/uploadImgs/files/cntnts/20200717114921495_oen"
                alt=""
              />
            </div>
            <div class="col-2">
              <img
                class="img-fluid rounded"
                src="https://www.visitbusan.net/uploadImgs/files/cntnts/20191229142305192_oen"
                alt=""
              />
            </div>
            <div class="col-2">
              <img
                class="img-fluid rounded"
                src="https://www.visitbusan.net/uploadImgs/files/cntnts/20191229160530047_oen"
                alt=""
              />
            </div>
            <div class="col-2">
              <img
                class="img-fluid rounded"
                src="https://www.visitbusan.net/uploadImgs/files/cntnts/20191231193128851_wufrotr"
                alt=""
              />
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
              Designed By <a href="https://htmlcodex.com">부울경 3반 11조 김동현, 우미경</a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Footer End -->

    <!-- login/logout success & fail message -->
    <div id="message"></div>

    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"
      ><i class="bi bi-arrow-up"></i
    ></a>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/wow/wow.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/counterup/counterup.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="lib/isotope/isotope.pkgd.min.js"></script>
    <script src="lib/lightbox/js/lightbox.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
    
  </body>
</html>

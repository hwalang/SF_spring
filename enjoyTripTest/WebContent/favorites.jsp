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

    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css"
    />

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
          <a href="index.jsp" class="nav-item nav-link">Home</a>
          <a href="board.jsp" class="nav-item nav-link">게시판</a>
          <a href="/map" class="nav-item nav-link">여행지 찾기</a>

          <!-- 개인화 페이지 -->
          <a href="favorites.jsp" id="navFavorite" class="nav-item nav-link active"
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

    <!-- Page Header Start -->
    <div class="container-fluid page-header py-5 mb-5">
      <div class="container py-5">
        <h1 class="display-3 text-white mb-3 animated slideInDown">즐겨찾기</h1>
        <nav aria-label="breadcrumb animated slideInDown">
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a class="text-white" href="#">Home</a>
            </li>
            <li class="breadcrumb-item">
              <a class="text-white" href="#">Pages</a>
            </li>
            <li class="breadcrumb-item text-white active" aria-current="page">즐겨찾기</li>
          </ol>
        </nav>
      </div>
    </div>
    <!-- Page Header End -->

    <!-- Team Start -->
    <div class="container-xxl py-5">
      <div class="container">
        <div
          class="text-center mx-auto mb-5 wow fadeInUp"
          data-wow-delay="0.1s"
          style="max-width: 600px"
        >
          <h6 class="text-primary">Fav Spots</h6>
          <h1 class="mb-4">Mark's Favorite Spots EVER!</h1>
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
          <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="team-item rounded overflow-hidden">
              <div class="d-flex">
                <img
                  class="img-fluid w-75"
                  src="https://www.visitbusan.net/uploadImgs/files/cntnts/20191229142305192_oen"
                  alt=""
                />
                <div class="team-social w-25">
                  <a class="btn btn-lg-square btn-outline-primary rounded-circle mt-3" href=""
                    ><i class="bi bi-bookmark-heart-fill"></i
                  ></a>
                </div>
              </div>
              <div class="p-4">
                <h5>감천문화마을</h5>
                <span>주소</span>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
            <div class="team-item rounded overflow-hidden">
              <div class="d-flex">
                <img
                  class="img-fluid w-75"
                  src="https://www.visitbusan.net/uploadImgs/files/cntnts/20191229160530047_oen"
                  alt=""
                />
                <div class="team-social w-25">
                  <a class="btn btn-lg-square btn-outline-primary rounded-circle mt-3" href=""
                    ><i class="bi bi-bookmark-heart-fill"></i
                  ></a>
                </div>
              </div>
              <div class="p-4">
                <h5>광안리</h5>
                <span>주소</span>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
            <div class="team-item rounded overflow-hidden">
              <div class="d-flex">
                <img
                  class="img-fluid w-75"
                  src="https://www.visitbusan.net/uploadImgs/files/cntnts/20191231193128851_wufrotr"
                  alt=""
                />
                <div class="team-social w-25">
                  <a class="btn btn-lg-square btn-outline-primary rounded-circle mt-3" href=""
                    ><i class="bi bi-bookmark-heart-fill"></i
                  ></a>
                </div>
              </div>
              <div class="p-4">
                <h5>선암사</h5>
                <span>주소</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Team End -->

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

    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"
      ><i class="bi bi-arrow-up"></i
    ></a>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/wow/wow.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/counterup/counterup.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="lib/isotope/isotope.pkgd.min.js"></script>
    <script src="lib/lightbox/js/lightbox.min.js"></script>
    <!-- 주석처리 하지 않으면 jquery와 충돌이 발생해서 mai.js에 있는 이벤트를 사용할 수 없다. -->
    <!-- <script
      type="text/javascript"
      src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"
    ></script> -->

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
  </body>
</html>

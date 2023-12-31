<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="user.dto.UserDto, main.dto.SidoDto, main.dto.GugunDto, java.util.List"%>
<%
	// DB ACCESS
	// 뿌려줄 데이터를 추출 후 body에서 적절하게 사용 가능
	// List<StudentDto> studentList = (List<StudentDto>) request.getAttribute("studentList"); 

	UserDto userDto = (UserDto) session.getAttribute("userDto");
	List<SidoDto> sidoList = (List<SidoDto>) request.getAttribute("sidoList");
	List<GugunDto> gugunList = (List<GugunDto>) request.getAttribute("gugunList");
%>

<!DOCTYPE html>
<html lang="en">
<head>

<%@ include file="include/header.jsp" %>

</head>

<%@ include file="include/navbar.jsp"%>

<div class="hero">
	<div class="container">
		<div class="row align-items-center">
			<div class="col-lg-7">
				<div class="intro-wrap">
					<h1 class="mb-4">
						<span class="d-block">여행을 계획해볼까요?</span> <span class="typed-words"></span>는
						어떠세요?
					</h1>

					<div class="row">
						<div class="col-12">
							<form class="form">
								<div class="row mb-2">
									<div class="col-sm-12 col-md-6 mb-3 mb-lg-0 col-lg-4">
								 		<select name id="area1List" class="form-control custom-select">  
								 			<option value="">시도</option>
											<%
												System.out.println("sidoList(main.jsp): "+sidoList);
											    for(SidoDto dto: sidoList) {    
											%>
											    <option value = "<%= dto.getSidoCode() %>"> <%= dto.getSidoName() %> </option>
											<%
											    }
											%>
										</select>
									</div>
									<div class="col-sm-12 col-md-6 mb-3 mb-lg-0 col-lg-4">
								 		<select name id="area2List" class="form-control custom-select">  
								 			<option value="">구군</option>
										</select>
									</div>
									<div class="row align-items-center">
										<div class="col-sm-12 col-md-6 mb-3 mb-lg-0 col-lg-4">
										<button id="btnSearch" type="button" class="btn btn-primary">Search</button>
										<!-- <input type="submit" class="btn btn-primary btn-block" value="Search" /> -->
									</div>
									<!-- <div class="col-sm-12 col-md-6 mb-3 mb-lg-0 col-lg-5">
										<input type="text" class="form-control" name="daterange" />
									</div>
									<div class="col-sm-12 col-md-6 mb-3 mb-lg-0 col-lg-3">
										<input type="text" class="form-control"
											placeholder="# of People" />
									</div> -->
								</div>
								
									<!-- <div class="col-lg-8"> -->
									<!-- <label class="control control--checkbox mt-3"> -->
									<!-- <span class="caption">Save this search</span> -->
									<!-- <input type="checkbox" checked="checked" /> -->
									<!-- <div class="control__indicator"></div> -->
									<!-- </label> -->
									<!-- </div> -->
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-5">
				<div class="slides">
					<img src="images/hero-slider-1.jpg" alt="Image"
						class="img-fluid active" /> <img src="images/hero-slider-2.jpg"
						alt="Image" class="img-fluid" /> <img
						src="images/hero-slider-3.jpg" alt="Image" class="img-fluid" /> <img
						src="images/hero-slider-4.jpg" alt="Image" class="img-fluid" /> <img
						src="images/hero-slider-5.jpg" alt="Image" class="img-fluid" /> <img
						src="images/hero-slider-5.jpg" alt="Image" class="img-fluid" />
				</div>
			</div>
		</div>
	</div>
</div>

<div class="untree_co-section">
	<div class="container">
		<div class="row mb-5 justify-content-center">
			<div class="col-lg-6 text-center">
				<h2 class="section-title text-center mb-3">Our Services</h2>
				<p>Far far away, behind the word mountains, far from the
					countries Vokalia and Consonantia, there live the blind texts.
					Separated they live in Bookmarksgrove right at the coast of the
					Semantics, a large language ocean.</p>
			</div>
		</div>
		<div class="row align-items-stretch">
			<div class="col-lg-4 order-lg-1">
				<div class="h-100">
					<div class="frame h-100">
						<div class="feature-img-bg h-100"
							style="background-image: url('images/hero-slider-1.jpg')"></div>
					</div>
				</div>
			</div>

			<div
				class="col-6 col-sm-6 col-lg-4 feature-1-wrap d-md-flex flex-md-column order-lg-1">
				<div class="feature-1 d-md-flex">
					<div class="align-self-center">
						<span class="flaticon-house display-4 text-primary"></span>
						<h3>Beautiful Condo</h3>
						<p class="mb-0">Even the all-powerful Pointing has no control
							about the blind texts.</p>
					</div>
				</div>

				<div class="feature-1">
					<div class="align-self-center">
						<span class="flaticon-restaurant display-4 text-primary"></span>
						<h3>Restaurants & Cafe</h3>
						<p class="mb-0">Even the all-powerful Pointing has no control
							about the blind texts.</p>
					</div>
				</div>
			</div>

			<div
				class="col-6 col-sm-6 col-lg-4 feature-1-wrap d-md-flex flex-md-column order-lg-3">
				<div class="feature-1 d-md-flex">
					<div class="align-self-center">
						<span class="flaticon-mail display-4 text-primary"></span>
						<h3>Easy to Connect</h3>
						<p class="mb-0">Even the all-powerful Pointing has no control
							about the blind texts.</p>
					</div>
				</div>

				<div class="feature-1 d-md-flex">
					<div class="align-self-center">
						<span class="flaticon-phone-call display-4 text-primary"></span>
						<h3>24/7 Support</h3>
						<p class="mb-0">Even the all-powerful Pointing has no control
							about the blind texts.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="untree_co-section count-numbers py-5">
	<div class="container">
		<div class="row">
			<div class="col-6 col-sm-6 col-md-6 col-lg-3">
				<div class="counter-wrap">
					<div class="counter">
						<span class data-number="9313">0</span>
					</div>
					<span class="caption">No. of Travels</span>
				</div>
			</div>
			<div class="col-6 col-sm-6 col-md-6 col-lg-3">
				<div class="counter-wrap">
					<div class="counter">
						<span class data-number="8492">0</span>
					</div>
					<span class="caption">No. of Clients</span>
				</div>
			</div>
			<div class="col-6 col-sm-6 col-md-6 col-lg-3">
				<div class="counter-wrap">
					<div class="counter">
						<span class data-number="100">0</span>
					</div>
					<span class="caption">No. of Employees</span>
				</div>
			</div>
			<div class="col-6 col-sm-6 col-md-6 col-lg-3">
				<div class="counter-wrap">
					<div class="counter">
						<span class data-number="120">0</span>
					</div>
					<span class="caption">No. of Countries</span>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="untree_co-section">
	<div class="container">
		<div class="row text-center justify-content-center mb-5">
			<div class="col-lg-7">
				<h2 class="section-title text-center">Popular Destination</h2>
			</div>
		</div>

		<div class="owl-carousel owl-3-slider">
			<div class="item">
				<a class="media-thumb" href="images/hero-slider-1.jpg"
					data-fancybox="gallery">
					<div class="media-text">
						<h3>Pragser Wildsee</h3>
						<span class="location">Italy</span>
					</div> <img src="images/hero-slider-1.jpg" alt="Image" class="img-fluid" />
				</a>
			</div>

			<div class="item">
				<a class="media-thumb" href="images/hero-slider-2.jpg"
					data-fancybox="gallery">
					<div class="media-text">
						<h3>Oia</h3>
						<span class="location">Greece</span>
					</div> <img src="images/hero-slider-2.jpg" alt="Image" class="img-fluid" />
				</a>
			</div>

			<div class="item">
				<a class="media-thumb" href="images/hero-slider-3.jpg"
					data-fancybox="gallery">
					<div class="media-text">
						<h3>Perhentian Islands</h3>
						<span class="location">Malaysia</span>
					</div> <img src="images/hero-slider-3.jpg" alt="Image" class="img-fluid" />
				</a>
			</div>

			<div class="item">
				<a class="media-thumb" href="images/hero-slider-4.jpg"
					data-fancybox="gallery">
					<div class="media-text">
						<h3>Rialto Bridge</h3>
						<span class="location">Italy</span>
					</div> <img src="images/hero-slider-4.jpg" alt="Image" class="img-fluid" />
				</a>
			</div>

			<div class="item">
				<a class="media-thumb" href="images/hero-slider-5.jpg"
					data-fancybox="gallery">
					<div class="media-text">
						<h3>San Francisco, United States</h3>
						<span class="location">United States</span>
					</div> <img src="images/hero-slider-5.jpg" alt="Image" class="img-fluid" />
				</a>
			</div>

			<div class="item">
				<a class="media-thumb" href="images/hero-slider-1.jpg"
					data-fancybox="gallery">
					<div class="media-text">
						<h3>Lake Thun</h3>
						<span class="location">Switzerland</span>
					</div> <img src="images/hero-slider-2.jpg" alt="Image" class="img-fluid" />
				</a>
			</div>
		</div>
	</div>
</div>

<div class="untree_co-section testimonial-section mt-5">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-7 text-center">
				<h2 class="section-title text-center mb-5">Testimonials</h2>

				<div class="owl-single owl-carousel no-nav">
					<div class="testimonial mx-auto">
						<figure class="img-wrap">
							<img src="images/person_2.jpg" alt="Image" class="img-fluid" />
						</figure>
						<h3 class="name">Adam Aderson</h3>
						<blockquote>
							<p>&ldquo;There live the blind texts. Separated they live in
								Bookmarksgrove right at the coast of the Semantics, a large
								language ocean.&rdquo;</p>
						</blockquote>
					</div>

					<div class="testimonial mx-auto">
						<figure class="img-wrap">
							<img src="images/person_3.jpg" alt="Image" class="img-fluid" />
						</figure>
						<h3 class="name">Lukas Devlin</h3>
						<blockquote>
							<p>&ldquo;There live the blind texts. Separated they live in
								Bookmarksgrove right at the coast of the Semantics, a large
								language ocean.&rdquo;</p>
						</blockquote>
					</div>

					<div class="testimonial mx-auto">
						<figure class="img-wrap">
							<img src="images/person_4.jpg" alt="Image" class="img-fluid" />
						</figure>
						<h3 class="name">Kayla Bryant</h3>
						<blockquote>
							<p>&ldquo;There live the blind texts. Separated they live in
								Bookmarksgrove right at the coast of the Semantics, a large
								language ocean.&rdquo;</p>
						</blockquote>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="untree_co-section">
	<div class="container">
		<div class="row justify-content-center text-center mb-5">
			<div class="col-lg-6">
				<h2 class="section-title text-center mb-3">Special Offers &amp;
					Discounts</h2>
				<p>Far far away, behind the word mountains, far from the
					countries Vokalia and Consonantia, there live the blind texts.
					Separated they live in Bookmarksgrove right at the coast of the
					Semantics, a large language ocean.</p>
			</div>
		</div>
		<div class="row">
			<div class="col-6 col-sm-6 col-md-6 col-lg-3 mb-4 mb-lg-0">
				<div class="media-1">
					<a href="#" class="d-block mb-3"><img
						src="images/hero-slider-1.jpg" alt="Image" class="img-fluid" /></a> <span
						class="d-flex align-items-center loc mb-2"> <span
						class="icon-room mr-3"></span> <span>Italy</span>
					</span>
					<div class="d-flex align-items-center">
						<div>
							<h3>
								<a href="#">Rialto Mountains</a>
							</h3>
							<div class="price ml-auto">
								<span>$520.00</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-6 col-sm-6 col-md-6 col-lg-3 mb-4 mb-lg-0">
				<div class="media-1">
					<a href="#" class="d-block mb-3"><img
						src="images/hero-slider-2.jpg" alt="Image" class="img-fluid" /></a> <span
						class="d-flex align-items-center loc mb-2"> <span
						class="icon-room mr-3"></span> <span>United States</span>
					</span>
					<div class="d-flex align-items-center">
						<div>
							<h3>
								<a href="#">San Francisco</a>
							</h3>
							<div class="price ml-auto">
								<span>$520.00</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-6 col-sm-6 col-md-6 col-lg-3 mb-4 mb-lg-0">
				<div class="media-1">
					<a href="#" class="d-block mb-3"><img
						src="images/hero-slider-3.jpg" alt="Image" class="img-fluid" /></a> <span
						class="d-flex align-items-center loc mb-2"> <span
						class="icon-room mr-3"></span> <span>Malaysia</span>
					</span>
					<div class="d-flex align-items-center">
						<div>
							<h3>
								<a href="#">Perhentian Islands</a>
							</h3>
							<div class="price ml-auto">
								<span>$750.00</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-6 col-sm-6 col-md-6 col-lg-3 mb-4 mb-lg-0">
				<div class="media-1">
					<a href="#" class="d-block mb-3"><img
						src="images/hero-slider-4.jpg" alt="Image" class="img-fluid" /></a> <span
						class="d-flex align-items-center loc mb-2"> <span
						class="icon-room mr-3"></span> <span>Switzerland</span>
					</span>

					<div class="d-flex align-items-center">
						<div>
							<h3>
								<a href="#">Lake Thun</a>
							</h3>
							<div class="price ml-auto">
								<span>$520.00</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="untree_co-section">
	<div class="container">
		<div class="row justify-content-between align-items-center">
			<div class="col-lg-6">
				<figure class="img-play-video">
					<a id="play-video" class="video-play-button"
						href="https://www.youtube.com/watch?v=mwtbEGNABWU" data-fancybox>
						<span></span>
					</a>
					<img src="images/hero-slider-2.jpg" alt="Image"
						class="img-fluid rounded-20" />
				</figure>
			</div>

			<div class="col-lg-5">
				<h2 class="section-title text-left mb-4">Take a look at Tour
					Video</h2>
				<p>Far far away, behind the word mountains, far from the
					countries Vokalia and Consonantia, there live the blind texts.
					Separated they live in Bookmarksgrove right at the coast of the
					Semantics, a large language ocean.</p>

				<p class="mb-4">A small river named Duden flows by their place
					and supplies it with the necessary regelialia. It is a
					paradisematic country, in which roasted parts of sentences fly into
					your mouth.</p>

				<ul class="list-unstyled two-col clearfix">
					<li>Outdoor recreation activities</li>
					<li>Airlines</li>
					<li>Car Rentals</li>
					<li>Cruise Lines</li>
					<li>Hotels</li>
					<li>Railways</li>
					<li>Travel Insurance</li>
					<li>Package Tours</li>
					<li>Insurance</li>
					<li>Guide Books</li>
				</ul>

				<p>
					<a href="#" class="btn btn-primary">Get Started</a>
				</p>
			</div>
		</div>
	</div>
</div>

<div class="py-5 cta-section">
	<div class="container">
		<div class="row text-center">
			<div class="col-md-12">
				<h2 class="mb-2 text-white">Lets you Explore the Best. Contact
					Us Now</h2>
				<p class="mb-4 lead text-white text-white-opacity">Lorem ipsum
					dolor sit amet, consectetur adipisicing elit. Excepturi, fugit?</p>
				<p class="mb-0">
					<a href="booking.html"
						class="btn btn-outline-white text-white btn-md font-weight-bold">Get
						in touch</a>
				</p>
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
<script>
      $(function () {
        var slides = $(".slides"),
          images = slides.find("img");

        images.each(function (i) {
          $(this).attr("data-id", i + 1);
        });

        var typed = new Typed(".typed-words", {
          strings: [" 제주", " 대구", " 경주", " 강원도", " 대전", " 부산"],
          typeSpeed: 80,
          backSpeed: 80,
          backDelay: 4000,
          startDelay: 1000,
          loop: true,
          showCursor: true,
          preStringTyped: (arrayPos, self) => {
            arrayPos++;
            //console.log(arrayPos);
            $(".slides img").removeClass("active");
            $('.slides img[data-id="' + arrayPos + '"]').addClass("active");
          },
        });
      });
</script>

<script type="text/javascript">
	window.onload = function(){
		document.querySelector("#area1List").onchange = selectGugun;
		document.querySelector("#btnSearch").onclick = searchOnMap;
		
		async function searchOnMap(){
	        // 사용자가 입력한 파라미터 준비
	        // 백엔드 url 요청 - fetch post
	        // 결과 : json
	        // 성공 / 실패

	        let sido = document.querySelector("#area1List").value;
	        let gugun = document.querySelector("#area2List").value;

	        let urlParams = new URLSearchParams({
	            job: 'searchMap',
	            sido: sido,
	            gugun: gugun
	        });

	        let fetchOptions = {
	            method: "POST",
	            body: urlParams
	        }
	        let response = await fetch("/searchMap", fetchOptions);
	        let data = await response.json();
	        console.log(data);
	        
	        if (data.result == "success"){
	        	window.location.href="/main";
	        } else if (data.result == "fail"){
	        	alert("아이디 또는 비밀번호가 틀렸습니다.");
	        }
		}
		
		async function selectGugun(){
			
    		// 선택한 시도 정보를 받는다.
    	    let selectSidoCode = document.querySelector("#area1List").value;
    	    console.log(selectSidoCode);

    	    let response = await fetch(`/map?action=gugun&select=` + selectSidoCode);
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
	}
</script>

<script src="js/custom.js"></script>
</body>
</html>

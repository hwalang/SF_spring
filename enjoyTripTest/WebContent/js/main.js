(function($) {
	"use strict";

	// Spinner
	var spinner = function() {
		setTimeout(function() {
			if ($("#spinner").length > 0) {
				$("#spinner").removeClass("show");
			}
		}, 1);
	};
	spinner();

	// Initiate the wowjs
	new WOW().init();

	// Sticky Navbar
	$(window).scroll(function() {
		if ($(this).scrollTop() > 300) {
			$(".sticky-top").addClass("shadow-sm").css("top", "0px");
		} else {
			$(".sticky-top").removeClass("shadow-sm").css("top", "-100px");
		}
	});

	// Back to top button
	$(window).scroll(function() {
		if ($(this).scrollTop() > 300) {
			$(".back-to-top").fadeIn("slow");
		} else {
			$(".back-to-top").fadeOut("slow");
		}
	});
	$(".back-to-top").click(function() {
		$("html, body").animate({
			scrollTop : 0
		}, 1500, "easeInOutExpo");
		return false;
	});

	// Facts counter
	$('[data-toggle="counter-up"]').counterUp({
		delay : 10,
		time : 2000,
	});

	// Header carousel
	$(".header-carousel").owlCarousel({
		autoplay : true,
		smartSpeed : 1500,
		loop : true,
		nav : false,
		dots : true,
		items : 1,
		dotsData : true,
	});

	// Testimonials carousel
	$(".testimonial-carousel").owlCarousel(
			{
				autoplay : true,
				smartSpeed : 1000,
				center : true,
				dots : false,
				loop : true,
				nav : true,
				navText : [ '<i class="bi bi-arrow-left"></i>',
						'<i class="bi bi-arrow-right"></i>' ],
				responsive : {
					0 : {
						items : 1,
					},
					768 : {
						items : 2,
					},
				},
			});

	// Portfolio isotope and filter
	var portfolioIsotope = $(".portfolio-container").isotope({
		itemSelector : ".portfolio-item",
		layoutMode : "fitRows",
	});
	$("#portfolio-flters li").on("click", function() {
		$("#portfolio-flters li").removeClass("active");
		$(this).addClass("active");

		portfolioIsotope.isotope({
			filter : $(this).data("filter")
		});
	});
})(jQuery);

// 마이페이지 버튼 이벤트
if (document.querySelector("#btnUpdateMyPage")) {
	// 수정 버튼 이벤트
	document.querySelector("#btnUpdateMyPage").addEventListener(
			"click",
			function() {
				let modalMyPage = new bootstrap.Modal(document.querySelector("#modalByUpdateMyPage"));
				modalMyPage.show();

				// modal 수정완료 이벤트
				function updateHandler() {
					alert("수정완료!");
					modalMyPage.hide();

					// 이벤트 핸들러 제거
					document.querySelector("#btnUpdate").removeEventListener("click", updateHandler);
				}

				document.querySelector("#btnUpdate").addEventListener("click",updateHandler);
			});

	// 회원탈퇴 이벤트
	document.querySelector("#cancelMember").addEventListener("click",
		function() {
			alert("회원 탈퇴!");
		});
}

// 로그인 기능들
// 로그인 버튼 -> 로그인 창 띄우기
// 로그인 창 -> 비밀번호 찾기 | 회원가입 | 로그인
// 로그인 이벤트 등록
if (document.querySelector("#navLogin") != null) {
	document.querySelector("#navLogin").addEventListener("click", function() {
		showModal();
	});
}

// 비밀번호찾기:
function showModal() {
	let modalByJs = new bootstrap.Modal(document.querySelector("#modalByJs"));
	modalByJs.show();

	// btn-close 이벤트시 modal창 닫기
	// document.querySelector("#btn-login-close").addEventListener("click",
	// function () {
	// modalByJs.hide();
	// });

	// modal에서 로그인 버튼을 누르면 로그인했다고 가정하고 페이지를 새로고침
	// 1. 로그인 버튼 숨기기 | 로그아웃 보이기
	// 2. 즐겨찾기 및 마이페이지 보이기
	function login() {
		document.querySelector("#btnLogin").addEventListener(
				"click",
				function() {
					console.log("로그인 버튼 클릭");
					// login -> logout
//					document.querySelector("#navLogin").classList
//							.add("visually-hidden");
//					document.querySelector("#navLogout").classList
//							.remove("visually-hidden");
//					document.querySelector("#navFavorite").classList
//							.remove("visually-hidden");
//					document.querySelector("#navMyPage").classList
//							.remove("visually-hidden");

					console.log("로그인 버튼 숨기고 로그아웃 버튼 보이기");

					modalByJs.hide();
					document.querySelector("#btnLogin").removeEventListener(
							"click", login);
					console.log("로그인 이벤트 해제");
				});

	}
	console.log("로그인 이벤트 등록");
	document.querySelector("#btnLogin").addEventListener("click", login);

	// document.querySelector("#btnLogin").addEventListener("click", function ()
	// {
	// console.log("로그인 버튼 클릭");
	// // login -> logout
	// document.querySelector("#navLogin").classList.add("visually-hidden");
	// document.querySelector("#navLogout").classList.remove("visually-hidden");
	// document.querySelector("#navFavorite").classList.remove("visually-hidden");
	// document.querySelector("#navMyPage").classList.remove("visually-hidden");
	//
	// console.log("로그인 버튼 숨기고 로그아웃 버튼 보이기");
	//    
	// modalByJs.hide();
	// });

	// 회원가입 -> 새로운 modal 띄우기
	document.querySelector("#btnRegister").addEventListener(
			"click",
			function() {
				let modalRegister = new bootstrap.Modal(document
						.querySelector("#modalByRegister"));
				modalRegister.show();

				// btn-close 이벤트시 modal창 닫기
				document.querySelector("#btn-register-close").addEventListener(
						"click", function() {
							modalByJs.hide();
							modalRegister.hide();
						});

				document.querySelector("#registerCheck").addEventListener(
						"click", function() {
							// 회원 정보 DB에 보내기 전에 확인 작업
							modalRegister.hide();
							modalByJs.show();
						});
			});

}

// 로그아웃 누르면
// 1. 로그인 버튼 보이고 로그아웃 버튼 숨기기
// 2. 마이페이지 숨기기
// 3. 즐겨찾기 숨기기
// document.querySelector("#navLogout").addEventListener("click", function () {
// // login -> logout
// document.querySelector("#navLogin").classList.remove("visually-hidden");
// document.querySelector("#navLogout").classList.add("visually-hidden");
//
// document.querySelector("#navMyPage").classList.add("visually-hidden");
// document.querySelector("#navFavorite").classList.add("visually-hidden");
// });


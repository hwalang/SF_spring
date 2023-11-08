<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dto.UserDto, java.util.*, board.dto.*"%>
<%
	UserDto userDto = (UserDto) session.getAttribute("userDto");
%>
<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/alertify.min.js"></script>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/alertify.min.css" />
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/themes/default.min.css" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>한국 관광 페이지 게시판</title>
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
          <a href="board.jsp" class="nav-item nav-link active">게시판</a>
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
} else {   // 로그인하지 않은 상태
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
          <a href="board.jsp" class="nav-item nav-link active">게시판</a>
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
                 <input type="hidden" value="board" name="path"><br>
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
			<h1 class="display-3 text-white mb-3 animated slideInDown">게시판</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a class="text-white" href="#">Home</a>
					</li>
					<li class="breadcrumb-item"><a class="text-white" href="#">Pages</a>
					</li>
					<li class="breadcrumb-item text-white active" aria-current="page">게시판</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->

	<div class="container-xxl py-5">
		<div class="container">
			<div class="text-center mx-auto mb-5 wow" style="max-width: 900px">
				<!-- <div class="container mt-3"> -->
				<!-- mt-3 추가 -->

				<h6 class="text-primary">게시판</h6>
				<h1 class="mb-4">What Our Clients Say!</h1>

				<div class="input-group mb-3 mt-3">
					<!-- mb-3 mt-3  추가 -->
					<input id="inputSearchWord" type="text" class="form-control"
						placeholder="Search">
					<button id="btnSearchWord" class="btn btn-success" type="button">Search</button>
				</div>

				<table class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일시</th>
						</tr>
					</thead>
					<tbody id="boardTbody">
					</tbody>
				</table>

				<div id="paginationWrapper"></div>

				<button class="btn btn-sm btn-primary" id="btnBoardInsertUI" style="float: right">글쓰기</button>
			</div>
		</div>
	</div>


	<!-- modal begin ------------------------------------------------------------------------->

	<!-- Modal insert-->
	<div class="modal fade" id="boardInsertModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">글 쓰기</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">

					<div class="mb-3">
						<label for="titleInsert" class="form-label">제목</label> <input
							type="text" class="form-control" id="titleInsert">
					</div>
					<div class="mb-3">
						<label for="contentInsert" class="form-label">내용</label>
						<textarea class="form-control" id="contentInsert" rows="5"></textarea>
					</div>
					<button id="btnBoardInsert"
						class="btn btn-sm btn-primary btn-outline float-end"
						data-bs-dismiss="modal" type="button">등록</button>

				</div>
			</div>
		</div>
	</div>
	<!-- End Modal -->

	<!-- Modal detail-->
	<div class="modal fade" id="boardDetailModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">글 상세</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">

					<table class="table">
						<tbody>
							<tr>
								<td>글번호</td>
								<td id="boardIdDetail">#</td>
							</tr>
							<tr>
								<td>제목</td>
								<td id="titleDetail">#</td>
							</tr>
							<tr>
								<td>내용</td>
								<td id="contentDetail">#</td>
							</tr>
							<tr>
								<td>작성자</td>
								<td id="userNameDetail">#</td>
							</tr>
							<tr>
								<td>작성일시</td>
								<td id="regDtDetail">#</td>
							</tr>
						</tbody>
					</table>
					<button id="btnBoardUpdateUI"
						class="btn btn-sm btn-primary btn-outline" data-bs-dismiss="modal"
						type="button">글 수정하기</button>
					<button id="btnBoardDeleteUI"
						class="btn btn-sm btn-warning btn-outline" data-bs-dismiss="modal"
						type="button">글 삭제하기</button>

				</div>
			</div>
		</div>
	</div>
	<!-- End Modal -->

	<!-- Modal update-->
	<div class="modal fade" id="boardUpdateModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">글 수정</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">

					<div class="mb-3">
						<label for="titleUpdate" class="form-label">제목</label> <input
							type="text" class="form-control" id="titleUpdate">
					</div>
					<div class="mb-3">
						<label for="contentUpdate" class="form-label">내용</label>
						<textarea class="form-control" id="contentUpdate" rows="5"></textarea>
					</div>
					<button id="btnBoardUpdate"
						class="btn btn-sm btn-primary btn-outline float-end"
						data-bs-dismiss="modal" type="button">수정</button>

				</div>
			</div>
		</div>
	</div>
	<!-- End Modal -->
	<!-- modal end --------------------------------------------------------------------------->

	<script>

var LIST_ROW_COUNT = 10;    //limit
var OFFSET = 0;   // limit 10 offet 10
var SEARCH_WORD = "";

var PAGE_LINK_COUNT = 10;    // pagination link 갯수
var TOTAL_LIST_ITEM_COUNT = 0;
var CURRENT_PAGE_INDEX = 1;

window.onload = function(){

    boardList();

    // 검색어 검색 
    document.querySelector("#btnSearchWord").onclick = function(){

        SEARCH_WORD = document.querySelector("#inputSearchWord").value;
        // 처음 페이지로 초기화
        OFFSET = 0;
        CURRENT_PAGE_INDEX = 1;

        boardList();
    }


    // 글 등록 모달
    document.querySelector("#btnBoardInsertUI").onclick = function(){

        document.querySelector("#titleInsert").value = "";
        document.querySelector("#contentInsert").value = "";

        let modal = new bootstrap.Modal(document.querySelector("#boardInsertModal"));
        modal.show();
    };

    // 글 등록
    document.querySelector("#btnBoardInsert").onclick = function(){

        if( validateInsert() ){
            boardInsert();
        }
    }

    // 글 수정 모달
    document.querySelector("#btnBoardUpdateUI").onclick = function(){

        var boardId = document.querySelector("#boardDetailModal").getAttribute("data-boardId");
        document.querySelector("#boardUpdateModal").setAttribute("data-boardId", boardId);

        document.querySelector("#titleUpdate").value = document.querySelector("#titleDetail").innerHTML;
        document.querySelector("#contentUpdate").value = document.querySelector("#contentDetail").innerHTML;

        let detailModal = new bootstrap.Modal( document.querySelector("#boardDetailModal") );
        detailModal.hide();
        let updatelModal = new bootstrap.Modal( document.querySelector("#boardUpdateModal") );
        updatelModal.show();
    };

    // 글 수정
    document.querySelector("#btnBoardUpdate").onclick = function(){

        if( validateUpdate() ){
            boardUpdate();
        }
    };

    // 글 삭제
    document.querySelector("#btnBoardDeleteUI").onclick = function(){
         alertify.confirm('삭제 확인', '이 글을 삭제하시겠습니까?',
             function() {
                boardDelete();
             },
            function(){
                 console.log('cancel');
            }
        );
    };

    // logout
};

async function boardList(){
	console.log("boardList 들어오니?")
    let url = '/board/boardList';
    let urlParams = '?limit=' + LIST_ROW_COUNT + '&offset=' + OFFSET + "&searchWord=" + SEARCH_WORD;

    try{
        let response = await fetch(url + urlParams);
        let data = await response.json();
        makeListHtml(data);

    }catch(error){
        console.log(error);
        alertify.error('글 조회 과정에 문제가 생겼습니다.');
    }

}

function makeListHtml(list){

    console.log('jsps makeListHtml: '+list);

    let listHTML = ``;
    console.log(list.length);

    list.forEach( el => {
        let boardId = el.board_id;
        let userName = el.user_name;
        console.log(userName);
        let title = el.board_title;
        let content = el.board_content;
        let regDtStr = el.board_createtime;    // javascript of parsed from LocalDateTime
        regDtStr = regDtStr.substr(0,10);
        console.log(regDtStr);
        //let regDtStr = makeDateStr(regDt.date.year, regDt.date.month, regDt.date.day, '.');

        listHTML +=
            `<tr style="cursor:pointer" data-boardId=\${boardId}><td>\${boardId}</td><td>\${title}</td><td>\${userName}</td>
                <td>\${regDtStr}</td></tr>`;

    } );

    document.querySelector("#boardTbody").innerHTML = listHTML;


    makeListHtmlEventHandler();

    boardListTotalCnt();
}

function makeListHtmlEventHandler(){
    document.querySelectorAll("#boardTbody tr").forEach( el => {
        el.onclick = function(){
            var boardId = this.getAttribute("data-boardId");
            boardDetail(boardId);
        }
    });
}

async function boardListTotalCnt(){
    let url = '/board/boardListTotalCnt';
    let urlParams = '?searchWord=' + SEARCH_WORD;

    try{
        let response = await fetch(url + urlParams);
        let data = await response.json();
        TOTAL_LIST_ITEM_COUNT = data.totalCnt;
        makePaginationHtml(LIST_ROW_COUNT, PAGE_LINK_COUNT, CURRENT_PAGE_INDEX, TOTAL_LIST_ITEM_COUNT, "paginationWrapper" );

    }catch(error){
        console.log(error);
        alertify.error('글 전체 수 조회 과정에 문제가 생겼습니다.');
    }
}

function movePage(pageIndex){
    OFFSET = (pageIndex - 1) * LIST_ROW_COUNT;
    CURRENT_PAGE_INDEX = pageIndex;
    boardList();
}

//htmlt      argetId 어느 html에 사영해줄지
function makePaginationHtml(listRowCount, pageLinkCount, currentPageIndex,
		totalListItemCount, htmlTargetId) {

	var targetUI = document.querySelector("#" + htmlTargetId);

	var pageCount = Math.ceil(totalListItemCount / listRowCount);

	var startPageIndex = 0;
	if ((currentPageIndex % pageLinkCount) == 0) { // 10, 20...맨마지막
		// 현재 페이지 index가 20 일 때, 11로
		// 20 - 10 => 10, 10 + 1 => 11
		startPageIndex = currentPageIndex - pageLinkCount + 1;
	} else {
		// 현재 페이지 index가 23 일 때, 21로
		// 23 / 10 => 2.3 => 2, 2*10 => 20, 20+1 => 21
		startPageIndex = Math.floor(currentPageIndex / pageLinkCount)
				* pageLinkCount + 1
	}

	var endPageIndex = 0;
	if ((currentPageIndex % pageLinkCount) == 0) { // 10, 20...맨마지막
		endPageIndex = currentPageIndex;
	} else {
		endPageIndex = Math.floor(currentPageIndex / pageLinkCount)
				* pageLinkCount + pageLinkCount;
	}

	var prev;
	if (currentPageIndex <= pageLinkCount) {
		prev = false;
	} else {
		prev = true;
	}

	var next;
	// 127 건 / 10 => 12.7 => 13 <-- pageCount
	// 위 계산이 13 보다 크면 13으로
	if (endPageIndex > pageCount) {
		endPageIndex = pageCount
		next = false;
	} else {
		next = true;
	}

	var paginationHtml = '<ul class="pagination justify-content-center">';
	if (prev) {
		paginationHtml += '<li class="page-item">'
				+ '<a class="page-link" href="javascript:movePage('
				+ (startPageIndex - 1) + ')" aria-label="Previous">'
				+ '<span aria-hidden="true">&laquo;</span>' + '</a>' + '</li>';
	}

	for (var i = startPageIndex; i <= endPageIndex; i++) {

		if (i == currentPageIndex) {
			paginationHtml += '<li class="page-item active"><a class="page-link" href="javascript:movePage('
					+ i + ')">' + i + '</a></li>';
		} else {
			paginationHtml += '<li class="page-item"><a class="page-link" href="javascript:movePage('
					+ i + ')">' + i + '</a></li>';
		}
	}

	if (next) {
		paginationHtml += '<li class="page-item">'
				+ '<a class="page-link" href="javascript:movePage('
				+ (endPageIndex + 1) + ')" aria-label="Next">'
				+ '<span aria-hidden="true">&raquo;</span>' + '</a>' + '</li>';
	}

	paginationHtml += '</ul>';

	targetUI.innerHTML = paginationHtml;
}

// insert
function validateInsert(){
    var isTitleInsertValid = false;
    var isContentInsertValid = false;

    var titleInsertValue = document.querySelector("#titleInsert").value;
    if( titleInsertValue.length > 0 ){
        isTitleInsertValid = true;
    }

    var contentInsertValue = document.querySelector("#contentInsert").value;
    if( contentInsertValue.length > 0 ){
        isContentInsertValid = true;
    }

    if(    isTitleInsertValid && isContentInsertValid ){
        return true;
    }else{
        return false;
    }
}

async function boardInsert(){

    let title = document.querySelector("#titleInsert").value;
    let content = document.querySelector("#contentInsert").value;

    let urlParams = new URLSearchParams({
        title: title,
        content: content,
    });

    let fetchOptions = {
        method: "POST",
        body: urlParams,
    }

    let url = '/board/boardInsert';

    try{
        let response = await fetch(url, fetchOptions );
        let data = await response.json();
        console.log(data.result);
        if( data.result == "success" ){ // 백엔드 로그인 필터에서 session timeout 이 발생하면 내려주는 json 값
            alertify.success('글이 등록되었습니다.');
            boardList();
        }else{
            alertify.error('글 등록 과젱에 문제가 있습니다.')
        }
    }catch( error ){
        console.error( error );
        alertify.error('글 등록 과젱에 문제가 있습니다.')
    }
}


//detail
async function boardDetail(boardId){

    var url = '/board/boardDetail';
    var urlParams = '?boardId=' + boardId;

    try{
        let response = await fetch(url + urlParams);
        let data = await response.json();
        console.log('jsps boardDetail: '+data);
        makeDetailHtml(data);
    }catch( error ){
        console.error( error );
        alertify.error("글 조회과정에 문제가 생겼습니다.");
    }
}

function makeDetailHtml(detail){
    console.log('jsps makeDetailHtml: '+detail);
    var boardId = detail.board_id;
    var userSeq = detail.userSeq;
    var userName = detail.board_writername;
    var title = detail.board_title;
    var content = detail.board_content;
    var regDtStr = detail.board_createtime;
    console.log(regDtStr);

    var sameUser = detail.sameUser;
    var fileList = detail.fileList;

    document.querySelector("#boardDetailModal").setAttribute("data-boardId", boardId);
    document.querySelector("#boardIdDetail").innerHTML = "#" + boardId;
    document.querySelector("#titleDetail").innerHTML = title;
    document.querySelector("#contentDetail").innerHTML = content;
    document.querySelector("#userNameDetail").innerHTML = userName;
    document.querySelector("#regDtDetail").innerHTML = regDtStr;

    if( sameUser ){
        document.querySelector("#btnBoardUpdateUI").style.display = "inline-block";
        document.querySelector("#btnBoardDeleteUI").style.display = "inline-block";
    }else{
        document.querySelector("#btnBoardUpdateUI").style.display = "none";
        document.querySelector("#btnBoardDeleteUI").style.display = "none";
    }

    let modal = new bootstrap.Modal(document.querySelector("#boardDetailModal"));
    modal.show();
}

// update
function validateUpdate(){
    var isTitleUpdateValid = false;
    var isContentUpdateValid = false;

    var titleUpdate = document.querySelector("#titleUpdate").value;
    var titleUpdateLength = titleUpdate.length;

    if( titleUpdateLength > 0 ){
        isTitleUpdateValid = true;
    }

    var contentUpdateValue = document.querySelector("#contentUpdate").value;
    var contentUpdateLength = contentUpdateValue.length;

    if( contentUpdateLength > 0 ){
        isContentUpdateValid = true;
    }

    if(    isTitleUpdateValid && isContentUpdateValid ){
        return true;
    }else{
        return false;
    }
}

async function boardUpdate(){

    let boardId = document.querySelector("#boardUpdateModal").getAttribute("data-boardId");
    let title = document.querySelector("#titleUpdate").value;
    let content = document.querySelector("#contentUpdate").value;

    let urlParams = new URLSearchParams({
        boardId: boardId,
        title: title,
        content: content,
    });

    let fetchOptions = {
        method: "POST",
        body: urlParams,
    }

    let url = '/board/boardUpdate';

    try{
        let response = await fetch(url, fetchOptions );
        let data = await response.json();
        if( data.result == "success" ){
            alertify.success('글이 수정되었습니다.');
            boardList();
        }else{
            alertify.error('글 수정 과젱에 문제가 있습니다.');
        }
    }catch( error ){
        console.error( error );
        alertify.error('글 수정 과젱에 문제가 있습니다.');
    }
}

//delete
async function boardDelete(){

    var url = '/board/boardDelete';
    var urlParams = '?boardId=' + document.querySelector("#boardDetailModal").getAttribute("data-boardId");

    try{
        let response = await fetch(url + urlParams);
        let data = await response.json();

        if(data.result == "success"){
            alertify.success("글이 삭제되었습니다.");
            boardList();
        }else{
            alertify.error("글 삭제 과정에 문제가 생겼습니다.");
        }
    }catch( error ){
        console.error( error );
        alertify.error("글 삭제 과정에 문제가 생겼습니다.");
    }
}
</script>

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
	<script src="lib/lightbox/js/lightbox.min.js"></script>

	<!-- Template Javascript -->
	<script src="js/main.js"></script>
</body>
</html>

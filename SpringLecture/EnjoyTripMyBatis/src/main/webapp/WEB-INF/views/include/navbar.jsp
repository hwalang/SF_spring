<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- User를 사용하기 위해 dto 패키지를 import 한다. --%>
<%--@ page import="user.dto.UserDto"--%> 

<%
// UserDto loginUser = (UserDto) request.getSession().getAttribute("userDto");
// System.out.println(loginUser);
%>
<%-- session에서 loginUser를 가져와서 존재 여부에 따라 로그인 폼 또는 사용자 정보를 출력한다. --%>

<%--로그인 정보가 없을 경우 : 로그인을 위한 폼을 제공한다. --%>
<%--로그인 정보가 있는 경우 : 사용자 이름과 로그아웃을 위한 링크를 생성한다.--%>

<!-- nav bar -->
<div class="site-mobile-menu site-navbar-target">
    <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close">
            <span class="icofont-close js-menu-toggle"></span>
        </div>
    </div>
    <div class="site-mobile-menu-body"></div>
</div>

<nav class="site-nav">
    <div class="container">
        <div class="site-navigation">
            <a href="/main" class="logo m-0">Tour <span
                class="text-primary">.</span></a>

            <ul
                class="js-clone-nav d-none d-lg-inline-block text-left site-menu float-right">

                <li class="active"><a href="/main">Home</a></li>
                <li><a href="board.jsp">Board</a></li>
                <li><a href="search.jsp">Search</a></li>
                <li><a href="map.jsp">Map</a></li>

                <!-- 로그아웃 상태 -->  
                <%--
                if (loginUser == null) {
                --%>
                <li><a href="/enjoytrip/login">Sign In</a></li>
                <%--
                } else {
                --%>
                <li class="has-children"><a href="#">My Page</a>
                    <ul class="dropdown">
                        <li><a href="/enjoytrip/detail">My Info</a></li>
                        <li><a href="bookmark.jsp">Bookmark</a></li>
                        <li><a href="/loginout?job=logout">Logout</a></li>
                    </ul></li>
                <%--
                }
                --%>
            </ul>

            <a href="#"
                class="burger ml-auto float-right site-menu-toggle js-menu-toggle d-inline-block d-lg-none light"
                data-toggle="collapse" data-target="#main-navbar"> <span></span>
            </a>
        </div>
    </div>
</nav>

<script>
    // request 영역에 msg라는 이름의 attribute가 있다면 화면에 alert으로 출력한다.
    let msg = "${msg}";
    if (msg) {
        alert(msg)
    }
</script>
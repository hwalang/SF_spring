//package config;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import user.dto.UserDto;
//
//// 주의!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//// 너무 편해서 나중에 이게 있는지 까먹을 수 있다..!!!!!!
//// login관련 필터링을 다 하기 땜에 까먹을 수 있음..!!!!!!!!!!!!!!!!!
//
//
//@WebFilter("/*")
//public class LoginFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) res;
//        
//        String contextPath = httpServletRequest.getContextPath();
//        String path = httpServletRequest.getRequestURI();
//       
//        // 필터가 동작하고 있음을 말해줌!!!!!!!!!!
//        System.out.println("BoardWebAjaxJson - doFilter path : " + path ); 
//
//        HttpSession session = httpServletRequest.getSession();
//        
//        // exclude
//        if( 
//                ! path.contains("/img/") 
//                && ! path.contains("/css/") 
//                && ! path.contains("/js/") 
//                && ! path.contains("/register") 
//                && ! path.contains("/isEmailUnique") 
//                && ! path.contains("/login") 
//        ) {
//            UserDto userDto = (UserDto) session.getAttribute("userDto");
//
//            if(userDto == null) {	// 로그인한 사용자가 없으면
//                httpServletResponse.sendRedirect(contextPath + "/login.jsp");
//                return;
//            }
//        }
//
//        chain.doFilter(req, res);
//    }
//
//}

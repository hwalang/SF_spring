package com.mycom.myboard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mycom.myboard.common.LoginInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Autowired
	LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns("/**")				// 모든 경로에 적용한다.
				.excludePathPatterns(				// 적용하지 않는 경로
						"/",
						"/login/**",
						"/users/**",				// 회원가입
						"/codes/**",				// 공통 코드
						"/css/**",
						"/js/**",
						"/img/**",
						"/favicon.ico"
				);	
	}
	
	// CORS 에러 방지
	// @CrossOrigin(origins="*", allowedHeaders="*") 역할
	// login이 없으면 위 코드 하나로 가능하지만, login이 추가되면 여러 설정이 필요하다.
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")	// port 변경 유의!!
                // GET/PUT은 모든 웹서버가 구현했다고 가정하기 때문에 OPTIONS가 필요없다.
                // PUT/DELETE/PATCH는 신뢰할 수 없는 HTTP method이다.
                // put/delete/patch를 요청 받았을 때, 이를 처리하기 전에
                // options라는 method로 put/delete/patch가 서버에 구현됐는지 확인하는 과정이 필요하다.
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3000);
    }
	
}

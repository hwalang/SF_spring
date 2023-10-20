import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 사용자정의 Annotation 생성: @interface
// Annotation life-cycle 지정: Retention
//	사용하려면 @MyAnnotation

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

	// 메소드로 속성을 정의
	
	int num();
	String msg();
}

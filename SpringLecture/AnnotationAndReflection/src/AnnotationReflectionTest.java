import java.lang.reflect.Method;

public class AnnotationReflectionTest {
	
	public static void main(String[] args) throws Exception {
		// 사용자 정의 Annotation & Reflection
		
		// basic
		UseMyAnnotation uma = new UseMyAnnotation();
		uma.m1();
		
		// Reflection
		Method m = uma.getClass().getMethod("m1");	// m1() 메소드를 가져온다.
		
		// Annotation
		MyAnnotation ma = m.getAnnotation(MyAnnotation.class);
		System.out.println(ma.num());
		System.out.println(ma.msg());
	}

}

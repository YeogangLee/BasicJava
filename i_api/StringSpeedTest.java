package i_api;

public class StringSpeedTest {

	public static void main(String[] args) {
		
		/*
		 * String 클래스 특징 한 가지
			
			문자열에 변경이 가해지면,
			ex. abc뒤에 d를 붙였다
			-> 그러면 abcd라는 새로운 객체를 만들어서 저장하는 방식
			      기존 변수에 d를 붙이는 방식이 아님
		
		 * 객체는 생성을 하면 계속 메모리에 쌓인다 -> 낭비
		 * 메모리가 꽉차서 실행 속도가 느려진다.
		 * 
		 * 그런 String class의 단점을 보완
		 * : String buffer 클래스
		 */
		
		String str = "a";
		
		//속도 측정
//		long start = System.currentTimeMillis();
//		for(int i = 0; i < 10000; i++){
//			str += "a";
//		}
//		long end = System.currentTimeMillis();
//		System.out.println(end - start + "ms");
		
		StringBuffer sb = new StringBuffer("a");
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++){
			sb.append("a");
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start + "ms");
		
		//문자열 변경이 많을 때는, StringBuffer 클래스를 사용하는 게 좋다.
		//String은 변경시에 객체를 새로 만든다 ! 기억.
		
		
		
		
		
		
		
		
	}

}

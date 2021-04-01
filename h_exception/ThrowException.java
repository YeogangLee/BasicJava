package h_exception;

import java.io.IOException;

public class ThrowException {

	public static void main(String[] args) {
		
		/*
		 * 예외 발생시키기
		 * - throw new Exception();
		 * - throw 예약어와 예외 클래스의 객체로 예외를 발생시킬 수 있다.
		 */
		
		try {
			throw new IOException("예외 발생 이유");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//강제로 예외 발생 -> 콘솔 창에 예외 발생 이유가 없다.
		//발생 이유를 만들어 주고 싶다 -> 생성자의 파라미터에 문자열 입력
		
		
		/* 자주 만나게 될 에러 정리 */
		//1.
//		throw new NullPointerException(); 
		//널 값을 참조
		
		String str = null;
		System.out.println(str.equals("문자열비교"));
		
		//2.
		throw new IndexOutOfBoundsException();
		//배열의 인덱스가 범위를 벗어났다. 
		
		
		
	}

}

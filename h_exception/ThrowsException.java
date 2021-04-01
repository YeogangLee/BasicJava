package h_exception;

import java.io.IOException;

public class ThrowsException {

	public static void main(String[] args) {

		/*
		 * 메서드에 예외 선언하기
		 * - 메서드 호출시 발생할 수 있는 예외를 선언해줄 수 있다.
		 * - void method() throws IOException {}
		 * - 메서드의 구현부 끝에  throws 예약어와 예외 클래스명으로 예외를 선언할 수 있다.
		 * - 예외를 선언하면 예외처리를 하지 않고 자신을 호출한 메서드로 예외처리를 넘겨준다.
		 */
		
		try {
			method();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//method()를 호출하면 IOException이 발생할 수 있다 -> 호출한 곳 main() 메서드에서 예외처리
	private static void method() throws IOException {
		throw new IOException();		
	}
	
	//오늘 수업 요약 : 오늘 내용 다 기억하기 << 에러, 예외 메세지 읽기

}

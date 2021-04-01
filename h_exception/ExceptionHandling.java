package h_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionHandling {

	public static void main(String[] args) {

		/*
		 * 에러 Error
		 * - 컴파일 에러 : 컴파일 시에 발생되는 에러 (빨간 밑줄) - 실행 불가
		 * - 논리적 에러 : 실행은 되지만, 의도와 다르게 동작하는 것(버그)
		 * - 런타임 에러 : 실행 시에 발생되는 에러 - 콘솔 창에 (빨간 줄)로 표시되는
		 * 
		 * 런타임 에러
		 * - 런타임 에러 발생시 발생한 위치에서 프로그램이 비정상적으로 종료된다.
		 * - 에러 : 프로그램 코드에 의해 수습될 수 없는 심각한 오류(처리 불가)
		 * - 예외 : 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류(처리 가능)
		 * 
		 * 예외 Exception
		 * - 모든 예외는 Exception 클래스의 자식 클래스이다. - 제일 위에 있는 클래스 Exception 클래스
		 * - RuntimeException 클래스와 그 자식들을 예외처리가 강제되지 않는다.
		 * - [RuntimeException 클래스와 그 자식들을 제외한] Exception 클래스의 자식들은 예외처리가 강제된다.
		 * 											 ㄴ 강제처리 하지 않으면 컴파일 에러 발생
		 * 
		 * 예외처리 (try-catch)
		 * - 예외처리를 통해 프로그램이 비정상적으로 종료되는 것을 방지할 수 있다.
		 * - try {} catch(Exception e) {}
		 * - try 블럭 안의 내용을 실행 중 예외가 발생하면 catch로 넘어간다.
		 * - catch의 () 안에는 처리할 예외를 지정해줄 수 있다.
		 * - 여러 종류의 예외를 처리할 수 있도록 catch는 하나 이상 올 수 있다.
		 * - 발생한 예외와 일치하는 catch 블럭 안의 내용이 수행된 후 try-catch를 빠져 나간다.
		 * - 발생한 예외와 일치하는 catch가 없을 경우에는 예외는 처리되지 않는다.
		 */
		
		try{
			int result = 10 / 0;
			System.out.println(result);
			
			/*
			 * - 예외처리 방법 2가지
			 * 1. 파라미터 여러 개, 각 파라미터는 |로 구분
			 * 2. catch(){} 여러 개 
			 */

		}catch(ArithmeticException | IndexOutOfBoundsException e){
			//파라미터 : 예외가 발생한 곳,  java.lang.ArithmeticException
			e.printStackTrace();	
		}catch(NullPointerException e){
		// Exception e 파라미터 : 모든 경우 예외처리 가능	
		}catch(Exception e){ // 실무에서도 이렇게 사용 가능 
							 // -> 예외처리란 형식적인 것, 그냥 프로그램 종료를 막기 위해, 컴파일 되기 위해, 
							 // 사실상 로직이 없다. 단, 예외적으로 로직이 필요한 경우는 그렇게 해야겠죠. 
							 // 중요한 것 : 에러 메세지를 읽을 수 있는가.
		}
		
		test1();
	}

	private static void test1() {
		test2();
	}

	private static void test2() {
//		System.out.println(10 / 0);
		try {
			new FileInputStream("");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * / by zero : 0으로 나눠서 에러
	 * 
	 * at 위치가 3개가 있네, 왜?
	 * JVM - 콜스택 : 현재 호출된 메서드들이 있는 곳
	 * 
	 * - CallStack
	 * 
	 * |		   |
	 * |__test2()__|
	 * |__test1()__|
	 * |__main()___|
	 * 
	 * : 위에는 뚫려 있고 밑에는 막혀 있다 -> 먼저 들어온 게 나중에 나간다 FILO
	 * 가장 최근에 호출된 메서드에서 에러가 발생할 확률이 높다
	 * 그래서 at이 적힌 에러 발생 코드 중 제일 위에 있는 메서드를 클릭해서 그 줄 위치에 들어간다
	 * BUT 항상 맨 위가 답은 아니다 
	 * -> 내가 만든 메서드가 아니거나 모르는 메서드이면 건너 뛰고 ex.Native Method 
	 *    내가 만들었거나 아는 메서드부터 클릭해서 들어가본다.
	 * 
	 * 에러가 나면 반드시 메세지를 읽어주세요.
	 * 
	 */

}

package h_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Finally {

	public static void main(String[] args) {

		/*
		 * finally
		 * - 필요에 따라 try-catch 뒤에 finally를 추가할 수 있다.
		 * - finally는 예외 발생 여부와 상관없이 가장 마지막에 수행된다.
		 * 
		 * try 블럭에서 에러가 발생하면 그 위치에서 바로 catch로 간다.
		 * 만약 그 위치 이후의 실행되지 않은 코드에, 
		 * 반드시 실행해야 하는 코드가 있다면 finally를 사용해서 실행시킬 수 있다. 
		 * 
		 * 자동 자원 반환
		 * - try(변수 선언;변수 선언) {} catch(Exception e) {}
		 * - 사용 후 반환이 필요한 객체를 try의 () 안에서 선언하면 try 블럭 종료시 자동으로 반환된다.
		 */
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("d:file.txt");
			// fis.close(); // 자원 낭비를 막기 위해 FileInputStream 같은 클래스는, 꼭 close() 메서드와 함께 사용
			// 아래로 이동
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close(); //오류가 발생하든 발생하지 않든 반드시 실행
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}// 간단한 close() 코드 때문에 너무 긴 부가적인 코드 발생 -> 자동 자원 반환 이용
		
		//자동 자원 반환(JDK 1.7)
		// 원래 try 뒤에 괄호가 없었는데, 괄호를 허용 
		// -> 이 안에서 객체 생성하면 호출이 끝날 때 자원이 자동 반환됨
		// -> finally가 필요없다.
		
		//FileOutputStream : 파일 생성 클래스
		//파일을 읽거나 만들거나 그럴 때는 <<운영체제의 도움>>이 필요하다. -> 자원 반환의 이유
		try(FileOutputStream fos = new FileOutputStream("d:/file.txt")){
			String str = "아무내용";
			byte[] bytes = str.getBytes();
			for(int i = 0; i < bytes.length; i++){
				fos.write(bytes[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

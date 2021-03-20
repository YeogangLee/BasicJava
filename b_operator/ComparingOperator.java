package b_operator;

public class ComparingOperator {

	public static void main(String[] args) {
		/*
		 * 비교 연산자
		 * - <, >, <=, >=, ==, !=
		 * - 문자열 비교 : equals() - 문자열의 내용이 같은지 비교하고 싶을 때
		 * 
		 */
		
		int x = 10;
		int y = 20;
		boolean b = x < y;		
		System.out.println(b);
		
		b = x <= y - 15; //산술 먼저 연산, 우선순위 : 산술 > 비교
		// b = 10 <= 20 - 15 //false
		
		String str1 = "abc";	//String 참조형 타입 - 주소를 저장
		String str2 = "abc";
		b = str1 == str2;		//주소를 비교
		System.out.println(b);
		//문자열 내용을 비교한 게 아님
		//값을 저장하는 게 아닌 값이 저장된 위치를 저장하는 게 참조형 타입
		
		
		//문자열 내용 비교
		b = str1.equals(str2);	//같음을 비교
		System.out.println(b);
		
		b = !str1.equals(str2); //!A.equals(B) 다름을 비교
		System.out.println(b);
		
		
		//다음의 문장들을 코드로 작성해주세요.
		//1. x는 y보다 작거나 같다.
		//2. x + 5와 y는 같다.
		//3. y는 홀수이다.
		//4. "기본형"과 "참조형"은 다르다.
		
		System.out.println("\n문제");
		b = x <= y;
		System.out.println(b);
		b = x + 5 == y;
		System.out.println(b);
		b = y % 2 == 1;
		System.out.println(b);
		str1 = "기본형";
		str2 = "참조형";
		//b = !str1.equals(str2);
		b = "기본형".equals("참조형");
		System.out.println(b);
		
		
		
		
	}

}

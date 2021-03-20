package a_variable; //클래스의 위치

import java.util.Scanner;

public class Variable { //클래스

	public static void main(String[] args) { //메서드 
		//메서드 : 어떤 작업을 위한 명령문들의 집합
		//main메서드 : 프로그램의 시작과 끝
		//주석 : 프로그램 코드로 인식하지 않는 문장 - 주로 코드를 설명하는 데 사용한다.
		//한줄주석 : ctrl Shift c
		/* 범위주석  : ctrl Shift / */
		/*범위주석 풀기 : ctrl Shift \ */
		
		//프로그래밍이란 ? 데이터를 만들고 데이터를 조작하는 것
		
		/*
		 * 데이터의 종류
		 * - 정수: 10, -5 
		 * - 실수: 3.14, -1.5
		 * - 문자: 'a', '3' - 따옴표로 묶여 있는 한 글자를 문자라고 한다. 반드시 따옴표로 묶여있어야 함.
		 * - 논리: true, false
		 *
		 * 프로그래밍에서는 데이터를 사용하기 위해 종류별로 이름을 붙여놓았다. (자료형/Data Type)
		 * 
		 * 기본형 타입
		 * - 정수 : byte(1), short(2), *int(4), long(8)
		 * - 실수 : float(4), *double(8)
		 * - 문자 : char(2)
		 * - 논리 : boolean(1) 
		 */

		//변수를 만드는 것 : 변수 선언
		//변수를 만드는 방법 : 데이터타입 변수이름
		//; 문장과 문장을 구분해 주는 마침표 역할
		
		int name;
		
		double pi;
		
		//같은 변수 이름을 사용했을 때 나타나는 빨간줄 RED LINE ERROR : 컴파일 에러
		//컴파일 에러 -> 실행할 수 없는 코드
		//long name;
		//한 블럭{}안에서 변수의 이름은 중복될 수 없다
		
		//=(대입연산자) : 오른쪽의 값을 왼쪽의 변수에 저장 
		name = 10;	// 이렇게 변수에 처음으로 값을 대입하는 것 => 초기화
		pi = 3.14;  //변수의 타입에 맞는 값을 저장해야 한다.
		
		int abc = 30;  //보통은 선언과 초기화를 동시에 한다
		long l = 40L;  //접미사 L을 붙여야 long타입이 된다
					   // 정수를 그냥 쓰면 int가 되기 때문에, 정수 뒤에 접미사 L
		
		float f = 5.5f;  //접미사 f를 붙여야 float타입이 된다.
						 //f가 붙지 않으면 double
		
		char c = '한'; //따옴표 안에 한 글자만 넣어야 한다. 
		              //아무것도 넣지 않을 시, 오류 발생, 반드시 공백이라도 들어가 있어야 한다.
		
		boolean b = true; //true, false
		
		
		//8가지 기본형 타입을 사용해서 8개의 변수를 선언 및 초기화 해주세요.
		byte var1 = 1;
		short var2 = 100;
		int var3 = 4;
		long var4 = 4L;
		
		float var5 = 5.5f;
		double var6 = 6.6;
		char var7 = '칠';
		boolean var8 = true;
		
		
		//콘솔창에 출력 - System.out.println() 메서드 이용
		//실행 : ctrl + F11
		System.out.println(name);
		
		name = 100;
		System.out.println(name);			
		
		
		//위에서 만든 8개의 변수에 새로운 값을 저장하고 출력해주세요.
		System.out.println("== 8개 변수 출력 ==");
		System.out.println(var1);			
		System.out.println(var2);
		System.out.println(var3);
		System.out.println(var4);
		System.out.println(var5);
		System.out.println(var6);
		System.out.println(var7);
		System.out.println(var8);
		
		//노란줄 : 문제는 아닌데, 문제가 될 수도 있음을 경고하는 줄
		
		/*
		 * 타입 선택의 기준
		 * 
		 * 정수
		 * - byte, short : 메모리를 절약해야 할 때
		 * - int : 기본
		 * - long : int의 표현 범위를 벗어날 때
		 * 
		 * 실수
		 * - float : 메모리를 절약해야 할 때
		 * - double : 기본
		 */
		
		//문자열 : 쌍따옴표로 묶여 있음
		//기본형 타입이 아니고, 참조형 타입
		//참조형 타입은 실제 값을 저장하고 있지 않음, 변수 밖에 저장을 한다.
		//그러면 무엇을 저장 ? 값이 저장되어 있는 주소를 저장하고 있음
		//참조형 타입은 대부분 클래스
		String str = "문자 여러개..";
		System.out.println(str);
		
		//==> 오늘 공부한 자료형 총 9가지 꼭 외우기 + 기본형 8가지는 크기까지 외우기!
		
		
		//형변환 type casting 
		//- 데이터의 타입을 다른 데이터 타입으로 바꾸는 것  for 다른 타입의 값 저장을 위해
		int small = 10;
		long big = 10L;
		
		small = (int)big;
		big = small;

		//형변환이 자동으로 처리됨, 생략된 형변환
		//생략이 가능한 이유 - 표현범위가 작은쪽에서 큰쪽으로의 형변화은 생략이 가능하다.
		//		표현 범위 - 얼마만큼의 수를 표현할 수 있느냐
		
		//명명규칙
		// - 영문자 대소문자, 한글, 숫자, 특수문자('_', '$')를 사용할 수 있다. - 한글은 웬만해선 사용X
		// - 숫자로 시작할 수 없다.
		// - 예약어는 사용할 수 없다. 예약어 - 이미 어떤 기능으로 사용하고 있는 단어들
		// - [낙타식 표기법을 사용한다. mySampleVariable - 두 번째 단어부터는 단어의 시작하는 알파벳을 대문자로
		// - [클래스명의  첫글자는 대문자로 한다. MySampleClass - 클래스만! 앞 글자가 대문자
		//대괄호를 친 이유 - 이렇게 하지 않는다해서 오류가 발생하는 건 아니다. 
		//하지만 개발자들끼리 약속한 것, 그렇기 때문에 웬만하면 지키자.
		
		/*
		 * 상수
		 * - 처음 담긴 값을 변경할 수 없는 그릇
		 * - 리터럴에 의미를 부여하기 위해 사용
		 *   리터럴 - 수학에서의 상수처럼, 변하지 않는 값  
		 *   대문자로만 변수 선언  ex.MAX_NUMBER 
		 *   final이라는 예약어를 사용 
		 *   -> final int MAX_NUMBER, 값 변경이 불가 
		 *   
		 *   MAX_NUMBER = 10;
		 *   MAX_NUMBER = 100; - 컴파일 에러 발생
		 */
		
		final int MAX_NUMBER;
		MAX_NUMBER = 10;
		
		System.out.print("X줄바꿈X");
		System.out.print("X줄바꿈X\n");  // \n : 줄바꿈 - 역슬러쉬\는 이스케이프 문자, 탈출 문자		
		System.out.println("줄바꿈을\t한다."); // \t : 탭
		System.out.printf("문자열 : %s, 숫자 : %d", "GUMO", 10);  //출력 포맷을 지정한다.
		System.out.println();
		System.out.println("A"+100);    //문자열과 같이 출력하게 되면 int형이 정수가 아닌 문자열로 바뀌게 된다.
		System.out.println(10+20+"30"); //왼쪽부터 연산 -> 30, 연산 후에 문자열로 변환되어 문자열 3030 출력
		System.out.println("10"+20+30); //1020이라는 문자열로 변환 + 30 = 또한 문자열 => 102030 출력
		
		
		//입력
		//입력을 위해서는 이를 도와주는 class가 필요 -> Scanner
		Scanner sc = new Scanner(System.in);
		//컴파일 에러 이유 : 다른 클래스를 사용하려면 같은 패키지 안에 존재해야 한다.
		//import 단축키 : ctrl Shift O 
		
//		System.out.println("숫자를 입력해주세요 > ");
//		int num = sc.nextInt();
		
//		System.out.println("문자열 입력해주세요 > ");
//		String str2 = sc.nextLine();
		//스캐너.nextLine() : 문자열 입력 메서드
		//문자열이기 때문에 String 자료형에 대입
		//엔터키를 치면 그 앞까지의 내용을 가져옴
//		System.out.println("입력받은 내용 : " + str2);
		
		/* 
		 * int nextInt = sc.nextInt();
		 * double nextDouble = sc.nextDouble();
		*/
		//하지만 이건 버그가 있어서 x사용 권장x
		//어떤버그 ? 저 2줄 코드로 숫자 입력 받은 후, 문자열을 입력받으려고 하면 그대로 통과해버린다.
		//입력받은 내용 : -> 결과없이 그대로 출력
		
		
		System.out.println("int 입력 > ");
//		int number = (int)sc.nextLine();
		//문자열을 int형에 넣을 수 x -> 형변환이 필요 (int)이렇게 하면 안됨
		//기본형과 참조형 간의 형변환은 불가능!
		
		int number = Integer.parseInt(sc.nextLine());
		System.out.println(number);
		
		//double을 입력받는 방법
//		System.out.println("double 입력 > ");
//		double number2 = Double.parseDouble(sc.nextLine());
//		System.out.println(number2);
		
		
		//간단한 문제
		//자신의 이름을 저장할 변수를 선언해주세요.
		String myName;
		
		//위에서 선언한 변수를 초기화 하기 위해 이름을 입력받아주세요.
		Scanner sc2 = new Scanner(System.in);
		System.out.print("이름을 입력해주세요 > ");
		myName = sc2.nextLine();
		System.out.println("당신은 "+myName+"입니다.");
		
		//자신의 나이를 저장할 변수를 선언해주세요.
		short myAge;
		
		//위에서 선언한 변수를 초기화 하기 위해 나이를 입력받아주세요.
		System.out.print("나이를 입력해주세요 : ");
		myAge = Short.parseShort(sc2.nextLine());
		System.out.println("이름 : "+myName+" / 나이 : "+myAge);
		
		
		// 과제
		// 다음과 같은 프로그램을 작성해주세요.
		/*
		 * ======== 회원가입 ==========
		 * 아이디>admin
		 * 비밀번호(4자리숫자)>1234
		 * 이름>홍길동
		 * 나이>30
		 * 키>185.5
		 * ==========================
		 * 회원가입 완료!!
		 * ========= 내정보 ===========
		 * 아이디 : admin
		 * 비밀번호 : 1234
		 * 이름 : 홍길동
		 * 나이 : 30세
		 * 키 : 185.5cm
		 * ==========================
		 */
		
	}
	
}








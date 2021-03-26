package e_oop;

public class ClassMaker2 {
	
	//인스턴스 변수 하나를 선언하고 명시적으로 초기화 해주세요.
	int a = 10;
	
	//위에서 선언한 인스턴스 변수를 초기화 블럭을 사용해 초기화 해주세요.
	{
		a = 20;
	}
	
	//위에서 선언한 인스턴스 변수를 생성자의 파라미터를 사용해 초기화 해주세요.
	ClassMaker2(int a){
		//int a; 지역변수는 따로 작성하지 않는다.
		
		this.a = a;
	}
	
	//생성자를 하나 더 만들어서 위에서 선언한 인스턴스 변수를 초기화 해주세요.
	ClassMaker2(int a, int b){
		//선생님
		this(10); //생성자 호출은 생성자의 맨 첫 줄에 작성
		
		this.a = a;
		this.a = b;
		//this.b = a; //컴파일 에러
		
//		this(10);
//		Constructor call must be the first statement in a constructor
	}
	
	//3가지 방법 모두 다 사용했을 때
	//누구에 의해 초기화 될까? 
	//초기화 순서 : 1. 명시적 초기화 -> 2. 초기화 블럭 -> 3. 생성자
	//그래서  최종적으로는 생성자가 초기화 한 값이 사용된다.
	
}

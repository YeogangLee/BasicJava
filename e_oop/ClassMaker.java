package e_oop;

public class ClassMaker {

	//전역변수 하나를 선언 및 초기화 해주세요.
	int field = 10;
	String a = "abc";
	
	//리턴타입과 파라미터가 없는 메서드를 하나 만들어주세요.
	//메서드 안에서 전역변수를 출력해주세요.
	void VoidvoidMethod(){
		System.out.println(field);
	}
	void a(){
		System.out.println(a);
	}
	
	//전역변수와 동일한 타입의 리턴 타입이 있고 파라미터는 없는 메서드 하나를 만들어주세요.
	//메서드 안에서 전역변수를 리턴해주세요.
	int IntvoidMethod(){
		return field;
	}
	String b(){
		return a;
	}
	
	//리턴 타입은 없고 파라미터가 있는 메서드 하나를 만들어주세요.
	//메서드 안에서 파라미터를 출력해주세요.
	void VoidparaMethod(int num){
		System.out.println(num);
	}
	void c(int b){
		System.out.println(b);
		return; //메서드를 종료시키는 역할
	}
	
	//int 타입의 리턴 타입과 int 타입의 파라미터 두 개가 있는 메서드 하나를 만들어주세요.
	//메서드 안에서 두 파라미터를 곱한 결과를 리턴해주세요.
	int IntintMethod(int x, int y){
		return x * y;
	}
	int d(int a, int b){
		return a * b;
		//return의 역할
		//1. 값 반환
		//2. 메서드 종료
	}
	
	
	
	
	
	
}

package e_oop;

public class VariableInit2 {
	
	/* 변수 초기화 방법 3가지 */
	
	//1. 명시적 초기화
	int var = 10;
	static int classVar = 20;
	
	//2. 초기화 블럭
	{
		var = 30;
	}
	
	static {
		classVar = 40;
	}	
	
	//3. 생성자 생성 : 클래스이름(){}
	VariableInit2(){
		var = 50;
	}
	
	public static void main(String[] args) {
		Init i = new Init();
		i.a = 10;
		i.b = 20;
		i.c = 30;
		System.out.println(i.a);
		System.out.println(i.b);
		System.out.println(i.c);
		
		Init i2 = new Init();
		i2.a = 40;
		i2.b = 50;
		i2.c = 60;
		System.out.println(i2.a);
		System.out.println(i2.b);
		System.out.println(i2.c);
		
		Init i3 = new Init(70, 80, 90); //파라미터를 사용해서 초기화 할 때 생성자가 사용된다
		
		
	}
	
}

class Init{
	int a;
	int b;
	int c;
	
	//생성자를 만들어서 파라미터를 받아보자
	Init(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	//생성자 : 클래스와 같은 이름을 가지고 있다
	Init(){
		this(10, 20, 30); 
	}
	
}

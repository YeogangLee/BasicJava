package g_oop2;

public interface SampleInterface {

	//인터페이스 : 상수와 추상메서드로 구성
	//인터페이스의 모든 멤버변수는 public static final 제어자를 사용해야 한다
	public static final int NUM1 = 10;
	
	//모든 멤버변수의 제어자가 같기 때문에 생략이 가능하다
	int NUM2 = 20;
	
	//인터페이스의 모든 메서드는 public abstract 제어자를 사용해야 한다
	public abstract void method1();
	
	//모든 메서드의 제어자가 같기 때문에 생략이 가능하다
	void method2();	
	
}

//인터페이스는 상속 예약어로 extends를 사용하지 않는다. -> implements 사용
//기존에서 더 확장시킨다는 의미로 extends 예약어를 사용한 건데,
//인터페이스는 메서드이지만 내용이 없기 때문에,
//내용을 구현한다는 의미가 강하기 때문에 implements라는 예약어 사용
//그래서 인터페이스를 상속받기도 하지만 인터페이스를 구현한다 라는 말을 쓰기도 한다
class SampleImplement implements SampleInterface, SampleInterface2{

	//인터페이스의 아주 큰 특징 
	//: 다중 상속이 가능하다 -> 부모가 여러 개여도 된다. 여러 부모로부터 상속 받을 수 있다.
	//implements 뒤에 콤마,로 구분지어 사용
	
	@Override
	public void method1() {		
		
	}

	@Override
	public void method2() {		
		
	}

	@Override
	public void method3() {
		
	}
}

interface SampleInterface2{
	void method1();
	void method3();
}

//사용이유
//1차원적으로는, 부모클래스의 역할, 강제하는 역할을 한다
//


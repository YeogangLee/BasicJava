package g_oop2;

public abstract class SampleAbstractParent {

	//추상메서드 : 내용이 없는 메서드 = 블럭이 없다, 선언부만 있다
	//추상메서드를 하나라도 포함하는 클래스는,
	//마찬가지로 추상 클래스이다.
	//클래스 키워드 앞에 'abstract' 추가
	
	//추상메서드는 내용이 없기 때문에 호출이 불가능하다.
	//: 사용 이유 -> 부모클래스의 역할만 한다. 상속을 받아서 사용하겠다. 
	
	void method(){
		
	}
	
	abstract void abstractMethod();
	
}

class SampleAbstractChild extends SampleAbstractParent{
	//추상메서드를 가지고 있으려면
	//1. 얘를 추상 클래스로 만들던가
	//2. 아니면 추상 메서드의 내용을 만든다 -> 오버라이딩을 통해서 
	
	@Override
	void abstractMethod(){
		
	}
	// 상속 받는 자식마다 내용이 달라질 수가 있기 때문에.
	

	
}
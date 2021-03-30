package g_oop2;

public class SampleChild extends SampleParent { // 상속을 위한 키워드 : extends (상속 받을 클래스 이름)
	
	void childMethod(){
		System.out.println(var);
		System.out.println(method(7,13));
	}
	
	//오버라이딩 - 상속 받는 메서드의 내용을 변경하는 것
	//super - 부모 클래스의 멤버 이름과 자식 클래스 멤버의 이름이 똑같을 때, 그걸 구분하기 위해 사용
	//super() - 부모 클래스의 생성자에서 자식 클래스의 생성자를 생성할 때 사용
	//다형성 - 부모 타입의 변수를 사용해서 자식 타입의 변수를 사용하는 것
	
	//오버라이딩 : 상속 받은 메서드의 내용을 재정의 하는 것
	@Override // 어노테이션, 애너테이션 : 클래스, 변수, 메서드 등에 표시해 놓는 것, @t = 주석 in 사전
	int method(int a, int b){ //상속 받은 기존의 메서드와 리턴타입, 메서드명, 파라미터 모두 같아야 한다
		return a*b;			  //SampleParent 클래스 자바 파일에서 동일한 모습 확인 가능
	}
	//실수로 메서드 이름을 잘못 적는다던가, 오타를 내면 오버라이딩이 안 될 수가 있다
	//그런 실수를 방지하기 위해 어노테이션 사용 - 어노테이션 사용하지 않으면 컴파일에러가 발생해도 빨간줄이 그이지 않는다.
	
	//super, super()
	int var; //아래의 인스턴스 변수와 동일한 변수
	
	void test(double var){
		System.out.println(var); //지역변수
		System.out.println(this.var); //인스턴스 변수
		System.out.println(super.var); //부모 클래스의 인스턴스 변수
		//super : 부모 클래스의 멤버와 자식 클래스의 멤버가 이름이 중복될 때 둘을 구분하기 위해 사용한다.
		//부모 클래스의 "멤버" 
		
		System.out.println(this.method(10, 20));
		System.out.println(super.method(10, 20)); //다른 자바 파일, 부모클래스의 int method a+b
	}
	
	SampleChild(){
		super(); //부모클래스의 생성자 호출
		//super()를 통해 부모클래스의 생성자를 호출하고 부모클래스의 인스턴스 변수도 초기화한다.
		//super()가 없으면 컴파일러가 자동으로 super()를 넣어준다.
		//무조건 적어야 하는 것
		//생성자에 파라미터가 있을 때 컴파일러가 자동으로 넣지 못한다.
		//그때는 반드시 super()를 호출을 해서 파라미터까지 넘겨줘야 한다.
	}
	
	//다형성
	public static void main(String[] args) {
		SampleChild sc = new SampleChild();
		SampleParent sp = new SampleChild();
		//sp = new SampleChild2();
		//sp = new SampleChild3();
		
		sc = (SampleChild)sp;
		sp = (SampleParent)sc;
		//형변환 생략 가능 : 작은 쪽 -> 더 큰 쪽으로 갈 때
		//여기서도, 자식 타입-> 부모 타입으로의 형변환은 생략 가능
		
		//왜 그런지 보자
		sc = (SampleChild)new SampleParent();
		//샘플 차일드는 현재 사용할 수 있는 5개의 멤버가 있는 것
		//샘플 페어런트는 var, method 2개의 멤버
		//나머지 멤버 3개는 커버할 수 없다 -> 문제 발생
		
		sp = new SampleChild();
		//5개 중에 2개는 쓸 수 있겠지. 그러니까 형변환 생략 가능.
		//쓸 게 남는 것은 문제가 안 된다.
		
		//컴파일 에러, 런타임 에러 ...
		
		//다형성 사용 이유 - 다른 클래스에서 알아보기 new class 생성
		
				
	}
	
}


package e_oop;

public class JVM {

	public static void main(String[] args) {
		/*
		 * Java Virtual Machine
		 * - 자바로 만들어진 프로그램이 실행되는 컴퓨터 안의 가상 컴퓨터
		 * - 운영체제 -> JVM -> 자바 프로그램
		 * - 장점 : 운영체제에 상관없이 실행할 수 있다.
		 * - 단점 : 속도가 느리다. (그렇게 큰 차이는x)
		 * 
		 * JVM 메모리 구조
		 * - Method Area(메서드 영역) : 클래스 멤버가 저장된다. (주로 static이 붙은 것들)
		 * - Heap : 객체가 저장된다.
		 * - Call Stack(호출 스택) : 현재 호출되어 있는 메소드가 저장된다.
		 * 
		 * 메서드 영역 : 프로그램을 시작하면 전부 올라갔다가 종료되면 전부 내려오는
		 * 힙 : 더 이상 참조되지 않아 사용할 필요가 없으면 
		 *     GarbageCollector가비지 컬렉터에 의해 삭제됨
		 * 콜 스택 : 호출되면 올라갔다가 작업 끝나면 내려오는
		 * 
		 * JVM 메모리 구조는 개발자라면 상식으로 알아두세요. 안다고 코드를 잘 작성하게 되는 건 아니지만,
		 */
		
		//메인 메서드도 static이기 때문에, 객체 생성하지 않으면, 
		//static 내부에서 static 변수가 아닌 instanceVar 사용 불가
//		System.out.println(instanceVar); //컴파일 에러 
		
		//프로그램 실행시 main(), classVar, classMethod()가 MethodArea에 저장됨
		//main()이 호출되어 CallStack에 저장됨
		
		System.out.println(classVar);
		// System 클래스의 out이 MethodArea에 저장됨
		// println()이 호출되어 CallStack에 저장됨
		// println()이 classVar를 출력 후 CallStack에서 삭제됨
		
		classMethod();
		// classMethod()가 호출되어 CallStack에 저장되고,
	    // 메서드의 내용을 수행 후 CallStack에서 삭제됨
				
		
		JVM jvm = new JVM();
		//JVM 객체가 Heap에 저장됨
		//jvm 변수가 CallStack에 생성되고, JVM 객체의 주소가 저장됨
		//지역변수는 CallStack에서 생성된다.
		
		System.out.println(jvm.instanceVar);
		//out은 이미 쓰인 적이 있으므로, MethodArea에 다시 저장할 필요x
		//println()이 호출되어 CallStack에 저장되고,
		//println()이 instanceVar를 출력 후 CallStack에서 삭제됨
		
		jvm.instanceMethod();
		//instanceMethod()가 호출되어 CallStack에 저장되고,
		//메서드의 내용을 수행 후 CallStack에서 삭제됨
		
		jvm = null;
		//jvm변수에 null이 저장됨
		//주소가 null이므로 사용할 수가 없는 상태
		//-> (어디에서도 주소를 참조하지 않는)
		//   JVM 객체는 GarbageCollector에 의해 삭제됨
		
		//메인 메서드 main()의 실행이 종료되어 CallStack에서 삭제됨
		//프로그램이 종료되고 MethodArea의 데이터가 삭제됨
				
	}
	
	int instanceVar;
	static int classVar; //static은 프로그램 실행하자마자 메모리에 올라간다.
	
	void instanceMethod(){
		System.out.println(instanceVar);
		System.out.println(classVar);
	}
	
	//객체 생성하지 않고 사용하려고 
	//-> 지금은 객체 생성을 하기 전, 그래서 instanceVar에는 컴파일 에러 발생 
	static void classMethod(){
//		System.out.println(instanceVar); //빨간줄, 컴파일 에러 발생
		System.out.println(classVar);
	}

}

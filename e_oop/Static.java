package e_oop;

public class Static {
	
	/*
	 * static을 붙이면 프로그램 실행시 메모리에 올라간다.
	 * <객체 생성>을 하지 않아도 사용할 수 있다.
	 * static을 붙인 변수는 객체끼리 변수의 값을 공유한다.
	 * 
	 * static이 붙은 멤버의 명칭 : 클래스 변수, 클래스 메서드 - 클래스 이름을 통해 사용하기 때문
	 * static이 붙지 않은 멤버의 명칭 : 인스턴스 변수, 인스턴스 메서드 - 객체 생성을 통해 사용하기 때문
	 * 
	 */
	
	
	static int var; //클래스 변수 : 값을 공유하기 위해 사용한다.
	//값 대입은 main 메서드 안에서 이뤄져야 한다
	
	public static void main(String[] args) {
		
		var = 1;
		System.out.println("var : " + var);
		
		Saram s1 = new Saram();
		Saram s2 = new Saram();
		
		s1.name = "철수";
		s2.name = "영희";
	
		s1.saveMoney(100000);
		s2.saveMoney(200000);
		
		s1.saveDateMoney(200000);
		s2.saveDateMoney(200000);
		
		//Math.random()은 객체 생성하지 않고도 사용 가능
		System.out.println(Math.random());
		
		//ScanUtil 클래스를 생성 후 클래스 내부에 static 메서드 이용
		// => 객체 생성하지 않고도 Scanner 사용 가능
		System.out.println("문자열 입력>");
		String str = ScanUtil.nextLine();
		System.out.println(str);
		
		System.out.println("숫자 입력>");
		int num = ScanUtil.nextInt();
		System.out.println(num);
		
		//static 사용 이유
		//변수 - 값 공유를 위해
		//메서드 - 자주 사용하니까, 편하게 객체 생성하지 않고 사용하려고
		
	}

}

class Saram {
	
	String name; //이름
	int account; //계좌 잔고
	
	void saveMoney(int money){
		account += money;
		System.out.println(name + "의 계좌 잔고 : " + account);
	}
	
	//변수 간의 값 공유를 위해 static 사용
	static int dateAccount;
	
	void saveDateMoney(int money){
		dateAccount += money;
		System.out.println("데이트 통장 잔고 : " + dateAccount);
	}
	
	
	
}




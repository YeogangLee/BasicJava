package b_operator;

public class LogicalOperator {

	public static void main(String[] args) {
		/*
		 * 논리연산자
		 * - &&(AND), ||(OR), !(NOT)  //보통 비교 연산을 논리로 연결시켜주는 역할
		 * - 피연산자로 boolean만 허용한다.
		 */
		
		int x = 10;
		int y = 20;
		boolean b = 0 < x && x < 10 || x < y;
		//&&, || 함께 사용, 우선순위 : && > ||
		System.out.println(b);
		b = !(x < y);
		
		//효율적 연산
		b = true && true; //true
		b = true && false; //false
		System.out.println("b1="+b); //10
		b = false && true; //false, true 확인x
		System.out.println("b2="+b); //10
		b = false && false; //false, false 확인x
		
		b = true || true;  //true, true 확인x
		b = true || false; //true, false 확인x
		b = false || true; //true
		b = false || false;//false
		//왼쪽의 피연산자에게서 결과가 정해지면 오른쪽은 수행하지 않는다
		// && 연산에서 왼쪽이 false일 경우 오른쪽 확인 X
		// || 연산에서 왼쪽이 true일 경우 오른쪽 확인 X
		// 확인하지 않은 피연산자는 노란줄이 그여져 있다.
		
		
		//효율적 연산 시 주의 사항
		int a = 10;
		b = a < 5 && 0 < a++;
		// false && a++  
		// => && 연산에서 false를 만나면 뒤의 연산을 실행하지 않으므로 a값이 증가하지 않음, >주의 
		System.out.println(a); //10
		
		
		//효율적 연산 시 조건에 따라 정상수행 되거나 에러 발생 
		boolean c;
		c = false && c;	//false, 오류 x
		c = true || c;  //true, 오류 x
		System.out.println("c = "+c);
		
		c = true && c;	//오류 발생
		c = false || c;  //오류 발생
		System.out.println("c = "+c);
		
		
		
		//다음의 문장들을 코드로 작성해주세요.
		//1. x가 y보다 크고 x가 10보다 작다.
		//2. x가 짝수이고 y보다 작거나 같다.
		//3. x가 3의 배수이거나 5의 배수이다.
		
		//x = 10, y = 20
		b = x > y && x < 10;
		System.out.println(b);
		b = x % 2 == 0 && x <= y;
		System.out.println(b);
		b = x % 3 == 0 || x % 5 == 0;
		System.out.println(b);
		
				
		
				

	}

}

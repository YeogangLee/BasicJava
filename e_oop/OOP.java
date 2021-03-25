package e_oop;

import e_oop.restaurant.Arbeit;

public class OOP {

	public static void main(String[] args) {
		/*
		 * 객체지향 프로그래밍 (Object Oriented Programming)
		 * - 프로그래밍을 단순히 코드의 연속으로 보는 것이 아니라
		 *   객체 간의 상호작용으로 보는 것
		 * - 코드의 재사용성이 높고 유지보수가 용이하다.
		 * 
		 * 객체 - 실제 존재하는 개념, 대상
		 */
		
		SampleClass sc = new SampleClass(); // 선언 -> 메모리에 올라간 상태

		System.out.println(sc.field);
		
		String returnValue = sc.method1(5);
		System.out.println(returnValue);
		
		
		sc.method2();
		
		sc.flowTest1();
		
		
		Calculator cal = new Calculator();
		
		double a = 123456;
		double b = 654321;		
		double result = cal.plus(a,b);
		result = cal.multiply(result, a);
		result = cal.division(result, a);
		result = cal.minus(result, b);
		result = cal.mod(result, a);
		System.out.println(result);
		
		// ((a + b) * a / a - b) % a = 0;  
		
				
		
	}

}

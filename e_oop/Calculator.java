package e_oop;

public class Calculator {
	//사칙연산 + 나머지
	//하나의 메서드에서 연산할 파라미터 2개를 받고 리턴
	
	double plus(double a, double b){
		return a + b;
	}
	
	double minus(double a, double b){
		return a - b;
	}
	
	double multiply(double a, double b){
		return a * b;
	}
	
	double division(double a, double b){
		return a / b;
	}

	double mod(double a, double b){
		return a % b;
	}
	
}

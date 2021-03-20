package b_operator;

import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		//두 개의 숫자와 하나의 연산자를 입력받아 연산 결과를 알려주는 프로그램을 만들어주세요.
		//간단한 계산기 프로그램, 연산자는 + - * / % 이렇게 5개 
		
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("====================");
		System.out.println("숫자1> ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.println("숫자2> ");
		int num2 = Integer.parseInt(sc.nextLine());
		System.out.println("연산자> ");
		char op = sc.nextLine().charAt(0);
		// = String op = sc.nextLine();
		System.out.println(op);
		
		int result = op == '+' ? num1 + num2 : (op == '-' ? num1 - num2 : (op == '*' ? num1 * num2 : (op == '/' ? num1 / num2 : (op == '%' ? num1 % num2 : 0))));
		/*
		int result = op.equals("+") ? x + y
					: op.equals("-") ? x - y
					: op.equals("*") ? x * y
					: op.equals("/") ? x / y
					: x % y;
		*/		
		String message = result == 0 ? "연산자를 잘못 입력했습니다." : "";
		
		System.out.println("====================");
		System.out.println(num1+" "+op+" "+num2+" "+"="+" "+result);
		System.out.println(message);
		
	}

}

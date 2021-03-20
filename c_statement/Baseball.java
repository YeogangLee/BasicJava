package c_statement;

import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		/*
		 * 123
		 * 135 : 1S 1B 1O
		 * 
		 * 입력받은 숫자와 원래 숫자를 비교해서
		 * 스트라이크, 볼, 아웃을 만든다.
		 * 스트라이크 : 1 - 숫자도 같고 자릿수도 같다.
		 * 볼 : 3 - 조합에는 있으나 자릿수가 다른 것
		 * 아웃 : 자릿수도 조합에도 없는 것  
		 *
		 * 
		 * 768 : 1S 0B 2O
		 * 743 : 0S 1B 2O
		 * 543 : 0S 1B 2O
		 * 924 : 1S 1B 1O
		 * 461 : 1S 0B 2O
		 * 963 : 000
		 * 524 : 1S 1B 1O
		 * 254 : 0S 2B 1O
		 * 219 : 0S 1B 2O
		 * 164 : 0S 1B 2O
		 * 
		 * 428 : 3S
		 * 
		 * O 4
		 * X 1 3 6 7 9 
		 * 
		 * 
		 */
		
		
		//숫자 3자리 만들고 시작
		//숫자는 1~9 사이의 중복되지 않는 숫자들
		//=> (int)(Math.random() * 9) + 1;
		
		Scanner sc = new Scanner(System.in);
		
		int a = (int) (Math.random() * 9) + 1;
		int b = (int) (Math.random() * 9) + 1;
		int c = (int) (Math.random() * 9) + 1;
		
		if(a == b) b = a + 1;
		if(b > 10) b = a - 1;
		if(b == c) c = b + 1;
		if(c > 10) c = b - 1;
		if(a == c) c = a + 1;
		if(c > 10) c = a - 1;
		
		int strike = 0, ball = 0, out = 0;
		
		System.out.println(a + " " + b + " " + c);
		
		do{
			System.out.println("첫 번째 숫자 입력>");
			int x = Integer.parseInt(sc.nextLine());
			System.out.println("두 번째 숫자 입력>");
			int y = Integer.parseInt(sc.nextLine());
			System.out.println("세 번째 숫자 입력>");
			int z = Integer.parseInt(sc.nextLine());
			
			int rand = a * 100 + b * 10 + c;
			int user = x * 100 + y * 10 + z;
			
//			// +
//			if((rand-user < 100 ||  || ((rand-user)%10 == 0)){ strike++; }
//			
//			// -
//			if(-(rand-user) > 100) ||  || -(rand-user)%10 == 0))
			
			
			if (a==x){
				strike++;
			}
			if (b==y){
				strike++;
			}
			if (c==z){
				strike++;
			}
		
		
		
		
		
		}while(strike!=3);
		
	}

}

package c_statement;

//import java.util.Scanner;

public class RepetitiveStatement {

	public static void main(String[] args) {
		/*
		 * 반복문
		 * - for문
		 * - while문
		 * - do-while문
		 * 
		 * for문
		 * - for(초기화; 조건식; 증감식){}
		 * - 포함하고 있는 문장들을 "정해진 횟수"만큼 반복하는 문장 
		 */
		
//		for(int i = 1; i <= 10; i++){
//			//초기화 : 조건식과 증감식에 사용할 변수 초기화
//			//조건식 : 연산결과가 true이면 블럭 안의 내용을 수행한다
//			//증감식 : 변수를 증가/감소시켜 반복문을 제어한다
//			System.out.println(i + "번째 반복");
//			
//		}
//		
//		int sum = 0; //1부터 10까지의 합계를 저장
//		
//		sum += 1;
//		sum += 2;
//		sum += 3;
//		sum += 4;
//		sum += 5;
//		sum += 6;
//		sum += 7;
//		sum += 8;
//		sum += 9;
//		sum += 10;
//		System.out.println("합계 "+sum);
//		
//		sum = 0;
//		for(int i = 1; i <= 10; i++){
//			sum += i;
//		}
//		System.out.println("합계 "+sum);
//		
//		sum = 0;
//		for(int i = 10; i >= 1; i--){
//			sum += i;
//		}
//		System.out.println("합계 "+sum);
//		
//		//hazardous
//		
//		//1부터 100까지 짝수의 합을 출력해주세요.
//		sum = 0;
//		for(int i = 1; i <= 100; i++){
//			if (i % 2 == 0) sum += i;
//		}
//		System.out.println("합계 "+sum);
//		
//		sum = 0;
//		for(int i = 2; i <= 100; i += 2){
//		  sum += i;	
//		}
//		System.out.println("합계 "+sum);
//		
//		
//		//1부터 100까지 홀수의 합을 출력해주세요.
//		sum = 0;
//		for (int i = 1; i < 100; i += 2){
//			sum += i;
//		}
//		System.out.println("합계 "+sum);
//		
//		
//		/*
//		 * 구구단 출력
//		 * 
//		 * 2 * 1  = 2
//		 * 2 * 2  = 4
//		 * 2 * 3  = 6
//		 * ...
//		 * 
//		 */
//		
//		//앞에 숫자  - 똑같이 반복
//		//뒤에 숫자 - 1만큼 증가, 결과는 2씩 증가
//		
//		//2단
//		for(int i = 1; i <= 9; i++){
//			System.out.println(2 + "*" + i + " = " + i * 2);
//		}
//		
//		//6단
//		for(int i = 1; i <= 9; i++){
//			System.out.println(6 + "*" + i + " = " + i * 6);
//		}
//				
//		//구구단 전체 출력
//		for(int i = 2; i <= 9; i++){
//			for(int j = 1; j <= 9; j++){
//			System.out.println(i +" * "+ j +" = " + i*j);
//			}	
//		}
//		System.out.println();
//		
//		//구구단 전체를 가로로 출력해주세요.
//		/*
//		 * 2 * 1 = 2	3 * 1 = 3	4 * 1 = 4	
//		 * 2 * 2 = 4	3 * 2 = 6	4 * 1 = 8
//		 * 2 * 3 = 6	3 * 3 = 9	4 * 1 = 12
//		 */
//		
//		sum = 0;
//		for(int i = 1; i <= 9; i++){
//			for(int j = 2; j <= 9; j++){
//				System.out.print(j+" * "+i+" = "+i*j+"\t");
//				if(j==9) System.out.println();
//			}
//			//System.out.println();
//		}
		
		/*
		 * while문
		 * - while(조건식){}
		 * - 포함하고 있는 문장들을 조건식이 만족하는 동안 반복하는 문장
		 * - 반복 횟수가 정확하지 않은 경우에 주로 사용한다.
		 *   ㄴ 반복 횟수를 모르는 경우
		 */
		
		
		//a에 2씩 몇 번을 곱해야 1000 이상이 될까?
		int count = 0;
		int a = 1;
		
		while(a < 1000){
			a *= 2;
			count++;
		}
		
		System.out.println(count + " : " + a);
		
		
		/*
		 * do-while문
		 * - do{}while(조건식);
		 * - 최소한 한 번의 수행을 보장한다.
		 * ㄴ 사용자에게 입력을 받는 경우에 사용
		 *   사용자가 입력을 그만 받고 싶을 때까지 입력을 받는 것
		 *   또는 어떠한 결과가 나올 때까지 입력을 받는 경우
		 * => 입력 횟수가 일정하지 않음
		 */
		
		
//		//숫자 맞추기 게임
//		int answer = (int) (Math.random() * 100) + 1;
//		int input = 0;
//		Scanner sc = new Scanner(System.in);
//		do{
//			System.out.println("1 ~ 100 사이의 수를 입력해주세요>");
//			input = Integer.parseInt(sc.nextLine());
//			
//			if(answer < input){
//				System.out.println(input + " 보다 작습니다.");
//			}else if(answer > input){
//				System.out.println(input + " 보다 큽니다.");
//			}else{
//				System.out.println("정답입니다.");
//			}
//		}while(input != answer);
//		System.out.println();
		
		//이름붙은 반복문
		//-> break를 더 멀리 있는 반복문에 사용하기 위해
		outer : for(int i = 2; i <= 9; i++){
			for(int j = 1; j <= 9; j++){ // <-- break에서 가장 가까운 반복문
				if(j==5){
					//break; //가장 가까운 반복문 하나를 빠져나간다.
					break outer; //outer라는 이름의 반복문을 빠져나간다.
//					continue; //가장 가까운 반복문의 현재 반복회차를 빠져나간다. -> 1,2,3,4, 6,7,8,9
//					continue outer; //outer라는 이름의 현재 반복회차를 빠져나간다.
				}
				System.out.println(i+" * "+ j +" = " + i*j);
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("*****");
		System.out.println("*****");
		System.out.println("*****");
		System.out.println();
		
		for(int j = 1; j <= 3; j++){
			for(int i = 1; i <= 5; i++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("*");
		System.out.println("**");
		System.out.println("***");
		System.out.println("****");
		System.out.println("*****");
		System.out.println();
		
		for(int j = 1; j <= 5; j++){
			for(int i = 1; i <= j; i++){
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int j = 5; j >= 1; j--){
			for(int i = 1; i <= j; i++){
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		
		for(int j = 5; j >= 1; j--){
			for(int i = 1; i <= j; i++){
				System.out.print(" ");
			}System.out.println();
		}
		System.out.println();
		
		
		
	}
}

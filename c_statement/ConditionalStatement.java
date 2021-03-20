//package c_statement;
//
//import java.util.Scanner;
//
//public class ConditionalStatement {
//
//	public static void main(String[] args) {
//		/*
//		 * 조건문
//		 * - if문
//		 * - switch문
//		 * 
//		 * if문
//		 * - if(조건식){} : 조건식의 결과가 true이면 블럭 안의 문장을 수행한다. - 조건식 안의 내용은 boolean 형태
//		 * - else if(조건식){} : 다수의 조건이 필요할 때 if 뒤에 추가한다.
//		 * - else{} : 결과가 true인 조건식이 하나도 없는 경우를 위해 추가한다.
//		 * 
//		 */
//		
////		int a = 1;
////		
////		if(a == 1){
////			System.out.println("조건식의 연산 결과가 true이면 수행된다.");
////		}
////		if(a == 0){
////			System.out.println("조건식의 연산 결과가 false이면 수행되지 않는다.");
////		}
////		if(a == 1){
////			System.out.println("a가 1인 경우에 하고 싶은 것");
////		}else if(a == 2){
////			System.out.println("a가 2인 경우에 하고 싶은 것");
////		}else if(a == 3){
////			System.out.println("a가 2인 경우에 하고 싶은 것");
////		}else{
////			System.out.println("이외의 경우에 하고 싶은 것"); 
////		}
////		
////		if(a < 10){
////			System.out.println("a가 10보다 작다");
////		}else if(a < 20){
////			System.out.println("a가 20보다 작다");
////		}
////		
////		
////		int score = 70;
////		//점수가 60점 이상이면 합격, 그렇지 않으면 불합격이라고 출력해주세요.
////		
////		if(score >= 60){
////			System.out.println("합격");
////		}else{
////			System.out.println("불합격");
////		}
////		
////		
////		//점수에 등급을 부여하는 프로그램
////		score = 80;
////		String grade = null;
////		
////		if(score >= 90){
////			grade = "A";
////		}else if(score >= 80){
////			grade = "B";
////		}else if(score >= 70){
////			grade = "C";
////		}else if(score >= 60){
////			grade = "D";
////		}else{
////			grade = "F";
////		}
////		System.out.println(score+"점에 해당하는 등급은 "+grade+"입니다.");
////		
////		score = 90;
////		grade = null; // null : String 타입의 기본값
////		
////		/*
////		 * 기본값 : 직접 초기화 하지 않았을 때 초기화되는 값
////		 * - 참조형 타입 : null
////		 * - boolean : false
////		 * - char : ' '(0)
////		 * - 이외 나머지 타입은 기본값이 0
////		 * 
////		 * => 기본적으로 이런 값으로 변수를 초기화 한다 
////		 */
////		
////		//정렬단축키 : Ctrl Shift F
////		if(score >= 90){
////			grade = "A";
////			if(score >= 97) grade += "+";
////			else if (score <= 93)grade += "-";
////		}else if(score >= 80){
////			grade = "B";
////			if(score >= 87) grade += "+";
////			else if (score <= 83) grade += "-";
////		}else if(score >= 70){
////			grade = "C";
////			if(score >= 77) grade += "+";
////			else if (score <= 73) grade += "-";
////		}else if(score >= 60){
////			grade = "D";
////			if(score >= 67) grade += "+";
////			else if (score <= 63) grade += "-";
////		}else{
////			grade = "F";
////		}
////		
////		System.out.println(score+"점에 해당하는 등급은 "+grade+"입니다.");
////		
////		
////		/*
////		 * switch문
////		 * - switch(int/String) { case 1: break; } // if문은 조건식 안이 boolean
////		 * - 조건식의 결과는 정수와 문자열만 (JDK1.7부터 문자열 허용) 허용한다.
////		 * - 조건식과 일치하는 case문 이후의 문장을 수행한다. 
////		 */
////		
////		a = 10; //int
////		switch (a) {
////		case 10:
////			System.out.println("a가 10인 경우에 하고 싶은 것");
////			break;
////		case 20:
////			System.out.println("a가 20인 경우에 하고 싶은 것");
////			break;
////		default:	
////			System.out.println("이외의 경우에 하고 싶은 것");
////		}
////		//장점 : 같은 내용을 if문과 switch문으로 표현했을 때 switch문이 더 빠르다.
////		//단점 : 사용할 수 있는 곳이 적다.
////		
////		String b = "a";
////		switch(b){
////		case "a":
////			System.out.println("b가 \"a\"인 경우에 하고 싶은 것");
////			break;
////		case "b":
////			System.out.println("b가 \"b\"인 경우에 하고 싶은 것");
////			break;
////		default:
////			System.out.println("이외의 경우에 하고 싶은 것");
////		}
////		
////		// \ : 탈출문자
////
////		//월에 해당하는 계절을 출력
////		int month = 1;
////		String season = null;
////		
////		switch(month){
////		case 3: case 4: case 5:
////			season = "봄";
////			break;
////		case 6: case 7: case 8:
////			season = "여름";
////			break;
////		case 9: case 10: case 11:
////			season = "가을";
////			break;
////		case 12: case 1: case 2:
////			season = "겨울";
////			break;
////		default:
////			System.out.println("1~12 사이의 숫자를 입력해 주세요.");
////		}
////		
////		System.out.println(month+"월은 "+season+"입니다.");
////		
////		
////		score = 70;
////		grade = null;
////		switch(score/10){
////		case 10: case 9:
////			grade = "A";
////			break;
////		case 8:
////			grade = "B";
////			break;
////		case 7:
////			grade = "C";
////			break;
////		case 6:
////			grade = "D";
////			break;
////		default:
////			grade = "F";
////		}
////		System.out.println(score+"점은 "+grade+"입니다.");
////		
////		
////		//숫자를 입력받아 그 숫자가 0인지 아닌지 출력
////		Scanner sc = new Scanner(System.in);
////		
////		System.out.println("숫자 입력>");
////		int num = Integer.parseInt(sc.nextLine());
////		
////		switch(num){
////		case 0:
////			System.out.println("입력한 숫자는 0입니다.");
////			break;
////		default:
////			System.out.println("입력한 숫자는 0이 아닙니다.");
////		}
////		
////		//숫자를 입력받아 그 숫자가 홀수인지 짝수인지 출력해주세요.
////		switch(num%2){
////		case 0:
////			System.out.println("입력한 숫자는 짝수입니다.");
////			break;
////		default:
////			System.out.println("입력한 숫자는 홀수입니다.");
////		}
////		
////		//점수 3개를 입력받아 총점, 평균, 등급을 출력해 주세요.
////		int score1, score2, score3;
////		//float avg;
////		grade = null;
////		// int sum = kor, eng, math;
////		// double avg = Math.round(sum/3.0*100) / 100.0;
////		double avg; 
////		
////		System.out.println("점수1 입력>");
////		score1 = Integer.parseInt(sc.nextLine());
////		System.out.println("점수2 입력>");
////		score2 = Integer.parseInt(sc.nextLine());
////		System.out.println("점수3 입력>");
////		score3 = Integer.parseInt(sc.nextLine());
////		
////		//avg = (score1+score2+score3)/3f;
////		avg = Math.round((score1+score2+score3)/3.0*100) / 100.0;
////		
////		switch((int)avg/10){
////		case 10: case 9:
////			grade = "A";
////			break;
////		case 8:
////			grade = "B";
////			break;
////		case 7:
////			grade = "C";
////			break;
////		case 6:
////			grade = "D";
////			break;
////		default:
////			grade = "F";
////		}
////		
////		System.out.println("총점 : "+(score1+score2+score3));
////		System.out.println("평균 : "+avg);
////		System.out.println("등급 : "+grade);
//		
//		//Math.round((score1+score2+score3)/3.0*100) / 100.0;
//		
//		//위에 전부 주석 처리하고 문제 풀기
//		//1~100 사이의 랜덤한 수를 3개 발생시키고 오름차순으로 출력
//
//		int temp;
//		int a = (int)(Math.random() * 100) + 1;
//		int b = (int)(Math.random() * 100) + 1;
//		int c = (int)(Math.random() * 100) + 1;
//		
//		System.out.println("정렬 전 : "+a+" "+b+" "+c);
//		
//		if(a>b){
//			temp = a;
//			a = b;
//			b = temp;
//			if(b>c){
//				temp = b;
//				b = c;
//				c = temp;
//			}
//			if(a>b){
//				temp = a;
//				a = b;
//				b = temp;
//			}
//		}else if(b>c){
//			temp = b;
//			b = c;
//			c = temp;
//			if(a>b){
//				temp = a;
//				a = b;
//				b = temp;
//			}
//			if(b>c){
//				temp = b;
//				b = c;
//				c = temp;
//			}
//		}else if(a>c){
//			temp = c;
//			c = a;
//			a = temp;
//			if(a>b){
//				temp = a;
//				a = b;
//				b = temp;
//			}
//			if(b>c){
//				temp = b;
//				b = c;
//				c = temp;
//			}
//		}		
//		
//		System.out.println("정렬 후 : "+a+" "+b+" "+c);
//		
//		
//		//선생님 풀이
//		int x = (int)(Math.random()*100)+1;
//		int y = (int)(Math.random()*100)+1;
//		int z = (int)(Math.random()*100)+1;
//		
//		if(x>y){
//			int t=x;
//			x=y;
//			y=t;
//		}
//		if(x>z){
//			int t=x;
//			x=z;
//			z=t;		
//		}
//		if(y>z){
//			int t=y;
//			y=z;
//			z=y;
//		}
//		
//		System.out.println(a+" < "+b+" < "+c);
//	}
//}
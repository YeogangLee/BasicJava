//package c_statement;
//
//import java.util.Scanner;
//
//public class SelfTest {
//
//	public static void main(String[] args) {
//		
//		char answer = ' ';
//		int yes = 0, no = 0, qno = 0;
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("<탄수화물 중독 자가진단 테스트> (출처: 식품의약품안전처) =========");
//		System.out.println("=====================================================");
//		System.out.println("테스트 방법 : 다음 항목에 해당된다면 O, 그렇지 않다면 X를 입력해 주세요.");		
//		System.out.println("=====================================================");
//		
//		System.out.println("1. 아침을 배불리 먹은 후 점심시간 전에 배가 고프다.");
//		answer = sc.nextLine().charAt(0);
//		qno++;
//		switch(answer){
//		case 'O': case 'o': yes++; break;
//		case 'X': case 'x': no++; break;
//		default: System.out.println("O 또는 X를 선택해주세요.");
//			if (yes + no != qno) {
//				answer = sc.nextLine().charAt(0);
//				switch(answer){
//				case 'O': case 'o': yes++; break;
//				case 'X': case 'x': no++; break;
//				}
//			}
//		}
//			
//		System.out.println("2. 밥, 빵, 과자 등 음식을 먹기 시작하면 끝이 없다.");
//		answer = sc.nextLine().charAt(0);
//		qno++;
//		switch(answer){
//		case 'O': case 'o': yes++; break;
//		case 'X': case 'x': no++; break;
//		default: System.out.println("O 또는 X를 선택해주세요.");
//			if (yes + no != qno) {
//				answer = sc.nextLine().charAt(0);
//				switch(answer){
//				case 'O': case 'o': yes++; break;
//				case 'X': case 'x': no++; break;
//				}
//			}		
//		}
//		
//		System.out.println("3. 음식을 금방 먹은 후에도 만족스럽지 못하고 더 먹는다.");
//		answer = sc.nextLine().charAt(0);
//		qno++;
//		switch(answer){
//		case 'O': case 'o': yes++; break;
//		case 'X': case 'x': no++; break;
//		default: System.out.println("O 또는 X를 선택해주세요.");
//			if (yes + no != qno) {
//				answer = sc.nextLine().charAt(0);
//				switch(answer){
//				case 'O': case 'o': yes++; break;
//				case 'X': case 'x': no++; break;
//				}
//			}
//		}
//		
//		System.out.println("4. 정말 배고프지 않더라도 먹을 때가 있다.");
//		answer = sc.nextLine().charAt(0);
//		qno++;
//		switch(answer){
//		case 'O': case 'o': yes++; break;
//		case 'X': case 'x': no++; break;
//		default: System.out.println("O 또는 X를 선택해주세요.");
//			if (yes + no != qno) {
//				answer = sc.nextLine().charAt(0);
//				switch(answer){
//				case 'O': case 'o': yes++; break;
//				case 'X': case 'x': no++; break;
//				}
//			}
//		}
//		
//		System.out.println("5. 저녁을 먹고 간식을 먹지 않으면 잠이 오지 않는다.");
//		answer = sc.nextLine().charAt(0);
//		qno++;
//		switch(answer){
//		case 'O': case 'o': yes++; break;
//		case 'X': case 'x': no++; break;
//		default: System.out.println("O 또는 X를 선택해주세요.");
//			if (yes + no != qno) {
//				answer = sc.nextLine().charAt(0);
//				switch(answer){
//				case 'O': case 'o': yes++; break;
//				case 'X': case 'x': no++; break;
//				}
//			}
//		}
//		
//		System.out.println("6. 스트레스를 받으면 자꾸 먹고 싶어진다.");
//		answer = sc.nextLine().charAt(0);
//		qno++;
//		switch(answer){
//		case 'O': case 'o': yes++; break;
//		case 'X': case 'x': no++; break;
//		default: System.out.println("O 또는 X를 선택해주세요.");
//			if (yes + no != qno) {
//				answer = sc.nextLine().charAt(0);
//				switch(answer){
//				case 'O': case 'o': yes++; break;
//				case 'X': case 'x': no++; break;
//				}
//			}
//		}
//		
//		System.out.println("7. 책상이나 식탁 위에 항상 과자, 초콜릿 등이 놓여있다.");
//		answer = sc.nextLine().charAt(0);
//		qno++;
//		switch(answer){
//		case 'O': case 'o': yes++; break;
//		case 'X': case 'x': no++; break;
//		default: System.out.println("O 또는 X를 선택해주세요.");
//			if (yes + no != qno) {
//				answer = sc.nextLine().charAt(0);
//				switch(answer){
//				case 'O': case 'o': yes++; break;
//				case 'X': case 'x': no++; break;
//				}
//			}
//		}
//		
//		System.out.println("8. 오후 5시가 되면 피곤함과 배고픔을 느끼고 일이 손에 안 잡힌다.");
//		answer = sc.nextLine().charAt(0);
//		qno++;
//		switch(answer){
//		case 'O': case 'o': yes++; break;
//		case 'X': case 'x': no++; break;
//		default: System.out.println("O 또는 X를 선택해주세요.");
//			if (yes + no != qno) {
//				answer = sc.nextLine().charAt(0);
//				switch(answer){
//				case 'O': case 'o': yes++; break;
//				case 'X': case 'x': no++; break;
//				}
//			}
//		}
//		
//		System.out.println("9. 과자, 초콜릿 등 단 음식은 상상만해도 먹고 싶어진다.");
//		answer = sc.nextLine().charAt(0);
//		qno++;
//		switch(answer){
//		case 'O': case 'o': yes++; break;
//		case 'X': case 'x': no++; break;
//		default: System.out.println("O 또는 X를 선택해주세요.");
//			if (yes + no != qno) {
//				answer = sc.nextLine().charAt(0);
//				switch (answer) {
//				case 'O': case 'o': yes++; break;
//				case 'X': case 'x': no++; break;
//				}
//			}		
//		}
//		
//		System.out.println("10. 다이어트를 위해 식이조절을 하는데 3일도 못 간다.");
//		answer = sc.nextLine().charAt(0);
//		qno++;
//		switch(answer){
//		case 'O': case 'o': yes++; break;
//		case 'X': case 'x': no++; break;
//		default: System.out.println("O 또는 X를 선택해주세요.");
//			if (yes + no != qno) {
//				answer = sc.nextLine().charAt(0);
//				switch (answer) {
//				case 'O': case 'o': yes++; break;
//				case 'X': case 'x': no++; break;
//				}
//			}
//		}
//		
//		System.out.println("===========================================");
//		System.out.println("진단자에게 해당되는 항목은");
//		System.out.println("총 "+yes+"개 입니다.");
//		System.out.println("===========================================");
//		System.out.println("[주의 - 위험 - 중독]");
//		
//		if(yes <= 3){
//			System.out.println("\"주의\"(0개~3개)에 해당합니다.");
//			System.out.println("위험한 수준은 아니지만 관리가 필요합니다.");
//		}else if(yes <= 6){
//			System.out.println("\"위험\"(4개~6개)에 해당합니다.");
//			System.out.println("탄수화물 섭취를 줄이기 위한 식습관 개선이 필요합니다.");
//		}else{
//			System.out.println("\"중독\"(7개 이상)에 해당합니다.");
//			System.out.println("전문의의 상담이 필요합니다.");
//		}
//		
//	}
//
//}

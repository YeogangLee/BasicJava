//package c_statement;
//
//import java.util.Scanner;
//
//public class SelfTest_check {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int count = 0;
//		
//		System.out.println("1. ...(Y/N)>");
//		//System.out.println("1. ...(1.예 / 0.아니오)>");
//		String answer = sc.nextLine();
//		if(answer.equals("Y")) count++;
//		
//		if(count < 3){
//			System.out.println("안전");
//		}else if(count == 3){
//			System.out.println("주의");
//		}else if(4 <= count && count <= 6){
//			System.out.println("위험");
//		}else{
//			System.out.println("중독");
//		}
//		
//	}
//
//}

// 과제
		// 다음과 같은 프로그램을 작성해주세요.
		/*
		 * ======== 회원가입 ==========
		 * 아이디>admin
		 * 비밀번호(4자리숫자)>1234
		 * 이름>홍길동
		 * 나이>30
		 * 키>185.5
		 * ==========================
		 * 회원가입 완료!!
		 * ========= 내정보 ===========
		 * 아이디 : admin
		 * 비밀번호 : 1234
		 * 이름 : 홍길동
		 * 나이 : 30세
		 * 키 : 185.5cm
		 * ==========================
		 */

package a_variable;

import java.util.Scanner;

public class Homework {

	public static void main(String[] args) {
		short age;
		int pw;
		float height;
		String name;
		String id;
		
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("======= 회원가입 =======");
		System.out.println("아이디>");
		id = sc.nextLine();
		System.out.println("비밀번호(4자리숫자)>");
		pw = Integer.parseInt(sc.nextLine());
		System.out.println("이름>");
		name = sc.nextLine();
		System.out.println("나이>");
		age = Short.parseShort(sc.nextLine());
		System.out.println("키>");
		height = Float.parseFloat(sc.nextLine());
		System.out.println("======================");
		System.out.println("회원가입 완료!!");
		System.out.println("======= 내 정보 ========");
		System.out.println("아이디 : "+id+"\n비밀번호 : "+pw+"\n이름 : "+name);
		System.out.println("나이 : "+age+"세"+"\n키 : "+height+"cm");
		System.out.println("======================");

	}

}

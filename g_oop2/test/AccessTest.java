package g_oop2.test;

import g_oop2.AccessModifier;

public class AccessTest extends AccessModifier {

	public static void main(String[] args) {
		
		AccessModifier am = new AccessModifier();
		
		System.out.println(am.publicVar);
		am.publicMethod();
		
//		System.out.println(am.protectedVar);
//		am.protectedMethod();
		//상속 받기
		// : 클래스 명 뒤에 extends 상속할 이름
		//상속 받았다 = 내꺼, 내꺼처럼 사용
		//AccessModifier 객체를 통해 사용하고 있어서 문제, 오류
		//아래에 AccessTets 객체 새로 생성해서 바르게 사용하기
		
//		System.out.println(am.defaultVar);
//		am.defaultMethod();
		
//		System.out.println(am.privateVar);
//		am.privateMethod();
		
		AccessTest at = new AccessTest();
		
		System.out.println(at.protectedVar);
		at.protectedMethod();
		
		
		/*
		 * 접근제어자를 사용하는 이유
		 * - 데이터를 보호하기 위해
		 * - 사용하는데 불필요한 멤버를 숨기기 위해
		 */
		
		
		Time t = new Time();
		
//		t.hour = 13;
//		t.minute = 590;
//		t.second = -30;
		t.setHour(13);
		t.setMinute(590);
		t.setSecond(55);
		
		System.out.println(t.getTime());
		
		t.clock();
		
	}

}

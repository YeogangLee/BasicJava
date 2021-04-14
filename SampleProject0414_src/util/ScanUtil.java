package util;

import java.util.Scanner;

public class ScanUtil {
	
	private static Scanner s = new Scanner(System.in);
	
	//객체 안 만들고 쓸 거라 static 사용
	public static String nextLine(){
		return s.nextLine();
	}
	
	public static int nextInt(){
		return Integer.parseInt(s.nextLine());
	}
	
	public static boolean nextBoolean(){
		return s.nextBoolean();
	}
}

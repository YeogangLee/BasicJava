package i_api;

import java.util.Scanner;

public class SetComma {

	public static void main(String[] args) {
		
		//숫자를 입력 받아 입력 받은 숫자에 3자리 마다 콤마(,)를 붙여 출력해주세요.
		//1,234,567
		
		/*
		 * 1
		 * 12
		 * 123
		 * 1,234			
		 * 12,345
		 * 123,456
		 * 1,234,567
		 * 
		 */
		
		final int digit = 3;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 입력>");
		String str = sc.nextLine();
		
		String strFin = "";
		String strSub = "";

		for(int i = str.length()/digit; 0 <= i; i--){
			
			int endIndex = str.length()-digit*i;
			int startIndex = endIndex - digit;
			
			if(startIndex < 0){
				startIndex= 0;
			}
			
			strSub = str.substring(startIndex, endIndex);
			
			strFin += strSub;
			
			if(endIndex != str.length() && startIndex != endIndex){
				strFin += ",";
				
				/*
				 * 1. endIndex 의 제일 처음 시작값은 str 길이
				 *    제일 처음은 strFin에 콤마를 저장하지 않는다
				 *    -> 출력할 때 숫자 제일 뒤에 콤마 출력X
				 *   
				 * 2. startIndex는 endIndex보다 항상 작다
				 *    startIndex가 endIndex와 일치한다면, strFin에 저장할 문자열이 남아있지 않은 것
				 *    -> 출력할 때 숫자 제일 앞에 콤마 출력X
				 */
			}
			

			/* 일반식 구하기  */
//			String str1 = ""; String str2 = "";	String str3 = ""; String str4 = "";
//			String str = "0123456789";
//			str1 = str.substring(0,1);
//			str2 = str.substring(1,4);
//			str3  = str.substring(4,7);
//			str4 = str.substring(7,10);
//			System.out.println(str0 + "," + str1 + "," + str2 + "," + str3);

								//str.length()-3*4 -> 0
//			str1 = str.substring(0, str.length()-3*3);
//			str2 = str.substring(str.length()-3*3,str.length()-3*2);
//			str3 = str.substring(str.length()-3*2,str.length()-3*1);
//			str4 = str.substring(str.length()-3*1,str.length()-3*0);
			
//			str1 = str.substring(startIndex, endIndex-3*3);
//			str2 = str.substring(endIndex-3*3,endIndex-3*2);
//			str3 = str.substring(endIndex-3*2,endIndex-3*1);
//			str4 = str.substring(endIndex-3*1,endIndex-3*0);

//		=>	strSub = str.substring(startIndex, str.length()-3*i);
			
		}
		System.out.println("strFin :" + strFin);
		
	}

}

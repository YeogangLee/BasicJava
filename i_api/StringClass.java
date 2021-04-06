package i_api;

import java.util.Arrays;

public class StringClass {

	public static void main(String[] args) {
		/*
		 * String
		 * - 여러 개의 문자를 사용하기 쉽게 만들어 놓은 클래스
		 * 
		 * String의 주요 메서드
		 * - equals() : 문자열의 [내용]이 같은지 반환한다.
		 * - length() : 문자열의 [길이]를 반환한다.
		 * - charAt() : 특정 인덱스에 [위치한 문자]를 반환한다. - 인덱스를 넘기면 문자를 반환
		 * - substring() : 문자열의 [특정 부분]을 잘라서 반환한다.
		 * - indexOf() : 문자열 내의 [특정 문자의 인덱스]를 반환한다.
		 * - contains() : 문자열이 [특정 문자열을 포함]하고 있는지 여부를 반환한다.
		 * - split() : 문자열을 특정 문자를 기준으로 나누어 배열 형태로 반환한다.
		 * - trim() : 문자열 앞뒤의 공백을 제거해 반환한다.
		 * - valueOf() : 다른 타입의 데이터를 문자열로 변환해 반환한다. - 형변환 메서드
		 */

		//boolean .equals()
		boolean equals = "문자열".equals("문자열");
		System.out.println(equals);
		
		String str1 = "문자열";
		String str2 = null;
		System.out.println(str1.equals(str2));	//false - 파라미터에는 null값 허용
		//System.out.println(str2.equals(str1));	//에러	- .equals()를 적용할 앞에 문자열은 null값 허용X
												//		    그래서 null이 오지 않을 변수만 사용하는 게 좋다
		
		//char charAt()
		String str = "12345";
		for(int i = 0; i < str.length(); i++){
			char charAt = str.charAt(i); // charAt() : 문자열 아닌, 문자를 반환
			System.out.println(charAt);
		}
		
		String rev = "";
		for(int i = str.length() - 1; 0 <= i; i--){
			rev += str.charAt(i); // charAt() : 문자열 아닌, 문자를 반환
		}
		System.out.println(rev);
		
		
		// String substring()
		str = "0123456789";
		//substring() : 파라미터 1개-시작인덱스, 2개-시작,끝 인덱스 가능
		String sub1 = str.substring(0); //0번 인덱스부터 잘라서 반환, 문자열 반환
		System.out.println(sub1);
		String sub2 = str.substring(4,9); //4번 인덱스부터 9번 인덱스 "전까지" 잘라서 반환한다
		System.out.println(sub2);
		
		
		// int indexOf()
		str = "수박 오렌지 귤 블루베리";
		int index = str.indexOf("오렌지"); //3반환, 오만 찾아도 같은 3 반환, 한 글자씩 인덱스에 저장
		System.out.println(index);
		
		String[] menu = {
			"수박 20000원",
			"오렌지 100000원",
			"귤 500원",
			"블루베리 3000원"
		};
		//과일 이름만 저장하고 싶을 때, 과일 이름은 공백 전에 끝난다. 
		
		//과일 이름
		for(int i = 0; i < menu.length; i++){
			String name = menu[i].substring(0, menu[i].indexOf(" "));
			System.out.println(name);
		}
		
		//가격
		//가격만 잘라서 int 타입 변수에 저장
		//String -> int 형변환 : Integer.parseInt(문자열)
		for(int i = 0; i < menu.length; i++){
			String priceS = (menu[i].substring(menu[i].indexOf(" ")+1, menu[i].length()-1));
			int price = Integer.parseInt(menu[i].substring(menu[i].indexOf(" ")+1, menu[i].indexOf("원")));
						//valueOf()는 int -> String
			System.out.println(price);
		}
		
		
		//boolean contains()
		str = "abcd";
		boolean contains = str.contains("c");
		System.out.println(contains);
		
		for(int i = 0; i < menu.length; i++){
			if(menu[i].contains("오렌지")){
				System.out.println("오렌지는 " + i + "번 인덱스에 있습니다.");
			}// 수박은 0번 인덱스
		}
		
		
		//String[] split()
		str = "a/b/c";
		String[] split = str.split("/");
		System.out.println(Arrays.toString(split));
		String s = "";
		for(int i = 0; i < split.length; i++){
			s += split[i];
			System.out.println("s는 " + s + "입니다.");
		}
		
		//split()을 이용, 배열 값 나누기
		for(int i = 0; i < menu.length; i++){
			String[] split2 = menu[i].split(" ");
			System.out.println("메뉴명 : " + split2[0] + " / 가격 : " + split2[1]);
		}
		
		
		//String trim()
		str = "	문 자열	";
		String trim = str.trim();
		System.out.println("[" + str + "] -> [" + trim + "]");
		//앞 뒤 공백만 제거, 문자 사이의 공백은 제거X
		//쓸데없어 보이는데, 쓸 때가 있다. -> 사용자의 입력 실수를 방지
		
		String id = " myid";
		String password = "mypassword "; //문자열 뒤에 있는 공백은 더 찾기가 어렵다.
		System.out.println(id);
		System.out.println(password);
		System.out.println(id.trim());
		System.out.println(password.trim());
		
		//String valueOf()
		int number = 10;
		Integer numInteger = 0;
		//String으로의 형변환 방법 2가지
		//1. valueOf()
		str = String.valueOf(number);
		//2. number + ""(빈문자열), 문자열과 만났기 때문에 자동적으로 문자열로 변환된다
		str = number + "";
		
		System.out.println("numInteger : "+ numInteger.getClass().getName());
		System.out.println("str        : " + str.getClass().getName());
		
	}

}

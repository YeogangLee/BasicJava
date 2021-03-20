package b_operator;

public class ArithmeticOperator {

	public static void main(String[] args) {
		//class 생성할 때 제일 첫 번째 체크박스 이름 : 메인메서드
		/*
		 * 산술연산
		 * - 사칙연산 : +,-,*,/,%(나머지)
		 * - 복합연산자 : +=, -=, *=, /=, %=
		 * - 증감연산자 : ++, --
		 * 
		 */
		
		int result = 10 + 20 - 30 * 40 / 50 % 60; //%의 우선순위는 *,/와 동일
		System.out.println(result);
		
		//나머지 연산
		result = 10 / 3;
		System.out.println(result);
		result = 10 % 3;
		System.out.println(result);
		
		//5개의 산수 연산자를 사용해 5개의 연산을 수행 후 출력해주세요.
		int var1, var2=2, var3=3;
		var1 = var2 + var3;
		System.out.println("+ = "+var1);
		var1 = var2 - var3;
		System.out.println(var1);
		var1 = var2 * var3;
		System.out.println(var1);
		var1 = var2 / var3;
		System.out.println(var1);
		var1 = var2 % var3;
		System.out.println(var1);
		
		//복합연산자
		result = result + 3;
		result += 3;
		
		result -=5;
		
		result *=2;
		
		//아래의 문장을 복합연산자를 사용한 문장으로 만들어주세요.
		result += 10;
		result %= 5;
		result -= 2*3;

		
		//증감연산자
		//증가연산자(++) : 변수의 값을 1 증가시킨다
		//감소연산자(--) : 변수의 값을 1 감소시킨다
		
		int i = 0;
		++i; //전위형: 변수의 값을 읽어오기 전에 1 증가된다
		i++; //후위형: 변수의 값을 읽어온 후에 1 증가된다
		--i;
		i--;
		
		i = 0;
		System.out.println("++i = "+ ++i); //1
		i = 0;
		System.out.println("i++ = "+ i++); //0		
		System.out.println(i);		
		
		
		//연산자 사용시 주의사항 : 
		//피연산자의 타입이 서로 같아야만 연산이 가능하다.
		
		int _int = 10;
		double _double = 3.14;
		double result2 = _int + _double;
		//자동으로 이루어진 형변환 - double과 double의 연산
		//생략 가능한 형변환: 작은 것 -> 큰 것으로 변환
		System.out.println(result2);
		
		long _long = 100L;
		_long = _int + _long; //long타입의 결과
		_int = _int + (int)_long; // double => int 형변환
		
		byte _byte = 5;
		short _short = 10;
		_int = _byte + _short; 
		//int보다 작은 타입은 int로 형변환된다
		//char, short가 int로 형변환되는 이유
		// => 연산의 최소 단위인 4바이트가 되어야만 연산 가능
		
		char _char = 'a';
		char _char2 = 'b';
		_int = _char + _char2;
		System.out.println(_int);
		
		
		//## 오버플로우, 언더플로우
		//표현범위를 벗어나는 값을 표현할 때 발생하는 현상
		//오버플로우: 변수 자료형의 최대값을 벗어날 때 발생, 범위를 벗어난 양수는 음수로 바뀜 
		//언더플로우: 변수 자료형의 최소값을 벗어날 때 발생, 범위를 벗어난 음수는 양수로 바뀜
		byte b = 127;
		b++;
		System.out.println(b); //-128
		b--;
		System.out.println(b); //127
		
		//00000000 - 0/1이 8개 있는 게 1바이트, 8bit = 1byte
		//맨 앞자리는 부호를 표시, 나머지 7자리로 숫자 표현 : 2^7
		// byte 2^7 의 표현 범위 : -2^7 ~ 2^7 - 1
		// 2^7 = 128
		// -2^15 ~ 2^15 - 1  //6만 ~
		//int : -2^31 ~ 2^31 - 1
		//long : -2^63 ~ 2^63 - 1
		//char : 0 ~ 2^16 //3만~ char는 음수를 표현할 필요가 없으므로 양수만 표현
		
		
		//다음을 한 줄씩 계산해서 최종 결과값을 출력해주세요.
		//1. 123456 + 654321
		//2. 1번의 결과값 * 123456
		//3. 2번의 결과값 / 123456
		//4. 3번의 결과값 - 654321
		//5. 4번의 결과값 % 123456
		
		//int var4, var5, var6, var7;
		long var4, var5, var6, var7;
		long var33;
		
		var1 = 123456;
		var2 = 654321;
		var33 = var1 + var2;
		System.out.println("var3 : "+var33);
		var4 = var33 * var1;
		System.out.println(var4);
		var5 = var4 / var1;
		System.out.println(var5);
		var6 = var5 - var1;
		System.out.println(var6);
		var7 = var6 % var1;
		System.out.println(var7);
		
		//0
		long res = 123456 + 654321;
		//res = res * 123456;
		res *= 123456;
		res /= 123456;
		res -= 654321;
		res %= 123456;
		System.out.println("res = "+res);
		
		
		//3개의 int형 변수를 선언 및 초기화 후 합계와 평균을 출력해 주세요.
		int int1 = 15, int2 = 34, int3 = 49;
		long sum;
		double avg;
		sum = int1+int2+int3;
		//avg = sum/3; // 결과는 int
		avg = sum/3.0; //double은 둘 중 하나를 double로 바꿔야 결과가 double로 나온다.
		System.out.println("합계 : "+sum+" 평균 :"+avg);
		
		//반올림 함수
//		avg = Math.round(avg); //무조건 소수점 첫번째 자리에서 반올림 -> 결과가 정수
//		System.out.println(avg);

		//소수점 첫째 자리까지 출력
		avg = Math.round(avg*10)/10.0; //살리고 싶은 소수점 자리수만큼 10을 곱해주고 나눠준다. 
		System.out.println(avg);
		
		//랜덤값 발생 함수
		//Math.random() : 0.0 ~ 1.0미만(0.999999...)
		//Math.random() * 100 : 0 ~ 99 		
		int random = (int)(Math.random() * 100) + 1; //1 ~ 100까지의 랜덤 숫자
		System.out.println(random);
		
		
		
	}

}

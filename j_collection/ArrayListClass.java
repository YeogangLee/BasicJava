package j_collection;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListClass {

	public static void main(String[] args) {

		/*
		 * Collections Framework
		 * - 다수의 데이터를 다루기 위한 표준 방식
		 * - List
		 * - Map
		 * - Set 
		 * 
		 * -> 전부 인터페이스, 인터페이스는 추상메서드를 가지고 부모의 역할만 한다 //??
		 * List, Map을 주로 사용한다
		 * 그 중에서도 각각 한 가지만 알아볼 것
		 * List - ArrayList, Map - HasingMap
		 * 
		 * 오늘 List, 내일 Map
		 * 
		 * ArrayList의 주요 메서드
		 * -- add 메서드 : 파라미터 1개, 파라미터 2개
		 * - boolean add(Object obj) : 마지막 위치에 객체를 추가 후 성공여부를 반환한다.
		 * 
		 * - void add(int index, Object obj) : 지정된 위치에 객체를 추가한다.
		 *   ㄴ 기존 인덱스를 벗어난 인덱스에 저장을 할 수는 없다
		 * 
		 * - Object set(int index, Object obj) : 지정된 위치에 객체를 저장 후 기존 객체를 반환한다.
		 *   ㄴ set vs add : 기존 값 덮어쓰기 vs 기존 값 밀기 -> add는 한 번 수행시, 인덱스 번호를 하나 증가
		 * 
		 * - Object get(int index) : 지정된 위치의 객체를 반환한다.
		 * 
		 * - int size() : 저장된 객체의 수를 반환한다.
		 * 
		 * - Object remove(int index) : 지정된 위치의 객체를 제거한다.
		 *   ㄴ 뒤에 있는 자료들은 한 칸씩 앞으로 -> 한 번 수행시, 인덱스 번호가 각각 하나 줄어든다
		 * 
		 * 배열과의 차이점 
		 * : ArrayList는 처음 길이가 0
		 *   저장하는 만큼 길이가 계속 늘어나고, 데이터를 삭제하면 길이도 줄어든다. 
		 *   => 저장한 개수만큼 길이를 유지
		 */
		
		ArrayList sample = new ArrayList();
		
		sample.add("abc");
		sample.add(100);
		sample.add(new Scanner(System.in));
		//장점 : 자료형에 관계없이 저장 가능, 심지어 스캐너 객체까지도
		//단점 : 인덱스 번호로 접근해서 꺼냈을 때 자료형을 예측하기 어렵다.
		
		//-> 제네릭 사용 권장
		ArrayList<Integer> list = new ArrayList<>();
		//제네릭 : ArrayList 뒤에 <저장할 자료형>을 명시
		
		list.add(new Integer(10));
//		list.add("abc"); //컴파일 에러 발생
		list.add(20); //int를 넣어도 ㄱㅊ
		//Wrapper 클래스 
		//: 기본형 타입을 사용하고 싶은데, 그 기본형 타입을 그대로 사용할 수 없고 객체로 사용해야 할 때가 있다.
		//ex. 지금처럼, ArrayList에는 객체만 올 수 있기 때문에 int가 아닌 Integer 사용
		
		/*
		 * 래퍼 클래스
		 * - byte		: Byte
		 * - short		: Short
		 * - int		: Integer
		 * - long		: Long
		 * - float		: Float
		 * - double		: Double
		 * - boolean	: Boolean
		 * - char		: Character
		 * 
		 *  서로 자동으로 형변환이 이루어진다
		 *  //t//인터넷 사이트 참고
		 *  http://www.tcpschool.com/java/java_api_wrapper
		 */
		
		System.out.println(list);
		
		// void add(인덱스, 저장할 값)
		list.add(1, 30); // 첫번째 파라미터 : 인덱스, 두번째 파라미터 : 저장할 값
		System.out.println(list);
		
		// Object set()
		int before = list.set(2, 40);
		System.out.println("before : " + before);
		System.out.println("after : " + list.get(2)); // get(n)값을 가져올 때 사용
		System.out.println(list);
		
		// int size()
		for(int i = 0; i < list.size(); i++){
			System.out.println(i + " : " + list.get(i));
		}
		
		// Object remove()
		int remove = list.remove(1);
		System.out.println(list);
		System.out.println("list에서 제거된 값 : " + remove);
		
		//ArrayList의 값을 제거 할 때 for문을 거꾸로 돌려야 하는 이유
		//: 뒤에서부터 비교해야 비교가 정확하다 -> 모든 데이터 삭제 가능
		for(int i = list.size() - 1; i >= 0; i--){
			list.remove(i);
		}
		System.out.println(list);
		
		
		//list에서 1~100 사이의 랜덤값을 10개 저장해 주세요.
		for(int i = 0; i < 10; i++){
			int random = (int)(Math.random()*100)+1;
			list.add(random);
		}
		System.out.println(list);
		
		
		//list에 저장된 값의 합계와 평균을 구해주세요.
		int sum = 0;
		for(int i = 0; i < list.size(); i++){
			sum += list.get(i);
		}
		double avg = (double)sum/list.size(); 
		System.out.println("합계 : " + sum + " 평균 : " + avg);
		
		//최소값과 최대값 출력
		int min = list.get(0);
		int max = list.get(0);
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) < min){
				min = list.get(i);
			}
			if(max < list.get(i)){
				max = list.get(i);
			}
		}
		System.out.println(min + " / " + max);
		
		//list.set(index, 값);
		//list를 오름차순으로 정렬
		for(int i = 0; i < list.size()-1; i++){
			min = 1;
			for(int j = 1; j < list.size(); j++){
				if(list.get(j) < list.get(min)){
					min = j;
				}
			}
			int temp = list.get(i);
			list.set(i, list.get(min));
			list.set(min, temp);
		}
		System.out.println(list);
		//이렇게들 많이 썼던데,
		//list.get(i) = list.get(min)
		//이건 값에 값을 넣는 것, 상수에 상수 대입 -> 불가능
		//대입 연산자 = 의 왼쪽은 반드시 변수여야 한다.
		
		//2차원 배열으로써의
		//ArrayList 사용
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<>(); 
		
		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(10);
		list3.add(20);
		list3.add(30);
		
		list2.add(list3); //list3이라는 변수를 저장한 게 아니라, ArrayList<>를 저장한 것
		
		//변수 그릇 재사용, 그릇은 같아도 내용물이 새 거면 바뀌는 거다
		list3 = new ArrayList<>();
		list3.add(40);
		list3.add(50);
		
		list2.add(list3);
		
		//리스트 출력
		for(int i = 0; i < list2.size(); i++){
//			ArrayList<Integer> list4 = list2.get(i);
//			for(int j = 0; j < list4.size(); j++){
//				System.out.println(list4.get(j) + "\t");
//			}
//			System.out.println();
			
			//위와 다른 방법
			//변수를 사용하지 않고, 2차원 배열에 있는 값을 꺼내고 또 꺼내는 방식 
			for(int j = 0; j < list2.get(i).size(); j++){
				System.out.print(list2.get(i).get(j)+" ");
			}
			System.out.println();
		}
		
	}
}


package j_collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class HashMapClass {

	public static void main(String[] args) {

		/*
		 * Object put(Object key, Object value) : 지정된 키와 값을 저장한다.
		 * Object remove(Object key) : 지정된 키로 저장된 값을 제거한다.
		 * Object get(Object key) : 지정된 키의 값(없으면 null)을 반환한다.
		 * Set keySet() : 저장된 모든 키를 Set자료형으로 반환한다.
		 * 
		 * hashmap
		 * 인덱스 존재 X => 순서라는 개념X
		 * 인덱스 대신 키가 존재
		 * 본인이 만든 게 아닌 이상 키를 알기가 어렵다
		 * keySet()을 이용하면 모든 키를 알 수가 있다
		 * 
		 * 테이블을 나타내는 데에 자주 쓰인다.
		 * 여기서 말하는 테이블은, SQL의 테이블이다.
		 * 키는 컬럼명, 값은 컬럼의 각 행 데이터
		 *  
		 * 해쉬맵 하나로 테이블의 한 행 저장 가능
		 * 테이블은 다수의 행 -> ArrayList에 여러 개의 HashMap을 저장, 그러면 테이블 표현 가능
		 */
		
		HashMap<String, Object> map = new HashMap<>();
		//키는 웬만하면 String 타입
		//ArrayList는 인덱스를 알아도 자료 예측이 어렵지만,
		//HashMap에서는 키를 알면 어떤 자료일지 예상할 수가 있다
		//키가 String자료형이므로 의미 있는 네이밍이 가능하기 때문 
		
		map.put("age", 10);
		map.put("name", "홍길동");
		map.put("date", new Date());
		
		System.out.println(map);
		//순서가 없기 때문에, 저장한 순서대로 출력되지 않는다.
		
		map.put("name", "이순신");
		//같은 키를 사용 -> 데이터 덮어쓰기
		
		System.out.println(map);
		System.out.println("age 삭제 전 map 크기 :"+map.size());
		map.remove("age");
		//remove(키) : 데이터와 키가 함께 삭제된다
		System.out.println("age 삭제 후\n"+map);
		System.out.println("age 삭제 후 map 크기 :"+map.size());
		
		Object value = map.get("name");
		//자료형이 Object인 이유 : HashMap을 생성할 때 Object로 생성했기 때문
		System.out.println("value : " + value);
		
		String str = (String)map.get("name");
		//String으로 꺼내오고 싶으면 이렇게 형변환 후 get()
		System.out.println("str : " + str);
		
		Set<String> keys = map.keySet();
		//Set은 자주 쓰이는 자료형이 아니다.
		//이유
		//1. Set은 중복된 값을 허용하지 않음
		//2. Set에서 값을 꺼낼 수 있는 메서드가 존재하지 않음
		//   -> 향상된 for문을 사용해서 값 꺼내기 가능
		
		
		for(String key : keys){//향상된 for문
			System.out.println(key + " : " + map.get(key));
			/*
			 * : 의 오른쪽에는 여러 데이터를 저장할 수 있는 형태의 데이터가 온다
			 * : 의 왼쪽에는 변수가 오는데, 변수의 자료형은 저장된 값 중 하나
			 */
			
		}
		
		HashMap<String, Object> row = new HashMap<>();
		row.put("id", "admin");
		row.put("password", "admin123");
		row.put("name", "관리자");
		row.put("tel", "010-1234-5678");
		// => 회원 테이블의 한 행이 해쉬맵에 저장된 것
		
		ArrayList<HashMap<String, Object>> table = new ArrayList<>();
		table.add(row);
		System.out.println(table);
		//자바에서 앞으로 이런 식으로 작업할 것
		
		HashMap<String, Object> dog = new HashMap<>();
		dog.put("id", "hunde");
		dog.put("password", "dog");
		dog.put("name", "후네");
		dog.put("tel", "010-1111-9999");
		
		table.add(dog);
		System.out.println(table);
		
		/*
		 * LPROD_ID		LPROD_GU	LPROD_NM
		 * 1			P101		컴퓨터제품
		 * 2			P102		전자제품
		 * 3			P201		여성캐주얼
		 * 4			P202		남성캐주얼
		 * 5			P301		피혁잡화
		 */
		
		ArrayList<HashMap<String, Object>> LPROD = new ArrayList<>();
		
		HashMap<String, Object> row1 = new HashMap<>();
		row1.put("LPROD_ID", "1");
		row1.put("LPROD_GU", "P101");
		row1.put("LPROD_NM", "컴퓨터제품");
		
		LPROD.add(row1);
		
		HashMap<String, Object> row2 = new HashMap<>();
		row2.put("LPROD_ID", "2");
		row2.put("LPROD_GU", "P102");
		row2.put("LPROD_NM", "전자제품");
		
		LPROD.add(row2);
		
		HashMap<String, Object> row3 = new HashMap<>();
		row3.put("LPROD_ID", "3");
		row3.put("LPROD_GU", "P201");
		row3.put("LPROD_NM", "여성캐주얼");
		
		LPROD.add(row3);
		
		
		HashMap<String, Object> row4 = new HashMap<>();
		row4.put("LPROD_ID", "4");
		row4.put("LPROD_GU", "P202");
		row4.put("LPROD_NM", "남성캐주얼");
		
		LPROD.add(row4);
		
		
		HashMap<String, Object> row5 = new HashMap<>();
		row5.put("LPROD_ID", "5");
		row5.put("LPROD_GU", "P301");
		row5.put("LPROD_NM", "피혁잡화");
		
		LPROD.add(row5);
		
//		System.out.println(LPROD);
		
		System.out.println();
		System.out.println("LPROD_ID    LPROD_GU    LPROD_NM");
		for(int i = 0; i < LPROD.size(); i++){
			//System.out.println(row1.get("LPROD_GU"));
			System.out.print(LPROD.get(i).get("LPROD_ID")+"\t    ");
			System.out.print(LPROD.get(i).get("LPROD_GU")+"\t");
			System.out.print(LPROD.get(i).get("LPROD_NM")+"\t");
			System.out.println();
		}
		
		System.out.println("\n선생님");
		
		row = new HashMap<>();
		row.put("LPROD_ID", "5");
		row.put("LPROD_GU", "P301");
		row.put("LPROD_NM", "피혁잡화");
		table.add(row);
		
		System.out.println("LPROD_ID\tLPROD_GU\tLPROD_NM");
		for(int i = 0; i < table.size(); i++){
			HashMap<String, Object> _row = table.get(i);
			System.out.println(_row.get("LPROD_ID") + "\t\t"
					+ _row.get("LPROD_GU") + "\t\t" + _row.get("LPROD_NM"));
		}
		
	}

}

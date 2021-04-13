package k_jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDBCTest {

	public static void main(String[] args) {

		JDBCUtil jdbc = JDBCUtil.getInstance();
		
		//반환자료형 자동으로 붙여주는 단축키 뭐더라
		//-> 대입할 값만 먼저 적고 끝에서 ctrl + 1 > new local variable ... 선택
		
		//물음표가 있는 메서드 사용을 위해, 물음표가 있는 쿼리
		String sql = "SELECT * FROM cart WHERE cart_member = ?";
		ArrayList<Object> param = new ArrayList<>();
		param.add("a001");
		
		//4.
		List<Map<String, Object>> list = jdbc.selectList(sql, param);
		
		for(int i = 0; i < list.size(); i++){
			Map<String, Object> row = list.get(i);
			for(String key : row.keySet()){ //향상된 for문
				System.out.print(key + " : " + row.get(key) + "\t");
			}
			System.out.println();
		}
				
	}

}

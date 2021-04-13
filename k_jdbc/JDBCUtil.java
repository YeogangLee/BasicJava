package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List; //utilPackage에 있는 것
import java.util.Map;

public class JDBCUtil {

	//유틸파일, 여러곳에서 객체를 생성해서 사용
	//불필요한 객체 -> 그래서 지금 다른 디자인을 적용시킬 것
	//프라이빗이 붙은 생성자 -> 다른 클래스에서 객체 생성 불가, 이 클래스 안에서만 생성자 사용 가능
	
	//싱글톤 패턴 : 인스턴스의 생성을 제한하여, 한정된 인스턴스만 사용하는 디자인 패턴
	private JDBCUtil(){
		
	}
	
	//인스턴스를 보관할 JDBCUtil 타입의 변수 instance
	private static JDBCUtil instance;
	// 초기화를 안 해서 지금 기본값인 null값이 들어있다.
	
	//인스턴스를 빌려주는 메서드
	//: 필요하다는 요청이 들어올 때, 변수를 새로 만드는 것이 아닌, 변수를 가지고 있다가 반환한다.
	public static JDBCUtil getInstance(){
		if(instance == null){
			instance = new JDBCUtil();
		}
		return instance;
	}
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "stu";
	String pass = "java";
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/*
	 * Map<String, Object> selectOne(String sql)
	 * Map<String, Object> selectOne(String sql, List<Object> param)
	 * 
	 * List<Map<String, Object>> selectList(String sql)
	 * List<Map<String, Object>> selectList(String sql, List<Object> param)
	 * 
	 * int resultOfUpdate(String sql)
	 * int resultOfUpdate(String sql, List<Object> param)
	 */
	
	/*
	 * 6개의 메서드
	 * 
	 * - selectOne() : 조회의 결과가 1줄일 때 사용하는 메서드
	 * Map<String, Object> selectOne(String sql) : Map리턴, Map은 인터페이스고 클래스는 HashMap, 저번에 sql 테이블의 1행 반환 가능하다고 했죠
	 * Map<String, Object> selectOne(String sql, List<Object> param) : List는 인터페이스, 클래스는 ArrayList, 물음표의 값을 순서대로 ArrayList에 저장
	 * : 밑에 있는 쿼리는 물음표가 있는 쿼리, 뒤의 파라미터 위치에 물음표에 들어갈 값을 적어준다. 값을 하나씩 하나씩 넣는 것
	 * 
	 * - selectList() : 조회의 결과가 여러 줄일 때 사용하는 메서드
	 * List<Map<String, Object>> selectList(String sql) : Map을 List에 담아서 반환
	 * List<Map<String, Object>> selectList(String sql, List<Object> param) : 마찬가지로 Map은 물음표가 있는 쿼리 ...
	 * ㄴ 이것만 선생님과 같이 연습
	 * 
	 * - update() : select를 제외한 나머지 이벤트를 사용하는 메서드
	 * int update(String sql) : int 타입 리턴, execute query - 쿼리로 인해 몇 줄 영향 받았다 할 때 그 숫자, int 자료형
	 * int update(String sql, List<Object> param)
	 * 
	 * 선생님께 죄송하지만 메서드명 수정 => resultOfUpdate()
	 * 
	 */
	
	//1.
	public Map<String, Object> selectOne(String sql){
		//반환할 값은 try블럭 밖에 선언 + 가능하다면 null 값 대입
		HashMap<String, Object> oneRow = null; //권장방법
//		HashMap<String, Object> oneRow = new HashMap<>(); (X)
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			while(rs.next()){
				oneRow = new HashMap<>();
				for(int i = 1; i <= columnCount; i++){
					String key = metaData.getColumnName(i);
					Object value = rs.getObject(i);
					oneRow.put(key, value);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		//Map<String, Object> 반환
		return oneRow;
		
	}
	
	//2.
	public Map<String, Object> selectOne(String sql, List<Object> param){
		HashMap<String, Object> row = null;
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			
			for(int i = 0; i < param.size(); i++){
				ps.setObject(i+1, param.get(i));
			}
			
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			while(rs.next()){
				row = new HashMap<>();
				for(int i = 1; i <= columnCount; i++){
					String key = metaData.getColumnName(i);
					Object value = rs.getObject(i);
					row.put(key, value);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		//Map<String, Object> 반환
		return row;
		
	}
	
	//3.
	public List<Map<String, Object>> selectList(String sql){
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			while(rs.next()){
				HashMap<String, Object> row = new HashMap<>();
				for(int i = 1; i <= columnCount; i++){
					String key = metaData.getColumnName(i);
					Object value = rs.getObject(i);
					row.put(key, value);
				}
				list.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		//List<Map<String, Object>> 반환
		return list;
	}
	
	//5.
	public int resultOfUpdate(String sql){
		int result = 0;
		//값을 초기화하지 않으면 return 불가능
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		//int 반환
		return result;
		
	}
	
	//6.
	public int resultOfUpdate(String sql, List<Object> param){
		int result = 0;
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			for(int i = 0; i < param.size(); i++){
				ps.setObject(i+1, param.get(i));
			}
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		//int 반환
		return result;
	}
	
	//4.
	public List<Map<String, Object>> selectList(String sql, List<Object> param){
		List<Map<String, Object>> list = new ArrayList<>();
		// List는 인터페이스, 클래스는 ArrayList
		
		/*
		 * - 자바의 다형성 관련
			클래스를 생성할 때 도형 타입으로 생성하게 되면 정사각형이 아닌
			다른 직사각형, 삼각형 등 도형 인터페이스를 구현한 클래스에서 사용 될 수 있습니다.
			하지만 정사각형 클래스로 생성하게 되면 직사각형, 삼각형 등 에서는 사용할 수 없습니다.
			
			도형에 비유하여 풀어보면,
			
			List list = new ArrayList();
			-> 도형 list = new 정사각형();
			
			ArrayList list = new ArrayList();
			-> 정사각형 list = new 정사각형();
			
			출처: https://yoon-dailylife.tistory.com/7 [알면 쓸모있는 개발 지식]
		 * 
		 */
		//
		List<HashMap<String, Object>> list2 = new ArrayList<>();
		ArrayList<Map<String, Object>> list3 = new ArrayList<>();
		ArrayList<HashMap<String, Object>> list4 = new ArrayList<>();
		
		Map<String, Object> q = new HashMap<>();
		HashMap<String, Object> q2 = new HashMap<>();
		//
		
		try {
			//con에 값 넣으면 ctrl + 1해서  try-catch 적용
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			//List라서 for문 사용 - List<Object> param : 
			for(int i = 0; i < param.size(); i++){
				//물음표에 들어갈 값을 하나씩 넣기
				ps.setObject(i+1, param.get(i));
				//i+1의 이유는, ?의 인덱스는 1부터 시작하기 때문, sql도 마찬가지로 1부터 시작
			}
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			while(rs.next()){
				HashMap<String, Object> row = new HashMap<>();
				//for문이 한 행의 데이터
				for(int i = 1; i <= columnCount; i++){
					String key = metaData.getColumnName(i); //key는 컬럼의 이름
					Object value = rs.getObject(i);
					//for문 안에서 한 행의 값을 넣어주기
					row.put(key, value);
				}
				//한 행이 끝나면 List에 넣어주기
				list.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		} // finally는 복사해서 사용
		
		//List<Map<String, Object>> 반환
		return list;
		
	} 	
	
	
	
}








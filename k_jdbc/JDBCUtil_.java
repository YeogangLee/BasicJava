package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtil_ {
	
	//싱글톤 패턴 : 인스턴스의 생성을 제한하여 하나의 인스턴스만 사용하는 디자인 패턴
	private JDBCUtil_(){
		
	}

	//인스턴스를 보관할 변수
	private static JDBCUtil_ instance;
	
	//인스턴스를 빌려주는 메서드
	public static JDBCUtil_ getInstance(){
		if(instance == null){
			instance = new JDBCUtil_();
		}
		return instance;
	}
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "sem";
	String password = "java";
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	/*
	 * Map<String, Object> selectOne(String sql)
	 * Map<String, Object> selectOne(String sql, List<Object> param)
	 * List<Map<String, Object>> selectList(String sql)
	 * List<Map<String, Object>> selectList(String sql, List<Object> param)
	 * int update(String sql)
	 * int update(String sql, List<Object> param)
	 */
	
	public Map<String, Object> selectOne(String sql){
		Map<String, Object> row = null; //null로 초기화하는 것이 중요
		//Map<String, Object> row = new HashMap<>();
		
		//결과는 여러 줄이 나올 수도, 한 줄이 나올 수도, 아무 줄도 안 나올 수 있다.
		//조회가 된 건지, 데이터가 없는 건지 알기 위해 null값을 넣어준다
		
		//null값 대입이 아니라 new HashMap()으로 초기화를 한다면
		//사이즈는 0이겠지만, 불필요한 HashMap 객체가 리턴 된다
		
//		if(row == null){} // row에 null값을 넣었을 때의 null 여부 비교식
//		if(0 < row.size()){} // row에 HashMap 객체를 넣었을 때의 null 여부 비교식 
		
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
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
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		
		return row;
	}
	
	public Map<String, Object> selectOne(String sql, List<Object> param){
		Map<String, Object> row = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			for(int i = 0; i < param.size(); i++){
				ps.setObject(i + 1, param.get(i));
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
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		
		return row;
	}
	
	public List<Map<String, Object>> selectList(String sql){
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			con = DriverManager.getConnection(url, user, password);
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
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		
		return list;
	}
	
	public List<Map<String, Object>> selectList(String sql, List<Object> param){
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			for(int i = 0; i < param.size(); i++){
				ps.setObject(i + 1, param.get(i));
			}
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
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		
		return list;
	}
	
	public int update(String sql){
		int result = 0;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		
		return result;
	}
	
	public int update(String sql, List<Object> param){
		int result = 0;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			for(int i = 0; i < param.size(); i++){
				ps.setObject(i + 1, param.get(i));
			}
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		
		return result;
	}
	
}













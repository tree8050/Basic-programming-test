package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class UserDao {
	static Scanner sc = new Scanner(System.in);
	static Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	UserDto userDto = new UserDto();
	public UserDao() {
		final String url = "jdbc:oracle:thin:@192.168.0.12:1521:orcl11";
		final String id = "test";
		final String pw = "test";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
//			System.out.println("dao");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int create(String name) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			final String url = "jdbc:oracle:thin:@192.168.0.12:1521:orcl11";
			final String id = "test";
			final String pw = "test";
			conn = DriverManager.getConnection(url, id, pw);
			userDto.setId(UUID.randomUUID().toString());
			userDto.setName(name);
			String sql2 = " insert into MEMBER values(?, ?)";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, userDto.getId());
			pstmt.setString(2, userDto.getName());
			
			cnt =pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//자원 반납
			if(rs!=null) try {
				rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(stmt!=null) try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(pstmt!=null) try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return cnt;
	}

	public ArrayList<UserDto> allRead() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<UserDto> list = new ArrayList<UserDto>();
		
		try {
			final String url = "jdbc:oracle:thin:@192.168.0.12:1521:orcl11";
			final String id = "test";
			final String pw = "test";
			conn = DriverManager.getConnection(url, id, pw);

			String sql = "select * from MEMBER";
			stmt = conn.createStatement();

			rs= stmt.executeQuery(sql);

			while(rs.next()){
				UserDto userDto = new UserDto();
				userDto.setId(rs.getString("id"));
				userDto.setName(rs.getString("name"));
				
				list.add(userDto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//자원 반납
			if(conn!=null) try {
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(rs!=null) try {
				rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(stmt!=null) try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(pstmt!=null) try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return list;
	}
	
	public UserDto read(String userId) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		UserDto userDto = null;
		
		try {
			final String url = "jdbc:oracle:thin:@192.168.0.12:1521:orcl11";
			final String id = "test";
			final String pw = "test";
			conn = DriverManager.getConnection(url, id, pw);

			int count = getMemberCount(userId);
			if(count==0){
				System.out.println("존재하지않는 id 입니다.");
				return userDto;
			}
			String sql5 = "SELECT * FROM MEMBER WHERE id = ?";
			pstmt = conn.prepareStatement(sql5);
			pstmt.setString(1, userId);
			rs= pstmt.executeQuery();

			while(rs.next()){
				
				userDto = new UserDto();
				
				userDto.setId(rs.getString("id"));
				userDto.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			//자원 반납
			if(conn!=null) try {
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(rs!=null) try {
				rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(stmt!=null) try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(pstmt!=null) try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return userDto;
	}
	public int update(UserDto userDto) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			final String url = "jdbc:oracle:thin:@192.168.0.12:1521:orcl11";
			final String id = "test";
			final String pw = "test";
			conn = DriverManager.getConnection(url, id, pw);

			int count = getMemberCount(userDto.getId());
			if(count==0){
				System.out.println("존재하지않는 id 입니다.");
				return count;
			}
			
			System.out.println("수정할 이름을 입력해주세요(1~5글자)");
//			userDto.setName(sc.nextLine());
			String name = sc.nextLine();
			
			String sql4 = "UPDATE MEMBER SET name = ? where id = ?";
			pstmt = conn.prepareStatement(sql4);
			pstmt.setString(1, name);
			pstmt.setString(2, userDto.getId());
			cnt =pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			//자원 반납
			if(conn!=null) try {
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(rs!=null) try {
				rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(stmt!=null) try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(pstmt!=null) try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return cnt;
	}
	
	// id 개수를 반환
	private int getMemberCount(String keyid){
		final String url = "jdbc:oracle:thin:@192.168.0.12:1521:orcl11";
		final String id = "test";
		final String pw = "test";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int count =0;
		try {
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "select count(*) cnt from MEMBER where id= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyid);

			rs = pstmt.executeQuery();

			if(rs.next()){
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			count = 0;
			e.printStackTrace();
		}finally{
			//자원 반납
			if(conn!=null) try {
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(rs!=null) try {
				rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(stmt!=null) try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(pstmt!=null) try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return count;
	}
	

	public int delete(String did) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			final String url = "jdbc:oracle:thin:@192.168.0.12:1521:orcl11";
			final String id = "test";
			final String pw = "test";
			conn = DriverManager.getConnection(url, id, pw);
			int count = getMemberCount(did);
			if(count==0){
				System.out.println("존재하지않는 id 입니다.");
				return count;
			}
			
			String sql3 = "delete from MEMBER where id = ?";
			
			pstmt = conn.prepareStatement(sql3);
			pstmt.setString(1, did);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			//자원 반납
			if(conn!=null) try {
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(rs!=null) try {
				rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(stmt!=null) try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(pstmt!=null) try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return cnt;
	}
}
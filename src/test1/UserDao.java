package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.UUID;

public class UserDao {
	static Scanner sc = new Scanner(System.in);
	static Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	
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
	
	public void create() {
		try {
			String id = UUID.randomUUID().toString();
			System.out.println("이름을 입력해주세요(1~5글자)");
			String name = sc.nextLine();
			
			String sql2 = " insert into MEMBER values(?, ?)";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			
			int cnt =pstmt.executeUpdate();
			
//			System.out.println("반환값: "+ cnt);
			if(cnt>0){
				System.out.println("추가 성공");
			}else{
				System.out.println("추가 실패");
			}
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
	}

	public void allRead() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		System.out.println("                 id                     name");
		System.out.println("--------------------------------------------");
		try {
			final String url = "jdbc:oracle:thin:@192.168.0.12:1521:orcl11";
			final String id = "test";
			final String pw = "test";
			conn = DriverManager.getConnection(url, id, pw);

			String sql = "select * from MEMBER";
			stmt = conn.createStatement();

			rs= stmt.executeQuery(sql);

			while(rs.next()){
				System.out.print(rs.getString("id") + " \t");
				System.out.print(rs.getString("name")+ " \n");
			}
			
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

	}
	public void read() {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			final String url = "jdbc:oracle:thin:@192.168.0.12:1521:orcl11";
			final String id = "test";
			final String pw = "test";
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("검색할  id를 입력해주세요");
			String keyid = sc.nextLine();

			int count = getMemberCount(keyid);
			if(count==0){
				System.out.println("존재하지않는 id 입니다.");
				return ;
			}
			String sql5 = "SELECT * FROM MEMBER WHERE id = ?";
			pstmt = conn.prepareStatement(sql5);
			pstmt.setString(1, keyid);
			rs= pstmt.executeQuery();
			System.out.println("                 id                     name");
			System.out.println("--------------------------------------------");
			while(rs.next()){
				System.out.print(rs.getString("id") + " \t");
				System.out.print(rs.getString("name")+ " \n");
			}
		} catch (SQLException e) {
			// TODO: handle exception
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
	}
	public void update() {
		
		try {
			System.out.println("수정할  id를 입력해주세요");
			String id = sc.nextLine();
			

			int count = getMemberCount(id);
			if(count==0){
				System.out.println("존재하지않는 id 입니다.");
				return ;
			}
			
			System.out.println("수정할 이름을 입력해주세요(1~5글자)");
			String name = sc.nextLine();
			
			String sql4 = "UPDATE MEMBER SET name = ? where id = ?";
			pstmt = conn.prepareStatement(sql4);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			int cnt =pstmt.executeUpdate();
			
			if(cnt>0){
				System.out.println("수정 성공");
			}else{
				System.out.println("수정 실패");
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
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
	

	public void delete() {
		try {
			
			System.out.println("삭제할 id를 입력하세요");
			String delete_id = sc.nextLine();
			
			String sql3 = "delete from MEMBER where id = ?";
			
			pstmt = conn.prepareStatement(sql3);
			pstmt.setString(1, delete_id);
			int cnt = pstmt.executeUpdate();

			if(cnt>0){
				System.out.println("삭제 성공");
			}else{
				System.out.println("삭제 실패");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
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
	}
}

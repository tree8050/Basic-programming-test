package test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/*
	1주차 Coding 과제 :
	Java 입출력 관리 프로그램을 제작 (Pure Object Java로 진행 요청)
	Console 창내에 입력을 받아 Scanner Class 혹은
	InputStream 아무거나 사용해도 괜찮습니다.
	관리 프로그램은 도서, 음반, 회원 등등 여러가지중 1가지를 택하며 field 값은 많지 않아도 되지만 Key로 사용하는 값은 반드시 존재해야합니다.
	key는 java.util.UUID.randomUUID(); 를 통해 생성해주시기 바랍니다.
	
	요구 기능은 아래와 같습니다.
	Console 내에 기능 번호순 입니다.
	1) 전체 조회
	2) key로 조회
	3) 추가
	4) key를 기반으로 갱신
	5) key를 기반으로 삭제
	
	VO, DTO를 사용해도 상관 없고 Collection Framework(List, Set 등등...)의 제약 역시 존재하지 않습니다.
	입출력시 사용될 항목의 갯수 역시 자유롭게 진행하시면 됩니다.

	 수정사항
		   1. Main에서 Connection생성(연결)이후 메서드 실행 시 해당 Connection 사용
		   2. 반환타입 void -> int
	       3. 예외처리 수정(부모, 자식 모두 처리)
	       4. 컬렉션프레임워크, 스트림 사용한 과제는 test2 패키지에 만들었습니다
	 
 */
public class Main {
	
	static Scanner sc = new Scanner(System.in);
	UserDao userDao = new UserDao();
	UserDto userDto = new UserDto();
	UserController userController = new UserController();
	static Connection conn = null;
	final String url = "jdbc:oracle:thin:@192.168.0.12:1521:orcl11";
	final String id = "test";
	final String pw = "test";
	
	// Connection 연결
	public Main() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.start();
	}

	private void start() {
		boolean start = true;
		while (start) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, id, pw);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("\n	" + "1) 전체 조회\r\n" + "	2) key로 조회\r\n" + "	3) 추가\r\n" + "	4) key를 기반으로 갱신\r\n"
					+ "	5) key를 기반으로 삭제\r\n" + "	9) 종료\r\n");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				allRead(conn);
				break;
			case 2:
				read(conn);
				break;
			case 3:
				create(conn);
				break;
			case 4:
				update(conn);
				break;
			case 5:
				delete(conn);
				break;
				// 수정사항  1. Main에서 Connection생성(연결)이후 메서드 실행 시 해당 Connection 사용
				//		 2. 반환타입 void -> int
				//       3. 예외처리 수정(부모, 자식 모두 처리)
			case 6: // 자식에서 try-catch
				userDao.methodA(conn); // data 생성
				userDao.methodB(conn); // data 수정
				break;
			case 7: // 부모에서 try-catch
				try {
					conn = DriverManager.getConnection(url, id, pw);
					try {
						int result = userDao.methodC(conn) // data 생성 성공하면 1 반환
								+ userDao.methodD(conn, userDto); // data 수정 성공하면 1반환
						if (result != 2) {
							throw new Exception();
						}
					} catch (Exception e) {
						conn.rollback();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case 9:
				exit();
			} //////////////// end of switch
		} //////////////// end of while
	} //////////////// end of start
	public void allRead(Connection conn) {
		ArrayList<UserDto> list = userController.allRead(conn);
		System.out.println("                 id                     name");
		System.out.println("--------------------------------------------");
		for (UserDto userDto : list) {
			System.out.print(userDto.getId() + "    ");
			System.out.println(userDto.getName());
		}
	}

	public void read(Connection conn) {
		System.out.println("검색할  id를 입력해주세요");
		String id = sc.nextLine();
		UserDto userDto = userController.read(conn, id);
		if (userDto != null) {
			System.out.print(userDto.getId() + "    ");
			System.out.println(userDto.getName());
		}
	}

	public void create(Connection conn) {
		String id = UUID.randomUUID().toString();
		System.out.println("이름을 입력해주세요(1~5글자)");
		String name = sc.nextLine();
		UserDto userDto = new UserDto(id, name);
		boolean result = userController.create(conn, name);
		if (result) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}

	public void update(Connection conn) {
		System.out.println("수정할  id를 입력해주세요");
		String id = sc.nextLine();
		UserDto userDto = userController.read(conn, id);
		if (userDto != null) {
			boolean result = userController.upadate(conn, userDto);
			if (result) {
				System.out.println("수정 성공");
			} else {
				System.out.println("수정 실패");
			}
		} else {
			System.out.println("수정 실패");
		}
	}

	public void delete(Connection conn) {
		System.out.println("삭제할 id를 입력하세요");
		String id = sc.nextLine();
		UserDto userDto = userController.read(conn, id);
		if (userDto != null) {
			boolean result = userController.delete(conn, id);
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}
	
	public void exit() {
		System.out.println("종료");
		System.exit(0);
	}
}

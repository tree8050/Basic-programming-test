package test1;

import java.util.Scanner;

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
 */
public class Main {
	static Scanner sc = new Scanner(System.in);
	UserDao userDao = new UserDao();
	public static void main(String[] args) {
		Main m = new Main();
		m.start();
	}
	private void start() {
		boolean start = true;
		while(start) {
			System.out.println("\n	"
					+ "1) 전체 조회\r\n" + 
					"	2) key로 조회\r\n" + 
					"	3) 추가\r\n" + 
					"	4) key를 기반으로 갱신\r\n" + 
					"	5) key를 기반으로 삭제"); 
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice){
				case 1:  userDao.allRead(); break;
				case 2:  userDao.read(); break;
				case 3:  userDao.create(); break;
				case 4:  userDao.update(); break;
				case 5:  userDao.delete(); break;
			}
		}
	}
}

package test3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Stream;

public class Main {
	static Scanner sc = new Scanner(System.in);
	String id;
	String name;
	String pw;
	UserDto userDto[] = new UserDto[10];
	ArrayList<UserDto> list = new ArrayList<>();
	Stream<UserDto> stream = list.stream();
	private int index = -1; // index
	private String searchId; // 조회, 삭제 시 이용할 변수

	public static void main(String[] args) {
		Main m = new Main();
		m.start();
	}

	private void start() {
		boolean start = true;

		while (start) {
			System.out.println("\n	" + "1) 전체 조회\r\n" + "	2) key로 조회\r\n" + "	3) 추가\r\n" + "	4) key를 기반으로 갱신\r\n"
					+ "	5) key를 기반으로 삭제\r\n" + "	6) 종료\r\n");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				allRead();
				break;
			case 2:
				read();
				break;
			case 3:
				create();
				break;
			case 4:
				update();
				break;
			case 5:
				delete();
				break;
			case 6:
				exit();
			} //////////////// end of switch
		} //////////////// end of while
	} //////////////// end of start

	public void allRead() {
		// UserDto타입으로 받는 list 선언
//		ArrayList<UserDto> list = new ArrayList<UserDto>();
//		for (int i = 0; i < index + 1; i++) {
//			// 객체수만큼 리스트에 담고
//			list.add(new UserDto(userDto[i].getId(), userDto[i].getName(), userDto[i].getPw()));
//		}
//		// stream() 메서드를 통해 List를 Stream으로 변환(생성)
//		Stream<UserDto> stream = list.stream();
//		// stream의 메서드인 forEach를 이용해 하나씩 꺼내기
		stream.forEach(userDto -> System.out.println(userDto));
		System.out.println(list);
	}

	public void read() {
		System.out.println("검색할  id를 입력해주세요");
		searchId = sc.next();
		// UserDto타입으로 받는 list 선언
		ArrayList<UserDto> list = new ArrayList<UserDto>();
		for (int i = 0; i < index + 1; i++) {
			if (userDto[i].getId().equals(searchId)) {
				// 검색한 id와 일치하는 객체를 list에 담기
				list.add(new UserDto(userDto[i].getId(), userDto[i].getName(), userDto[i].getPw()));
			}
		}
		// stream() 메서드를 통해 List를 Stream으로 변환(생성)
		Stream<UserDto> stream = list.stream();
		// stream의 메서드인 forEach를 이용해 하나씩 꺼내기
		stream.forEach(userDto -> System.out.println(userDto));
	}

	public void create() {
		id = UUID.randomUUID().toString();
		System.out.println("이름을 입력하세요");
		name = sc.next();
		System.out.println("비밀번호를 입력하세요");
		pw = sc.next();
		
		// UserDto타입으로 받는 list 선언
		ArrayList<UserDto> list2 = new ArrayList<>(Arrays.asList(new UserDto(id, name, pw)));
		// stream() 메서드를 통해 List를 Stream으로 변환(생성)
		Stream<UserDto> stream2 = list.stream();
		// stream의 메서드인 concat을 이용해 전역으로 선언한 stream과 이어주기
		list = (ArrayList<UserDto>) Stream.concat(stream, stream2);
		
	}

	public void update() {

		System.out.println("수정할 id를 입력하세요");
		searchId = sc.next();

		for (int i = 0; i < index + 1; i++) {
			if (userDto[i].getId().equals(searchId)) {
				System.out.println("이름을 입력하세요");
				name = sc.next();
				System.out.println("비밀번호를 입력하세요");
				pw = sc.next();
				userDto[index] = new UserDto(id, name, pw);
				userDto[i].setName(name);
				userDto[i].setPw(pw);
				System.out.println();
			}
		}
	}

	public void delete() {

		System.out.println("삭제할 id를 입력하세요");
		searchId = sc.next();

		for (int i = 0; i < index + 1; i++) {
			if (userDto[i].getId().equals(searchId)) {
				userDto[i].setId(null);
				userDto[i].setName(null);
				userDto[i].setPw(null);
				System.out.println();
			}
		}
	}

	public void exit() {
		System.out.println("종료");
		System.exit(0);
	}
}
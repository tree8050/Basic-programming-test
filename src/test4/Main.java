package test4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;
public class Main {
	static Scanner sc = new Scanner(System.in);
	String id;
	String name;
	String pw;
	private String searchId; // 조회, 삭제 시 이용할 변수
	List<UserDto> list =Arrays.asList();
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
			sc.nextLine();
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
		
//		List<String> userNames = list.stream()
//				  .map(UserDto::getName)
//				  .collect(toList());
//		List<String> userIds = list.stream()
//				  .map(UserDto::getId)
//				  .collect(toList());
//		if(userNames.size()==0) {
//			System.out.println("회원이 없습니다");
//			return;
//		}
//		System.out.println("유저 name 목록 : " + userNames);
//		System.out.println("유저 id 목록 : " + userIds);
		
			
		// 1_1  ::은 매개변수가 하나일 때 간결하게 표현해주는 방법
		list.stream().forEach(System.out::println);
		
		// 1_2
		//list.stream().map(list -> { System.out.println("회원목록"); return list; }). forEach(System.out::println);
		
		// 2_1
		//list.stream().forEach(list -> System.out.println(list));
		
		// 2_2
		//list.stream().forEach(list -> System.out.println("id : " + list.getId() + " name : " + list.getName() + " pw : " + list.getPw()));
		
	}

	public void read() {
		System.out.println("검색할  id를 입력해주세요");
		searchId = sc.next();
//		try {
//			String userName = list.stream()
//					.filter(userDto -> userDto.getId().equals(searchId))
//					.findAny().get().getName();
//			System.out.println("검색 결과 name : " + userName);
//		} catch(Exception e){
//			System.out.println("없는 회원입니다");
//		}
		
		
		try {
			list.stream().filter(userDto -> userDto.getId().equals(searchId)).forEach(userDto -> System.out.println("검색 결과\n" + list));
		} catch(Exception e){
			System.out.println("없는 회원입니다");
		}
		
	}

	public void create() {
		System.out.println("이름을 입력하세요");
		name = sc.next();
		System.out.println("비밀번호를 입력하세요");
		pw = sc.next();
		ArrayList<UserDto> insert = new ArrayList<>(Arrays.asList(new UserDto(UUID.randomUUID().toString(), name, pw)));		
		list = (ArrayList<UserDto>) Stream.of(list, insert).flatMap(userDto -> userDto.stream()).collect(toList());
	}

	public void update() {
		System.out.println("수정할 id를 입력하세요");
		searchId = sc.next();
		System.out.println("이름을 입력하세요");
		name = sc.next();
		System.out.println("비밀번호를 입력하세요");
		pw = sc.next();
		
//		list.stream()
//		.filter(userDto -> userDto.getId().equals(searchId))
//		.findAny().get().setName(name);
//		list.stream()
//		.filter(userDto -> userDto.getId().equals(searchId))
//		.findAny().get().setPw(pw);
		
		list.stream().filter(userDto -> userDto.getId().equals(searchId)).forEach(userDto -> {userDto.setName(name); userDto.setPw(pw);});
		
		}

	public void delete() {

		System.out.println("삭제할 id를 입력하세요");
		searchId = sc.next();
		list.removeIf(userDto -> userDto.getId().equals(searchId));
	}

	public void exit() {
		System.out.println("종료");
		System.exit(0);
	}
}
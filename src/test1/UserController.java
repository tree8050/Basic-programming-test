package test1;

import java.util.ArrayList;


public class UserController {
	UserDao userDao = new UserDao();

	public ArrayList<UserDto> allRead() {
		ArrayList<UserDto> list = userDao.allRead();
		return list;
	}

	public UserDto read(String id) {
		System.out.println("                 id                     name");
		System.out.println("--------------------------------------------");
		UserDto userDto = userDao.read(id);
		return userDto;
	}

	public boolean create(String name) {
		int result = userDao.create(name);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}

	public boolean upadate(UserDto userDto) {
		int result = userDao.update(userDto);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}

	public boolean delete(String id) {
		int result = userDao.delete(id);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	
}
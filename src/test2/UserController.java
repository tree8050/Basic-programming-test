package test2;

import java.sql.Connection;
import java.util.ArrayList;


public class UserController {
	UserDao userDao = new UserDao();

	public ArrayList<UserDto> allRead(Connection conn) {
		ArrayList<UserDto> list = userDao.allRead(conn);
		return list;
	}

	public UserDto read(Connection conn, String id) {
		System.out.println("                 id                     name");
		System.out.println("--------------------------------------------");
		UserDto userDto = userDao.read(conn, id);
		return userDto;
	}

	public boolean create(Connection conn, String name) {
		int result = userDao.create(conn, name);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}

	public boolean upadate(Connection conn, UserDto userDto) {
		int result = userDao.update(conn, userDto);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}

	public boolean delete(Connection conn, String id) {
		int result = userDao.delete(conn, id);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	
}

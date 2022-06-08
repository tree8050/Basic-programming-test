package test4;



import lombok.Data;

@Data
public class UserDto {
	private String   id;
	private String name;
	private String pw;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public UserDto(String id, String name, String pw) {
		this.id = id;
		this.name = name;
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", pw=" + pw + "]";
	}
}

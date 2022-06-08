package test2;

import lombok.Data;

@Data
public class UserDto {
	private String id;
	private String name; 
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
	UserDto(){
		
	}
	UserDto(String id, String name){
		this.id = id;
		this.name = name;
	}
}

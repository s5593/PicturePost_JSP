package mvc.vo;

public class PostDTO {
	private String postNum;
	private String postName ;
	private String category;
	private String picture; 
	private String password ;
	private String writeday; 
	
	public PostDTO(){}
	

	public PostDTO(String postNum, String password) {
		this.postNum = postNum;
		this.password = password;
	}
	

	public PostDTO(String postNum, String postName, String category, String password) {
		super();
		this.postNum = postNum;
		this.postName = postName;
		this.category = category;
		this.password = password;
	}


	public PostDTO(String postNum, String postName, String category, String picture, String password, String writeday) {
		this.postNum = postNum;
		this.postName = postName;
		this.category = category;
		this.picture = picture;
		this.password = password;
		this.writeday = writeday;
	}


	public String getPostNum() {
		return postNum;
	}


	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}


	public String getPostName() {
		return postName;
	}


	public void setPostName(String postName) {
		this.postName = postName;
	}


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getWriteday() {
		return writeday;
	}


	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	
}

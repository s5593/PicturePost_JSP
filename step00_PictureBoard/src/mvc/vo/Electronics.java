package mvc.vo;

public class Electronics {
	private String postNum;
	private String postName ;
	private String picture; 
	private String password ;
	private String writeday; 
	
	public Electronics(){}
	

	public Electronics(String postNum, String password) {
		this.postNum = postNum;
		this.password = password;
	}
	

	public Electronics(String postNum, String postName, String picture, String password) {
		this.postNum = postNum;
		this.postName = postName;
		this.picture = picture;
		this.password = password;
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


	
}

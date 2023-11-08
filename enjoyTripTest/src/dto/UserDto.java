package dto;

public class UserDto {
	
	private int userId;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String userPassword;
	
	public UserDto() {}
	public UserDto(int userId, String userName, String userEmail, String userPhone, String userPassword) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.userEmail = userEmail;
	this.userPhone = userPhone;
	this.userPassword = userPassword;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPhone="
				+ userPhone + ", userPassword=" + userPassword + "]";
	}
	
	
}

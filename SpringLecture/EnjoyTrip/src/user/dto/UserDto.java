package user.dto;

public class UserDto {
    private int userNum;
    private String userId;
    private String userPassword;
    private String userName;
    private String profileImg;

    @Override
	public String toString() {
		return "UserDto [userNum=" + userNum + ", userId=" + userId + ", userPassword=" + userPassword + ", userName="
				+ userName + ", profileImg=" + profileImg + "]";
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public UserDto() {
    }

	public UserDto(int userNum, String userId, String userPassword, String userName, String profileImg) {
		super();
		this.userNum = userNum;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.profileImg = profileImg;
	}
	
}
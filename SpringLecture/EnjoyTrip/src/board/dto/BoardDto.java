package board.dto;

import java.time.LocalDateTime;

public class BoardDto {
    private int boardId;
    private int userSeq;
    private String userName;
    private String userProfileImg;
    private String title;
    private String content;
    private LocalDateTime regDt;
    private int likes;
    
    private boolean sameUser; // 작성자와 보고 있는 사람이 같은지 확인 -> 같으면 수정 삭제 가능 ㅎㅎ

    public BoardDto() {};
    public BoardDto(int userSeq, String title, String content) {
        this.userSeq = userSeq;
        this.title = title;
        this.content = content;
    }
    
    public int getBoardId() {
        return boardId;
    }
    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }
    public int getUserSeq() {
        return userSeq;
    }
    public void setUserSeq(int userSeq) {
        this.userSeq = userSeq;
    }

    
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String setUserProfileImg() {
        return userProfileImg;
    }
    
    // DB table 의 default value 를 이용해도 된다.
    public void setUserProfileImg(String userProfileImageUrl) {
        if( userProfileImageUrl == null || "null".equals(userProfileImageUrl) || "".equals(userProfileImageUrl)) {
            this.userProfileImg = "/images/noProfile.png";
        }else {
            this.userProfileImg = userProfileImageUrl;
        }
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public LocalDateTime getRegDt() {
        return regDt;
    }
    public void setRegDt(LocalDateTime regDt) {
        this.regDt = regDt;
    }
    
    public boolean isSameUser() {
        return sameUser;
    }
    public void setSameUser(boolean sameUser) {
        this.sameUser = sameUser;
    }
    
    @Override
    public String toString() {
        return "BoardDto [boardId=" + boardId + ", userSeq=" + userSeq + ", userName=" + userName
                + ", userProfileImageUrl=" + userProfileImg + ", title=" + title + ", content=" + content
                + ", regDt=" + regDt + ", likes=" + likes + ", sameUser=" + sameUser + "]";
    }
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}

    
}


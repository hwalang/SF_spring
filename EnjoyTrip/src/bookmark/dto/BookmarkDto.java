package bookmark.dto;

public class BookmarkDto {
	int bookmarkNum;
	int userNum;
	int contentId;
	
	@Override
	public String toString() {
		return "BookmarkDto [bookmarkNum=" + bookmarkNum + ", userNum=" + userNum + ", contentId=" + contentId + "]";
	}

	public int getBookmarkNum() {
		return bookmarkNum;
	}

	public void setBookmarkNum(int bookmarkNum) {
		this.bookmarkNum = bookmarkNum;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	
	public BookmarkDto() {}
	
	public BookmarkDto(int bookmarkNum, int userNum, int contentId) {
		super();
		this.bookmarkNum = bookmarkNum;
		this.userNum = userNum;
		this.contentId = contentId;
	}
	
	
}

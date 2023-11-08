package board.dto;

import java.time.LocalDateTime;

public class BoardDto {
    private int board_id;
    private String board_writername;
    private String board_title;
    private String board_content;
    private String board_createtime;
    
    private int user_id;
    private String user_name;
    
    
    //private boolean sameUser; // 작성자와 보고 있는 사람이 같은지 확인 -> 같으면 수정 삭제 가능 ㅎㅎ
    
    
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getBoard_writername() {
		return board_writername;
	}
	public void setBoard_writername(String board_writername) {
		this.board_writername = board_writername;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_createtime() {
		return board_createtime;
	}
	public void setBoard_createtime(String board_createtime) {
		this.board_createtime = board_createtime;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	
	
	
	public int getUserSeq() {
		return user_id;
	}
	public void setUserSeq(int user_id) {
		this.user_id = user_id;
	}
	public String getUserName() {
		return user_name;
	}
	public void setUserName(String user_name) {
		this.user_name = user_name;
	}
	
	
	public BoardDto(int board_id, String board_writername, String board_title, String board_content,
			String board_createtime, int user_id, String user_name) {
		super();
		this.board_id = board_id;
		this.board_writername = board_writername;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_createtime = board_createtime;
		this.user_id = user_id;
		this.user_name = user_name;
	}
	public BoardDto() {}
	@Override
	public String toString() {
		return "BoardDto [board_id=" + board_id + ", board_writername=" + board_writername + ", board_title="
				+ board_title + ", board_content=" + board_content + ", board_createtime=" + board_createtime
				+ ", userSeq=" + user_id + ", userName=" + user_name + "]";
	}
	
	
	

    
    
    
}


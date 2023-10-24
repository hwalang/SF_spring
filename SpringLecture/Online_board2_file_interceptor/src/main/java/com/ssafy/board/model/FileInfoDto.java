package com.ssafy.board.model;

public class FileInfoDto {

	private String saveFolder;		// file을 올린 날짜로 폴더를 생성
	private String originalFile;	// 원본 파일 이름( 다운받는 이름: 내부에서 만든 규칙으로 정함 - 시간, uuid )
	private String saveFile;		// 실제 저장 파일 이름( 보이는 이름 )

	public String getSaveFolder() {
		return saveFolder;
	}

	public void setSaveFolder(String saveFolder) {
		this.saveFolder = saveFolder;
	}

	public String getOriginalFile() {
		return originalFile;
	}

	public void setOriginalFile(String originalFile) {
		this.originalFile = originalFile;
	}

	public String getSaveFile() {
		return saveFile;
	}

	public void setSaveFile(String saveFile) {
		this.saveFile = saveFile;
	}

}

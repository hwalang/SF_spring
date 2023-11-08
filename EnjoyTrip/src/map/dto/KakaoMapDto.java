package map.dto;

public class KakaoMapDto {
	
	private int contentId;
	private String title;
	private String addr1;
	private String addr2;
	private String firstImageURL;
	private int sidoCode;
	private int gugunCode;
	private double latitude;
	private double longitude;
	
	public KakaoMapDto() {}
	public KakaoMapDto(int contentId, String title, String addr1, String addr2, String firstImageURL, int sidoCode,
			int gugunCode, double latitude, double longitude) {
		super();
		this.contentId = contentId;
		this.title = title;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.firstImageURL = firstImageURL;
		this.sidoCode = sidoCode;
		this.gugunCode = gugunCode;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getFirstImageURL() {
		return firstImageURL;
	}
	public void setFirstImageURL(String firstImageURL) {
		this.firstImageURL = firstImageURL;
	}
	public int getSidoCode() {
		return sidoCode;
	}
	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}
	public int getGugunCode() {
		return gugunCode;
	}
	public void setGugunCode(int gugunCode) {
		this.gugunCode = gugunCode;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		return "KakaoMapDto [contentId=" + contentId + ", title=" + title + ", addr1=" + addr1 + ", addr2=" + addr2
				+ ", firstImageURL=" + firstImageURL + ", sidoCode=" + sidoCode + ", gugunCode=" + gugunCode
				+ ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}

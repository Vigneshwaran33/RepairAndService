package objects;

public class Bookingsobj {
	private int bookid;
	private String phone_num;
	private String address;
	private String date;
	private String time;
	public Bookingsobj(String phone_num,String address,String date,String time) {
		this.setPhone_num(phone_num);
		this.setAddress(address);
		this.setDate(date);
		this.setTime(time);
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}

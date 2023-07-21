package objects;

public class Servicesobj {
    private int sid;
    private String sname;
    private int price;
    private String type;
    private String cname;
    private int cid;
	public Servicesobj(int sid,String sname,int price,String type,String cname,int cid) {
		this.sid=sid;
		this.setSname(sname);
		this.setPrice(price);
		this.setType(type);
		this.cname=cname;
		this.cid=cid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
}

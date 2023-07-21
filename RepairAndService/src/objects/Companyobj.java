package objects;

public class Companyobj {
   private int cid;
   private String cname;
   private String pwd;
   public Companyobj(int cid,String cname,String pwd) {
	   this.cid=cid;
	   this.setCname(cname);
	   this.setPwd(pwd);
   }

public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}

}

package objects;
public class Usersobj {
   private  int  uid;
   private  String uname;
   private  String pwd;
   public Usersobj(int uid,String uname,String pwd) {
	   this.uid=uid;
	   this.setUname(uname);
	   this.setPwd(pwd);
   }
public Usersobj() {}
public  int getUid() {
	return uid;
}

public void setUid(int uid) {
	this.uid = uid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}

}

package model;
import java.sql.*;
import objects.*;
import java.util.ArrayList;
public class Users {
      static Statement st=Dbconnection.getStatement();
      
	  public boolean validate(String uname,String pwd) throws SQLException {
		  ResultSet r=st.executeQuery("SELECT uname,pwd FROM users WHERE uname='"+uname+"' AND pwd='"+pwd+"'");
	      if(r.next()) {
	    	  if(r.getString(1).equals(uname) && r.getString(2).equals(pwd)) return true;
	    	  else return false;
	      }
	      return false;
	  }
	  public int uid(String uname,String pwd) throws SQLException{
		  ResultSet r=st.executeQuery("SELECT uid FROM users WHERE uname='"+uname+"' AND pwd='"+pwd+"'");
		  if(r.next())
			 return r.getInt(1);
		  return 0;
	  }
	  public ResultSet getServices() throws SQLException {
		  return st.executeQuery("SELECT DISTINCT(sname) FROM services");
	  }
	  public ResultSet getBookings(int uid) throws SQLException{
		  return st.executeQuery("SELECT b.bookid,c.cname,s.sname,s.type,s.price,b.date,b.time,b.status from bookings as b\r\n"
		  		+ "inner join services as s on b.sid=s.sid inner join company as c on s.cid=c.cid where uid='"+uid+"';");
	  }
	  public ResultSet getCategory(String service) throws SQLException {
		  return st.executeQuery("SELECT DISTINCT(type) FROM services WHERE sname='"+service+"'");
	  }
	  public ResultSet getDetails(String category,String service) throws SQLException {
		  return st.executeQuery("SELECT s.sid,s.sname,s.price,s.type,c.cname,c.cid FROM services as s"
		  		+ " INNER JOIN company as c ON c.cid=s.cid  WHERE type='"+category+"' AND sname='"+service+"'");
	  }
	  public void setBookings(ArrayList<Bookingsobj> bo,int uid,int sid,int cid) throws SQLException {
		  for(Bookingsobj b:bo) {
		  st.execute("INSERT INTO bookings(uid,cid,sid,phone_num,address,date,time)"
		  		+ " values('"+uid+"','"+cid+"','"+sid+"','"+b.getPhone_num()+"','"+b.getAddress()+"','"+b.getDate()+"','"+b.getTime()+"')");
		  }
	  }
	  
	  
}

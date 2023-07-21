package controller;
import model.*;
import java.sql.*;
import objects.*;
import view.*;
import java.util.*;
public class Usersctrl  {
    Scanner s=new Scanner(System.in);
    Users model=new Users();
    static Usersctrl controller =new Usersctrl();
    static Usersobj u=new Usersobj();
    static App view=new App();
    public void usersCtrlLogin() throws SQLException{
    	System.out.println("WELCOME TO REPAIR & SERVICES");
    	System.out.println("----------------------------");
       	System.out.println("Enter your Username:");
       	String uname=s.nextLine();
       	System.out.println("Enter your Password:");
       	String pwd=s.nextLine();
        if(model.validate(uname,pwd)==true) { 
        	u=new Usersobj(model.uid(uname, pwd),uname,pwd);
        	System.out.println("WELCOME "+u.getUname().toUpperCase());
        	System.out.println("-------");
        	System.out.println("1.Services");
        	System.out.println("2.View Booking Status");
        	int n=s.nextInt();
        	if(n==1) controller.getServicesCtrl();
        	else if(n==2) controller.getBookingsCtrl();
        }
        else {
        	System.out.println("Invalid Username or Password");
        	controller.usersCtrlLogin();
        }
    }
    public void getServicesCtrl() throws SQLException {
    	System.out.println("OUR SERVICES");
    	view.getServicesView(model.getServices());
    }
    public void getBookingsCtrl() throws SQLException{
    	System.out.println("YOUR BOOKINGS");
    	System.out.println("-------------");
    	view.getBookingsView(model.getBookings(u.getUid()));
    }
    public void getCategoryCtrl(String service) throws SQLException {
    	view.getCategoryView(model.getCategory(service),service);
    }
    public void getDetailsCtrl(String category,String service) throws SQLException {
    	view.getDetailsView(model.getDetails(category,service));
    }
    public void setBookingsCtrl(ArrayList<Bookingsobj> bo,int sid,int cid) throws SQLException {
    	model.setBookings(bo,u.getUid(),sid,cid);
    }
   
    

}

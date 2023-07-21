package view;
import objects.*;
import controller.*;
import java.sql.*;
import java.util.*;
import java.util.Map.Entry;
public class App extends Data {

	static Usersctrl controller=new Usersctrl();
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		System.out.println("1.Customer");
		System.out.println("2.Company");
		int l=s.nextInt();
		s.nextLine();
		if(l==1) controller.usersCtrlLogin(); 
		
	}
	public void getServicesView(ResultSet r) throws SQLException {
	    ArrayList<String> al=new ArrayList<>();
	    while(r.next()) {
	    	al.add(r.getString(1));
	    }
	    for(int i=0;i<al.size();i++) System.out.println(i+1+"."+al.get(i).toUpperCase());
	    System.out.println("Enter your choice:");
	    int ch=s.nextInt();
	    String service=al.get(ch-1);
	   
	    controller.getCategoryCtrl(service);
	}
	public void getCategoryView(ResultSet r,String service) throws SQLException{
		ArrayList<String> al=new ArrayList<>();
		while(r.next()) {
			al.add(r.getString(1));
		}
		for(int i=0;i<al.size();i++) System.out.println(i+1+"."+al.get(i).toUpperCase());
		System.out.println("Enter your choice:");
		int ch=s.nextInt();
		String category=al.get(ch-1);
		controller.getDetailsCtrl(category,service);
	}
	public void getDetailsView(ResultSet r) throws SQLException{
		int j=1;
		while(r.next()) {
			so.add(new Servicesobj (r.getInt(1),r.getString(2),r.getInt(3),r.getString(4),r.getString(5),r.getInt(6)));
		}
		
		int i=1;
			for(Servicesobj s:so) {
				System.out.println(i+"."+s.getCname().toUpperCase()+" "+s.getSname().toUpperCase()+"("+s.getType().toUpperCase()+")"+" @"+s.getPrice());
				i++;
			}  
		System.out.println("Enter your choice");
		int ch=s.nextInt();
		int sid=0,cid=0,cnt=0;
		for(Servicesobj s:so) {
			if(ch==cnt) break;
			else {
				sid=s.getSid();
				cid=s.getCid();
				cnt++;
			}
		}
		int conform=0;
		while(conform!=1) {
		System.out.println("Enter your booking details");
		System.out.println("Enter your Phone Number:");
		String ph=s.nextLine();
		while(!ph.matches("[0-9]{10}")) ph=s.nextLine();
		System.out.println("Enter your Address:");
		String address=s.nextLine();
		System.out.println("Enter your service Date(yyyy/mm/dd):");
		String date=s.nextLine();
		while(!date.matches("[0-9]{4}[/][0-9]{2}[/][0-9]{2}")) date=s.nextLine();
		System.out.println("Enter your service Time(hh:mm):");
		String time=s.nextLine();
		while(!time.matches("[0-9]{2}[:][0-9]{2}")) time=s.nextLine();
		System.out.println("Phone Number:"+ph);
		System.out.println("Address:"+address);
		System.out.println("Service Date:"+date);
		System.out.println("Service Time:"+time);
		System.out.println("Press 1 to Conform your Booking or Press 0 to edit your Booking");
		conform=s.nextInt();
		if(conform==1) {
			bo.add(new Bookingsobj(ph,address,date,time));
			controller.setBookingsCtrl(bo,sid,cid);
			System.out.println("Your booking has been registered.Check booking status for further details");
			System.out.println("Press 1 to go Home or Press 0 to exit");
			int HE=s.nextInt();
			if(HE==0) {
				System.out.println("Thank you");
				System.exit(0);
				}
			else controller.getServicesCtrl();
		}
		}	
	}
	public void getBookingsView(ResultSet r) throws SQLException {
		r.last();
		int l=r.getRow();
		r.beforeFirst();
		if(l!=0) {
			System.out.printf("%-10s %-40s %-10s %-12s %-8s %-10s", "BookingID", "Service", "Price", "Date", "Time", "Status");
			System.out.println();
			while(r.next()) {
				System.out.printf("%-10s %s %s %s %s %-8s %-9s %-12s %-8s %-10s",r.getInt(1),r.getString(2),r.getString(3),"(",r.getString(4),")",r.getString(5),r.getString(6),r.getString(7),r.getString(8));
			}
		}
		else System.out.println("Empty");
	}
	

}

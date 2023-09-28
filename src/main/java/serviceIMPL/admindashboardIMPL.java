package serviceIMPL;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import Exception.globalexception;
import daoIMPL.admindashboardDAOIMPL;
import model.room;
import model.user;
import service.admindashboard;
public class admindashboardIMPL implements admindashboard {

	static Logger log=Logger.getLogger(admindashboardIMPL.class);
	static Scanner sc=new Scanner(System.in);
	static admindashboardIMPL  impl=new admindashboardIMPL ();
	static admindashboardDAOIMPL dao=new admindashboardDAOIMPL();
	@Override
	public void dashboard()throws globalexception {
		log.info("\t\t\t\t*****welcome to admin dashboard*****");
		int ch=5;
		while(ch!=0) {
			log.info("Press 1 for Create Room\nPress 2 for view users\nPress 3 for view Rooms\nPress 4 to allot the room\nPress 5 for delete User\nPress 6 for delee room\nPress 7 for add due amount\nPress 8 for update due amount\nPress 9 for view user\nPress 0 to exit ");
			
			log.info("Enter your choice of Operation");
			ch=sc.nextInt();
			
			switch(ch) {
			
			case 1->impl.createRoom();
			case 2->impl.viewUsers();
			case 3->impl.viewRooms();
			case 4->impl.allotRoom();
			case 5->impl.deleteUser();
			case 6->impl.deleteRoom();
			case 7->impl.addDueAmount();
			case 8->impl.addpaidDueAmount();
			case 9->impl.viewUser();
			}
				
		}
		
	}
	@Override
	
	//creating the room
	public void createRoom() throws globalexception {
		log.info("Enter room id");
		int rId=sc.nextInt();
		log.info("Enter room Name");
		String rname=sc.next();
		log.info("Enter room type");
		String rtype=sc.next();
		
		room r1=new room();
		r1.setRoomId(rId);
		r1.setRoomName(rname);
		r1.setRoomType(rtype);
		//calling createroom method from dao
		int res=dao.createRoom(r1);
			if(res==1) {
				log.info("room added successfully");
			}
	}
	//view all the users
	@Override
	public void viewUsers() {
		List<user> userList=dao.viewUsers();
		
		//iterating userlist to print every user
		for(user u:userList)
			log.info(u.getUserId()+" "+u.getUserName()+" ");
		
	}
	//view all rooms
	@Override
	public void viewRooms() {
		List<room> roomList=dao.viewRooms();
		//iterating roomlist to print every room
		for(room r:roomList)
			log.info(r.toString());
	}
	//alloting room to the user
	@Override
	public void allotRoom() {
		log.info("Enter user id");
		int uid=sc.nextInt();
		log.info("Enter Room id");
		int rid=sc.nextInt();
		
		int status=dao.allotRoom(uid, rid);
		if(status==1) {
			log.info("room allotted successfully");
		}
		
	}
	@Override
	public void deleteUser() {
		
		log.info("enter user id to delet");
		int uid=sc.nextInt();
		int res=dao.deleteUser(uid);
		if(res==1) {
			log.info("deleted successfully");
		}
		else {
			log.info("something went wrong");
		}
		
	}
	@Override
	public void deleteRoom() {
		log.info("enter room id to delet");
		int rid=sc.nextInt();
		int res=dao.deleteRoom(rid);
		if(res==1) {
			log.info("deleted successfully");
		}
		else {
			log.info("something went wrong");
		}
			
	}
	@Override
	public void addDueAmount() {
		
		log.info("Enter user id");
		int uid=sc.nextInt();
		log.info("Enter amount to add");
		int amount=sc.nextInt();
		
		int res=dao.addDueAmount(uid, amount);
		if(res==1) {
			log.info("amount added");
		}
		else {
			log.info("something went wrong");
		}
	}
	@Override
	public void addpaidDueAmount() {
		log.info("Enter user id");
		int uid=sc.nextInt();
		log.info("Enter amount to add");
		int amount=sc.nextInt();
		
		int res=dao.paidDueAmount(uid, amount);
		if(res==1) {
			log.info("amount added");
		}
		else {
			log.info("something went wrong");
		}
	}
	@Override
	public void viewUser() {
		log.info("Enter user id to view");
		int uid=sc.nextInt();
		
	user u1=	dao.viewUserProfile(uid);
		log.info(u1);
	}

}

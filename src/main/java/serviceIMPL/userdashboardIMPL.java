package serviceIMPL;

import org.apache.log4j.Logger;

import Exception.globalexception;
import service.userdashboard;
import daoIMPL.userdashboardDAOIMPL;
import java.util.*;
public class userdashboardIMPL  implements userdashboard{

	static Logger log=Logger.getLogger(userdashboardIMPL.class);
	static userdashboardDAOIMPL  dao=new userdashboardDAOIMPL ();
	static Scanner sc=new Scanner(System.in);
	static userdashboardIMPL impl=new userdashboardIMPL();
	static int userId;
	@Override
	public void userdashboard(int userId) throws globalexception {
		log.info("\t\t\t\t*****welcome to user dashboard*****");
		this.userId=userId;
		
		int ch=1;
		
		while(ch!=0) {
			log.info("Press 1 for view room\nPress 2 for view due amount\nPress 3 for update phone\nPress 4 for change password\nPress 5 for view profile\nPress 0 to exit");
			ch=sc.nextInt();
			
			switch(ch) {
			
			case 1->impl.viewRoom();
			
			case 2->impl.viewDueAmount();
			
			case 3->impl.changePhoneNum();
			
			case 4->impl.changePassword();
			
			case 5->impl.viewProfile();
			
			default->log.info("wrong option");
			
			}	
		}
	}
	@Override
	public void viewRoom() {
	
		String room=dao.viewRoom(userId);
		log.info(room);
		
	}
	@Override
	public void viewDueAmount() {
	
		int amount=dao.viewDueAmount(userId);
		log.info("total due amount is : "+amount );
	}
	@Override
	public void changePhoneNum() {
		
		log.info("enter new phone number");
		String newphone=sc.next();
		int res=dao.changePhoneNum(userId, newphone);
		if(res==1) {
			log.info("phone number updaed");
		}
		else {
			log.info("something went wrong");
		}
	}
	@Override
	public void changePassword() throws globalexception {
		
		log.info("Enter current password");
		String oldpwd=sc.next();
		log.info("Enter new password");
		String newpwd=sc.next();
		
		int st=dao.changePassword(userId, oldpwd, newpwd);
		if(st==1) {
			log.info("password update");
		}
	}
	@Override
	public void viewProfile() {
		
		log.info(dao.viewProfile(userId));
		
	}
}

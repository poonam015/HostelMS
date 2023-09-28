package daoIMPL;

import org.hibernate.Session;

import Exception.globalexception;
import dao.userdahboardDAO;
import model.user;

public class userdashboardDAOIMPL  implements userdahboardDAO{

	@Override
	public String viewRoom(int Uid) {
		
		try(Session ses=hibernateUtil.getSession()){
			
			//getting the user details 
			user u2=ses.get(user.class, Uid);
			//returning room details based on user object
			return "Room Id is "+u2.getUserRoom().getRoomId()+" Name is :"+u2.getUserRoom().getRoomName()+" which is"+u2.getUserRoom().getRoomType();
		}
	}

	@Override
	public int viewDueAmount(int Uid) {

			try(Session ses=hibernateUtil.getSession()){
			
			
			user u2=ses.get(user.class, Uid);
		//returning user fee
			return u2.getUserFee();
			}
		
	}

	@Override
	public int changePhoneNum(int Uid, String phone) {
		try(Session ses=hibernateUtil.getSession()){
			ses.beginTransaction();
			//updating phone number using userid
			int status=ses.createQuery("update user set userPhone=:phone where userId=:id").setParameter("phone", phone).setParameter("id", Uid).executeUpdate();
			ses.getTransaction().commit();
			return status;
		}
	}

	@Override
	public int changePassword(int Uid, String oldPwd,String newPwd) throws globalexception {

		try(Session ses=hibernateUtil.getSession()){
			ses.beginTransaction();
			//retriving user details
			user u2=ses.get(user.class, Uid);
			//matching the password from db and old pwd entered by user
			if(u2.getUserPassword().equals(oldPwd)) {
				//if both are correct we can update new pwd
				int status=ses.createQuery("update user set userPassword=:pwd where userId=:id").setParameter("pwd", newPwd).setParameter("id", Uid).executeUpdate();
				ses.getTransaction().commit();
				return status;
			}
			else {
				//throw an exception if current password is wrong
				throw new globalexception("wrong password");
			}
		}
	
	}

	@Override
	public user viewProfile(int Uid) {
		try(Session ses=hibernateUtil.getSession()){
			//returing user object
			user u2=ses.get(user.class, Uid);
			return u2;
	}
	}

}

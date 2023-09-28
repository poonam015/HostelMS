package daoIMPL;

import java.util.*;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import Exception.globalexception;
import dao.admindashboardDAO;
import model.room;
import model.user;

public class admindashboardDAOIMPL implements admindashboardDAO {

	@Override
	public int createRoom(room r1) throws globalexception {
	//autoclosable session object
		try(Session ses=Hibernate.getSession()){
			
			ses.beginTransaction();
			String roomName=r1.getRoomName();
			room r2=null;
			//getting the room details based roomname
		r2=(room)ses.createQuery("from room where roomName=:room").setParameter("room", roomName).uniqueResult();
			
		//if room is null we can save the room
		if(r2==null) {
			ses.save(r1);
			ses.getTransaction().commit();
			return 1;
		}
		else {
			throw new globalexception("room is already existed");
		}	
		}
		
		
	}

	@Override
	public List<room> viewRooms() {

		try(Session ses=hibernateUtil.getSession()){
			
			Query qu=ses.createQuery("from room");
			
			//fetching list of rooms
			List<room> roomList=qu.getResultList();
			return roomList;
			
		}
		
	}

	@Override
	public List<user> viewUsers() {
		try(Session ses=hibernateUtil.getSession()){
			
			Query qu=ses.createQuery("from user");
			//fetching list of users
			List<user> userList=qu.getResultList();
			return userList;
			
		}
	}

	@Override
	public int allotRoom(int userId, int roomId) {
		try(Session ses=hibernateUtil.getSession()){
		
			ses.beginTransaction();
			
			//updating roomid of one user
			int res=ses.createQuery("update user set userRoom_roomId=:roomid where userId=:userid")
			.setParameter("roomid", roomId).setParameter("userid",userId).executeUpdate();
			
			ses.getTransaction().commit();
			
			return res;
		}
		
	}

	@Override
	public int deleteUser(int userId) {
		
		try(Session ses=hibernateUtil.getSession()){
			//deleting the user using userid
			ses.beginTransaction();
			int status=ses.createQuery("delete from user where userId=:uId").setParameter("uId", userId).executeUpdate();
			ses.getTransaction().commit();
			return status;
		}

	}

	@Override
	public int deleteRoom(int roomId) {

		try(Session ses=hibernateUtil.getSession()){
			//deleting the room using roomid
			ses.beginTransaction();
			int status=ses.createQuery("delete from room where roomId=:rId").setParameter("rId", roomId).executeUpdate();
			ses.getTransaction().commit();
			return status;
		}

	}

	@Override
	public int addDueAmount(int userId, int amount) {

		try(Session ses=hibernateUtil.getSession()){
			
			ses.beginTransaction();
			//getting old due amount
		int dueamount=(int)	ses.createQuery("select userFee from user where userId=:uid").setParameter("uid", userId).uniqueResult();
			
		//adding old and new due amount
		int finalAmount=dueamount+amount;
		//updating totaldue 
		int status=ses.createQuery("update user set userFee=:fee where userId=:uid").setParameter("fee", finalAmount).setParameter("uid", userId).executeUpdate();
			return status;
		}
		

	}

	@Override
	public int paidDueAmount(int userId, int amount) {
try(Session ses=hibernateUtil.getSession()){
			
			ses.beginTransaction();
			
			//getting old due amount
		int dueamount=(int)	ses.createQuery("select userFee from user where userId=:uid").setParameter("uid", userId).uniqueResult();
			//subtract paid amount from due amount
		int finalAmount=dueamount-amount;
		//update final amount in db
		int status=ses.createQuery("update user set userFee=:fee where userId=:uid").setParameter("fee", finalAmount).setParameter("uid", userId).executeUpdate();
			return status;
		}
		
	}

	@Override
	public user viewUserProfile(int userId) {
		
		try(Session ses=hibernateUtil.getSession())
		{
			user u1=null;
			//retriving user using primarykey
			u1=ses.get(user.class, userId);
			return u1;
		}	
	}
}

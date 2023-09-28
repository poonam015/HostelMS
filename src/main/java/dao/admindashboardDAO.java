package dao;

import model.*;
import java.util.*;

import Exception.globalexception;

public interface admindashboardDAO {

	public int createRoom(room r1)throws globalexception;
	
	public List<room> viewRooms();
	
	public List<user> viewUsers();
	
	public int allotRoom(int userId,int roomId);
	
	public int deleteUser(int userId);
	
	public int deleteRoom(int roomId);
	
	public int addDueAmount(int userId,int amount);
	
	public int paidDueAmount(int userId,int amount);
	
	public user viewUserProfile(int userId);
	
	
}
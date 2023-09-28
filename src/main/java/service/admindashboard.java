package service;

import Exception.globalexception;

public interface admindashboard {

	public void dashboard()throws globalexception;
	
	public void createRoom()throws globalexception;
	
	public void viewUsers();
	
	public void viewRooms();
	
	public void allotRoom();
	
	public void deleteUser();
	
	public void deleteRoom();
	
	public void addDueAmount();
	
	public void addpaidDueAmount();
	
	public void viewUser();
}

package service;

import Exception.globalexception;

public interface userdashboard {

	public void userdashboard(int userId)throws globalexception ;
	
	public void viewRoom();
	
	public void viewDueAmount();
	
	public void changePhoneNum();
	
	public void changePassword()throws globalexception;
	
	public void viewProfile();
}

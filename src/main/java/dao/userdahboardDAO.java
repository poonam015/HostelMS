package dao;

import Exception.globalexception;
import model.*;

public interface userdahboardDAO {

	public String viewRoom(int Uid);
	
	public int viewDueAmount(int Uid);
	
	public int changePhoneNum(int Uid,String phone);
	
	public int changePassword(int Uid,String oldPwd,String newPwd) throws globalexception;
	
	public user viewProfile(int Uid);
	
}

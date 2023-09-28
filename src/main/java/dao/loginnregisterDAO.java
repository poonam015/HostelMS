package dao;

import Exception.globalexception;
import model.user;
public interface loginnregisterDAO {

	public int registration(user u1) throws globalexception ;
	
	public user login(String username,String password)throws globalexception;
	
	
}

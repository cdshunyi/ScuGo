package com.action.library;

import com.bean.library.UserBuyer;
import com.dao.DaoManager;
import com.dao.library.UserBuyerDao;

public class UserBuyerAction {
	
	public static UserBuyer findUserProfileByUsId(int usid) {
		
		DaoManager dManager = DaoManager.getInstance();
		UserBuyerDao ubDao = dManager.getDao(UserBuyerDao.class);
		
		UserBuyer uBuyer = null;
		
		try
		{
			dManager.begin();			
			uBuyer = ubDao.getUserBuyerByUsId(usid);
			dManager.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			dManager.end();
		}
		
		return uBuyer;
	}
	
	public static boolean savaUserBuyer(UserBuyer uBuyer) {
		
		DaoManager dManager = DaoManager.getInstance();
		UserBuyerDao ubDao = dManager.getDao(UserBuyerDao.class);
		
		try
		{
			dManager.begin();			
			ubDao.saveUserBuyer(uBuyer);
			dManager.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally 
		{
			dManager.end();
		}
		return true;
	}
	
	public static boolean addUserBuyer(UserBuyer uBuyer) {
		
		DaoManager dManager = DaoManager.getInstance();
		UserBuyerDao ubDao = dManager.getDao(UserBuyerDao.class);
		
		try
		{
			dManager.begin();			
			ubDao.addUserBuyer(uBuyer);
			dManager.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally 
		{
			dManager.end();
		}
		return true;
	}
	
	public static boolean addNewUserBuyer(int usid) {
		
		DaoManager dManager = DaoManager.getInstance();
		UserBuyerDao ubDao = dManager.getDao(UserBuyerDao.class);
		
		UserBuyer uBuyer = new UserBuyer();
		uBuyer.setUsid(usid);
		uBuyer.setBalance(0);
		uBuyer.setCredit(0);
		uBuyer.setLevel(0);
		
		try
		{
			dManager.begin();			
			ubDao.addUserBuyer(uBuyer);
			dManager.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally 
		{
			dManager.end();
		}
		return true;
	}
}

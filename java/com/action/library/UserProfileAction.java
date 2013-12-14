package com.action.library;

import com.bean.library.UserProfile;
import com.dao.DaoManager;
import com.dao.library.UserProfileDao;

public class UserProfileAction {
	
	public static UserProfile findUserProfileByUsId(int usid) {
		
		DaoManager dManager = DaoManager.getInstance();
		UserProfileDao upDao = dManager.getDao(UserProfileDao.class);
		
		UserProfile uProfile = null;
		
		try
		{
			dManager.begin();			
			uProfile = upDao.getUserProfileByUsId(usid);
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
		
		return uProfile;
	}
	
	public static boolean savaUserProfile(UserProfile uProfile) {
		
		DaoManager dManager = DaoManager.getInstance();
		UserProfileDao upDao = dManager.getDao(UserProfileDao.class);
		
		try
		{
			dManager.begin();			
			upDao.saveUserProfile(uProfile);
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
	
	public static boolean addUserProfile(UserProfile uProfile) {
		
		DaoManager dManager = DaoManager.getInstance();
		UserProfileDao upDao = dManager.getDao(UserProfileDao.class);
		
		try
		{
			dManager.begin();			
			upDao.addUserProfile(uProfile);
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
	
	public static boolean addNewUserProfile(int usid) {
		
		DaoManager dManager = DaoManager.getInstance();
		UserProfileDao upDao = dManager.getDao(UserProfileDao.class);
		
		UserProfile uProfile = new UserProfile();
		uProfile.setSex(0);
		uProfile.setUsid(usid);
		uProfile.setBirthday("");
		uProfile.setPhone("");
		uProfile.setReceiver("");
		uProfile.setAddress("");
		
		try
		{
			dManager.begin();			
			upDao.addUserProfile(uProfile);
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

package com.action.library;

import java.util.ArrayList;

import com.bean.library.UserData;
import com.dao.DaoManager;
import com.dao.library.UserDataDao;

public class UserDataAction {

	public static UserData findUserDataByUsId(int usid) {
		
		DaoManager dManager = DaoManager.getInstance();
		UserDataDao udDao = dManager.getDao(UserDataDao.class);
		
		UserData uData = null;
		
		try
		{
			dManager.begin();			
			uData = udDao.getUserDataByUsId(usid);
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
		
		return uData;
	}
	
	public static UserData findUserDataByUsername(String username) {
		
		DaoManager dManager = DaoManager.getInstance();
		UserDataDao udDao = dManager.getDao(UserDataDao.class);
		
		UserData uData = null;
		
		try
		{
			dManager.begin();
			uData = udDao.getUserDataByUsername(username);
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
		
		return uData;
	}
	
	public static ArrayList<UserData> getAllUsersData() {
		
		DaoManager dManager = DaoManager.getInstance();
		UserDataDao udDao = dManager.getDao(UserDataDao.class);
		
		ArrayList<UserData> uDatas = null;
		
		try
		{
			dManager.begin();			
			uDatas = (ArrayList<UserData>) udDao.getAllUsersData();
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
		
		return uDatas;
	}
	
	public static UserData loginCheck(String username, String passwd) {
		DaoManager dManager = DaoManager.getInstance();
		UserDataDao udDao = dManager.getDao(UserDataDao.class);
		UserData uData = null;
		
		try
		{
			dManager.begin();
			uData = udDao.getUserDataByUsername(username);
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
		
		if (uData == null) {
			return null;
		}
		else {
			if ( uData.getPassword().equals( SystemUtils.MD5(SystemUtils.MD5(passwd)+uData.getSalt()) ) ) {
				return uData;
			}
			else {
				return null;
			}
		}
	}
	
	public static int registUserData(UserData uData) {
		DaoManager dManager = DaoManager.getInstance();
		UserDataDao udDao = dManager.getDao(UserDataDao.class);
		int maxId = 0;
		
		try
		{
			dManager.begin();
			udDao.addUserData(uData);
			maxId = udDao.getMaxUsId();
			dManager.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		finally
		{
			dManager.end();
		}
		return maxId;
	}
	
	public static boolean saveUserData(UserData uData) {
		
		DaoManager dManager = DaoManager.getInstance();
		UserDataDao udDao = dManager.getDao(UserDataDao.class);
		
		try
		{
			dManager.begin();
			udDao.saveUserData(uData);
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

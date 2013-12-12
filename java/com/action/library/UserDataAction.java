package com.action.library;

import java.util.ArrayList;

import com.bean.library.UserData;
import com.dao.DaoManager;
import com.dao.library.UserDataDao;

public class UserDataAction {

	static public UserData findUserDataByUsId(int usid) {
		
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
	
	static public UserData findUserDataByUsername(String username) {
		
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
	
	static public ArrayList<UserData> getAllUsersData() {
		
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
}

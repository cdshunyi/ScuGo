package com.dao.library;

import java.util.List;

import com.bean.library.UserData;

public interface UserDataDao {
	public UserData getUserDataByUsId(int usid) throws Exception;
	public UserData getUserDataByUsername(String username) throws Exception;
	public List<UserData> getAllUsersData() throws Exception;
	public int addUserData(UserData uData) throws Exception;
}

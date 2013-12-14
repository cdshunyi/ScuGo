package com.dao.library;

import com.bean.library.UserProfile;

public interface UserProfileDao {
	public UserProfile getUserProfileByUsId(int usid) throws Exception;
	public int addUserProfile(UserProfile uProfile) throws Exception;
	public int saveUserProfile(UserProfile uProfile) throws Exception;
}

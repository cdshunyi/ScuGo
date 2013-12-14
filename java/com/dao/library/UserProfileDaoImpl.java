package com.dao.library;

import com.bean.library.UserProfile;
import com.dao.BaseDao;
import com.dao.PostgreSQL;

public class UserProfileDaoImpl extends BaseDao implements UserProfileDao, PostgreSQL{
	
	@Override
	public UserProfile getUserProfileByUsId(int usid) throws Exception {
		String sql = "SELECT * FROM scugo_user_profile WHERE usid = ?";
		return esql.query(UserProfile.class, sql, usid);
	}

	@Override
	public int saveUserProfile(UserProfile uProfile) throws Exception {
		String sql = "UPDATE scugo_user_profile SET sex=?, birthday=?, phone=?," +
				" receiver=?, address=? WHERE usid=?";
		return esql.update(sql, uProfile.getSex(), uProfile.getBirthday(), uProfile.getPhone(), 
				uProfile.getReceiver(), uProfile.getAddress(), uProfile.getUsid());
	}

	@Override
	public int addUserProfile(UserProfile uProfile) throws Exception {
		String sql = "INSERT INTO scugo_user_profile(usid, sex, phone, receiver,address, birthday)" +
				" VALUES (?, ?, ?, ?, ?, ?)";
		return esql.update(sql, uProfile.getUsid(), uProfile.getSex(), uProfile.getPhone(), uProfile.getReceiver(),
				uProfile.getAddress(), uProfile.getBirthday());
	}
	
	
}

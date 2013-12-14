package com.dao.library;

import java.util.List;

import com.bean.library.UserData;
import com.dao.BaseDao;
import com.dao.PostgreSQL;

public class UserDataDaoImpl extends BaseDao implements UserDataDao, PostgreSQL{
	
	@Override
	public UserData getUserDataByUsId(int usid) throws Exception {
		String sql = "SELECT * FROM scugo_user_data WHERE usid = ?";
		return esql.query(UserData.class, sql, usid);
	}

	@Override
	public UserData getUserDataByUsername(String username) throws Exception {
		String sql = "SELECT * FROM scugo_user_data WHERE username = ?";
		return esql.query(UserData.class, sql, username);
	}

	@Override
	public List<UserData> getAllUsersData() throws Exception {
		String sql = "SELECT * FROM scugo_user_data";
		return esql.list(UserData.class, sql);
	}

	@Override
	public int addUserData(UserData uData) throws Exception {
		String sql = "INSERT INTO scugo_user_data(type, username, password, salt, timereg, email, isseller) VALUES (?, ?, ?, ?, ?, ?, ?);";
		return esql.update(sql, uData.getType(), uData.getUsername(), uData.getPassword(), uData.getSalt(),
				uData.getTimereg(), uData.getEmail(), uData.getIsseller());
	}

	@Override
	public int getMaxUsId() throws Exception {
		String sql = "SELECT max(usid) FROM scugo_user_data";
		return esql.query(Integer.class, sql);
	}

	@Override
	public int saveUserData(UserData uData) throws Exception {
		String sql = "UPDATE scugo_user_data SET type=?, username=?, password=?, salt=?, timereg=?, email=?, isseller=? " +
				"WHERE usid=?";
		return esql.update(sql, uData.getType(), uData.getUsername(), uData.getPassword(), uData.getSalt(),
				uData.getTimereg(), uData.getEmail(), uData.getIsseller(), uData.getUsid());
	}
}

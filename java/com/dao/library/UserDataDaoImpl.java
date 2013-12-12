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
		String sql = "SELECT * FROM scugo_user_data WHERE username = '?'";
		return esql.query(UserData.class, sql, username);
	}

	@Override
	public List<UserData> getAllUsersData() throws Exception {
		String sql = "SELECT * FROM scugo_user_data";
		return esql.list(UserData.class, sql);
	}
}
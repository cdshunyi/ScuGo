package com.dao.library;

import com.bean.library.UserBuyer;
import com.dao.BaseDao;
import com.dao.PostgreSQL;

public class UserBuyerDaoImpl extends BaseDao implements UserBuyerDao, PostgreSQL{
	
	@Override
	public UserBuyer getUserBuyerByUsId(int usid) throws Exception {
		String sql = "SELECT * FROM scugo_user_buyer WHERE usid = ?";
		return esql.query(UserBuyer.class, sql, usid);
	}

	@Override
	public int saveUserBuyer(UserBuyer uBuyer) throws Exception {
		String sql = "UPDATE scugo_user_buyer SET balance=?, credit=?, level=? WHERE WHERE usid=?";
		return esql.update(sql, uBuyer.getBalance(), uBuyer.getCredit(), uBuyer.getLevel(), uBuyer.getUsid());
	}

	@Override
	public int addUserBuyer(UserBuyer uBuyer) throws Exception {
		String sql = "INSERT INTO scugo_user_buyer (usid, balance, credit, level) VALUES (?, ?, ?, ?)";
		return esql.update(sql, uBuyer.getUsid(), uBuyer.getBalance(), uBuyer.getCredit(), uBuyer.getLevel());
	}
	
	
}

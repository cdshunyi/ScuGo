package com.dao.library;

import com.bean.library.UserBuyer;

public interface UserBuyerDao {
	public UserBuyer getUserBuyerByUsId(int usid) throws Exception;
	public int addUserBuyer(UserBuyer uBuyer) throws Exception;
	public int saveUserBuyer(UserBuyer uBuyer) throws Exception;
}

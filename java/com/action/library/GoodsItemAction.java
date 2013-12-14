package com.action.library;

import java.util.ArrayList;

import com.bean.library.GoodsItem;
import com.dao.DaoManager;
import com.dao.library.GoodsItemDao;

public class GoodsItemAction {
	
	/**
	 * 查询某分类ID的商品信息
	 * @param caid
	 * @return
	 */
	public static GoodsItem findItemByItId(int itid) {
		DaoManager dManager = DaoManager.getInstance();
		GoodsItemDao giDao = dManager.getDao(GoodsItemDao.class);
		GoodsItem gItem = null;
		try {
			dManager.begin();			
			gItem = giDao.getItemByItId(itid);
			dManager.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			dManager.end();
		}
		return gItem;
	}
	
	public static ArrayList<GoodsItem> findItemByCatalogCaId(int caid) {
		DaoManager dManager = DaoManager.getInstance();
		GoodsItemDao giDao = dManager.getDao(GoodsItemDao.class);
		ArrayList<GoodsItem> gItems = null;
		try {
			dManager.begin();			
			gItems = (ArrayList<GoodsItem>) giDao.getItemByCatalogCaId(caid);
			dManager.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			dManager.end();
		}
		return gItems;
	}
	
}

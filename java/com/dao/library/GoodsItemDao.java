package com.dao.library;

import java.util.List;

import com.bean.library.GoodsItem;

public interface GoodsItemDao {
	public GoodsItem getItemByItId(int itid) throws Exception;
	public List<GoodsItem> getItemByCatalogCaId(int caid) throws Exception;
	public int addItem(GoodsItem gItem) throws Exception;
	public int saveItem(GoodsItem gItem) throws Exception;
	public int deleteItemByItId(int itid) throws Exception;
	public int deleteItemsByCaId(int caid) throws Exception;
	public int deleteItemsBySeId(int usid) throws Exception;
}

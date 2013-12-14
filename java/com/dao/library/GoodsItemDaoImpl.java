package com.dao.library;

import java.util.List;

import com.bean.library.GoodsItem;
import com.dao.BaseDao;
import com.dao.PostgreSQL;

public class GoodsItemDaoImpl extends BaseDao implements GoodsItemDao, PostgreSQL{

	@Override
	public GoodsItem getItemByItId(int itid) throws Exception {
		String sql = "SELECT * FROM scugo_goods_item WHERE itid = ?";
		return esql.query(GoodsItem.class, sql, itid);
	}

	@Override
	public List<GoodsItem> getItemByCatalogCaId(int caid) throws Exception {
		String sql = "SELECT * FROM scugo_goods_item WHERE caid = ?";
		return esql.list(GoodsItem.class, sql, caid);
	}

	@Override
	public int addItem(GoodsItem gItem) throws Exception {
		String sql = "INSERT INTO scugo_goods_item (name, seid, place, pricenormal, " +
				"pricemember, pricein, picture, caid, onselltime, soldnum, intime, " +
				"quantity, comment, isonsell, commentnum) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		return esql.update(sql, gItem.getName(), gItem.getSeid(), gItem.getPlace(),
				gItem.getPricenormal(), gItem.getPricemember(), gItem.getPricein(), gItem.getPicture(), 
				gItem.getCaid(), gItem.getOnselltime(), gItem.getSoldnum(), gItem.getIntime(), 
				gItem.getQuantity(), gItem.getComment(), gItem.getIsonsell(), gItem.getCommentnum());
	}

	@Override
	public int saveItem(GoodsItem gItem) throws Exception {
		String sql = "UPDATE scugo_goods_item SET name=?, seid=?, place=?, pricenormal=?, " +
				"pricemember=?, pricein=?, picture=?, caid=?, soldnum=?, selledtime=?, intime=?, " +
				"quantity=?, comment=?, isonsell=?, commentnum=? " +
				"WHERE itid=?";
		return esql.update(sql, gItem.getName(), gItem.getSeid(), gItem.getPlace(),
				gItem.getPricenormal(), gItem.getPricemember(), gItem.getPricein(), gItem.getPicture(), 
				gItem.getCaid(), gItem.getOnselltime(), gItem.getSoldnum(), gItem.getIntime(), 
				gItem.getQuantity(), gItem.getComment(), gItem.getIsonsell(), gItem.getCommentnum(), 
				gItem.getItid());
	}

	@Override
	public int deleteItemByItId(int itid) throws Exception {
		String sql = "DELETE FROM scugo_goods_item WHERE itid=?";
		return esql.update(sql, itid);
	}

	@Override
	public int deleteItemsByCaId(int caid) throws Exception {
		String sql = "DELETE FROM scugo_goods_item WHERE caid=?";
		return esql.update(sql, caid);
	}

	@Override
	public int deleteItemsBySeId(int usid) throws Exception {
		String sql = "DELETE FROM scugo_goods_item WHERE seid=?";
		return esql.update(sql, usid);
	}
	

}

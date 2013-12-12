package com.dao.library;

import java.util.List;

import com.bean.library.GoodsCatalog;
import com.dao.BaseDao;
import com.dao.PostgreSQL;

public class GoodsCatalogDaoImpl extends BaseDao implements GoodsCatalogDao, PostgreSQL {
	
	/**
	 * 通过分类ID查询分类
	 * @param ca_id 分类ID
	 * @return 分类信息
	 * @throws Exception
	 */
	public GoodsCatalog getCatalogByCaId(int caid) throws Exception {
		String sql = "SELECT * FROM scugo_goods_catalog WHERE caid = ?";
		return esql.query(GoodsCatalog.class, sql, caid);
	}
	
	/**
	 * 通过父类ID查询分类
	 * @param ca_id 分类ID
	 * @return 分类信息List
	 * @throws Exception
	 */
	public List<GoodsCatalog> getCatalogByParent(int caid) throws Exception {
		String sql = "SELECT * FROM scugo_goods_catalog WHERE parent = ?";
		return esql.list(GoodsCatalog.class, sql, caid);
	}
	
	/**
	 * 插入一条分类信息
	 * @param gc 分类信息
	 * @return 
	 * @throws Exception
	 */
	public int addCatalog(GoodsCatalog gc) throws Exception {
		String sql = "INSERT INTO scugo_goods_catalog (caid, name, level, parent, isbottom, isempty, comment) VALUES (NULL, ?, ?, ?, ?, ?, ?)";
		return esql.update(sql, gc.getName(), gc.getLevel(), gc.getParent(), gc.getIsbottom(), gc.getIsempty(), gc.getComment());
	}
	
	/**
	 * 修改一条分类信息
	 * @param gc 分类信息
	 * @return 
	 * @throws Exception
	 */
	public int saveCatalog(GoodsCatalog gc) throws Exception {
		String sql = "UPDATE scugo_goods_catalog SET name=?, level=?, parent=?, isbottom=?, isempty=?, comment=? "
				+ "WHERE caid=?";
		return esql.update(sql, gc.getName(), gc.getLevel(), gc.getParent(), gc.getIsbottom(), gc.getIsempty(), gc.getComment());
	}
	
	/**
	 * 删除一条分类信息
	 * @param ca_id
	 * @return
	 * @throws Exception
	 */
	public int deleteCatalogByCaId(int caid) throws Exception {
		String sql = "DELETE FROM scugo_goods_catalog WHERE caid=?";
		return esql.update(sql, caid);
	}
}

package com.dao.library;

import java.util.List;

import com.bean.library.GoodsCatalog;

public interface GoodsCatalogDao {
	public GoodsCatalog getCatalogByCaId(int caid) throws Exception;
	public List<GoodsCatalog> getCatalogByParent(int caid) throws Exception;
	public int addCatalog(GoodsCatalog gc) throws Exception;
	public int saveCatalog(GoodsCatalog gc) throws Exception;
	public int deleteCatalogByCaId(int caid) throws Exception;
}

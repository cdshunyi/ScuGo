package com.action.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bean.library.GoodsCatalog;
import com.dao.DaoManager;
import com.dao.library.GoodsCatalogDao;

public class GoodsCatalogAction {
	
	/**
	 * 查找某ID的所以子分类
	 * @param caid
	 * @return
	 */
	static public ArrayList<GoodsCatalog> findCatalogByParent(int caid) {
		
		DaoManager dManager = DaoManager.getInstance();
		GoodsCatalogDao gcDao = dManager.getDao(GoodsCatalogDao.class);
		
		ArrayList<GoodsCatalog> gCatalogs = null;
		
		try
		{
			dManager.begin();			
			gCatalogs = (ArrayList<GoodsCatalog>) gcDao.getCatalogByParent(caid);
			dManager.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			dManager.end();
		}
		
		return gCatalogs;
	}

	/**
	 * 查找从根分类开始的3层分类
	 * @return
	 */
	static public ArrayList<HashMap<String, Object>> findRoots() {
		
		ArrayList<HashMap<String, Object>> catalogMaps = new ArrayList<HashMap<String, Object>>();
		
		DaoManager dManager = DaoManager.getInstance();
		GoodsCatalogDao gcDao = dManager.getDao(GoodsCatalogDao.class);
		List<GoodsCatalog> rootCatalogs = null;
		List<GoodsCatalog> twoCatalogs = null;
		List<GoodsCatalog> threeCatalogs = null;
		
		try
		{
			dManager.begin();
			rootCatalogs = gcDao.getCatalogByParent(0);
			for (GoodsCatalog goodsCatalog : rootCatalogs) {
				HashMap<String, Object> tmpMap = new HashMap<String, Object>();
				ArrayList<HashMap<String, Object>> tmpList = new ArrayList<HashMap<String, Object>>();
				
				tmpMap.put("value", goodsCatalog);
				
				twoCatalogs = gcDao.getCatalogByParent(goodsCatalog.getCaid());
				for (GoodsCatalog goodsCatalog2 : twoCatalogs) {
					HashMap<String, Object> tmpMap2 = new HashMap<String, Object>();
					
					threeCatalogs = gcDao.getCatalogByParent(goodsCatalog2.getCaid());
					tmpMap2.put("value", goodsCatalog2);
					tmpMap2.put("children", threeCatalogs);
					tmpList.add(tmpMap2);
				}
				
				tmpMap.put("children", tmpList);
				catalogMaps.add(tmpMap);
			}
			dManager.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			dManager.end();
		}
		
		return catalogMaps;
	}
}

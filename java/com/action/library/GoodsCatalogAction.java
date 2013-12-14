package com.action.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.bean.library.GoodsCatalog;
import com.dao.DaoManager;
import com.dao.library.GoodsCatalogDao;

public class GoodsCatalogAction {
	
	/**
	 * 查询某分类ID的分类信息
	 * @param caid
	 * @return
	 */
	public static GoodsCatalog findCatalogByCaId(int caid) {
		
		DaoManager dManager = DaoManager.getInstance();
		GoodsCatalogDao gcDao = dManager.getDao(GoodsCatalogDao.class);
		
		GoodsCatalog gCatalog = null;
		
		try
		{
			dManager.begin();			
			gCatalog = gcDao.getCatalogByCaId(caid);
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
		
		return gCatalog;
	}
	
	/**
	 * 查找某ID的所以子分类
	 * @param caid
	 * @return
	 */
	public static ArrayList<GoodsCatalog> findCatalogByParent(int caid) {
		
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
	public static ArrayList<HashMap<String, Object>> findRoots() {
		
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
	
	/**
	 * 寻找从根分类到达ID为caid的分类的路径
	 * @param caid
	 * @return
	 */
	public static LinkedList<GoodsCatalog> findPathToCaId(int caid) {
		
		DaoManager dManager = DaoManager.getInstance();
		GoodsCatalogDao gcDao = dManager.getDao(GoodsCatalogDao.class);
		
		GoodsCatalog gCatalog = null;
		LinkedList<GoodsCatalog> pathCatalogs = new LinkedList<GoodsCatalog>();
		
		try
		{
			dManager.begin();
			gCatalog = gcDao.getCatalogByCaId(caid);
			pathCatalogs.addFirst(gCatalog);
			while (gCatalog.getParent() != 0) {
				gCatalog = gcDao.getCatalogByCaId(gCatalog.getParent());
				pathCatalogs.addFirst(gCatalog);
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
		
		return pathCatalogs;
	}
	
}

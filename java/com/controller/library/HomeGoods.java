package com.controller.library;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.library.GoodsCatalogAction;
import com.action.library.GoodsItemAction;
import com.bean.library.GoodsCatalog;
import com.bean.library.GoodsItem;

public class HomeGoods extends HttpServlet {

	private static final long serialVersionUID = -643106748240977060L;
	
	private String m;		// 操作方法
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		m = request.getParameter("m");
		
		if (m.equals("catalog")) {
			catalogGet(request, response);
		}
		else if (m.equals("item")) {
			itemGet(request, response);
		}
		// TODO 其他User方法
		else {
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		m = request.getParameter("m");
		
		// TODO 其他User方法
	}
	
	private void catalogGet(HttpServletRequest request, HttpServletResponse response) {
		
		String tpl_attr_action = "catalog";
		
		String caidStr = request.getParameter("id");
		
		if (caidStr == null || "".equals(caidStr) || "0".equals(caidStr)) {
			try {
				response.sendRedirect("index");
			} catch (IOException e) {
				e.printStackTrace();
			} 
			return;
		}
		
		int caid = Integer.parseInt(caidStr);
		GoodsCatalog gCatalog = GoodsCatalogAction.findCatalogByCaId(caid);
		LinkedList<GoodsCatalog> pathCatalogs = GoodsCatalogAction.findPathToCaId(caid);
		
		if (gCatalog.getIsbottom() == 1) {
			ArrayList<GoodsItem> gItems = GoodsItemAction.findItemByCatalogCaId(caid);
			request.setAttribute("tpl_goods_catalog_items", gItems);
		}
		else {
			ArrayList<GoodsCatalog> childrenCatalogs = GoodsCatalogAction.findCatalogByParent(caid);
			request.setAttribute("tpl_goods_catalog_children", childrenCatalogs);
		}
		
		request.setAttribute("tpl_attr_action", tpl_attr_action);
		request.setAttribute("tpl_attr_actstr", gCatalog.getName());
		request.setAttribute("tpl_goods_catalog", gCatalog);
		request.setAttribute("tpl_goods_path", pathCatalogs);
		
		try {
			request.getRequestDispatcher("/goods/catalog.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void itemGet(HttpServletRequest request, HttpServletResponse response) {
		String tpl_attr_action = "item";
		
		String itidStr = request.getParameter("id");
		if (itidStr == null || "".equals(itidStr) || "0".equals(itidStr)) {
			try {
				response.sendRedirect("index");
			} catch (IOException e) {
				e.printStackTrace();
			} 
			return;
		}
		int itid = Integer.parseInt(itidStr);
		
		GoodsItem gItem = GoodsItemAction.findItemByItId(itid);
		LinkedList<GoodsCatalog> pathCatalogs = GoodsCatalogAction.findPathToCaId(gItem.getCaid());
		
		request.setAttribute("tpl_attr_action", tpl_attr_action);
		request.setAttribute("tpl_attr_actstr", gItem.getName());
		request.setAttribute("tpl_goods_path", pathCatalogs);
		
		try {
			request.getRequestDispatcher("/goods/item.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

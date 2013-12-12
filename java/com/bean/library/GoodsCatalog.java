package com.bean.library;

public class GoodsCatalog {
	private int caid;
	private String name;
	private int level;
	private int parent;
	private int isbottom;
	private int isempty;
	private String comment;
	
	public int getCaid() {
		return caid;
	}
	public void setCaid(int caid) {
		this.caid = caid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public int getIsbottom() {
		return isbottom;
	}
	public void setIsbottom(int isbottom) {
		this.isbottom = isbottom;
	}
	public int getIsempty() {
		return isempty;
	}
	public void setIsempty(int isempty) {
		this.isempty = isempty;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}

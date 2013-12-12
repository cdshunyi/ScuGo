package com.dao;

import zuojie.esql.ESQL;

public abstract class BaseDao
{
	protected ESQL esql;

	protected BaseDao()
	{
	}

	public void setEsql(ESQL esql)
	{
		this.esql = esql;
	}
}

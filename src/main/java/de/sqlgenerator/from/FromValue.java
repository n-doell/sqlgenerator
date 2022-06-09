package de.sqlgenerator.from;

import de.sqlgenerator.SqlObject;
import de.sqlgenerator.Table;

public class FromValue implements SqlObject {

	private Table table;
	
	/**
	 * If you use this constructor you also need to override the 
	 * {@link #toSQL()} method or set the {@link #table} attribute
	 * manually
	 */
	protected FromValue() {
	}
	
	public FromValue(Table table) {
		this.table = table;
	}

	@Override
	public String toSQL() {
		return table.toSQL();
	}
}

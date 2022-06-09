package de.sqlgenerator.from;

import de.sqlgenerator.SqlObject;
import de.sqlgenerator.Table;

public class FromValue implements SqlObject {

	private Table table;
	
	public FromValue(Table table) {
		this.table = table;
	}

	@Override
	public String toSQL() {
		return table.toSQL();
	}
}

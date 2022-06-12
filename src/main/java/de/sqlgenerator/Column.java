package de.sqlgenerator;

import java.util.StringJoiner;

public class Column implements SqlObject {

	private String columnName; 
	private Table table;
	private SqlFunction function;
	
	public Column(String columnName, Table table) {
		this.columnName = columnName;
		this.table = table;
	}
	
	public Column(String columnName, Table table, SqlFunction function) {
		this.columnName = columnName;
		this.table = table;
		this.function = function;
	}

	@Override
	public String toSQL() {
		if (function != null) {
			return wrapInSqlFunction(getColumnSQL());
		}
		return getColumnSQL();
	}
	
	private String getColumnSQL() {
		String tableName = table.getTableName();
		if (table.getAlias() != null) {
			tableName = table.getAlias();
		}
		return tableName + "." + columnName;
	}

	private String wrapInSqlFunction(String sql) {
		return function.getFunctionName() + "(" + sql + ")";
	}
}

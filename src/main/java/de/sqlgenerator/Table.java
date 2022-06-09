package de.sqlgenerator;

import java.util.StringJoiner;

public class Table implements SqlObject {

	private final String tableName;
	private String alias;
	
	public Table(String tableName) {
		this.tableName = tableName;
	}
	
	public Table(String tableName, String alias) {
		this.tableName = tableName;
		this.alias = alias;
	}

	@Override
	public String toSQL() {
		if (this.alias == null) {
			return tableName;
		}
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add(tableName);
		joiner.add(SqlConst.AS);
		joiner.add(alias);
		return joiner.toString();
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public String getTableName() {
		return this.tableName;
	}
}

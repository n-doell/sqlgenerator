package de.sqlgenerator.select;

import de.sqlgenerator.SqlObject;

public class SelectValue implements SqlObject {

	protected final String columnName;
	private String alias;
	protected SelectValueFunction function;
	
	public SelectValue(String columnName) {
		this.columnName = columnName;
	}
	
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public void setFunction(SelectValueFunction function) {
		this.function = function;
	}
	
	private boolean hasAlias() {
		return alias != null && !alias.isBlank();
	}
	
	protected boolean hasFunction() {
		return function != null;
	}

	@Override
	public String toSQL() {
		String sql = columnName;
		if (hasFunction()) {
			sql = wrapInFunction(sql);
		}
		if (hasAlias()) {
			sql += " AS " + alias;
		}
		return sql;
	}
	
	protected String wrapInFunction(String value) {
		switch (function) {
			case COUNT: return "COUNT(" + value + ")";
			case AVG: return "AVG(" + value + ")";
			default: return value;
		}
	}
}

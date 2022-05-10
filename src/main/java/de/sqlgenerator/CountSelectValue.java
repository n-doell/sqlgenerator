package de.sqlgenerator;

import java.text.MessageFormat;

public class CountSelectValue extends SelectValue {
	
	private static final String COUNT = "COUNT({0})";
	private static final String COUNT_WITH_ALIAS = "COUNT({0}) AS {1}";
	
	public CountSelectValue(String columnName) {
		super(columnName);
	}

	public CountSelectValue(String columnName, String alias) {
		super(columnName, alias);
	}
	
	@Override
	public String toSQL() {
		if (hasNoAlias()) {
			return MessageFormat.format(COUNT_WITH_ALIAS, columnName, alias);
		}
		return MessageFormat.format(COUNT, columnName);
	}
	
	public static CountSelectValue getSelectCountFromAll() {
		return new CountSelectValue(SqlConst.DEFAULT_SELECT_VALUE);
	}
}

package de.sqlgenerator.select;

import de.sqlgenerator.SqlConst;

public class AsteriskSelectValue extends SelectValue {

	public AsteriskSelectValue() {
		super(SqlConst.DEFAULT_SELECT_VALUE);
	}
	
	@Override
	public void setAlias(String alias) {
		throw new UnsupportedOperationException("Cannot set an alias for asterisk");
	}

	@Override
	public String toSQL() {
		String sql = columnName;
		if (hasFunction()) {
			sql = wrapInFunction(sql);
		}
		return sql;
	}
	
}

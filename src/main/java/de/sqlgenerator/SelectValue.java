package de.sqlgenerator;

public class SelectValue implements SqlObject {

	protected final String columnName;
	protected String alias;
	
	public SelectValue(String columnName) {
		this.columnName = columnName;
	}
	
	public SelectValue(String columnName, String alias) {
		this.columnName = columnName;
		this.alias = alias;
	}
	
	protected boolean hasNoAlias() {
		return alias == null || alias.isBlank();
	}

	@Override
	public String toSQL() {
		if (hasNoAlias()) {
			return columnName;		
		}
		return columnName + " " + SqlConst.AS + " " + alias;
		
	}
	
	
}

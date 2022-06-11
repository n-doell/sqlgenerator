package de.sqlgenerator.groupby;

public enum OrderType {
	ASC("ASC"),
	DESC("DESC");
	
	private String typeAsSql;
	
	private OrderType(String type) {
		typeAsSql = type;
	}
	
	public String getTypeAsSql() {
		return typeAsSql;
	}
}

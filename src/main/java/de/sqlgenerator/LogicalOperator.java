package de.sqlgenerator;

public enum LogicalOperator {
	AND("AND"),
	OR("OR"), 
	BETWEEN("BETWEEN"),
	IN("IN"),
	LIKE("LIKE");
	
	private String operator;
	
	private LogicalOperator(String operator) {
		this.operator = operator;
	}
	
	public String getValue() {
		return operator;
	}
}

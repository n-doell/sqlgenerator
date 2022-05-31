package de.sqlgenerator.where;

public enum LogicalOperator {
	AND("AND"),
	OR("OR");
	
	private String operator;
	
	private LogicalOperator(String operator) {
		this.operator = operator;
	}
	
	public String getValue() {
		return operator;
	}
}

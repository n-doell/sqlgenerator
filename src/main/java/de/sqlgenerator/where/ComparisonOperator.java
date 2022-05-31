package de.sqlgenerator.where;

public enum ComparisonOperator {
	EQUALS("="),
	LESS_THAN("<");
	
	private String operator;
	
	private ComparisonOperator(String operator) {
		this.operator = operator;
	}
	
	public String getOperator() {
		return operator;
	}
}

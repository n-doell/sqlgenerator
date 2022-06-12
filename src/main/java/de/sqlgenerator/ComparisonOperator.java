package de.sqlgenerator;

public enum ComparisonOperator {
	EQUALS("="),
	LESS_THAN("<"),
	LESS_OR_EQUAL("<="),
	GREATER_THAN(">"),
	GREATER_OR_EQUAL(">="),
	NOT_EQUAL("<>");
	
	private String operator;
	
	private ComparisonOperator(String operator) {
		this.operator = operator;
	}
	
	public String getOperator() {
		return operator;
	}
}

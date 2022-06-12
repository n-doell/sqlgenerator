package de.sqlgenerator;

public enum SqlFunction {
	COUNT("COUNT"),
	AVERAGE("AVG"),
	SUM("SUM");
	
	private String functionName;
	
	private SqlFunction(String functionName) {
		this.functionName = functionName;
	}
	
	public String getFunctionName() {
		return functionName;
	}
}

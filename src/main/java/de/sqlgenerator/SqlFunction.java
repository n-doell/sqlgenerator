package de.sqlgenerator;

public enum SqlFunction {
	COUNT("COUNT"),
	AVERAGE("AVG"),
	SUM("SUM"),
	MIN("MIN"),
	MAX("MAX");
	
	private String functionName;
	
	private SqlFunction(String functionName) {
		this.functionName = functionName;
	}
	
	public String getFunctionName() {
		return functionName;
	}
}

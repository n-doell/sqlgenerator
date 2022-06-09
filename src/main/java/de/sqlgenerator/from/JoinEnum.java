package de.sqlgenerator.from;

public enum JoinEnum {
	LEFT_JOIN("LEFT JOIN"),
	RIGHT_JOIN("RIGHT JOIN"),
	INNER_JOIN("INNER JOIN"),
	FULL_JOIN("FULL JOIN");
	
	private String sqlString; 
	
	private JoinEnum(String sqlString) {
		this.sqlString = sqlString;
	}
	
	public String toSQL() {
		return sqlString;
	}
}

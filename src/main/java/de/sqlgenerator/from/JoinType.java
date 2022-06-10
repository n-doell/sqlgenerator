package de.sqlgenerator.from;

public enum JoinType {
	LEFT_JOIN("LEFT JOIN"),
	RIGHT_JOIN("RIGHT JOIN"),
	INNER_JOIN("INNER JOIN"),
	FULL_JOIN("FULL JOIN");
	
	private String sqlString; 
	
	private JoinType(String sqlString) {
		this.sqlString = sqlString;
	}
	
	public String toSQL() {
		return sqlString;
	}
}

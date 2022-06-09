package de.sqlgenerator.where;

import java.util.List;
import java.util.StringJoiner;

import de.sqlgenerator.ComparisonOperator;
import de.sqlgenerator.SqlObject;

public class In extends WhereClause {

	private SqlObject leftSide;
	private List<SqlObject> rightSide;
	
	public In(SqlObject leftSide, List<SqlObject> rightSide) {
		super();
		this.operator = ComparisonOperator.IN;
		this.leftSide = leftSide;
		this.rightSide = rightSide;
	}
	
	@Override
	public String toSQL() {
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add(leftSide.toSQL());
		joiner.add(operator.getOperator());
		joiner.add(getInValuesAsString());
		return joiner.toString();
	}
	
	private String getInValuesAsString() {
		StringJoiner joiner = new StringJoiner(",");
		for (SqlObject object : rightSide) {
			joiner.add(object.toSQL());
		}
		return "(" + joiner.toString() + ")";
	}
}

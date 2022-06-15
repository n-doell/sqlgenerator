package de.sqlgenerator.condition;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import de.sqlgenerator.LogicalOperator;
import de.sqlgenerator.SqlObject;

public class In extends Condition {

	private SqlObject leftSide;
	private List<SqlObject> rightSide = new ArrayList<SqlObject>();
	
	public In(SqlObject leftSide, List<SqlObject> rightSide) {
		super();
		this.leftSide = leftSide;
		this.rightSide.addAll(rightSide);
	}
	
	@Override
	public String toSQL() {
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add(leftSide.toSQL());
		joiner.add(LogicalOperator.IN.getValue());
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

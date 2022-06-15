package de.sqlgenerator.where;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import de.sqlgenerator.LogicalOperator;
import de.sqlgenerator.SqlConst;
import de.sqlgenerator.SqlObject;
import de.sqlgenerator.condition.Condition;

public class ConditionBuilder implements SqlObject {

	private List<ConditionWithOperator> clauses = new ArrayList<ConditionWithOperator>();
	private final String conditionType; // WHERE or HAVING
	private boolean printConditionType = true; // where or not to print the conditionType (needed for nested conditions)
	
	private ConditionBuilder(String conditionType) {
		this.conditionType = conditionType;
	}
	
	public void addCondition(Condition clause, LogicalOperator operator) {
		clauses.add(new SingleConditionWithOperator(clause, operator));
	}
	
	public void addNestedConditions(ConditionBuilder nestedConditions, LogicalOperator operator) {
		nestedConditions.printConditionType = false; // set false so that WHERE or HAVING are not printed
		clauses.add(new NestedConditionWithOperator(nestedConditions, operator));
	}
	
	@Override
	public String toSQL() {
		StringJoiner joiner = new StringJoiner(" ");
		if (printConditionType) {
			joiner.add(getConditionTypeAsSqlString());
		}
		joiner.add(getConditionAsSqlString());
		return joiner.toString();
	}
	
	private String getConditionTypeAsSqlString() {
		if (clauses.size() == 0) {
			return "";
		}
		return conditionType;	
	}
	
	private String getConditionAsSqlString() {
		if (clauses.size() == 0) {
			return "";
		}
		
		StringJoiner joiner = new StringJoiner(" ");
		for (int i = 0; i < clauses.size(); i++) {
			if (i != 0) {
				joiner.add(clauses.get(i).getOperator().getValue());
			}
			joiner.add(clauses.get(i).getConditionAsSQLString());
		}
		
		return joiner.toString();
	}
	
	public static final ConditionBuilder createWhereClauseConditionBuilder() {
		return new ConditionBuilder(SqlConst.WHERE);
	}
	
	public static final ConditionBuilder createHavingConditionBuilder() {
		return new ConditionBuilder(SqlConst.HAVING);
	}

}

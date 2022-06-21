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
	
	public static final ConditionBuilder createWhereClauseConditionBuilder(Condition condition) {
		ConditionBuilder where = new ConditionBuilder(SqlConst.WHERE);
		where.addCondition(condition, LogicalOperator.AND); // Operator does not matter because it is not printed for the first condition 
		return where;
	}
	
	public static final ConditionBuilder createWhereClauseConditionBuilder(ConditionBuilder nestedCondition) {
		ConditionBuilder where = new ConditionBuilder(SqlConst.WHERE);
		where.addNestedConditions(nestedCondition, LogicalOperator.AND); // Operator does not matter because it is not printed for the first condition 
		return where;
	}
	
	public static final ConditionBuilder createHavingConditionBuilder(Condition condition) {
		ConditionBuilder having = new ConditionBuilder(SqlConst.HAVING);
		having.addCondition(condition, LogicalOperator.AND); // Operator does not matter because it is not printed for the first condition 
		return having;
	}
	
	public static final ConditionBuilder createHavingConditionBuilder(ConditionBuilder nestedCondition) {
		ConditionBuilder having = new ConditionBuilder(SqlConst.HAVING);
		having.addNestedConditions(nestedCondition, LogicalOperator.AND); // Operator does not matter because it is not printed for the first condition 
		return having;
	}

}

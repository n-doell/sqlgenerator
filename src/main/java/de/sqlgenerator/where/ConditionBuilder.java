package de.sqlgenerator.where;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import de.sqlgenerator.SqlConst;
import de.sqlgenerator.SqlObject;

public class ConditionBuilder implements SqlObject {

	private List<ConditionWithOperator> clauses = new ArrayList<ConditionWithOperator>();
	private final String conditionType; // WHERE or HAVING
	
	private ConditionBuilder(String conditionType) {
		this.conditionType = conditionType;
	}
	
	public void addCondition(Condition clause, LogicalOperator operator) {
		clauses.add(new ConditionWithOperator(clause, operator));
	}
	
	public void addCondition(Condition clause) {
		clauses.add(new ConditionWithOperator(clause, LogicalOperator.AND));
	}
	
	@Override
	public String toSQL() {
		if (clauses.size() == 0) {
			return "";
		}
		
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add(conditionType);
		for (int i = 0; i < clauses.size(); i++) {
			if (i != 0) {
				joiner.add(clauses.get(i).getOperator().getValue());
			}
			joiner.add(clauses.get(i).getWhereClause().toSQL());
		}
		
		return joiner.toString();
	}
	
	public static final ConditionBuilder createWhereClauseConditionBuilder() {
		return new ConditionBuilder(SqlConst.WHERE);
	}
	
	public static final ConditionBuilder createHavingConditionBuilder() {
		return new ConditionBuilder(SqlConst.HAVING);
	}

	private class ConditionWithOperator {
	
		private Condition clause;
		private LogicalOperator operator;
		
		public ConditionWithOperator(Condition clause, LogicalOperator operator) {
			this.clause = clause;
			this.operator = operator;
		}
		
		public Condition getWhereClause() {
			return clause;
		}
		
		public LogicalOperator getOperator() {
			return operator;
		}
	}
}

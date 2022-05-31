package de.sqlgenerator.where;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import de.sqlgenerator.SqlConst;
import de.sqlgenerator.SqlObject;

public class ConditionBuilder implements SqlObject {

	private List<WhereClauseWithOperator> clauses = new ArrayList<WhereClauseWithOperator>();
	
	public void addCondition(WhereClause clause, LogicalOperator operator) {
		clauses.add(new WhereClauseWithOperator(clause, operator));
	}
	
	public void addCondition(WhereClause clause) {
		clauses.add(new WhereClauseWithOperator(clause, LogicalOperator.AND));
	}
	
	@Override
	public String toSQL() {
		if (clauses.size() == 0) {
			return "";
		}
		
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add(SqlConst.WHERE);
		for (int i = 0; i < clauses.size(); i++) {
			if (i != 0) {
				joiner.add(clauses.get(i).getOperator().getValue());
			}
			joiner.add(clauses.get(i).getWhereClause().toSQL());
		}
		
		return joiner.toString();
	}

	private class WhereClauseWithOperator {
	
		private WhereClause clause;
		private LogicalOperator operator;
		
		public WhereClauseWithOperator(WhereClause clause, LogicalOperator operator) {
			this.clause = clause;
			this.operator = operator;
		}
		
		public WhereClause getWhereClause() {
			return clause;
		}
		
		public LogicalOperator getOperator() {
			return operator;
		}
	}
}

package de.sqlgenerator.where;

import java.util.StringJoiner;

import de.sqlgenerator.SqlObject;

public class Like extends WhereClause {

	public Like(SqlObject leftSide, SqlObject rightSide) {
		super(leftSide, ComparisonOperator.LIKE, rightSide);
	}
	
	@Override
	public String toSQL() {
		SqlObject left = addQuotationIfNecessary(leftSide);
		SqlObject right = addQuotationIfNecessary(rightSide);
		
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add(left.toSQL());
		joiner.add(operator.getOperator());
		joiner.add(right.toSQL());
		return joiner.toString();
	}
	
	private SqlObject addQuotationIfNecessary(SqlObject object) {
		if (object instanceof NumberSqlObejct) {
			return new StringSqlObject(object.toSQL());
		}
		return object;
	}
}

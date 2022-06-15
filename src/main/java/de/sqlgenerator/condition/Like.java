package de.sqlgenerator.condition;

import java.util.StringJoiner;

import de.sqlgenerator.LogicalOperator;
import de.sqlgenerator.NumberSqlObejct;
import de.sqlgenerator.SqlObject;
import de.sqlgenerator.StringSqlObject;

public class Like extends Condition {

	public Like(SqlObject leftSide, SqlObject rightSide) {
		super();
		this.leftSide = leftSide;
		this.rightSide = rightSide;
	}
	
	@Override
	public String toSQL() {
		SqlObject left = addQuotationIfNecessary(leftSide);
		SqlObject right = addQuotationIfNecessary(rightSide);
		
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add(left.toSQL());
		joiner.add(LogicalOperator.LIKE.getValue());
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

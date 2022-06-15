package de.sqlgenerator.condition;

import java.util.StringJoiner;

import de.sqlgenerator.SqlConst;
import de.sqlgenerator.SqlObject;

public class NullCondition extends Condition {

	public NullCondition(SqlObject expectedNullObject) {
		super();
		this.leftSide = expectedNullObject;
	}
	
	@Override
	public String toSQL() {
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add(leftSide.toSQL());
		joiner.add(SqlConst.IS);
		joiner.add(SqlConst.NULL);
		return joiner.toString();
	}
}

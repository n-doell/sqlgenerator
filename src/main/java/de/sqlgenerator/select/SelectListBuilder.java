package de.sqlgenerator.select;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import de.sqlgenerator.SqlConst;
import de.sqlgenerator.SqlObject;

public class SelectListBuilder implements SqlObject {

	private List<SelectValue> values = new ArrayList<SelectValue>();
	
	public void addSelectValue(SelectValue value) {
		this.values.add(value);
	}
	
	@Override
	public String toSQL() {
		if (values.isEmpty()) {
			values.add(new AsteriskSelectValue());	
		}
		StringJoiner joiner = new StringJoiner(", ");
		values.forEach(value -> {
			joiner.add(value.toSQL());
		});
		return SqlConst.SELECT + " " + joiner.toString();
	}

	
}

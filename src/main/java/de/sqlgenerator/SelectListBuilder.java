package de.sqlgenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class SelectListBuilder implements SqlObject {

	private List<SelectValue> values = new ArrayList<SelectValue>();
	
	public void addSelectValue(SelectValue value) {
		this.values.add(value);
	}
	
	@Override
	public String toSQL() {
		if (values.isEmpty()) {
			return SqlConst.SELECT + " " + SqlConst.DEFAULT_SELECT_VALUE;	
		}
		StringJoiner joiner = new StringJoiner(", ");
		values.forEach(value -> {
			joiner.add(value.toSQL());
		});
		return SqlConst.SELECT + " " + joiner.toString();
	}

	
}

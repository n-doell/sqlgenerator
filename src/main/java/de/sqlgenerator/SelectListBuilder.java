package de.sqlgenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class SelectListBuilder implements SqlObject {

	private static final String DEFAULT_SELECT_VALUE = "*";
	private static final String SELECT = "SELECT";
	
	private List<SelectValue> values = new ArrayList<SelectValue>();
	
	public void addSelectValue(SelectValue value) {
		this.values.add(value);
	}
	
	@Override
	public String toSQL() {
		if (values.isEmpty()) {
			return SELECT + " " + DEFAULT_SELECT_VALUE;	
		}
		StringJoiner joiner = new StringJoiner(", ");
		values.forEach(value -> {
			joiner.add(value.toSQL());
		});
		return SELECT + " " + joiner.toString();
	}

	
}

package de.sqlgenerator.select;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import de.sqlgenerator.SqlConst;
import de.sqlgenerator.SqlObject;

public class SelectListBuilder implements SqlObject {

	private List<SelectValue> values = new ArrayList<SelectValue>();
	private boolean distinct = false;
	
	public void addSelectValue(SelectValue value) {
		this.values.add(value);
	}
	
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
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
		String selectList = joiner.toString();
		if (distinct) {
			selectList = "DISTINCT " + selectList;
		}
		return SqlConst.SELECT + " " + selectList;
		
	}

	
}

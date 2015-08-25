package com.dogant.selection;

public class Axis {

	private String name;
	private String type;

	public String getColumn() {

		return hasType() ? type + "(" + name + ")" : name;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean hasName() {
		return name != null && !name.isEmpty();
	}

	public Boolean hasType() {
		return type != null && !type.isEmpty();
	}

}

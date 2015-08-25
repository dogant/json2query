package com.dogant.selection;

public class Selection {

	private Axis x, y, z;

	public Axis getX() {
		return x;
	}

	public void setX(Axis x) {
		this.x = x;
	}

	public Axis getY() {
		return y;
	}

	public void setY(Axis y) {
		this.y = y;
	}

	public Axis getZ() {
		return z;
	}

	public void setZ(Axis z) {
		this.z = z;
	}

	public Boolean hasX() {
		return x != null && x.hasName();
	}

	public Boolean hasY() {
		return y != null && y.hasName();
	}

	public Boolean hasZ() {
		return z != null && z.hasName();
	}

}

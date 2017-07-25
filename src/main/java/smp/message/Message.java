package smp.message;

import java.util.ArrayList;

import smp.sale.Sale;

/**
 * 
 * Message.java
 * Purpose: Abstract base class for all received messages.
 *
 * @author Ayoola Adeogun
 * @version 1.0 7/24/2017
 */

public abstract class Message {
	private String name;
	private Character mUnit;
	
	public abstract ArrayList<Sale> createSale();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Character getmUnit() {
		return mUnit;
	}
	public void setmUnit(Character mUnit) {
		this.mUnit = mUnit;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mUnit == null) ? 0 : mUnit.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (mUnit == null) {
			if (other.mUnit != null)
				return false;
		} else if (!mUnit.equals(other.mUnit))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}

package smp.sale;

/**
 * 
 * SaleValue.java
 * Purpose: Class stores the value of a Sale as data could have an adjustment.
 *
 * @author Ayoola Adeogun
 * @version 1.0 7/24/2017
 */

public class SaleValue {
	private Adjustment adjustment;
	private int value;
	private char mUnit;
	
	public Adjustment getAdjustment() {
		return adjustment;
	}
	public void setAdjustment(Adjustment adjustment) {
		this.adjustment = adjustment;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public char getmUnit() {
		return mUnit;
	}
	public void setmUnit(char mUnit) {
		this.mUnit = mUnit;
	}
	@Override
	public String toString() {
		return "SaleValue [adjustment=" + adjustment + ", value=" + value + ", mUnit=" + mUnit + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adjustment == null) ? 0 : adjustment.hashCode());
		result = prime * result + mUnit;
		result = prime * result + value;
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
		SaleValue other = (SaleValue) obj;
		if (adjustment == null) {
			if (other.adjustment != null)
				return false;
		} else if (!adjustment.equals(other.adjustment))
			return false;
		if (mUnit != other.mUnit)
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	
	
}

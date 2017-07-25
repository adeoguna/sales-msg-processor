package smp.sale;

/**
 * 
 * Adjustment.java
 * Purpose: Class enables the storage of the type and amount of adjustment.
 *
 * @author Ayoola Adeogun
 * @version 1.0 7/24/2017
 */

public class Adjustment {
	private AdjustmentType adjustment;
	private int adjustmentAmt;
	private char mUnit;
	
	public AdjustmentType getAdjustment() {
		return adjustment;
	}
	public void setAdjustment(AdjustmentType adjustment) {
		this.adjustment = adjustment;
	}
	public int getAdjustmentAmt() {
		return adjustmentAmt;
	}
	public void setAdjustmentAmt(int adjustmentAmt) {
		this.adjustmentAmt = adjustmentAmt;
	}
	public char getmUnit() {
		return mUnit;
	}
	public void setmUnit(char mUnit) {
		this.mUnit = mUnit;
	}
	@Override
	public String toString() {
		return "Adjustment [adjustment=" + adjustment + ", adjustmentAmt=" + adjustmentAmt + ", mUnit=" + mUnit + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adjustment == null) ? 0 : adjustment.hashCode());
		result = prime * result + adjustmentAmt;
		result = prime * result + mUnit;
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
		Adjustment other = (Adjustment) obj;
		if (adjustment != other.adjustment)
			return false;
		if (adjustmentAmt != other.adjustmentAmt)
			return false;
		if (mUnit != other.mUnit)
			return false;
		return true;
	}
	
}

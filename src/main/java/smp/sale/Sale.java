package smp.sale;

/**
 * 
 * Sale.java
 * Purpose: Class stores Sale extracted from a message.
 *
 * @author Ayoola Adeogun
 * @version 1.0 7/24/2017
 */

public class Sale {
	
	private String productType;
	private SaleValue value;
	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public SaleValue getValue() {
		return value;
	}
	public void setValue(SaleValue value) {
		this.value = value;
	}
	
	
	 /**
     * 	Applies adjustments to a sale.
     *	@param An adjustment to apply to the sale.
     * 	@return
     */
	public void adjustValue(Adjustment adjustment){
		if(adjustment.getAdjustment() == AdjustmentType.ADD){
			value.setValue(value.getValue() + adjustment.getAdjustmentAmt());
		}else if(adjustment.getAdjustment() == AdjustmentType.MULTIPLY){
			value.setValue(value.getValue() * adjustment.getAdjustmentAmt());
		}else if(adjustment.getAdjustment() == AdjustmentType.SUBSTRACT){
			int newValue = value.getValue() - adjustment.getAdjustmentAmt();
			if(newValue < 0){
				newValue = 0;
			}
			value.setValue(newValue);
		}
	}
	@Override
	public String toString() {
		return "Sale [productType=" + productType + ", value=" + value + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Sale other = (Sale) obj;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
}

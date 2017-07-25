package smp.message;

import java.util.ArrayList;

import smp.sale.Adjustment;
import smp.sale.AdjustmentType;
import smp.sale.Sale;
import smp.sale.SaleValue;

/**
 * 
 * SingleSaleMsg.java
 * Purpose: Class for messages that create a single sale.
 *
 * @author Ayoola Adeogun
 * @version 1.0 7/24/2017
 */

public class SingleSaleMsg extends Message {
	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "SingleSaleMsg [name=" + getName() + ", mUnit=" + getmUnit() + ", price=" + price + "]";
	}

	@Override
	public ArrayList<Sale> createSale() {
		ArrayList<Sale> sales = new ArrayList<Sale>();
		Sale sale = new Sale();
		sale.setProductType(getName());
		SaleValue value = new SaleValue();
		value.setValue(getPrice());
		value.setmUnit(getmUnit());
		Adjustment adjustment = new Adjustment();
		adjustment.setAdjustment(AdjustmentType.NONE);
		adjustment.setmUnit(getmUnit());
		adjustment.setAdjustmentAmt(0);
		value.setAdjustment(adjustment);
		sale.setValue(value);
		sales.add(sale);
		return sales;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + price;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SingleSaleMsg other = (SingleSaleMsg) obj;
		if (price != other.price)
			return false;
		return true;
	}
	
}

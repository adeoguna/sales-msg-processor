package smp.message;

import java.util.ArrayList;

import smp.sale.Adjustment;
import smp.sale.AdjustmentType;
import smp.sale.Sale;
import smp.sale.SaleValue;

/**
 * 
 * MultiSaleMsg.java
 * Purpose: Class for messages that create multiple sales.
 *
 * @author Ayoola Adeogun
 * @version 1.0 7/24/2017
 */

public class MultiSaleMsg extends Message {
	private int quantity;
	private int unitPrice;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	@Override
	public String toString() {
		return "MultiSaleMsg [name=" + getName() + ", mUnit=" + getmUnit() + ", quantity=" + quantity + ", unitPrice=" + unitPrice + "]";
	}
	@Override
	public ArrayList<Sale> createSale() {
		ArrayList<Sale> sales = new ArrayList<Sale>();
		for(int count= 0; count < quantity; count++){
			Sale sale = new Sale();
			sale.setProductType(getName());
			SaleValue value = new SaleValue();
			value.setValue(getUnitPrice());
			value.setmUnit(getmUnit());
			Adjustment adjustment = new Adjustment();
			adjustment.setAdjustment(AdjustmentType.NONE);
			adjustment.setmUnit(getmUnit());
			adjustment.setAdjustmentAmt(0);
			value.setAdjustment(adjustment);
			sale.setValue(value);
			sales.add(sale);
		}
		
		return sales;
	}
	
}

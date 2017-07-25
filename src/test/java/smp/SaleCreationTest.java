package smp;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import smp.message.AdjustSaleMsg;
import smp.message.MultiSaleMsg;
import smp.message.SingleSaleMsg;
import smp.sale.Adjustment;
import smp.sale.AdjustmentType;
import smp.sale.Sale;
import smp.sale.SaleValue;

public class SaleCreationTest {

	@Test
	public void saleCreationFromSingleSaleMsgTest() {
		SingleSaleMsg inputMsg = new SingleSaleMsg();
		inputMsg.setName("apple");
		inputMsg.setmUnit('p');
		inputMsg.setPrice(10);
		
		Sale expectedSale = new Sale();
		expectedSale.setProductType("apple");
		SaleValue expectedValue = new SaleValue();
		Adjustment expectedAdjustment = new Adjustment();
		expectedAdjustment.setAdjustment(AdjustmentType.NONE);
		expectedAdjustment.setAdjustmentAmt(0);
		expectedAdjustment.setmUnit('p');
		expectedValue.setAdjustment(expectedAdjustment);
		expectedValue.setmUnit('p');
		expectedValue.setValue(10);
		expectedSale.setValue(expectedValue);
		
		ArrayList<Sale> actualSale = inputMsg.createSale();
		
		assertEquals(expectedSale, actualSale.get(0));
	}
	
	@Test
	public void saleCreationFromMultiSaleMsgTest() {
		MultiSaleMsg inputMsg = new MultiSaleMsg();
		inputMsg.setName("banana");
		inputMsg.setmUnit('p');
		inputMsg.setQuantity(9);
		inputMsg.setUnitPrice(22);
		
		Sale expectedSale = new Sale();
		expectedSale.setProductType("banana");
		SaleValue expectedValue = new SaleValue();
		Adjustment expectedAdjustment = new Adjustment();
		expectedAdjustment.setAdjustment(AdjustmentType.NONE);
		expectedAdjustment.setAdjustmentAmt(0);
		expectedAdjustment.setmUnit('p');
		expectedValue.setAdjustment(expectedAdjustment);
		expectedValue.setmUnit('p');
		expectedValue.setValue(22);
		expectedSale.setValue(expectedValue);
		
		ArrayList<Sale> actualSale = inputMsg.createSale();
		
		assertEquals(inputMsg.getQuantity(), actualSale.size());
		assertEquals(expectedSale, actualSale.get(0));
	}
	
	@Test
	public void saleCreationFromAdjustSaleMsgTest() {
		AdjustSaleMsg inputMsg = new AdjustSaleMsg();
		inputMsg.setName("apple");
		inputMsg.setmUnit('p');
		inputMsg.setOperation("Multiply");
		inputMsg.setAmount(2);
		
		Sale expectedSale = new Sale();
		expectedSale.setProductType("apple");
		SaleValue expectedValue = new SaleValue();
		Adjustment expectedAdjustment = new Adjustment();
		expectedAdjustment.setAdjustment(AdjustmentType.MULTIPLY);
		expectedAdjustment.setAdjustmentAmt(2);
		expectedAdjustment.setmUnit('p');
		expectedValue.setAdjustment(expectedAdjustment);
		expectedValue.setmUnit('p');
		expectedValue.setValue(0);
		expectedSale.setValue(expectedValue);
		
		ArrayList<Sale> actualSale = inputMsg.createSale();
		
		assertEquals(expectedSale, actualSale.get(0));
	}

}

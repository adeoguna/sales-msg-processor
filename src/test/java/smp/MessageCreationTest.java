package smp;

import static org.junit.Assert.*;

import org.junit.Test;

import smp.message.AdjustSaleMsg;
import smp.message.Message;
import smp.message.MessageFactory;
import smp.message.MultiSaleMsg;
import smp.message.SingleSaleMsg;

public class MessageCreationTest {

	@Test
	public void singleSaleMsgCreationTest() {
		String inputMsg = "apple at 10p";
		SingleSaleMsg expectedMsg = new SingleSaleMsg();
		expectedMsg.setName("apple");
		expectedMsg.setmUnit('p');
		expectedMsg.setPrice(10);
		MessageFactory msgFactory = new MessageFactory();
		Message actualMsg = null;
		try{
			actualMsg = msgFactory.createMessage(inputMsg);
		}catch(Exception e){
			e.printStackTrace();
		}
		assertEquals(expectedMsg, actualMsg);
	}
	
	@Test
	public void adjustSaleMsgCreationTest() {
		String inputMsg = "Multiply 2p apples";
		AdjustSaleMsg expectedMsg = new AdjustSaleMsg();
		expectedMsg.setName("apple");
		expectedMsg.setmUnit('p');
		expectedMsg.setOperation("Multiply");
		expectedMsg.setAmount(2);
		MessageFactory msgFactory = new MessageFactory();
		Message actualMsg = null;
		try{
			actualMsg = msgFactory.createMessage(inputMsg);
		}catch(Exception e){
			e.printStackTrace();
		}
		assertEquals(expectedMsg, actualMsg);
	}
	
	@Test
	public void multiSaleMsgCreationTest() {
		String inputMsg = "9 sales of bananas at 22p each";
		MultiSaleMsg expectedMsg = new MultiSaleMsg();
		expectedMsg.setName("banana");
		expectedMsg.setmUnit('p');
		expectedMsg.setQuantity(9);
		expectedMsg.setUnitPrice(22);
		MessageFactory msgFactory = new MessageFactory();
		Message actualMsg = null;
		try{
			actualMsg = msgFactory.createMessage(inputMsg);
		}catch(Exception e){
			e.printStackTrace();
		}
		assertEquals(expectedMsg, actualMsg);
	}

}

package smp.message;

/**
 * 
 * MessageFactory.java
 * Purpose: Object factory for creating SingleSaleMsg, AdjustSaleMsg or MultiSaleMsg.
 *
 * @author Ayoola Adeogun
 * @version 1.0 7/24/2017
 */

public class MessageFactory {
	
	 /**
     * 	Factory for creating the required messages from the string received.
     *	@param A random message from the MessageProvider.
     * 	@return A message implemented by one of SingleSaleMsg, MultiSaleMsg or AdjustSaleMsg types.
	 * @throws Exception 
     */
	public Message createMessage(String msg) throws Exception{
		
		String[]  msgTokens = msg.split(" ");
		
		if(msgTokens.length == 3){
			String firstToken = msgTokens[0];
			if(firstToken.equals("Add") || firstToken.equals("Multiply") || firstToken.equals("Substract")){
				return createAdjustSaleMsg(msgTokens);
			}else{
				return createSingleSaleMsg(msgTokens);
			}
		}else if(msgTokens.length == 7){
			return createMultiSaleMsg(msgTokens);
		}else{
			throw new Exception("Message.createMessage(String msg): Unsupported message from external party => " + msg);
		}
		
	}
	
	public Message createMultiSaleMsg(String[] tokenArray){
		MultiSaleMsg multiSaleMsg = new MultiSaleMsg();
		String quantity = tokenArray[0];
		String name = tokenArray[3];
		String unitPrice = tokenArray[5];
		multiSaleMsg.setName(name.substring(0, name.lastIndexOf('s')));
		multiSaleMsg.setQuantity(Integer.parseInt(quantity));
		multiSaleMsg.setmUnit(unitPrice.charAt(unitPrice.indexOf('p')));
		multiSaleMsg.setUnitPrice(Integer.parseInt(unitPrice.substring(0, unitPrice.indexOf('p'))));
		return multiSaleMsg;
	}
	
	public Message createAdjustSaleMsg(String[] tokenArray){
		AdjustSaleMsg adjustSaleMsg = new AdjustSaleMsg();
		String operation = tokenArray[0];
		String amount = tokenArray[1];
		String name = tokenArray[2];
		adjustSaleMsg.setName(name.substring(0, name.lastIndexOf('s')));
		adjustSaleMsg.setOperation(operation);
		adjustSaleMsg.setmUnit(amount.charAt(amount.indexOf('p')));
		adjustSaleMsg.setAmount(Integer.parseInt(amount.substring(0, amount.indexOf('p'))));
		return adjustSaleMsg;
	}
	
	public Message createSingleSaleMsg(String[] tokenArray){
		SingleSaleMsg singleSaleMsg = new SingleSaleMsg();
		String name = tokenArray[0];
		String unitPrice = tokenArray[2];
		singleSaleMsg.setName(name);
		singleSaleMsg.setmUnit(unitPrice.charAt(unitPrice.indexOf('p')));
		singleSaleMsg.setPrice(Integer.parseInt(unitPrice.substring(0, unitPrice.indexOf('p'))));
		return singleSaleMsg;
	}
}

/**
 * 
 */
package smp;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import smp.message.Message;
import smp.message.MessageFactory;
import smp.provider.ArrayMessageProvider;
import smp.provider.MessageProvider;
import smp.sale.AdjustmentType;
import smp.sale.Sale;

/**
 * 
 * SalesMessageProcessor.java
 * Purpose: Class initializes salesStore and msgProvider. It gets the 
 *			next message, processes it and stores it in the sales store.
 *			It prints the required reports at specified stages of the process.
 * @author Ayoola Adeogun
 * @version 1.0 7/24/2017
 */

public class SalesMessageProcessor {
    static int totalValue = 0;
    /**
     * 	Processes messages obtained from the message provider. Converts messages into sales
     * 	and initiates the printing of the required reports.
     *	@param 
     * 	@return
     */
    public static void main(String[] args) throws InterruptedException {
    	Map<String, ArrayList<Sale>> salesStore = new Hashtable<String, ArrayList<Sale>>();
    	MessageProvider msgProvider = new ArrayMessageProvider();
        for(int i = 1; i < 51; i++){
        	Message msg = getNextMessage(msgProvider.getMessageStr());
        	ArrayList<Sale> sales = msg.createSale();
        	processSales(sales, salesStore);
        	if(i % 10 == 0){
        		System.out.println("Interim Sales Report after 10 messages....");
        		printSalesReport(salesStore);
        	}
        }
        System.out.println("SalesMessageProcessor application is pausing.......");
        printAdjustmentReport(salesStore);
        Thread.sleep(6000);
    }
    
    /**
     * 	Read a line of text from the shell console.
     *	@param A String representing message arriving from the Message Provider.
     * 	@return An object that implements the Message interface.
     */
    public static Message getNextMessage(String msg){
    	MessageFactory msgFactory = new MessageFactory();
    	Message message = null;
    	try{
    		message = msgFactory.createMessage(msg);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return message;
    }
    
    public static void printAdjustmentReport(Map<String, ArrayList<Sale>> salesStore){
    	salesStore.forEach((key, value) -> {
    		value.forEach(sale->{
    			AdjustmentType adjustmentType = sale.getValue().getAdjustment().getAdjustment();
    			int adjustmentAmt = sale.getValue().getAdjustment().getAdjustmentAmt();
    			if(adjustmentType != AdjustmentType.NONE){
    				System.out.println("Adjustment to " + key + " : " + adjustmentType + " " + adjustmentAmt + "p.");
    			}
    		});
    	    
    	});
    }
    
    public static void printSalesReport(Map<String, ArrayList<Sale>> salesStore){
    	salesStore.forEach((key, value) -> {
    		int size = value.size();
    		totalValue = 0;
    		value.forEach(sale->{
    			totalValue += sale.getValue().getValue();
    		});
    	    System.out.println(size + " " + key + "s"+ " sold for " + totalValue + "p.");
    	});
    }
    
    /**
     * 	Goes through the new  sales generated from the latest message. Add it to the	
     * 	HashTable if it is new. New sales types that already exist in the HashTable are
     * 	added to the end of the value for that key. For adjustment sales, the adjustment
     * 	is made to all the existing sales and the sale is added to the store.
     * 
     *	@param A String representing message arriving from the Message Provider.
     * 	@return An object that implements the Message interface.
     */
    public static void processSales(ArrayList<Sale> sales, Map<String, ArrayList<Sale>> salesStore){
    	for(Sale sale: sales){
    		if(!salesStore.containsKey(sale.getProductType())){
    			ArrayList<Sale> newSaleType = new ArrayList<Sale>();
				newSaleType.add(sale);
				salesStore.put(sale.getProductType(), newSaleType);
    		}else{
    			ArrayList<Sale> storedSales = salesStore.get(sale.getProductType());
    			if(sale.getValue().getAdjustment().getAdjustment() != AdjustmentType.NONE){
        			for(Sale storedSale: storedSales){
        				if(storedSale.getValue().getAdjustment().getAdjustment() == AdjustmentType.NONE){
        					storedSale.adjustValue(sale.getValue().getAdjustment());
        				}
        			}
        		}
    			storedSales.add(sale);
    			salesStore.replace(sale.getProductType(), storedSales);
    		}
    	}    	
    }
    
}

package smp.provider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 
 * ArrayMessageProvider.java
 * Purpose: Class stores various types of messages and simulates a non-deterministic 
 *			source of messages by randomly selecting messages from collection.
 * @author Ayoola Adeogun
 * @version 1.0 7/24/2017
 */

public class ArrayMessageProvider implements MessageProvider {
	
	List <String> messages = new ArrayList<String>();
	
	public ArrayMessageProvider(){
		Collections.addAll(messages, 
							"apple at 10p",
							"lemon at 5p",
							"Substract 2p lemons",
							"Multiply 2p apples",
							"orange at 20p",
							"pear at 15p",
							"banana at 30p",
							"9 sales of bananas at 22p each",
							"25 sales of oranges at 12p each",
							"lemon at 5p",
							"apple at 10p",
							"pear at 15p",
							"Add 10p pears",
							"Add 9p bananas",
							"orange at 20p",
							"apple at 10p", 
							"lemon at 5p",
							"20 sales of pears at 18p each",
							"10 sales of bananas at 25p each",
							"5 sales of oranges at 15p each",
							"banana at 30p",
							"lemon at 5p",
							"25 sales of apples at 8p each",
							"10 sales of pears at 18p each",
							"Substract 8p apples",
							"8 sales of bananas at 25p each",
							"8 sales of oranges at 15p each",
							"pear at 15p",
							"banana at 30p",
							"20 sales of pears at 16p each",
							"orange at 20p",
							"apple at 10p",
							"20 sales of apples at 6p each",
							"30 sales of lemons at 3p each",
							"Add 8p apples",
							"pear at 15p",
							"apple at 10p",
							"Add 6p oranges",
							"Add 5p lemons",
							"12 sales of lemons at 4p each",
							"orange at 20p",
							"apple at 10p",
							"Substract 6p pears",
							"Substract 4p bananas",
							"apple at 10p",
							"banana at 30p",
							"Substract 8p oranges",
							"pear at 15p",
							"apple at 10p",
							"Multiply 3p pears",
							"Multiply 2p bananas",
							"14 sales of apples at 8p each",
							"apple at 10p",
							"lemon at 5p",
							"6 sales of lemons at 4p each",
							"Multiply 2p oranges",
							"Multiply 3p lemons"
							);
	}
	
	 /**
     * 	Gets a random message string from the collection.
     *	@param
     * 	@return A random message string
     */
	public String getMessageStr() {
		return messages.get(new Random().nextInt(messages.size()));
	}

}

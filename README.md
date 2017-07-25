# Sale Message Processor
A stand-alone java application for processing sales messages received from a external party. It transforms the messages into a sale, multiple sales or adjustment. It stores sales in a hash table after processing message. After every 10th message, it prints reports based on the sales stored in the hash table. After processing 50 messages it prints the adjustments that have been applied to products and stops processing the messages. Due to the non-deterministic nature of the message provider, if an adjustment message arrives before a message of that type is in the store, the sale is recorded but has no side effect. If a substract adjustment takes value of products below zero, the value is re-initialized to zero.

The instruction **You should assume that an external company will be sending you the input messages, but for the purposes of this exercise you are free to define the interfaces** gave the impression that i could make the format of the incoming messages more precise by using xml or json. I struggled with this but eventually I settled for using message examples provided in the problem specification. If a message arrives that does not follow the format, an unsupported message exception is thrown.

## Running the application
This is a maven project. It requires Java 1.8 compliance due to use of lambda expressions. The only dependency is to JUnit for running the included unit tests.
1. clone or download source from provided url
2. mvn compile
3. java

## Design and Implementation
Implementation classes are:
1. **SalesMessageProcessor** - entry point of application. Gets a random message from a collection 50 times. Converts each to a sale or multiple sales depending on type of message and prints the required reports at various stages. 
2. **MessageProvider**  - interface to the message service.
    2.1 ArrayMessageProvider  - implements a collection of string messages stored in an array. Simulates an indeterminate message source by enabling random selection of message from the collection.  
3. **MessageFactory**  - creates implementations of Message.
4. **Message**  - abstract base class of all messages. Additional type of messages can be implemented from extending this class.  
    4.1 SingleSaleMsg  - represents messages for single sale of a product.  
    4.2 MultiSaleMsg  - represents multiple sales of a product.  
    4.3 AdjustSaleMsg  - represents an adjustment to existing sales of a product.  
5. **Sale**  - represents a unit of sale. Created from a message and it has a product type and sales value. Sales value is a complex type that stores information about possible adjustment.  
    5.1 Adjustment  - represents the adjustment to be applied to a sale. It has an adjustment amount and adjustment type.  
    5.2 AdjustmentType  - represents the adjustment type of a value and can be NONE, MULTIPLY, SUBSTRACT or ADD.  
    5.3 SaleValue  - represents the value of a sale. A normal value does not have adjustment and its adjustment type is NONE. Adjustment values can have adjustment type of MULTIPLY, SUBSTRACT or ADD.

## Tests
Unit tests provided for methods that transforms the messages from string to single, multiple or adjustment message types. Unit tests are also provided for methods that transform single, multiple and adjustment message types into sales.
1. **MessageCreationTest** - test case for transforming strings to messages.  
    1.1 singleSaleMsgCreationTest - unit test for creating SingleSaleMsg from a single sale message string.  
    1.2 multiSaleMsgCreationTest - unit test for creating MultiSaleMsg from a multiple sale message string.  
    1.3 adjustSaleMsgCreationTest - unit test for creating AdjustSaleMsg from an adjustment sale message string.  
2. **SaleCreationTest** - test case for transforming messages to sale.  
	2.1 saleCreationFromSingleSaleMsgTest - unit test for creating a sale from a single sale message object.  
	2.2 saleCreationFromMultiSaleMsgTest - unit test for creating a set of sales from a multiple sale message object.
	2.3 saleCreationFromAdjustSaleMsgTest - unit test for creating a sale from an adjustment sale message object.
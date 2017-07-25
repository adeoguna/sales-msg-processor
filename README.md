# Sale Message Processor
A stand-alone java application for processing sales messages received from a external party.

## Running the application
This is a maven project. It requires Java 1.8 compliance due to use of lambda expressions. The only dependency is to JUnit. In the command line do:
1. git clone
2. mvn compile
3. java

## Design and Implementation
Major classes are:  
1. MessageProvider  
    1.1 ArrayMessageProvider  
2. MessageFactory  
3. Message  
    3.1 SingleSaleMsg  
    3.2 MultiSaleMsg  
    3.3 AdjustSaleMsg  
4. Sale  
    4.1 Adjustment  
    4.2 AdjustmentType  
    4.3 SaleValue  
5. SalesMessageProcessor

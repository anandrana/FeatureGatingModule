package exceptions;


public class OperandTypeException extends Exception{
    public OperandTypeException(String logicalOperator, String s){
        super("For the logical operator = "+logicalOperator+" -> "+s);
    }
}
package operators;

import exceptions.OperandCountException;
import exceptions.OperandTypeException;

import java.util.ArrayList;
import java.util.List;

public class GreaterThanEqual implements LogicalOperator {
    private static int precedence;
    private static GreaterThanEqual greaterThanEqual = null;
    private List<String> symbols;
    private int operandCount;

    private GreaterThanEqual(){
        precedence = 4;
        symbols = new ArrayList<String>();
        symbols.add(">=");
        operandCount = 2;
    }

    public static GreaterThanEqual getInstance() {
        if(greaterThanEqual == null)
            greaterThanEqual = new GreaterThanEqual();
        return greaterThanEqual;
    }

    public int getOperandCount() {
        return operandCount;
    }

    public int getPrecedence() {
        return precedence;
    }

    public List<String> getSymbols() {
        return symbols;
    }

    public <E> boolean operate(List<E> operands) throws Exception {
        if(operands.size()!=operandCount)
            throw new OperandCountException("GreaterThanEqual", operandCount, operands.size());
        E operand1 = operands.get(0);
        E operand2 = operands.get(1);
        if(operand1 instanceof Integer){
            if(operand2 instanceof Integer){
                return (Integer)operand1>=(Integer)operand2;
            }
            if(operand2 instanceof Double){
                return (Integer)operand1>=(Double)operand2;
            }
            throw new OperandTypeException("GreaterThanEqual", "Operand Type Mismatch");
        }
        if(operand1 instanceof Double){
            if(operand2 instanceof Double){
                return (Double)operand1>=(Double)operand2;
            }
            if(operand2 instanceof Integer){
                return (Double)operand1>=(Integer)operand2;
            }
            throw new OperandTypeException("GreaterThanEqual", "Operand Type Mismatch");
        }
        throw new OperandTypeException("GreaterThanEqual", "Operand Type Not Supported");
    }

}

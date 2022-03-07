package operators;

import exceptions.OperandCountException;
import exceptions.OperandTypeException;

import java.util.ArrayList;
import java.util.List;

public class GreaterThan implements LogicalOperator {
    private static int precedence;
    private static GreaterThan greaterThan = null;
    private List<String> symbols;
    private int operandCount;

    private GreaterThan(){
        precedence = 4;
        symbols = new ArrayList<String>();
        symbols.add(">");
        operandCount = 2;
    }

    public static GreaterThan getInstance() {
        if(greaterThan == null)
            greaterThan = new GreaterThan();
        return greaterThan;
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
            throw new OperandCountException("GreaterThan", operandCount, operands.size());
        E operand1 = operands.get(0);
        E operand2 = operands.get(1);

        if(operand1 instanceof Integer){
            if(operand2 instanceof Integer){
                return (Integer)operand1>(Integer)operand2;
            }
            if(operand2 instanceof Double){
                return (Integer)operand1>(Double)operand2;
            }
            throw new OperandTypeException("GreaterThan", "Operand Type Mismatch");
        }
        if(operand1 instanceof Double){
            if(operand2 instanceof Double){
                return (Double)operand1>(Double)operand2;
            }
            if(operand2 instanceof Integer){
                return (Double)operand1>(Integer)operand2;
            }
            throw new OperandTypeException("GreaterThan", "Operand Type Mismatch");
        }
        throw new OperandTypeException("GreaterThan", "Operand Type Not Supported");
    }

}

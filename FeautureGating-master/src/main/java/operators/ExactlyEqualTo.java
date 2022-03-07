package operators;

import exceptions.OperandCountException;

import java.util.ArrayList;
import java.util.List;

public class ExactlyEqualTo implements LogicalOperator {
    private static int precedence;
    private static ExactlyEqualTo exactlyEqualTo = null;
    private List<String> symbols;
    private int operandCount;

    private ExactlyEqualTo(){
        precedence = 4;
        symbols = new ArrayList<String>();
        symbols.add("==");
        operandCount = 2;
    }
    public static ExactlyEqualTo getInstance() {
        if(exactlyEqualTo == null)
            exactlyEqualTo = new ExactlyEqualTo();
        return exactlyEqualTo;
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
            throw new OperandCountException("ExactlyEqual", operandCount, operands.size());
        E operand1 = operands.get(0);
        E operand2 = operands.get(1);
        if(operand1 instanceof String && operand2 instanceof String)
            return ((String) operand1).equalsIgnoreCase((String) operand2);
        return operand1.equals(operand2);
    }
}

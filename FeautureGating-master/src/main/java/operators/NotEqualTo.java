package operators;

import exceptions.OperandCountException;

import java.util.ArrayList;
import java.util.List;

public class NotEqualTo implements LogicalOperator {
    private static int precedence;
    private static NotEqualTo notEqualTo = null;
    private List<String> symbols;
    private int operandCount;

    private NotEqualTo(){
        precedence = 4;
        symbols = new ArrayList<String>();
        symbols.add("!=");
        symbols.add("ne");
        operandCount = 2;
    }

    public static NotEqualTo getInstance() {
        if(notEqualTo == null)
            notEqualTo = new NotEqualTo();
        return notEqualTo;
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
            throw new OperandCountException("NotEqualTo", operandCount, operands.size());
        if(operands.get(0) instanceof String && operands.get(1) instanceof String)
            return !(((String) operands.get(0)).equalsIgnoreCase((String) operands.get(1)));
        return !operands.get(0).equals(operands.get(1));
    }
}

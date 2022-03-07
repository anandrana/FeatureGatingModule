package operators;

import exceptions.OperandCountException;

import java.util.ArrayList;
import java.util.List;

public class NoneOf implements LogicalOperator{
    private static int precedence;
    private static NoneOf noneOf = null;
    private List<String> symbols;
    private int operandCount;

    private NoneOf(){
        precedence = 5;
        symbols = new ArrayList<String>();
        symbols.add("NoneOf");
        symbols.add("noneof");
        symbols.add("noneOf");
        operandCount = 3;
    }

    public static NoneOf getInstance(){
        if(noneOf == null)
            noneOf = new NoneOf();
        return noneOf;
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
            throw new OperandCountException("NoneOf", operandCount, operands.size());

        ExactlyEqualTo exactlyEqualTo = ExactlyEqualTo.getInstance();
        E operand = operands.get(0);
        for(int i=1;i<operands.size();i++){
            List<E> list = new ArrayList<E>();
            list.add(operand);
            list.add(operands.get(i));
            if(exactlyEqualTo.operate(list))
                return false;
        }
        return true;
    }
}

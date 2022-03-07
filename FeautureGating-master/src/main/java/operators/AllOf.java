package operators;

import exceptions.OperandCountException;

import java.util.ArrayList;
import java.util.List;

public class AllOf implements LogicalOperator {
    private static int precedence;
    private static AllOf allOf = null;
    private static List<String> symbols;
    private static int operandCount;

    private AllOf(){
        precedence = 5;
        symbols = new ArrayList<String>();
        symbols.add("AllOf");
        symbols.add("allOf");
        symbols.add("allof");
        operandCount = 3;
    }

    public static AllOf getInstance(){
        if(allOf == null)
            allOf = new AllOf();
        return allOf;
    }

    public int getPrecedence() {
        return precedence;
    }

    public int getOperandCount() {
        return operandCount;
    }

    public List<String> getSymbols() {
        return symbols;
    }

    public <E> boolean operate(List<E> operands) throws Exception {
        if(operands.size()!=operandCount)
            throw new OperandCountException("AllOf", operandCount, operands.size());

        ExactlyEqualTo exactlyEqualTo = ExactlyEqualTo.getInstance();
        E operand = operands.get(0);
        for(int i=1;i<operands.size();i++){
            List<E> list = new ArrayList<E>();
            list.add(operand);
            list.add(operands.get(i));
            if(!exactlyEqualTo.operate(list))
                return false;
        }
        return true;
    }
}

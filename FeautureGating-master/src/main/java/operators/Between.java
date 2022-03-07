package operators;

import exceptions.OperandCountException;
import exceptions.OperandTypeException;

import java.util.ArrayList;
import java.util.List;

public class Between implements LogicalOperator {
    private static Between between = null;
    private static int precedence;
    private List<String> symbols;
    private int operandCount;

    private Between(){
        precedence = 5;
        symbols = new ArrayList<String>();
        symbols.add("Between");
        symbols.add("B/W");
        symbols.add("BETWEEN");
        symbols.add("between");
        operandCount = 3;
    }

    public static Between getInstance(){
        if(between==null)
            between = new Between();
        return between;
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
            throw new OperandCountException("Between", operandCount, operands.size());
        E operand = operands.get(0);
        E start = operands.get(1);
        E end = operands.get(2);

        if(operand instanceof Integer){
            if(start instanceof Integer && end instanceof Integer){
                return (((Integer)operand>=(Integer)start)&&((Integer)operand<=(Integer)end));
            }
            throw new OperandTypeException("Between", "Operand Type Mismatch");
        }
        if(operand instanceof Double){
            if(start instanceof Double && end instanceof Double){
                return (((Double)operand>=(Double)start)&&((Double)operand<=(Double)end));
            }
            throw new OperandTypeException("Between", "Operand Type Mismatch");
        }
        throw new OperandTypeException("Between", "Operand Type Not Supported");
    }
}

package operators;

import exceptions.OperandCountException;
import exceptions.OperandTypeException;

import java.util.ArrayList;
import java.util.List;

public class LogicalAND implements LogicalOperator {
    private static int precedence;
    private static LogicalAND logicalAND = null;
    private List<String> symbols;
    private int operandCount;

    private LogicalAND(){
        precedence = 2;
        symbols = new ArrayList<String>();
        symbols.add("AND");
        symbols.add("&&");
        symbols.add("and");
        operandCount = 2;
    }

    public static LogicalAND getInstance(){
        if(logicalAND == null)
            logicalAND = new LogicalAND();
        return logicalAND;
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
            throw new OperandCountException("LogicalAND", operandCount, operands.size());
        for (E operand : operands){
            if(!(operand instanceof Boolean)){
                throw new OperandTypeException("LogicalAND", "Operand Type Not Supported");
            }
        }
        for(E operand : operands){
            if((Boolean)operand == false)
                    return false;
        }
        return true;
    }
}

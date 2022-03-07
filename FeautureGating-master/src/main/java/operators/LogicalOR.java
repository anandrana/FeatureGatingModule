package operators;

import exceptions.OperandCountException;
import exceptions.OperandTypeException;

import java.util.ArrayList;
import java.util.List;

public class LogicalOR implements LogicalOperator {
    private static int precedence;
    private static LogicalOR logicalOR = null;
    private List<String> symbols;
    private int operandCount;

    private LogicalOR(){
        precedence = 1;
        symbols = new ArrayList<String>();
        symbols.add("||");
        symbols.add("OR");
        symbols.add("or");
        operandCount = 2;
    }

    public static LogicalOR getInstance(){
        if(logicalOR == null)
            logicalOR = new LogicalOR();
        return logicalOR;
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
            throw new OperandCountException("LogicalOR", operandCount, operands.size());
        for (E operand : operands){
            if(!(operand instanceof Boolean)){
                throw new OperandTypeException("LogicalOR", "Operand Type Not Supported");
            }
        }
        for(E operand : operands){
            if((Boolean)operand == true)
                return true;
        }
        return false;
    }
}
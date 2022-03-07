package operators;


import java.util.List;

public interface LogicalOperator {
    int getPrecedence();
    int getOperandCount();
    List<String> getSymbols();
    <E> boolean operate( List<E> operands ) throws Exception;
}

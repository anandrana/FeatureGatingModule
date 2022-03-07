package calculations;

import operators.*;

import java.util.*;

public class Calculator {

    private static Calculator calculator = null;
    private static Set<LogicalOperator> operators;
    private static HashMap<String, LogicalOperator> symbolOperatorMap;

    public static Calculator getInstance(){
        if(calculator==null)
            calculator = new Calculator();
        return calculator;
    }
    private Calculator() {
        populateOperators();
    }

    private void populateOperators() {
        operators = new HashSet<LogicalOperator>();
        operators.add(AllOf.getInstance());
        operators.add(Between.getInstance());
        operators.add(ExactlyEqualTo.getInstance());
        operators.add(GreaterThan.getInstance());
        operators.add(GreaterThanEqual.getInstance());
        operators.add(LessThan.getInstance());
        operators.add(LessThanEqual.getInstance());
        operators.add(LogicalAND.getInstance());
        operators.add(LogicalNOT.getInstance());
        operators.add(LogicalOR.getInstance());
        operators.add(NoneOf.getInstance());
        operators.add(NotEqualTo.getInstance());

        symbolOperatorMap = createSymbolMap(operators);
    }

    private HashMap<String,LogicalOperator> createSymbolMap(Set<LogicalOperator> operators) {
        HashMap<String, LogicalOperator> hashMap = new HashMap<String, LogicalOperator>();

        for(LogicalOperator operator : operators){
            List<String> symbols = operator.getSymbols();
            for(String symbol : symbols){
                hashMap.put(symbol, operator);
            }
        }
        return hashMap;
    }


    public static String infixToPostfix(String exp)
    {
        String result = new String("");

        Stack<String> stack = new Stack<String>();
        String[] elements = exp.split(" ");

        for (String element : elements)
        {
            if (element.equalsIgnoreCase("("))
                stack.push(element);

            else if (element.equalsIgnoreCase(")"))
            {
                while (!stack.isEmpty() && !stack.peek().equalsIgnoreCase("("))
                    result = result + stack.pop() + " ";

                if (!stack.isEmpty() && !stack.peek().equalsIgnoreCase("("))
                    return "Invalid Expression";
                else
                    stack.pop();
            }
            else if (!isOperator(element)) {
                result = result + element + " ";
            }
            else
            {
                while (!stack.isEmpty() && getOperatorPrecedence(element) <= getOperatorPrecedence(stack.peek())){
                    if(stack.peek().equalsIgnoreCase("("))
                        return "Invalid Expression";
                    result = result + stack.pop() + " ";
                }
                stack.push(element);
            }
        }
        while (!stack.isEmpty()){
            if(stack.peek().equalsIgnoreCase("("))
                return "Invalid Expression";
            result = result + stack.pop() + " ";
        }
        return result;
    }

    private static boolean isOperator(String str) {

        for(String key : symbolOperatorMap.keySet()){
            if(str.equalsIgnoreCase(key))
                return true;
        }
        return false;
    }

    private static int getOperatorPrecedence(String str) {
        if(symbolOperatorMap.containsKey(str)){
            return symbolOperatorMap.get(str).getPrecedence();
        }
        else {
            return -1;
        }
    }

    public static boolean evaluateInfix(String infixExpression, Context context) throws Exception {
        return evaluatePostfix(infixToPostfix(infixExpression).replace("(", "").replace(")",""), context);
    }

    public static boolean evaluatePostfix(String postfixExpression, Context context) throws Exception {

        Stack<Object> stack=new Stack<Object>();

        String[] elements = postfixExpression.split(" ");

        for (String element : elements)
        {
            if(isOperator(element))
            {
                List<Object> operandList = new ArrayList<Object>();
                LogicalOperator logicalOperator = symbolOperatorMap.get(element);
                for(int i=1; i<=logicalOperator.getOperandCount();i++){
                    operandList.add(stack.pop());
                }
                operandList = reverseOperandList(operandList);
                stack.push(logicalOperator.operate(operandList));
            }
            else {
                Object value = context.getValue(element);
                if(value!=null) {
                    stack.push(value);
                }
                else if(element.equalsIgnoreCase("true"))
                    stack.push(true);
                else if(element.equalsIgnoreCase("false"))
                    stack.push(false);
                else {
                    try {
                        int val = Integer.parseInt(element);
                        stack.push(val);
                        continue;
                    }catch (NumberFormatException nfe){ }
                    try {
                        double val = Double.parseDouble(element);
                        stack.push(val);
                        continue;
                    }catch (NumberFormatException nfe){ }
                    stack.push(element);
                }
            }
        }
        return (Boolean)stack.pop();
    }

    private static List<Object> reverseOperandList(List<Object> operandList) {
        int length = operandList.size();
        List<Object> reversedList = new ArrayList<Object>();
        for(int i=length-1; i>=0; i--)
            reversedList.add(operandList.get(i));
        return reversedList;
    }
}
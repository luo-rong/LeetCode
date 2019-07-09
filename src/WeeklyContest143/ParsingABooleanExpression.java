package WeeklyContest143;

import java.util.Stack;

public class ParsingABooleanExpression {
    private static final String op = "!|&";

    private char calculate(char op, StringBuilder bools) {
        char result;
        switch (op) {
            case '!':
                result = bools.charAt(0) == 't' ? 'f' : 't';
                break;
            case '|':
                result = 'f';
                for (int i = 0; i < bools.length(); ++i) {
                    result = bools.charAt(i) == 't' || result == 't' ? 't' : 'f';
                }
                break;
            case '&':
                result = 't';
                for (int i = 0; i < bools.length(); ++i) {
                    result = bools.charAt(i) == 't' && result == 't' ? 't' : 'f';
                    if (result == 'f') {
                        break;
                    }
                }
                break;
            default:
                result = ' ';
        }
        return result;
    }


    public boolean parseBoolExpr(String expression) {
        Stack<Character> boolStack = new Stack<>(), opStack = new Stack<>();
        for (int i = 0; i < expression.length(); ++i) {
            char ch = expression.charAt(i);
            if (ch != ',') {
                if (op.indexOf(ch) != -1) {
                    opStack.push(ch);
                } else if (ch == ')') {
                    char bool;
                    StringBuilder bools = new StringBuilder();
                    while ((bool = boolStack.pop()) != '(') {
                        bools.append(bool);
                    }
                    boolStack.push(calculate(opStack != null ? opStack.pop() : ' ', bools));
                } else {
                    boolStack.push(ch);
                }
            }
        }
        return boolStack.pop() == 't' ? true : false;
    }

    public static void main(String[] args) {
        ParsingABooleanExpression expression = new ParsingABooleanExpression();
        System.out.println(expression.parseBoolExpr("|(f,t)"));
    }
}

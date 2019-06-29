package _227_BasicCalculatorII;

import java.util.Stack;

public class BasicCalculator {
    // 初始状态为1
    private static final int EMPTY_STATUS = 0;
    private static final int OP_BLANK_STATUS = 1;
    private static final int NUM_BLANK_STATUS = 2;
    private static final int NUMBER_STATUS = 3;
    private static final int OPERATOR_STATUS = 4;

    private static final String BLANK = " ";
    private static final String NUMBER = "0123456789";
    private static final String OPERATOR = ".+-*/";

    private Stack<Integer> numStack;
    private Stack<Character> opStack;

    private int getOpPrecedence(char op) {
        switch (op) {
            case '*':
            case '/':
                return 1;
            case '+':
            case '-':
                return 2;
            default:
                return Integer.MAX_VALUE;
        }
    }

    private void addNumToStack(char input, boolean isNew) {
        int num = input - NUMBER.charAt(0);
        if (!isNew) {
            num += numStack.pop() * 10;
        }
        numStack.push(num);
    }

    private void addOpToStack(char input) {
        if (opStack.size() == 0 || getOpPrecedence(input) < getOpPrecedence(opStack.peek())) {
            opStack.push(input);
        } else {
            // TODO 除数为0
            doCalculate(input);
            opStack.push(input);
        }
    }

    private boolean doCalculate(char currOp) {
        while (numStack.size() > 1 && getOpPrecedence(currOp) >= getOpPrecedence(opStack.peek())) {
            int num = 0;
            switch (OPERATOR.indexOf(opStack.pop())) {
                case 1:
                    num = numStack.pop() + numStack.pop();
                    break;
                case 2:
                    num = -numStack.pop() + numStack.pop();
                    break;
                case 3:
                    num = numStack.pop() * numStack.pop();
                    break;
                case 4:
                    num = numStack.pop();
                    if (num == 0) {
                        return false;
                    }
                    num = numStack.pop() / num;
                    break;
                default:
            }
            numStack.push(num);
        }
        return true;
    }

    private int fsm(int currStatus, char input) {
        switch (currStatus) {
            case OP_BLANK_STATUS:
                if (BLANK.indexOf(input) >= 0) {
                    return OP_BLANK_STATUS;
                } else if (NUMBER.indexOf(input) >= 0) {
                    addNumToStack(input, true);
                    return NUMBER_STATUS;
                }
                return EMPTY_STATUS;
            case NUM_BLANK_STATUS:
                if (BLANK.indexOf(input) >= 0) {
                    return NUM_BLANK_STATUS;
                } else if (OPERATOR.indexOf(input) >= 0) {
                    addOpToStack(input);
                    return OPERATOR_STATUS;
                }
                return EMPTY_STATUS;
            case NUMBER_STATUS:
                if (NUMBER.indexOf(input) >= 0) {
                    addNumToStack(input, false);
                    return NUMBER_STATUS;
                } else if (BLANK.indexOf(input) >= 0) {
                    return NUM_BLANK_STATUS;
                } else if (OPERATOR.indexOf(input) >= 0) {
                    addOpToStack(input);
                    return OPERATOR_STATUS;
                }
                return EMPTY_STATUS;
            case OPERATOR_STATUS:
                if (NUMBER.indexOf(input) >= 0) {
                    addNumToStack(input, true);
                    return NUMBER_STATUS;
                } else if (BLANK.indexOf(input) >= 0) {
                    return OP_BLANK_STATUS;
                }
                return EMPTY_STATUS;
            default:

        }
        return 0;
    }

    public int calculate(String s) {
        if (s.length() == 0) {
            return 0;
        }
        numStack = new Stack<>();
        opStack = new Stack<>();
        int status = OP_BLANK_STATUS;
        for (int i = 0; i < s.length(); ++i) {
            if (status == EMPTY_STATUS) {
                throw new RuntimeException("非法输入：" + s.charAt(i));
            }
            status = fsm(status, s.charAt(i));
        }
        doCalculate('.');
        return numStack.pop();
    }

    public static void main(String[] args) {
        BasicCalculator basicCalculator = new BasicCalculator();
        System.out.println(basicCalculator.calculate(""));
        System.out.println(basicCalculator.calculate(" 3 + 2 "));
        System.out.println(basicCalculator.calculate("3+2*2"));
        System.out.println(basicCalculator.calculate("3+3-2*3"));
        System.out.println(basicCalculator.calculate("3 + 3   - 2 *3+3*1/2+4"));
    }
}

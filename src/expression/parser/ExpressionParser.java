package expression.parser;

import expression.*;

public class ExpressionParser implements Parser {

    private Pointer pointer;

    public TripleExpression parse(String expression) {
        pointer = new Pointer(expression);
        return parseShifts();
    }
    
    private TripleExpression parseShifts() {
        TripleExpression result = parseAddSub();
        while (true) {
            switch (pointer.getType()) {
                case LEFT_SHIFT:
                    result = new Left_Shift(result, parseAddSub());
                    break;
                case RIGHT_SHIFT:
                    result = new Right_Shift(result, parseAddSub());
                    break;
                default:
                    return result;
            }
        }
    }

    private TripleExpression parseAddSub() {
        TripleExpression result = parseMulDiv();
        while (true) {
            switch (pointer.getType()) {
                case ADD:
                    result = new Add(result, parseMulDiv());
                    break;
                case SUB:
                    result = new Subtract(result, parseMulDiv());
                    break;
                default:
                    return result;
            }
        }
    }

    private TripleExpression parseMulDiv() {
        TripleExpression result = parseLower();
        while (true) {
            switch (pointer.getType()) {
                case MUL:
                    result = new Multiply(result, parseLower());
                    break;
                case DIV:
                    result = new Divide(result, parseLower());
                    break;
                default:
                    return result;
            }
        }
    }

    private TripleExpression parseLower() {
        TripleExpression result = null;
        switch (pointer.getNext().getType()) {
            case VARIABLE:
                result = new Variable(pointer.getContent());
                pointer.getNext();
                break;
            case CONST:
                result = new Const(Integer.parseUnsignedInt(pointer.getContent()));
                pointer.getNext();
                break;
            case INVERSE:
                result = new Inversion(parseLower());
                break;
            case BRACE_OPN:
                result = parseShifts();
                pointer.getNext();
                break;
        }
        return result;
    }
}
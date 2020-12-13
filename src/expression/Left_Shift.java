package expression;

public class Left_Shift extends Binary {

    public Left_Shift(TripleExpression first, TripleExpression second) {
        super(first, second);
    }

    protected int apply(int first, int second) {
        return first << second;
    }

}

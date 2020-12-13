package expression;

public class Right_Shift extends Binary {

    public Right_Shift(TripleExpression first, TripleExpression second) {
        super(first, second);
    }

    protected int apply(int first, int second) {
        return first >> second;
    }

}

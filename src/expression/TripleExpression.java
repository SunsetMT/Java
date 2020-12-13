package expression;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public interface TripleExpression extends CommonExpression {
    int evaluate(int x, int y, int z);
}

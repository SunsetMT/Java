package expression;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public strictfp interface DoubleExpression extends CommonExpression {
    double evaluate(double x);
}

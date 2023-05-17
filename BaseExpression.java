/**
 * @author noa benita
 * BaseExpression class - binary or unary expressions.
 */
public abstract class BaseExpression implements Expression {
    private final Expression e1;
    private final Expression e2;
    /**
     * @param e1 - first expression
     * @param e2 - second expression
     * constructor
     */
    public BaseExpression(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }
    /**
     * @return the first expression
     */
    public Expression getE1() {
        return e1;
    }
    /**
     * @return the second expression
     */
    public Expression getE2() {
        return e2;
    }

}

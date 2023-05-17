import java.util.List;
/**
 * @author noa benita
 * BinaryExpression class - unary operator operates on only one operand.
 */
public abstract class UnaryExpression extends BaseExpression {
    /**
     * @param e1 - first expression
     * constructor - uses the fields of the base expressions.
     */
    public UnaryExpression(Expression e1) {
        super(e1, e1);
    }

    @Override
    public List<String> getVariables() {
        return super.getE1().getVariables();
    }
}

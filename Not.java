import java.util.Map;
/**
 * @author noa benita
 * Not class - describe a boolean action - logic expression
 * change each verse or pattern to the opposite verse or pattern in their meaning and conditions of truth.
 */
public class Not extends UnaryExpression {
    /**
     * @param e1 - first expression
     * constructor - uses the fields of the unary expressions.
     */
    public Not(Expression e1) {
        super(e1);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        boolean value = super.getE1().evaluate(assignment);
        return !value;
    }

    @Override
    public Boolean evaluate() throws Exception {
        boolean value = super.getE1().evaluate();
        return !value;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Expression a1 = super.getE1().assign(var, expression);
        return new Not(a1);
    }

    @Override
    public Expression nandify() {
        Expression n1 = super.getE1().nandify();
        return new Nand(n1, n1);
    }

    @Override
    public Expression norify() {
        Expression n1 = super.getE1().norify();
        return new Nor(n1, n1);
    }

    @Override
    public Expression simplify() {
        Expression s1 = super.getE1().simplify();
        if (s1.toString().equals(FALSE)) {
            return new Val(true);
        }
        if (s1.toString().equals(TRUE)) {
            return new Val(false);
        }
        return new Not(s1);
    }

    @Override
    public String toString() {
        String s1 = super.getE1().toString();
        return "~(" + s1 + ")";
    }
}

import java.util.Map;
/**
 * @author noa benita
 * Or class - describe a boolean action - logic expression
 * return true when at least one of the two components is real
 */
public class Or extends BinaryExpression {
    /**
     * @param e1 - first expression
     * @param e2 - second expression
     * constructor - uses the fields of the binary expressions.
     */
    public Or(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return super.getE1().evaluate(assignment) || super.getE2().evaluate(assignment);
    }

    @Override
    public Boolean evaluate() throws Exception {
        return super.getE1().evaluate() || super.getE2().evaluate();
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Expression a1 = super.getE1().assign(var, expression);
        Expression a2 = super.getE2().assign(var, expression);
        return new Or(a1, a2);
    }

    @Override
    public Expression nandify() {
        Expression n1 = super.getE1().nandify();
        Expression n2 = super.getE2().nandify();
        return new Nand(new Nand(n1, n1), new Nand(n2, n2));
    }

    @Override
    public Expression norify() {
        Expression n1 = super.getE1().norify();
        Expression n2 = super.getE2().norify();
        return new Nor(new Nor(n1, n2), new Nor(n1, n2));
    }

    @Override
    public Expression simplify() {
        // x | T = T
        // x | F = x
        // x | x = x
        Expression s1 = super.getE1().simplify();
        Expression s2 = super.getE2().simplify();

        if (s1.toString().equals(TRUE) || s2.toString().equals(TRUE)) {
            return new Val(true);
        }
        if (s1.toString().equals(FALSE)) {
            return s2.simplify();
        }
        if (s2.toString().equals(FALSE)) {
            return s1.simplify();
        }
        if (s1.toString().equals(s2.toString())) {
            return s1.simplify();
        }
        return new Or(s1, s2);
    }

    @Override
    public String toString() {
        String s1 = super.getE1().toString();
        String s2 = super.getE2().toString();
        return "(" + s1 + " | " + s2 + ")";
    }
}

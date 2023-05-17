import java.util.Map;
/**
 * @author noa benita
 * Nor class - describe a boolean action - logic expression
 *      the oposite from the "or" action
 */
public class Nor extends BinaryExpression {
    /**
     * @param e1 - first expression
     * @param e2 - second expression
     * constructor - uses the fields of the binary expressions.
     */
    public Nor(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        boolean v1 = super.getE1().evaluate(assignment);
        boolean v2 = super.getE2().evaluate(assignment);
        return !(v1 || v2);
    }

    @Override
    public Boolean evaluate() throws Exception {
        boolean v1 = super.getE1().evaluate();
        boolean v2 = super.getE2().evaluate();
        return !(v1 || v2);
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Expression a1 = super.getE1().assign(var, expression);
        Expression a2 = super.getE2().assign(var, expression);
        return new Nor(a1, a2);
    }

    @Override
    public Expression nandify() {
        Expression n1 = super.getE1().nandify();
        Expression n2 = super.getE2().nandify();
        Expression exp1 = new Nand(n1, n1);
        Expression exp2 = new Nand(n2, n2);
        return new Nand(new Nand(exp1, exp2), new Nand(exp1, exp2));
    }

    @Override
    public Expression norify() {
        Expression n1 = super.getE1().norify();
        Expression n2 = super.getE2().norify();
        return new Nor(n1, n2);
    }

    @Override
    public Expression simplify() {
        //x ↓ T = F
        //x ↓ F = ~(x)
        //x ↓ x = ~(x)
        Expression s1 = super.getE1().simplify();
        Expression s2 = super.getE2().simplify();
        if (s1.toString().equals(TRUE) || s2.toString().equals(TRUE)) {
            return new Val(false);
        }
        if (s1.toString().equals(FALSE)) {
            return new Not(s2).simplify();
        }
        if (s2.toString().equals(FALSE)) {
            return new Not(s1).simplify();
        }
        if (s1.toString().equals(s2.toString())) {
            return new Not(s1).simplify();
        }
        return new Nor(s1, s2);
    }

    @Override
    public String toString() {
        String s1 = super.getE1().toString();
        String s2 = super.getE2().toString();
        return "(" + s1 + " V " + s2 + ")";
    }
}

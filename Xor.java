import java.util.Map;

/**
 * @author noa benita
 * Xor class - describe a boolean action that receives two operands
 * and returns truth when the two operands are different.
 */
public class Xor extends BinaryExpression {
    /**
     * @param e1 - first expression
     * @param e2 - second expression
     *           constructor - uses the fields of the binary expressions.
     */
    public Xor(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return super.getE1().evaluate(assignment) ^ super.getE2().evaluate(assignment);
    }

    @Override
    public Boolean evaluate() throws Exception {
        return super.getE1().evaluate() ^ super.getE2().evaluate();
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Expression a1 = super.getE1().assign(var, expression);
        Expression a2 = super.getE2().assign(var, expression);
        return new Xor(a1, a2);
    }

    @Override
    public Expression nandify() {
        Expression n1 = super.getE1().nandify();
        Expression n2 = super.getE2().nandify();
        Expression exp = new Nand(n1, n2);
        return new Nand(new Nand(n1, exp), new Nand(n2, exp));
    }

    @Override
    public Expression norify() {
        Expression n1 = super.getE1().norify();
        Expression n2 = super.getE2().norify();
        Expression exp1 = new Nor(n1, n1);
        Expression exp2 = new Nor(n2, n2);
        Expression exp3 = new Nor(n1, n2);
        return new Nor(new Nor(exp1, exp2), exp3);
    }

    @Override
    public Expression simplify() {
        // x ^ T = ~(x)
        // x ^ F = x
        // x ^ x = F
        Expression s1 = super.getE1().simplify();
        Expression s2 = super.getE2().simplify();
        if (s1.toString().equals(TRUE)) {
            return new Not(s2).simplify();
        }
        if (s2.toString().equals(TRUE)) {
            return new Not(s1).simplify();
        }
        if (s1.toString().equals(FALSE)) {
            return s2.simplify();
        }
        if (s2.toString().equals(FALSE)) {
            return s1.simplify();
        }
        if (s1.toString().equals(s2.toString())) {
            return new Val(false);
        }
        return new Xor(s1, s2);
    }

    @Override
    public String toString() {
        String s1 = super.getE1().toString();
        String s2 = super.getE2().toString();
        return "(" + s1 + " ^ " + s2 + ")";
    }
}

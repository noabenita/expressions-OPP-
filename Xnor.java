import java.util.Map;
/**
 * @author noa benita
 * Xnor class - describe a boolean action - logic expression
 *      a mix of the "xor" and "not" actions - the oposit from the "xor" action
 */
public class Xnor extends BinaryExpression {
    /**
     * @param e1 - first expression
     * @param e2 - second expression
     * constructor - uses the fields of the binary expressions.
     */
    public Xnor(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        boolean v1 = super.getE1().evaluate(assignment);
        boolean v2 = super.getE2().evaluate(assignment);
        return !(v1 ^ v2);
    }

    @Override
    public Boolean evaluate() throws Exception {
        boolean v1 = super.getE1().evaluate();
        boolean v2 = super.getE2().evaluate();
        return !(v1 ^ v2);
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Expression a1 = super.getE1().assign(var, expression);
        Expression a2 = super.getE2().assign(var, expression);
        return new Xnor(a1, a2);
    }

    @Override
    public Expression nandify() {
        Expression n1 = super.getE1().nandify();
        Expression n2 = super.getE2().nandify();
        Expression exp1 = new Nand(n1, n1);
        Expression exp2 = new Nand(n2, n2);
        Expression exp3 = new Nand(n1, n2);
        return new Nand(new Nand(exp1, exp2), exp3);
    }

    @Override
    public Expression norify() {
        Expression n1 = super.getE1().norify();
        Expression n2 = super.getE2().norify();
        Expression exp = new Nor(n1, n2);
        return new Nor(new Nor(n1, exp), new Nor(n2, exp));
    }

    @Override
    public Expression simplify() {
        Expression s1 = super.getE1().simplify();
        Expression s2 = super.getE2().simplify();
        if (s1.toString().equals(s2.toString())) {
            return new Val(true);
        }
        return new Xnor(s1, s2);
    }

    @Override
    public String toString() {
        String s1 = super.getE1().toString();
        String s2 = super.getE2().toString();
        return "(" + s1 + " # " + s2 + ")";
    }
}

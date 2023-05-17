import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/**
 * @author noa benita
 * BinaryExpression class - binary operator operates on two operands.
 */
public abstract class BinaryExpression extends BaseExpression {
    /**
     * @param e1 - first expression
     * @param e2 - second expression
     * constructor - uses the fields of the base expressions.
     */
    public BinaryExpression(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public List<String> getVariables() {
        List<String> vars1 = super.getE1().getVariables();
        List<String> vars2 = super.getE2().getVariables();
        List<String> union = vars1;
        union.addAll(vars2);
        Set<String> list = new LinkedHashSet<String>();
        list.addAll(union);
        union.clear();
        union.addAll(list);
        return union;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * @author noa benita
 * Val class - representing variables.
 */
public class Var implements Expression {
    private final String string;
    /**
     * @param str - a string.
     * constructor - assign a variable.
     */
    public Var(String str) {
        this.string = str;
    }
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        if (assignment.containsKey(string)) {
            return assignment.get(string);
        }
        throw new Exception();
    }

    @Override
    public Boolean evaluate() throws Exception {
        throw new Exception();
    }

    @Override
    public List<String> getVariables() {
        List<String> variable = new ArrayList<>();
        variable.add(this.string);
        return variable;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        if (var.equals(string)) {
            return expression;
        }
        return this;
    }

    @Override
    public Expression nandify() {
        return this;
    }

    @Override
    public Expression norify() {
        return this;
    }

    @Override
    public Expression simplify() {
        return this;
    }

    @Override
    public String toString() {
        return this.string;
    }
}

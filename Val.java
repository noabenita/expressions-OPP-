import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * @author noa benita
 * Val class - representing values.
 */
public class Val implements Expression {
    private final boolean value;
    /**
     * @param val - a value
     * constructor - assign a value.
     */
    public Val(boolean val) {
        this.value = val;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return this.value;
    }

    @Override
    public Boolean evaluate() throws Exception {
        return this.value;
    }

    @Override
    public List<String> getVariables() {
        return new ArrayList<>();
    }

    @Override
    public Expression assign(String var, Expression expression) {
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
        if (this.value) {
            return "T";
        }
        return "F";
    }
}

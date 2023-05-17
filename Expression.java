import java.util.List;
import java.util.Map;

/**
 * @author noa benita
 * the Expression interface.
 */
public interface Expression {
    String FALSE = "F";
    String TRUE = "T";

    /**
     * @param assignment - mapping the boolean value.
     * Evaluate the expression using the variable values provided
     *                   in the assignment, and return the result. If the expression
     *                   contains a variable which is not in the assignment, an exception
     *                   is thrown.
     * @return true/false
     * @throws Exception - throw exception
     */
    Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     * @return true/false
     * @throws Exception - throw exception
     */
    Boolean evaluate() throws Exception;

    /**
     * Returns a list of the variables in the expression.
     * @return a list
     */
    List<String> getVariables();

    /**
     * Returns a nice string representation of the expression.
     * @return a string
     */
    String toString();

    /**
     * @param var        - representing variables.
     * @param expression - the new expression to assign instead of var.
     * Returns a new expression in which all occurrences of the variable
     *                   var are replaced with the provided expression (Does not modify the
     *                   current expression).
     * @return an expression
     */
    Expression assign(String var, Expression expression);

    /**
     * Returns the expression tree resulting from converting all the operations to the logical Nand operation.
     * @return an expression
     */
    Expression nandify();

    /**
     * Returns the expression tree resulting from converting all the operations to the logical Nor operation.
     * @return an expression
     */
    Expression norify();

    /**
     * Returned a simplified version of the current expression.
     * @return an expression
     */
    Expression simplify();
}
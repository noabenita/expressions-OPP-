import java.util.Map;
import java.util.TreeMap;

/**
 * @author noa benita
 * testing class with a main method
 */
public class ExpressionsTest {

    /**
     * @param args a main method with a test example
     * @throws Exception - throw exception
     */
    public static void main(String[] args) throws Exception {
        Var x = new Var("x");
        Var y = new Var("y");
        Var z = new Var("z");

        Expression e = new Xor(new And(x, y), new Or(z, new Val(false)));
        System.out.println(e);
        Map<String, Boolean> ass = new TreeMap<>();
        ass.put("x", true);
        ass.put("y", true);
        ass.put("z", false);
        try {
            System.out.println(e.evaluate(ass));
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        System.out.println(e.nandify());
        System.out.println(e.norify());
        System.out.println(e.simplify());
    }
}

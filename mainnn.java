import java.util.Map;
import java.util.TreeMap;

/**
 * @author noa benita
 * testing class with a main method
 */
public class mainnn {

    /**
     * @param args a main method with a test example
     * @throws Exception - throw exception
     */
    public static void main(String[] args) throws Exception {
        Var x = new Var("x");

        Expression e = new Or(x, new Val(false));
        System.out.println(e);
        Map<String, Boolean> ass = new TreeMap<>();
        //ass.put("x", true);
        ass.put("y", true);
        ass.put("z", false);
        try {
            System.out.println(e.evaluate(ass));
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        //System.out.println(e.evaluate(ass));
        System.out.println(e.nandify());
        System.out.println(e.norify());
        System.out.println(e.simplify());
    }
}

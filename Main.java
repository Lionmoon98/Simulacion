package hands;
/**
 * @author Lionmoon
 */

public class Main {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        SimpleLinearRegression slr = new SimpleLinearRegression();

       
        slr.ImprimirEcuacionRegresion();
        slr.PredecirY(x);

    }
}

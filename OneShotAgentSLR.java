package hands;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
/**
 * @author Lionmoon
 */
public class OneShotAgentSLR extends Agent{

    /**
     * @param args the command line arguments
     */
        private SLRGui myGui;
        private SimpleLinearRegression slr;


        protected void setup() {
            System.out.println("Hola" + getLocalName());
            myGui = new SLRGui(this);
            slr = new SimpleLinearRegression();
        }
        
        public void predict(int value){
            addBehaviour(new OneShotBehaviour(){
                public void action(){
                    slr.ImprimirEcuacionRegresion();
                    slr.PredecirY(value);
                }
            });
        }
}
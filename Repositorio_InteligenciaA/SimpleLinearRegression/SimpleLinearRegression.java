package hands;

import java.util.ArrayList;
import java.util.List;
import java.math.*;

/**
 *
 * @author Lionmoon
 * 
 */
public class SimpleLinearRegression {


        private class DataS{

                public int n =10;
                public final int[] x;
                public final int[] y;
                public double SigmaX2i = 0 ;
                public double SigmaYi = 0 ;
                public double SigmaXiYi = 0 ;
                public double SigmaXi = 0 ;

                public DataS(){
                        this.x = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                        this.y = new int[]{3, 6, 9, 12, 15, 18, 21, 24, 27, 30};

                        this.SigmaX2i = 0;

                        System.out.println("DataSet");
                        String patron = "%4d|%5d|%5d";
                        System.out.println("Anno|Venta|Publicidad");

                        for (int i= 0; i < this.n; i++){
                         System.out.println(String.format(patron, (i+1),this.x[i], this.y[i]));     
                         this.SigmaX2i += this.x[i]*this.x[i];
                         this.SigmaYi += this.y[i];
                         this.SigmaXi += this.x[i];
                         this.SigmaXiYi += this.x[i]* this.y[i];
                        

                         
                        }
                       
                      
                       //System.out.println(String.valueOf(SigmaX2i).toString()); 
                      
                }
        }
        public DataS ds;
        public double BETA_0;
        public double BETA_1;
        
        

        public SimpleLinearRegression(){ //Aqui se hace referencia a las determinantes de las Betas
                System.out.println("instanciando case");
                this.ds = new DataS();
                BETA_0 = this.dBETA_0()/this.dSystem();
                BETA_1 = this.dBETA_1()/this.dSystem();

        }

        public double dSystem(){
                return (this.ds.n * this.ds.SigmaX2i) - (this.ds.SigmaXi * this.ds.SigmaXi);
        }

        public double dBETA_0(){
                return (this.ds.SigmaX2i*this.ds.SigmaYi)-(this.ds.SigmaXi * this.ds.SigmaXiYi);
        }

       
        public double dBETA_1(){

                return (this.ds.n*this.ds.SigmaXiYi)-(this.ds.SigmaXi*this.ds.SigmaYi);
        }

        public void ImprimirEcuacionRegresion(){
                System.out.println("Y = " + String.valueOf(BETA_0) + " + " + String.valueOf(BETA_1) + " X " );
        }

        public void PredecirY(int x){
                System.out.println("Costo " + String.valueOf(x));
                System.out.println("Valor a predecir de Y: " + String.valueOf(BETA_0+BETA_1*x));
        }

       


}
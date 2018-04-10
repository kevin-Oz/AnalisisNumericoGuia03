/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisnumerico;

import org.nfunk.jep.JEP;

/**
 *
 * @author kevin
 */
public class Funcion {
    
    JEP hi= new JEP();
    
        public Funcion(String def){
            hi.addVariable("x", 0);
            hi.addStandardConstants();
            hi.addStandardFunctions();
            hi.parseExpression(def);
            if(hi.hasError()){
                System.out.println(hi.getErrorInfo());
            }
        
        }
    public double eval(double x){
        double d;
        
        hi.addVariable("x", x);
        d=hi.getValue();
            if(hi.hasError()){
                System.out.println(hi.getErrorInfo());
            }
         
        return d;
        
    }
       
        
}

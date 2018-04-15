/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisnumerico;

import org.nfunk.jep.JEP;

/**
 *
 * @author kevin Figueroa
 */
public class Funcion {
    
    JEP hi= new JEP();
    
        public Funcion(String funci){
            hi.addVariable("x", 0);
            hi.addStandardConstants();
            hi.addStandardFunctions();
            hi.parseExpression(funci);
            if(hi.hasError()){
                System.out.println(hi.getErrorInfo());
            }
        
        }
    public double eval(double x){
        double resp;
        
        hi.addVariable("x", x);
        resp=hi.getValue();
            if(hi.hasError()){
                System.out.println(hi.getErrorInfo());
            }
         
        return resp;
        
    }
       
        
}

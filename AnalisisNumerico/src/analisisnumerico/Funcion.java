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
    
    public static double [] SacarCoeficientes(String funci){
          int k=0;
        String[] funcion;
         funcion = funci.split("[^\\d\\*.|-]");
        double [] separador = new double[funcion.length];
       
       
        for (String elemento : funcion) {    
            if(elemento.equals("")){
                
            }else{
            separador[k]=Double.parseDouble(elemento);
            k++;
        }
        }
        double [] coeficientes= new double [k];
     
        for (int i = 0; i <coeficientes.length; i++) { 
          coeficientes[i]=separador[i];
     }  

        for (int i = 0; i <coeficientes.length; i++) {
             System.out.println("posicion "+ i+"  value= "+coeficientes[i]); 
        }
        
        return coeficientes;
        
    }
       
        
}

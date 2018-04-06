/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisnumerico;

/**
 *
 * @author kevin
 */
public class Proceso {
    
    
     public static double[] discriminante(double a, double b, double c) {
        double h, g, d;
        h = (3 * b - Math.pow(a, 2)) / 9;
        g = (9 * a * b - 27 * c - 2 * Math.pow(a, 3)) / 54;
        d = Math.pow(g, 2) + Math.pow(h, 3);

        double valores[] = {d, h, g};
        return valores;
    }
     
     
     
     public static double [] tartaglia(double a,double b,double c){
           
         
         double resp[] = discriminante (a, b, c);
         System.out.println("Discriminante="+resp[0]);
         
        double x1 = 0,x2 = 0,x3 = 0;

        if (resp[0] < 0) {
        
            double tetha, relleno, gradis, angulo2, angulo3;
            relleno = resp[2] / Math.sqrt(-Math.pow(resp[1], 3));
            tetha = Math.acos((relleno));
            gradis = Math.toDegrees(tetha);

            x1 = 2 * (Math.sqrt(-resp[1]) * Math.cos(tetha / 3)) - (a / 3);
            System.out.println("x1=" + x1);
            angulo2 = (gradis / 3) + 120;
            x2 = 2 * (Math.sqrt(-resp[1]) * Math.cos(Math.toRadians(angulo2))) - (a / 3);
            System.out.println("x2 = " + x2);
            angulo3 = (gradis / 3) + 240;
            x3 = 2 * (Math.sqrt(-resp[1]) * Math.cos(Math.toRadians(angulo3))) - (a / 3);
            System.out.println("x2 = " + x3);
//para valores que no son cero exacto!!
        } else if (resp[0] == 0 || resp[0]<0.000001) {
           
            resp[2] = (-9 * a * b + 27 * c + 2 * Math.pow(a, 3)) / 54;
            double p, q;
            p = 3 * resp[1];

            q = 2 * resp[2];

            System.out.println("p= " + p + " q= " + q);
            System.out.println("a= " + a);
            double num = 3 * q;
            double den = 2 * p;

            x1 = -(num / den) - (a / 3);
            x2 = x1;
            double numerador = 4 * (Math.pow(p, 2));
            double denominador = 9 * q;
            x3 = -(numerador / denominador) - (a / 3);

        } else if (resp[0] > 0) {
            resp[2] = (-9 * a * b + 27 * c + 2 * Math.pow(a, 3)) / 54;
            double p = 0, q = 0, raizCubo = 1 / 3, relleno, rellenuto, imaginaria, real;

            relleno = -resp[2] + Math.sqrt(resp[0]);
            rellenuto = -resp[2] - Math.sqrt(resp[0]);

            if (relleno == 0) {
                p = 0;
            } else {
                if (relleno > 0) {
                 
                    p = Math.pow(rellenuto, raizCubo);
                    
                } else if (rellenuto < 0) {
                    
                    p = -Math.pow(rellenuto, raizCubo);
                }
            }

            if (rellenuto == 0) {
                q = 0;
            } else {

                if (rellenuto > 0) {
                    
                    q = Math.pow(rellenuto, raizCubo);
                    
                } else if (rellenuto < 0) {
                    
                    q = -Math.pow(rellenuto, raizCubo);
                }

            }
            System.out.println("P= "+p+"\nQ="+q);
            imaginaria = (p - q) * (Math.sqrt(3) / 2);
            x1 = p + q - (a / 3);
            real = -((p + q) / 2) - (a / 3);
            x2 = real;
            x3 =x2;
            
            //falta imaginaria
            
        }
         for (int i = 0; i <resp.length; i++) {
              System.out.println(""+resp[i]);
         }
        
      double valores[] = {x1, x2, x3};
        return valores;
     
     }
     

     public static double [] ferrari(double a,double b,double c, double d){
      
      double x1,x2,x3,x4,p,q,r;
        p=(8 * b - 3 * Math.pow(a,2))/8;
        q=(8 * c - 4 * a * b + Math.pow(a,3))/8;
        r=(256 * d - 64 * a * c + 16 * Math.pow(a,2) * b - 3 * Math.pow(a,4))/256;
        
        System.out.println("p="+p+"\nq="+q+"\nr="+r);
        
        double uCuadrado= -(p/2);
        double u= -r;
        double uCero= (4 * p * r - Math.pow(q,2))/8;

        double raices [] = Proceso.tartaglia(uCuadrado, u, uCero);
        System.out.println("u²= "+uCuadrado+"\nu= "+u+"c= "+uCero);
        double v,w;
        v=Math.sqrt(2 * raices[0]- p);
        w=Math.sqrt( Math.pow(raices[0],2) -r);
        System.out.println("v= "+v+"\nW= "+w+"\nU= "+raices[0]+", "+raices[1]+", "+raices[2] );
double discriminantee= Math.pow(v,2)- 4 * (raices[0]-w);
        x1= (v + Math.sqrt(discriminantee))/2 - (a/4);
        x2 =(v - Math.sqrt(discriminantee))/2 - (a/4);
        x3= (-v + Math.sqrt(discriminantee))/2 - (a/4);
        x4=(-v - Math.sqrt(discriminantee))/2 - (a/4);
        
        System.out.println("x1="+x1);
        System.out.println("x2="+x2);
       System.out.println("x3="+x3);
        System.out.println("x4="+x4);
         
     double valores []={x1,x2,x3,x4};
     return valores;
     }
    
}

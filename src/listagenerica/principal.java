
package listagenerica;

import java.util.Scanner;

public class principal {

    
    public static void main(String[] args) {
        
        
       
        lista lg=new lista();
        lg.ingresarPrimero (10);
        lg.ingresarPrimero(45);
        lg.ingresarPrimero(23);
        lg.ingresarPrimero(89);
        lg.imprimir();
        System.out.println("Insertamos un nodo al final:");
        lg.ingresarUltimo(160);
        lg.imprimir();
        System.out.println("Insertamos un nodo en la segunda posición:");
        lg.ingresarSegundo(13);
        lg.imprimir();
        System.out.println("Insertamos un nodo en la anteultima posición:");
        lg.ingresarAnteUltimo(600);
        lg.imprimir();
        System.out.println("Borramos el primer nodo de la lista:");
        lg.eliminarPrimero();
        lg.imprimir();        
        System.out.println("Borramos el segundo nodo de la lista:");
        lg.eliminarSegundo();
        lg.imprimir();
        System.out.println("Borramos el ultimo nodo de la lista:");
        lg.eliminarUltimo();
        lg.imprimir(); 
        System.out.println("Borramos el mayor de la lista:");
        lg.borrarMayor();
        lg.imprimir(); 
        
        System.out.println ("Luego de Extraer el segundo");
        lg.extraer (2);
        lg.imprimir ();
        System.out.println ("Luego de Intercambiar el primero con el tercero");
        lg.intercambiar (1, 3);
        lg.imprimir ();
        if (lg.existe(10)) 
            System.out.println("Se encuentra el 20 en la lista");
        else
            System.out.println("No se encuentra el 20 en la lista");
        System.out.println("La posición del mayor es:"+lg.posMayor());
        if (lg.ordenada())
            System.out.println("La lista está ordenada de menor a mayor");
        else
            System.out.println("La lista no está ordenada de menor a mayor");
       
        lg.imprimir();
                            
    }
}

        
        
 

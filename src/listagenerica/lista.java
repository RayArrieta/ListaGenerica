
package listagenerica;


public class lista {
    
    
    nodo primero;
    
    nodo ultimo;
    
    private nodo puntero; //Este es el nodo puntero raiz que contiene la direccion del nodo en si
    
    public lista () {
        puntero=null;
    }
      
    

    
    void ingresarPrimero(int x)
    {
        nodo nuevo = new nodo ();
        nuevo.dato = x;
        nuevo.sig=puntero;
        if (puntero!=null)
            puntero.ant=nuevo;
        puntero=nuevo;
    }

    public void ingresarUltimo(int x) {
        nodo nuevo = new nodo ();
        nuevo.dato = x;
        if (puntero==null)
            puntero=nuevo;
        else {
            nodo reco=puntero;
            while (reco.sig!=null) {
                reco=reco.sig;
            }
            reco.sig=nuevo;
            nuevo.ant=reco;
        }
    }
    
    public void ingresarSegundo(int x) {
        if (puntero!=null) {
            nodo nuevo = new nodo ();
            nuevo.dato = x;
            if (puntero.sig==null) {
                //Hay un solo nodo.
                puntero.sig=nuevo;
                nuevo.ant=puntero;
            } else {
                nodo tercero=puntero.sig;
                nuevo.sig=tercero;
                tercero.ant=nuevo;
                puntero.sig=nuevo;
                nuevo.ant=puntero;
            }
        }
    }
    
    public void ingresarAnteUltimo(int x) {
        if (puntero!=null) {
            nodo nuevo = new nodo ();
            nuevo.dato = x;
            if (puntero.sig==null) {
                //Hay un solo nodo.
                nuevo.sig=puntero;
                puntero=nuevo;
            } else {
                nodo reco=puntero;
                while (reco.sig!=null) {
                    reco=reco.sig;
                }
                nodo anterior=reco.ant;
                nuevo.sig=reco;
                nuevo.ant=anterior;
                anterior.sig=nuevo;
                reco.ant=nuevo;
            }
        }
    }
    
    
    public int extraer (int pos) {
        if (pos <= cantidad ())    {
            int informacion;
            if (pos == 1) {
                informacion = puntero.dato;
                puntero = puntero.sig;
                if (puntero!=null)
                    puntero.ant=null;
            } else {
                nodo reco;
                reco = puntero;
                for (int f = 1 ; f <= pos - 2 ; f++)
                    reco = reco.sig;
                nodo prox = reco.sig;
                reco.sig = prox.sig;
                nodo siguiente=prox.sig;
                if (siguiente!=null)
                    siguiente.ant=reco;
                informacion = prox.dato;
            }
            return informacion;
        }
        else
            return Integer.MAX_VALUE;
    }

    public void eliminarPrimero() {
        if (puntero!=null) {
            puntero=puntero.sig;
            if (puntero!=null) {
                puntero.ant=null;
            }
        }
    }
    
    public void eliminarSegundo() {
        if (puntero!=null) {
            if (puntero.sig!=null) {
                nodo tercero=puntero.sig;
                tercero=tercero.sig;
                puntero.sig=tercero;
                if (tercero!=null)
                    tercero.ant=puntero;
            }
        }
    }
    
    public void eliminarUltimo () {
        if (puntero!=null) {
            if (puntero.sig==null) {
                puntero=null;
            } else {
                nodo reco=puntero;
                while(reco.sig!=null) {
                    reco=reco.sig;
                }
                reco=reco.ant;
                reco.sig=null;
            }
        }
        
    }
    
    public void intercambiar (int pos1, int pos2) {
        if (pos1 <= cantidad () && pos2 <= cantidad ())    {
            nodo reco1 = puntero;
            for (int f = 1 ; f < pos1 ; f++)
                reco1 = reco1.sig;
            nodo reco2 = puntero;
            for (int f = 1 ; f < pos2 ; f++)
                reco2 = reco2.sig;
            int aux = reco1.dato;
            reco1.dato = reco2.dato;
            reco2.dato = aux;
        }
    }
    
    public int mayor () {
        if (!vacia ()) {
            int may = puntero.dato;
            nodo reco = puntero.sig;
            while (reco != null) {
                if (reco.dato > may)
                    may = reco.dato;
                reco = reco.sig;
            }
            return may;
        }
        else
            return Integer.MAX_VALUE;
    }
    
    
     public void borrarMayor() {
        if (puntero!=null) {
            nodo reco=puntero;
            int may=puntero.dato;
            while (reco!=null) {
                if (reco.dato>may) {
                    may=reco.dato;
                }
                reco=reco.sig;
            }
            reco=puntero;
            while (reco!=null) {
                if (reco.dato==may) {
                    if (reco==puntero) {
                        puntero=puntero.sig;
                        if (puntero!=null)
                            puntero.ant=null;
                        reco=puntero;
                    } else {
                        nodo atras=reco.ant;
                        atras.sig=reco.sig;
                        reco=reco.sig;
                        if (reco!=null)
                            reco.ant=atras;
                    }
                } else {
                    reco=reco.sig;
                }
            }
            
        }
    
     }
     
     
     
    public int posMayor() {
        if (!vacia ())    {
            int may = puntero.dato;
            int x=1;
            int pos=x;
            nodo reco = puntero.sig;
            while (reco != null){
                if (reco.dato > may) {
                    may = reco.dato;
                    pos=x;
                }
                reco = reco.sig;
                x++;
            }
            return pos;
        }
        else
            return Integer.MAX_VALUE;
    }

    
    public  void buscarNodo ( int dato ){
    
    nodo actual = new nodo();
    actual = primero;
    
    while (actual!=null){
           
    if (actual.dato==dato){
        System.out.println(" Nodo encontrado: Si existe en la lista");  
            }
      actual = actual.sig;
      }
        
    }
    
    
    
    public int cantidad ()
    {
        int cant = 0;
        nodo reco = puntero;
        while (reco != null) {
            reco = reco.sig;
            cant++;
        }
        return cant;
    }
    
    public boolean ordenada() {
        if (cantidad()>1) {
            nodo reco1=puntero;
            nodo reco2=puntero.sig;
            while (reco2!=null) {
                if (reco2.dato<reco1.dato) {
                    return false;
                }
                reco2=reco2.sig;
                reco1=reco1.sig;
            }
        }
        return true;
    }
    
    public boolean existe(int x) {
        nodo reco=puntero;
        while (reco!=null) {
            if (reco.dato==x)
                return true;
            reco=reco.sig;
        }
        return false;
    }
    
    public boolean vacia ()
    {
        if (puntero == null)
            return true;
        else
            return false;
    }
    
    public void imprimir ()
    {
        nodo reco = puntero;
        while (reco != null) {
            System.out.print (reco.dato + "-");
            reco = reco.sig;
        }
        System.out.println();
    }
        

    
    
}

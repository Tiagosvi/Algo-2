package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero;
    private Nodo ultimo;

    private class Nodo {
        T valor;
        Nodo ant;
        Nodo sig;
        Nodo(T v) { valor = v; }
        }

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
    }

    public int longitud() {
        int contador = 0;
        Nodo actual = primero;
        while (actual != null) {
            contador = contador + 1;
            actual = actual.sig;
        }
        return contador;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (this.longitud() == 0){
            primero = nuevo;
            ultimo = nuevo;

        }
        else{
            primero.ant = nuevo;
            nuevo.sig = primero;
            primero = nuevo;
        }
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (this.longitud() == 0){
            primero = nuevo;
            ultimo = nuevo;

        } /**2 3 5 8  */
        else{
            ultimo.sig = nuevo;
            nuevo.ant = ultimo;
            ultimo = nuevo;
        }
    }
    
    public T obtener(int i) { /** ver a futuro si se rompe con lista vacia  */
        int contador = 0;
        Nodo actual = primero;
        while (actual != null & contador != i ) {
            contador = contador + 1;
            actual = actual.sig;
        }
        return actual.valor;


    }

    public void eliminar(int i) {
        Nodo actual = primero;
        Nodo anterior = primero;
        for (int j = 0; j < i; j++) {
            anterior = actual;
            actual = actual.sig;
            }
        if (i == 0) {
            primero = actual.sig;
        }
        else {
            anterior.sig = actual.sig;
            }
    }



    public void modificarPosicion(int indice, T elem) {
        Nodo actual = primero;
        int contador = 0;
        while (actual!=null & contador != indice){
            contador += 1;
            actual = actual.sig;
            }
        actual.valor = elem;
        }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        for( int i=0;i<lista.longitud();i++){
            agregarAtras(lista.obtener(i));
        }

    }
    
    @Override
    public String toString() {
        Nodo actual = primero;
        String arranco = "[";
        String fin = "]";
        while(actual!=null){
            if (actual == ultimo){
                arranco = arranco + (actual.valor).toString();
            }
            else{// arranco.concat(actual.valor.toString()).concat(",");
            arranco = arranco + (actual.valor).toString() + ", ";
            }
            actual = actual.sig;
        }
        arranco = arranco + fin;
        return arranco;
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}

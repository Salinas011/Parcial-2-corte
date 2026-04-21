package model;

public class ArbolBST {

    private Nodo raiz;

    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo actual, int valor) {

        if (actual == null)
            return new Nodo(valor);

        if (valor < actual.valor) {
            actual.izquierdo = insertarRec(actual.izquierdo, valor);
        } else {
            actual.derecho = insertarRec(actual.derecho, valor);
        }

        return actual;
    }

    public void inOrden() {
        inOrden(raiz);
        System.out.println();
    }

    private void inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inOrden(nodo.derecho);
        }

    }

    public int contarHojas() {
        return contarHojasRec(raiz);
    }

    private int contarHojasRec(Nodo nodo) {
        if (nodo == null)
            return 0;

        if (nodo.izquierdo == null && nodo.derecho == null) {
            return 1;
        }
        return contarHojasRec(nodo.izquierdo) +
                contarHojasRec(nodo.derecho);

    }

    public void eliminar(int valor) {
        raiz = eliminarRec(raiz, valor);
    }

    private Nodo eliminarRec(Nodo actual, int valor) {
        if (actual == null)
            return null;

        if (valor < actual.valor) {
            actual.izquierdo = eliminarRec(actual.izquierdo, valor);
        } else if (valor > actual.valor) {
            actual.derecho = eliminarRec(actual.derecho, valor);
        } else {
            // Caso 1 sin hijos
            if (actual.izquierdo == null && actual.derecho == null) {
                return null;
            }

            // Caso 2 con un hijo
            if (actual.izquierdo == null) {
                return actual.derecho;
            }
            if (actual.derecho == null) {
                return actual.izquierdo;
            }

            // Caso 3 cn 2 hijos
            int menor = encontrarMin(actual.derecho);
            actual.valor = menor;
            actual.derecho = eliminarRec(actual.derecho, menor);
        }
        return actual;
    }

    private int encontrarMin(Nodo nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo.valor;
    }

}

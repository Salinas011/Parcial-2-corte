package main;

import model.ArbolBST;

public class Main {
    public static void main(String[] args) {

        ArbolBST arbol = new ArbolBST();

        int[] valores = {
                55, 25, 75, 15, 35, 65, 85,
                25, 75, 15, 35, 65
        };

        System.out.println("Insertando los valores");
        for (int v : valores) {
            arbol.insertar(v);
        }

        // InOrden inicial
        System.out.println("\nRecorrido InOrden:");
        arbol.inOrden();

        // Contar hojas
        System.out.println("Cantidad de hojas: " + arbol.contarHojas());

        // Insertar 30
        System.out.println("\nInsertando el valor 30");
        arbol.insertar(30);

        System.out.println("InOrden actualizado:");
        arbol.inOrden();

        // Eliminar 65
        System.out.println("\nEliminando el valor 65");
        arbol.eliminar(65);

        System.out.println("InOrden después de eliminar:");
        arbol.inOrden();
    }
}
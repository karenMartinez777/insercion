/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.algotitmo_insercion;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author KAREN
 */
public class Algotitmo_Insercion {

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        Stack<String> libros = new Stack<>();

        System.out.print("Ingrese el número de libros que desea ordenar: ");
        int numLibros = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de nextInt()

        System.out.println("Ingrese los títulos de los libros:");

        for (int i = 0; i < numLibros; i++) {
            System.out.print("Libro " + (i + 1) + ": ");
            String tituloLibro = scanner.nextLine();
            libros.push(tituloLibro);
        }

        // Imprimimos la pila de libros antes de ordenar
        System.out.println("\nLibros antes de ordenar:");
        imprimirPila(libros);

        // Ordenamos la pila de libros alfabéticamente de la A a la Z
        ordenamientoPorInsercion(libros);

        // Imprimimos la pila de libros después de ordenar
        System.out.println("\nLibros después de ordenar:");
        imprimirPila(libros);

        scanner.close();
    }

    public static void ordenamientoPorInsercion(Stack<String> stack) {
        Stack<String> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            String temp = stack.pop();

            while (!tempStack.isEmpty() && temp.compareTo(tempStack.peek()) > 0) {
                stack.push(tempStack.pop());
            }

            tempStack.push(temp);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void imprimirPila(Stack<String> stack) {
        for (String libro : stack) {
            System.out.println(libro);
        }
    }
}

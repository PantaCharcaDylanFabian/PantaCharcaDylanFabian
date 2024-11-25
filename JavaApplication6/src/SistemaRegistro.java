/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dylan
 */
import java.util.Scanner;

public class SistemaRegistro {
    private static GestionLenguaje gestionLenguaje = new GestionLenguaje();

    public static void main(String[] args) {
        iniciarMenu();
    }

    public static void iniciarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menu de Registro de Lenguajes ---");
            System.out.println("1. Agregar Lenguaje");
            System.out.println("2. Buscar Lenguaje");
            System.out.println("3. Eliminar Lenguaje");
            System.out.println("4. Listar Lenguajes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> agregarLenguaje(scanner);
                case 2 -> buscarLenguaje(scanner);
                case 3 -> eliminarLenguaje(scanner);
                case 4 -> gestionLenguaje.imprimirLenguajes();
                case 5 -> {
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                }
                default -> System.out.println("Opcion inválida. Intentar de nuevo.");
            }
        }
        scanner.close();
    }

    private static void agregarLenguaje(Scanner scanner) {
        System.out.println("\n--- Agregar Lenguaje ---");
        System.out.print("Año de Creación: ");
        int anio = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Característica Principal: ");
        String caracteristica = scanner.nextLine();

        System.out.print("Nombre del Lenguaje: ");
        String nombre = scanner.nextLine();

        System.out.print("Utilizacion: ");
        String utilizacion = scanner.nextLine();

        gestionLenguaje.agregarLenguaje(anio, caracteristica, nombre, utilizacion);
    }

    private static void buscarLenguaje(Scanner scanner) {
        System.out.println("\n--- Buscar Lenguaje ---");
        System.out.print("Nombre del Lenguaje: ");
        String nombre = scanner.nextLine();

        LenguajeProgramacion lenguaje = gestionLenguaje.buscarLenguaje(nombre);

        if (lenguaje != null) {
            System.out.println("Lenguaje encontrado: " + lenguaje);
        } else {
            System.out.println("El lenguaje no se encuentra registrado.");
        }
    }

    private static void eliminarLenguaje(Scanner scanner) {
        System.out.println("\n--- Eliminar Lenguaje ---");
        System.out.print("Nombre del Lenguaje: ");
        String nombre = scanner.nextLine();

        if (gestionLenguaje.eliminarLenguaje(nombre)) {
            System.out.println("Lenguaje eliminado correctamente.");
        } else {
            System.out.println("El lenguaje no fue encontrado.");
        }
    }
}

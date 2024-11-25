/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dylan
 */
public class GestionLenguaje {
    private LenguajeProgramacion[] lenguajes;
    private int contadorLenguajes;
    private final int FACTOR_CRECIENTO = 2;

    // el constructor
    public GestionLenguaje() {
        this.lenguajes = new LenguajeProgramacion[FACTOR_CRECIENTO];
        this.contadorLenguajes = 0;
    }

    // el metodo para agregar un nuevo lenguaje
    public void agregarLenguaje(int anioCreacion, String caracteristicaPrincipal, String nombre, String utilizacion) {
        if (contadorLenguajes == lenguajes.length) {
            expandirArreglo();
        }
        lenguajes[contadorLenguajes++] = new LenguajeProgramacion(anioCreacion, caracteristicaPrincipal, nombre, utilizacion);
        System.out.println("Lenguaje agregado correctamente.");
    }

    // el metodo para buscar un lenguaje por su nombre
    public LenguajeProgramacion buscarLenguaje(String nombre) {
        for (int i = 0; i < contadorLenguajes; i++) {
            if (lenguajes[i].getNombre().equalsIgnoreCase(nombre)) {
                return lenguajes[i];
            }
        }
        return null;
    }

    // el mtodo para quitar un lenguaje por su nombre
    public boolean eliminarLenguaje(String nombre) {
        for (int i = 0; i < contadorLenguajes; i++) {
            if (lenguajes[i].getNombre().equalsIgnoreCase(nombre)) {
                // Desplazar elementos hacia la izquierda
                for (int j = i; j < contadorLenguajes - 1; j++) {
                    lenguajes[j] = lenguajes[j + 1];
                }
                lenguajes[--contadorLenguajes] = null; // Reducir tamaño y limpiar referencia
                return true;
            }
        }
        return false;
    }

    // el metodo para imprimir todos los lenguajes
    public void imprimirLenguajes() {
        if (contadorLenguajes == 0) {
            System.out.println("No hay lenguajes registrados.");
        } else {
            System.out.println("\nLista de Lenguajes:");
            for (int i = 0; i < contadorLenguajes; i++) {
                System.out.println(lenguajes[i]);
            }
        }
    }

    // el metodo privado para expandir el arreglo
    private void expandirArreglo() {
        LenguajeProgramacion[] nuevoArreglo = new LenguajeProgramacion[lenguajes.length + FACTOR_CRECIENTO];
        System.arraycopy(lenguajes, 0, nuevoArreglo, 0, lenguajes.length);
        lenguajes = nuevoArreglo;
    }
}

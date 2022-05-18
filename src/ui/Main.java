package ui;

import tl.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Controller gestor = new Controller();
    public static void main(String[] args) throws IOException {
        menu();
    }

    /**
     * Método:      menu
     * Descripción  Método que se permite desplegar un menú con las opciones de generar el password
     * @throws IOException  Excepcion
     */
    public static void menu() throws IOException {
        boolean salir;
        String menu = "GENERAR PASSWORD\n" +
                "1. Longitud default (8)\n" +
                "2. Definir la longitud\n" +
                "3. Salir\n" +
                "Elija una opción\n\n";
        do {
            int opcion = ingresar_int(menu);
            salir = procesar_menu(opcion);
        } while (!salir);
    }
    /**
     * Método           procesar_menu
     * Descripción      Método que permite ejecutar las opciones elegida del menú
     * @param opcion    Variable de tipo int escogida por el usuario
     * @return          Variable de tipo boolean que retorna false si continúa en el menú o true si finaliza
     * @throws IOException  Excepción
     */
    private static boolean procesar_menu(int opcion) throws IOException {
        boolean salir = false;
        switch (opcion) {
            case 1:
                generarPasswordDefault();
                break;
            case 2:
                generarPassword();
                break;
            case 3:
                out.println("Usted ha elegido salir\n");
                salir = true;
                break;
            default:
                out.println("Opción inválida\nDebe ingresar un número de los indicados en el menú\n");
                break;
        }
        return salir;
    }
    /**
     * Método:      generarPassword
     * Descripción  Método que permite solicitar un password con tamaño default.
     */
    private static void generarPasswordDefault(){
        String [] password;
        password = gestor.generarPassword();
        printArray(password);
    }

    /**
     * Método:      generarPassword
     * Descripción  Método que permite solicitar un password con el tamaño definido por el usuario.
     * @throws IOException Excepción
     */
    private static void generarPassword() throws IOException {
        int largo;
        boolean salir = false;
        do {
            largo = ingresar_int("Ingrese la longitud del password");
            if (validarValorPiso(largo) &&
                    validarValorTecho(largo)) {
                salir = true;
            } else {
                out.println("La longitud debe ubicarse entre 8 y 30 caractéres, ambos inclusive.");
            }
        } while (!salir);
        String [] password = gestor.generarPassword(largo);
        printArray(password);
    }

    /**
     * Método:      printArray
     * Descripción  Método que recibe un arreglo de números y los imprime
     * @param array Arreglo de números
     */
    private static void printArray(String [] array) {
        StringBuilder txt = new StringBuilder("| ");
        for (String s : array) {
            txt.append(s).append(" | ");
        }
        out.println("Password: " + array[0]);
        out.println("El password generado es: " + array[1] + "\n\n");
    }
    /**
     * Método:      ingresar_int
     * Descripción  Método que permite el ingreso de valores de tipo int
     * @param msg   Variable de tipo String que contiene el mensaje enviado al usuario
     * @return      Variable de tipo int que representa el número que se ingresó por teclado
     * @throws IOException Excepción
     */
    private static int ingresar_int(String msg) throws IOException {
        String respuesta = "La número ingresado no es válida, debe intentarlo nuevamente.\n";
        String valor;
        int num = 0;
        boolean salir = false, validacion;
        do {
            out.println(msg);
            valor = in.readLine();
            validacion = esIntValido(valor);
            if (validacion) {
                num = Integer.parseInt(valor);
                salir = true;
            } else {
                out.print(respuesta);
            }
        } while (!salir);
        return num;
    }

    /**
     * Método:      esIntValido
     * Descripción  Método que permite validar si el valor ingresado en un número
     * @param valor Variable de tipo boolean que representa si el valor es un int (true) o no (false)
     * @return      Excepción
     */
    private static boolean esIntValido(String valor) {
        boolean respuesta;
        try {
            Integer.parseInt(valor);
            respuesta = true;
        } catch (NumberFormatException e) {
            respuesta = false;
        }
        return respuesta;
    }

    /**
     * Método:      validarValorTecho
     * Descripción  Método que permite validar si el valor ingresado se ubica como máximo en el valor
     *              techo.
     * @param num   Variable de tipo int que representa el número que debe ser verificado
     * @return      Variable de tipo boolean que representa si el valor se ubica como máximo en el
     *              valor seńalado como techo (true) o es superior (false)
     */
    private static boolean validarValorTecho(int num) {
//        if (num > techo) {
//            return false;
//        }
//        return true;
        int techo = 30;
        return num <= techo;
    }
    /**
     * Método:      validarValorPiso
     * Descripción  Método que permite validar si el valor ingresado se ubica como mínimo en el valor
     *              piso.
     * @param num   Variable de tipo int que representa el número que debe ser verificado
     * @return      Variable de tipo boolean que representa si el valor se ubica como mínimo en el
     *              valor seńalado como piso (true) o es inferior a este (false)
     */
    private static boolean validarValorPiso(int num) {
        int piso = 8;
        return num >= piso;
    }
}

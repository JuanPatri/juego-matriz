package obligatorio1p2;

//Theo Brum N 315141 | Juan Pablo Patri N 266824

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import static obligatorio1p2.Juego.indice;
import static obligatorio1p2.Sistema.copiaTableroMet;
import static obligatorio1p2.Sistema.historialMet;
import static obligatorio1p2.Sistema.movimientosMet;
import static obligatorio1p2.Sistema.solucionMet;

public class Interfaz {

    public static void inicioMet(ArrayList<String[][]> tablerosGuardados) throws FileNotFoundException {

        Scanner entrada = new Scanner(System.in);
        System.out.println("¿Desea jugar o salir?(SI-NO)");
        String jugar = entrada.nextLine().toUpperCase();
        int filas = 0;
        int cols = 0;
        int lvls = 0;

        while (!jugar.equals("SI") && !jugar.equals("NO")) {
            System.out.println("Respuesta invalida, vuelva a ingresarla");
            jugar = entrada.nextLine().toUpperCase();
        }

        if (jugar.equals("NO")) {
            System.exit(0);
        }

        while (jugar.equals("SI")) {
            Sistema.tiempoInicioMet();
            Juego.historial.clear();
            Juego.movSolucion.clear();
            Juego.contador = 0;
            Juego.indice = 0;
            Juego.indice1 = 1;
            Juego.tablerosGuardados.clear();
            System.out.println("""
            a) Tomar datos del archivo “datos.txt”
            b) Usar el tablero predefinido
            c) Usar un tablero al azar.
        """);
            String abc = entrada.nextLine().toUpperCase();
            while (!abc.equals("A") && !abc.equals("B") && !abc.equals("C")) {
                System.out.println("Respuesta invalida, vuelva a ingresarla");
                abc = entrada.nextLine().toUpperCase();
            }
            if (abc.equals("A")) {
                Sistema.leerArchivoTxtMet(".\\Test\\datos.txt");
                tiempoFinalMet(Juego.comienzo);
                entrada.nextLine();
            }
            if (abc.equals("B")) {
                Sistema.tabPredMet(lvls);
                tiempoFinalMet(Juego.comienzo);
                entrada.nextLine();
            }
            if (abc.equals("C")) {
                System.out.println("Ingrese cantidad de filas (entre 3 y 9) ");
                boolean filBien = true;

                while (filBien) {
                    if (entrada.hasNextInt()) {
                        filas = entrada.nextInt();

                        if (filas >= 3 && filas <= 9) {
                            filBien = false;
                        } else {
                            System.out.println("Respuesta invalida, vuelva a ingresarla");
                            entrada.nextLine();
                        }
                    } else {
                        System.out.println("Respuesta invalida, vuelva a ingresarla");
                        entrada.nextLine();
                    }
                }

                System.out.println("Ingrese cantidad de columnas (entre 3 y 9) ");
                boolean colBien = true;

                while (colBien) {
                    if (entrada.hasNextInt()) {
                        cols = entrada.nextInt();

                        if (cols >= 3 && cols <= 9) {
                            colBien = false;
                        } else {
                            System.out.println("Respuesta invalida, vuelva a ingresarla");
                            entrada.nextLine();
                        }
                    } else {
                        System.out.println("Respuesta invalida, vuelva a ingresarla");
                        entrada.nextLine();
                    }
                }

                System.out.println("Ingrese nivel de dificultad (entre 1 y 8) ");
                boolean lvlBien = true;

                while (lvlBien) {
                    if (entrada.hasNextInt()) {
                        lvls = entrada.nextInt();

                        if (lvls >= 1 && lvls <= 8) {
                            lvlBien = false;
                        } else {
                            System.out.println("Respuesta invalida, vuelva a ingresarla");
                            entrada.nextLine();
                        }
                    } else {
                        System.out.println("Respuesta invalida, vuelva a ingresarla");
                        entrada.nextLine();
                    }
                }
                Sistema.genTabLvlMet(filas, cols, lvls, tablerosGuardados);
                tiempoFinalMet(Juego.comienzo);
                entrada.nextLine();
            }
            System.out.println("¿Desea volver a jugar?(SI-NO)");
            jugar = entrada.nextLine().toUpperCase();

            while (!jugar.equals("SI") && !jugar.equals("NO")) {
                System.out.println("Respuesta invalida, vuelva a ingresarla");
                jugar = entrada.nextLine().toUpperCase();
            }
        }
    }

    public static void menuMovimientosMet(int filas, int cols, int lvls, String[][] tabRandomLvl, ArrayList<String[][]> tablerosGuardados) throws FileNotFoundException {
        String meA = "\u001B[34m" + " - " + "\u001B[0m" + "|";
        String vA = "\u001B[34m" + " | " + "\u001B[0m" + "|";
        String bdA = "\u001B[34m" + " / " + "\u001B[0m" + "|";
        String biA = "\u001B[34m" + " \\ " + "\u001B[0m" + "|";

        Scanner entrada = new Scanner(System.in);
        int movFilas = 0;
        int movCols = 0;
        String movFilasXHS;
        String movColsXHS;
        boolean filBien = true;
        boolean colBien = true;

        System.out.println("Indique la fila en la que desea hacer el movimiento");

        while (filBien) {
            if (entrada.hasNextInt()) {
                movFilas = entrada.nextInt();

                if ((movFilas >= 1 && movFilas <= filas) || movFilas == -1) {
                    filBien = false;
                } else {
                    System.out.println("Respuesta invalida, vuelva a ingresarla");
                    entrada.nextLine();
                }
            } else {
                if (entrada.hasNext()) {
                    movFilasXHS = entrada.next().toUpperCase();

                    if (movFilasXHS.equals("X")) {
                        tiempoFinalMet(Juego.comienzo);
                        inicioMet(tablerosGuardados);
                        return;
                    } else if (movFilasXHS.equals("H")) {
                        filBien = false;
                        toStringHistorialMet(Juego.historial);
                        menuMovimientosMet(filas, cols, lvls, tabRandomLvl, tablerosGuardados);
                    } else if (movFilasXHS.equals("S")) {
                        filBien = false;
                        toStringSolucionMet(Juego.movSolucion);
                        menuMovimientosMet(filas, cols, lvls, tabRandomLvl, tablerosGuardados);
                    }
                } else {
                    System.out.println("Respuesta invalida, vuelva a ingresarla");
                    entrada.nextLine();
                }
            }
        }

        System.out.println("Indique la columna en la que desea hacer el movimiento");

        while (colBien) {
            if (entrada.hasNextInt()) {
                movCols = entrada.nextInt();

                if (movFilas == -1 && movCols == -1) {
                    colBien = false;
                } else if (movFilas == -1 && movCols != -1) {
                    System.out.println("Respuesta invalida, vuelva a ingresarla");
                    entrada.nextLine();
                } else if (movCols >= 1 && movCols <= cols) {
                    colBien = false;
                } else {
                    System.out.println("Respuesta invalida, vuelva a ingresarla");
                    entrada.nextLine();
                }
            } else {
                if (entrada.hasNext()) {
                    movColsXHS = entrada.next().toUpperCase();
                    if (movColsXHS.equals("X")) {
                        tiempoFinalMet(Juego.comienzo);
                        inicioMet(tablerosGuardados);
                        return;
                    } else if (movColsXHS.equals("H")) {
                        colBien = false;
                        toStringHistorialMet(Juego.historial);
                        menuMovimientosMet(filas, cols, lvls, tabRandomLvl, tablerosGuardados);
                        toStringHistorialMet(Juego.historial);
                    } else if (movColsXHS.equals("S")) {
                        colBien = false;
                        toStringSolucionMet(Juego.movSolucion);
                        menuMovimientosMet(filas, cols, lvls, tabRandomLvl, tablerosGuardados);
                    }
                } else {
                    System.out.println("Respuesta invalida, vuelva a ingresarla");
                    entrada.nextLine();
                }
            }
        }
        Juego.indice++;
        if (movFilas == -1 && movCols == -1) {
            solucionMet(movFilas, movCols, lvls);
            imprimirMenosMet(tabRandomLvl, tablerosGuardados);
            menuMovimientosMet(filas, cols, lvls, tabRandomLvl, tablerosGuardados);
        } else {
            solucionMet(movFilas, movCols, lvls);
            historialMet(movFilas, movCols);
            movimientosMet(movFilas, movCols, tabRandomLvl);
            copiaTableroMet(tabRandomLvl);
            int cantidad = filas * cols;
            int cantAzul = 0;

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < cols; j++) {
                    String elemento = tabRandomLvl[i][j];
                    if (elemento.equals(meA) || elemento.equals(vA) || elemento.equals(bdA) || elemento.equals(biA)) {
                        cantAzul++;
                    }
                }
            }
            if ((cantAzul == cantidad) || (cantAzul == 0)) {
                System.out.println("Felicitaciones, has ganado!");
                tiempoFinalMet(Juego.comienzo);
                inicioMet(tablerosGuardados);
            } else {
                imprimir2Met(tabRandomLvl, tablerosGuardados);
                menuMovimientosMet(filas, cols, lvls, tabRandomLvl, tablerosGuardados);
            }
        }
    }

    public static void imprimirMet(String[][] tabRandomLvl) {

        int filas = tabRandomLvl.length;
        int cols = tabRandomLvl[0].length;

        String[] numFilas = new String[filas];
        String[] separador = {"  +---+", "---+", "---+", "---+", "---+", "---+", "---+", "---+", "---+"};

        for (int j = 0; j < cols; j++) {
            if (j == 0) {
                System.out.print("    " + (j + 1) + "  ");
            } else {
                System.out.print(" " + (j + 1) + "  ");
            }
        }
        System.out.println();

        for (int i = 0; i < filas; i++) {
            numFilas[i] = (i + 1) + " |";
        }

        for (int i = 0; i < filas; i++) {
            System.out.print(separador[0]);
            for (int j = 0; j < cols - 1; j++) {
                System.out.print(separador[1]);
            }
            System.out.println();

            System.out.print(numFilas[i]);

            for (int j = 0; j < cols; j++) {
                System.out.print(tabRandomLvl[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < 1; i++) {
            System.out.print(separador[0]);
            for (int j = 0; j < cols - 1; j++) {
                System.out.print(separador[1]);
            }
        }
        System.out.println();
    }

    public static void imprimirMenosMet(String[][] tabRandomLvl, ArrayList<String[][]> tablerosGuardados) {
        Juego.indice1++;
        int largoArray = tablerosGuardados.size();
        int pos = largoArray;
        if (pos - Juego.indice1 >= 2) {
            pos = largoArray - Juego.indice1;
            String[][] matrizAnterior = tablerosGuardados.get(pos);
            imprimirMet(matrizAnterior);
        } else if ((pos - Juego.indice1 < 2) && (tablerosGuardados.size() >= 2)) {
            System.out.println("No se puede acceder al primer tablero");
            String[][] matrizAnterior = tablerosGuardados.get(1);
            imprimirMet(matrizAnterior);
        } else {
            System.out.println("No existe un tablero anterior");
            String[][] matrizAnterior = tablerosGuardados.get(0);
            imprimirMet(matrizAnterior);
        }
    }

    public static void imprimir2Met(String[][] tabRandomLvl, ArrayList<String[][]> tablerosGuardados) {

        int largoA = tablerosGuardados.size();
        String[][] matrizAnterior = tablerosGuardados.get(largoA - 2);

        int colsN = matrizAnterior[0].length;
        int filas = matrizAnterior.length;
        int cols = matrizAnterior[0].length * 2;
        int indiceCols = 1;

        String[] numFilas = new String[filas];
        String[] separador = {"  +---+", "---+", "---+", "---+", "---+", "---+", "---+", "---+", "---+", "---+", "---+", "---+", "---+", "---+", "---+", "---+", "---+"};

        for (int j = 0; j < cols; j++) {
            if (j == 0) {
                System.out.print("    " + (j + 1) + "  ");
            }
            if (j > 0 && j < colsN) {
                System.out.print(" " + (j + 1) + "  ");
            }
            if (j == colsN) {
                System.out.print("           " + (indiceCols) + "  ");
                indiceCols++;
            }
            if (j > colsN) {
                System.out.print(" " + (indiceCols) + "  ");
                indiceCols++;
            }
        }
        System.out.println();

        for (int i = 0; i < filas; i++) {
            int contador = 0;
            numFilas[i] = (i + 1) + " |";
            System.out.print(separador[0]);
            for (int j = 0; j < cols; j++) {
                if (j < colsN - 1) {
                    if (j == colsN - 2) {
                        System.out.print("---+" + "  " + "==>" + "  ");
                    } else {
                        System.out.print(separador[1]);
                    }
                }
                if (j == colsN) {
                    System.out.print(separador[0]);
                }
                if (j > colsN) {
                    System.out.print(separador[1]);
                }
            }
            System.out.println();
            System.out.print(numFilas[i]);

            for (int j = 0; j < cols + 1; j++) {
                if (j < colsN) {
                    System.out.print(matrizAnterior[i][j]);
                } else if (j == colsN) {
                    System.out.print("  " + "==>" + "  " + numFilas[i]);
                } else if (j > colsN && j < cols + 1) {
                    System.out.print(tabRandomLvl[i][contador]);
                    if (contador <= tabRandomLvl[i].length) {
                        contador++;
                    }
                }
            }
            System.out.println();
        }

        for (int i = 0; i < cols; i++) {
            if (i == 0) {
                System.out.print(separador[0]);
            } else if (i > 0 && i < colsN) {
                System.out.print(separador[1]);
            } else if (i == colsN) {
                System.out.print("  " + "==>" + "    " + "+---+");
            } else {
                System.out.print(separador[1]);
            }
        }
        System.out.println();
    }

    public static void toStringSolucionMet(ArrayList<int[]> movSolucion) {
        System.out.println("Solucion de la partida:");
        for (int[] solucion : movSolucion) {
            System.out.println("(" + solucion[0] + "," + solucion[1] + ")");
        }
    }

    public static void toStringHistorialMet(ArrayList<int[]> historial) {
        System.out.println("Historial de movimientos:");
        for (int[] movimiento : historial) {
            System.out.println("(" + movimiento[0] + "," + movimiento[1] + ")");
        }
    }

    public static void tiempoFinalMet(long comienzo) {
        long tFinal = System.nanoTime();
        long tTotal = tFinal - comienzo;
        double tTotalSec = (double) tTotal / 1_000_000_000.0;
        System.out.println("Tiempo total insumido: " + tTotalSec + "segundos");
    }
}

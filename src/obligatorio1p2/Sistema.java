package obligatorio1p2;

//Theo Brum N 315141 | Juan Pablo Patri N 266824

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import static obligatorio1p2.Interfaz.imprimirMet;
import static obligatorio1p2.Interfaz.menuMovimientosMet;
import static obligatorio1p2.Juego.historial;
import static obligatorio1p2.Juego.movSolucion;
import static obligatorio1p2.Juego.tablerosGuardados;

public class Sistema {

    public static String[][] tabPredMet(int lvls) throws FileNotFoundException {
        int filas = 5;
        int cols = 6;
        lvls = 3;

        int[] mov1 = {4, 4};
        int[] mov2 = {5, 6};
        int[] mov3 = {5, 4};

        String meA = "\u001B[34m" + " - " + "\u001B[0m" + "|";
        String meR = "\u001B[31m" + " - " + "\u001B[0m" + "|";

        String vA = "\u001B[34m" + " | " + "\u001B[0m" + "|";
        String vR = "\u001B[31m" + " | " + "\u001B[0m" + "|";

        String bdA = "\u001B[34m" + " / " + "\u001B[0m" + "|";
        String bdR = "\u001B[31m" + " / " + "\u001B[0m" + "|";

        String biA = "\u001B[34m" + " \\ " + "\u001B[0m" + "|";
        String biR = "\u001B[31m" + " \\ " + "\u001B[0m" + "|";

        String[][] tabPred = {
            {vA, vA, meR, bdA, vR, meR},
            {meR, bdA, bdA, vA, meR, meR},
            {meR, meR, vA, meR, bdR, meR},
            {biR, meR, vR, biR, vA, vR},
            {biR, bdR, bdR, vA, bdA, biA}};

        imprimirMet(tabPred);
        copiaTableroMet(tabPred);
        Juego.solInicial2.add(mov1);
        Juego.solInicial2.add(mov2);
        Juego.solInicial2.add(mov3);
        Juego.solInicial.add(mov1);
        Juego.solInicial.add(mov2);
        Juego.solInicial.add(mov3);
        Juego.movSolucion.add(mov1);
        Juego.movSolucion.add(mov2);
        Juego.movSolucion.add(mov3);
        menuMovimientosMet(filas, cols, lvls, tabPred, tablerosGuardados);
        return tabPred;
    }

    public static String[][] movimientosMet(int movFilas, int movCols, String[][] tabRandomLvl) {
        String meA = "\u001B[34m" + " - " + "\u001B[0m" + "|";
        String meR = "\u001B[31m" + " - " + "\u001B[0m" + "|";

        String vA = "\u001B[34m" + " | " + "\u001B[0m" + "|";
        String vR = "\u001B[31m" + " | " + "\u001B[0m" + "|";

        String bdA = "\u001B[34m" + " / " + "\u001B[0m" + "|";
        String bdR = "\u001B[31m" + " / " + "\u001B[0m" + "|";

        String biA = "\u001B[34m" + " \\ " + "\u001B[0m" + "|";
        String biR = "\u001B[31m" + " \\ " + "\u001B[0m" + "|";

        int filas = tabRandomLvl.length;
        int cols = tabRandomLvl[0].length;

        movFilas--;
        movCols--;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                if (tabRandomLvl[movFilas][movCols].equals(bdA) || tabRandomLvl[movFilas][movCols].equals(bdR)) {
                    int res = movFilas + movCols;
                    if (res == i + j) {
                        if (tabRandomLvl[i][j].equals(meA)) {
                            tabRandomLvl[i][j] = meR;
                        } else if (tabRandomLvl[i][j].equals(meR)) {
                            tabRandomLvl[i][j] = meA;
                        } else if (tabRandomLvl[i][j].equals(vA)) {
                            tabRandomLvl[i][j] = vR;
                        } else if (tabRandomLvl[i][j].equals(vR)) {
                            tabRandomLvl[i][j] = vA;
                        } else if (tabRandomLvl[i][j].equals(bdA)) {
                            tabRandomLvl[i][j] = bdR;
                        } else if (tabRandomLvl[i][j].equals(bdR)) {
                            tabRandomLvl[i][j] = bdA;
                        } else if (tabRandomLvl[i][j].equals(biA)) {
                            tabRandomLvl[i][j] = biR;
                        } else {
                            tabRandomLvl[i][j] = biA;
                        }
                    }
                }
            }
        }
        int movFilaRes = movFilas;
        int movColsRes = movCols;

        if ((tabRandomLvl[movFilas][movCols].equals(biA) || tabRandomLvl[movFilas][movCols].equals(biR)) && movFilas < tabRandomLvl.length && movCols < tabRandomLvl[0].length) {
            movCols++;
            movFilas++;
            while (movFilas < tabRandomLvl.length && movCols < tabRandomLvl[0].length) {
                if (tabRandomLvl[movFilas][movCols].equals(meA)) {
                    tabRandomLvl[movFilas][movCols] = meR;
                } else if (tabRandomLvl[movFilas][movCols].equals(meR)) {
                    tabRandomLvl[movFilas][movCols] = meA;
                } else if (tabRandomLvl[movFilas][movCols].equals(vA)) {
                    tabRandomLvl[movFilas][movCols] = vR;
                } else if (tabRandomLvl[movFilas][movCols].equals(vR)) {
                    tabRandomLvl[movFilas][movCols] = vA;
                } else if (tabRandomLvl[movFilas][movCols].equals(bdA)) {
                    tabRandomLvl[movFilas][movCols] = bdR;
                } else if (tabRandomLvl[movFilas][movCols].equals(bdR)) {
                    tabRandomLvl[movFilas][movCols] = bdA;
                } else if (tabRandomLvl[movFilas][movCols].equals(biA)) {
                    tabRandomLvl[movFilas][movCols] = biR;
                } else {
                    tabRandomLvl[movFilas][movCols] = biA;
                }
                movCols++;
                movFilas++;
            }
        }

        movFilas = movFilaRes;
        movCols = movColsRes;

        if ((tabRandomLvl[movFilas][movCols].equals(biA) || tabRandomLvl[movFilas][movCols].equals(biR)) && movFilas < tabRandomLvl.length && movCols < tabRandomLvl[0].length) {
            while (movFilas >= 0 && movCols >= 0) {
                if (tabRandomLvl[movFilas][movCols].equals(meA)) {
                    tabRandomLvl[movFilas][movCols] = meR;
                } else if (tabRandomLvl[movFilas][movCols].equals(meR)) {
                    tabRandomLvl[movFilas][movCols] = meA;
                } else if (tabRandomLvl[movFilas][movCols].equals(vA)) {
                    tabRandomLvl[movFilas][movCols] = vR;
                } else if (tabRandomLvl[movFilas][movCols].equals(vR)) {
                    tabRandomLvl[movFilas][movCols] = vA;
                } else if (tabRandomLvl[movFilas][movCols].equals(bdA)) {
                    tabRandomLvl[movFilas][movCols] = bdR;
                } else if (tabRandomLvl[movFilas][movCols].equals(bdR)) {
                    tabRandomLvl[movFilas][movCols] = bdA;
                } else if (tabRandomLvl[movFilas][movCols].equals(biA)) {
                    tabRandomLvl[movFilas][movCols] = biR;
                } else {
                    tabRandomLvl[movFilas][movCols] = biA;
                }
                movFilas--;
                movCols--;
            }
        }

        movFilas = movFilaRes;
        movCols = movColsRes;

        if ((tabRandomLvl[movFilas][movCols].equals(vA) || tabRandomLvl[movFilas][movCols].equals(vR)) && movFilas < tabRandomLvl.length && movCols < tabRandomLvl[0].length) {
            movFilas++;
            while (movFilas < tabRandomLvl.length && movCols < tabRandomLvl[0].length) {
                if (tabRandomLvl[movFilas][movCols].equals(meA)) {
                    tabRandomLvl[movFilas][movCols] = meR;
                } else if (tabRandomLvl[movFilas][movCols].equals(meR)) {
                    tabRandomLvl[movFilas][movCols] = meA;
                } else if (tabRandomLvl[movFilas][movCols].equals(vA)) {
                    tabRandomLvl[movFilas][movCols] = vR;
                } else if (tabRandomLvl[movFilas][movCols].equals(vR)) {
                    tabRandomLvl[movFilas][movCols] = vA;
                } else if (tabRandomLvl[movFilas][movCols].equals(bdA)) {
                    tabRandomLvl[movFilas][movCols] = bdR;
                } else if (tabRandomLvl[movFilas][movCols].equals(bdR)) {
                    tabRandomLvl[movFilas][movCols] = bdA;
                } else if (tabRandomLvl[movFilas][movCols].equals(biA)) {
                    tabRandomLvl[movFilas][movCols] = biR;
                } else {
                    tabRandomLvl[movFilas][movCols] = biA;
                }
                movFilas++;
            }
        }

        movFilas = movFilaRes;
        movCols = movColsRes;

        if ((tabRandomLvl[movFilas][movCols].equals(vA) || tabRandomLvl[movFilas][movCols].equals(vR)) && movFilas < tabRandomLvl.length && movCols < tabRandomLvl[0].length) {
            while (movFilas >= 0 && movCols >= 0) {
                if (tabRandomLvl[movFilas][movCols].equals(meA)) {
                    tabRandomLvl[movFilas][movCols] = meR;
                } else if (tabRandomLvl[movFilas][movCols].equals(meR)) {
                    tabRandomLvl[movFilas][movCols] = meA;
                } else if (tabRandomLvl[movFilas][movCols].equals(vA)) {
                    tabRandomLvl[movFilas][movCols] = vR;
                } else if (tabRandomLvl[movFilas][movCols].equals(vR)) {
                    tabRandomLvl[movFilas][movCols] = vA;
                } else if (tabRandomLvl[movFilas][movCols].equals(bdA)) {
                    tabRandomLvl[movFilas][movCols] = bdR;
                } else if (tabRandomLvl[movFilas][movCols].equals(bdR)) {
                    tabRandomLvl[movFilas][movCols] = bdA;
                } else if (tabRandomLvl[movFilas][movCols].equals(biA)) {
                    tabRandomLvl[movFilas][movCols] = biR;
                } else {
                    tabRandomLvl[movFilas][movCols] = biA;
                }
                movFilas--;
            }
        }

        movFilas = movFilaRes;
        movCols = movColsRes;

        if ((tabRandomLvl[movFilas][movCols].equals(meA) || tabRandomLvl[movFilas][movCols].equals(meR)) && movFilas < tabRandomLvl.length && movCols < tabRandomLvl[0].length) {
            movCols++;
            while (movFilas < tabRandomLvl.length && movCols < tabRandomLvl[0].length) {
                if (tabRandomLvl[movFilas][movCols].equals(meA)) {
                    tabRandomLvl[movFilas][movCols] = meR;
                } else if (tabRandomLvl[movFilas][movCols].equals(meR)) {
                    tabRandomLvl[movFilas][movCols] = meA;
                } else if (tabRandomLvl[movFilas][movCols].equals(vA)) {
                    tabRandomLvl[movFilas][movCols] = vR;
                } else if (tabRandomLvl[movFilas][movCols].equals(vR)) {
                    tabRandomLvl[movFilas][movCols] = vA;
                } else if (tabRandomLvl[movFilas][movCols].equals(bdA)) {
                    tabRandomLvl[movFilas][movCols] = bdR;
                } else if (tabRandomLvl[movFilas][movCols].equals(bdR)) {
                    tabRandomLvl[movFilas][movCols] = bdA;
                } else if (tabRandomLvl[movFilas][movCols].equals(biA)) {
                    tabRandomLvl[movFilas][movCols] = biR;
                } else {
                    tabRandomLvl[movFilas][movCols] = biA;
                }
                movCols++;
            }
        }

        movFilas = movFilaRes;
        movCols = movColsRes;

        if ((tabRandomLvl[movFilas][movCols].equals(meA) || tabRandomLvl[movFilas][movCols].equals(meR)) && movFilas < tabRandomLvl.length && movCols < tabRandomLvl[0].length) {
            while (movFilas >= 0 && movCols >= 0) {
                if (tabRandomLvl[movFilas][movCols].equals(meA)) {
                    tabRandomLvl[movFilas][movCols] = meR;
                } else if (tabRandomLvl[movFilas][movCols].equals(meR)) {
                    tabRandomLvl[movFilas][movCols] = meA;
                } else if (tabRandomLvl[movFilas][movCols].equals(vA)) {
                    tabRandomLvl[movFilas][movCols] = vR;
                } else if (tabRandomLvl[movFilas][movCols].equals(vR)) {
                    tabRandomLvl[movFilas][movCols] = vA;
                } else if (tabRandomLvl[movFilas][movCols].equals(bdA)) {
                    tabRandomLvl[movFilas][movCols] = bdR;
                } else if (tabRandomLvl[movFilas][movCols].equals(bdR)) {
                    tabRandomLvl[movFilas][movCols] = bdA;
                } else if (tabRandomLvl[movFilas][movCols].equals(biA)) {
                    tabRandomLvl[movFilas][movCols] = biR;
                } else {
                    tabRandomLvl[movFilas][movCols] = biA;
                }
                movCols--;
            }
        }
        return tabRandomLvl;
    }

    public static void solucionMet(int movFilas, int movCols, int lvls) {

        if (movFilas != -1 && movCols != -1) {
            Juego.contador++;
            int[] nuevoMovimiento = {movFilas, movCols};
            movSolucion.add(nuevoMovimiento);
        }

        int largoSol = movSolucion.size();

        for (int i = 0; i < largoSol; i++) {
            if ((movFilas == -1 && movCols == -1)) {
                if (Juego.historial.size() - Juego.cont >= 1) {
                    movSolucion.add(historial.get(historial.size() - Juego.cont));
                    Juego.cont++;
                    break;
                }
            }
        }
    }

    public static void historialMet(int movFilas, int movCols) {
        int[] movimientoNuevo = {movFilas, movCols};
        historial.add(movimientoNuevo);
    }

    public static void tiempoInicioMet() {
        Juego.comienzo = System.nanoTime();
    }

    public static String[][] genTabLvlMet(int filas, int cols, int lvls, ArrayList<String[][]> tablerosGuardados) throws FileNotFoundException {

        Random random = new Random();
        String[][] tabRandomLvl = new String[filas][cols];

        String meA = "\u001B[34m" + " - " + "\u001B[0m" + "|";
        String vA = "\u001B[34m" + " | " + "\u001B[0m" + "|";
        String bdA = "\u001B[34m" + " / " + "\u001B[0m" + "|";
        String biA = "\u001B[34m" + " \\ " + "\u001B[0m" + "|";

        String[] simbolos = {meA, vA, bdA, biA};

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                int indice = random.nextInt(simbolos.length);
                tabRandomLvl[i][j] = simbolos[indice];
            }
        }
        movimientosRandomMet(filas, cols, lvls, tabRandomLvl, tablerosGuardados);
        return tabRandomLvl;
    }

    public static void movimientosRandomMet(int filas, int cols, int lvls, String[][] tabRandomLvl, ArrayList<String[][]> tablerosGuardados) throws FileNotFoundException {
        Random genNum = new Random();

        int numRandomFilas[] = new int[filas];
        int numRandomCols[] = new int[cols];

        for (int i = 0; i < filas; i++) {
            numRandomFilas[i] = i + 1;
        }

        for (int i = 0; i < cols; i++) {
            numRandomCols[i] = i + 1;
        }

        int[] ultimoMovimiento = new int[2];

        for (int i = 0; i < lvls; i++) {
            int filaRandom;
            int colRandom;
            do {
                int indiceFila = genNum.nextInt(numRandomFilas.length);
                filaRandom = numRandomFilas[indiceFila];
                int indiceCol = genNum.nextInt(numRandomCols.length);
                colRandom = numRandomCols[indiceCol];
            } while (filaRandom == ultimoMovimiento[0] && colRandom == ultimoMovimiento[1]);
            ultimoMovimiento[0] = filaRandom;
            ultimoMovimiento[1] = colRandom;

            movimientosMet(filaRandom, colRandom, tabRandomLvl);
            int[] coordenadasMovRandom = {filaRandom, colRandom};
            movSolucion.add(coordenadasMovRandom);
            Juego.solInicial.add(coordenadasMovRandom);
            Juego.solInicial2.add(coordenadasMovRandom);
        }
        imprimirMet(tabRandomLvl);
        copiaTableroMet(tabRandomLvl);
        menuMovimientosMet(filas, cols, lvls, tabRandomLvl, tablerosGuardados);
        solucionMet(filas, cols, lvls);
    }

    public static void copiaTableroMet(String[][] tabRandomLvl) {
        int filas = tabRandomLvl.length;
        int cols = tabRandomLvl[0].length;
        String[][] copiaTablero = new String[filas][cols];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                copiaTablero[i][j] = tabRandomLvl[i][j];
            }
        }
        Juego.tablerosGuardados.add(copiaTablero);
    }

    public static String[][] leerArchivoTxtMet(String ruta) throws FileNotFoundException {
        int filas;
        int cols;
        int lvls;
        String[][] matrizTxt;

        try (Scanner input = new Scanner(new File(ruta))) {
            filas = Integer.parseInt(input.next());
            cols = Integer.parseInt(input.next());
            input.nextLine();

            matrizTxt = new String[filas][cols];
            for (int i = 0; i < filas; i++) {
                String linea = input.nextLine();
                String[] elementos = linea.split(" ");
                for (int j = 0; j < cols; j++) {
                    matrizTxt[i][j] = elementos[j];
                }
            }

            lvls = Integer.parseInt(input.next());
            input.nextLine();
            for (int i = 0; i < lvls; i++) {
                int movFilas = Integer.parseInt(input.next());
                int movCols = Integer.parseInt(input.next());
                int[] coordenadasMovRandom = {movFilas, movCols};
                movSolucion.add(coordenadasMovRandom);
                Juego.solInicial.add(coordenadasMovRandom);
                Juego.solInicial2.add(coordenadasMovRandom);
            }
        }

        String meA = "\u001B[34m" + " - " + "\u001B[0m" + "|";
        String meR = "\u001B[31m" + " - " + "\u001B[0m" + "|";

        String vA = "\u001B[34m" + " | " + "\u001B[0m" + "|";
        String vR = "\u001B[31m" + " | " + "\u001B[0m" + "|";

        String bdA = "\u001B[34m" + " / " + "\u001B[0m" + "|";
        String bdR = "\u001B[31m" + " / " + "\u001B[0m" + "|";

        String biA = "\u001B[34m" + " \\ " + "\u001B[0m" + "|";
        String biR = "\u001B[31m" + " \\ " + "\u001B[0m" + "|";

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrizTxt[i][j].equals("|R")) {
                    matrizTxt[i][j] = vR;
                } else if (matrizTxt[i][j].equals("|A")) {
                    matrizTxt[i][j] = vA;
                } else if (matrizTxt[i][j].equals("-R")) {
                    matrizTxt[i][j] = meR;
                } else if (matrizTxt[i][j].equals("-A")) {
                    matrizTxt[i][j] = meA;
                } else if (matrizTxt[i][j].equals("/R")) {
                    matrizTxt[i][j] = bdR;
                } else if (matrizTxt[i][j].equals("/A")) {
                    matrizTxt[i][j] = bdA;
                } else if (matrizTxt[i][j].equals("\\R")) {
                    matrizTxt[i][j] = biR;
                } else if (matrizTxt[i][j].equals("\\A")) {
                    matrizTxt[i][j] = biA;
                }
            }
        }

        imprimirMet(matrizTxt);
        copiaTableroMet(matrizTxt);
        Interfaz.menuMovimientosMet(filas, cols, lvls, matrizTxt, tablerosGuardados);

        return matrizTxt;
    }

}

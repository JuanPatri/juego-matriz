package obligatorio1p2;

//Theo Brum N 315141 | Juan Pablo Patri N 266824

import java.io.FileNotFoundException;
import java.util.ArrayList;
import static obligatorio1p2.Interfaz.inicioMet;

public class Juego {

    static long comienzo;

    static ArrayList<int[]> historial = new ArrayList<>();
    static ArrayList<int[]> movSolucion = new ArrayList<>();
    static ArrayList<String[][]> tablerosGuardados = new ArrayList<>();
    static ArrayList<int[]> solInicial = new ArrayList<>();
    static ArrayList<int[]> solInicial2 = new ArrayList<>();

    static int indice = 0;
    static int indice1 = 1;
    static int contador = 0;
    static int cont = 1;

    public static void main(String[] args) throws FileNotFoundException {
        inicioMet(tablerosGuardados);
    }
}

package py.com.cube.tareas;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Tarea02ArrayList {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayListNumeros = new ArrayList<ArrayList<Integer>>();

        File fichero = new File(
                System.getProperty("user.home") + "/Documentos/Tareas/Java/Tarea02 ArrayList/numeros.txt");
        Scanner s = null;

        // Primera forma
        try {
            s = new Scanner(fichero);

            while (s.hasNextLine()) {
                String linea = s.nextLine();
                String[] numerosStr = linea.split(" ");

                ArrayList<Integer> numeros = new ArrayList<Integer>();

                for (String numeroStr : numerosStr) {
                    if (!numeroStr.equals("0")) {
                        numeros.add(Integer.parseInt(numeroStr));
                    }
                }

                if (numeros.size() > 0)
                    arrayListNumeros.add(numeros);
            }

            s.close();

            System.out.println("Contenido del ArrayList de ArrayLists:");
            for (ArrayList<Integer> lista : arrayListNumeros) {
                System.out.println(lista);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

package py.com.cube.utils;

public class PrintUtils {
    public static void printCaso(Integer numeroCaso) {
        System.out.println("Caso: #" + numeroCaso);
    }

    public static void printSingleTextResponse(String texto) {
        System.out.println("La respuesta es: " + texto);
        System.out.println("-".repeat(48));
    }

    public static void printSingleText(String texto) {
        System.out.println(texto);
        System.out.println("-".repeat(48));
    }

    public static void printError(String error) {
        System.out.println("Ha ocurrido un error: " + error);
        System.out.println("-".repeat(48));
    }
}

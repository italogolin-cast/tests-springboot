package py.com.cube.puebas;

import py.com.cube.utils.CalculadoraUtils;
import py.com.cube.utils.ExceptionUtils;
import py.com.cube.utils.PrintUtils;
import py.com.cube.utils.StringUtils;

public class PruebaJava05 {

    public static void main(String[] args) {
        try {
            String nombreEjemplo = "";
            String respuesta = "";
            Integer numeroCaso = 1;

            // CASO 1 OK
            nombreEjemplo = "Gerardo";
            respuesta = StringUtils.recortarTexto(nombreEjemplo, 5);
            PrintUtils.printCaso(numeroCaso);
            PrintUtils.printSingleTextResponse(respuesta);
            numeroCaso++;

            // CASO 2 ERROR POR NULL EXCEPTION
            nombreEjemplo = null;
            respuesta = StringUtils.recortarTexto(nombreEjemplo, 5);
            PrintUtils.printCaso(numeroCaso);
            PrintUtils.printSingleText(respuesta);
            numeroCaso++;

            // CASO 3 ERROR POR LONGITUD MAYOR AL TAMAÑO DEL TEXTO
            nombreEjemplo = "Raul";
            respuesta = StringUtils.recortarTexto(nombreEjemplo, 5);
            PrintUtils.printCaso(numeroCaso);
            PrintUtils.printSingleText(respuesta);
            numeroCaso++;

            // CASO 4 ERROR POR LONGITUD MAYOR AL TAMAÑO DEL TEXTO
            nombreEjemplo = "Gustavo";
            PrintUtils.printCaso(numeroCaso);
            respuesta = StringUtils.recortarTexto(nombreEjemplo, (int) (Math.random() *
                    10) + 1);
            PrintUtils.printSingleTextResponse(respuesta);
            numeroCaso++;

            // CASO 5 OK
            Integer numeroEjemplo = 10;
            PrintUtils.printCaso(numeroCaso);
            respuesta = CalculadoraUtils.hacerSuma(numeroEjemplo);
            PrintUtils.printSingleTextResponse(respuesta);
            numeroCaso++;

            // CASO 6 ERROR POR NULL EXCEPTION
            numeroEjemplo = null;
            PrintUtils.printCaso(numeroCaso);
            respuesta = CalculadoraUtils.hacerSuma(numeroEjemplo);
            PrintUtils.printSingleTextResponse(respuesta);
            numeroCaso++;

            // CASO 7 EXCEPCION CASO EL NUMERO SE MAYOR A 5
            PrintUtils.printCaso(numeroCaso);
            // ExceptionUtils.lanzarExcepcion((int) (Math.random() * 10 + 1));
            ExceptionUtils.lanzarExcepcion(8);
        } catch (Exception e) {
            PrintUtils.printError("Vino al error general: " + e);
        } finally {
            PrintUtils.printSingleText("El metodo ha culminado");
        }
    }
}

package py.com.cube.utils;

public class ExceptionUtils {

    public static String lanzarExcepcion(Integer numero) throws Exception {
        try {
            // System.out.printf("Aca se debe establecer la logica para %s%n", numero);

            if (numero > 5)
                throw new Exception("El numero recibido es mayor a 5");

            return String.valueOf(numero);
        } catch (Exception e) {
            throw e;
        }
    }
}

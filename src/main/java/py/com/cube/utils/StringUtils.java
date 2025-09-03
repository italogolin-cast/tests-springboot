package py.com.cube.utils;

import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {
    public static String remueveSimbolosTexto(String texto) {
        return texto
                .replace(",", "")
                .replace(";", "")
                .replace(".", "");
    }

    public static Integer encuentraMayorCantidadDeCaracteresPorPalabra(List<String> palabras) {
        Integer mayorCantidadDeCaracteres = 0;

        for (String palabra : palabras) {
            if (palabra.length() > mayorCantidadDeCaracteres) {
                mayorCantidadDeCaracteres = palabra.length();
            }
        }

        return mayorCantidadDeCaracteres;
    }

    public static List<String> obtienePalabrasConNCaracteres(List<String> palabras, Integer n) {
        return palabras.stream()
                .filter(p -> p.length() == n)
                .collect(Collectors.toList());
    }

    public static Integer obtieneCantidadRepetidaPorLetraEnTexto(String letra, String texto) {
        Integer cantidadRepetida = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (String.valueOf(texto.charAt(i)).equals(letra)) {
                cantidadRepetida++;
            }
        }
        return cantidadRepetida;

    }

    public static String recortarTexto(String texto, int longitud) {
        try {
            System.out.println(">>>>> El nombre es: " + texto + " y la longitud es: " + longitud);

            String recorte = texto.substring(0, longitud);

            return recorte;
        } catch (Exception e) {
            if (texto == null) {
                return "El texto no puede ser recortado por ser nulo";
            }
            Integer excedeCantidadCaracteres = longitud - texto.length();
            return "El texto no puede ser recortado por exceder en " + excedeCantidadCaracteres
                    + " caracteres el limite permitido";
        }

    }
}

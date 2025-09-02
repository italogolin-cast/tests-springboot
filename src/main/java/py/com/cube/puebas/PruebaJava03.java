package py.com.cube.puebas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import py.com.cube.utils.StringUtils;

public class PruebaJava03 {
    public static void main(String[] args) {
        StringBuilder fraseInicial = new StringBuilder("La libertad, Sancho, es uno de los mas preciosos dones que a " +
                "los hombres dieron los cielos; con ella no pueden igualarse los tesoros " +
                "que encierra la tierra ni el mar encubre; por la libertad, así como por la" +
                " honra, se puede y debe aventurar la vida, y, por el contrario, el cautiverio es " +
                "el mayor mal que puede venir a los hombres.");

        String textoSinComasYPuntos = StringUtils.remueveSimbolosTexto(fraseInicial.toString());

        StringBuilder textoSinPuntoFinal = new StringBuilder(fraseInicial).replace(fraseInicial.length() - 1,
                fraseInicial.length(),
                textoSinComasYPuntos);

        String textoAdicionalCuandoHayMasDe10S = " Por la libertad, asi como por la honra se puede y debe aventurar la vida";
        String textoAdicionalAlternativo = " El cautiverio es el mayor mal que puede venir a los hombres";

        List<String> palabras = new ArrayList<>(Arrays.asList(textoSinComasYPuntos.split(" ")));

        Integer mayorCantidadDeCaracteres = StringUtils.encuentraMayorCantidadDeCaracteresPorPalabra(palabras);

        List<String> palabrasConMayorCantidadDeCaracteres = StringUtils.obtienePalabrasConNCaracteres(palabras,
                mayorCantidadDeCaracteres);

        Integer cantidadRepetidaDeLetraE = StringUtils.obtieneCantidadRepetidaPorLetraEnTexto("e",
                fraseInicial.toString());

        Integer cantidadRepetidaDeLetraS = StringUtils.obtieneCantidadRepetidaPorLetraEnTexto("s",
                fraseInicial.toString());

        System.out.println("a-) La cantidad de palabras del texto es: " + textoSinComasYPuntos.split(" ").length);
        System.out.printf("b-) Las palabras con mayor cantidad de caracteres son: %s y poseen: %s caracteres%n",
                palabrasConMayorCantidadDeCaracteres, mayorCantidadDeCaracteres);
        System.out.printf("c-) Cantidad de veces repetidas de la letra \"e\" con caseSensitive: %s%n",
                cantidadRepetidaDeLetraE);
        System.out.printf("d-) Texto sin el punto final con metodo \"replace\": %s%n",
                textoSinPuntoFinal);
        System.out.printf(
                "e-) Agregar texto al final con condicional de cantidad de letra \"s\" (cantidad de \"s\"=%s): %s%n",
                cantidadRepetidaDeLetraS,
                fraseInicial.append(cantidadRepetidaDeLetraS > 10 ? textoAdicionalCuandoHayMasDe10S
                        : textoAdicionalAlternativo));
    }

}

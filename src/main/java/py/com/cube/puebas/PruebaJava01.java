package py.com.cube.puebas;

import java.math.BigDecimal;
import java.util.stream.LongStream;

import py.com.cube.entities.factura.Factura;
import py.com.cube.entities.factura.dto.Tarea01Result;
import py.com.cube.utils.CalculadoraUtils;

public class PruebaJava01 {
    // 1- Ciclo que imprime del 1 al 100, y para cada numero genera un monto de
    // venta aleatorio entre 0 y 10 millones
    // 2- Cuenta cuantas facturas tienen monto inferior a 5 millones
    // 3- Suma el monto de las facturas cuyo numero de factura es multiplo de 7

    public static void main(String[] args) {

        final Tarea01Result resultado = new Tarea01Result();

        LongStream.range(1, 101).forEach(i -> {
            Factura f = new Factura(i);

            BigDecimal nuevoMontoVenta = CalculadoraUtils.generaMontoAleatorio(1l, 10_000_000l);
            f.setMontoVenta(nuevoMontoVenta);

            // 1- Aumenta contador cuando cumple con condicion de monto menor a 5 millones
            if (CalculadoraUtils.comparaMontoInferiorA5Millones(nuevoMontoVenta)) {
                resultado.incrementCantidadFacturasInferiorA5Millones();
            }

            // 2- Filtra las facturas con numero de factura multiplo de 7 y agrega el
            // contador y aumenta la suma
            if (i % 7 == 0)
                resultado.addToSumaTotalDelMontoDeFacturasConNumeroDeFacturaMultiploDe7(nuevoMontoVenta);

            System.out.println("Factura Nro: " + f.getNumero() + " - Monto Venta: " + nuevoMontoVenta);

            // 3- Suma el total de las facturas y cuenta la cantidad de las mismas
            resultado.addSumaTotal(nuevoMontoVenta);

        });

        System.out.println("-".repeat(64));

        System.out
                .println("1 - Cantidad de facturas con monto inferior a 5 millones: "
                        + resultado.getCantidadFacturasInferiora5Millones());

        System.out.println("2 - Suma total de monto de facturas con numero de factura multiplo de 7: " +
                resultado.getSumaTotalDelMontoDeFacturasConNumeroDeFacturaMultiploDe7());

        System.out.printf(
                "3 - La suma total de los montos de las facturas es de: %s, y el promedio de las mismas es: %s%n",
                resultado.getSumaTotalMontoVentas(), resultado.getPromedioMontoVentas());

        System.out.println("-".repeat(64));

        System.out.println("Fin de la tarea");

    }
}

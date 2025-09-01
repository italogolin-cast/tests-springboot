package py.com.cube;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import py.com.cube.entities.factura.Factura;
import py.com.cube.entities.factura.dto.ResultadoCalculoPromedioVenta;
import py.com.cube.utils.CalculadoraUtils;

public class PruebaJava01 {
    // 1- Ciclo que imprime del 1 al 100, y para cada numero genera un monto de
    // venta aleatorio entre 0 y 10 millones
    // 2- Cuenta cuantas facturas tienen monto inferior a 5 millones
    // 3- Suma el monto de las facturas cuyo numero de factura es multiplo de 7

    public static void main(String[] args) {
        Long cantidadFacturasInferiora5Millones = 0l;
        Map<Long, BigDecimal> facturasConNumeroFacturaMultiplo7 = new HashMap<Long, BigDecimal>();
        for (long i = 1; i <= 100; i++) {
            Factura f = new Factura(i);

            BigDecimal nuevoMontoVenta = CalculadoraUtils.generaMontoAleatorioEntre0a10Millones();
            f.setMontoVenta(nuevoMontoVenta);

            // Suma contador si el valor de la venta es menor a 5 millones
            if (CalculadoraUtils.comparaMontoInferiorA5Millones(nuevoMontoVenta))
                cantidadFacturasInferiora5Millones++;

            // Suma el monto de la venta si el numero de factura es multiplo de 7
            if (CalculadoraUtils.numeroFacturaEsMultiploDe7(i))
                facturasConNumeroFacturaMultiplo7.put(i, nuevoMontoVenta);

            System.out.print("Numero factura: " + i + ", monto: " + f.getMontoVenta() + "\n");
        }
        System.out.println("-".repeat(24));

        System.out
                .println("Cantidad de facturas con monto inferior a 5 millones: " + cantidadFacturasInferiora5Millones);

        ResultadoCalculoPromedioVenta resultadoPromedioVentaConNumeroFacturaMultiploDe7 = CalculadoraUtils
                .calculaPromedioVenta(new ArrayList<>(facturasConNumeroFacturaMultiplo7.values()));
        System.out.println("Cantidad de facturas con numero de factura multiplo de 7: "
                + facturasConNumeroFacturaMultiplo7.size());
        System.out.println("Suma total de monto de facturas con numero de factura multiplo de 7: " +
                resultadoPromedioVentaConNumeroFacturaMultiploDe7.getSumaTotalMontoVentas());
        System.out.println("Promedio de ventas de facturas con numero multiplo de 7: "
                + resultadoPromedioVentaConNumeroFacturaMultiploDe7.getPromedioMontoVentas());

        System.out.println("-".repeat(24));

        System.out.println("Fin de la tarea");

    }
}

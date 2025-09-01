package py.com.cube.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import py.com.cube.entities.factura.dto.ResultadoCalculoPromedioVenta;

public class CalculadoraUtils {
    public static void imprimeSumaDeMontoVentaFacturaConNumeroFacturaMultiploDe7(
            BigDecimal sumaFacturaConNumeroFacturaMultiploDe7) {
        System.out.println("Suma de monto de venta de facturas con numero de factura multiplo de 7: "
                + sumaFacturaConNumeroFacturaMultiploDe7);
    }

    public static Boolean comparaMontoInferiorA5Millones(BigDecimal montoVenta) {
        return montoVenta.compareTo(new BigDecimal(5_000_000l)) < 0;
    }

    public static Boolean numeroFacturaEsMultiploDe7(Long numeroFactura) {
        return numeroFactura % 7 == 0;
    }

    public static BigDecimal generaMontoAleatorioEntre0a10Millones() {
        Long min = 0l;
        Long max = 10_000_000l;
        Long range = max - min + 1;
        return new BigDecimal((long) (Math.random() * range) + min);
    }

    public static ResultadoCalculoPromedioVenta calculaPromedioVenta(List<BigDecimal> valores) {
        if (valores == null || valores.isEmpty())
            return ResultadoCalculoPromedioVenta.builder()
                    .promedioMontoVentas(BigDecimal.ZERO)
                    .sumaTotalMontoVentas(BigDecimal.ZERO)
                    .build();

        BigDecimal suma = valores.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal promedio = suma.divide(new BigDecimal(valores.size()), 2, RoundingMode.HALF_UP);
        return ResultadoCalculoPromedioVenta.builder()
                .promedioMontoVentas(promedio)
                .sumaTotalMontoVentas(suma)
                .build();
    }
}

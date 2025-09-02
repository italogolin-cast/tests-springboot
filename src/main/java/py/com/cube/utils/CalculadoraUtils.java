package py.com.cube.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

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

    public static BigDecimal generaMontoAleatorio(Long minimo, Long maximo) {
        Long range = maximo - minimo + 1;
        return new BigDecimal((long) (Math.random() * range) + minimo);
    }

    public static BigDecimal calculaPromedioVenta(BigDecimal sumaMontoVenta,
            Long cantidadTotalFacturas) {
        if (sumaMontoVenta == null || cantidadTotalFacturas == 0l)
            return BigDecimal.ZERO;

        return sumaMontoVenta.divide(new BigDecimal(cantidadTotalFacturas), 2, RoundingMode.HALF_UP);
    }

    public static String formatearBigDecimalGuarani(BigDecimal valor) {
        DecimalFormat df = new DecimalFormat("#,###");
        df.setGroupingSize(3);
        df.setGroupingUsed(true);
        return df.format(valor);
    }
}

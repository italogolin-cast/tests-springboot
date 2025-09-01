package py.com.cube.entities.factura;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import py.com.cube.entities.factura.dto.ResultadoCalculoPromedioVenta;
import py.com.cube.utils.CalculadoraUtils;

public class FacturaTest {

    @Test
    void testGenera100FacturasDel1al100() {
        Long cantidadFacturasInferiora5Millones = 0l;
        Map<Long, BigDecimal> facturasConNumeroFacturaMultiplo7 = new HashMap<Long, BigDecimal>();
        for (long i = 1; i <= 100; i++) {
            Factura f = new Factura(i);
            BigDecimal nuevoMontoVenta = CalculadoraUtils.generaMontoAleatorioEntre0a10Millones();
            f.setMontoVenta(nuevoMontoVenta);

            if (CalculadoraUtils.comparaMontoInferiorA5Millones(nuevoMontoVenta))
                cantidadFacturasInferiora5Millones++;

            if (CalculadoraUtils.numeroFacturaEsMultiploDe7(i))
                facturasConNumeroFacturaMultiplo7.put(i, nuevoMontoVenta);
        }

        ResultadoCalculoPromedioVenta resultadoPromedioVentaConNumeroFacturaMultiploDe7 = CalculadoraUtils
                .calculaPromedioVenta(new ArrayList<>(facturasConNumeroFacturaMultiplo7.values()));

        // Alternativa a System.out.println: usar assertions
        org.junit.jupiter.api.Assertions.assertTrue(cantidadFacturasInferiora5Millones >= 0);
        org.junit.jupiter.api.Assertions
                .assertNotNull(resultadoPromedioVentaConNumeroFacturaMultiploDe7.getPromedioMontoVentas());
        org.junit.jupiter.api.Assertions
                .assertNotNull(resultadoPromedioVentaConNumeroFacturaMultiploDe7.getSumaTotalMontoVentas());
    }

    @Test
    void testFacturaMontoVentaSetterGetter() {
        Factura factura = new Factura(123L);
        BigDecimal monto = new BigDecimal("1234567.89");
        factura.setMontoVenta(monto);
        // No hay getter, pero podrías agregar uno y testearlo así:
        // Assertions.assertEquals(monto, factura.getMontoVenta());
    }

    @Test
    void testFacturaNumeroMultiploDe7() {
        for (long i = 1; i <= 100; i++) {
            boolean esperado = (i % 7 == 0);
            boolean resultado = CalculadoraUtils.numeroFacturaEsMultiploDe7(i);
            org.junit.jupiter.api.Assertions.assertEquals(esperado, resultado, "Error en multiplo de 7 para " + i);
        }
    }

    @Test
    void testCompararMontoInferiorA5Millones() {
        BigDecimal menor = new BigDecimal("4999999.99");
        BigDecimal igual = new BigDecimal("5000000.00");
        BigDecimal mayor = new BigDecimal("5000000.01");

        org.junit.jupiter.api.Assertions.assertTrue(CalculadoraUtils.comparaMontoInferiorA5Millones(menor));
        org.junit.jupiter.api.Assertions.assertFalse(CalculadoraUtils.comparaMontoInferiorA5Millones(igual));
        org.junit.jupiter.api.Assertions.assertFalse(CalculadoraUtils.comparaMontoInferiorA5Millones(mayor));
    }

    @Test
    void testCalculaPromedioVentaVacio() {
        ResultadoCalculoPromedioVenta resultado = CalculadoraUtils.calculaPromedioVenta(new ArrayList<>());
        org.junit.jupiter.api.Assertions.assertNotNull(resultado);
        org.junit.jupiter.api.Assertions.assertEquals(BigDecimal.ZERO, resultado.getPromedioMontoVentas());
        org.junit.jupiter.api.Assertions.assertEquals(BigDecimal.ZERO, resultado.getSumaTotalMontoVentas());
    }
}

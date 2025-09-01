package entities;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class VentaItemTest {
    @Test
    void testSetCantidad() {
        // 1- Preparación de datos
        VentaItem item = VentaItem.buildVentaItemTest();

        // 2- Ejecución del código a probar

        item.setCantidad(new BigDecimal("4"));

        // 3- Verificación de resultados

        assert item.getCantidad().compareTo(new BigDecimal("4")) == 0;
    }

    @Test
    void testSetCantidadConRecalcularSubTotal() {
        // 1- Preparación de datos
        VentaItem item = VentaItem.buildVentaItemTest();

        // 2- Ejecución del código a probar

        item.setPrecioUnitario(new BigDecimal("300"));

        // 3- Verificación de resultados

        assert item.getSubTotal().compareTo(new BigDecimal("600")) == 0;
    }

    @Test
    void testSetPrecioUnitario() {
        // 1- Preparación de datos
        VentaItem item = VentaItem.buildVentaItemTest();

        // 2- Ejecución del código a probar

        item.setCantidad(new BigDecimal("3"));
        item.setPrecioUnitario(new BigDecimal("1000"));

        // 3- Verificación de resultados
        assert item.getSubTotal().compareTo(new BigDecimal("3000")) == 0;
    }
}

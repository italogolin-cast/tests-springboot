package entities;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class VentaTest {
    @Test
    void testCalcularValorTotalFail() {

        // 1- Preparación de datos
        Venta ventaTest = Venta.getVentaTest();

        VentaItem item1 = VentaItem.builder()
                .cantidad(new BigDecimal("2"))
                .precioUnitario(new BigDecimal("100"))
                .subTotal(new BigDecimal("200"))
                .venta(ventaTest)
                .build();

        ventaTest.agregaItem(item1);

        VentaItem item2 = VentaItem.builder()
                .cantidad(new BigDecimal("4"))
                .precioUnitario(new BigDecimal("100"))
                .subTotal(new BigDecimal("200"))
                .venta(ventaTest)
                .build();

        ventaTest.agregaItem(item2);
        // 2- Ejecución del código a probar

        ventaTest.calcularValorTotal();

        // 3- Verificación de resultados

        System.out.println("Total venta: " + ventaTest.getValorTotal());

        assert ventaTest.getValorTotal().compareTo(new BigDecimal("600")) != 0;
    }
     @Test
    void testCalcularValorTotalOk() {

        // 1- Preparación de datos
        Venta ventaTest = Venta.getVentaTest();

        VentaItem item1 = VentaItem.builder()
                .cantidad(new BigDecimal("2"))
                .precioUnitario(new BigDecimal("100"))
                .subTotal(new BigDecimal("200"))
                .venta(ventaTest)
                .build();

        ventaTest.agregaItem(item1);

        VentaItem item2 = VentaItem.builder()
                .cantidad(new BigDecimal("4"))
                .precioUnitario(new BigDecimal("100"))
                .subTotal(new BigDecimal("200"))
                .venta(ventaTest)
                .build();

        ventaTest.agregaItem(item2);
        // 2- Ejecución del código a probar

        ventaTest.calcularValorTotal();

        // 3- Verificación de resultados

        System.out.println("Total venta: " + ventaTest.getValorTotal());

        assert ventaTest.getValorTotal().compareTo(new BigDecimal("400")) == 0;
    }
}

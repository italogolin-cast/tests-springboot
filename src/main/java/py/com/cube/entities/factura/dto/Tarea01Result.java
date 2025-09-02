package py.com.cube.entities.factura.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import py.com.cube.utils.CalculadoraUtils;

public class Tarea01Result {
    private Long cantidadFacturasInferiora5Millones;
    private BigDecimal sumaTotalDelMontoDeFacturasConNumeroDeFacturaMultiploDe7;
    private BigDecimal sumaTotalMontoVentas;
    private Long cantidadFacturas;
    private BigDecimal promedioMontoVentas;

    public Tarea01Result() {
    }

    public Long getCantidadFacturasInferiora5Millones() {
        return cantidadFacturasInferiora5Millones;
    }

    public String getSumaTotalDelMontoDeFacturasConNumeroDeFacturaMultiploDe7() {
        return CalculadoraUtils.formatearBigDecimalGuarani(sumaTotalDelMontoDeFacturasConNumeroDeFacturaMultiploDe7);
    }

    public String getSumaTotalMontoVentas() {
        return CalculadoraUtils.formatearBigDecimalGuarani(sumaTotalMontoVentas);
    }

    public String getPromedioMontoVentas() {
        return CalculadoraUtils.formatearBigDecimalGuarani(promedioMontoVentas.setScale(2));
    }

    public Long getCantidadFacturas() {
        return cantidadFacturas;
    }

    public void incrementCantidadFacturasInferiorA5Millones() {
        if (this.cantidadFacturasInferiora5Millones == null)
            this.cantidadFacturasInferiora5Millones = 0L;

        this.cantidadFacturasInferiora5Millones++;
    }

    public void addToSumaTotalDelMontoDeFacturasConNumeroDeFacturaMultiploDe7(BigDecimal monto) {
        if (this.sumaTotalDelMontoDeFacturasConNumeroDeFacturaMultiploDe7 == null)
            this.sumaTotalDelMontoDeFacturasConNumeroDeFacturaMultiploDe7 = BigDecimal.ZERO;

        this.sumaTotalDelMontoDeFacturasConNumeroDeFacturaMultiploDe7 = this.sumaTotalDelMontoDeFacturasConNumeroDeFacturaMultiploDe7
                .add(monto);
    }

    public void addSumaTotal(BigDecimal monto) {
        if (this.sumaTotalMontoVentas == null)
            this.sumaTotalMontoVentas = BigDecimal.ZERO;

        this.sumaTotalMontoVentas = this.sumaTotalMontoVentas.add(monto);

        if (this.cantidadFacturas == null)
            this.cantidadFacturas = 0L;
        this.cantidadFacturas++;

        this.promedioMontoVentas = this.sumaTotalMontoVentas.divide(BigDecimal.valueOf(this.cantidadFacturas),
                1, RoundingMode.HALF_UP);
    }

}

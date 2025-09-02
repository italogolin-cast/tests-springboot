package py.com.cube.entities.factura;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import py.com.cube.entities.EnumCondicionVenta;
import py.com.cube.utils.CalculadoraUtils;

public class Factura {

    private Long clienteCodigo;
    private String clienteNombre;
    private String clienteRuc;
    private Timestamp fechaVenta;
    private BigDecimal montoVenta;
    private EnumCondicionVenta condicionVenta;
    private BigDecimal montoIva;
    private Long numero;
    private List<FacturaDetalle> detalles;

    public Factura() {
    }

    public Factura(Long numero) {
        this.numero = numero;
    }

    public List<FacturaDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<FacturaDetalle> detalles) {
        this.detalles = detalles;
    }

    public void setMontoVenta(BigDecimal montoVenta) {
        this.montoVenta = montoVenta;
    }

    public BigDecimal getMontoVenta() {
        return montoVenta;
    }

    public Long getNumero() {
        return numero;
    }

    public void calcularImporteproducto(Long numeroFactura) {
        Factura f = new Factura(numeroFactura);
        f.setDetalles(this.buildDetalles());
    }

    private List<FacturaDetalle> buildDetalles() {
        return LongStream.range(0, 5).boxed().map(l -> {
            BigDecimal precioUnitario = CalculadoraUtils.generaMontoAleatorio(1l, 100_000l);
            BigDecimal cantidad = CalculadoraUtils.generaMontoAleatorio(1l, 100l);

            FacturaDetalle detalle = new FacturaDetalle(precioUnitario, cantidad);

            Integer importeTotalDetalle = detalle.calcularImporteTotal();
            System.out.printf("Detalle numero: %s, importe total: %s%n", l + 1l, importeTotalDetalle);

            return detalle;
        }).collect(Collectors.toList());
    }

}

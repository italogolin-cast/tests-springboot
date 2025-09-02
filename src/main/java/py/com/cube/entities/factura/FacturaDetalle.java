package py.com.cube.entities.factura;

import java.math.BigDecimal;

public class FacturaDetalle {

    private Long productoCodigo;
    private String productoNombre;
    private BigDecimal precioUnitario;
    private BigDecimal precioTotal;
    private BigDecimal ivaTotal;
    private BigDecimal cantidad;

    public FacturaDetalle() {
    }

    public FacturaDetalle(BigDecimal precioUnitario, BigDecimal cantidad) {
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    public Integer calcularImporteTotal() {
        return this.precioUnitario.multiply(this.cantidad).intValue();
    }

}

package py.com.cube.entities.factura;

import java.math.BigDecimal;

public class FacturaV2 {
    public String clienteNombre;
    public Integer numero;
    public BigDecimal monto;

    public FacturaV2() {
        this.monto = BigDecimal.ZERO;
    }

    public String mostrarFactura() {
        return "Su factura es: " + this.numero;
    }

}
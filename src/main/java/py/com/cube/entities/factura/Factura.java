package py.com.cube.entities.factura;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import py.com.cube.entities.EnumCondicionVenta;
import py.com.cube.entities.factura.dto.ResultadoCalculoPromedioVenta;
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

    public Factura() {
    }

    public Factura(Long numero) {
        this.numero = numero;
    }

    public void setMontoVenta(BigDecimal montoVenta) {
        this.montoVenta = montoVenta;
    }

    public BigDecimal getMontoVenta() {
        return montoVenta;
    }

}

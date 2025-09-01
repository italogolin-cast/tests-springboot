package entities;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VentaItem {

    private Long id;
    private Long productoId;
    private BigDecimal cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subTotal;
    private Venta venta;

    void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
        recalcularSubTotal();
    }

    void recalcularSubTotal() {
        if (cantidad != null && precioUnitario != null) {
            this.subTotal = cantidad.multiply(precioUnitario);
        } else {
            this.subTotal = BigDecimal.ZERO;
        }
    }

    static VentaItem buildVentaItemTest() {
        return VentaItem.builder()
                .cantidad(new BigDecimal("2"))
                .precioUnitario(new BigDecimal("100"))
                .subTotal(new BigDecimal("0"))
                .build();
    }

}

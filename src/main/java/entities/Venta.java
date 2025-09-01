package entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
public class Venta {

    private Long id;
    private BigDecimal valorTotal;
    private Long clienteId;
    private List<VentaItem> items;

    public void calcularValorTotal() {
        this.valorTotal = items.stream()
                .map(VentaItem::getSubTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void agregaItem(VentaItem item){
        this.items.add(item);
        item.setVenta(this);
        this.calcularValorTotal();
    }

   static Venta getVentaTest() {
        return Venta.builder()
                .clienteId(1l)
                .valorTotal(BigDecimal.ZERO)
                .items(new ArrayList<>())
                .build();
    }

}

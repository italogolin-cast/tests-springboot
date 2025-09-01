package py.com.cube.entities.factura.dto;

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
public class ResultadoCalculoPromedioVenta {
    private BigDecimal sumaTotalMontoVentas;
    private BigDecimal promedioMontoVentas;
}

package py.com.cube.puebas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import py.com.cube.entities.factura.FacturaV2;

public class PruebaJava04 {
    final static Map<Integer, BigDecimal> facturasMap = new HashMap<Integer, BigDecimal>();

    public static void main(String[] args) {

        FacturaV2 f;

        List<Integer> listaValores = new ArrayList<Integer>();

        for (int i = 0; i < 100; i++) {
            f = new FacturaV2();
            f.numero = i + 1;
            f.monto = new BigDecimal(Math.random() * 1_000_000).setScale(0, RoundingMode.HALF_DOWN);

            listaValores.add(f.monto.intValue());

            System.out.printf("Factura Nro: %d, Monto: %s\n", f.numero, f.monto);

            facturasMap.put(f.numero, f.monto);

        }

        Integer montoMayor = listaValores.stream().max(Integer::compare).get();

        int indexMontoMayor = listaValores.indexOf(montoMayor);

        System.out.printf("a-) La cantidad de valores agregados a la lista es: %d\n", listaValores.size());
        System.out.printf("b-) El valor mayor de la lista es: %d, y su posicion es: %d\n", montoMayor, indexMontoMayor);

    }

}

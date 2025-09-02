package py.com.cube.tareas;

public class Tarea01String {

    public static void main(String[] args) {
        int cantidadCaracolas = 5000;
        StringBuilder sb = new StringBuilder("Hola Caracolas");
        System.out.printf("a-) El StringBuilder es= %s%n", sb);
        System.out.printf("b-) Capacidad= %s, longitud= %s%n", sb.capacity(), sb.length());
        sb.replace(0, 4, "Hay");
        System.out.printf("c-) %s%n", sb);
        sb.insert(3, " " + cantidadCaracolas);
        System.out.printf("d-) %s%n", sb);
        sb.append(" en el mar");
        System.out.printf("e-) %s%n", sb);
        String ultimos4CaracteresDelStringBuilder = sb.substring(sb.length() - 4, sb.length());
        System.out.printf("e-) Ultimos 4 caracteres del StringBuilder= %s%n", ultimos4CaracteresDelStringBuilder);
    }
}

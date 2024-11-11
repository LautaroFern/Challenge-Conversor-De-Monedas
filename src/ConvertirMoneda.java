import java.util.Scanner;

public class ConvertirMoneda {
    public static void convertir(String moneda_base, String moneda_target, ConsultaMoneda consulta, Scanner lectura){
        double cantidad;
        double cantidadConvertida;

        Monedas monedas = consulta.buscarMoneda(moneda_base, moneda_target);
        System.out.println("La Tasa de conversion para hoy \n1" + moneda_base + " = " + monedas.conversion_rate()+ " " +moneda_target);
        System.out.println("Ingrese la cantidad de " + moneda_base);
        Scanner teclado = new Scanner(System.in);
        cantidad = Double.parseDouble(teclado.nextLine());
        cantidadConvertida = cantidad * monedas.conversion_rate();
        System.out.println(cantidad+" "+moneda_base+" = "+cantidadConvertida +" "+moneda_target);
    }
}

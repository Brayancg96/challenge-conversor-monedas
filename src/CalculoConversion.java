import java.util.Scanner;

public class CalculoConversion {

    private String monedaInicial;
    private String monedaConvertir;
    private double cantidad;

    Scanner lectura = new Scanner(System.in);
    ConsultaConversion conversion;

    public CalculoConversion(ConsultaConversion conversion) {
        this.conversion = conversion;
    }

    public String getMonedaInicial() {
        return monedaInicial;
    }

    public String getMonedaConvertir() {
        return monedaConvertir;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void almacenarValores(String monedaInicial, String monedaConvertir){
        this.monedaInicial = monedaInicial;
        this.monedaConvertir = monedaConvertir;

        System.out.println("Ingrese el valor que deseas convertir");

        this.cantidad = Double.parseDouble(lectura.nextLine());
    }



    public String obtenerMensajeRespuesta() {
        String mensaje = getCantidad()+ " " + getMonedaInicial().toUpperCase() + " equivale a: "  + conversion.buscaConversion(getMonedaInicial(), getMonedaConvertir(), getCantidad()) + " " + getMonedaConvertir().toUpperCase();
        System.out.println(" ");
        System.out.println(mensaje);
        return mensaje;
    }
}

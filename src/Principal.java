import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        int opcionElegida = 0;


        ConsultaConversion consulta = new ConsultaConversion();

        CalculoConversion calculos = new CalculoConversion(consulta);

        List<String> respuestas = new ArrayList<>();

        String menu = """
                \n***************************************************
                *** Sea bienvenido al Conversor de Monedas ***
                
                1) Dólar ==>> Peso argentino
                2) Peso argentino ==>> Dólar
                3) Dólar ==>> Real brasileño
                4) Real brasileño ==>> Dólar
                5) Dólar ==>> Peso colombiano
                6) Peso colombiano ==>> Dólar
                7) Salir
                ***************************************************
                """;

        while (opcionElegida != 7) {
            try {
                System.out.println(menu);
                opcionElegida = Integer.parseInt(lectura.nextLine());

                switch (opcionElegida) {
                    case 1:
                        calculos.almacenarValores("USD", "ARS");
                        respuestas.add(calculos.obtenerMensajeRespuesta());
                        break;
                    case 2:
                        calculos.almacenarValores("ARS", "USD");
                        respuestas.add(calculos.obtenerMensajeRespuesta());
                        break;
                    case 3:
                        calculos.almacenarValores("USD", "BRL");
                        respuestas.add(calculos.obtenerMensajeRespuesta());
                        break;
                    case 4:
                        calculos.almacenarValores("BRL", "USD");
                        respuestas.add(calculos.obtenerMensajeRespuesta());
                        break;
                    case 5:
                        calculos.almacenarValores("USD", "COP");
                        respuestas.add(calculos.obtenerMensajeRespuesta());
                        break;
                    case 6:
                        calculos.almacenarValores("COP", "USD");
                        respuestas.add(calculos.obtenerMensajeRespuesta());
                        break;
                    case 7:
                        break;

                    default:
                        System.out.println("Ingrese una opción válida");
                }
            } catch (JsonSyntaxException | NullPointerException e) {
                System.out.println("Error. Ingrese solo códigos de moneda válidos.");
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Error. Ingrese un valor numérico válido.");
            }
        }

        System.out.println("Finalizando programa");

    }
}

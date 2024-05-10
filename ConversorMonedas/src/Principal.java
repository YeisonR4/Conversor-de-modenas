import java.util.Map;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        // Crear una instancia de la clase ConsultaAPI
        ConsultaAPI consultaAPI = new ConsultaAPI();

        // Realizar la consulta a la API para obtener las tasas de cambio
        ConsultaAPI.Moneda moneda = consultaAPI.consultaMoneda();

        if (moneda != null) {
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("=== Conversor de Monedas ===");
                System.out.println("1. Cambiar de Dólar a Peso Argentino");
                System.out.println("2. Cambiar de Peso Argentino a Dólar");
                System.out.println("3. Cambiar de Dólar a Real Brasileño");
                System.out.println("4. Cambiar de Real Brasileño a Dólar");
                System.out.println("5. Cambiar de Dólar a Peso Colombiano");
                System.out.println("6. Cambiar de Peso Colombiano a Dólar");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opción: ");
                System.out.println(moneda.rates);

                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        // Convertir de Dólar a Peso Argentino
                        System.out.print("Ingrese la cantidad en Dólares (USD): ");
                        double cantidadUSD = scanner.nextDouble();
                        double tasaARS = moneda.rates.get("ARS");
                        double valorConvertidoARS = cantidadUSD * tasaARS;
                        System.out.printf("%.2f USD equivale a %.2f ARS%n", cantidadUSD, valorConvertidoARS);
                        break;

                    case 2:
                        // Convertir de Peso Argentino a Dólar
                        System.out.print("Ingrese la cantidad en Pesos Argentinos (ARS): ");
                        double cantidadARS = scanner.nextDouble();
                        double tasaUSDToARS = 1 / moneda.rates.get("ARS");
                        double valorConvertidoUSD = cantidadARS * tasaUSDToARS;
                        System.out.printf("%.2f ARS equivale a %.2f USD%n", cantidadARS, valorConvertidoUSD);
                        break;

                    case 3:
                        // Convertir de Dólar a Real Brasileño
                        System.out.print("Ingrese la cantidad en Dólares (USD): ");
                        double cantidadUSDToBRL = scanner.nextDouble();
                        double tasaBRL = moneda.rates.get("BRL");
                        double valorConvertidoBRL = cantidadUSDToBRL * tasaBRL;
                        System.out.printf("%.2f USD equivale a %.2f BRL%n", cantidadUSDToBRL, valorConvertidoBRL);
                        break;

                    case 4:
                        // Convertir de Real Brasileño a Dólar
                        System.out.print("Ingrese la cantidad en Reales Brasileños (BRL): ");
                        double cantidadBRL = scanner.nextDouble();
                        double tasaUSDBRL = 1 / moneda.rates.get("BRL");
                        double valorConvertidoUSDFromBRL = cantidadBRL * tasaUSDBRL;
                        System.out.printf("%.2f BRL equivale a %.2f USD%n", cantidadBRL, valorConvertidoUSDFromBRL);
                        break;

                    case 5:
                        // Convertir de Dólar a Peso Colombiano
                        System.out.print("Ingrese la cantidad en Dólares (USD): ");
                        double cantidadUSDToCOP = scanner.nextDouble();
                        double tasaCOP = moneda.rates.get("COP");
                        double valorConvertidoCOP = cantidadUSDToCOP * tasaCOP;
                        System.out.printf("%.2f USD equivale a %.2f COP%n", cantidadUSDToCOP, valorConvertidoCOP);
                        break;

                    case 6:
                        // Convertir de Peso Colombiano a Dólar
                        System.out.print("Ingrese la cantidad en Pesos Colombianos (COP): ");
                        double cantidadCOP = scanner.nextDouble();
                        double tasaUSDCOP = 1 / moneda.rates.get("COP");
                        double valorConvertidoUSDFromCOP = cantidadCOP * tasaUSDCOP;
                        System.out.printf("%.2f COP equivale a %.2f USD%n", cantidadCOP, valorConvertidoUSDFromCOP);
                        break;

                    case 7:
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } while (opcion != 7);
        } else {
            System.out.println("Error al obtener las tasas de cambio. Verifique su conexión a internet.");
        }
    }
}
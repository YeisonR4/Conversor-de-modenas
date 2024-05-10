import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConsultaAPI {

    // Método para consultar la moneda
    public Moneda consultaMoneda() {
        // URI de la API
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/d6d860b366a736802c42a3fc/latest/USD");

        // Crear un cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Crear una solicitud HTTP GET
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar el código de estado de la respuesta
            int statusCode = response.statusCode();
            //System.out.println("Código de estado: " + statusCode);

            // Imprimir el cuerpo de la respuesta
            String responseBody = response.body();
            //System.out.println("Cuerpo de la respuesta: " + responseBody);


            // Analizar el JSON de la respuesta utilizando Gson
            Gson gson = new Gson();
            Moneda moneda = gson.fromJson(responseBody, Moneda.class);
            System.out.println(moneda);

            // Devolver el objeto Moneda
            return moneda;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            // Manejar errores
            return null; // Devolver null en caso de error
        }
    }

    // Clase Moneda (debes definirla según la estructura del JSON de la respuesta)
    static class Moneda {
        // Define las propiedades de la clase Moneda según la estructura del JSON
        // Por ejemplo, puedes tener propiedades como base, date y rates
        String base;
        String date;
        Map<String, Double> rates;
        // Puedes usar un mapa para las tasas de cambio

    }

}

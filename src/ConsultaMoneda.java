import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda{

    public Monedas buscarMoneda(String moneda_base, String moneda_target){

        URI direccion =URI.create("https://v6.exchangerate-api.com/v6/ea5de6e0662a4ed0b7322c59/pair/"
                + moneda_base + "/" + moneda_target + "/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();


        try{
            HttpResponse <String> response = client.
                    send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Monedas.class);
        }
        catch (Exception e) {
            throw new RuntimeException("No se encontro la moneda");
        }
    }

}


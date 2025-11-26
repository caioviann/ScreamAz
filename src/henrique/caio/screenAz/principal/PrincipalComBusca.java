package henrique.caio.screenAz.principal;

import com.google.gson.Gson;
import henrique.caio.screenAz.modelos.Tituulo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um Filme para busca: ");
        var search = sc.nextLine();

        String address = "http://www.omdbapi.com/?t=" + search + "&apikey=ce3ed0d3";


        //mais informações no JAVA DOC
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        Gson gson = new Gson();
        Tituulo meuTitulo = gson.fromJson(json, Tituulo.class);
        System.out.println(meuTitulo.getNome());
    }
}

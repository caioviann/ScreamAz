package henrique.caio.screenAz.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import henrique.caio.screenAz.execao.ErroDeConversaoDeAnoException;
import henrique.caio.screenAz.modelos.TitulosOMDB;
import henrique.caio.screenAz.modelos.Tituulo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        String search = "";
        List<Tituulo> titles = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!search.equalsIgnoreCase("sair")) {
            System.out.print("Digite um Filme para busca: ");
            search = sc.nextLine();

            if(search.equalsIgnoreCase("sair")) break;

            String address = "http://www.omdbapi.com/?t=" + search.replace(" ", "+") + "&apikey=ce3ed0d3";

            try {
                //mais informações no JAVA DOC
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(address))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                TitulosOMDB meuTituloOMDB = gson.fromJson(json, TitulosOMDB.class);
                System.out.println(meuTituloOMDB);

                Tituulo meuTitulo = new Tituulo(meuTituloOMDB);
                System.out.println("Titulo ja convertido");
                System.out.println(meuTitulo);

                titles.add(meuTitulo);

            } catch (NumberFormatException e) {
                System.err.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.err.println("Algum erro de argumento");
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(titles);

        FileWriter wr = new FileWriter("filmes.json");
        wr.write(gson.toJson(titles));
        wr.close();
        System.out.println("O programa finalizou corretamente.");
    }
}

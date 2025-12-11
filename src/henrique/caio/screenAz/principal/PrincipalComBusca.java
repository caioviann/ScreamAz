package henrique.caio.screenAz.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import henrique.caio.screenAz.execao.ErroDeConversaoDeAnoException;
import henrique.caio.screenAz.modelos.TitulosOMDB;
import henrique.caio.screenAz.modelos.Tituulo;

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
    static HttpClient client = HttpClient.newHttpClient();
    static Scanner sc = new Scanner(System.in);
    static String search = "";
    static List<Tituulo> titles = new ArrayList<>();
    static Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();
    static TitulosOMDB meuTituloOMDB;

    public static void main(String[] args) throws IOException, InterruptedException {


        while (!search.equalsIgnoreCase("sair")) {
            System.out.print("Digite um Filme para busca: ");
            search = sc.nextLine();

            if(search.equalsIgnoreCase("sair")) break;

            String address = "http://www.omdbapi.com/?t=" + search.replace(" ", "+") + "&apikey=ce3ed0d3";

            TitulosOMDB titulosOMDB = pegaTitulo(address);
            adicionaNaLista(titulosOMDB);
        }

        escreveNoArquivo();
        System.out.println("O programa finalizou corretamente.");
    }

    public static TitulosOMDB pegaTitulo(String address){
        try {
            //ler mais informações no JAVA DOC
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            return meuTituloOMDB = gson.fromJson(json, TitulosOMDB.class);

        } catch (NumberFormatException e) {
            System.err.println("Aconteceu um erro: ");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Algum erro de argumento");
        } catch (ErroDeConversaoDeAnoException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return meuTituloOMDB;
    }

    public static String adicionaNaLista(TitulosOMDB titulosOMDB){
        Tituulo meuTitulo = new Tituulo(titulosOMDB);
        System.out.println(meuTitulo);

        titles.add(meuTitulo);
        return "Titulo ja convertido e adicionado na lista.";
    }

    public static String escreveNoArquivo() throws IOException {
        FileWriter wr = new FileWriter("filmes.json");
        wr.write(gson.toJson(titles));
        wr.close();
        return "Escrito no arquivo com sucesso.";
    }
}

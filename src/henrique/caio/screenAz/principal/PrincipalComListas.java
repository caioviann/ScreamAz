package henrique.caio.screenAz.principal;

import henrique.caio.screenAz.modelos.Filme;
import henrique.caio.screenAz.modelos.Serie;
import henrique.caio.screenAz.modelos.Tituulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão",1970);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("Avatar",2023);
        outroFilme.avalia(6);
        var filmeDoPaulo = new Filme("Dogville",2003);
        filmeDoPaulo.avalia(10);
        Serie lost = new Serie("lost", 2000);

        ArrayList<Tituulo> lista = new ArrayList<>();

        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);
        for (Tituulo item: lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme &&  filme.getClassificacao() > 2){
                System.out.println("Classsificação: " + filme.getClassificacao());
            }
        }


        List<String> buscaPorArtista = new LinkedList<>();
        buscaPorArtista.add("Henrique");
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Caio");

        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);

        System.out.println("Depois da ordenação: ");
        System.out.println(buscaPorArtista);
        System.out.println("Lista de Titulos ordenadas: ");
        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Tituulo::getAnoDeLancamento));
        System.out.println("Ordenando por Ano: ");
        System.out.println(lista);

    }
}

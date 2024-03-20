package henrique.caio.screenAz.principal;

import henrique.caio.screenAz.modelos.Filme;
import henrique.caio.screenAz.modelos.Serie;
import henrique.caio.screenAz.modelos.Tituulo;

import java.util.ArrayList;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão",1970);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("Avatar",2023);
        meuFilme.avalia(6);
        var filmeDoPaulo = new Filme("Dogville",1970);
        meuFilme.avalia(10);
        Serie lost = new Serie("lost", 2000);

        ArrayList<Tituulo> lista = new ArrayList<>();

        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);
        for (Tituulo item: lista) {
            System.out.println(item.getNome());
            Filme filme = (Filme) item;
            System.out.println("Classsificação: " + filme.getClassificacao());

        }

    }
}

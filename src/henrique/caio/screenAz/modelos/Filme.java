package henrique.caio.screenAz.modelos;

import henrique.caio.screenAz.calculos.Classificavel;

public class Filme extends Tituulo implements Classificavel {

    private String diretor;

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }
}

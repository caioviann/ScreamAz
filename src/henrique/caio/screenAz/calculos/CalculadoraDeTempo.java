package henrique.caio.screenAz.calculos;

//import henrique.caio.screenAz.modelos.Filme;
//import henrique.caio.screenAz.modelos.Serie;
import henrique.caio.screenAz.modelos.Tituulo;

public class CalculadoraDeTempo {
    private int tempoTotal = 0;

    public int getTempoTotal() {
        return this.tempoTotal;
    }

//    public void inclui(Filme f) {
//        this.tempoTotal += f.getDuracaoEmMinutos();
//    }
//    public void inclui(Serie s) {
//        this.tempoTotal += s.getDuracaoEmMinutos();
//    }
    public void inclui(Tituulo titulo) {
        System.out.println("Adicionando duração em minutos de " + titulo);
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}

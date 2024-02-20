public class Filme {
    String nome;
    int anoDeLancamento;
    boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    int duracaoEmMinutos;

    int getTotalDeAvaliacoes(){
        return totalDeAvaliacoes;
    }

    void exibeFichaTecnica(){
        System.out.println("Nome do Filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }
    void avalia(double nota){
         somaDasAvaliacoes += nota;
         totalDeAvaliacoes++;
    }
    double pegaMedia(){
        return Math.round(somaDasAvaliacoes / totalDeAvaliacoes);
    }
}

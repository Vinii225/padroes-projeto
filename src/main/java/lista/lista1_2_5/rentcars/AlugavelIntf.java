package lista.lista1_2_5.rentcars;

public interface AlugavelIntf {

    String getDescricao();

    int getAno();

    double getValorDaLocacao(int diasAlugada);

    int getPontosDeAlugadorFrequente(int diasAlugada);
}

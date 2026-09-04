package lista.lista1_2_7.rentcars;

public interface AlugavelIntf {

    String getDescricao();

    int getAno();

    double getValorDaLocacao(int diasAlugada);

    int getPontosDeAlugadorFrequente(int diasAlugada);
}

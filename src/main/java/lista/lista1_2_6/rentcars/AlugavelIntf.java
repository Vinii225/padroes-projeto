package lista.lista1_2_6.rentcars;

public interface AlugavelIntf {

    String getDescricao();

    int getAno();

    double getValorDaLocacao(int diasAlugada);

    int getPontosDeAlugadorFrequente(int diasAlugada);
}

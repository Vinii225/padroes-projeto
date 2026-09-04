package lista.lista1_2_7.rentcars;

public abstract class Classificacao {

    abstract int getCodigoDoPreco();

    abstract double getValorDaLocacao(int diasAlugado);

    int getPontosDeAlugadorFrequente(int diasAlugado) {
        return 1;
    }
}

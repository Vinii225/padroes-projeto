package lista.lista1_2_6.rentcars;

public class Basica extends Classificacao {

    @Override
    int getCodigoDoPreco() {
        return Automovel.BASICO;
    }

    @Override
    double getValorDaLocacao(int diasAlugado) {
        return diasAlugado * 90.00;
    }
}

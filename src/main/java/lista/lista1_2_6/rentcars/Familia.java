package lista.lista1_2_6.rentcars;

public class Familia extends Classificacao {

    @Override
    int getCodigoDoPreco() {
        return Automovel.FAMILIA;
    }

    @Override
    double getValorDaLocacao(int diasAlugado) {
        return diasAlugado * 130.00;
    }
}

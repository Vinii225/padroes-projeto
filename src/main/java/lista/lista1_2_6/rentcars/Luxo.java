package lista.lista1_2_6.rentcars;

public class Luxo extends Classificacao {

    @Override
    int getCodigoDoPreco() {
        return Automovel.LUXO;
    }

    @Override
    double getValorDaLocacao(int diasAlugado) {
        double valorLocacao = diasAlugado * 200.00;

        // Acima de 4 diárias tem 10% de desconto
        if (diasAlugado > 4) {
            valorLocacao *= 0.9;
        }
        return valorLocacao;
    }

    @Override
    int getPontosDeAlugadorFrequente(int diasAlugado) {
        int pontos = super.getPontosDeAlugadorFrequente(diasAlugado);

        if (diasAlugado > 2) {
            pontos += 2;
        }
        return pontos;
    }
}

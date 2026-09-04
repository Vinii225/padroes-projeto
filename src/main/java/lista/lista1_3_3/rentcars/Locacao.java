package lista.lista1_3_3.rentcars;

public class Locacao {
    private Automovel carro;
    private int diasAlugado;

    public Locacao(Automovel carro, int diasAlugado) {
        this.carro = carro;
        this.diasAlugado = diasAlugado;
    }

    public Automovel getCarro() {
        return carro;
    }

    public int getDiasAlugado() {
        return diasAlugado;
    }

    public double valorLocacao() {
        double valorLocacao = 0.0;

        switch (carro.getCodigoDoPreco()) {
            case Automovel.BASICO: // R$ 90.00 por dia
                valorLocacao += diasAlugado * 90.00;
                break;

            case Automovel.FAMILIA: // R$ 130.00 por dia
                valorLocacao += diasAlugado * 130.00;
                break;

            case Automovel.LUXO: // R$ 200.00 por dia.
                valorLocacao += diasAlugado * 200.00;
                // Acima de 4 diárias tem 10% de desconto
                if (diasAlugado > 4) {
                    valorLocacao *= 0.9;
                }
                break;
        }    
        return valorLocacao;
    }

    public int pontosLocacao() {
        int pontos = 1;

        if (carro.getCodigoDoPreco() == Automovel.LUXO && diasAlugado > 2) {
            pontos += 2;
        }
        return pontos;
    }
}

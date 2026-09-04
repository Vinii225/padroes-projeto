package lista.lista1_2_4.rentcars;

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
        return carro.valorLocacao(diasAlugado);
    }

    public int pontosLocacao() {
        return carro.pontosLocacao(diasAlugado);
    }
}

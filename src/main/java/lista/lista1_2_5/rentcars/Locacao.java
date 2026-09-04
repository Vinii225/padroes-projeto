package lista.lista1_2_5.rentcars;

public class Locacao {

    private AlugavelIntf item;
    private int diasAlugado;

    public Locacao(AlugavelIntf item, int diasAlugado) {
        this.item = item;
        this.diasAlugado = diasAlugado;
    }

    public AlugavelIntf getItem() {
        return item;
    }

    public int getDiasAlugado() {
        return diasAlugado;
    }

    public double valorLocacao() {
        return item.getValorDaLocacao(diasAlugado);
    }

    public int pontosLocacao() {
        return item.getPontosDeAlugadorFrequente(diasAlugado);
    }
}

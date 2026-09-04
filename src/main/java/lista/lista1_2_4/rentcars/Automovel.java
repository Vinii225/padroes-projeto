package lista.lista1_2_4.rentcars;

public class Automovel {

    public static final int BASICO = 0;
    public static final int FAMILIA = 1;
    public static final int LUXO = 2;

    private String descricao;
    private String placa;
    private int ano; // Ano de fabricação do automóvel
    private int codigoDoPreco;

    public Automovel(String descricao, String placa, int ano, int codigoDoPreco) {
        this.descricao = descricao;
        this.placa = placa;
        this.ano = ano;
        this.codigoDoPreco = codigoDoPreco;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPlaca() {
        return placa;
    }

    public int getAno() {
        return ano;
    }

    public int getCodigoDoPreco() {
        return codigoDoPreco;
    }

    public void setCodigoDoPreco(int codigoDoPreco) {
        this.codigoDoPreco = codigoDoPreco;
    }

    public double valorLocacao(int diasAlugado) {
        double valorLocacao = 0.0;

        switch (codigoDoPreco) {
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

    public int pontosLocacao(int diasAlugado) {
        int pontos = 1;

        if (codigoDoPreco == Automovel.LUXO && diasAlugado > 2) {
            pontos += 2;
        }
        return pontos;
    }
}

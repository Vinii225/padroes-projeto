package lista.lista1_2_5.rentcars;

public class Automovel implements AlugavelIntf {

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

    @Override
    public String getDescricao() {
        return descricao;
    }

    public String getPlaca() {
        return placa;
    }

    @Override
    public int getAno() {
        return ano;
    }

    public int getCodigoDoPreco() {
        return codigoDoPreco;
    }

    public void setCodigoDoPreco(int codigoDoPreco) {
        this.codigoDoPreco = codigoDoPreco;
    }

    @Override
    public double getValorDaLocacao(int diasAlugada) {
        double valorLocacao = 0.0;

        switch (codigoDoPreco) {
            case Automovel.BASICO: // R$ 90.00 por dia
                valorLocacao += diasAlugada * 90.00;
                break;
            case Automovel.FAMILIA: // R$ 130.00 por dia
                valorLocacao += diasAlugada * 130.00;
                break;
            case Automovel.LUXO: // R$ 200.00 por dia.
                valorLocacao += diasAlugada * 200.00;
                // Acima de 4 diárias tem 10% de desconto
                if (diasAlugada > 4) {
                    valorLocacao *= 0.9;
                }
                break;
        }
        return valorLocacao;
    }

    @Override
    public int getPontosDeAlugadorFrequente(int diasAlugada) {
        int pontos = 1;

        if (codigoDoPreco == Automovel.LUXO && diasAlugada > 2) {
            pontos += 2;
        }
        return pontos;
    }
}

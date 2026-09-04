package lista.lista1_2_7.rentcars;

public class Automovel implements AlugavelIntf {

    public static final int BASICO = 0;
    public static final int FAMILIA = 1;
    public static final int LUXO = 2;

    private String descricao;
    private String placa;
    private int ano; // Ano de fabricação do automóvel
    private Classificacao classificacao;

    public Automovel(String descricao, String placa, int ano, int codigoDoPreco) {
        this.descricao = descricao;
        this.placa = placa;
        this.ano = ano;
        setCodigoDoPreco(codigoDoPreco);
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
        return classificacao.getCodigoDoPreco();
    }

    public void setCodigoDoPreco(int codigoDoPreco) {
        switch (codigoDoPreco) {
            case Automovel.BASICO:
                classificacao = new Basica();
                break;
            case Automovel.FAMILIA:
                classificacao = new Familia();
                break;
            case Automovel.LUXO:
                classificacao = new Luxo();
                break;
        }
    }

    @Override
    public double getValorDaLocacao(int diasAlugada) {
        return classificacao.getValorDaLocacao(diasAlugada);
    }

    @Override
    public int getPontosDeAlugadorFrequente(int diasAlugada) {
        return classificacao.getPontosDeAlugadorFrequente(diasAlugada);
    }
}

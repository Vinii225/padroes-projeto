package lista.lista1_2_2.rentcars;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cliente {

    private String nome;
    private List<Locacao> carrosAlugados = new ArrayList<Locacao>();

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionaLocacao(Locacao locacao) {
        carrosAlugados.add(locacao);
    }

    public String extrato() {
        final String fimDeLinha = System.getProperty("line.separator");
        double valorTotal = 0.0;
        int pontosDeAlugadorFrequente = 0;
        int sequencia = 0;

        Iterator<Locacao> locacoes = carrosAlugados.iterator();
        String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;
        resultado += String.format("Seq Automovel               Ano da Locacao Valor Pago" + fimDeLinha);
        resultado += String.format("=== ==================== ============== ===========" + fimDeLinha);

        while (locacoes.hasNext()) {
            Locacao locacao = locacoes.next();

            double valorCorrente = valorLocacao(locacao);
            pontosDeAlugadorFrequente = pontosLocacao(locacao);

            // mostra valores para este aluguel
            sequencia++;
            resultado += String.format(
                "%02d. %-20s %4d R$ %8.2f" + fimDeLinha,
                sequencia,
                locacao.getCarro().getDescricao(),
                locacao.getCarro().getAno(),
                valorCorrente
            );
            valorTotal += valorCorrente;
        } // while

        // adiciona rodapé
        resultado += "============================================" + fimDeLinha;
        resultado += String.format("Valor Acumulado em diárias............: R$ %8.2f" + fimDeLinha, valorTotal);
        resultado += "Voce acumulou " + pontosDeAlugadorFrequente + " pontos de alugador frequente";
        return resultado;
    }

    // Info: tarefa1
    private double valorLocacao(Locacao locacao) {
        double valorLocacao = 0.0;

        switch (locacao.getCarro().getCodigoDoPreco()) {
            case Automovel.BASICO: // R$ 90.00 por dia
                valorLocacao += locacao.getDiasAlugado() * 90.00;
                break;
            case Automovel.FAMILIA: // R$ 130.00 por dia
                valorLocacao += locacao.getDiasAlugado() * 130.00;
                break;
            case Automovel.LUXO: // R$ 200.00 por dia.
                valorLocacao += locacao.getDiasAlugado() * 200.00;
                // Acima de 4 diárias tem 10% de desconto
                if (locacao.getDiasAlugado() > 4) {
                    valorLocacao *= 0.9;
                }
                break;
        }
        return valorLocacao;
    }

    // Info: tarefa2
    private int pontosLocacao(Locacao locacao) {
        int pontos = 1;

        if (locacao.getCarro().getCodigoDoPreco() == Automovel.LUXO && locacao.getDiasAlugado() > 2) {
            pontos += 2;
        }
        return pontos;
    }
}

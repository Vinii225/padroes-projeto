package lista.lista1_2_4.rentcars;

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
        int sequencia = 0;

        Iterator<Locacao> locacoes = carrosAlugados.iterator();
        String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;
        resultado += String.format("Seq Automovel               Ano da Locacao Valor Pago" + fimDeLinha);
        resultado += String.format("=== ==================== ============== ===========" + fimDeLinha);

        while (locacoes.hasNext()) {
            Locacao locacao = locacoes.next();

            // mostra valores para este aluguel
            sequencia++;
            resultado += String.format("%02d. %-20s %4d R$ %8.2f" + fimDeLinha,
                    sequencia, locacao.getCarro().getDescricao(),
                    locacao.getCarro().getAno(), locacao.valorLocacao());
        } // while

        // adiciona rodapé
        resultado += "============================================" + fimDeLinha;
        resultado += String.format("Valor Acumulado em diárias............: R$ %8.2f" + fimDeLinha, getValorTotal());
        resultado += "Voce acumulou " + getPontosAlugadorFrequente() +
                " pontos de alugador frequente";
        return resultado;
    }

    public String extratoHTML() {
        final String fimDeLinha = System.getProperty("line.separator");
        int sequencia = 0;

        Iterator<Locacao> locacoes = carrosAlugados.iterator();
        String resultado = "<html><body>" + fimDeLinha;
        resultado += String.format("<H2>Registro de Locacoes de <EM>%s</EM></H2>" + fimDeLinha, getNome());
        resultado += "<table border=\"1\"><tr><th>Seq</th><th>Automóvel</th><th>Ano</th><th>Diárias</th><th>Valor</th></tr>"
                + fimDeLinha;

        while (locacoes.hasNext()) {
            Locacao locacao = locacoes.next();

            sequencia++;
            resultado += String.format("<tr><td>%02d</td><td>%s</td><td>%d</td><td>%d</td><td>R$ %8.2f</td></tr>" + fimDeLinha,
                    sequencia, locacao.getCarro().getDescricao(), locacao.getCarro().getAno(),
                    locacao.getDiasAlugado(), locacao.valorLocacao());
        } // while

        resultado += "</table>" + fimDeLinha;
        resultado += String.format("<P>Valor Acumulado em diárias: R$ %8.2f</P>" + fimDeLinha, getValorTotal());
        resultado += String.format("<P>Voce acumulou %d pontos de alugador frequente</P>" + fimDeLinha,
                getPontosAlugadorFrequente());
        resultado += "</body></html>";
        return resultado;
    }

    public int getPontosAlugadorFrequente() {
        int pontosDeAlugadorFrequente = 0;
        Iterator<Locacao> locacoes = carrosAlugados.iterator();
        while (locacoes.hasNext()) {
            pontosDeAlugadorFrequente += locacoes.next().pontosLocacao();
        }
        return pontosDeAlugadorFrequente;
    }

    public double getValorTotal() {
        double valorTotal = 0.0;
        Iterator<Locacao> locacoes = carrosAlugados.iterator();
        while (locacoes.hasNext()) {
            valorTotal += locacoes.next().valorLocacao();
        }
        return valorTotal;
    }
}

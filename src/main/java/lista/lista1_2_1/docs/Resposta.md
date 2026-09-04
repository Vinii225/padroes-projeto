# GRASP - Vinícius Ares

- **Expert  Information:** colocar  as  responsabilidades  com  os  dados,
ou seja, atribuir  uma  responsabilidade  ao  expert  de  informação,
classe  que  possui  a informação necessária para preencher a responsabilidade.

- **Fraco Acoplamento:** medida para mensurar o quão fortemente uma classe possui
ou depende de outra classe. O desejado é um cenário de fraco acoplamento.

- **Alta Coesão:** medida empregada para interpretar o qual relacionadas ou focadas
estão as responsabilidades de uma classe. O desejado é um cenário de alta coesão.
Uma classe com baixa coesão assume responsabilidades que pertencem a outras
classes, logo deveriam ser delegadas a outras classes.

- **Creator:** determina qual classe deve ser responsável por criar outros objetos.

## Violações Encontradas - Observações

1. O cálculo do preço da locação e os pontos de fidelidade deveriam ser feitos pela locação e não pelo cliente (fere Expert Information). A classe Locacao poderia ter esse cálculo

2. O método cliente faz 3 coisas além de apenas exibir o extrato, valor da locação, valor dos pontos de fidelidade (fere a parte de Alta Coesão com uma classe de baixa coesão).

3. Números mágicos dentro de um switch, sem nome e sem local de configuração.

4. O cliente tem alto acoplamento com preços, descontos, se eles mudarem o Cliente quebra.

5. Mistura com a apresentação do extrato junto com o cálculo em cliente.

6. Para aplicar descontos é preciso acessar qual o carro e seu código para aplicar descontos, em vez de ter um método a parte.

## Perguntas do PDF

a. Não, pois para adicionar "Premium", precisa de uma nova constante, um case novo no Switch e ajustar o cálculo de pontos de fidelidade + desconto, uso do Strategy aqui seria show.

b. Não, os preços estão num switch que também vai montar o relatório, o problema aqui é a classe fazer as coisas por ter informação.

# I. Análise sobre as mudanças realizadas

Depois de todas as etapas (1.2.1 a 1.2.6), o `Automovel` deixou de guardar o preço e a
regra de pontos de fidelidade dentro de si mesmo. Ele passou a manter uma referência
para um objeto `Classificacao` (`Basica`, `Familia` ou `Luxo`) e delega para ele
`getValorDaLocacao()` e `getPontosDeAlugadorFrequente()`. Como antes, ainda é possível
trocar a classificação de um automóvel em tempo de execução chamando
`setCodigoDoPreco()` — só que agora esse método troca o objeto composto em vez de
trocar um `int`.

Valeu a pena o esforço? Sim:

- O `switch` que existia em `Automovel.getValorDaLocacao()` e a lógica embutida de
  pontos de fidelidade desapareceram. Cada classificação virou uma classe pequena e
  fácil de entender isoladamente.
- Adicionar uma nova classificação (ex.: `Premium`) agora é só criar uma nova subclasse
  de `Classificacao` e ajustar o `switch` do *creator* (`setCodigoDoPreco()`) — não é
  mais necessário mexer no cálculo de preço nem no de pontos dentro do `Automovel`.
- `Locadora` e `Cliente` nunca precisaram mudar durante todo o processo, o que mostra
  que o impacto do refatoramento ficou isolado exatamente onde deveria (Alta Coesão).

## II. Herança x Composição

| | Composição | Herança |
|---|---|---|
| Acoplamento | Mais fraco, principalmente com interfaces/abstrações | Mais forte (subclasse depende da implementação da superclasse) |
| Flexibilidade | Pode trocar o objeto composto em tempo de execução (`Automovel` muda de `Basica` para `Luxo` sem virar outro objeto) | Fixa em tempo de compilação — não dá pra "mudar de subclasse" |
| Legibilidade | Pior: o comportamento final só se sabe olhando quem foi composto com quem em tempo de execução | Melhor: a leitura do código é direta, dá pra seguir a árvore de classes |

No nosso caso, herança não resolveria o problema real: um `Automovel` muda de
classificação durante a vida dele (por exemplo, um LUXO pode virar BASICO), e herança
não permite que um objeto "mude de subclasse" sem destruí-lo e recriar outro. Por isso
a composição (o padrão *Strategy*, na prática) foi a escolha certa aqui — a herança
ainda aparece, mas dentro da hierarquia de `Classificacao`, não na de `Automovel`.

## Observação sobre o diagrama final

O diagrama do PDF mostra uma `ClassificationFactory` separada, responsável por
`create(codigoDaClassificacao): Classificacao`. No código atual, quem cria a
classificação concreta ainda é o próprio `Automovel` (dentro de `setCodigoDoPreco()`),
funcionando como *creator*. Extrair essa lógica para uma `ClassificationFactory`
seria um próximo passo natural (Factory Method/GRASP Creator dedicado), deixando o
`Automovel` ainda mais enxuto — mas como o PDF não pede essa implementação nesta
etapa, mantive a criação dentro de `Automovel`.

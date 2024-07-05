# java-boundary-fill-recursive-algorithm

O algoritmo Boundary Fill é um método utilizado em computação gráfica para preencher regiões delimitadas por uma cor de borda específica. Ele é frequentemente empregado em programas de desenho e editores de imagem para preencher áreas com uma cor sólida, garantindo que a cor de preenchimento não ultrapasse os limites estabelecidos pela cor de borda.

## Funcionamento do Algoritmo Boundary Fill
O algoritmo Boundary Fill pode ser implementado de duas formas principais: recursiva e iterativa. A versão recursiva é a mais comum e intuitiva. 

O algoritmo Boundary Fill recursivo implementado neste projeto funciona da seguinte maneira:

1. Ponto Inicial: Começa a partir de um ponto dentro da área a ser preenchida.

2. Verificação de Cor: Verifica se a a cor do ponto atual é a mesma do ponto inicial.

3. Preenchimento: Pinta o ponto atual com a cor de preenchimento, caso  o passo 2 tenha obtido uma resposta verdadeira (true).

4. Chamada Recursiva: Chama a si mesmo recursivamente para os quatro pontos adjacentes (esquerda, direita, acima e abaixo) do ponto atual.

5. Repetição do Processo: Para cada ponto adjacente, o algoritmo repete os passos 2 a 4, verificando e preenchendo até que todos os pontos dentro da área delimitada pela cor inicial sejam preenchidos.

O processo continua até que não haja mais pontos a serem preenchidos dentro dos limites definidos pela cor inicial.

## Considerações
- Recursão: A implementação recursiva é simples e fácil de entender, mas pode levar a problemas de estouro de pilha se a área a ser preenchida for muito grande. Nesses casos, uma abordagem iterativa utilizando uma pilha explícita pode ser mais segura.

- Eficiência: Boundary Fill pode ser menos eficiente em comparação com outros algoritmos de preenchimento, como o Flood Fill, especialmente em áreas grandes e complexas.

O algoritmo Boundary Fill é uma técnica fundamental em computação gráfica e ilustra conceitos importantes de recursão e processamento de imagem.

## Animação da execução do algoritmo - Demonstração visual feita no Java
<div align="center">
  <img width="50%" src="/animation/boundary-fill-animation.gif">
</div>



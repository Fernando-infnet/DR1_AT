# 1️ Explicação

Os testes foram elaborados para cobrir diferentes cenários de entrada da API, utilizando técnicas de partição de equivalência e análise de valor limite. A ideia é não testar apenas valores “normais”, mas também valores que possam estar nos limites do que a API deve aceitar ou rejeitar, aumentando a chance de identificar falhas não previstas.

No caso do CEP, foram considerados três tipos de testes: valores inválidos (como letras ou nulos), valores muito longos e valores válidos. A partição de equivalência separa os CEPs em categorias válidas e inválidas, enquanto a análise de valor limite verifica casos extremos, como CEPs com tamanho acima do esperado.

Para endereços, testamos consultas válidas, onde esperamos receber resultados, e inválidas, como UFs inexistentes ou logradouros inexistentes, que devem retornar erros ou listas vazias. Essa abordagem garante que a API se comporte corretamente tanto para entradas normais quanto para entradas fora do padrão.
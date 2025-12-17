# 1️ Registro de falhas, comportamentos inesperados e dificuldades de uso

Durante os testes, o código funciona de forma esperada porque apresenta simplicidade em sua função, sendo bastante direto ao ponto, que também se apresenta como um problema quando os testes envolvem diferentes tipos de entradas, inválidas, que o programa não procura alguma forma de lidar com erros.

# 2️ Escreva uma especificação funcional clara e objetiva com base no comportamento esperado do sistema.

O sistema deve calcular o IMC de um usuário, esse sendo um indicador de massa que auxilia as pessoas à terem ideias iniciais sobre seu estado físico,  para este indicador ser calculado, o sistema precisa dos dados de altura de um usuário com base em entradas com números inteiros ou com casas decimais sendo no total os centímetros de altura do usuário, e posteriormente a quantidade de kilos em números inteiros ou casas decimais também. Após obter o número do IMC deve-se colocar o usuário na caixa correta de sua massa considerando o seu estado físico.

# 3️ Elabore casos de teste formais com base em análise de valor limite e partições de equivalência.

Os casos de teste foram elaborados utilizando as técnicas de análise de valor limite e partições de equivalência. Para a classificação do IMC, foram testados valores nos limites das faixas, bem como valores imediatamente abaixo desses limites, garantindo que as transições entre categorias ocorram corretamente.

# 4️ Justifique suas escolhas de cenários de teste com base na lógica e riscos da aplicação.

Os cenários de teste foram escolhidos com base nos limites entre as categorias, para que a análise de valor limite estivesse com um funcionamento adequado, considerando que é o objetivo principal da execução de separar por imc em diferentes categorias de gordura. 

A inclusão de testes com valores negativos, zero e valores especiais foi justificada pelo risco de falhas matemáticas e pela necessidade de robustez do sistema. Esses testes demonstraram que, embora o sistema funcione corretamente para entradas válidas, ele não implementa validações essenciais, o que caracteriza uma falha de qualidade do software, que poderia, se em produção, acabar com a execução dos sistemas conectadosa.
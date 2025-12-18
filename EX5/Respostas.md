# 1 Explicação

Escolhi a funcionalidade de criptografia Caesar Cipher, pois o código é claro, lida com uma das criptografias mais importantes da humanidade, e é focado em substituição de letras com shift, e lida com ramificações como caso maiúsculo/minúsculo, que apresenta bastante espaço para teste do que alguns modelos mais simples. 

Testes Unitários:
Adicionei testes ao CaesarTest para cobrir mais decisões e ramificações:

Strings vazias (caminho else completo).
Shifts 0, 26 (sem mudança).
Shift negativo (equivalente a shift positivo mod 26, mas código tem bug potencial em % negativo).
Caracteres não-letras (números, pontuação).
Shifts grandes (>26).
Casos mistos (maiúsculo/minúsculo, acentos? Mas código ignora non-ASCII).

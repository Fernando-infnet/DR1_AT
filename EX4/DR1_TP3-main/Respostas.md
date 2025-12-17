# Exercício 1 – Conceitos Fundamentais do Selenium

WebDriver: é o que realmente controla o navegador, abre páginas, clica, digita. É o coração do Selenium.

Selenium Grid: serve para rodar testes em vários computadores, navegadores e sistemas ao mesmo tempo. É pra paralelismo e testes distribuídos.

Selenium IDE: é uma extensão que grava os passos no navegador. Bem simples de usar, mas bem limitado.

Diferença entre WebDriver e Grid:
WebDriver é para usar localmente, no seu computador.
Grid é para quando você quer executar testes em paralelo ou em vários ambientes diferentes.

Vantagens do Selenium IDE:
É fácil, rápido e grava testes automaticamente.

Limitações:
Pouca flexibilidade, difícil pra testes grandes, não é ideal pra projetos profissionais.

# Exercício 2 – Configuração do Ambiente

Passos para configurar Java + Selenium:
Instalar Java JDK.
Criar projeto Java (Maven ou Gradle).
Adicionar dependências do Selenium.
(Fazer download do chromium)
Criar a classe de testes.

# Exercício 3 – Interação com Elementos Web

Escolhidos: Register User e Add Products in Cart.

Desafios comuns:
Alguns elementos não carregam rápido e precisam de waits.
Pop-ups atrapalham cliques.
Campos de texto às vezes limpam sozinhos.
Alertas precisam ser tratados com switchTo().alert().
Elementos às vezes ficam fora da tela e precisam de scroll.

# Exercício 4 – Teste de Login

Escolhido: Login com email e senha corretos.
Como verificar a URL:
Depois do login, conferir se a URL mudou para a página esperada. Exemplo: driver.getCurrentUrl() e comparar com a URL certa.

Usando Cookies e Web Storage:
Dá pra salvar cookies depois do login e carregar eles no próximo teste. Assim você não precisa logar toda vez, já entra direto como usuário logado.

# Exercício 5 – Manipulação de Formulários

Automatizei o formulário “Add Your Review” usando Selenium. Preenchi campos de texto com sendKeys, selecionei o radio button de avaliação com click e enviei o formulário. Usei WebDriverWait porque os campos só habilitam depois do login. Também validei a mensagem de sucesso após o envio. Não houve dropdowns nem pop-ups reais, mas foi necessário lidar com elementos inicialmente desabilitados.

# Exercício 6 – Cookies e Sessões

Os cookies guardam a sessão autenticada do usuário.
Salvamos os cookies após o primeiro login e carregamos nas execuções seguintes.
Isso evita login manual toda vez, gerando testes mais rápidos e estáveis.
Também reduz falhas por CAPTCHA, lentidão ou formulários.
Usado em testes reais de CI/CD para acelerar suites de regressão.

# Exercício 7 – Screenshots

Screenshots são úteis quando um teste falha ou quando você quer registrar evidências.
Dá pra salvar automaticamente no computador usando o próprio WebDriver.
Ótimo para debug e para anexar em relatórios de testes.

# Exercício 8 – Carrinho e Checkout

Para validar apenas é necessário o componente visual do carrinho de quantidade de items ser pego e avaliado.

# Exercício 9 – Rolagem e Elementos visíveis/invisíveis

Presença: o elemento existe no DOM.
Visível: está realmente aparecendo na tela.

O Selenium só interage com elementos visíveis.

Problema comum:
Quando o elemento só aparece depois de rolar a página.
Solução: fazer scroll até o elemento aparecer ou usar scrollIntoView.
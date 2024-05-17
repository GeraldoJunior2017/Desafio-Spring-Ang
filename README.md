Desafio: Cadastro de Usuário - Java + Angular
Este projeto foi desenvolvido como parte do desafio de um processo seletivo, onde o objetivo era criar uma aplicação web para cadastro de usuários, utilizando Java (Spring) no back-end e Angular no front-end.

Funcionalidades
Página de registro de usuário com campos de nome, e-mail, senha e confirmação de senha.
Validações eficazes em Angular para garantir que os campos atendam aos requisitos especificados.
API RESTful em Java para processar o registro de usuários, incluindo validação dos dados e armazenamento no banco de dados PostgreSQL.
Testes unitários para a API Java e para a página Angular.
Integração da página de registro Angular com a API Java para envio de dados do formulário para o back-end.
Tratamento de erros adequado na página Angular para lidar com falhas na comunicação com o back-end.
Estrutura do Projeto
O projeto está dividido em duas partes principais:

Front-end (Angular): A pasta angular-apps/projeto-angular-Spring contém o código fonte do front-end desenvolvido em Angular. Aqui estão os arquivos relacionados à interface do usuário e às validações dos campos do formulário.

Back-end (Java / Spring): A pasta spring-angular-registration contém o código fonte do back-end desenvolvido em Java com Spring. Aqui estão os arquivos relacionados à API RESTful, validação dos dados recebidos e armazenamento no banco de dados PostgreSQL.

Configuração e Execução
Front-end (Angular):

Certifique-se de ter o Angular CLI instalado.
Navegue até o diretório angular-apps/projeto-angular-Spring.
Execute npm install para instalar as dependências.
Execute ng serve para iniciar o servidor de desenvolvimento. Acesse http://localhost:4200/ em seu navegador.
Back-end (Java / Spring):

Certifique-se de ter o Java e o Apache Maven instalados.
Navegue até o diretório spring-angular-registration.
Execute mvn spring-boot:run para iniciar o servidor back-end. Acesse http://localhost:8080/ em seu navegador.
Certifique-se de configurar corretamente o banco de dados PostgreSQL e as conexões de banco de dados no arquivo de configuração do Spring, conforme necessário.

Testes
Back-end (Java / Spring): Os testes unitários para a API Java estão localizados no diretório spring-angular-registration/src/test/java.

Front-end (Angular): Os testes unitários para a página Angular estão localizados no diretório angular-apps/projeto-angular-Spring/src/app.

Contribuição
Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões de melhorias, fique à vontade para abrir uma issue ou enviar um pull request.

Autor
Este projeto foi desenvolvido por [Seu Nome].

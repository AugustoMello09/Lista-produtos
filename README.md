<h1> Lista de Produtos </h1>

<h3 align="center">
    Projeto Lista de Produtos 📦
    <br>
    <br><br>
    <p align="center">
      <a href="#sobre">Sobre</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
      <a href="#back">Backend</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
      <a href="#execB">Execução do projeto Backend</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
      <a href="#execF">Execução do projeto Frontend</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
      <a href="#execD">Execução o Docker-compose</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
      <a href="#tec">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
      <a href="#contato">Entre em contato</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  </p>
</h3>

<hr>

<h3 id="sobre"> Sobre </h3>

Este projeto é uma aplicação Full Stack para uma Lista de produtos, desenvolvida utilizando Java com Spring Boot 3+ no backend e Angular no frontend. O objetivo é oferecer uma interface prática e moderna, permitindo aos usuários listar, criar, editar, excluir produtos.

https://github.com/user-attachments/assets/88a4cb6e-3654-4fd8-a685-056cc569d7ed

<hr>

<h3 id="back"> Backend 🔧 </h3>

<h2> Projeto lista de Produtos 🧱 </h2>


#### Diagrama de Classe

![Screenshot_73](https://github.com/user-attachments/assets/92c15350-23da-4b3f-a541-0af9203592db)

### Funcionalidades Principais

__Listagem de Produtos__: Os usuários podem visualizar uma lista com todos os produtos cadastrados no sistema.

> __Observação: Caso não existam produtos cadastrados, será exibida a mensagem: "Ainda não há produtos cadastrados.__

__Criação de Produtos__: Os usuários podem adicionar novos produtos ao sistema, informando os dados corretos para a criação

__Atualização de Produtos__: Os produtos cadastrados podem ser editados pelos usuários para atualizar suas informações.

__Exclusão de Produtos__: Os usuários podem excluir produtos cadastrados, garantindo que apenas os produtos relevantes permaneçam no sistema.


<hr>

<h3> Documentação com Swagger 📗 </h3>

>  A documentação do nosso sistema usando Swagger, proporcionando uma visão unificada e acessível de todos os nossos serviços


![Screenshot_75](https://github.com/user-attachments/assets/92719c13-d1a6-49b1-8e11-68568f117c5e)

__Acesse a documentação do projeto:__

> Quando subir a aplicação acesse usando esse link

 - __Acesse:__ http://localhost:8080/swagger-ui.html para visualizar os endpoints.

<hr>

<h3> Migration com Flyway ️‍️✈️ </h3>

> Utilizei o Flyway para gerenciar e versionar as migrações do banco de dados de forma automática e eficiente. Isso garante que o esquema do banco esteja sempre atualizado, permitindo controle de versão e facilidade na aplicação de novas alterações.

![flyway](https://github.com/user-attachments/assets/0cffa7a8-48f2-4b0c-b53e-0ecbbb19bf0b)

<hr>

<h3 id="execB"> Execução do projeto Backend 🤓 </h3>

## Execute o projeto 👁‍🗨

__Pré-requisitos:__ Java 17  & (Docker opcional)

__Clone o repositório do projeto__

~~~~~~Bash
git clone https://github.com/AugustoMello09/Lista-produtos.git
~~~~~~

### Configurando o projeto local 🏠

__Configurando o ambiente:__

- Navegue até o diretório do projeto

~~~~~~Bash
cd produtosBackend
~~~~~~

- Acesse o diretório do projeto, utilize o comando `cd` e o nome do diretório para instalar todas as dependências necessárias:

~~~~~~Bash
# exemplo
cd produtosBackend

mvn clean package -DskipTest=true
~~~~~~

- Agora execute o seguinte comando para executar o projeto

~~~~Bash

cd produtosBackend

mvn spring-boot:run
~~~~

### Configurando o projeto para usar Docker 🐳

__com o terminal aberto use o seguinte comando:__

~~~~~~Bash
docker run -d -p 8080:8080 --name backend augustomello09/listproductbackend:latest
~~~~~~


<h3 id="execF"> Execução do projeto Frontend 🤪 </h3>

## Execute o projeto 👁

__Pré-requisitos:__ Angular & Node (20) (Docker opcional)

__Executar__

- Certifique-se de ter o Node.js e o Angular CLI instalados em seu ambiente.
- Navegue até a pasta do projeto front-end:

~~~~~~Bash
cd produtosFrontend
~~~~~~

__Instale as dependências do projeto:__

~~~~~~Bash
npm install
~~~~~~

- Suba o Frontend

~~~~~~Bash
ng serve
~~~~~~

### Configurando o projeto para usar Docker 🐳

__com o terminal aberto use o seguinte comando:__

__AVISO ⚠️__:

> Antes de iniciar o frontend, certifique-se de que o backend está em execução para que as requisições funcionem corretamente.

~~~~~~Bash
docker run -d -p 4200:4200 --name backend augustomello09/listproductfrontend:latest
~~~~~~

<hr>

<h3 id="execD"> Execução do com docker-compose  🐳</h3>

### Execute o projeto 👁

__Clone o repositório do projeto__

~~~~~~Bash
git clone https://github.com/AugustoMello09/Lista-produtos.git
~~~~~~

- Com o docker aberto, suba o docker-compose

~~~~~~Bash
docker-compose up -d
~~~~~~

<h3 id="tec"> Tecnologias </h3>

<div style="display: inline_block"><br>

<img align="center" alt="Augusto-Java" height="70" width="70" src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg">
<img align="center" alt="Augusto-SpringBoot" height="70" width="70" src="https://raw.githubusercontent.com/devicons/devicon/1119b9f84c0290e0f0b38982099a2bd027a48bf1/icons/spring/spring-original-wordmark.svg">
<img align="center" alt="Augusto-MYSQL" height="60" width="60"
src= https://raw.githubusercontent.com/devicons/devicon/1119b9f84c0290e0f0b38982099a2bd027a48bf1/icons/mysql/mysql-original.svg>
<img align="center" alt="Augusto-Docker" height="70" width="70" src="https://raw.githubusercontent.com/devicons/devicon/1119b9f84c0290e0f0b38982099a2bd027a48bf1/icons/docker/docker-original.svg">
<img align="center" alt="Augusto-Swagger" height="40" width="40" src="https://github.com/AugustoMello09/Locadora/assets/101072311/a895137a-8126-4eed-8a5c-9934ed30401b">
<img align="center" alt="Augusto-ANGULAR" height="50" width="50" src="https://raw.githubusercontent.com/get-icon/geticon/fc0f660daee147afb4a56c64e12bde6486b73e39/icons/angular-icon.svg">

</div>

<hr>

<h3 id="contato"> Entre em contato </h3>

### contato

Para mais informações sobre o projeto ou para entrar em contato, você pode me encontrar através dos canais abaixo:

<div style="display: inline_block">

  <a href="https://www.linkedin.com/in/augusto-mello-794a94234" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>
 <a href="mailto:joseaugusto.mello01@gmail.com" target="_blank"><img src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white" target="_blank"></a>

</div>


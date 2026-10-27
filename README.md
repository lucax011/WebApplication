# Barbearia: aplicação web em Java

Meu primeiro CRUD completo (2023): um sistema de agendamento para uma barbearia fictícia, com back-end em Java (Servlets) e front-end em HTML, CSS e JavaScript.

## Funcionalidades

- Cadastro e login de usuários
- Agendamento com escolha de serviço, atendente, dia e horário (opções carregadas do banco via AJAX)
- Consulta, alteração e exclusão de agendamentos

## Stack

- Java 8, Servlet API 3.1 (`javax.servlet`), empacotado como WAR
- MySQL (JDBC, `mysql-connector-java`)
- Apache Tomcat 9
- HTML, CSS e JavaScript com chamadas AJAX; páginas JSP

## Como rodar

Pré-requisitos: JDK 8+, Maven, MySQL e Tomcat 9.

1. Crie o banco no MySQL e ajuste a URL, o usuário e a senha em `Model/ConnectionBd.java`.
2. Gere o WAR e copie para a pasta `webapps` do Tomcat:
   ```bash
   cd "App Web java/javaWebapplication"
   mvn package
   ```
3. Inicie o Tomcat e acesse a aplicação pelo contexto do WAR.

Também dá para importar a pasta `javaWebapplication` no Eclipse como projeto Maven e rodar em um servidor Tomcat configurado na IDE.

## Estrutura

```
App Web java/javaWebapplication/src/main/
  java/javaWebApplication/
    Beans/        modelos (agendamento, atendente, serviço, dia, hora, login)
    Controller/   servlets que atendem as requisições AJAX
    Model/        conexão e operações no MySQL
  webapp/         JSP, CSS, JavaScript e imagens
```

# Cadastro de Usuários - React & Spring Boot

Este é um projeto desenvolvido para prática e aprendizado, explorando conceitos de **React** no frontend, **Java Spring Boot** no backend e a conexão entre ambos.

## Tecnologias Utilizadas

### Frontend

- **React** (Vite para inicialização rápida do projeto)
- **React Hooks** (useState, useEffect)
- **Axios** (para consumo de API)

### Backend

- **Spring Boot** (REST API)
- **Spring Data JPA** (para interação com o banco de dados)
- **Banco de dados postgresql**

## Funcionalidades

- Cadastro de usuários com nome, idade e email.
- Integração entre frontend e backend via API REST.
- Exibição da lista de usuários cadastrados.
- Validação básica no frontend.

## Como Rodar o Projeto

### Backend (Spring Boot)

1. Clone o repositório:
    ```sh
    git clone https://github.com/silveira24/RegisterPage-Projeto
    cd backend
    ```

2. Configure o banco de dados PostgreSQL:
    - Crie um banco de dados chamado [clients]
    - Atualize as credenciais do banco de dados no arquivo [application.properties]

3. Compile e rode o backend:
    ```sh
    ./mvnw spring-boot:run
    ```


### Frontend (React)

1. Navegue até a pasta do frontend
2. Instale as dependências:
   ```sh
   npm install
   ```
3. Inicie o projeto:
   ```sh
   npm run dev
   ```
4. O frontend estará acessível em `http://localhost:5173`

## Licença

Este projeto é apenas para fins educacionais e não possui uma licença definida.


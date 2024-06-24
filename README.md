# Projeto Livraria

### Descrição

Este projeto é um estudo voltado para o desenvolvimento de uma aplicação backend júnior de um sistema de empréstimo de livros.

## Tecnologias Utilizadas

- **Java 21**: Linguagem de programação principal usada para desenvolver a aplicação.
- **Docker**: Ferramenta de contêinerização utilizada para facilitar o ambiente de desenvolvimento e a implantação.
- **Spring Boot**: Framework para criação de aplicações Java, que simplifica a configuração e o desenvolvimento.
- **PostgreSQL**: Sistema de gerenciamento de banco de dados relacional usado para armazenar os dados da aplicação.

## Como Executar o Projeto

### Pré-requisitos

Antes de começar, certifique-se de ter instalado em sua máquina:

- [Docker](https://www.docker.com/)
- [Java 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)

### Passo a Passo

1. **Clone o repositório**:

   ```sh
   https://github.com/AllanCristiano/library.git
   cd projeto-livraria
   
2. **Execute o Docker Compose**

   ```sh
   docker-compose up -d
   
3. **Acesse a aplicação: Acesse a aplicação em http://localhost:8080 do navegador.**

## API Endpoints

### Author Endpoints

A seguir estão os endpoints disponíveis para gerenciar autores no sistema.

#### Criar Autor

- **URL:** `/api/authors`
- **Método:** `POST`
- **Descrição:** Cria um novo autor.
- **Request Body:**
  ```json
  {
    "name": "Nome do Autor",
    "nationality": "Nacionalidade"
  }


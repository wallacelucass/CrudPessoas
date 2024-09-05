# Cadastro de Pessoas

## Descrição
Aplicação em Java com Microsoft SQL Server para o cadastro, leitura, edição e exclusão de pessoas, utilizando Hibernate.

## Funcionalidades
- Cadastro de novas pessoas
- Listagem de todas as pessoas cadastradas
- Edição de informações de pessoas existentes
- Exclusão de pessoas do cadastro

## Tecnologias Utilizadas
- **Java**: Linguagem de programação principal
- **Spring Boot**: Framework para simplificar a criação de aplicações Java
- **Hibernate**: Framework de mapeamento objeto-relacional (ORM)
- **Microsoft SQL Server**: Banco de dados utilizado
- **Maven**: Gerenciador de dependências

## Pré-requisitos
- Java 11 ou superior
- Maven
- Microsoft SQL Server

## Como Executar
1. Clone o repositório:
    ```bash
    git clone https://github.com/wallacelucass/CrudPessoas.git
    ```
2. Navegue até o diretório do projeto:
    ```bash
    cd CrudPessoas
    ```
3. Configure o banco de dados no arquivo `application.properties`:
    ```properties
    spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=sua-base-de-dados
    spring.datasource.username=seu-usuario
    spring.datasource.password=sua-senha
    ```
4. Compile e execute a aplicação:
    ```bash
    mvn spring-boot:run
    ```

## Endpoints

### Criar Pessoa
- **URL**: `/pessoas`
- **Método**: `POST`
- **Descrição**: Cria uma nova pessoa.
- **Corpo da Requisição**:
    ```json
    {
        "nome": "string",
        "email": "string"
    }
    ```

### Listar Pessoas
- **URL**: `/pessoas`
- **Método**: `GET`
- **Descrição**: Lista todas as pessoas cadastradas.

### Buscar Pessoa por Nome
- **URL**: `/pessoas/nome/{nome}`
- **Método**: `GET`
- **Descrição**: Busca uma pessoa pelo nome.
- **Parâmetros**:
    - `nome`: Nome da pessoa a ser buscada.

### Buscar Pessoa por Email
- **URL**: `/pessoas/email/{email}`
- **Método**: `GET`
- **Descrição**: Busca uma pessoa pelo email.
- **Parâmetros**:
    - `email`: Email da pessoa a ser buscada.

### Atualizar Pessoa
- **URL**: `/pessoas`
- **Método**: `PUT`
- **Descrição**: Atualiza as informações de uma pessoa.
- **Corpo da Requisição**:
    ```json
    {
        "id": "long",
        "nome": "string",
        "email": "string"
    }
    ```

### Deletar Pessoa
- **URL**: `/pessoas/{id}`
- **Método**: `DELETE`
- **Descrição**: Deleta uma pessoa pelo ID.
- **Parâmetros**:
    - `id`: ID da pessoa a ser deletada.

## Estrutura do Projeto
- `src/main/java`: Código fonte da aplicação
- `src/main/resources`: Arquivos de configuração
- `src/test/java`: Testes unitários

## Contribuição
1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`)
4. Faça um push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## Contato
- **Nome**: Wallace Lucas
- **Email**: wallace.lucas@live.com
- **LinkedIn**: [Wallace Lucas](https://www.linkedin.com/in/wallaceltcardoso/)


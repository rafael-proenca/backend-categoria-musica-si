# backend-categoria-musica-si
Repositório destinado ao estudo da disciplina Banco de dados da pós em java da UTFPR
- [link da disciplina](https://github.com/Cyber-Barbarian/estudo-java-utfpr-rafael)
- [link do repositório](https://github.com/Cyber-Barbarian/backend-categoria-musica-si)

# Atividade projeto Spring JPA
- O Diagrama ER do projeto está em: [diagramaER](src\main\resources\static\diagrama_ER.png)
 
## Gerando os projeto Spring Initializr

1. Acesse o site oficial do Spring Initializr em https://start.spring.io.
2. Nessa parte do painel, escolher:
    - Project = “Maven”
    - Langague = “Java”
    - Spring Boot = “3.2.1” (escolhemos 3.3.1)
    - Group = “com.utfpr”
    - Artifact = “backend-categoria-musica-si”
    - Name = “backend-categoria-musica-si”
    - Description = “Projeto exemplo disciplina Banco de Dados usando spring initializr”
    - Package name = “com.utfpr. backendcategoriamusicasi”
    - Packaging = “Jar”
    - Java = “17”
3. Adicionamos as dependências:
    - Spring Boot DevTools - recursos de desenvolvimento (ex reinicialização automática)
    - Spring Data JPA - recursos de persistência de dados
    - Spring Web - Recursos para criação de endpoints REST
    - MariaDB Driver - Banco de dados
    - H2 Database - Banco de dados
    - Lombok - Recursos que simplificam a criação de classes
4. Clicamos em generate, baixamos e extraímos para este repo, como se fosse mais um módulo
5. Deixei em uma pasta como backup enquanto segui com o projeto

## Estrutura inicial do projeto

- src/main/java, é onde encontra-se o código fonte do nosso projeto
- com.utfpr.backendcategoriamusicasi, é o pacote raiz de nossa estrutura do projeto
- src/main/resources, é onde colocamos arquivos de configuração, imagens, HTML, etc. Em application.properties podemos fazer uma conexão alternativa no banco de dados
- pom.xml (Project Object Model) guarda as  informações do maven (versão do java, dependências, etc...)

## Executar o projeto
 - modo 1
   - Main Menu -> Run -> Edit Configurations... -> + -> Maven -> Run -> spring-boot:run
   - apply -> ok -> run
   - Se não aparecer nenhum “Error” então tudo ok

- modo 2
   - acessar o terminal
   - $cd <path dir>
   - $mvn spring-boot:run
  
# Implementar configuração programática
- clicckameos com o direito no pacote raiz do seu projeto -> New -> Package
- vamos criar o pacote **config** de forma que tenhamos **“com.utfpr.backendcategoriamusicasi.config”**
- nele sera criada nossa classe de configuração (direito config -> new -> class, nome [**SpringDataConfig**](src\main\java\com\utfpr\backendcategoriamusicasi\config\SpringDataConfig.java))
- vamos aplicar as tags **@Configuration** e **@EnableJpaRepositories(<path>)** e o **@EnableTransactionManagement**
- aplicar  conexão **dataSource()**, nesse caso com o **H2**
- obs: pode ser necessário adicionar ao pom.xml
```xml
<dependency>
<groupId>com.zaxxer</groupId>
 <artifactId>HikariCP</artifactId>
</dependency>
```
- aplicar o **entityManagerFactory()** e o **transactionManager()**

# Implementando as classes de entidade
- criamos o pacote [**com.utfpr.backendcategoriamusicasi.entity**](src/main/java/com/utfpr/backendcategoriamusicasi/entity)
- criamos a classe  [Categoria](src/main/java/com/utfpr/backendcategoriamusicasi/entity/Categoria.java) com as tags **“@Entity”** e **"@Table(name = "categoria")"**
- vamos criar as colunas "cod_categoria" que será o id e "desc_categoria"
- vamos incluir a anotação **@Data** para podermos usar o **lombok**
- Vamos fazer o mesmo processo com a classe [Musica](src/main/java/com/utfpr/backendcategoriamusicasi/entity/Musica.java), implementando a chave estrangeira em **cod_categoria**
- Repare na classe música que a notação @Column foi omitida para duracao, pois alem de ter o mesmo nome da variável ela poderá ser nula e não tem limite de tamanho
- Repare também na criação da variável **codCategoria** como chave estrangeira
- 


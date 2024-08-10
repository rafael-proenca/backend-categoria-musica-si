# https://spring.io/guides/gs/accessing-data-jpa

# backend-categoria-musica-si
Repositório destinado ao estudo da disciplina Banco de dados da pós em java da UTFPR
- [link da disciplina](https://github.com/Cyber-Barbarian/estudo-java-utfpr-rafael)
- [link do repositório](https://github.com/Cyber-Barbarian/backend-categoria-musica-si)

# Atividade projeto Spring JPA
- O Diagrama ER do projeto está em: [diagramaER](src/main/resources/static/diagrama_ER.png)
 
# Inicializando o projeto
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
- nele sera criada nossa classe de configuração (direito config -> new -> class, nome [**SpringDataConfig**](src/main/java/com/utfpr/backendcategoriamusicasi/config/SpringDataConfig.java))
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

# Implementando Repository e Service
## Implementando o Repository
- A camada de repository em um projeto Spring Data JPA tem a responsabilidade de abstrair o acesso aos dados e fornecer métodos de alto nível para realizar operações de persistência e consulta no banco de dados.
- Atua como uma interface entre a camada de serviço (ou de negócios) e o mecanismo de persistência (banco de dados), encapsulando a lógica de acesso aos dados e fornecendo métodos que são utilizados pela camada de serviço para interagir com as entidades do domínio.
- As principais funções da camada de repository são:
```
Abstração do acesso aos dados: acultação de detalhes de como os dados são armazenados e consultados no banco de dados. 
Definição de operações de consulta: define métodos que podem ser personalizados para realizar operações de consulta no banco de dados. 
Herança de recursos do Spring Data JPA:A camada de repository pode estender as interfaces CrudRepository, JpaRepository e PagingAndSortingRepository para herdar recursos prontos para uso.
Implementação de consultas personalizadas: a camada de repository pode incluir métodos personalizados para consultas específicas do domínio. Por exemplo consultas com anotações @Query , ou também consultas dinâmicas com o uso de Criteria, Example ou Specifications.
Suporte a transações: a tag @Transactional garante a consistência dos dados e a atomicidade das operações.
```
### Etapas para criar a interface repository:
- Pacote raiz do seu projeto->New->Package teremos algo como [**com.utfpr.backendcategoriamusicasi.repository**](src/main/java/com/utfpr/backendcategoriamusicasi/repository), onde iremos alocar nossas interfaces
- Em repository New->Java Class->Interface com o nome [**CategoriaRepository**](src/main/java/com/utfpr/backendcategoriamusicasi/repository/CategoriaRepository.java)
- Estender o JpaRepository e fazer as importações necessárias
```
extends JpaRepository <"ClasseReferência","TipoDeDadoNoId">
```
- Fazer o mesmo para [**MusicaRepository**](src/main/java/com/utfpr/backendcategoriamusicasi/repository/MusicaRepository.java)

## Implementando o Service
- A camada de serviço (@Service) em um projeto Spring Data JPA tem a responsabilidade de encapsular a lógica de negócios e coordenar as operações entre a camada de controle (Controller) e a camada de acesso aos dados (Repository).
- Algumas das funções da camada de serviço são:
```
Coordenação das operações: Orquestra a execução das operações de negócio, geralmente envolvendo múltiplas operações de acesso a dados.
Validação de dados: Garante a integridade dos dados. Pode incluir validações de campos obrigatórios, formatos, restrições de negócio, entre outros.
Transformação de dados: Realiza tanto a conversão dos objetos de transferência de dados (DTO) para serem processados pelas operações de negócio.E também realiza a conversão inversa.
Transações: Definir métodos transacionais usando a anotação @Transactional, garantindo que um conjunto de operações de negócio seja executado de forma atômica e consistente.
Exposição de serviços: A camada de serviço expõe uma interface para a camada de controle, definindo métodos que encapsulam as operações de negócio disponíveis para serem consumidas pelos clientes da aplicação.
```
- Sendo assim, a camada de serviço **(@Service)** é responsável por encapsular a lógica de negócios, coordenar as operações entre a camada de controle e a camada de acesso aos dados, realizar validações, transformações de dados e garantir a consistência e atomicidade das operações por meio do controle de transações.

### Etapas para criar a classe Service (@Service):
- Pacote raiz do seu projeto -> New -> Package teremos algo como [**com.utfpr.backendcategoriamusicasi.service**](src/main/java/com/utfpr/backendcategoriamusicasi/service)
- Dentro do novo pacote, vamos criar a classe [**CategoriaService**](src/main/java/com/utfpr/backendcategoriamusicasi/service/CategoriaService.java)
- Devemos inserir a anotação @Service para transformar essa classe em um bean gerenciável pelo spring
- Criamos uma variável para o repositório de categoria, do tipo **CategoriaRepository** , inserindo também a anotação @Autowired, para implementar a injeção de dependência do repository.
- Vamos implementar um método teste para testar o acesso ao repositório.
- Implementamos da mesma forma um serviço para a categoria Musica [**MusicaService**](src/main/java/com/utfpr/backendcategoriamusicasi/service/MusicaService.java)

## data.sql
- o arquivo data.sql foi inserido na pasta resources. será nossa massa de testes [data.sql](src%2Fmain%2Fresources%2Fdata.sql)
- passamos a configuração spring.jpa.defer-datasource-initialization=true no applicatio.properties [application.properties](src%2Fmain%2Fresources%2Fapplication.properties)
- ao rodar a configuração basta acessar http://localhost:8080/h2-console e logar com Username("root"); Password("senharoot");
- tive um bug e ele estava entrando com usuário default, então alterei o  applicatio.properties [application.properties](src%2Fmain%2Fresources%2Fapplication.properties) para
```properties
spring.application.name=backend-categoria-musica-si
spring.jpa.defer-datasource-initialization=true
spring.datasource.url=jdbc:h2:mem:testdb
# Enabling H2 Console
spring.datasource.driverClassName=org.h2.Driver
spring.h2.console.enabled=true
spring.datasource.username=root
spring.datasource.password=senharoot
```
 

# Apostila - Usando CommandLineRunner e Logger

- Abrir sua classe “Application.java”, normalmente essa classe tem como nome o => nome do projeto + a palavra Application.
[BackendCategoriaMusicaSiApplication.java](src%2Fmain%2Fjava%2Fcom%2Futfpr%2Fbackendcategoriamusicasi%2FBackendCategoriaMusicaSiApplication.java)
- Fazer a declaração do atributo log do tipo Logger e efetuar as importações corretamente
```java

package com.utfpr.backendcategoriamusicasi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class BackendCategoriaMusicaSiApplication {

	private static final Logger log = LoggerFactory.getLogger(BackendCategoriaMusicaSiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendCategoriaMusicaSiApplication.class, args);
	}

}

```

- incluir as categorias de serviço, criar o @bean CommandLineRunner demo(...), importar as libs do spring e implementar os métodos de services
```java
package com.utfpr.backendcategoriamusicasi;

import com.utfpr.backendcategoriamusicasi.entity.Categoria;
import com.utfpr.backendcategoriamusicasi.entity.Musica;
import com.utfpr.backendcategoriamusicasi.service.CategoriaService;
import com.utfpr.backendcategoriamusicasi.service.MusicaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BackendCategoriaMusicaSiApplication {

	private static final Logger log = LoggerFactory.getLogger(BackendCategoriaMusicaSiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendCategoriaMusicaSiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CategoriaService service, MusicaService musicaService) {
		return (args) -> {
			log.info("");
			log.info("");
			log.info("===============Listagem das músicas===============");
			for (Musica m : musicaService.listarTodasAsMusicas()) {
				log.info(m.toString());
			}
			log.info("");
			log.info("");
			log.info("===============Listagem das categorias===============");
			for (Categoria c : service.listarTodasAsCategorias()) {
				log.info(c.toString());
			}
		};
	}


}

```

- Ao rodar serão listados todos os objetos
## Segware Upvote (back-end)
Case para a Segware

### Banco de dados
- utilizado banco MySQL para persistência dos dados
- as credenciais para comunicação com o banco de dados se encontram no arquivo application.yml.
- o banco será criado e populado com três posts automaticamente (schema: upvote).
- será criado um outro banco para execução dos testes (schema: upvote_teste)

### Tecnologias utilizadas:
- Framework: SpringBoot
- Versionamento do banco de dados: Flyway
- Testes automatizados: Cucumber
- Documentação das apis: Swagger [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Testes Automatizados:
Para iniciar os testes automatizados basta executar a classe CucumberRunner
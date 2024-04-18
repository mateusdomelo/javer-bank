# Javer Bank | Bridge

Esta aplicação é responsável por ser a ponte para a segunda aplicação do sistema de cadastro de clientes do banco **Javer**.
Ela expõe endpoints REST para operações CRUD de clientes e também um endpoint para calcular o score de crédito.

## Como Executar

1. Certificar-se de ter o Java JDK 17 e o Maven instalados na máquina.
2. Clonar o repositório: `git clone https://github.com/mateusdomelo/javer-bank-bridge`
3. Acessar o diretório do projeto: `cd javer-bank-bridge`
4. Executar o projeto usando o Maven: `mvn spring-boot:run`

## Como Acessar e Testar

1. Após iniciar a aplicação, é possível acessar os endpoints REST utilizando ferramentas como cURL, Postman, Insomnia ou qualquer cliente HTTP.
2. Os endpoints estão disponíveis em `http://localhost:8080/api/clientes`.
3. Consultar a documentação da API para obter detalhes sobre os endpoints disponíveis e os payloads esperados através do endereço: `http://localhost:8080/swagger-ui/index.html`.

---
## Contatos
Em caso de dúvidas ou problemas, sinta-se à vontade para entrar em contato:

- **E-mail:** mateusdomelo@gmail.com
- **LinkedIn:** [Mateus Melo](https://www.linkedin.com/in/mateusdomelo/)